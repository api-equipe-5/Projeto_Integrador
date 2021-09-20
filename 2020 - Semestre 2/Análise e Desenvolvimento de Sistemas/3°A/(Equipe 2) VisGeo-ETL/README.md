![ViaGeo - Capa](https://user-images.githubusercontent.com/56441371/93688444-5704dc80-fa9c-11ea-8bed-fdac35ce7337.png)

A **VisGEO** nasceu através da necessidade de resolução de um problema do cliente parceiro com a Fatec São José dos Campos - Prof. Jessen Vidal.

### - Disciplinas Integradas

- **Engenharia de Software**

    Prof. Me. José Walmir Gonçalves Duque

- **Interação Humano Computador**

    Prof. Me. Giuliano Araujo Bertoti

- **Programação Orientada a Objetos**

    Prof. Me. Gerson Penha Neto

- **Estrutura de Dados**

    Prof. Me. Fernando Masanori Ashikaga

### Time

- Evandro Braga - PO - [LinkedIn](https://www.linkedin.com/in/evandro-rodrigues-de-melo-braga-1aa677149/)
- José Danrley - Scrum Master - [LinkedIn](https://www.linkedin.com/in/jos%C3%A9-danrley-069827191/)
- Cristiane Rodrigues - DEV Team - [LinkedIn](https://www.linkedin.com/in/cristiane-rodrigues-20b3b61b2)
- Leonardo Messias  - DEV Team - [LinkedIn](https://www.linkedin.com/in/leonardo-messias-89568818a/)
- Luis Guilherme - DEV Team - [LinkedIn](https://www.linkedin.com/mwlite/in/luis-guilherme-a17b58185)
- Matheus Amauri - DEV Team - [LinkedIn](https://www.linkedin.com/in/matheus-campos-9b8550192)
- Pedro Mendonça - DEV Team - [LinkedIn](https://www.linkedin.com/in/pedro-mendon%C3%A7a-3a13541a4/)
- Raquel Ribeiro - DEV Team - [LinkedIn](https://www.linkedin.com/in/raquel-rodrigues-ribeiro-a9537818b)
- Washington Henrique - DEV Team - [LinkedIn](https://www.linkedin.com/in/justhenrique/)

### Objetivo

Desenvolver uma aplicação web, com uma ferramenta ETL de baixo custo.

### O Projeto

O Projeto consiste no desenvolvimento de um sistema web ETL¹ no qual dados georreferenciados serão extraídos de shapefiles², transformados e carregados em banco de dados geográfico³, no caso atual, PostGis. Assim como o processo inverso.

### Requisitos Funcionais

- Carga de dados geográficos (ponto, linha e polígono) e seus atributos alfanuméricos em tabelas existentes de banco de dados geográficos.
- Recuperação de dados geográficos (ponto, linha e polígono) e seus atributos alfanuméricos armazenados em banco de dados geográficos.

### Requisitos Não Funcionais:

- Banco de Dados Geográficos PostGIS;
- Documentações.

### Backlog do Projeto

![Cards](https://user-images.githubusercontent.com/56441371/98672721-ff188280-2334-11eb-9050-4b434acba3a4.png)

### Tecnologias Utilizadas

![VisGeo - Techs](https://user-images.githubusercontent.com/56441371/93688825-3c803280-fa9f-11ea-9408-bd07d27aad71.png)

- De acordo com os requisitos não funcionais levantados e alinhamento com nosso cliente, optamos por utilizar Java no CRUD de usuários.
- A  API que trata do processo ETL foi desenvolvida em Python, com auxílio do Framework Flask, e das bibliotecas PyShp e postgresql.
- O front-end foi desenvolvido com React usando as bibliotecas Ant Design, Axios, Bootstrap, React-Bootstrap, React Icons e StyledComponents.
- Os arquivos shapefiles são carregados em Banco de Dados Postgres, utilizando a extensão para arquivos geográficos, PostGis.


### Entregas

[Sprint 1 - ](https://github.com/JDanrley/VisGeo-ETL/tree/master/Sprints%20-%20Entregas/Sprint%201) 14/09/2020 a 20/09/2020

[Sprint 2 - ](https://github.com/JDanrley/VisGeo-ETL/tree/master/Sprints%20-%20Entregas/Sprint%202) 12/10/2020 a 18/10/2020

[Sprint 3 - ](https://github.com/JDanrley/VisGeo-ETL/tree/master/Sprints%20-%20Entregas/Sprint%203) 02/11/2020 a 08/11/2020

[Sprint 4 - ](https://github.com/JDanrley/VisGeo-ETL/tree/master/Sprints%20-%20Entregas/Sprint%204) 23/11/2020 a 29/11/2020


### Requisitos necessários para o funcionamento do software

- **Python 3** ou superior;
- Gerenciador de pacotes **Pip3**;
- **NODEJS 12.18.0v** ou superior;
- Gerenciador de pacotes **npm** ou **yarn**;
- Framework **Flask**;
- Bibliotecas back-end **PyShp, postgresql, cors**.
- Bibliotecas front-end **ReactJS, Ant Design, Axios, Bootstrap, React-Bootstrap, React Icons e StyledComponents**.

**Instalação em ambientes Linux**

- Basta instalar o **pip3**, pois o **Python3** já vem instalado por padrão.
- Para isso, basta executar o comando abaixo:

```
$ sudo apt install pip3
```

**Nodejs**


**Using Ubuntu**
```
curl -sL https://deb.nodesource.com/setup_12.x | sudo -E bash -
sudo apt-get install -y nodejs
```

**Using Debian, as root**
```
curl -sL https://deb.nodesource.com/setup_12.x | bash -
apt-get install -y nodejs
```

**Máquina Virtual**

- Para instalar a Virtualenv, basta executar:

```
$ pip3 install virtualenv
```

- Para criar a Virtualenv do projeto, execute:

```
$ virtualenv -p python3 venv
```

- Para iniciar a Virtualenv:
```
$ source venv/bin/activate
```

- Após iniciá-lo, instale as dependências do back-end, que incluem o framework e as bibliotecas necessárias para funcionamento da API.

```
$ cd backend

$ venv/bin/pip3 install -r requirements.txt
```

- Por último instale as dependências do front-end, que também incluem todas as bibliotecas necessárias.

```
$ cd frontend

$ npm install ou yarn
```

- Para iniciar os servidores, execute:


- Front-end:

```
$ yarn start
```

- Back-end:

```
$ python3 run.py
```

- Cadastro e login:
```
$ yarn dev
```

**Instalação em ambientes Windows**

- Basta instalar o **Python3**, pois o **pip3** já virá instalado por padrão juntamente com o **Python**.
- Para isso, acesse o site abaixo e baixe a versão para seu Sistema Operacional:

https://www.python.org/downloads/


**Nodejs**

- Acesse o site abaixo e baixe a versão para seu Sistema Operacional:

https://nodejs.org/en/download/


**Máquina Virtual**

- Para instalar a Virtualenv, basta executar:

```
$ pip3 install virtualenv
```

- Para criar a Virtualenv do projeto, execute:

```
$ virtualenv -p python3 venv
```

- Para iniciar a Virtualenv:
```
$ source venv/bin/activate
```


- Após iniciá-lo, instale as dependências do back-end, que incluem o framework e as bibliotecas necessárias para funcionamento da API.

```
$ cd backend

$ venv/bin/pip3 install -r requirements.txt
```

- Por último instale as dependências do front-end, que também incluem todas as bibliotecas necessárias.

```
$ cd frontend

$ npm install ou yarn
```

- Para iniciar os servidores, execute:

- Front-end:

```
$ yarn start
```

- Back-end:

```
$ python3 run.py
```

- Cadastro e login:
```
$ yarn dev
```

### Definições

¹ ETL - Vem do inglês Extract, Transform and Load (Extrair, transformar e carregar), consiste em um processo de direção dos dados até o armazenamento. A ele corresponde as ações de extração, tratamento e inserção na base de dados.

² Shapefiles – É um formato de armazenamento de dados vetoriais, formado por aqrquivos com múltiplas extensões. Pode armazenar geometria do tipo ponto, polígono ou linha. No shapefile três arquivos são obrigatórios e devem estar na mesma pasta, ter o mesmo nome; estes arquivos são diferentes entre si por conta de sua extensão, sendo elas .dbf, .shp e .shx. Já os arquivos com extensão .cpg e .prj são facultativos.

- .shp – geometria da operação
- .shx – índice da geometria do recurso
- .dbf – informações de atributo
- .prj - sistema de coordenadas e informações de projeção
- .cpg - descreve um conjunto de caracteres para exibir texto

³ Banco de dados relacional
É um tipo de banco de dados que armazena e fornece acesso a pontos de dados relacionados entre si, de modo intuitivo e direto.
