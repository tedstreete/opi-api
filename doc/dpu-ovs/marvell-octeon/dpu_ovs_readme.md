# DPU OVS on Marvell OCTEON

Demo for running some traffic between containers on DPU and host
Use dpdk-testpmd as internal Packet Generating Source
Use udp destination port for OVS forwarding rules
BDFs should be modified according to setup
Assumptions: All drivers installed and loaded on host and dpu
and Octeon is setup as a DPU (PCIE-EP)

## On Host

### Bind Octeon host VFs to dpdk

```text
dpdk-devbind.py -b vfio-pci 04:02.0  
dpdk-devbind.py -b vfio-pci 04:02.1  
```

## On Target

### Bind devices to dpdk (PF, VFs, LBKs, SDP VFs)

```text
echo "Mounting Huge Pages"
echo 12 > /sys/kernel/mm/hugepages/hugepages-524288kB/nr_hugepages
mkdir -p /dev/huge
mount -t hugetlbfs -o size=4G nodev /dev/huge

echo "Binding PF and enabling sriov"
dpdk-devbind.py -u 0002:05:00.0 && dpdk-devbind.py -b vfio-pci 0002:05:00.0
echo 8 > /sys/bus/pci/devices/0002\:05\:00.0/sriov_numvfs

echo "Bind VFs"
dpdk-devbind.py -u 0002:05:00.1 && dpdk-devbind.py -b vfio-pci 0002:05:00.1
dpdk-devbind.py -u 0002:05:00.2 && dpdk-devbind.py -b vfio-pci 0002:05:00.2
dpdk-devbind.py -u 0002:05:00.3 && dpdk-devbind.py -b vfio-pci 0002:05:00.3
dpdk-devbind.py -u 0002:05:00.4 && dpdk-devbind.py -b vfio-pci 0002:05:00.4

echo "Bind SDP VFs"
dpdk-devbind.py -u 0002:0f:00.2 && dpdk-devbind.py -b vfio-pci 0002:0f:00.2
dpdk-devbind.py -u 0002:0f:00.3 && dpdk-devbind.py -b vfio-pci 0002:0f:00.3

echo "Bind Loopback devices"
dpdk-devbind.py -u 0002:01:00.1 && dpdk-devbind.py -b vfio-pci 0002:01:00.1
dpdk-devbind.py -u 0002:01:00.2 && dpdk-devbind.py -b vfio-pci 0002:01:00.2
```

## Setting up the ovs environment on TARGET

**We use 4 representors.**

- Representor 0,1 refer to Target NIX Vfs.
- Representor 2,3 refer to NIX Vfs which will be forwarded to SDP Vfs and
    connected to host VFs

### Configure OVS

#### Folder creation (first time only)

```text
mkdir -p /usr/local/etc/openvswitch
mkdir -p /usr/local/var/run/openvswitch
mkdir -p /usr/local/var/log/openvswitch
```

#### Remove previous configuration and log

```text
rm /usr/local/etc/openvswitch/conf.db
rm /usr/local/var/log/openvswitch/ovs-vsctl.log
```

#### PATH update

```text
export PATH=$PATH:/usr/local/share/openvswitch/scripts:/usr/local/bin:/usr/local/sbin
```

#### ovs setup configuration

 ```text
 export PATH=$PATH:/usr/local/share/openvswitch/scripts:/usr/local/bin:/usr/local/sbin\
/sbin/modprobe openvswitch\
ovsdb-tool create /usr/local/etc/openvswitch/conf.db /usr/local/share/openvswitch/vswitch.ovsschema\
ovsdb-server --remote=punix:/usr/local/var/run/openvswitch/db.sock --remote=db:Open_vSwitch,Open_vSwitch,manager_options --pidfile --detach\
ovs-ctl start --db-sock=/usr/local/var/run/openvswitch/db.sock --db-file=/usr/local/etc/openvswitch/conf.db  --db-schema=/usr/local/var/run/openvswitch/db.sock --no-ovs-vswitchd\
ovs-vsctl --no-wait init -- set Open_vSwitch . other_config:hw-offload=true other_config:dpdk-init=true\
ovs-vsctl --no-wait set Open_vSwitch . other_config:dpdk-extra="--vfio-vf-token="9d75f7af-606e-47ff-8ae4-f459fce4a422" --pci-whitelist="0002:05:00.0,vf_rep_lbk_vf=0002:01:00.1,vf_rep_rx_lbk_vf=0002:01:00.2""\
ovs-vswitchd unix:/usr/local/var/run/openvswitch/db.sock --pidfile --detach --log-file=/usr/local/var/log/openvswitch/ovs-vsctl.log
```

### Setting up the following 3 flows

1. VF Host -> VF Host
2. VF Target -> VF Target
3. VF Host -> VF Target

On host BDF: 04:02.0\
On Target BDF: 0002:05:00.1

#### Connect all 4 representors (2 for Target VFs, 2 for Host VFs)

```text
ovs-vsctl add-br br0 -- set bridge br0 datapath_type=netdev\
ovs-vsctl add-port br0 pf -- set Interface pf type=dpdk options:dpdk-devargs="0002:05:00.0"\
ovs-vsctl add-port br0 vf_rep0 -- set Interface vf_rep0 type=dpdk options:dpdk-devargs="0002:05:00.0,representor=[0]"\
ovs-vsctl add-port br0 vf_rep1 -- set Interface vf_rep1 type=dpdk options:dpdk-devargs="0002:05:00.0,representor=[1]"\
ovs-vsctl add-port br0 vf_rep2 -- set Interface vf_rep2 type=dpdk options:dpdk-devargs="0002:05:00.0,representor=[2]"\
ovs-vsctl add-port br0 vf_rep3 -- set Interface vf_rep3 type=dpdk options:dpdk-devargs="0002:05:00.0,representor=[3]"

ovs-vsctl show\
ip link set br0 up
```

#### On Target: Setup the following unique flows based on udp destination

##### Usecase I:   Host   VF -> Host   VF

```text
ovs-ofctl add-flow br0 in_port=vf_rep2,udp,tp_dst=200,idle_timeout=0,actions=output:vf_rep3\
ovs-ofctl add-flow br0 in_port=vf_rep3,udp,tp_dst=300,idle_timeout=0,actions=output:vf_rep2
```

##### Usecase II:  Target VF -> Target VF

```text
ovs-ofctl add-flow br0 in_port=vf_rep0,udp,tp_dst=500,idle_timeout=0,actions=output:vf_rep1\
ovs-ofctl add-flow br0 in_port=vf_rep1,udp,tp_dst=400,idle_timeout=0,actions=output:vf_rep0
```

##### Usecase III: Target VF -> Host   VF

```text
ovs-ofctl add-flow br0 in_port=vf_rep0,udp,tp_dst=600,idle_timeout=0,actions=output:vf_rep2\
ovs-ofctl add-flow br0 in_port=vf_rep2,udp,tp_dst=700,idle_timeout=0,actions=output:vf_rep0
```

#### Usecase I: Run app per VF on Host [Container if desired so - same command] (traffic generated from testpmd)

##### VF1 (Tx Only)

```text
dpdk-testpmd --proc-type=auto --file-prefix=pci0 -w 04:02.0,sdp_packet_mode=loop -c 0xc -- --coremask 0x8 --portmask=0xf --rxq=1 --txq=1  --rxd=2048 --txd=2048 --nb-cores=1 -i --tx-udp=300,200 --forward-mode=txonly --max-pkt-len=9600 --mbuf-size=9600 --total-num-mbufs=70000

testpmd> start tx_first 100
```

#### VF2 (Rx Only)

```text
dpdk-testpmd --proc-type=auto --file-prefix=pci1 -w 04:02.1,sdp_packet_mode=loop -c 0x3 -- --coremask 0x2 --portmask=0xf --rxq=1 --txq=1  --rxd=2048 --txd=2048 --nb-cores=1 -i -a --tx-udp=200,300 --forward-mode=rxonly --max-pkt-len=9600 --mbuf-size=9600 --total-num-mbufs=70000
```

#### Usecase II: Run app per VF on Target (traffic generated from testpmd)

##### VF1

```text
dpdk-testpmd --vfio-vf-token="9d75f7af-606e-47ff-8ae4-f459fce4a422" -c 0xffffff -w 0002:05:00.1 --file-prefix=vf1 -- -i --coremask=0xff00 --portmask=0xf --rxd=2048 --txd=2048 --max-pkt-len=9200 --mbuf-size=9200 --total-num-mbufs=50000 --tx-udp=400,500 --forward-mode=txonly
testpmd> start tx_first 100
```

##### VF2

```text
dpdk-testpmd --vfio-vf-token="9d75f7af-606e-47ff-8ae4-f459fce4a422" -c 0xffffff -w 0002:05:00.2 --file-prefix=vf2 -- -i --coremask=0xff0000  --portmask=0xf --rxd=2048 --txd=2048 -a --max-pkt-len=9200 --mbuf-size=9200 --total-num-mbufs=50000 --tx-udp=500,400 --forward-mode=rxonly
```

#### Usecase III: Run one app on Target and one on host (traffic generated from testpmd)

##### VF1 On HOST

Refer to "Usecase I: VF1 (Tx Only)" but set "--tx-udp=700,600" in dpdk-testpmd command

```text
testpmd> start tx_first 100
```

##### VF1 On Target

```text
dpdk-testpmd --vfio-vf-token="9d75f7af-606e-47ff-8ae4-f459fce4a422" -c 0xf00 -w 0002:05:00.1 --file-prefix=vf1 -- -i --coremask=0x200 --portmask=0xf --rxd=2048 --txd=2048 -a --max-pkt-len=9200 --mbuf-size=9200 --total-num-mbufs=70000 --tx-udp=600,700 --forward-mode=rxonly
```
