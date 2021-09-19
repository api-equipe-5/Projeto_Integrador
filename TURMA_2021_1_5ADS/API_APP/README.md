# Api Analytic


### Requisitos:

```
Python 3.9
Postgres
git

```

### Primeiros passos:

```
Navegue até a pasta onde quer clonar o projeto pelo cmd
execute: git clone https://github.com/2021-FATEC-API-GRUPO-01/API_APP
execute: pip install -r requirements.txt
```

### Segunda etapa: 

```
Na pasta raiz abra o arquivo config.py onde encontrará uma linha como está SQLALCHEMY_DATABASE_URI = "postgresql+psycopg2://postgres:123@localhost:5432/spc"
altere o usuário e a senha para as credenciais do seu banco Postgres
Crie um schema em seu banco no qual inseriu as credenciais, utilize o nome de spc


```
### Terceira etapa(popular o schema com tables e column): 

```
Vá até a pasta raiz do projeto pelo cmd e entre no psql
No psql execute o comando psql -U nome_usuario -d spc -f spc.sql

```

### Etapa final: 

```
Execute: python run.py db stamp head
Execute: python run.py db migrate
Execute: python run.py db upgrade
Crie um usuário com id 0 na tabela users
Execute: python run.py runserver
Após isso navegue até o localhost pelo navegador na página index: http://localhost:5000

```

