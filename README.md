# 🚀 API‑TESTS‑RESTASSURED‑MASTER

## 📌 Visão Geral
Este projeto consiste em um mini-framework reutilizável de automação de testes de API, desenvolvido em **Java** utilizando **RestAssured** e **JUnit 5**, com gerenciamento de dependências via **Maven**. 

Ele foi estruturado com foco em aprendizado prático e aplicação real em projetos corporativos, simulando os padrões arquiteturais utilizados por squads de QA e Desenvolvimento no mercado. O repositório serve como uma base sólida para novos projetos de automação, referência de código limpo e material de estudo aprofundado.

## 🎯 Objetivos do Framework
* **Centralização de Infraestrutura:** Configurações de ambientes e autenticação isoladas e modulares.
* **Redução de Código Duplicado:** Camadas específicas para gerenciamento de payloads e isolamento de requisições HTTP.
* **Manutenção e Legibilidade:** Testes limpos baseados em asserções diretas, separando a regra do teste da mecânica de envio.
* **Validação Abrangente:** Cobertura que vai desde testes funcionais isolados a fluxos ponta a ponta (E2E), além de testes de contrato e cenários guiados por comportamento (BDD).

## 🧱 Stack Tecnológica
* **Java 17**
* **Maven**
* **RestAssured**
* **JUnit 5**
* **Jackson Databind** (para manipulação e serialização de objetos JSON)
* **RestAssured Json-Schema-Validator**

---

## 📂 Estrutura do Projeto

A arquitetura do diretório `src/test` reflete com precisão a separação de responsabilidades do framework:

```text
src/test
├── java/api
│   ├── base/
│   │   └── BaseTest.java              # Configurações globais de inicialização (BaseURI, portas, logs)
│   ├── bdd/
│   │   └── PostSteps.java             # Implementação dos passos (Glue Code) das features Gherkin
│   ├── config/
│   │   ├── AuthConfig.java            # Gerenciamento de tokens e credenciais de segurança
│   │   └── EnvironmentConfig.java     # Configuração dinâmica de ambientes (Dev, Homologação, Prod)
│   ├── delete/
│   │   └── DeletePostTest.java        # Cenários de testes isolados de exclusão (HTTP DELETE)
│   ├── flow/
│   │   └── PostPutDeleteFlowTest.java # Testes funcionais integrados ponta a ponta (E2E)
│   ├── get/
│   │   └── GetUserTest.java           # Cenários de testes isolados de consulta (HTTP GET)
│   ├── payload/
│   │   └── PostPayload.java           # Modelagem de massa de dados/POJOs para o corpo das requisições
│   ├── post/
│   │   └── CreateUserTest.java        # Cenários de testes isolados de criação (HTTP POST)
│   ├── put/
│   │   └── UpdatePostTest.java        # Cenários de testes isolados de atualização (HTTP PUT)
│   ├── schema/
│   │   └── PostSchemaTest.java        # Execução técnica de testes de contrato JSON
│   └── service/
│       └── PostService.java           # Métodos de ação e encapsulamento das chamadas da API
└── resources/
    ├── features/                      # Arquivos descritivos de cenários de teste em formato Gherkin (.feature)
    └── schemas/                       # Arquivos JSON Schema para validação estrutural de contratos

    
