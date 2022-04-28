# Open Programmable Infrastructure API and Behavioral Model Group

---
Minutes 4/21/2022

Attendees:  Mark Sanders, Dan Daly, Ted Streete, Boris Glimcher, Jerin Jacob Kollanukkaran, Steven Royer, Venkatesan Mahalingam, Umesh Deshpande, Tim Michels, Shafiq Abedin, Fabrizio D’Angelo, Matthew Jean, Venkat Pullela

Agenda

- General Updates
- Discuss where we can begin to prototype a base API – Networking Support using OpenConfig?
- Discussion on Storage API

Notes:

- Define the OpenConfig areas that need to configure.
- Define a Use case that we can use for the basis to align toward.
  - Application based (OpenStack Ironic, Tinkerbell, Smart Fabric Director)

- Security Models are important across the APIs

- Storage API
  - Model Perspective
    - Host Facing Interfaces
      - How to configure Emulated Devices?  NVMe Target/VirtIO Block.
    - Networking Facing Interfaces
      - NVMe over whatever
      - Connecting to external Storage
        - IP, Port, Subsystem names, Namespaces, IPSec, TLS
    - Storage Services on DPU
      - How we interconnect the Host Facing to Network Facing Devices?
      - Bridging the virtual to the network hashing, compression, resiliency.
  - Similarity to the Kubernetes CSI model
    - CSI and Cinder as an example
    - gRPC with Protobuf, GraphQL
  - Security Checking and Services
    - Have an East-West configuration for the untrusted host and have a proxy mechanism

  - Configuration APIs vs Dataplane (Consumption) APIs
    - Dataplane APIs will have the chaining paths in the flow of traffic

  - Define the API information independent of the transport.  The transport can be SMA, gRPC, GraphQL, etc.

  - Virtual Device information of IPDK reference:  <https://ipdk.io/documentation/Interfaces/TargetAbstraction/>
  - We need to handle different device mechanisms for Networking, Storage, etc.

Actions:

- Define a Use Case that is Application Based such as OpenStack Ironic, Tinkerbell, Smart Fabric Director that we can use as a basis to begin prototyping a Network case.
- Define a Virtual Storage Device use case for the Storage API basis build an API framework. – Boris will post a PR for review and discussion.

Upcoming Meeting Topics:

- Trust Model in D/IPU and how it relates to the Root of Trust on the Host (Crosses over into Provisioning and Management possibly)
- Others
