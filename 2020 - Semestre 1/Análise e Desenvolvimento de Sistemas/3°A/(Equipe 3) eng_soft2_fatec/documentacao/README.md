# Aqui será colocada toda a documentação referente ao projeto

### PostgreSQL.md
### Docker.md
### Pdf's de entregas

### Orientações para os devs

Como rodar a aplicação? 

1. Criar um ambiente virtual:

    > $ pip install virtualenv

    > $ mkvirtualenv <nome_do_ambiente_virtual> Ex: mkvirtualenv project

2. Navegar até a pasta do ambiente virtual, no caso "$ cd project/bin/", nesta pasta ativar o virtualenv com o comando "activate"

3. Com o ambiente virtual criado, entrar na pasta de destino da aplicação que você queira deixá-lo e fazer o clone da aplicação que está no github.

    > $ git clone --single-branch --branch homologacao git@github.com:eduardoquerido/eng_soft2_fatec.git 

4. Com o ambiente virtual ativado, instalar os requirements do projeto

    > $ pip install -r requirement.txt (no caso, o projeto terá mais de um requirement, por tanto, provavelmente mudando para dev.txt que irá puxar de um base.txt e um production.txt que também puxará do base)

#### Obs: Posteriormente será criado uma imagem Docker para facilitar os passos anteriores

5. Feito isso, teste a aplicação com:

    > $ python3 manage.py runserver --settings project.settings.local_dev



============================================================================================================================================================================


## Rodando com docker-compose

#### Fica-se subentendido que já está com docker e docker-compose tudo instalado
##### Caso contrário vá até eng_soft2_fatec/documentacao e encontre o arquivo Docker.md

Encontre o arquivo docker-compose.yml

    No diretório padrão ele encontra-se em:

    $ /eng_soft2_fatec/docker-compose.yml

Rode a aplicação com:

    $ docker-compose up --build 
