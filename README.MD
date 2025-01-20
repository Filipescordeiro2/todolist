# Desafio de Criação de um Microsserviço em Java 17 com Spring Boot

## Objetivo
O objetivo deste desafio é desenvolver um microsserviço simples que gerencia uma lista de tarefas (*to-do list*). O serviço permitirá que os usuários criem, leiam, atualizem e excluam tarefas. Esse projeto ajudará a entender os conceitos básicos de microsserviços, RESTful APIs, e o uso do Spring Boot.

## Requisitos do Projeto

### 1. Tecnologias
- **Java 17**
- **Spring Boot** (versão 2.6 ou superior)
- **Spring Data JPA**
- **H2 Database** (para persistência em memória)
- **Maven** (para gerenciamento de dependências)

### 2. Funcionalidades
- **Criar uma nova tarefa**: `POST /tasks`
- **Listar todas as tarefas**: `GET /tasks`
- **Obter uma tarefa específica**: `GET /tasks/{id}`
- **Atualizar uma tarefa existente**: `PUT /tasks/{id}`
- **Excluir uma tarefa**: `DELETE /tasks/{id}`

### 3. Modelo de Dados
A classe `Task` deverá conter os seguintes atributos:
- `id` (Long, gerado automaticamente)
- `title` (String, obrigatório)
- `description` (String, opcional)
- `completed` (Boolean, padrão `false`)
- `createdAt` (LocalDateTime, gerado automaticamente)
- `updatedAt` (LocalDateTime, atualizado automaticamente)

### 4. Validações
- O título da tarefa deve ser obrigatório.
- O ID fornecido para buscar, atualizar ou excluir uma tarefa deve existir.

### 5. Estrutura do Projeto
O projeto deve seguir a seguinte estrutura de pacotes:

```
src/main/java/com/exemplo/todolist
|— controller  (Pacote para controladores REST)
|— model       (Pacote para modelos de dados)
|— repository  (Pacote para repositórios)
|— service     (Pacote para lógica de negócio)
```

O arquivo de configuração `application.properties` deve estar localizado em:
```
src/main/resources/application.properties
```

## Configurações e Dicas

1. **Banco de Dados H2**:
    - Configure o H2 Database no arquivo `application.properties` para facilitar os testes.
    - Exemplo de configuração:
      ```properties
      spring.datasource.url=jdbc:h2:mem:todolist
      spring.datasource.driverClassName=org.h2.Driver
      spring.datasource.username=sa
      spring.datasource.password=
      spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
      spring.h2.console.enabled=true
      ```

2. **Testes**:
    - Teste sua API usando ferramentas como Postman ou cURL para garantir que todas as funcionalidades estejam funcionando corretamente.

3. **Boas Práticas**:
    - Utilize as anotações do Spring para injeção de dependências e organização do código.
    - Mantenha o código limpo e legível.
    - Documente os endpoints utilizando ferramentas como Swagger, se possível.

## Como Executar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```

2. **Navegue até o diretório do projeto**:
   ```bash
   cd todolist
   ```

3. **Compile e execute o projeto**:
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse o console do H2** (opcional):
    - URL: `http://localhost:8080/h2-console`
    - Username: `sa`
    - Password: (deixe em branco)

## Endpoints da API

| Método HTTP | Endpoint         | Descrição                     |
|--------------|------------------|---------------------------------|
| POST         | `/tasks`         | Criar uma nova tarefa          |
| GET          | `/tasks`         | Listar todas as tarefas        |
| GET          | `/tasks/{id}`    | Obter uma tarefa específica    |
| PUT          | `/tasks/{id}`    | Atualizar uma tarefa existente |
| DELETE       | `/tasks/{id}`    | Excluir uma tarefa             |

## Desenvolvido por:

Filipe Santana Cordeiro
---
Desenvolvedor Beck End

