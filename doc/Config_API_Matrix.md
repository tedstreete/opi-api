# Networking Configuration API Comparison Table

| Capability     | OpenConfig        | OVS DB | Cyborg | P4 | SONiC         | VPP | Relevant |
|----------------|-------------------|--------|--------|----|---------------|-----|----------|
| Inventory      | oc-platform       |        |        |    |               |     |    Y     |
| Interface      | oc-interfaces     |        |        |    | oc-interfaces |     |    Y     |
| Ethernet       |                   |        |        |    |               |     |    Y     |
| VLAN           | oc-vlan           |        |        |    |               |     |    Y     |
| 802.1x         |                   |        |        |    |               |     |          |
| IP             |                   |        |        |    |               |     |    Y     |
| IPv6           |                   |        |        |    |               |     |    Y     |
| Tunnel ipv4    |                   |        |        |    |               |     |          |
| Tunnel ipv6    |                   |        |        |    |               |     |          |
| Tunnel overlay |                   |        |        |    |               |     |          |
| GRE            |                   |        |        |    |               |     |          |
| VXLAN          |                   |        |        |    |               |     |          |
| LAG            |                   |        |        |    |               |     |          |
| QoS            |                   |        |        |    |               |     |          |
| OSPFv2         |                   |        |        |    |               |     |          |
| Routing        | oc-routing-policy |        |        |    |               |     |          |
| BGP            |                   |        |        |    |               |     |          |
| LLDP           | oc-lldp           |        |        |    |               |     |          |
| BFD            | oc-bfd            |        |        |    | oc-bfd        |     |    Y     |
| ACL            | oc-acl            |        |        |    | oc-acl        |     |    Y     |
| Forwarding     |                   |        |        |    |               |     |    Y     |
| Firewall       |                   |        |        |    |               |     |    Y     |
| IPSec          |                   |        |        |    |               |     |    Y     |

## OpenConfig

OpenConfig defines a set of models for configuration of network devices in a vendor netural way.  The data models can be used independ of the transport or RPC protocol.  Current protocols that can be used are NETCONF, RESTCONF, gRPC.

gNMI and gNOI provide a runtime configuration and monitoring interface along with a runtime operations interface respectively.  These protocols rely on gRPC as an underlying basis.

## OVS DB

OVSDB relies on the OVSDB Management Protocol (RFC7047) and specifies JSON RPC based protocol for communications between the client and server.  OVS uses the OVSDB for configuring and monitoring the open vswitch.  Per flow operation with open vswitch are handled by OpenFlow.  It utilizes a REST interface with GET, POST, PUT, DELETE

## Cyborg

Openstack Cyborg relies on REST as the control plane interface and utilizes json message format to configure the target devices.  Cyborg objective is to create a general purpose management interface framework for acceleration resources.  Currently it supports FPGAs, SPDK, GPU, Intel QAT and NIC, and NVMe SSD accelerator frameworks at the high level.

## P4

P4 interface consists of the P4 runtime, P4 Portable NIC Architecture (PNA), and P4 Portable Switch Architecture (PSA).  For the control plane interface the P4 runtime API is used to manage the data plane elements defined in the P4 program.

P4 runtime relies on gRPC as the interface and the protobufs are the table entries that define the traffic processing for the network interface.

## SONiC

SONiC utilizes the gNMI and REST for managing configuration and retrieving status on SONiC switches.  For the REST interface it leverages the POST, PUT, PATCH, DELETE, and GET operations on the supported data models.

## VPP
