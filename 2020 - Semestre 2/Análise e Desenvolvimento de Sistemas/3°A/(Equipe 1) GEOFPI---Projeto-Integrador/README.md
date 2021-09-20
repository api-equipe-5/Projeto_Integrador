
<img src="https://github.com/marciosousa4/GEOFPI---Projeto-Integrador/blob/master/Loading%20images/Simples%20Espa%C3%A7o.png?raw=true" width="900" height="500"/>


## Dev Team

* Márcio Geraldo de Sousa (Product Owner)

#### [Linked](https://www.linkedin.com/in/marciosousa4/)<img src="https://raw.githubusercontent.com/marciosousa4/GEOFPI---Projeto-Integrador/master/Loading%20images/download.png" width="15" height="15" /> [Github](https://github.com/marciosousa4)<img src="https://raw.githubusercontent.com/marciosousa4/GEOFPI---Projeto-Integrador/master/Loading%20images/GitHub-Mark.png" width="20" height="20" />



* Fernanda Corrente Marques (Scrum Master)
#### [Linked](https://www.linkedin.com/in/fernanda-marques-591a7078/)<img src="https://raw.githubusercontent.com/marciosousa4/GEOFPI---Projeto-Integrador/master/Loading%20images/download.png" width="15" height="15" /> [Github](https://github.com/fernandamarques-hub)<img src="https://raw.githubusercontent.com/marciosousa4/GEOFPI---Projeto-Integrador/master/Loading%20images/GitHub-Mark.png" width="20" height="20" />


* Jodan Lima Galas (Dev Team)

#### [Linked](https://www.linkedin.com/in/jodan-lima-galas-3a7782183/)<img src="https://raw.githubusercontent.com/marciosousa4/GEOFPI---Projeto-Integrador/master/Loading%20images/download.png" width="15" height="15" /> [Github](https://github.com/JodanGalas)<img src="https://raw.githubusercontent.com/marciosousa4/GEOFPI---Projeto-Integrador/master/Loading%20images/GitHub-Mark.png" width="20" height="20" />


* Fabrício Cursino dos Santos (Dev Team)
#### [Linked](https://www.linkedin.com/in/fabr%C3%ADcio-cursino/)<img src="https://raw.githubusercontent.com/marciosousa4/GEOFPI---Projeto-Integrador/master/Loading%20images/download.png" width="15" height="15" /> [Github](https://github.com/fcursino)<img src="https://raw.githubusercontent.com/marciosousa4/GEOFPI---Projeto-Integrador/master/Loading%20images/GitHub-Mark.png" width="20" height="20" />


* Edson Brendon de Oliveira (Dev Team)
#### [Linked](https://www.linkedin.com/in/edson-oliveira-b995b513b/)<img src="https://raw.githubusercontent.com/marciosousa4/GEOFPI---Projeto-Integrador/master/Loading%20images/download.png" width="15" height="15" /> [Github](https://github.com/edsonbrendon)<img src="https://raw.githubusercontent.com/marciosousa4/GEOFPI---Projeto-Integrador/master/Loading%20images/GitHub-Mark.png" width="20" height="20" />


* Lucas de Lima Chaves (Dev team)
#### [Linked](https://www.linkedin.com/in/lucas-chaves-24312391)<img src="https://raw.githubusercontent.com/marciosousa4/GEOFPI---Projeto-Integrador/master/Loading%20images/download.png" width="15" height="15" /> [Github](https://github.com/Lucas-Chaves)<img src="https://raw.githubusercontent.com/marciosousa4/GEOFPI---Projeto-Integrador/master/Loading%20images/GitHub-Mark.png" width="20" height="20" />



### Disciplina Focal Point: Engenharia de Software II
* M2 (Master dos Masters): Prof. Walmir Duque 
* P2 (PO dos PO´s): Prof. Claudio Lima
## Índice
* [O que é o GEOFPI](#o-que-é-o-geofpi)
* [Ferramenta Desenvolvida](#ferramenta-desenvolvida)
* [Benefícios](#benefícios)
* [Product Backlog](#user-story)
* [Tecnologias](#tecnologias)
* [Sistema ETL em desenvolvimento](#sistema-etl-desenvolvido)
* [Plano de Ação](#plano-de-ação-do-backlog)
* [Cronograma de Entregas](#cronograma-de-entregas)


## O que é o GEOFPI?
A carga de dados georreferenciados é uma atividade contínua durante os projetos que utilizam diversos software GIS para organizar e fazer o processamento de imagens de satélite. O resultado desse processamento, a depender do projeto, é o que se utiliza para desenvolvimento de produtos. A solução escolhida foi a ferramenta de ETL espacial GEOFIP, cuja estrutura conceitual é apresentada na figura abaixo.

<img src="https://github.com/marciosousa4/GEOFPI---Projeto-Integrador/blob/master/Loading%20images/Ferramenta2.png?raw=true"/>

## Ferramenta Desenvolvida
Essa ferramenta será configurada para entender os arquivos de formato shapefile e realizar conversões, usando regras definidas na etapa de planejamento, buscando compatibilidade com normas oficiais, e carregá-los e manipulá-los no banco de dados geográficos PostgreSQL com extensão Postgis, de acordo com a modelagem física definida pelo cliente. Também realiza o processo inverso de gerar um arquivo shapefile a partir de uma tabela do banco de dados PostgreSQL.
## Benefícios 
* Melhoria de aplicações para inteligência empresarial focada na capacidade de gerenciar dados espaciais.
* Suporta o processamento de grande volume de dados do tipo Shapefile.
* Transforma dados em insights com análises incorporáveis.
* Aprimora a análise dos negócios e tem influência nas decisões corporativas, permitindo analisar, visualizar e planejar.

## *User story*


| Quem | O que? | Para |
|:--------------:  | :----------:|:---------------------------------------------------------|
|    Analista de Dados Espaciais   | Gostaria da Prototipação da Ferramenta desenvolvida. | Para ter uma visão global do desenvolvimento do produto, verificar o entendimento das funcionalidades da ferramenta e fazer possíveis apontamentos de melhorias na usabilidade.|
|    Analista de Dados Espaciais   |Gostaria da interface gráfica fazendo a extração dos dados Shapefile e a conexão com o banco de dados|Para iniciar o processo de utilização da função “de para” da ferramenta.|
|    Analista de Dados Espaciais   |Gostaria que a ferramenta execute e transforme os dados e faça a parametrização com o Banco de Dados| Para atender as necessidades do negócio.|
|    Analista de Dados Espaciais   |Gostaria de um ambiente de desenvolvimento de tarefas e transformações geográficas e que o sistema realize o processo inverso de conversão de dados| Para atender as necessidades do negócio. E trazer soluções rápida de desenvolvimento de produtos para sistemas.|
|    Analista de Dados Espaciais   |Gostaria de uma ferramenta que me forneça condições de aplicar regras de transformação nos dados  | Para desenvolver novos produtos de acordo com a solicitação dos setores.| 
|    Analista de Dados Espaciais   |Gostaria de uma ferramenta intuitiva, de fácil usabilidade,  com manuais de instruções| Para melhorar a experiência do usuário com a ferramenta|

## Backlog Total em *Story Cards*

<img src="https://github.com/marciosousa4/GEOFPI---Projeto-Integrador/blob/master/Loading%20images/Backlog.png" width="1000" height="500"/>


## Plano de Ação do Backlog

<img src="https://github.com/marciosousa4/GEOFPI---Projeto-Integrador/blob/master/Loading%20images/Linha%20do%20tempo%20NOVA.png?raw=true" width="900" height="650"/>

## Tecnologias

<img src="https://github.com/marciosousa4/GEOFPI---Projeto-Integrador/blob/master/Loading%20images/Tecnologia%20Atualiza%C3%A7%C3%B5es.png?raw=true" width="900" height="550"/>

## Sistema ETL Desenvolvido

<img src="https://github.com/marciosousa4/GEOFPI---Projeto-Integrador/blob/master/Loading%20images/GEOFPI(sprint%204).gif?raw=true" width="900" height="550"/>

## Cronograma de Entregas

| Data | Links |
| ------ | ------ |
|    20/09/2020    |[Sprint 1](https://github.com/marciosousa4/GEOFPI---Projeto-Integrador/tree/sprint1)|
|    18/10/2020    |[Sprint 2](https://github.com/marciosousa4/GEOFPI---Projeto-Integrador/tree/sprint2) |
|    08/11/2020    |[Sprint 3](https://github.com/marciosousa4/GEOFPI---Projeto-Integrador/tree/sprint3) |
|    29/11/2020    |[Sprint 4](https://github.com/marciosousa4/GEOFPI---Projeto-Integrador/tree/sprint4) |                    
|    06/12/2020    |[Entrega final](https://github.com/marciosousa4/GEOFPI---Projeto-Integrador/tree/sprint5) |
|    

