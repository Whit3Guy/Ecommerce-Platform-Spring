# E-Commerce Platform API - Spring Boot

Bem-vindo à **E-Commerce Platform API**, um projeto de backend desenvolvido em **Spring Boot** que simula as operações principais de uma plataforma de comércio eletrônico. Este projeto foi estruturado para fins de aprendizado e portfólio, fornecendo endpoints para gerenciar **usuários**, **categorias**, **produtos**, **pedidos** e suas respectivas operações.

---

## 📋 Funcionalidades

1. **Gerenciamento de Usuários:**
    - Criar, listar, atualizar e excluir usuários.
2. **Gerenciamento de Categorias:**
    - Listar todas as categorias e consultar detalhes de uma categoria específica.
3. **Gerenciamento de Produtos:**
    - Listar todos os produtos e consultar detalhes de um produto específico.
4. **Gerenciamento de Pedidos:**
    - Listar todos os pedidos e consultar detalhes de um pedido específico.
5. **Validações:**
    - Utilização de validações com `Jakarta Validation` para dados enviados via requisição.
6. **Tratamento de Erros:**
    - Configuração de `Exception Handlers` para tratar erros de validação e erros de banco de dados.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17** (ou superior)
- **Spring Boot 3.x**
    - Spring Web
    - Spring Data JPA
    - Bean Validation (Jakarta Validation)
- **Banco de Dados:**
    - H2 Database (modo de teste e desenvolvimento)
    - Suporte a outros bancos como PostgreSQL ou MySQL
- **Ferramentas:**
    - Maven (para gerenciamento de dependências)
    - Insomnia/Postman (para testes dos endpoints)

---

## ⚙️ Endpoints

### **Usuários**

- **Base Path:** `/users`
- **Endpoints:**
    - `GET /users/`  
      Lista todos os usuários.  
      **Resposta:**
      ```json
      [
        { "id": 1, "name": "John Doe", "email": "john@example.com" },
        { "id": 2, "name": "Jane Doe", "email": "jane@example.com" }
      ]
      ```

    - `GET /users/{id}`  
      Retorna os detalhes de um usuário específico.  
      **Exemplo de Resposta (200):**
      ```json
      { "id": 1, "name": "John Doe", "email": "john@example.com" }
      ```
      **Exemplo de Resposta (404):**
      ```json
      { "error": "User not found" }
      ```

    - `POST /users/`  
      Cria um novo usuário.  
      **Payload:**
      ```json
      { "name": "Alice", "email": "alice@example.com", "password": "12345" }
      ```
      **Resposta (201):**
      ```json
      { "id": 3, "name": "Alice", "email": "alice@example.com" }
      ```

    - `PUT /users/{id}`  
      Atualiza os dados de um usuário existente.  
      **Payload:**
      ```json
      { "name": "Alice Updated" }
      ```
      **Resposta (200):**
      ```json
      { "id": 3, "name": "Alice Updated", "email": "alice@example.com" }
      ```

    - `DELETE /users/{id}`  
      Exclui um usuário específico.  
      **Resposta (200):**
      ```json
      { "id": 3, "name": "Alice Updated" }
      ```

---

### **Categorias**

- **Base Path:** `/categories`
- **Endpoints:**
    - `GET /categories/`  
      Lista todas as categorias.
    - `GET /categories/{id}`  
      Retorna os detalhes de uma categoria específica.

---

### **Produtos**

- **Base Path:** `/products`
- **Endpoints:**
    - `GET /products/`  
      Lista todos os produtos.
    - `GET /products/{id}`  
      Retorna os detalhes de um produto específico.

---

### **Pedidos**

- **Base Path:** `/orders`
- **Endpoints:**
    - `GET /orders/`  
      Lista todos os pedidos.
    - `GET /orders/{id}`  
      Retorna os detalhes de um pedido específico.

---

## 📂 Estrutura do Projeto

```plaintext
src/main/java/com/whiteStudio/Ecommerce_Platform_Spring/
├── controllers/          # Controladores REST (camada de API)
├── entities/             # Entidades representando as tabelas no banco
├── entities/dtos/        # Data Transfer Objects para validações
├── repositories/         # Interfaces JPA para acesso ao banco
├── services/             # Regras de negócios e lógica de serviço
├── services/exceptions/  # Classes de exceção personalizadas
└── controllers/exceptions/
    └── ValidationExceptionHandler.java  # Tratamento de erros
