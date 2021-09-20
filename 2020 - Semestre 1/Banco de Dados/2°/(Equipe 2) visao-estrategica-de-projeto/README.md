  

# Projeto Integrador - 2º BD

<br>

  

# Disciplinas

  

- Lab. Desevolvimento BD II - Profº Adriana da Silva <br>

  

- Engenharia de Software - Profº Giuliano Bertoti <br>

  

- Arquitetura e Modelagem de Banco de Dados - Profº Emanuel Mineda <br>

  

- Fundamentos de Gestao de Pessoas - Profº Valter Joao <br>

  

- Planejamento Estrategico - Profº Valter Joao <br>

  

- Linguagem de Programacao - Profº Adriana da Silva <br>

  

- Fundamentos de Calculo - Profº Dercy Felix <br>

  

  

# Integrantes:

  

  

:computer: Igor Carvalho <br>

  

:computer: Perilo <br>

  

:computer: Vinícius Fernandes<br>

  

:computer: Vinícius de Sousa<br>

  

  

# :pineapple: Pineapple

  

  

Pineapple é um sistema que será capaz de gerenciar as tarefas e atividades de funcionários dentro de uma empresa, utilizando do diagrama de Gantt que dará uma visão geral e ampla do cronograma de atividades para quem deseja gerenciar o planejamento de sua equipe.

  
  

## :x: Problema

  

  

Existem diversas ferramentas que utilizam o diagrama de Gantt no mercado, porém, por serem muito complexas alguns usuários acabam por não utilizarem a ferramenta e optam por outras alternativas que não são tão eficazes.
  

  

# Requisitos do Projeto

  

  

"Requisito é algo que foi requerido, uma condição a ser atendida para satisfazer uma necessidade."(Escritório de projetos, 2018).<br>

  

A atividade de levantamento de requisitos tem como objetivo a listagem de todas as ações e qualidades que o cliente deseja.<br>

  

Os requisitos podem ser divididos em dois tópicos, os Funcionais e Não Funcionais.

  

  

## Funcionais
Os requisitos funcionais representam o que o software faz, em termos de tarefas e serviços.

### Story Cards

####  1ª Entrega

- Listagem dos requisitos que o cliente deseja no projeto

- Criação da primeira versão do layout da aplicação

- O gerente do projeto pode visualizar um diagrama Gantt com informações básicas das tarefas que estão sendo desenvolidas em um determinado projeto. Estas informações básicas são: nome da tarefa, duração e interdependência entre tarefas (de forma estática por enquanto).

- Ao passar mouse sobre cada tarefa, o gerente de projetos pode ver informações detalhadas como a % do andamento da tarefa e os recursos (de forma estática por enquanto).

  

####  2ª Entrega

- O usuário poderá, cadastrar, atualizar, visualizar e deletar dados relacionados a pessoas cadastradas.

- O usuário poderá, cadastrar, atualizar, visualizar e deletar dados relacionados a projetos cadastrados.

- O usuário poderá, cadastrar, atualizar, visualizar e deletar dados relacionados a tarefas cadastrados.

  

####  3ª Entrega

- O usuário poderá ver as informações cadastradas no gráfico.

- O usuário poderá adicionar tarefas a um projeto

- O usuário poderá cadastrar e remover funcionários do projeto

- O usuário poderá atrelar um funcionário cadastrado no projeto para uma tarefa do mesmo

- O usuário poderá manipular o planejamento das tarefas do projeto através do gráfico, editando em formlário


####  4° Entrega

- O usuário poderá manipular o planejamento das tarefas do projeto através do gráfico, clicando e arrastando

- O gráfico poderá ser manipulado onde o usuário podera esconder as colunas do gráfico que não deseja ver

- O usuário poderá definir dependências de tarefas

- O usuário poderá salvar no sistema as alterações que fizer no gráfico
  

####  5º Entrega

- Manutenção de bugs reportados em entregas passadas

### Diagrama de caso e uso

<div align="left">
    <img src="https://gitlab.com/perilojunior68/visao-estrategica-de-projeto/-/wikis/uploads/8c385fbaaa93df451256d8088d54ab67/UML.jpeg" width="640" />
    <div height="480"></div>
</div>

## Requisitos não Funcionais
Requisitos não funcionais são os requisitos relacionados ao uso da aplicação em termos de desempenho, usabilidade, disponibilidade, portabilidade e tecnologias envolvidas

  -  __Disponibilidade:__ O sistema deverá ser acessado por todos e a qualquer momento <br>

-  __Usabilidade:__ Toda a estrutura do projeto será pensada para que o sistema seja de fácil utilização e que esteja bem intuitivo, detalhes como cores e estrutura da página estão sendo planejadas para maior usabilidade. <br>

-  __Desempenho:__ O projeto como um todo deverá ser rápido para que não diminua a produtividade de quem ira gerir os gráficos <br>

-  __Portabilidade:__ Para que seja utilizado em diversas plataformas, o projeto deverá funcionar em diversos dispositivos <br>

 ### Backlog
- A prioridade das tarefas serão dadas pelo gráfico abaixo, sendo a tarefa mais importante representada com o menor número e a que deixaremos para entregas futuras o número 5. Cada Sprint representa um número na prioridade.

|Id de tarefa|Nome|Descrição|Prioridade
|---|---|---|---|
| RF001 | Criação de interface | Primeira versão da interface do projeto| 1
| RF002 | Gerenciamento de funcionários | Permitir o cadastro, alteração e exclusão de funcionários.| 2
| RF003 | Gerenciamento de projeto | Permitir o cadastro, alteração e exclusão de projetos.| 2
| RF004 | Gerenciamento de tarefas | Permitir o cadastro, alteração e exclusão de tarefas associadas a projetos.| 3
| RF005 | Associar tarefa, projeto e funcionário | Atualizar a tarefa com funcionário vinculado.| 3
| RF006 | Mostrar projetos no diagrama de Gantt | Permitir visibilidade dinâmica para os projetos cadastrados.|3
| RF007 | Alteração de prazos pelo gráfico (alpha) | Permite a edição de uma atividade ao clicar no projeto.| 3
| RF008 | Salvamento via .jpg da tela do gráfico | Permite salvar uma cópia das modificações do projeto.| 3
| RF009 | Desconsiderar dias não úteis | No diagrama, dias não úteis serão desconsiderados.| 4
| RF010 | As tarefas terão dependências de outras | Possibilita níveis e prioridades de tarefas no projeto.| 4
| RF010 | Considerar carga e peso de trabalho | Permite a exclusão de um perfil de programador do sistema.| 5
| RF011 | Pesquisar por projeto, funcionário e tarefa na interface | Pesquisa através de um formulário de itens cadastrados.| 5

### Heurísticas

 - __Estética e design minimalista__
Nosso projeto adota uma estética onde apenas o que é de interesse do usuário aparecerá, evitando assim poluição na hora da utilização da aplicação.
- __Consistência e Uso de padrões__
  Para que o sistema seja confortável e possa ser utilizado com facilidade, adotamos uma padronização em todas as páginas.
 - __Prevenção de erros__
Estamos utilizando em nosso projeto um sistema onde evitará possíveis erros de uso do usuário, atrelado à um design minimalista e com padrões adotados, o usuário dificilmente errará na utilização de nosso sistema.

### Principais páginas
- Página principal

<div align="left">
    <img src="https://gitlab.com/perilojunior68/visao-estrategica-de-projeto/-/wikis/uploads/921a6c0031ade772b75c86b643c34502/i1__1_.png" width="640" />
    <div height="480"></div>
</div>


- Página de cadastro de funcionário

<div align="left">
    <img src="https://gitlab.com/perilojunior68/visao-estrategica-de-projeto/-/wikis/uploads/6fd3131a915b0d43dd45be3448b05a6f/i2__1_.png" width="640" />
    <div height="480"></div>
</div>


- Página de cadastro de projeto

<div align="left">
    <img src="https://gitlab.com/perilojunior68/visao-estrategica-de-projeto/-/wikis/uploads/3beb42bc75acf3846c1111ff7d7c0b3f/33.png" width="640" />
    <div height="480"></div>
</div>


- Página de cadastro de tarefas

<div align="left">
    <img src="https://gitlab.com/perilojunior68/visao-estrategica-de-projeto/-/wikis/uploads/2eb72a4ed7c0624418199df9f7fb8791/i4.png" width="640" />
    <div height="480"></div>
</div>


### Valor agregado 💸

  

  

O sistema tem como objetivo propiciar uma visão de projeto e satisfação pessoal ao usuário, auxiliando no planejamento de atividades de sua equipe, permitindo que o mesmo consiga se planejar de maneira fácil e intuitiva através de uma página na WEB.

  

  

### O que estamos utilizando? :thinking:

  
Como o objetivo do sistema é ser uma página WEB, estamos utilizando da linguagem de marcação HTML e para a estilização da mesma estamos utilizando CSS com eventos em JavaScript.<br>

Para o gerenciamento de informações do site estamos utilizando a linguagem de programação Java.

#### Apresentação do protótipo
 - https://youtu.be/MTuKAnL-SPk
#### Apresentação entrega 3
 - https://www.youtube.com/watch?v=9eeRtMzRgNk
#### Apresentação entrega 4
 - https://www.youtube.com/watch?v=9w4sPRoX_cY&
#### Apresentação entrega 5
 - https://www.youtube.com/watch?v=6l7kA4-Q49U
#### Apresentação entrega final
 - https://www.youtube.com/watch?v=_gihdsJWg50&feature=youtu.be