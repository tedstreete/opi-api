# Open Programmable Infrastructure API and Behavioral Model Group

---
Minutes 5/12/2022

Attendees: Mark Sanders, Boris Glimcher, Shachar Tal, Ted Streete, Satananda Burla. Burugula, Dan Daly, fnordahl, Gokul Kandiraju, Jerin Jacob Kollanukkaran, Patty Driever, Raja Kommula, Shafiq Abedin, Steven Royer, Tim Michels

Agenda:

- Brief Review Security and Attestation Discussion from last week
- Revisit Lifecycle Management API discussion

Notes:

Lifecycle Management API Discussion

- Need an inventory set of data - Inventory Queuery mechanism
  - Which DPUs exist
  - Location on Host - Index of DPU in Host (How we will determine this information needs to be identified.)
    - Advertise the virtual locations that is in the host
    - VFs/PFs
    - PCIe Domains that may be available
  - Interfaces that exist
  - Credentials for provisioning
    - How do we initially determine the credentials to secure the transactions?
  - Vendor Information
  - Network reachability information
    - Infrastructure Separation
  - Capabilities
    - Cores
    - Workloads supported
    - Offload Engines
    - Network breakdown/fanout - multiple ports
  - Language for exchange - gRPC, GraphQL, Broadcast Queuery
    - Would Traefik <https://github.com/traefik/traefik> as a load balancer with gRPC be an option for scalability?

Do we need to break the queuery of inventory into multiple stages?

- Initial limited queuery, the later the detailed queuery of information.

Where do we support the Inventory Queuery - is it in the UEFI, OS operation, BMC vs non-BMC solution?

Multiple Phases:

1) Initial phase - Day one provisioning
2) Later phase - Later re-provisioning/re-deploy of provisioning to add services or re-deploy services.

Actions:

- Steven Royer to check with Security team within RedHat for inputs around Attestation and TPM usage.

Topics for Next Week:

- Revisit the Networking and OpenConfig APIs
- Revisit the Storage API
