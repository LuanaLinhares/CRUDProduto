# Documentação do Projeto CRUDProduto

## Descrição do Projeto

Este projeto é um sistema de gerenciamento de produtos simples, construído usando o Spring Boot, que permite criar, listar, atualizar e deletar produtos. Ele utiliza o padrão MVC com Thymeleaf para a camada de visualização, JPA para a camada de persistência, e pode se conectar a um banco de dados MySQL para armazenamento de dados. Para testes, um banco de dados H2 em memória é utilizado.

### Estrutura do Projeto

- **Controller**: Responsável por gerenciar as requisições HTTP e direcionar as operações de CRUD para o repositório.
- **Entity**: Representa a entidade `Produto` que é manipulada pelas operações CRUD.
- **Repository**: Define a interface para operações de acesso a dados do `Produto`.
- **View**: Utiliza Thymeleaf para renderizar páginas HTML dinâmicas.

### Dependências

- **Spring Boot Starter Thymeleaf**: Para renderizar as páginas HTML no lado do servidor.
- **Spring Boot Starter Web**: Para construção de aplicações web com Spring MVC.
- **Spring Boot Starter Data JPA**: Para interagir com o banco de dados usando JPA.
- **H2 Database**: Banco de dados em memória para testes.
- **Spring Boot Starter Test**: Para realizar testes unitários e de integração.
- **MySQL Connector/J**: Conector JDBC para o banco de dados MySQL.
- **Velocity**: Framework de template para gerar templates dinâmicos em Java.

## Como Rodar o Projeto

### Pré-requisitos

- Java 8 ou superior
- Maven
- Servidor MySQL (se desejar utilizar MySQL em vez do banco H2 para armazenamento persistente)

### Instruções

1. **Clone o Repositório**:
   ```bash
   git clone https://github.com/LuanaLinhares/CRUDProduto.git
   cd CRUDProduto

## Configuração do Banco de Dados MySQL:

Se você optar por usar o MySQL, configure suas credenciais no arquivo application.properties localizado em src/main/resources:
properties
Copiar
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

## Compilar e Executar o Projeto:

Use Maven para compilar e executar o projeto:
```
mvn spring-boot:run
```

## Acessar o Sistema:

Abra seu navegador e acesse: http://localhost:8080/produto/list para ver a lista de produtos.
Contribuição
Processo de Fork e Pull Request
Fork do Repositório:

Vá até o repositório no github.com

Clique no botão Fork no canto superior direito para criar uma cópia do repositório no seu GitHub.
Clone o Repositório Forked:

```
git clone https://github.com/seu-usuario/CRUDProduto.git
cd CRUDProduto
```

## Criação de Branches:

### Use a branch develop para novas funcionalidades.
### Use o prefixo test para branches focadas em testes.
### Use o prefixo fix para correções de bugs.

## Exemplos:

```
git checkout -b develop/nova-feature
git checkout -b test/nome-do-teste
git checkout -b fix/bug-descricao
```

## Realizar o Pull Request:

Após realizar suas alterações e comitá-las, envie as mudanças para o seu repositório forked:
```
git push origin nome-da-branch
```

Navegue até o repositório original no GitHub e clique em Compare & pull request.
Preencha o formulário com os detalhes da sua contribuição e clique em Create pull request.


## Nomenclatura de Branches

master: Branch principal. Deve sempre estar estável.
develop: Branch para desenvolvimento de novas funcionalidades.
test/: Prefixo para branches relacionadas a implementações e melhorias de testes.
fix/: Prefixo para branches destinadas a correções de bugs.

## Considerações Finais
Este projeto demonstra uma implementação básica de um sistema CRUD. Para mais informações sobre cada componente e como personalizá-los, consulte a documentação oficial do 
spring.io
.
