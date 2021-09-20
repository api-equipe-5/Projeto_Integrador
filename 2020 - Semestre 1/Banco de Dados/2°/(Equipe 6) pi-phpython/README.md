# Projeto Integrador - 2º semestre de BD - PI-PHPython :elephant: :snake:

# GANTT PLANNER

## Entregas

**Para acessar o projeto em produção:** [Gantt Planner](https://pi-gantt-planner.herokuapp.com)

----------------------------------------------------------------

### 6ª Entrega (Final)
[![gantt-planner](/uploads/1dd27ec46e5cb20d56ac7f2f23998036/by_PHPython.png)](http://www.youtube.com/watch?v=sePaF3FJYkg "GANTT PLANNER - PHPython")

[vídeo da Apresentação da 6ª entrega](https://youtu.be/sePaF3FJYkg)

**Descrição**

- Melhorias de estética no Front-End;
- Reorganização dos menus de cadastro;
- Limpeza do código;
- Modularização do código do front-end;
- Optimização do Banco de Dados;
- Correção dos links para o "como utilizar" e "reportar erros";
- Agora são exibidas dicas quando você para com o mouse em cima de um botão;
- Removemos o Bootstrap;
- Corrigimos problemas de compatibilidade entre navegadores;
- Atualizamos o diagrama de banco de dados;
- Melhoramos o "como utilizar";

----------------------------------------------------------------

### 5ª Entrega

[vídeo da Apresentação da 5ª entrega](https://youtu.be/QbBc3mReSTo)

**Descrição**

Após a reunião com o Cadu, reavaliamos o que seria real prioridade e deixamos por não atender ao requisito 32. 
- (REQ-32) Usuário pode escolher quais projetos e tarefas serão exibidos no gráfico de gantt

Atendemos ao seguinte requisito além do que estava na sprint:
- (REQ-25) Gerente pode gerar relatórios de pessoas com os seguintes dados: Horas livres, salário, carga horária, projetos e tarefas que participa/participou
em um intervalo de tempo.



----------------------------------------------------------------

### 4ª Entrega

[vídeo da Apresentação da 4ª entrega](https://youtu.be/losLuFm8Eqk)

**Descrição**

Além dos itens que foram expostos na apresentação, vale ressaltar que foram feitos bem mais ações "por baixo dos panos", bem como: 
- transformar o back-end em uma API;
- Integração dos botões do front end e 
- remodelação do banco de dados.

----------------------------------------------------------------

### 3ª Entrega

[vídeo da Apresentação da 3ª entrega](https://www.youtube.com/watch?v=xsMU915KdhA&feature=youtu.be)

----------------------------------------------------------------

### 2ª Entrega

[vídeo da Apresentação da 2ª entrega](https://youtu.be/eVWRJgfRgmc)

----------------------------------------------------------------

**WIKI:** 

Acesse a Wiki do projeto para ter mais detalhes sobre o projeto organizada em Tópicos:

[Wiki do Projeto (Clique aqui!)](https://gitlab.com/felipemessibraga/pi-phpython/-/wikis/home)

**DISCIPLINAS:**
- Linguagem de Programação I - Profª Adriana Jacinto
- Laboratório de Desenvolvimento de Banco de Dados II - Profª Adriana Jacinto
- Engenharia de Software - Profº Giuliano Bertoti
- Planejamento Estratégico - Profº Valter de Sousa
- Gestão de Pessoas - Profº Valter de Sousa
- Arquitetura e Modelagem de Banco de Dados - Profº Emanuel Mineda
- Inglês - Profª Teresinha Nogueira

**EQUIPE DE ALUNOS:**
- Giovanni Guidace - r.a. 1460281923013
- Igor da Silva - r.a. 1460281923016
- Nathan Augusto - r.a. 1460281923027
- Jéssica Isri - r.a. 1460281923019
- Felipe Braga - r.a. 1460281923010

## VISÃO DO PROJETO

Para equipes que trabalham em múltiplos projetos e tarefas, que estão insatisfeitas com a dificuldade de 
fazer um planejamento com as ferramentas de planejamento disponíveis, o Gantt Planner é uma ferramenta visual 
de planejamento que auxilia o desenvolvimento do seu planejamento, minimizando os riscos de má distribuição 
de mão de obra, perder prazos e compreensão da evolução das tarefas.
Ao contrário de outras ferramentas de planejamento conhecidas, nosso projeto oferece gráficos e relatórios 
completos e agradáveis com a possibilidade de compartilhamento do gráfico do planejamento como imagem para o time.


## MOTIVAÇÃO

A motivação para o desenvolvimento desse projeto partiu de uma demanda da empresa Necto, a partir de seu 
CEO Carlos Eduardo, que era de uma ferramenta que fosse fácil de mexer, que fosse portátil e ao mesmo tempo 
flexível para auxiliar no planejamento de seus projetos. Manipular um gráfico de Gantt afim de conquistar esses 
objetivos será o cerne do projeto.
Outro fator decisivo para o desenvolvimento é a limitação que outras ferramentas semelhantes à do nosso projeto que 
impossibilitam ou dificultam muito a visualização da empresa como um todo, afim de conseguir conciliar o 
desenvolvimento de vários projetos simultaneamente com a distribuição da equipe da melhor forma possível, além de ter 
uma melhor distribuição dos recursos financeiros.


## CASOS DE NEGÓCIO

[Casos de Negócio](https://gitlab.com/felipemessibraga/pi-phpython/-/wikis/Casos-de-Neg%C3%B3cio-(Business-Case))

Visite os casos de uso para entender mais sobre os benefícios e riscos do projeto, justificativa financeira e 
avaliação de viabilidade.

### PROVA DE CONCEITO (POC)

[Prova de Conceito - PHPython](https://pi-phpython.herokuapp.com/gantt/)


## REQUISITOS

### FUNCIONAIS

Trataremos a pessoa que vai fazer o planejamento como *Gerente* e as pessoas que utilizarão esse planejamento
como *Usuário*, independente de suas funções reais.

(STORY CARDS)

**2ª ENTREGA**

- (REQ-1) O Gerente pode criar, alterar, visualizar ou excluir um cadastro de projeto. Cada cadastro de projeto deve conter apenas
as seguintes informações básicas: id, nome, escopo, data de inicio e prazo de entrega;
- (REQ-2) O Gerente pode criar, alterar, visualizar ou excluir um cadastro de tarefas. Cada cadastro de tarefa deve conter apenas
as seguintes informações básicas: id, nome, data inicial, data final, prazo, dependência, entregável (se essa tarefa gera um entregável);
- (REQ-3) O Gerente pode criar, alterar, visualizar ou excluir um cadastro de pessoas. Cada cadastro de pessoa deve conter apenas
as seguintes informações básicas: id, nome e contato;
- (REQ-4) O Gerente e o Usuário devem ser capazes de visualizar um gráfico de gantt com as tarefas (de forma estática por enquanto -Prova de Conceito(POC));

**3ª ENTREGA**

- (REQ-6) O Gerente pode incluir e excluir usuários para cada projeto através do django admin;
- (REQ-7) O Gerente pode incluir um usuário em uma ou mais tarefas se esse usuário fizer parte do projeto relacionado a tarefa através do django admin;
- (REQ-9) O Gerente pode criar, alterar, visualizar ou excluir um cadastro de projeto através de um menu;
- (REQ-10) O Gerente pode criar, alterar, visualizar ou excluir um cadastro de tarefa através de um menu;
- (REQ-11) O Gerente pode criar, alterar, visualizar ou excluir um cadastro de pessoa através de um menu;
- (REQ-12) O Gerente e o usuário podem cadastrar diferentes cores para os projetos para diferencia-los;;

**4ª ENTREGA**

- (REQ-5) O Gerente pode visualizar as tarefas de cada projeto. Cada tarefa deve estar atrelada a necessariamente um projeto;
- (REQ-6) O Gerente pode incluir usuários para cada projeto através da interface;
- (REQ-7) O Gerente pode incluir um usuário em uma ou mais tarefas se esse usuário fizer parte do projeto relacionado a tarefa;
- (REQ-8) O Gerente e o Usuário podem visualizar quais pessoas fazem parte de cada projeto e tarefa diretamente no gráfico;
- (REQ-12) O Gerente e o usuário podem visualizar diferentes cores para os projetos para diferencia-los;
- (REQ-14) O Gerente e o Usuário podem salvar as alterações feitas no gráfico de gantt;
- (REQ-13) O Gerente pode fazer alterações na visualização do gráfico de forma dinâmica direto no gráfico de gantt. As seguintes alterações podem ser feitas:
visualizar por período de dia, semana, mês ou ano, alterar o período, duração, data de inicio e fim
de cada tarefa;

**5ª ENTREGA**

- (REQ-19) O Gerente pode criar, alterar, visualizar ou excluir um cadastro de projeto. Cada cadastro de projeto deve conter além das informações básicas, 
as seguintes informações: custo base, horas de desenvolvimento, pessoas(usuários), progresso e data final;
- (REQ-20) O Gerente pode criar, alterar, visualizar ou excluir um cadastro de tarefas. Cada cadastro de projeto deve conter além das informações básicas, 
as seguintes informações: pessoas, dependencias (de outras tarefas),progresso e data final;
- (REQ-21) O Gerente pode criar, alterar, visualizar ou excluir um cadastro de pessoas. Cada cadastro de projeto deve conter além das informações básicas, 
as seguintes informações: horas disponíveis, salário, férias, carga horária, habilidades, faltas;
- (REQ-22) Gerente e Usuário podem pesquisar cadastros de Projetos, Tarefas e Pessoas;
- (REQ-23) Gerente pode visualizar todas as pessoas com horas livres sem filtro, com filtro de projetos ou com filtro de tarefas em um intervalo de tempo;
- (REQ-30) Usuário pode acessar aba de HELP para tirar dúvidas;
- (REQ-31) Usuário pode reportar um erro


**6ª ENTREGA (FINAL)**

- (REQ-16) O Gerente e o Usuário podem ver as tarefas por cor no gráfico;
- (REQ-17) O Gerente pode fazer modificações no gráfico e salva-las automaticamente;


#### Diagrama de Casos de Uso

![DIAGRAMA DE CASOS DE USO](/uploads/80b5f181d03c0cd07e3ba2b719cd2d89/diagrama_casos_casos_de_uso.jpeg)

### NÃO FUNCIONAIS

**Compatibilidade entre o aplicativo e o mundo real**
1.  A preocupação com o uso de ícones para as principais tarefas gera uma aproximação com o mundo real, trazendo
um conforto propiciado pelo natural reconhecimento dos símbolos presentes no dia a dia.
2.  O mapa centralizado na tela do usuário em referência as televisões que ficam no centro da sala.

![real-virtual](/uploads/3586344651689c3fc8d25e4227eae595/real-virtual.JPG)

**Controle e liberdade para o usuário**
1.  O usuário pode navegar entre as versões do projeto, podendo voltar a uma versão anterior caso a atual não o agrade;
2.  É possível modificar quase todos os atributos dos projetos, tarefas e pessoas;
3.  O sistema é responsivo, para se adaptar aos diversos monitores e dispositivos;

**Consistência e padronização**
1.  Os menus respeitam o mesmo padrão de design;
2.  Os icones apresentam apenas dois tipos, que variam apenas para evidenciar o seu contexto;

**Prevenção de erros**
1.  Existe uma preocupação grande com a prevenção de erros. Todas as decisões que não podem ser desfeitas emitem uma 
confirmação;
2.  Os botões respeitam um margem mínima para que não haja cliques "sem querer".
  
![botoes](/uploads/c2e675a3dbf8fbcab70ccadc283f9cf2/botoes.JPG)

**Eficiência e flexibilidade de uso**
1.  O aplicativo foi pensado para que qualquer pessoa consiga utiliza-lo, por isso apresenta botões com objetivos claros,
drag and drop para facilitar a movimentação das tarefas e contraste visual.
2.  Semelhança na disposição dos menus com ferramentas de uso popular como o Microsoft World;

**Estética e design minimalista**
1.  Deixamos apenas as principais informações em evidência, deixando o maior volume de informações para os relatórios,
onde essas informações são idealmente dispostas de forma a não sobrecarregar o visual;
2.  Sem propagandas ou qualquer informação desnecessária.

![wireframe-minimalista](/uploads/4de17b52b70036620bf3c0c01800b9a9/wireframe-minimalista.JPG)

**Ajuda e documentação**
1.  Aba de Help com várias dicas de como utilizar;
2.  Algumas dicas são sugeridas em menus mais complexos;

[WIREFRAME (ATUALIZADO)](https://www.figma.com/proto/lRDoAT9A8U6i1HlY84PNut/PHPython?node-id=1%3A2&scaling=min-zoom)

## BANCO DE DADOS

![d5514521-baf5-4d43-93fd-014b8a9deb53](/uploads/dd3c26d97593ce1d28dd568bfaa779aa/d5514521-baf5-4d43-93fd-014b8a9deb53.jpeg)

## TECNOLOGIAS UTILIZADAS

- Python
- PostgreSQL
- HTML
- JavaScript e CSS
- Django (Framework Python)
- Maquina Virtual
- GitLab
- Whats App
- Excel

### LinkedIn

* [Giovanni Guidace](https://www.linkedin.com/in/giovanni-guidace-61982812a/  )
* [Nathan Naressi](https://www.linkedin.com/in/nathan-naressi-b529081b2)
* [Felipe Braga](https://www.linkedin.com/in/felipegbraga/)
* [Jessica Isri](https://www.linkedin.com/in/jessica-dias1/)

Fatec - Prof Jessen Vidal - São José dos Campos - SP
