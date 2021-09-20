# API Analytics

  ##
<p align="center">
  <a href="#problema">Problema</a> |
  <a href="#solução">Solução</a> |
  <a href="#entregas">Entregas</a> |
  <a href="#tecnologias-utilizadas">Tecnologias Utilizadas</a> |
  <a href="#overview-técnico">Tech Overview</a> |
  <a href="#saiba-mais">Saiba mais</a>
</p>

##
FATEC São José dos Campos - Professor Jessen Vidal

*Professor:* Eduardo Sakaue

Projeto elaborado para resolver o problema proposto pelo SPC, decidimos utilizar a tecnologia de inteligencia artifical para traçar perfis e recomendar produtos.

## Equipe: 

| *INTEGRANTES*         									|
|---------------------------------------------------|          
| Eduardo Kenji Higa                 |
| Eduardo Vinicius Maia								|
| Luan Matheus Satiro de Oliveira					|
| Pedro Henrique Cerqueira Fernandes (Scrum Master)	|
| Rafael Augusto Campos Plinio (PO)					|

## Problema
### Segmentação do cliente?
Possuem uma segmentação antiga (2013) que não expressa o mercado atual e é pouco utilizada internamente.
### Temos nosso mercado potencial mapeado?
Possuem ferramenta de Market Share, ampla que não possui o detalhamento do potencial financeiro ou perfil, que acaba subutilizada.
### Possuimos análise/estratégia por mercado x produto x concorrente x segmento?
A atual análise pe gerada manualmente, o projeto produzirá automação e extração dessas análises.


## Solução
### Maior detalhamento do cliente, que permitirá ações comerciais personalizadas
Usaremos um algoritmo de recomendação para o setor de vendas do SPC, que irá recomendar o produto mais adequado de acordo com o perfil de cada cliente. Foram selecionadas algumas bases para nos auxiliar nessa complementação de dados para as análises que desejamos. Realizamos uma raspagem de dados na API do twitter. Usaremos os Top Trends de regiões para auxiliar o algoritmo de recomendação.
Desenvolveremos um sistema web onde o analista poderá logar e visualizar as análises disponiveis baseadas nos nossos modelos de dados e no nosso modelo de inteligência artificial, é importante salientar que nossa base estará em constante manutenção, afim de agregar cada vez mais valor.

## Entregas

### Kick of do projeto: 
* Data: (28/02/2021 a 06/03/2021)

### Sprint 1: 
* Levantamento de requisitos
* Brainstorming
* Análises no Jupyter Notebook
* Escopo do projeto
* Data: (08/03/2021 a 28/03/2021)

  A entrega foi analises no jupyter com a base fornecida pelo spc, transformamos a localização em latitude e longitude em gráficos de calor.
  <img src="https://github.com/2021-FATEC-API-GRUPO-01/API/blob/a08d562b7c128565848cf95ea1446e52f5ed1684/gifs/jupyterGraphics.gif" width="700" height="500" />
  
### Sprint 2:
* Conclusão da coleta dos requisitos
* Estudos sobre IA
* Análise na API do Twitter
* Elaboração das bases de dados
* Data: (29/03/2021 a 18/04/2021)

  A entrega foi a complementação da base de dados com fontes externas como por exemplo: dados raspados pela api twitter.
  Utilizamos a api do google maps para transformar as coordenadas em nomes de locais.
  Expandimos os campos da base inicial fornecida para ajudar no algoritmo de recomendação da próxima sprint, alguns exemplos:
  <img src="https://github.com/2021-FATEC-API-GRUPO-01/API/blob/c9ee6a26b59f04baf864acd6ca41e6ac8549a26e/dados.gif" width="900" height="700" />
 
  
### Sprint 3:
* Integração do machine learn com as bases de dados
* Integração do machine learn com o back end
* Detalhamentos dos processos técnicos
* Iniciação do front end
* Data: (26/04/2021 a 16/05/2021)

A entrega foi o desenvolvimento do machine learn e a integração com os dados e o back end com uma interface no front end
<img src="https://user-images.githubusercontent.com/42500368/118415583-87c80080-b681-11eb-8d73-4c75ff767dcf.gif" width="900" height="700" />

### Sprint 4:
* Finalização do front
* Funcionalidade para usar dados apartir de um csv
* Funcionalidade para salvar uma recomendação
* Integração do Frontend com o Backend
* Data: (17/05/2021 a 06/06/2020)

Foi adicionado uma opção para dados via csv e não mais somente por banco de dados, foi adicionado uma opção para salvar recomendações de alguma analise
<img src="https://user-images.githubusercontent.com/42500368/121388524-eea7a500-c921-11eb-9c14-7e50d00e7341.gif" width="900" height="700" />

## Tecnologias Utilizadas
* <p>
  <a href="https://www.python.org/">
  <img alt="Python" src="https://user-images.githubusercontent.com/42500368/114731807-68ebec80-9d18-11eb-8995-f5ccc064a1a5.png" height="30px" style="max-width:100%;"> </a> 
  Python                                                                                                                                           
</p>

* <p>
  <a href="https://flask.palletsprojects.com/en/1.1.x/">
  <img alt="Flask" src="https://user-images.githubusercontent.com/26223657/115167814-3121d380-a08f-11eb-93a0-285ddf1e8fac.png" height="30px" style="max-width:100%;"> </a> 
  Flask                                                                                                                                           
</p>

* <p>
  <a href="https://jinja.palletsprojects.com/en/2.10.x/api/">
  <img alt="Jinja2" src="https://user-images.githubusercontent.com/26223657/115167829-3f6fef80-a08f-11eb-8f52-7fb2e79b760a.png" height="30px"style="max-width: 100%;"> </a>
  Jinja2                                                                                                                                           
</p>

* <p>
  <a href="https://getbootstrap.com/">
  <img alt="Bootstrap" src="https://user-images.githubusercontent.com/26223657/115167815-32eb9700-a08f-11eb-92d5-d5c1d86c733c.png" height="30px"style="max-width: 100%;"> </a>
  Bootstrap                                                                                                                                           
</p>

* <p>
  <a href="https://scikit-learn.org/">
  <img alt="Scikit-Learn" src="https://user-images.githubusercontent.com/42500368/118415143-15eeb780-b67f-11eb-9873-d09400d1a8fa.png" height="30px"style="max-width: 100%;"></a>
  Scikit-Learn                                                                                                                                         
</p>

## Overview técnico
<a href="https://github.com/2021-FATEC-API-GRUPO-01/API_Documentation/wiki/Overview-t%C3%A9cnico"> Acesse aqui </a> para saber mais.


 ## Saiba mais
  #### :bellhop_bell:  Links úteis, FAQ e Leitura:
  <a href="https://github.com/2021-FATEC-API-GRUPO-01/API/wiki/Welcome-to-the-SPC-PROJECT-wiki!"> Acesse aqui </a> para saber mais.
  



