# 🍽️ Cardápio Digital — API REST com Spring Boot

> API RESTful para gerenciamento de cardápio digital, com cadastro completo de itens alimentares.

---

## 📌 Sobre o Projeto

O **Cardápio Digital** é uma API REST desenvolvida com Java e Spring Boot que permite gerenciar os itens de um cardápio de forma simples e eficiente. Através dos endpoints disponíveis, é possível listar, cadastrar, atualizar e remover comidas, integrando com um banco de dados PostgreSQL.

---

## ✨ Funcionalidades

- ✅ Listagem de todos os itens do cardápio
- ✅ Busca de item por ID
- ✅ Cadastro de novas comidas
- ✅ Atualização de itens existentes
- ✅ Remoção de itens do cardápio

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia      | Descrição                          |
|-----------------|------------------------------------|
| Java 21         | Linguagem principal                |
| Spring Boot 4   | Framework para criação da API      |
| PostgreSQL      | Banco de dados relacional          |
| Lombok          | Redução de código boilerplate      |
| Maven           | Gerenciador de dependências        |

---

## 📡 Endpoints

| Método   | Endpoint       | Descrição                    |
|----------|----------------|------------------------------|
| `GET`    | `/food`        | Lista todos os itens         |
| `GET`    | `/food/{id}`   | Busca um item por ID         |
| `POST`   | `/food`        | Cadastra um novo item        |
| `PUT`    | `/food/{id}`   | Atualiza um item existente   |
| `DELETE` | `/food/{id}`   | Remove um item do cardápio   |

---

## ⚙️ Configuração

Configure o arquivo `src/main/resources/application.properties` com suas credenciais do PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/cardapio
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🚀 Como Rodar o Projeto

### Pré-requisitos

- Java 21 ou superior
- PostgreSQL instalado e rodando
- Maven instalado (ou usar o Maven Wrapper incluso)

### Passo a passo

**1️⃣ Clone o repositório**
```bash
git clone https://github.com/seuusuario/cardapio-digital.git
cd cardapio-digital
```

**2️⃣ Crie o banco de dados**
```sql
CREATE DATABASE cardapio;
```

**3️⃣ Configure suas credenciais**

Edite o arquivo `src/main/resources/application.properties` com seu usuário e senha do PostgreSQL.

**4️⃣ Execute a aplicação**

Com Maven Wrapper:
```bash
./mvnw spring-boot:run
```

Ou com Maven instalado:
```bash
mvn spring-boot:run
```

**5️⃣ Acesse a API**
```
http://localhost:8080
```

---

## 📦 Exemplo de Requisição

**POST** `/food` — Cadastrar um item:

```json
{
  "nome": "Pizza Margherita",
  "preco": 45.90,
  "descricao": "Molho de tomate, mussarela e manjericão"
}
```

**Resposta** `201 Created`:
```json
{
  "id": 1,
  "nome": "Pizza Margherita",
  "preco": 45.90,
  "descricao": "Molho de tomate, mussarela e manjericão"
}
```
