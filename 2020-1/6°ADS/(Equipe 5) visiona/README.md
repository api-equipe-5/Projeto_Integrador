# Integrantes do Grupo 5
-   Douglas De Souza - Desenvolvedor Fullstack ([Linkedin](https://www.linkedin.com/in/douglas-de-souza-gon%C3%A7alves-a296a214b/))
-   Enzo Gerola - Desenvolvedor Fullstack ([Linkedin](https://www.linkedin.com/in/enzo-gerola-7b4700139/))
-   Gabriel Matos - Scrum Master ([Linkedin](www.linkedin.com/in/gaamatoss))
-   Henrique Alexandre - Desenvolvedor Fullstack ([Linkedin](https://www.linkedin.com/in/henrique-souza-alexandre-30373016b/))
-   José Elias - Product Owner ([Linkedin](https://www.linkedin.com/in/josé-elias-o-b39190142/))

# Visiona

## Situação atual e justificativa do projeto

Realizar um projeto em conjunto com a empresa Visiona, que consiste em criar um sistema web que define e gerencia os Talhões de uma determinada região através de uma IA, fornecida pela empresa todo o material de apoio para dar início ao projeto.

# Servidores e Cliente

Para facilitar no desenvolvimento do projeto, separamos ele em três partes:

## [Cliente](https://gitlab.com/douglas.souzag/webgis-visiona)

Parte visual do WebGIS, responsável por abstrair a interação do usuário com os servidores de processamento de banco de dados, se encontra neste
[repositório](https://gitlab.com/douglas.souzag/webgis-visiona) .

## [Servidor do Banco de Dados](https://gitlab.com/douglas.souzag/bd-server-visiona)

Parte responsável por armazenar e retornar todas as informações dos usuários, areas e imagens processadas, se encontra neste
[repositório](https://gitlab.com/douglas.souzag/bd-server-visiona) .

## [Servidor de Processamento](https://gitlab.com/douglas.souzag/ia-server-visiona)

Parte responsável pela identificação de talhões, e download das imagens, se encontra neste 
[repositório](https://gitlab.com/douglas.souzag/ia-server-visiona) .

## Objetivo do projeto
 	
Com a realização do projeto poderemos identificar os talhões de uma determinada região, assim podemos identificar como foi a mudança que o local sofreu ao longo dos anos, através de uma inteligência artificial iremos identificar os elementos presentes no arquivo gerado pelo satélite como nuvens, relevos e assim podendo “treinar” a IA para identificar os talhões e fazer o reconhecimento do local como um todo.
O projeto será considerado um sucesso se atender a todos os critérios de aceitação das entregas, respeitar as restrições e cumprir o cronograma de execução.

## Requisitos: 

-	Treinar uma inteligência artificial para fazer o reconhecimento dos elementos que estão presentes na imagem gerada
-	Identificar os talhões da região
-	Traçar métricas para analisar a região e como foi sua evolução durante o tempo
-	Desenvolver um sistema web para gerenciar todo o mapa com as informações

## Documentação do Projeto
-   [Documentos](https://drive.google.com/drive/folders/1jpylCukXZ-dXyeXKhveL1e4h_6h6Z0hI?usp=sharing)
-   [Planilha de custos](https://docs.google.com/spreadsheets/d/1K1LMhtv2zpvaMf7OXXQadKsYZsrr-DMd_8A0W-zwfvQ/edit?usp=sharing)
-   [Gráfico Burndown](https://docs.google.com/spreadsheets/d/1T-Um5j_i17QHgmUDWkdYQWlF-Beda6Tq5OJ0FkCOkxE/edit?usp=sharing)
-   [Matriz Raci](https://docs.google.com/spreadsheets/d/14LjCpRv72gBPqyzKASprroXeiO-9xncovccf3pB6K68/edit?usp=sharing)
-   [Checklist](https://drive.google.com/file/d/1Q0unTLsmw0O0yL8bstLIBgG-QSFGaqo6/view?usp=sharing)

## Entregas (Videos e [Priorizações](https://drive.google.com/file/d/1bWyWYEwtM5XWlK2GdvbMZuyKPnk8QsIH/view?usp=sharing))
- [x]  Entrega 1 --> [Video Demonstrativo entrega 1](https://drive.google.com/open?id=11v4xIfAYC_t8zkmm5uXnqkraF5Oosq1n)
- [x]  Entrega 2 --> [Video Demonstrativo entrega 2](https://drive.google.com/open?id=1qI51W90t1r8VAVSixZajOPehkBhtmiVV)
- [x]  Entrega 3 --> [Video Demonstrativo entrega 3](https://drive.google.com/file/d/1su1_JO-INZhCrKuTwO0xIuDHuL-4v2br/view?usp=sharing)

    Entrega 3 - Assim que o usuário selecionar a sua área de interesse essa área irá para um
catálogo com todos as outras áreas que o usuário selecionar e registrar podendo visualizar
essas áreas e sua informações e também podendo baixar uma imagem da área.

- [x]  Entrega 4 --> [Video Demonstrativo entrega 4](https://drive.google.com/file/d/1jmxoft1dSnrfpMGHpgdaniFxBGqBHaYb/view?usp=sharing)
    
    Entrega 4 - Desenvolvemos uma IA que como requisitado pela empresa é capaz de reconhecer os talhões selecionados nas áreas da imagem, essa feature é um passo muito grande para o projeto pois ele é o ponto principal da aplicação que irá fazer toda analise em cima das regiões selecionadas.
    
    O arquivo no google colab se encontra [**AQUI**](https://colab.research.google.com/drive/1S3tCy98YhN0T_iX4tkdnIJfvkIAtYxbV?usp=sharing).

- [x]  Entrega 5 --> [Video Demonstrativo Entrega 5](https://drive.google.com/drive/folders/1i5DTburScV7rxmNE8l2hBS-ri6yqtWz2?usp=sharing)

    Nessa etapa do projeto nós adicionamos os requisitos de busca definidos pela empresa
para que assim a precisão de analise seja maior, juntamente com isso a equipe integrou a IA
como um serviço fazendo com que a analise gerada pela IA seja retornada para o usuário ver e
analisar se ele está de acordo com a análise ou não.

- [x] Entrega 6 --> [Video demonstrativo Entrega 6](https://drive.google.com/file/d/1RyW0nsovzc7xF6O0qX_BEoIRN2JH98Z5/view?usp=sharing)
    
    Nessa desenvolvemos os ultimos ajustes para a entrega final e para a apresentação para o cliente. Finalizamos toda a parte visual do produto e a parte da IA para o reconhecimetno dos talhões.

## Fluxograma
- ![Fluxograma](./docs/Fluxograma.png)

## Fotos do Produto Final

- ## Login
![Login](https://image.prntscr.com/image/hSB_GltDRAeuh_5ZzpqUQw.png)
- ## Cadastro
![Cadastro](https://image.prntscr.com/image/rT7j0whSTT28cSn2v6lkwQ.png)
- ## Mapa
![Mapa](https://image.prntscr.com/image/gnNgmSxWTCK8Qw-Zojsing.png)
- ## Áreas
![Áreas](https://image.prntscr.com/image/bFa0cpc1QqKzfUPU-mLJIA.png)
- ## Galeria
![Galeria](https://image.prntscr.com/image/T4e9JLCbT2aQAhvGHdchCA.png)
- ## Talhões
![Talhões](https://image.prntscr.com/image/vaVMs8ZRSYC_lSerwUTTSA.png)
