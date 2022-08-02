#!/bin/env python3
'''
MIT License

Copyright (c) 2022 Fabrizio D'Angelo

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
'''

# some steps based on:
# https://access.redhat.com/documentation/en-us/red_hat_enterprise_linux/8/html-single/performing_an_advanced_rhel_installation/index/#preparing-for-a-network-install_installing-rhel-as-an-experienced-user

import argparse
import os, sys
import subprocess
from pathlib import Path
from time import sleep

if os.geteuid() != 0:
    print("This script must be run as root.")
    sys.exit(-1)

SUBNET = "172.31.100"
REPO_IP = SUBNET + ".1"
PROTOCOL = "ETH"

example = """examples:
python3 ./PXE_setup.py /tmp/RHEL-8.4.0-aarch64-dvd1.iso eno1 ETH RHEL8-bluefield.ks
python3 ./PXE_setup.py "/tmp/${RHEL_ISO##*/}" tmfifo tmfifo RHEL8-bluefield.ks
"""
parser = argparse.ArgumentParser(description='BF2 PXE setup tool',
                                 epilog=example,
                                 formatter_class=argparse.RawDescriptionHelpFormatter)
parser.add_argument('rhel_iso', help = "The .iso installation file")
parser.add_argument('netdev', help = "MLX Netdev to use")
parser.add_argument('protocol', help = "Protocol to PXE boot from",
                    choices = ['ETH', 'IB', 'tmfifo'])
parser.add_argument('ks_path', help = "Enable kickstart auto installation")
parser.add_argument('--ipmi', help="BMC IPMI address")
parser.add_argument('--ipmi_user', help="BMC IPMI username")
parser.add_argument('--ipmi_pass', help="BMC IPMI password")

args = parser.parse_args()

NETDEV = None
TFTP_PATH=Path('/var/lib/tftpboot')

PROTOCOL = args.protocol

try:
    DISTRO_ISO = Path(args.rhel_iso).resolve(strict=True)
except:
    print("ISO file does not exist.")
    sys.exit(-1)

DISTRO_VER = DISTRO_ISO.name.split('-dvd1.iso')[0]

if args.ks_path:
    try:
        KS_FILE = Path(args.ks_path).resolve(strict=True)
    except:
        print("Kickstart file does not exist.")
        sys.exit(-1)
    ENABLE_KS = True


# PXE mount path (temporary).
PXE_MOUNT = Path(f'/var/ftp/{DISTRO_VER}')

# Kickstart config path.
BF_KS_PATH = Path(f'/var/ftp/ks_{DISTRO_VER}')

if args.ipmi:
    subprocess.call(['dnf', 'install', '-y', 'ipmitool'])
    if subprocess.call(['ping', '-c', '1', args.ipmi], stdout=subprocess.DEVNULL) != 0:
        print(f"Failed to ping ipmi address: {args.ipmi}.")
        print("If ICMP packets are dropped, interrupt the script and double check host can be reached manually.")
        print("Continuing in 5 seconds...")
        sleep(5)


def setup_tmfifo():

    subprocess.run(['yum', 'install', 'rshim', '-y'])
    subprocess.run(['systemctl', 'enable', 'rshim', '--now'])

    for cmd in [
        ['nmcli', 'conn', 'delete', NETDEV],
        ['rm', f'/etc/sysconfig/network-scripts/ifcfg-{NETDEV}'],
        ['nmcli','conn','add','type','tun','mode','tap', f'con-name', NETDEV,
            'ifname', NETDEV, 'autoconnect', 'yes', 'ip4', REPO_IP],
        ['nmcli', 'conn', 'modify', 'tmfifo_net0', 'ipv4.routes', f'{SUBNET}.0/24'],
        ['systemctl', 'restart', 'NetworkManager'],
        ['nmcli', 'conn', 'up', NETDEV]]:
        subprocess.run(cmd)

    # Create rshim udev rules.
    print("Creating rshim tmfifo_net0 udev rules...")
    with open('/etc/udev/rules.d/91-tmfifo_net.rules', 'w') as tmfifo_rules:
        tmfifo_rules.write(f'SUBSYSTEM=="net", ACTION=="add", ATTR{{address}}=="00:1a:ca:ff:ff:02", ATTR{{type}}=="1", NAME="{NETDEV} RUN+="/usr/bin/nmcli conn up {NETDEV}"')

def reset_bluefield():
    with open('/dev/rshim0/misc', 'w') as rshim:
        rshim.write('SW_RESET 1')
    if b'activated' not in subprocess.check_output(['nmcli', '-f', 'GENERAL.STATE', 'con', 'show', 'tmfifo_net0']):
        sleep(5)
    if b'successfully' not in subprocess.check_output(['nmcli', 'c', 'up','tmfifo_net0']):
        print('Failed to restart tmfifo_net0 network. Possible BF2 specific failure')

def reset_ipmi():
    subprocess.call(['ipmitool', '-I', 'lanplus',
                    '-H', args.ipmi, '-U', args.ipmi_user,
                    '-P', args.ipmi_pass, 'chassis', 'power cycle'])

"""
Setup TFTP.
TFTP server provides the initial images (kernel & initrd) for pxeboot.
"""
def tftp_configuration():
    print("Setup tftp service...")
    subprocess.run(['yum', '-y', 'install', 'httpd', 'vsftpd', 'tftp-server', 'dhcp-server'])
    subprocess.run(['sed', '-i', '-e', 's/anonymous_enable=NO/anonymous_enable=YES/',
                    '-e', 's/write_enable=YES/write_enable=NO/', '/etc/vsftpd/vsftpd.conf'])
    with open('/etc/vsftpd/vsftpd.conf', 'a+') as vsftpd:
        vsftpd.write("""
pasv_min_port=10021
pasv_max_port=10031""")

    if not Path(TFTP_PATH).exists():
        print("tftp path not found")
        sys.exit(-1)

    # Copy over the tftp files.
    print("Generating TFTP images...")
    for cmd in [
           ['rm', '-rf', f'{TFTP_PATH}/pxelinux/'],
           ['mkdir', '-p', f'{TFTP_PATH}/pxelinux/pxelinux.cfg'],
           ['mkdir', '-p', f'{TFTP_PATH}/pxelinux/images/{DISTRO_VER}'],
           ['cp', '-fv', f'{PXE_MOUNT}/EFI/BOOT/BOOTAA64.EFI', TFTP_PATH],
           ['cp', '-fv', f'{PXE_MOUNT}/EFI/BOOT/grubaa64.efi', TFTP_PATH],
           ['cp', '-fv', f'{PXE_MOUNT}/EFI/BOOT/mmaa64.efi', TFTP_PATH],
           ['cp', '-fv', f'{PXE_MOUNT}/images/pxeboot/vmlinuz', f'{TFTP_PATH}/pxelinux/images/{DISTRO_VER}/'],
           ['cp', '-fv', f'{PXE_MOUNT}/images/pxeboot/initrd.img', f'{TFTP_PATH}/pxelinux/images/{DISTRO_VER}/']]:
        subprocess.run(cmd)

    # get pxelinux.0
    if "x86_64" in DISTRO_VER:
        for cmd in [
                    ['rm', '-rf', '/tmp/pxetmp'],
                    ['mkdir', '/tmp/pxetmp'],
                    ['cd', '/tmp/pxetmp']]:
            subprocess.run([cmd])
        syslinux_rpm = next(PXE_MOUNT.rglob('syslinux-tftpboot-[0-9]'), None)
        if not syslinux_rpm:
            print("cannot find syslinux RPM in the installation ISO media!")
            sys.exit(1)
        rpm2cpio = subprocess.Popen(f'rpm2cpio {syslinux_rpm}', stdout=subprocess.PIPE)
        cpio = subprocess.run(['cpio -id'], stdin=rpm2cpio.stdout)
        subprocess.run(['cp', '-fv', '/tmp/pxetmp/tftpboot/*', f'{TFTP_PATH}/pxelinux/'])
        subprocess.run(['rm', '-rf', '/tmp/pxetmp'])

    subprocess.run(['chmod', '-R', '+r', TFTP_PATH])


# Generate the grub.cfg.
def grub_configuration():
    print("Generate the grub.cfg...")
    grub_opts = f"inst.repo=http://{REPO_IP}/{DISTRO_VER}/ console=tty0 console=tty1 console=ttyS0,115200 console=ttyS1,115200"
    if ENABLE_KS:
        grub_opts += f" inst.ks=http://{REPO_IP}/ks_{DISTRO_VER}/kickstart.ks"
    if PROTOCOL == "ETH":
        grub_opts += " ip=dhcp console=ttyAMA1 console=hvc0 console=ttyAMA0 earlycon=pl011,0x01000000"
    elif PROTOCOL == "IB":
        grub_opts += f" bootdev={NETDEV} ksdevice={NETDEV} net.ifnames=0 biosdevname=0 rd.neednet=1 rd.boofif=0 rd.driver.pre=mlx5_ib,mlx4_ib,ib_ipoib ip={NETDEV}:dhcp rd.net.dhcp.retry=10 rd.net.timeout.iflink=60 rd.net.timeout.ifup=80 rd.net.timeout.carrier=80"
    elif PROTOCOL == "tmfifo":
        grub_opts += " ip=dhcp ip=dhcp console=ttyAMA1 console=hvc0 console=ttyAMA0 earlycon=pl011,0x01000000"

    if "x86_64" in DISTRO_VER:
        with open(f'{TFTP_PATH}/pxelinux/boot.msg') as boot:
            booth.write(f"""
!!!!!!!!!!!! PXE INSTALL TEST !!!!!!!!!!!!!!!

Select one:

  1 - Install Red Hat Enterprise Linux
  2 - Start installer but Break to shell
  3 - Reboot
""")
        with open(f'{TFTP_PATH}/pxelinux/pxelinux.cfg/default') as pxelinux_cfg_default:
            pxelinux_cfg_default.write(f"""
default vesamenu.c32
prompt 1
timeout 600

display boot.msg

label 1
  menu label ^Install {DISTRO_VER}
  menu default
  kernel images/{DISTRO_VER}/vmlinuz
  append initrd=images/{DISTRO_VER}/initrd.img showopts {grub_opts}

label 2
  menu label ^Start installer {DISTRO_VER} but break to shell
  kernel images/{DISTRO_VER}/vmlinuz
  append initrd=images/{DISTRO_VER}/initrd.img showopts {grub_opts} rd.break=initqueue rd.shell

label 3
  menu label Boot from ^Reboot
  reboot
""")
    elif "aarch64" in DISTRO_VER:
        with open(f'{TFTP_PATH}/grub.cfg', 'w') as grub_config:
            grub_config.write(f"""
# {DISTRO_ISO} {REPO_IP}
menuentry 'Install {DISTRO_VER}' --class red --class gnu-linux --class gnu --class os {{
    linux pxelinux/images/{DISTRO_VER}/vmlinuz showopts {grub_opts}
    initrd pxelinux/images/{DISTRO_VER}/initrd.img
}}

menuentry 'Start installer {DISTRO_VER} but break to shell' --class red --class gnu-linux --class gnu --class os {{
    linux images/{DISTRO_VER}/vmlinuz {grub_opts}
    initrd images/{DISTRO_VER}/initrd.img showopts {grub_opts} rd.break=initqueue rd.shell
}}

menuentry 'Reboot' --class red --class gnu-linux --class gnu --class os {{
    reboot
}}
""")
    else:
        print("-E- MISSING BOOT SETTINGS!!!")


"""
Setup DHCP.
DHCP-SERVER assigns IP address to the target, and specify the boot image.
"""
def dhcp_configuration():
    print("Setup dhcp service...")
    if Path("/etc/dhcp/dhcpd.conf").exists():
        subprocess.run(["cp", "/etc/dhcp/dhcpd.conf", "/etc/dhcp/dhcpd.conf.bak"])

    nameservers = []
    domain_names = []
    with open('/etc/resolv.conf', 'r') as f:
        for line in f.read().splitlines():
            if line:
                if line[0] == '#':
                    continue
                if 'nameserver' in line:
                    nameservers.append(line.split('nameserver')[1].strip())
                if 'search' in line:
                    domain_names = line.strip().split(' ')[1:]
    domain_names = ','.join(f'"{domain}"' for domain in domain_names)
    NAME_SERVERS_STR = f"option domain-name-servers {','.join(nameservers)};"
    DOMAIN_NAMES_STR = f"option domain-search {domain_names};"

    if 'x86_64' in DISTRO_VER:
        filesettings="""
if option architecture-type = 00:07 {
    filename "BOOTX64.efi";
} else {
    filename "pxelinux/pxelinux.0";
}
"""
    elif 'aarch64' in DISTRO_VER:
        filesettings='filename "/BOOTAA64.EFI";'
    else:
        print("-E- MISSING BOOT SETTINGS!!!")

    with open('/etc/dhcp/dhcpd.conf', 'w') as dhcp_config:
        dhcp_config.write(f"""option space pxelinux;
option pxelinux.magic code 208 = string;
option pxelinux.configfile code 209 = text;
option pxelinux.pathprefix code 210 = text;
option pxelinux.reboottime code 211 = unsigned integer 32;
option architecture-type code 93 = unsigned integer 16;
allow booting;
allow bootp;


next-server {REPO_IP};
always-broadcast on;

{filesettings}

subnet {SUBNET}.0 netmask 255.255.255.0 {{
    range {SUBNET}.10 {SUBNET}.20;
    option broadcast-address {SUBNET}.255;
    option routers {REPO_IP};
    {NAME_SERVERS_STR}
    {DOMAIN_NAMES_STR}
    option dhcp-client-identifier = option dhcp-client-identifier;
}}
""")

    # Restart DHCP automatically (if dhcpd is running) when board reboots.
    with open('/etc/NetworkManager/dispatcher.d/bluefield.sh', 'w') as bf2_ifup:
        bf2_ifup.write(f"""#!/usr/bin/env bash
interface=$1
event=$2

if [[ $interface != "{NETDEV}" ]] || [[ $event != "up" ]]
then
  return 0
fi

systemctl restart dhcpd
""")
    subprocess.run(['chmod', '+x', '/etc/NetworkManager/dispatcher.d/bluefield.sh'])

"""
Setup HTTP.
The installer will fetch packages from the http server.
"""
def http_configuration():
    print("Setup http service...")

    if ENABLE_KS:
        Path(BF_KS_PATH).mkdir(parents=True, exist_ok=True)
        subprocess.run(['cp', '-fv', KS_FILE, f'{BF_KS_PATH}/kickstart.ks'])
        subprocess.run(['sed', '-i', f's@REPO_URL@http://{REPO_IP}/{DISTRO_VER}@', f'{BF_KS_PATH}/kickstart.ks'])

    HTTP_PERMISSION=f"Require ip 127.0.0.1 {SUBNET}.0/24"

    with open(f'/etc/httpd/conf.d/pxeboot_{DISTRO_VER}.conf', 'w') as httpd_pxe_config:
        httpd_pxe_config.write(f"""
Alias /{DISTRO_VER} {PXE_MOUNT}
<Directory {PXE_MOUNT}>
    Options Indexes FollowSymLinks
    {HTTP_PERMISSION}
</Directory>

Alias /ks_{DISTRO_VER} {BF_KS_PATH}
<Directory {BF_KS_PATH}>
    Options Indexes FollowSymLinks
    {HTTP_PERMISSION}
</Directory>
""")

    if subprocess.check_output(["sestatus"]).splitlines()[4].split()[2] != b"permissive":
        print("""Warning: selinux seems enabled which might affect the installation.
It may block HTTP access and affect RHEL installation.
Disable it temporarily with command 'setenforce 0' if you're not sure.""")

if __name__ == '__main__':

    if args.netdev == 'tmfifo':
        NETDEV = 'tmfifo_net0'
        setup_tmfifo()
    elif args.netdev == 'IB':
        print(f"########### MAKE SURE OpenSM is running on {NETDEV} #############")
    elif Path(f'/sys/class/net/{args.netdev}').exists():
        NETDEV = args.netdev
    else:
        print(f'NETDEV: {NETDEV} does not seem to exist. Please check your network configuration.')
        sys.exit(-1)

    # Mount the .iso file. Retry it 3 times.
    print(f"Mounting the .iso file to {PXE_MOUNT}...")
    subprocess.run(['umount', PXE_MOUNT])
    subprocess.run(['mkdir', '-p', PXE_MOUNT,])
    mount_args = ['mount', '-t', 'iso9660', '-o', 'loop', DISTRO_ISO, PXE_MOUNT]
    for i in range(3):
        subprocess.run(mount_args)
        if Path(f'{PXE_MOUNT}/EFI').exists():
            break
        sleep(1)
    if not Path(f'{PXE_MOUNT}/EFI').exists():
        print(f"Unable to mount {DISTRO_ISO}.")
        sys.exit(-1)

    try:
        uplink_interface = subprocess.check_output(['ip', '-o', '-4', 'route', 'show', 'to', 'default']).decode().split()[4]
        with open(f'/sys/class/net/{uplink_interface}/operstate') as uplink:
            if uplink.read().strip() != 'up':
                raise ValueError(f"{uplink_interface} not up.")
        subprocess.run(['iptables', '-t', 'nat', '-F'])
        subprocess.run(['iptables', '-t', 'nat', '-A', 'POSTROUTING', '-o', uplink_interface, '-j', 'MASQUERADE'])
    except Exception as e:
        print('Valid uplink not found. May encounter issues installing additional packages.')

    if NETDEV != 'tmfifo_net0':
        try:
            subprocess.run(['ip', 'a', 'add', f'{REPO_IP}/24', 'dev', NETDEV])
            with open('/proc/sys/net/ipv4/ip_forward', 'w') as ip_forward:
                ip_forward.write('1')
        except Exception as e:
            print(f'Failed to configure networking for {NETDEV}: {e}')
            print('BF2 will not have internet access unless configured manually.')

    tftp_configuration()
    grub_configuration()
    dhcp_configuration()
    http_configuration()

    for cmd in [
       ['systemctl', 'enable', 'vsftpd'],
       ['systemctl', 'restart', 'vsftpd.service'],

       ['systemctl', 'enable', 'dhcpd'],
       ['systemctl', 'restart', 'dhcpd'],

       ['systemctl', 'enable', 'tftp.socket'],
       ['systemctl', 'restart', 'tftp.socket'],

       ['systemctl', 'enable', 'httpd'],
       ['systemctl', 'restart', 'httpd']]:
        subprocess.run(cmd)

    print("\nDone.")
    print("Next step: PXE boot from target (make sure to select the correct port!)")

    if NETDEV == 'tmfifo_net0':
        reset_bluefield()
    elif args.ipmi:
        reset_ipmi()

