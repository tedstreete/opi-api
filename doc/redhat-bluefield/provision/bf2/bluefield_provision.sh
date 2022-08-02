#!/bin/bash

function info {
	printf "=== INFO === %s\n" "$@"
}

function status {
	printf "=== STATUS === %s\n" "$@"
}

function die {
	printf "!!! FAILED !!! %s\n" "$@"
	exit 1
}

function install_deps {
	status "Installing rshim driver and tools"
	dnf install -y rshim expect wget minicom rpm-build lshw
	systemctl enable --now rshim
	systemctl status rshim --no-pager -l

	status "Installing mstflint tools"
	dnf install -y http://download.eng.bos.redhat.com/brewroot/packages/mstflint/4.15.0/1.el8/x86_64/mstflint-4.15.0-1.el8.x86_64.rpm
}

function firmware_update {
	status "Performing firmware update"
	BFB_IMAGE=DOCA_v1.2.1_BlueField_OS_Ubuntu_20.04-5.4.0-1023-bluefield-5.5-2.1.7.0-3.8.5.12027-1.signed-aarch64.bfb
	wget -c https://content.mellanox.com/BlueField/BFBs/Ubuntu20.04/$BFB_IMAGE
	status "Sending firmware to BF2. Please wait."
	cat $BFB_IMAGE > /dev/rshim0/boot
	expect -c '
		spawn minicom --baudrate 115200 --device /dev/rshim0/console
		expect {
			"localhost login:" { send "ubuntu\r"; exp_continue }
			"Password:" { send "ubuntu\r"; exp_continue }
			"Current password:" { send "ubuntu\r"; exp_continue }
			"New password:" { send "Bluefield123\r"; exp_continue }
			"Retype new password:" { send "Bluefield123\r"; exp_continue }
			"$ " { send "sudo su\r"; exp_continue }
			"# " { send "/usr/bin/bfrec\r" }
			timeout { send "\r"; exp_continue }
		}
		expect {
			"# " { send "/opt/mellanox/mlnx-fw-updater/firmware/mlxfwmanager_sriov_dis_aarch64_41686\r" }
			timeout exp_continue
		}
		expect {
			"Perform FW update?" { send "y\r"; exp_continue }
			"# " { exit }
			timeout exp_continue
		}
	'
}

function pxe_install() {
	status "Setting up PXE environment"

	RHEL_ISO="http://download.eng.bos.redhat.com/released/rhel-8/RHEL-8/8.4.0/BaseOS/aarch64/iso/RHEL-8.4.0-20210503.1-aarch64-dvd1.iso"

	wget -O "/tmp/${RHEL_ISO##*/}" -c $RHEL_ISO
        python3 ./PXE_setup.py "/tmp/${RHEL_ISO##*/}" tmfifo tmfifo RHEL8-bluefield.ks

	info "The BF2 is about to be rebooted and minicom console"
	info "started. You must manually select the PXE boot device."
	info "This can't be fully automated because the list of"
	info "options is not consistent."
	info ""
	info "ACTION: When you see the \"Boot Option Menu\" select the"
	info "option with following device path (and press enter):"
	info "MAC(001ACAFFFF01,0x1)/"
	info "IPv4(0.0.0.0)"
	info "In most cases, this is \"EFI NETWORK 4\". After that the"
	info "automation picks up again. Let it take over. The console"
	info "and reboot are slow. Have patience."
	info ""
	info "Press enter when you're ready."
	read

	status "PXE booting the BF2 and starting minicom"

	info "The RHEL install has been started. This is the end of the automation."
	info "I will reattach the minicom console to see the install progress."
	info "You can drop it anytime with key sequence: ctrl-a X"
	info ""

	minicom --color on --baudrate 115200 --device /dev/rshim0/console

#	expect -c '
#		spawn minicom --color on --baudrate 115200 --device /dev/rshim0/console
#		# Spam "ESC" until we see "Boot Manager"
#		#
#		set timeout 1
#		expect {
#			"Boot Manager" { send "OBOB"; send "\r"; }
#			timeout { send ""; exp_continue }
#		}
#		set timeout 600
#		interact {
#			\015 { send "\r"; return; }
#			* { exp_continue }
#		}
#		expect {
#			"Boot Manager" { send "OBOB"; send "\r";}
#			"Install" { send "\r"; break; }
#		}
#	'
#	reset # reset console, trashed after expect/minicom

}


function sriov_check {

	if ! rpm -qa | grep -q lshw; then
		dnf install -y lshw
	fi

	NEED_REBOOT=""
	PCI_LIST=$(lshw -class network -businfo |grep "BlueField-2" |sed 's/pci@\([^ ]\+\).*/\1/')

	for PCI in ${PCI_LIST}; do
		status "Checking usability of SRIOV for PCI ${PCI}"
		if mstconfig -d "$PCI" q | grep SRIOV_EN | grep -q "True\|1"; then
			echo "SRIOV enabled"
		else
			echo "SRIOV needs to be enabled in BIOS"
		fi

		if mstconfig -e -d "$PCI"  q | grep -i internal |  cut -d' ' -f28 | grep -q EMBEDDED_CPU\(1\); then
			echo "EMBEDDED_CPU mode enabled"
		else
			echo "SEPARATED_HOST mode enabled, cannot proceed with VF setup"
			if mstconfig -e -d "$PCI" q | grep -i internal | cut -d' ' -f29 | grep -q EMBEDDED_CPU\(1\); then
				echo "EMBEDDED_CPU mode is set to be enabled on next boot. Power cycle the system to enable it."
			else
				echo "Enabling EMBEDDED_CPU mode"
				NEED_REBOOT=yes
				mstconfig -d "$PCI" s INTERNAL_CPU_MODEL=1
				echo "EMBEDDED_CPU mode will be enabled on next boot. Power cycle the system to enable it."
			fi
		fi
	done

	test -n "${NEED_REBOOT}" && bash ./reboot_bf.sh
}

function help {
	cat << EOF
./bluefield_provision.sh [options]

Options:
  -f	Update BF2 firmware
  -s    Enable ECPF mode if not already enabled
  -p	Set up PXE boot server for provisioning BF2
  -i	Install dependencies
  -a	Run all provisioning scripts
EOF

}

while getopts "afspi" opt; do
    case $opt in
        a)
	    install_deps
	    firmware_update
	    sriov_check
	    pxe_install
            ;;

        f)
	    firmware_update
            ;;
        s)
	    sriov_check
            ;;
        p)
	    pxe_install
            ;;

        i)
	    install_deps
            ;;
        \?)
	    help
            exit 0
            ;;
    esac
done
