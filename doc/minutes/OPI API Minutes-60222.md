# Open Programmable Infrastructure API and Behavioral Model Group

---
Minutes 6/2/2022

Attendees: Mark Sanders, Frode Nordahl, Kyle Mestery, Shachar Tal, Shafiq Abedin, Steven Royer, Venkatesan Mahalingam, Wayne Hineman, Matthew Jean, R Sarma Burugula

Agenda:

- Revisit Networking and OpenConfig APIs
- Discuss API model view

Notes:

- Reviewed OpenConfig Model diagram that is posted in the network folder
- Identified areas that need to be augmented/extended
  - IPSec
  - Crypto Selection (for IPSec or TLS)
  - TLS (TLS 1.2/1.3)
  - Does it make sense to have a "Network Security" area that defines the TLS, IPSec?
  - Do we need to chain the IPSec or TLS on top of the Network config?
  - Do we add/chain the Crypto Selection as a chain to the Network Security component?

- Discussed the API definition aspects where we need to consider:
  - Traditional Software APIs where you have the Initialization function, API functions, and Data formats.  This would be the typical software APIs where you call the functions after initialization of the library
  - Data Primitive APIs where you define the parameter sets, text description files (protobuf, yaml file, etc.) that are used by a management agent to configure the operations of the target.
  - The latter (Data Primitive API) would seem to be what is desired since it defines what an orchastration application would use to configure the target operations and functions.

Actions:

- Get Test Driven develpment info from Dan Daly to upload

Upcoming Topics:

- Revisit Storage APIs
- Overview of DASH/Synergy with DASH effort
- Begin discussions around the Behavioral Model views (P4 DPDK, DPDK, SPDK)
