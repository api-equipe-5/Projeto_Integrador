## ENTREGAS
1ª Sprint
- Link do video: https://youtu.be/eWEpNS6VQXU


2ª Sprint
- Link do video: https://youtu.be/kOohl1NTa_Y

3ª Sprint
- Link do vídeo: https://youtu.be/gyfDzBTVyL0

4ª Sprint
- Link do video: https://youtu.be/TrUKfrHIr7w

5ª Sprint

- Link do video: https://youtu.be/GuhoNp6MZF4 


## Projeto Integrador realizado pelos alunos do 2º (segundo) semestre de Banco de Dados da FATEC/SJC no ano de 2020.

Consiste na criação de uma aplicação web utilizando o diagrama de Gantt para análise e controle de projetos.

1. Disciplinas relacionadas:
- Arquitetura e Modelagem de Banco de dados - Prof Emanuel Mineda
- Engenharia de Software - Prof Giuliano Araujo Bertoti
- Linguagem de Programação I - Prof Adriana da Silva Jacinto
- Laboratório em Desenvolvimento em Banco de Dados II - Prof Adriana da Silva Jacinto

## Problema

O cliente busca otimizar a organização dos projetos, desenhando uma visão estratégica em um software que administre projetos, tarefas e horas trabalhadas pelos desenvolvedores. O mesmo deverá ter como base o gráfico Gantt. 

![](/Imagens/MashGGantt.gif)

## Requerimentos (Tecnologias e bibliotecas utilizadas)

- Node.js
- biblioteca: dhtmlx
- banco de dados: MySQL

## Levantamento de requisitos:
Criação de uma tabela dinâmica (projetos) com livre movimentação de tarefas, que será designada para cada projeto, e designar desenvolvedores para elas.

##### Requisitos Funcionais

| Requisitos funcionais             |  Código |              Descrição                                                                                                                                     |Prioridade|
| ----------------------------------|---------| -----------------------------------------------------------------------------------------------------------------------------------------------------------|----------|
|Cadastrar projetos                 |RF01     |Pessoas responsáveis para o registro no sistema serão capacitados para cadastrar os projetos, informando: data, cliente, descrição, tarefa e desenvolvedores|    1     |
|Cadastrar tarefas                  |RF02     |Cadastrar tarefas em projetos existentes (Informar: tempo de desenvolvimento, desenvolvedor e descrição)                                                    |    2     |
|Cadastrar desenvolvedores          |RF03     |Cadastrar desenvolvedores em tarefas existentes (Informar: nome, carga horária de trabalho e disponibilidade)                                               |    3     |   
|Excluir dados                      |RF04     |O usuário poderá excluir dados envolvendo os projetos, tarefas e desenvolvedores designados                                                                 |    4     |       
|Alterar dados                      |RF05     |O usuário poderá alterar dados envolvendo os projetos, tarefas e desenvolvedores designados                                                                 |    5     |
|Filtrar dados                      |RF06     |O sistema poderá filtrar os dados: projetos, tarefas e desenvolvedores                                                                                      |    6     |
|Gerar relatórios                   |RF07     |O usuário poderá imprimir relatórios: projetos, tarefas e desenvolvedores                                                                                   |    7     |                                              


##### Requisitos não funcionais


| Requisitos não funcionais         |  Código |              Descrição                                                                                                           |
| ----------------------------------|---------| ---------------------------------------------------------------------------------------------------------------------------------|
|Usabilidade                        |RNF01    |Estética e Design minimalista: A interface do usuário deve ser implementada de maneira simples (interface web)                    |
|Visibilidade do status do sistema  |RNF02    |As tarefas e projetos serão organizados em cores: verde (em andamento), amarelo (chegando perto da entrega) e vermelho (entregue) |
|Consistência e padrões             |RNF03    |Consistência e padrões: Os dados serão visualizados em tabelas (diagrama de gantt)                                                |                                                                               |             
|Portabilidade                      |RNF04    |A consulta ao acervo deve estar disponivel na internet (principais navegadores disponíveis)                                       |
|Acesso de segurança                |RNF05    |O sistema deve controlar o acesso das funcionalidades                                                                             |                                                                                     |              
|Responsividade                     |RNF06    |Velocidade de resposta e tempo de atualização de tela                                                                             |                 


## Instalação do projeto/ Funcionalidade

1) Clonar reposiório, dando o seguinte comando no terminal de sua maquina: git clone "https://gitlab.com/VitorDan/projeto-integrador-2-sem.-2020.git"
2) Abrir o terminal dentro da pasta do projeto e digitar "npm install", para instalar os módulos utilizados.
3) Com o Mysql instalado, criar um banco de dados na porta "3306" com o nome "gantt_howto_node" e implementar as tabelas que estão no aquivo schema.sql
4) Abrir o terminal no arquivo server.js e digitar "node server.js".
5) O projeto será executado na porta "1337" no "localhost".


## Referências 

- https://docs.dhtmlx.com/


## Contribuintes

- Fernanda Ramos
gitlab: https://gitlab.com/ferpsalles
Linkedin: https://www.linkedin.com/in/fernanda-ramos-de-padua-salles-44329b157/

- Gabriela Momilli
gitlab: https://gitlab.com/gabsmomilli
Linkedin: https://www.linkedin.com/in/gabriela-momilli-105b1a184/

- Vitor Daniel Silva
gitlab: https://gitlab.com/VitorDan
Linkedin: https://www.linkedin.com/in/vitor-daniel-9343bb150/


## Agradecimentos

Agradecemos aos professores pelo suporte oferecido para o progresso do projeto.
