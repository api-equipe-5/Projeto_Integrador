<h1 align="center">
    <img alt="Gobarber" src="imagem/logo_fatecsjc.png" width="250px" />
</h1>

Este repositório é utilizado academicamente para a disciplina de Laboratório de Projeto de Bando de Dados V, ministrada pelo professor Eduardo Sakaue na FATEC São José dos Campos - Prof. Jessen Vidal.

<p align="center">
  <a href="#authors">Autores</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#about">Sobre</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#tech_utilizadas">Tecnologias utilizadas</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#installd">Tecnologias utilizadas</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#app">Acesso à aplicação</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#app">Planejamento</a>
</p>

<h1 align="center">
    <img alt="GoBarber" src="imagem/home.png" />
</h1>

## 📝 Sumário
- [Autores](#authors)
- [Sobre](#about)
- [Tecnologias utilizadas](#tech_utilizadas)
- [Tecnologias utilizadas](#install)
- [Acesso à aplicação](#app)
- [Planejamento](#app)
- [Links](#links)

## ✍️ Autores:  <a name = "authors"></a>
- <img src="imagem\linkedln.png" height=15px> [Daniel Willians Ignacio de Souza](https://www.linkedin.com/in/danielwisouza/)
- <img src="imagem\linkedln.png" height=15px> [Hercules Pereira da Silva](https://www.linkedin.com/in/hercules-pereira) 
- <img src="imagem\linkedln.png" height=15px> [Lucas Campioni Rodrigues Porto](https://www.linkedin.com/in/lucascampioni/) 
- <img src="imagem\linkedln.png" height=15px> [Jonathan Moreno Martins](https://www.linkedin.com/in/jonathanmmartins/) 
- <img src="imagem\linkedln.png" height=15px> [Victor Cardial De Menezes Pereira](https://www.linkedin.com/in/victor-cardial-de-menezes-pereira-67491018a/) 

## 🕵🏼 Sobre <a name = "about"></a>

Projeto de um sistema de uma produtora, onde é realizado os cadastros de atores, diretores, dublês, e diferentes categorias de filmes.

## ⛏️ Tecnologias utilizadas: [Documentação](https://github.com/herculespsilva/spring-boot-produtora/tree/master/docs/Tecnologias.md)
- [<img src="imagem\java.jpg" height=40px>](https://www.oracle.com/br/Java/) JAVA
- [<img src="imagem\mysql.png" height=40px>](https://www.mysql.com//) MySQL
- [<img src="imagem\maven.jpg" height=40px>](https://maven.apache.org/) Apache Maven
- [<img src="imagem\hibernate.png" height=40px>](https://hibernate.org/) Hibernate
- [<img src="imagem\spring.png" height=20px>](https://spring.io/) Spring
- [<img src="imagem\docker.png" height=40px>](https://www.docker.com/) Docker
- [<img src="imagem\portainer.io.png" height=40px>](https://www.zabbix.com/) Portainer.io
- [<img src="imagem\aws.png" height=40px>](https://aws.amazon.com/pt/) AWS
- [<img src="imagem\jenkins.png" height=40px>](https://www.jenkins.io/) Jenkins
- [<img src="imagem\zabbix.png" height=40px>](https://www.zabbix.com/) Zabbix

#  ⚙️ Instalação e execução  <a name = "tinstall"></a>
#### Pré-requisitos
```
Instalar o maven e o docker para execução do projeto.
```

##### Instalação
##### 1 - Clone o projeto para uma máquina local
```
git clone https://github.com/herculespsilva/spring-boot-produtora.git
```
##### 2 - Instale as dependências do projeto
```
mvn clean package
```
##### 3 - Iniciar a aplicação
```
docker-compose up
```
##### 4 - Rota padrão
```
localhost:8080/spring-app
```
##### 5 - Usuário administrador
```
User: admin Senha: 123
```

# 🗺️ Acesso aplicação <a name = "app"></a> 
- Servidor de Aplicação: ec2-3-135-222-234.us-east-2.compute.amazonaws.com
- Servidor Jenkins: ec2-3-135-222-234.us-east-2.compute.amazonaws.com
- Portainer.io: ec2-3-135-222-234.us-east-2.compute.amazonaws.com
- Zabbix : http://ec2-3-134-83-114.us-east-2.compute.amazonaws.com/zabbix/ -> U: Admin P: zabbix

# 📊 Planejamento <a name = "planejamento"></a>

<img src="imagem/Sprints.png" alt="Project logo"></a>
## Sprint 1 - [Documentação](https://github.com/herculespsilva/spring-boot-produtora/tree/master/docs/1entrega.md)
- Levantamento de requisitos, e Criação do DER *(Back-end)*
- Inicio da modelagem do banco de dados *(Back-end)*
- Refatoração da aplicação *(Back-end)*
- Implementação dos serviços do ambiente *(Back-end)*
- Mudanças no banco de dados *(Back-end)*
- wireframes das paginas *(Front-End)*

## Sprint 2 - [Documentação](https://github.com/herculespsilva/spring-boot-produtora/tree/master/docs/2entrega.md)
- REST com Spring *(Back-end)*
- Controllers e Métodos de acesso (get, post, put e delete) *(Back-end)*
- Formatação de JSON. CORS *(Back-end)*
- Criação de controllers responsaveis pelo login e autenticação *(Back-end)*
- Mudanças no banco de dados *(Back-end)*
- Pesquisa sobre plataforma Cerberon *(Pesquisa)*
- Implementação de Jenkins *(DevOps)*
- Gerenciador de logs do servidor *(DevOps)*
- Software de monitoramento - Métrica e Indicadores *(DevOps)* Parte 1

## Sprint 3 - [Documentação](https://github.com/herculespsilva/spring-boot-produtora/tree/master/docs/3entrega.md)
- Deploy (AWS) *(DevOps)*
- Gerenciador de pipeline *(DevOps)* 
- Configuração Docker (Preparação do ambiente)*(DevOps)*
- Segurança por token com JWT *(Back-end)*

## Sprint 4 - [Documentação](https://github.com/herculespsilva/spring-boot-produtora/tree/master/docs/4entrega.md)
- Software de monitoramento - Grafana Deploy Prometheus using Docker *(DevOps)* Parte 2 ( Vídeo: http://bit.ly/MonitorZabbix )
- Deploy automático (Jenkins with Docker Deploy AWS) ( Vídeo: http://bit.ly/AWS-AUTO-DEPLOY )
- Criação de front-end em Vue.js *(front-end)*
- Controle de estado com Vuex *(front-end)*
- Tratamento de erro em requisições (axios) *(Back-end)*

## Sprint 5 - [Documentação](https://github.com/herculespsilva/spring-boot-produtora/tree/master/docs/5entrega.md)
- Automatização de integração de testes *(DevOps)* 
- Divisão de ambiente (Teste/Produção) *(DevOps)* 
- Orquestador de deploy(portainer.io) *(DevOps)*
- Gestão de Mudanças Banco de Dados(liquibase) *(DevOps)*

## Sprint 6 - [Documentação](https://github.com/herculespsilva/spring-boot-produtora/tree/master/docs/6entrega.md)
- Ajustes e correções das ferramentas *(DevOps)*
- Conclusão da documentação
- Entrega funcional com exemplo
- Criação do vídeo explicando o projeto

# 💾 Links <a name = "links"></a>

- JAVA https://www.oracle.com/br/Java/
- MySQL https://www.mysql.com/
- Apache Maven https://maven.apache.org/
- Hibernate https://hibernate.org/
- Spring https://spring.io/
- Docker https://www.docker.com/
- Portainer.io https://www.zabbix.com/
- AWS https://aws.amazon.com/pt/
- Jenkins https://www.jenkins.io/ 
- Zabbix https://www.zabbix.com/
