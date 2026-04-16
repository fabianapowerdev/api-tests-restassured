
# 📌 Visão Geral

Este projeto contém um **mini‑framework reutilizável de automação de testes de API**, desenvolvido em **Java + Maven + RestAssured + JUnit 5**.

Ele foi construído com foco em **aprendizado prático** e **aplicação real em projetos corporativos**, seguindo padrões usados em squads de QA e desenvolvimento.

Use este repositório como:
- base para novos projetos de automação
- referência técnica
- material de estudo
- apoio para projetos reais

---

# 🎯 Objetivos do Framework

- Centralizar configurações (ambiente, autenticação, headers)
- Evitar código duplicado
- Manter testes limpos e legíveis
- Separar infraestrutura de cenários de teste
- Facilitar execução local e em CI/CD

---

# 🧱 Stack Tecnológica

- **Java 17**
- **Maven**
- **RestAssured**
- **JUnit 5**
- **Jackson Databind**

---

# 📂 Estrutura do Projeto

```text
src/test/java/api
├── base
│   └── BaseTest.java
│
├── config
│   ├── EnvironmentConfig.java
│   └── AuthConfig.java
│
├── service
│   └── PostService.java
│
├── payload
│   └── PostPayload.java
│
├── get
├── post
├── put
├── delete
│
└── flow
    └── PostPutDeleteFlowTest.java
