<div>
  <p align="center">
            <img src="https://user-images.githubusercontent.com/56441534/92442086-adf9e000-f185-11ea-8794-b6c5def3daf3.png" width = "39%">
            <img baackgroundcolor="white" width = "20%">
            <img src="https://user-images.githubusercontent.com/58118956/96368863-d97ccc80-112c-11eb-8a52-938b4327fc50.jpg" width = "39%"></p>
</div>    

# Projeto Integrador

O projeto integrador é uma parceria entre a Fatec São José dos Campos e uma empresa cliente que visa dar aos alunos a experiência de trabalhar com uma Empresa em um caso real, desenvolvendo uma aplicação que resolva um problema proposto por esse cliente.

# Disciplinas Integradas

## Engenharia de Software II

* Prof. José Walmir Gonçalves Duque

## Interação Humano Computador

* Prof. Giuliano Araujo Bertoti

## Programação Orientada a Objetos

* Prof. Gerson Penha Neto

## Estrutura de Dados

* Prof. Fernando Masanori Ashikaga

# Integrantes do grupo

* ### Mateus Prestes - Scrum Master 
* ### Lucas Okazaki - Product Owner
* ### João Pedro Paes - Dev Team
* ### Fabricio Rodrigues - Dev Team
* ### Rodrigo Felix - Dev Team
* ### João Vitor Soeiro - Dev Team
* ### William Honda - Dev Team
* ### Kleber Apolinario jr. - Dev Team

# Objetivos do projeto

O objetivo é de desenvolver uma aplicação web que funcione como um mini-ETL, extraindo os dados do shapefile e enviando ao banco de dados (PostgreSQL/Postgis) e fazendo também o processo inverso convertendo os dados do banco em um novo shapefile

# Shapefile

O Esri Shapefile ou simplesmente shapefile é um formato popular de arquivo contendo dados geoespaciais em forma de vetor usado por Sistemas de Informações Geográficas também conhecidos como SIG. Foi desenvolvido e regulamentado pela ESRI como uma especificação aberta para interoperabilidade por dados entre os softwares de Esri e de outros fornecedores.

<p align="center">
  <img src="https://user-images.githubusercontent.com/58118956/100610526-a8c4b100-32ee-11eb-8ffe-ec419225d17e.png"> </p>

# ETL

No contexto do Data Warehouse (DW) e Business Intelligence (BI) ouvimos muito falar sobre o processo de ETL. Essa sigla significa Extração, Transformação e Carga (em inglês Extract, Transform and Load) e trata da sistematização do tratamento e limpeza dos dados oriundos dos diversos sistemas organizacionais (OLTP) para a inserção, geralmente, em um DW ou Data Mart.
Como podemos perceber, esse processo possui três etapas. A primeira é a extração (extract), a segunda a transformação (transform) e por fim, a carga (load). Cada uma delas possui grande importância para o sucesso da transição dos dados dos sistemas de origem para o DW.

<p align="center">
  <img src="https://user-images.githubusercontent.com/58118956/100610486-964a7780-32ee-11eb-9ed1-74940d584917.png"> </p>
  
A etapa de extração pode ser entendida como a fase onde os dados são extraídos dos OLTPs e conduzidos para a staging area (área de transição ou área temporária), onde são convertidos para um único formato. A conversão se faz necessária devido a heterogeneidade existente nas informações oriundas desses sistemas, sendo essencial a conformação prévia para o tratamento adequado.

<p align="center">
  <img src="https://user-images.githubusercontent.com/58118956/100610602-cd208d80-32ee-11eb-8ce9-cbbc34af895c.png"> </p>

Após a extração, teremos subsídios para iniciar a etapa de transformação e limpeza dos dados. Nessa fase são corrigidos, padronizados e tratados os desvios e inconsistências, transformando os dados de acordo com as regras do negócio.

<p align="center">
  <img src="https://user-images.githubusercontent.com/58118956/100610630-dc074000-32ee-11eb-9130-f75cfb0617e4.png"> </p>

A etapa de carga ocorre em sequência com a de transformação. Assim que são efetuados os tratamentos necessários nos dados, a carga no DW é iniciada. Essa fase se resume na persistência dos dados na base consolidada.

<p align="center">
  <img src="https://user-images.githubusercontent.com/58118956/100610679-ecb7b600-32ee-11eb-9f01-9b7230de56cd.png"> </p>

O ETL é fundamental para qualquer iniciativa de DW. Porém deve ser planejado com cuidado para não comprometer os sistemas transacionais (OLTP) das empresas. Um bom ETL deve ter escalabilidade e ser manutenível.

# Shapview

<p align="center">
  <img src="https://user-images.githubusercontent.com/58118956/100611030-6ea7df00-32ef-11eb-97b5-c2fd6a9c7099.jpeg"> </p>
  
Assim, com essa base de conhecimento e entendendo melhor o problema do cliente, surgiu o Shapview. Onde a necessidade era ter uma ferramenta de baixo custo com a funcionalidade de realizar conversões de um arquivo shapefile para o banco de dados e realizar também o processo inverso para um novo shapefile agora tratado.

<p align="center">
  <img src="https://user-images.githubusercontent.com/58118956/100612612-05759b00-32f2-11eb-992a-c1380029209a.png"> </p>

O Shapeview que tem como objetivo funcionar como um mini ETL(extract, transform and load), suprindo essa necessidade da empresa. Podendo realizar “uploads” de forma personalizada de seus arquivos em formato Shapefile no seu banco de dados e ainda fazer "downloads" dos arquivos que estão salvos ali.   
  
# Requisitos
## Não funcionais
* Carga de dados geográficos (ponto, linha e polígono) e seus atributos alfanuméricos em tabelas existentes de banco de dados geográficos.
* Recuperação de dados geográficos (ponto, linha e polígono) e seus atributos alfanuméricos armazenados em banco de dados geográficos.

## Funcionais
* Banco de Dados Geográficos PostGIS;
* Documentações.

# Tecnologias utilizadas no desenvolvimento

Para o desenvolvimento da aplicação, tendo em vista os requisitos apresentados pelo cliente e os conhecimentos da equipe, foram utilizadas as tecnologias da seguinte maneira.

* ### Frontend da aplicação:

<p align="left">
  <img src="https://user-images.githubusercontent.com/58118956/100611681-787e1200-32f0-11eb-93c9-04a4885e47b4.png"> </p>
  
* ### Backend da aplicação:

<p align="left">
  <img src="https://user-images.githubusercontent.com/58118956/100611733-87fd5b00-32f0-11eb-94a2-a545a6bf55bb.png"> </p>

* ### Banco de Dados da aplicação:

<p align="left">
  <img src="https://user-images.githubusercontent.com/58118956/100611779-99466780-32f0-11eb-9374-5b0ac5ab020e.png"> </p>

# Wireframe

<p align="center">
  <img src="https://user-images.githubusercontent.com/58118956/100611802-a6fbed00-32f0-11eb-8e58-aa3a85dda145.png"> </p>

# Backlog Total

Para o desenvolvimento do projeto, foi estabelecido que fariamos por etapas onde apresentariamos a evolução do projeto para o cliente e os orientadores.

<p align="center">
  <img src="https://user-images.githubusercontent.com/58118956/100613329-2094da80-32f3-11eb-8f7e-bc5a76722f5c.jpeg"> </p>

Para as entrega e reuniões com as partes envolvidas, foram acordadas as datas a seguir, onde podemos acompanhar o que foi apresentado em cada etapa de desenvolvimento.

<a href='https://github.com/Mateus-Prestes/Projeto-integrador-3-Semestre/tree/sprint-1'> Sprint 1 </a>- 20/09/2020

<a href='https://github.com/Mateus-Prestes/Projeto-integrador-3-Semestre/tree/sprint-2'> Sprint 2 </a>- 18/10/2020

<a href='https://github.com/Mateus-Prestes/Projeto-integrador-3-Semestre/tree/sprint-3'> Sprint 3 </a>- 08/11/2020

<a href='https://github.com/Mateus-Prestes/Projeto-integrador-3-Semestre/tree/sprint-4'> Sprint 4 </a>- 29/11/2020

