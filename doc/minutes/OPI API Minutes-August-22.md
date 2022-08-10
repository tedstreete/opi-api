# Open Programmable Infrastructure API and Behavioral Model Group

---
Minutes 8/4/2022

Agenda:

- Vendor views/proposal for interface to SDK (Intel, Marvell, NVIDIA)
  - Define the boundary on the SDK (RPC, Link Library, etc.)
- Storage - Ceph Storage on DPUs (Red Hat - IBM) - Defer to 8/18

Notes:

- Dan Daly (Intel) discussed the ipu_sdk_opi_api information that was contributed.
- Concerns were expressed that what is provided is beyond the view of the protobuf level as the bottom of the opi api.  Description outlines two possible interface points.  The view was more directed toward Networking and didn't account for other areas (Storage, Security) of API development need.

- Liel (NVIDIA) discussed the NVIDIA view of the API
- The aspects shown seemed to align with the objective of defining the Northbound interface and the protobuf interaction point.
- Request for contributing the view to the repository

- Discussed several views related to the API:
  - The view is that there are essentially three interface views that have to be considered.
    - Configuration Interface - the control plane information for setup and management of the operation, accelerator, data flows, etc.
    - Data Flow Interface - for the data traffic being passed between the host and xPU
    - Application Interface - the service chaining interface between applications/services that are resident on the xPU
  - Performance of the overall api (especially the configuration actions) needs to be included in the view

- Interfaces need to consider
  - Northbound interface - in the case of the configuration/control plane this would be the protobuf definitions
  - SDK interface (Southbound) - The interface to the SDK and how it is consumed by the API.

Actions:

- Expand the use case(s) for Networking
  - Considerations with inclusion of 1) OVS DB, 2) Openflow, 3) Openconfig, 4) P4, others.
  - Define the requirements for each use case
  - Mapping of the use case with the APIs for the consideration
  - Inclusion of application operations such as switching, firewall, etc.
  - Include the scope for ports, links, vnets, etc.
  - Use case needs to be top down as well as bottoms up.

- Agreement on the Objectives for the APIs for Networking, Storage, Security

Upcoming Topics:

- August 11
  - Storage - goals and deliverables
  - Marvell - view on API boundary (RPC, Linked Library, etc.) - if ready
  - Network - Objectives, goals, deliverables

- August 18
  - Ceph Storage on DPUs - First Agenda Item for 8/18 meeting
