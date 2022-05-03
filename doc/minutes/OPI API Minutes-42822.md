# Open Programmable Infrastructure API and Behavioral Model Group

---
Minutes 4/28/2022

Attendees:  Mark Sanders, Boris Glimcher, Wayne Hineman, Steven Royer, Liron Himi, Shafiq Abedin, Fabrizio D’Angelo, Jerin Jacob Kollanukkaran, Kyle Mestery, Ted Streete, R Sarma Burugula, Matthew Jean, Michal Kalderon, Navad Haklai, Satananda Burla, Senthil Kumar Ganesan, Tim Michels, Yuval Caduri, Dan Daly

Agenda:

- General Updates
- Use Case Initial Discussion

Notes:

- Use Case Discussion
  - Virtualized Network (OVS) with Security Groups (VxLAN / Geneve) topology
    - OVN or Kubernetes type of infrastructure
    - Virtual Routing
  - Start with a software based solution first with 2 servers, KVM, etc.
  - Base Use case agreed to on two physical servers (example redhat blog) <https://www.redhat.com/en/blog/optimizing-server-utilization-datacenters-offloading-network-functions-nvidia-bluefield-2-dpus>
  - Begin working the Diagram for the base use case
  - Begin with Configuration API
  - DataPlane (Consumption) API
    - Use of different models like virt-io, nvme, other models.
    - Present specific device functions to the host can be vendor specific
    - Can we standardize the device data models?
    - Abstract the interface with port/device information
  - Develop initial diagram for review in Draw.io <https://app.diagrams.net/>
  - Use to begin concept creation to identify any gaps in OpenConfig (ex. Virtual Switching gaps)

Actions:

- Dan Daly (Intel) to provide initial view of Use case Diagram to the github site.
- Fabrizio provided RHEL files for OCP concept and config
- Intel, Marvell to provide device data model views for Dataplane/Consumption Interface
- Michal Kalderon agreed to upload the Marvell scripts

Upcoming Topics:

- Review Use Case concept diagram
