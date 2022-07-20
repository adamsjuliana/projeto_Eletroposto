# Eletroposto
Projeto final desenvolvido na Academia Java 2022 | ATOS - UFN.

## Modelo Descritivo

### Problema a ser solucionado
Tempos longos de carregamento de carros elétricos.

### Objetivo do Projeto
Redução das filas de espera de carregamento.

### Requisitos funcionais
- Geral
  - Cadastrar usuários
  - Agendar horário
  - Cancelar horário

- Administrador
  - Visualizar todos os agendamentos futuros
  - Editar autorizações dos cadastrados (USER e/ou ADMIN)
  - Cancelar agendamentos futuros (imprevistos da rede)

### Requisitos não funcionais
- O banco de dados deverá estar instalado em um servidor.
- O sistema será em plataforma Web.
  - Layout adaptado para PC e celular.

### Stack utilizada

Linguagem:
 - JAVA
 - SQL
 
Framework:
 - Spring Boot

Dependências:
 - Spring Web
 - Spring Security
 - Spring Data JPA
 - MySQL Driver
 - Thymeleaf
 - Validation
 
Banco de Dados:
 - MySQL
 
Front:
 - Thymeleaf
 - HTML
 - CSS
 - JS

 
### Rodando localmente

Baixe o projeto

```bash
  https://github.com/adamsjuliana/AcademiaJavaAtos_Projeto.git
```

Descompacte

Importe na IDE como projeto MAVEN

Crie o banco de dados no MySQL

```bash
create database Eletroposto
```

Modifique o arquivo de acordo com suas configurações do Banco de dados, atualizando seu usuário e senha

```bash
Eletroposto/src/main/resources/application.properties
```

Inicie o servidor

Registre um usuário

Dê papel de administrador ao usuário criado colocando o comando a seguir no MySQL

```bash
  insert into usuario_papel (usuario_id, papel_id) values (1,1)
```

Como o projeto tem a dependência Spring Boot DevTools, não precisa ser reiniciado.

### Demonstração

<div align="center">

[![Watch the video](https://img.youtube.com/vi/JnxR4rF38tg/0.jpg)](https://www.youtube.com/watch?v=JnxR4rF38tg)

</div>
