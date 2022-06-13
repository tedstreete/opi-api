# Open Programmable Infrastructure API and Behavioral Model Group

---
Minutes 6/9/2022

Attendees: Mark Sanders, Ted Streete, Tim Michels, Anh Thu Vo, Nadav Haklai, Patty Driever, Raja Kommula, Shachar Tal, Shafiq Abedin, Wayne Hineman, Satananda Burla, Yuval Caduri

Agenda:

- Review minutes from previous 6/2/22
- Discussed Security Implications

Notes:

- Security Model
  - Identity and Access Management to verify user/process and access to config services.
    - Potentially utilize/re-use some existing models from REST Standard Services
- CNCF - utilize concepts that have been developed from CNCF
  - Secure Provider Identity Framework for Everyone <https://spiffe.io/>

- With the basis of gRPC exchange, we need to decide on Transaction vs Session Based exchanges
  - Advantages and Dis-advantages of each
    - Concerns around Privilege Escalation, session caching, session scope, session timeouts, mutual TLS/Tokens, etc.

- ORAN Security Meeting June 14-16.  Anh Thu Vo will be attending and provide any feedback on the Secure Boot and Provisioning view from meetings.

- Configuration API - gRPC method of exchange with security model above being discussed.
- Consumption API
  - Network - currently this is a VF exposed to the Host with traffic flows defined
  - Storage - Virtual Disks exposed to the Host
    - Security level for Container environments and their associated storage area
    - Self encrypting drives and crypto key handling
    - Anh and Ted Streete to begin looking at this interface for security aspects

Actions:

- Get Test Driven develpment info from Dan Daly to upload

Upcoming Topics:

- Revisit Storage APIs
- Overview of DASH/Synergy with DASH effort
- Begin discussions around the Behavioral Model views (P4 DPDK, DPDK, SPDK)
