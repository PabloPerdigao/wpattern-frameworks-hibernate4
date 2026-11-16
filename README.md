# WPattern Frameworks Hibernate

Projeto desenvolvido em Java utilizando Hibernate 4, JPA, Maven e PostgreSQL, com o objetivo de estudar e aplicar conceitos de persistência de dados, mapeamento objeto-relacional (ORM) e operações CRUD.

## Tecnologias utilizadas

- Java 7
- Maven 3.8.9
- Hibernate 4.3.5.Final
- JPA 2.1
- PostgreSQL
- JDBC

## Pré-requisitos

Antes de executar o projeto, certifique-se de possuir:

- JDK 7 instalado.
- Maven instalado e configurado.
- PostgreSQL instalado.
- IntelliJ IDEA ou outra IDE compatível com a configuração de variáveis de ambiente.

## Configuração do banco de dados

O projeto utiliza variáveis de ambiente para armazenar as credenciais de conexão com o PostgreSQL.

Antes de executar a aplicação, configure as seguintes variáveis de ambiente na IDE:

| Variável | Descrição | Exemplo                         |
|---|---|---------------------------------|
| `DB_HOST` | Endereço do servidor | `localhost`                     |
| `DB_PORT` | Porta do PostgreSQL | `5432`                          |
| `DB_NAME` | Nome do banco de dados | `wpattern_frameworks_hibernate` |
| `DB_USER` | Usuário do banco | Seu usuário                     |
| `DB_PASSWORD` | Senha do banco | Sua senha                       |

### Configuração no IntelliJ IDEA

1. Abra o projeto no IntelliJ IDEA.
2. Acesse **Run → Edit Configurations**.
3. Selecione a configuração de execução da classe principal `Main`.
4. Localize o campo **Environment variables**.
5. Clique no ícone de edição e adicione as cinco variáveis necessárias, utilizando os nomes e valores indicados anteriormente.
6. Salve as alterações e execute a aplicação.

**Importante:** utilize as credenciais do seu próprio ambiente. As variáveis devem ser configuradas individualmente na IDE e não devem ser compartilhadas ou publicadas no repositório.

### Criação e configuração do banco de dados

O projeto utiliza PostgreSQL como sistema gerenciador de banco de dados.

Para preparar o ambiente, siga as etapas:

1. Crie um banco de dados chamado `wpattern_frameworks_hibernate`.
2. Acesse a pasta `database/` do projeto.
3. Execute o script `01-create-schema.sql` para criar as tabelas, chaves e sequências.
4. Execute o script `02-seed-data.sql` para inserir os dados iniciais utilizados nas operações e consultas do projeto.

Os scripts devem ser executados nessa ordem e apenas uma vez em um banco de dados vazio.

**Estrutura da pasta:**

- `01-create-schema.sql`: criação da estrutura do banco de dados.
- `02-seed-data.sql`: inserção dos registros iniciais e sincronização das sequências.

Após a configuração do banco, configure as variáveis de ambiente no IntelliJ IDEA conforme as instruções deste README.

## Como executar o projeto

Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

Entre na pasta do projeto:

```bash
cd wpattern-frameworks-hibernate
```

Abra o projeto no IntelliJ IDEA, configure as variáveis de ambiente conforme as instruções anteriores e atualize as dependências do Maven.

Para compilar o projeto, execute:

```bash
mvn clean compile
```

Por fim, execute a classe principal `Main` pela IDE.

## Segurança

As credenciais do banco de dados são obtidas por meio de variáveis de ambiente configuradas na IDE e não são armazenadas diretamente no código-fonte.
