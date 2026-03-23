# Cardápio Digital API

API REST para gerenciamento de cardápio digital.

## Tecnologias
- Java 21
- Spring Boot 4
- PostgreSQL
- Lombok

## Endpoints
- GET /food - listar todas as comidas
- GET /food/{id} - buscar por id
- POST /food - cadastrar comida
- PUT /food/{id} - atualizar comida
- DELETE /food/{id} - deletar comida

## Como rodar
1. Configure o PostgreSQL e crie um banco chamado `cardapio`
2. Configure o `application.properties` com suas credenciais
3. Rode a aplicação
