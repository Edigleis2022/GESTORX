🚧 Status: Em desenvolvimento (Projeto acadêmico)

🚀 GetorX API

API REST desenvolvida com Spring Boot como parte de um projeto acadêmico em desenvolvimento, com foco na aplicação prática de arquitetura em camadas e boas práticas no desenvolvimento backend.

📚 Contexto Acadêmico

Este projeto foi desenvolvido com o objetivo de aplicar conceitos estudados em sala de aula, incluindo:

Arquitetura em camadas

Desenvolvimento de APIs REST

Organização e estruturação de projetos Java

Uso de DTO (Data Transfer Object)

Tratamento global de exceções

Persistência de dados com JPA/Hibernate

🏗️ Arquitetura do Projeto

O sistema foi estruturado seguindo o padrão:
```
controller → service → repository → model
                ↓
               dto
                ↓
            exception
```

```
📂 Estrutura de Pacotes

GetorX
│
├── controller
│   ├── FornecedorController.java
│   ├── ProdutoController.java
│   └── UsuarioController.java
│
├── service
│   ├── implementacao
│   ├── FornecedorService.java
│   ├── ProdutoService.java
│   └── UsuarioService.java
│
├── repository
│
├── model
│   ├── Usuario.java
│   ├── Produto.java
│   ├── Fornecedor.java
│   ├── Demanda.java
│   └── EmitirNota.java
│
├── dto
│   ├── ProdutoDTO.java
│   └── FornecedorDTO.java
│
└── exception
    ├── GlobalExceptionHandler.java
    └── RecursoNaoEncontradoException.java
```
📌 Responsabilidade das Camadas

Controller → Camada responsável pelos endpoints da API

Service → Implementação das regras de negócio

Repository → Comunicação com o banco de dados

Model → Entidades do sistema

DTO → Transferência segura de dados entre camadas

Exception → Tratamento global de erros da aplicação

🛠️ Tecnologias Utilizadas

Java

Spring Boot

Spring Data JPA

Hibernate

Maven

🔌 Funcionalidades Implementadas

Cadastro de usuários

Cadastro de produtos

Cadastro de fornecedores

Tratamento global de exceções

Exceção personalizada para recurso não encontrado

🚧 O projeto ainda está em desenvolvimento e pode receber novas funcionalidades.

▶️ Como Executar o Projeto

```bash
git clone https://github.com/Edigleis2022/gestorx.git
cd gestorx
mvn spring-boot:run
```

Requisitos:

Java instalado

Maven configurado no sistema

📌 Status

Projeto acadêmico em desenvolvimento, com foco na consolidação dos conceitos de backend com Spring Boot.

👨‍🎓 Autores

Edigleis Pereira dos Santos

Bruno Severo de Oliveira

Maria Eduarda Bronzatti Mesquita
