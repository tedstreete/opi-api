# Use Cases

## Usage Deployments - Capabilities desired by end users

- Virtual Switch Offload
- Network Service Offload
- NVMeoF
- Storage Offload
- Firewall/Distributed Firewall
- ...

## Phases of Operation - API considerations

- Pre-provisioning
- Day 0 (Initial Startup)
  - Discovery
  - Initial Provisioning
- Day N
  - Re-provisioning
  - Firmware Update
  - OS Update

## Interfaces

- Configuration Interface
  - Network facing (Ethernet inband or out-of-band)
  - Host facing (Network port over PCIe)
- Consumption Interface
  - Virtual Function
    - Network VF Interface
    - Virtual Storage (VF Interface)

## Building Blocks

- gRPC
- VF/PF
- Access Security

## UseCases

### Network Services Offload

The Network Services Offload use case will build a foundation for the examples that can be put together for the OPI.  The basic topology is shown in the diagram.  It consists of two servers, with D/IPUs that are connected through a network switch.

![Network Services Offload Use Case](doc/minutes/images/API-Use-Case-1.png)

The network switch provides a mechanism to provide any debugging and analysis of the traffic on the network connection.  Each server contains a DPU with its network interface.

Subsequent use cases can be built upon the network services offload.


### Storage Services Offload

The The basic topology is shown in the diagram.
It consists of SAN/NAS (Network Attached Storage) Array/Applience/Controllers or JBOF/EBOF and a Initiator server, with D/IPUs that are connected through a network switch.

![Storage Services Offload Use Case](doc/minutes/images/API-Storage-Use-Case.png)

