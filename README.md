🚧 Status: Em desenvolvimento (Projeto acadêmico)

# 🚀 GestorX API

API REST desenvolvida com Spring Boot como parte de um projeto acadêmico voltado ao gerenciamento de estoque para empresas de pequeno e médio porte, aplicando conceitos de arquitetura em camadas e boas práticas de desenvolvimento backend.

---

## 📚 Contexto Acadêmico

Este projeto foi desenvolvido para aplicar conceitos estudados em sala de aula:

- Arquitetura em camadas
- Desenvolvimento de APIs REST
- Spring Security
- DTO (Data Transfer Object)
- Tratamento global de exceções
- Persistência com JPA/Hibernate
- Relacionamentos entre entidades
- Autenticação e autorização com JWT
- Organização de projetos Java

---

## 🏗️ Arquitetura do Projeto

Estrutura seguindo o padrão:

```text
controller → service → repository → model
                ↓
               dto
                ↓
            exception
                ↓
          securityConfig
```

---

## 📂 Estrutura de Pacotes

```text
GestorX
│
├── Config
│
├── controller
│   ├── UsuarioController.java
│   ├── ProdutoController.java
│   └── FornecedorController.java
│
├── dto
│   ├── UsuarioRequestDTO.java
│   ├── UsuarioResponseDTO.java
│   ├── UsuarioDetalhadoDTO.java
│   ├── ProdutoDTO.java
│   └── FornecedorDTO.java
│
├── enums
│   ├── CategoriaProduto.java
│   ├── TipoUsuario.java
│   └── StatusFornecedor.java
│
├── exception
│   ├── GlobalExceptionHandler.java
│   └── RecursoNaoEncontradoException.java
│
├── model
│   ├── Usuario.java
│   ├── Produto.java
│   ├── Fornecedor.java
│   └── FornecedorProduto.java
│
├── repository
│
├── securityConfig│
│   ├── SecurityConfiguration.java│ 
│   └── CustomUserDetailsService.java
│
├── service
│   ├── UsuarioService.java
│   ├── ProdutoService.java
│   └── FornecedorService.java
│
└── GestorXApplication.java
```

---

## 📌 Responsabilidade das Camadas

### Controller
Responsável pelos endpoints da API.

### Service
Contém as regras de negócio da aplicação.

### Repository
Realiza comunicação com banco de dados através do Spring Data JPA.

### Model
Representa as entidades do sistema.

### DTO
Transfere dados entre camadas evitando exposição direta das entidades.

### Exception
Centraliza tratamento de erros.

### SecurityConfig
Responsável pela autenticação, autorização e configuração de segurança.

### Enums
Define valores padronizados utilizados pelo sistema.

---

## 🔐 Segurança Implementada

- Spring Security
- Controle de acesso por perfil
- Autenticação de usuários
- Controle de permissões
- Implementação de UserDetails
- Tokens JWT

---

## 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- Maven
- PostgreSQL
- JWT

---

## 🔌 Funcionalidades Implementadas

✅ Cadastro de usuários

✅ Cadastro de produtos

✅ Cadastro de fornecedores

✅ Relacionamento fornecedor-produto

✅ Tratamento global de exceções

✅ Exceções personalizadas

✅ Controle de acesso por perfil

✅ Autenticação de usuários

---

## ▶️ Como executar

```bash
git clone https://github.com/Edigleis2022/gestorx.git

cd gestorx

mvn spring-boot:run
```

### Requisitos

- Java 21+
- Maven
- PostgreSQL

---

## 📌 Status

Projeto acadêmico em desenvolvimento com foco na consolidação de conhecimentos em backend utilizando Spring Boot.

---

## 👨‍🎓 Autores

- Edigleis Pereira dos Santos
- Bruno Severo de Oliveira
- Maria Eduarda Bronzatti Mesquita
