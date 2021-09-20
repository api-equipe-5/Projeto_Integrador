
O Banco de Dados foi realizado em um Docker contendo PostgreSQL PGAdmin:

Para instalação e configuração seguir o [Tutorial](https://renatogroffe.medium.com/postgresql-pgadmin-4-docker-compose-montando-rapidamente-um-ambiente-para-uso-55a2ab230b89)


No Terminal
```
docker-compose up -d

```

Após acessar o Banco:

1. Criar a Base de Dados e as Tabelas seguindo o [Modelo](https://github.com/RodrigoMarcelin/safe_share/blob/master/bd/modelo.sql).
2. Popular o Banco com os [dados](https://github.com/RodrigoMarcelin/safe_share/blob/master/bd/data.sql) de teste.
3. Criar o [trigger](https://github.com/RodrigoMarcelin/safe_share/blob/master/bd/trigger.sql) para obtenção do log.
