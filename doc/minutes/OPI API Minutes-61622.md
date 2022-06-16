# Open Programmable Infrastructure API and Behavioral Model Group

---
Minutes 6/16/2022

Attendees: Mark Sanders, Ted Streete, Boris Glimcher, Anh Thu Vo, Matthew Jean, Raja Kommula, Shachar Tal, Shafiq Abedin, Wayne Hineman, Satananda Burla, Yuval Caduri, Steven Royer, Senthil Kumar Ganesan, Jerin Jacob Kollanukkaran

Agenda:

- Quick view of USECASES addition to github site
- Test Driven Concept deck submitted by Dan Daly for access by the team
- Revisit Storage APIs
- No meeting on 6/23/22 - corresponds with the Open Source Summit and LF announcement
- Discuss pre-announcing agenda of meeting prior to allow the right set of attendees - Good Idea Steven Royer.

Notes:

Storage API Review/Discussion

- Protobuf definitions need to be worked for the Storage Actions (refer to the Storage Diagram)
  - Front End APIs
    - What can be shared from the vendors (NVIDIA, Marvell)
    - Satananda provided header file with parameter set
  - Back End APIs
    - NVMe and iSCSI devices
    - null, AIO, and Memory devices for debugging

- Emulated devices

- Defer/delay the security aspects for now
  - Make sure we put placeholder for the security in the protobuf definition

- Initial phase should be to flush out the basics, add TLS and Security aspects with encryption, compression, etc at a later time
  - Example NVMe-oSSL patches are not yet published

- Need to understand the parameters for storage that provide
  - IP
  - Protocol
  - Security keys
  - etc

Currently we are missing Storage Services in the Storage API (Boris will add to the diagram)

- Covers Encryption, Compression, RAID protection
- APIs with parameter settings

Upcoming Topics:

- Overview of DASH/Synergy with DASH effort
- Begin discussions around the Behavioral Model views (P4 DPDK, DPDK, SPDK)
