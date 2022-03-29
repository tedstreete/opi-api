# Open Programmable Infrastructure API and Behavioral Model Group

---
Minutes 3/24/2022

Attendees: Prasun Kapoor, Ted Streete, Boris Glimcher, Mark Sanders, Gene Bagwell, Navad Haklai, R Sarma Burugula, Satananda Burla, Jerin Jacob, Shafiq Abedin, Wayne Hineman, Gokul Kandiraju, Fabrizio D’Angelo, Kyle Mestery, Venkat Mahalinga, Umesh Deshpanti

Agenda:

- Discuss Github location and use of Issues/Discussion for Brainstorming, collaboration, and Actions
- Prioritize top Set of APIs to focus workstream on
- Discuss Capabilities Classification <https://docs.google.com/spreadsheets/d/1IBCS1a2R23Ehc4CYypzvX8GfwZXDO7Wm/edit#gid=488964010>
- Review/Discuss API protocol mechanisms – gRPC, etc.

Notes:

- Bring up the Discussions section of the Github to the broader DB/OPI teams for how to track the various information that is being worked across the teams.
- Prioritization of APIs
  - Define the Infrastructure Use Cases and align to the Needs in the API
    - Advertisement of Capabilities is key
    - Is Networking basis a key component across the various use cases? - Yes
    - Is Security a key component across the various use cases? – Yes
    - Is Storage a key component across the various use cases?
  - Get a broad agreement of the capabilities is a first step.
  - Style of API to use – REST for some types, gRPC for some types – provide recommendations.
    - Define the Request and Response structure
      - Base Framework Definition
    - GraphQL instead of REST (Thumbs up)
  - Utilize existing APIs that are in place and extend where capabilities are missing
  - Look at the view of Dataplane and Control Plane

Actions:

- Setup formal mailing list for the group – github, etc.
- Add notifications for the github for updates/changes to the repo.
- Add guidelines for the development/spec creation for the contributions to the repo.

Upcoming Meeting Topics:

- IPDK Interfaces Walk Through (next week) – Dan Daly (Intel)
- DPDK Interface Walk through (2 weeks from now) – Jerin Jacob (Marvell)
