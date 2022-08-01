# Comparing OPI APIs to IPU SDK

The IPU SDK adheres to the [Target Abstraction Interface](https://ipdk.io/documentation/Interfaces/TargetAbstraction/) from [IPDK](https://ipdk.io).

At a high level the TAI is well aligned with the direction the OPI APIs are going.  Where there is good alignment with the SDK shim aspects of the OPI APIs:

- API for all SDKs: Goal to have an API abstraction that multiple devices from multiple vendors can support.  Ideally this is a standard that we can all align to.
- Capabilities Based: Ability to determine the suitability of a target based on the application's requirements.
- Domain Specific: There can be different target abstraction interfaces for different domains.  This is aligned with how OPI APIs are split into networking, storage, etc.
- Separated Services: There are different services above the TAI converting from the high level objects coming over the network into the TAI interface.  This looks aligned to [the API conglomerate diagram](https://github.com/opiproject/opi-api/blob/main/doc/images/API-Detailed-Abstraction-Layer-Local.png) from OPI.
- Separation Betweeen RPC-based NB API & Target Abstraction Layers:  The top end of IPDK enables a set of gRPC-based interfaces as part of the [Infrastructure Application Interface](https://ipdk.io/documentation/Interfaces/InfraApp/).  This sets the boundary conditions of what code goes inside IPDK- it is a set of control plane frameworks that are converting from the Infrastructure Application Interface into TAI.
- Target Abstraction Layer Alignment:  The TAI uses both SAI and TDI for networking and this is aligned to the slide.

Where there is possible divergence between TAI and the OPI APIs are:

- Driver & Library Basis: The TAI is based on running a shared library that links with an application to control the underlying devices. If the OPI Target Abstraction Layer is defined in a different manner (for example a protobuf) then some translation will be required.  For dataplane functions, including trapping exception packets or sending out control plane messages, the TAI relies on drivers, including when data is moved to/from attached hosts (similar to the backend of vhost).
- API Definition: Since the TAI is a library interface, different library-based APIs are represented in C header files (for example SAI and TDI look the same here).  There are translation layers where there is overlap, for example pragmas used from the [PINS project](https://opennetworking.org/pins/) to map from SAI to TDI.  It would be good to define that the OPI API Target Abstraction Layers as header files (even if they are ultimately derived from protobuf representations).
- Application vs. Target Separation: The OPI APIs do not have an explicit delineation between what is a Target API vs. an Application API.  There is a concept of NB APIs and Target Interfaces in the API conglomerate diagram but this doesn't match well with the protobuf definitions which mix the two together.

Separate from the IPU SDK, IPDK defines the Infrastructure Application Interface which closely corresponds to the NB API. Where there is possible divergence between InfraApp and the OPI NB APIs are:

- Northbound API Definition: IPDK's InfraApp is not instantiating new protobufs, instead it is using pre-defined protobufs to transfer different objects between Infrastructure Applications attaching to IPDK. There is good alignment on the set of protocols called out on the slide today (OPenConfig, CSI, SMA). The missing interfaces (currently) are:
  - P4Runtime
  - Redfish / REST API
  - Managed Kubernetes
  - Envoy xDS
- Northbound API Proxy: The current conglomerate diagram has an API load balancer and fan out functions.  These are not likely to be needed as the calling applications should be abe to discover the gRPCs supported on the infrastructure device platform.  They also get in the way of the mutual TLS security between the device platform and the remote application.  It is also possible that a local application would be connecting to the Northbound OPI APIs, in which case that local application should talk directly to the domain specific services and not have to go through an API load balancer.

## Networking Comparison

The IPU SDK supports the [TDI](https://github.com/p4lang/tdi/blob/main/README.md) API.  SAI is also supported and is converted to TDI via pragmas such that there is effectively only one codepath into the devices for networking.

The way TDI is used is that the devices instantiate a set of tables that can be used for programming.  Some tables are derived directly from the application's requirements (for example P4 programs or OpenConfig required objects).  Other tables are derived from the devices (for example direct register access, if it is supported).

The set of tables defined for networking are:

- Programmable P4 Tables:  Derived from the application's requirements.
- Link Management: Derived from the OpenConfig for link management
- Virtual Device Management:  Derived from the OpenConfig for Virtual Devices
- QoS Management:  Derived from the OpenConfig for Hierarchical QoS
- IPsec Management:  Derived from the OpenConfig for programming security associations from strongSwan

The local networking interface on the IPU compute complex has additional logic to split trap packets between control plane packets to the kernel and exception packets that are processed in userspace.  Packets from the IPU can be sent and received to/from the host by using netdevs specific to the virtual devices that have been instantiated.  Userspace applications can similarly send traffic to/from the host by using inline tags to differentiate traffic coming and going from different destinations (Virtual Devices to the host, Physical Devices to the Network).

## Storage Comparison

The IPU SDK uses TDI for storage in a similar fashion as networking.

The set of tables defined for storage are:

- Virtual Device Management:  Derived from the OpenConfig for link management

The IPU SDK enables movement of traffic to/from the host over virtual devices (virtio-blk disks, or NVMe controllers).  On the IPU compute complex there is an 'inverse device' which looks like a work queue.  On transmit the new completions can be scheduled to be sent to the host.  On receive new storage requests from the virtual devices are held for the IPU compute complex to process.

This is a sub-set of scope being set up in the OPI APIs, as any of the NVMe-over-* configuration and setup would reside in the IPU compute complex and would not be pushed through into the IPU SDK.

## Security Comparison

The IPU SDK uses TDI for IPsec in a similar fashion as networking.

The set of tables defined for IPsec are:

- IPsec Management:  Derived from the OpenConfig for programming security associations from strongSwan

IPsec is enabled in the pipeline using P4.  The P4 program determines what modes of IPsec are enabled.  The parameters for each security association (SA) referred to in the P4 is set via OpenConfig.  The OpenConfig for these security association is translated into a set of TDI tables organized by SA index.
