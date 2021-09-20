# LMS - Guia Instalação

## Índice
  - [Dependências](#dependências)
  - [Instalação Utilizando Docker (Recomendado)](#instalação-utilizando-docker-recomendado)
  - [Instalação Local (Não Recomendado)](#instalação-local-não-recomendado)

## Dependências
- Ruby -> 3.0.0
- Rails -> 6.0.3
- Postgres -> 13

## Instalação Utilizando Docker (Recomendado)
Utilizamos o Docker para ter maior praticidade e isolar o ambiente de desenvolvimento. Para instalar o Docker basta seguir a [documentação oficial](https://docs.docker.com/get-docker/)

Com o docker instalado clone o projeto
```
$ git clone git@github.com:EquipeJerso/learning_management_system.git
```

Na pasta clonada basta executar o comando `docker-compose up` para buildar o projeto e subir os containers.
Com o projeto de pé é necessário fazer o setup do banco de dados com os seguintes comandos:
```
$ docker exec -it lms bash
$ rails db:setup
```
ou
```
$ docker exec -it lms rails db:setup
```

Este comando irá criar e popular o banco de dados com o conteúdo do `seeds.rb`.

Agora é possível acessar o `localhost:3000` e se logar com o e-mail `admin@admin.com` e password `123456`.

Sempre que necessário pode acessar o continer com `docker exec -it lms bash` e, por exemplo, acessar o rails console com `rails c`

## Instalação Local (Não recomendado)
⚠️ O que faz aqui? Já avisamos que não é recomendado! ⚠️


Este tutorial não ensinará o processo de instalação de dependências, utilize o Google para isto.

Com todas as dependências instaladas é necessário clonar o projeto
```
$ git clone git@github.com:EquipeJerso/learning_management_system.git
```

Na pasta do projeto execute `bundle install` para realizar a instalação das gems necessárias para execução do mesmo.

O `database.yml` foi criado com a utilização de variáveis de ambiente, crie um arquivo `.env` e popule com as seguintes envvars:
```
DB_HOST=host_do_seu_banco
DB_USER=usuario_do_seu_banco
DB_PASS=senha_do_seu_banco
DB_DEV=nome_banco_de_desenvolvimento
DB_TEST=nome_banco_de_teste
```

Tendo realizado a configuração das variáveis de ambiente podemos seguir com a migração do banco, para isso execute:
```
$ bundle exec rails db:setup
```

Após realizada a migração do banco podemos subir o servidor com `$ rails s` e acessar o `localhost:3000` ou acessar o rails console com `$ rails c`.

Com o migração do banco foi criado um usuário Admin com as credênciais `admin@admin.com` e `123456`

## Troubleshooting
🚧 WIP 🚧
