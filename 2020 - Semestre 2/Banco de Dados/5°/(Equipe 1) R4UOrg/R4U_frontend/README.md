## Laboratório de Projeto de Banco de Dados

### Integrantes:
  
Scrum Master:  
  [Ana Carolina S. de Moura](https://www.linkedin.com/in/ana-carolina-simplicio-de-moura-84bb49148/)  
    
P.O:  
  [Maria Clara Oliveira](https://www.linkedin.com/in/oliveira-mclaraa/)  
    
Dev Team:  
  [André Pires](https://www.linkedin.com/in/andr%C3%A9-pires-87558919b/)  
  [Bruno G. D. Faria](https://www.linkedin.com/in/bruno-dionisio-6134451a7/)  
  [Fernando T. de Castro](https://www.linkedin.com/in/ftcastro/)  
  [Gilberto Costa Jr.](https://www.linkedin.com/in/gilberto-costa-b8b988161/)  
  [Wesley Vinicius Silva](https://www.linkedin.com/in/wesley-vinicius-silva-8568a516b/)

- Introdução do projeto

  - Nosso projeto consiste numa API que se utiliza Inteligência Artificial para fazer interações com uma base de dados preexistente (IMDB).

- Objetivos

  - O objetivo central do projeto é fazer recomendações inteligentes de filmes baseado no perfil individual de cada usuário.
  - A disciplina tem como objetivo o estudo do DevOps a partir da implementação das práticas no projeto.

- Tecnologias utilizadas

  - Python - Escolhemos trabalhar com a linguagem de programação Python devido à sua grande popularidade em sistemas que utilizam Inteligência Artificial. Um outro motivo para a escolha do Python foi visando uma maior integração com os alunos do primeiro semestre, uma vez que muitos deles estão tendo contato com a programação pela primeira vez e isso ajudaria a dar um melhor suporte para eventuais dúvidas.
  - Flask - Várias funcionalidades úteis na aplicação com Python, sendo a principal delas as rotas de acesso.
  - Fuzzy - Biblioteca de Inteligência Artificial que permitiu fazer as análises e recomendações.
  - Postgresql - Banco de dados relacional que guarda a massa de filmes.
  - SQLAlchemy - Comunicação do Python com o Postgresql.
  - Docker - Foi utilizado visando eliminar qualquer problema de incompatibilidade entre os membros da equipe, pois o projeto fica exatamente igual para todos independentemente de onde ele é acessado.
  - Cloud AWS - Utilizado para hospedar e disponibilizar a API online para o cliente.
  - Sistemas de versionamento de código - Git e Github para uma melhor integração e organização dos códigos da disciplina.
  - Github Projects - Organização e controle de tasks pelo Scrum Master e PO e acesso claro de prazos e requisitos pelos outros membros da equipe.
  - Robot - Biblioteca de testes para Python.
  
### Quick Start

**Setup do projeto**
```
npm install
```

**Compila para desenvolvimento**
```
npm run serve
```

**Compila e builda para produção**
```
npm run build
```

### Cronograma de entregas

- [x] **Sprint 1** - Cloud & Database Automation
- [X] **Sprint 2** - CI
- [X] **Sprint 3** - Testing
- [X] **Sprint 4** - Integração Testing & CI
- [X] **Sprint 5** - Deploy Automático de Frontend
- [X] **Sprint 6** - Testes Frontend

------------



### Primeira entrega - Sprint 1 (Cloud & Database Automation)

- FlyWay como database automation;
- Deploy do código backend para a Cloud AWS;
- Configuração do nginx para uso posterior;

### Segunda entrega - Sprint 2 (CI)

- Deploy configurado com Jenkins para pipeline e AWS Code Deploy para deploy de código ao servidor;
- Primeira versão do frontend com layout estático;
- Mudanças na arquitetura do backend para acomodar o front;

### Terceira entrega - Sprint 3 (Testing)

- Configuração do PyTests no projeto;
- Criação de testes de integração;
- Otimizações no backend para melhor performance junto da API do IMDB;
- Segunda versão do frontend com layout melhorado;

### Quarta entrega - Sprint 4 (Integração Testing & CI)

- Alterações no docker-compose em preparo para separação de ambientes;
- Separação de ambientes em "Test" e "Production", permitindo que o desenvolvedor tenha um ambiente seguro para desenvolver e testar a aplicação sem acidentalmente interferir na aplicação sendo servida;
- Utilização do FlyWay para criação de um schema com dados pré-definidos para ser usado no ambiente de testes;
- Troca do PyTests por Robot para melhor execução dos testes de integração;
- Integração dos testes e deploy do ambiente de testes na pipeline Jenkins;

#### Vídeo de Apresentação da Entrega

https://drive.google.com/file/d/17PsqBPnBGSps0Zv4Hh_iG-TAsI4xWZZ6

### Quinta entrega - Sprint 5 (Deploy Automático de Frontend)

Houveram imprevistos nesta sprint devido a uma exclusão acidental de nossas duas máquinas na AWS, devido a isso a entrega foi renegociada para o deploy automático de front-end, deixando os testes de interface para depois.

- Recriação das duas máquinas da AWS a partir de imagens da Sprint 3;
- Configuração de proteção contra exclusão acidental de máquinas na AWS;
- Reconfiguração do CI com a separação de ambientes e os testes de backend;
- Alteraçes no frontend com a adição do Axios para fazer requests para o backend;
- Deploy automatizado do frontend utilizando Jenkins e AWS Code Deploy;

### Sexta entrega - Sprint 6 (Testes de Frontend)

- Desenvolvimento do teste de frontend, testando tanto interface quanto conexão com o backend. Testes desenvolvidos com Selenium em conjunto com Robot Framework, o teste navega pela página e realiza o clique para então comparar o resultado dado na tela com os registros do banco de dados;
- Integração do teste na pipeline de frontend, fazendo com que o deploy seja interrompido caso haja alguma falha com o teste rodado;
- Adição do step de merge do código na branch master e deploy para máquina produção na pipeline responsável pelo frontend;
