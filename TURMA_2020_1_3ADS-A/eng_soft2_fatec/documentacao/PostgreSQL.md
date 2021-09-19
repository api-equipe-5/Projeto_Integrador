# Como Instalar PostgreSQL

## Passo 1 - Instalando PostgreSQL

	$ sudo apt update
	$ sudo apt install postgresql postgresql-contrib

## Passo 2 - Criando um Banco de Dados - Caso não esteja utilizando DOCKER

Primeiro, deve-se acessar o postgresql

	$ sudo su postgres

> É provável que o terminal peça para entra com a senha de sudo

Vai ficar da seguinte forma, seu usuário passará a ser o usuário "postgres"

postgres@<nome_do_computador>: /home/<nome_de_usuario>/...

Então, digite para entrar no gerenciador do postgres:

	$ psql

Você saberá que está dentro do banco quando seu terminal ficar da seguinte forma:

	psql (10.12 (Ubuntu 10.12-0ubuntu0.18.04.1))
	Type "help" for help.

	postgres=# 


Em seguida, digite:

	postgres=# CREATE DATABASE project_db;


OBS: pode ser que seja preciso alterar a senha do postgres (as vezes a senha padrão não é postgres)

	postgres=# \password postgres;