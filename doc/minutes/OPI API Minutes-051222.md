# Open Programmable Infrastructure API and Behavioral Model Group

---
Minutes 5/12/2022

Attendees: Mark Sanders, Steven Royer, Ted Streete, R Sarma Burugula, Michal Kalderon, Navad Haklai, Prasun Kapoor, Raja Kommula, Satananda Burla, Shafiq Abedin, Tim Michels, Wayne Hineman

Agenda:

1) Lifecycle Management API Discussion - get inputs from the Lifecycle management around the needs for API framework
2) Security, Attestation API
  a. Basis or guidelines from the OpenSSL may be a starting point for the Security API.

Notes:

Use Cases for consumption

- Local Combined Entity access where operator is common
- Remote Entity access where operator is independent and separate Attestation and Security control points.

Attestation

- May want to look into: <https://keylime.dev/>
- Chain of Trust and Attestation
  - should be part of the application view and operating environment.
  - Reporting of Attestation data is the payload data from a queuery.
  - API needs to define the queuery.
    - API would provide the able to collect/queuery the attestation result for a service or capability
    - Need to provide a Joint Attestation/verification between the remote and local service
- Security wrapper around the solution - Identity Access Management and Role Based Access Controls are needed
- Is Attestation an optional capability in the DPU/API view since it relies on a TPM or TPM-like capability in the hardware?

Actions:

- Explore more broadly the requirement for TPMs or TPM-like capability on the DPUs
  - Bring forward the TPM discussion to the larger community meeting
- Security Wrapper should move toward the gRPC aspect to provide the security boundary for the incoming requests

Raja Kommula may be able to assist with the gRPC interface for initial concept