# 💸 Controle de Gastos Pessoais

Projeto acadêmico full-stack para um sistema de controle de lançamentos financeiros (receitas e despesas), utilizando Spring Boot, HTMX e PostgreSQL.

## 🚀 Aplicação no Ar (Live Demo)

A aplicação está hospedada no Render e pode ser acessada pela URL raiz:

➡️ URL: https://controlegastosbackend.onrender.com/

O endpoint principal da API para os lançamentos (que retorna o JSON) pode ser acessado em:

➡️ API: https://controlegastosbackend.onrender.com/api/lancamentos

## ✨ Funcionalidades

O projeto é um CRUD (Create, Read, Update, Delete) completo para gerenciar finanças pessoais:

Listar todos os lançamentos (receitas e despesas).

Adicionar um novo lançamento através de um formulário.

Editar um lançamento existente.

Excluir um lançamento do histórico.

Cálculo de saldo total.

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído com uma abordagem moderna, combinando um backend robusto com um frontend reativo sem a necessidade de uma SPA JavaScript complexa.

**Backend**

- Java 21

- Spring Boot 3

- Spring Data JPA (Hibernate)

- Maven (Gerenciador de dependências)

**Frontend**

- HTML 5

- HTMX (Para atualizações dinâmicas da página sem recarregamento)

- Thymeleaf (Motor de templates do lado do servidor)

**Banco de Dados**

- H2 Database (Ambiente de Desenvolvimento)

- PostgreSQL (Ambiente de Produção, hospedado no Neon.tech)

**Deploy (Infraestrutura)**

- Docker (Para containerizar a aplicação)

- Render.com (Plataforma de nuvem para hospedar o container Docker)

## 🏁 Rodando Localmente

Siga os passos abaixo para executar o projeto em sua máquina local.

Pré-requisitos:

- JDK 21 ou superior

- Maven

Passos

1. Clone o repositório:

```bash
git clone [https://github.com/SthefanySouza486/ControleDeGastos.git](https://github.com/SthefanySouza486/ControleDeGastos.git)
cd ControleDeGastos
```


2. (Opcional) Compile e baixe as dependências usando o Maven Wrapper:
   
```bash
./mvnw clean install
```

3. Execute a aplicação:

```bash
./mvnw spring-boot:run
```


4. Acesse em seu navegador:

- Aplicação: http://localhost:8080

- Console do Banco H2: http://localhost:8080/h2-console

    - (Use a URL JDBC: jdbc:h2:mem:testdb, User: sa, Password: password)

## 📦 Deploy em Produção (Render)

O deploy para produção é automatizado e configurado da seguinte forma:

1. Plataforma: Render.com

2. Runtime: O serviço está configurado para usar Docker.

3. Build: O Render detecta o Dockerfile na raiz do projeto e constrói a imagem automaticamente a cada push na branch main.

4. Banco de Dados: As variáveis de ambiente DB_URL, DB_USERNAME, e DB_PASSWORD estão configuradas no painel do Render, apontando para a instância do PostgreSQL no Neon.

5. Perfil: A variável SPRING_PROFILES_ACTIVE está definida como production, ativando o arquivo application-production.properties para conectar ao banco PostgreSQL.

## 👩‍💻 Autora

Sthefany Souza

GitHub: @SthefanySouza486
