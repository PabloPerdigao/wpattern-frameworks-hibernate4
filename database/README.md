# Scripts do banco de dados

Os scripts desta pasta preparam o banco PostgreSQL utilizado pelo projeto.

## Ordem de execucao

Execute os arquivos nesta ordem, em um banco de dados vazio:

1. `01-create-schema.sql`: cria sequencias, tabelas, chaves primarias e relacionamentos.
2. `02-seed-data.sql`: insere os dados iniciais e sincroniza as sequencias com os IDs inseridos.

## Banco esperado

Nome: `wpattern_frameworks_hibernate`

Crie primeiro esse banco no PostgreSQL. Depois, conecte-se a ele pelo DBeaver ou outra ferramenta e execute os dois scripts.

## Observacoes

- Os scripts foram preparados para uma primeira instalacao em banco vazio.
- Execute `02-seed-data.sql` apenas uma vez. Uma nova execucao causara conflitos de chave primaria.
- As sequencias de `categories`, `products` e `orders` ja sao criadas e associadas as colunas no primeiro script.
- `order_details` utiliza chave primaria composta (`order_id`, `product_id`) e nao possui sequencia propria.
