# Use Cases

## Usage Deployments - Capabilities desired by end users

- Virtual Switch Offload
- Network Service Offload
- NVMeoF
- Storage Offload/Services
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
  - Retirement

## Interfaces

- Configuration Interface
  - Network facing (Ethernet inband or out-of-band)
  - Host facing (Network port over PCIe)
  - BMC facing (for systems with integrated BMCs)
- Consumption Interface
  - Virtual Function
    - Network VF Interface
    - Virtual Storage (VF Interface)

What would the AI/ML consumption interface look like?
What are the Security implications on consumption interfaces?
What are the Security API boundary implications to create the air gap?

## Building Blocks

- gRPC
- VF/PF
- Access Security

## Use Case Examples

### Network Services Offload

The Network Services Offload use case will build a foundation for the examples that can be put together for the OPI.  The basic topology is shown in the diagram.  It consists of two servers, with D/IPUs that are connected through a network switch.

![Network Services Offload Use Case](doc/minutes/images/API-Use-Case-1.png)

The network switch provides a mechanism to provide any debugging and analysis of the traffic on the network connection.  Each server contains a DPU with its network interface.

Subsequent use cases can be built upon the network services offload.

### Storage Services Offload

The The basic topology is shown in the diagram.
It consists of SAN/NAS (Network Attached Storage) Array/Applience/Controllers or JBOF/EBOF and a Initiator server, with D/IPUs that are connected through a network switch.

![Storage Services Offload Use Case](doc/minutes/images/API-Storage-Use-Case.png)
