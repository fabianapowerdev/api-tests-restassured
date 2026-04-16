
✅ Checklist Completo – Como Iniciar Automação de Testes de API

📌 Objetivo deste checklist
Servir como guia prático e reutilizável para iniciar automação de testes de API em qualquer projeto real, evitando erros comuns e garantindo uma base sólida desde o início.


Este checklist pode ser usado:

no início de um projeto novo
ao entrar em uma squad já existente
como roteiro de estudo
como referência rápida no dia a dia


🧭 FASE 1 – Entendimento do Projeto (ANTES de escrever código)
✅ Entender qual API será testada

Qual é o domínio da API? (ex: cadastro, pedidos, pagamentos)
A API é REST? GraphQL?
Existe contrato (Swagger / OpenAPI)?
✅ Identificar ambientes disponíveis

DEV
HML
QA
PROD (normalmente NÃO testado diretamente)
✅ Confirmar autenticação

API sem autenticação
Token fixo
Token dinâmico via login
OAuth / JWT / outro
✅ Definir objetivo da automação

Regressão
Smoke test
Fluxo de negócio
Apoio ao time de desenvolvimento


🧱 FASE 2 – Preparação do Projeto
✅ Criar projeto base

Projeto Maven
Java 17 (ou versão definida pela empresa)
✅ Adicionar dependências essenciais

RestAssured
JUnit 5
Jackson Databind
✅ Validar execução inicial

mvn clean test roda sem erros


📂 FASE 3 – Estrutura Inicial do Framework
✅ Criar estrutura de pastas padrão
api
├── base
├── config
├── service
├── payload
├── get
├── post
├── put
├── delete
└── flow


✅ Objetivo da estrutura

separar infraestrutura de teste
facilitar manutenção
evitar código duplicado


⚙️ FASE 4 – Configuração Base (BaseTest)
✅ Criar BaseTest

Centralizar baseUri
Centralizar headers comuns
Configurar SSL (quando necessário)
Configurar logs automáticos em falha
✅ Boas práticas

Nenhum teste deve definir baseUri
Nenhum teste deve configurar headers globais


🌍 FASE 5 – Configuração de Ambiente (config)
✅ Criar EnvironmentConfig

DEV como padrão
Leitura via -Denv
✅ Validar execução

mvn test -Denv=dev
mvn test -Denv=hml
📌 Evita trocar código ao mudar ambiente


🔐 FASE 6 – Autenticação (AuthConfig)
✅ Criar AuthConfig

Leitura de token via -Dtoken
Token mock para estudo/local
✅ Integrar no BaseTest

Header Authorization centralizado
✅ Validar execução

mvn test -Dtoken=abc123
📌 Testes e services não devem conhecer auth


🌐 FASE 7 – Service Layer
✅ Criar classes de Service

Uma classe por domínio (ex: PostService)
Apenas chamadas HTTP
Sem asserts
✅ Conferir boas práticas

Usa RequestSpecification
Não conhece regras de negócio


📦 FASE 8 – Payload Layer
✅ Criar payload reutilizável

Sem JSON hardcoded no teste
Preferir Map ou POJO
✅ Benefícios

mudança de contrato em um único lugar
testes mais limpos


🧪 FASE 9 – Testes Unitários de Endpoint
✅ Criar testes por método HTTP

GET
POST
PUT
DELETE
✅ Validar

Status code
Campos principais do response


🔁 FASE 10 – Testes de Fluxo (Flow)
✅ Criar testes end‑to‑end

POST → PUT → DELETE
Extração de dados da resposta
✅ Boas práticas

Fluxo dentro de um único teste
Evitar dependência de ordem


🪵 FASE 11 – Logs e Debug
✅ Configuração padrão

Log automático somente em falha
✅ Debug pontual

Uso temporário de .log().all()


▶️ FASE 12 – Execução e Pipeline
✅ Execução local

mvn clean test
✅ Execução parametrizada

-Denv
-Dtoken
✅ Preparação para CI/CD

Projeto roda sem intervenção manual


📘 FASE 13 – Documentação
✅ Criar README.md

Explicar arquitetura
Explicar execução
Explicar decisões técnicas
✅ Benefícios

facilita onboarding
serve como referência
profissionaliza o projeto
