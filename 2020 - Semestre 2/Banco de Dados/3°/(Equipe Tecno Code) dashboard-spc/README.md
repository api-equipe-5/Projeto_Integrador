![logo](/uploads/4314307b69d1017bf8b22767856e3ff4/logo.jpg)

<h1 align="center">Plataforma Cadastro Positivo</h1>

## Proposta Comercial

A nossa proposta é desenvolver um dashboard que funcionará como uma linha do tempo. O objetivo é que o usuário da plataforma possa analisar sua vida financeira baseada em dados que englobam o passado, presente e futuro de sua vida financeira. Os recursos principais do dashboard serão os seguintes:
- Valor do score atual
- Banner com artigos informativos para os usuários
- Gráfico com valores em porcentagem, informando se as contas do cliente foram pagas dentro ou fora do prazo, se ainda estão em aberto ou se estão atrasadas, a partir da escolha de um determinado mês e ano.
- Gráfico com o histórico do score
- Tabela informando o quanto do orçamento do usuário foi designado para cada tipo de despesa em um determinado mês, que será escolhido pelo mesmo.
<p>Com essas informações, a sequência de linha do tempo proposta funcionará da seguinte forma:
Passado: será designado pelo gráfico de histórico, onde o usuário poderá saber em qual momento de sua vida a sua análise de crédito esteve melhor ou pior.
Presente: o score atual trará essa informação, onde o cliente poderá saber como agir dependendo do valor que o mesmo receberá como retorno ao fazer sua consulta.
Futuro: a interface contará com um banner, que irá permitir acesso a artigos que podem ajudar no planejamento financeiro do usuário. Caso o mesmo tenha score baixo, ele terá acesso a dicas de gestão financeira e de como sair das dívidas. Caso o seu score for alto, existem também artigos com informações de dicas de investimento e de como funcionam as taxas bancárias, com o intuito de evitar despesas desnecessárias.

## Descrição do Projeto

A equipe desenvolverá um trabalho em parceria com o Spc, onde será desenvolvida uma plataforma para que usuários possam consultar informações referentes ao seu cadastro positivo. Este trabalho será feito pelos alunos do 3° semestre do curso de Banco de Dados, da Fatec de São José dos Campos, cumprindo os objetivos propostos pela organização do projeto integrador.

Índice
=================
<!--ts-->
   * [Proposta Comercial](#proposta-comercial)
   * [Descrição do Projeto](#descricao-do-projeto)
   * [Índice](#indice)
   * [Status do Projeto](#status-do-projeto)
   * [Features](#features)
   * [Entregas](#entregas)
   * [Requisitos](#requisitos)
      * [Funcionais](#funcionais)
      * [Não Funcionais](#nao-funcionais)
   * [User Stories](#user-stories)
   * [Equipe](#equipe)
   * [Como Instalar o Projeto na Máquina](#como-instalar-o-projeto-na-maquina)
   * [Tecnologias](#tecnologias)
<!--te-->

## Status do Projeto

<h4 align="center"> 
	🚧  Dashboard Spc 🔧 Em Desenvolvimento...  🚧
</h4>

### Features

- [X] Tela de login
![login](/uploads/032e0b5978781b1971c642e3fc565159/login.gif)
- [X] Autenticação de usuário

![autenticação](/uploads/8351dad5eb1963b53b7a065e415416e1/autenticação.png)
- [X] Cadastro de novos usuários
![cadastro](/uploads/9dd37dae5b29b975dcb93538707acad7/cadastro.png)
- [X] Score do cadastro positivo

![score](/uploads/6fea0f3a11e72fdd8b7b6d969ecc0376/score.png)
- [X] Banner com artigos de utilidade pública
![banner](/uploads/7efa39a769f5df3cfcb50b79b5fda60e/banner.gif)

- [X] Histórico do score do usuário

![histórico](/uploads/2f3675e13f300756f68110f7b8919673/histórico.gif)
- [X] Gráfico com o status das contas

![status](/uploads/e3f0f45645d6f61041f475892e6da444/status.gif)
- [X] Tabela com os tipos de contas

![tabela](/uploads/bb7014db02f99e4fdd8ee4781670a7b9/tabela.png)
### Entregas

| Sprint | Data  | Vídeo                                       |
|--------|-------|---------------------------------------------|
| 0      | 27/09 | https://www.youtube.com/watch?v=udTstj6BMCI |
| 1      | 18/10 | https://www.youtube.com/watch?v=lQFAUZnjNhA |
| 2      | 08/11 | https://www.youtube.com/watch?v=JHuPgc0dNwY |
| 3      | 29/11 |                                             |

### Requisitos

#### Funcionais

| Requisitos Funcionais                          | Código | Prioridade | Sprint |
|------------------------------------------------|--------|------------|--------|
| Página de acesso                               | RF01   | 1          | 1      |
| Autenticação dos dados                         | RF02   | 2          | 1      |
| Formulário de cadastro                         | RF03   | 3          | 1      |
| Cabeçalho e rodapé da página                   | RF04   | 4          | 1      |
| Tela com valor atual do score                  | RF05   | 1          | 2      |
| Banner rotativo                                | RF06   | 2          | 2      |
| Visualização do status de pagamento das contas | RF07   | 3          | 2      |
| Histórico do score do usuário                  | RF08   | 4          | 2      |
| Tabela com descrição de consumo                | RF09   | 1          | 3      |
| Conexão com banco de dados                     | RF10   | 2          | 3      |

#### Não Funcionais

| Requisitos Não Funcionais                  | Código | 
|--------------------------------------------|--------|
| Dashboard interativo                       | RNF01  |
| Seguir as diretrizes da Lgpd               | RNF02  |
| Banco de dados relacional (my sql)         | RNF03  |
| Infraestrutura para grande volume de dados | RNF04  |
| Utilização de linguagem java               | RNF05  |
| Proteção dos dados do usuário              | RNF06  |
| Inclusão de captcha                        | RNF07  |
| Design de utilização simples               | RNF08  |
| Modelar o banco de dados fornecido         | RNF09  |
| Memorial de cálculo                        | RNF10  |

#### User Stories

| Quem? | O que? | Por que? |
|-------|--------|----------|
| Usuário da Plataforma | Ter acesso a um dashboard de fácil entendimento | Para que o mesmo poderá controlar as ações de sua vida financeira de acordo com o que foi apresentado na proposta comercial |
| SPC | Disponibilizar a seus clientes um sistema interativo | Para atrair pessoas interessadas em consultar seu histórico financeiro e acessar oportunidades que podem melhorar a situação do mesmo |
| Equipe Tecno Code | Entregar ao contratante do serviço um sistema de qualidade que contenha os recursos que foram solicitados pelo mesmo | Para aplicar na prática os conhecimentos de programação adquiridos, além de adquirir experiência profissional em desenvolvimento de projetos |

##### Equipe:

##### Fabrício Adriel
* [Git Lab](https://gitlab.com/fabricioadriel)
* [Linkedin](linkedin.com/in/fabricioadriel)
* RA: 1460281923009

##### Felipe Santos
* [Git Lab](https://gitlab.com/felipefsc)
* [Linkedin](https://www.linkedin.com/in/felipe-santos-454060187/)
* RA: 1460281923011

##### Gabriela Momilli
* [Git Lab](https://gitlab.com/gabsmomilli)
* [Linkedin](linkedin.com/in/gabriela-momilli-105b1a184)
* RA: 1460281923058

##### Gilberto Souza
* [Git Lab](https://gitlab.com/gilberto.santos10)
* [Linkedin](linkedin.com/in/gilberto-santos-jr)
* RA: 1460281723021

#### Como Instalar o projeto na máquina:

- Selecione uma pasta de sua preferência, através do comando "cd Pasta Escolhida"
- Abra o terminal clicando dentro de uma pasta com o botão direito e selecione a opção git bash here
- Utilize a função git clone https://gitlab.com/tecno-code/dashboard-spc para instalar os arquivos no seu computador

### 💻 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- Html
- Css
- Javascript
- Jquery
- Bootstrap
- Sql
- Java