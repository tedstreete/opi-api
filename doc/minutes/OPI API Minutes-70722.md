# Open Programmable Infrastructure API and Behavioral Model Group

---
Minutes 7/7/2022

Attendees: Mark Sanders, Boris Glimcher, Anh Thu Vo, Shachar Tal, Shafiq Abedin, Wayne Hineman, Satananda Burla, Venkat Pullela, Rob Davis, Navad Haklai, Liel, Anuradha Karuppiah, Noam Gottlieb, Tim Michels, Prasun Kapoor, Thomas Monjalon

Agenda:

- Continue Storage Discussion
  - NVIDIA K8s oriented diagram
- Discuss the Split between Network and Storage (create two weekly meetings)
Other Topics (time depending)
- Discuss API Gateway and Security (common authentication)
- Circle back on Network APIs, OVS, other networking stacks (SONiC, etc.)

Notes:

- Storage Discussion deferred to a later date when diagram is ready
  - Boris provided upate and call to action related to the PoC aspects.

- Split the API meetings between Networking and Storage
  - Options
    - Two meetings per week - One on Networking, One on Storage
    - Alternating weeks with Networking and Storage as topics
  - Make the meetings not overlapping.

- Deep dive on the diagram for the API Gateway.
  - Look through the Authentication and Authorization aspects of the layer.
  - Expand the view of the details
    - Monitoring
    - Hosting
    - Tracing
    - Authentication and Authorization
    - Streaming
  - Review the security needs for the VFs that are provided to the VM/Container environment in the host.
  - Look at the ORAN data and CNCF information on similar capabilities
    - <https://oranalliance.atlassian.net/wiki/spaces/SFG/pages/2534834394/ORA-2022.07.04-SFG-CR-0021-OCLOUD-Risk-Assessment>
    - <https://oranalliance.atlassian.net/wiki/spaces/SFG/pages/2512781323/Security+Requirements+Specification+v4.0> (membership in ORAN is required)

- Service Chaining discussion on the linkage between various services.  This will likely need to be a focused area to delve into the details on the flow interconnects.

- A configuration model is needed using OpenConfig to be applied to the basic network use case.  This can identify some of the basic missing capabilities such as:
  - Programmability Interface
  - IPSec
  - eBPF
- Extend OpenConfig to support missing capabilities or use other available models
- OpenConfig addresses the Control Plane aspects.  Do we need someting for Data Plane interaction or does that really fall into the existing SDKs such as DPDK, SPDK, etc?

Actions:

- (Mark) Queuery the API workgroup related to meeting preference.
- (Boris) Create initial API gateway diagram to start the dialogue.
- Produce a configuration model using OpenConfig that aligns with the networking basic Use case

Upcoming Topics:

- Storage Discussion wrt NVIDIA K8s diagram
