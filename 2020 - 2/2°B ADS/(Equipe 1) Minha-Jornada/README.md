![Capa](https://github.com/PITime01/Minha-Jornada/blob/master/documentos/Capa.gif)

# Disciplina Focal Point: Sistemas de Informações
* M2 (Master dos Masters): Prof. Walmir Duque
* P2 (PO dos PO´s): Prof. Claudio Lima

## Disciplinas Integradas

   ### Engenharia de Software
   Profª. Juliana Forin Pasquini Martiniz
   
   Prof. Giuliano Araujo Bertoti

   ### Linguagem de Programação
   Prof. Reinaldo Gen Ichiro Arakaki

# Dev Team
* Barbara Bidoia Bidetti - PO

     [Barbara-BB: GitHub](https://github.com/Barbara-BB).
     
     [Barbara Bidetti: Linkedin](https://www.linkedin.com/in/barbara-bidetti-bb910a1b3)

* José Alberto Martins de França - Scrum Master

     [José Alberto Martins de França: Linkedin](https://www.linkedin.com/in/jos%C3%A9-alberto-martins-de-fran%C3%A7a-041506170/)

* Carolina Margiotti de Abreu - DEV Team

     [Carolina Margiotti: GitHub](https://github.com/CarolinaMargiotti)
     
     [Carolina Margiotti: Linkedin](https://www.linkedin.com/in/carolina-margiotti-703897193/)

* Davi das Neves Machado - DEV Team

* Henrique Erzinger Dousseau - DEV Team

     [Henrique: GitHub](https://github.com/henrique73)

* Luis Gabriel Verola Santos - DEV Team

# Índice
* [O que é o Minha Jornada?](https://github.com/PITime01/Minha-Jornada/blob/master/README.md#minha-jornada)
* [Visão da solução](https://github.com/PITime01/Minha-Jornada/blob/master/README.md#vis%C3%A3o-da-solu%C3%A7%C3%A3o)
* [Benefícios](https://github.com/PITime01/Minha-Jornada/blob/master/README.md#benef%C3%ADcios)
* [Principais deliverables](https://github.com/PITime01/Minha-Jornada/blob/master/README.md#principais-deliverables)
* [Limites e Restrições da Solução](https://github.com/PITime01/Minha-Jornada/blob/master/README.md#limites-e-restri%C3%A7%C3%B5es-da-solu%C3%A7%C3%A3o)
* [User Roles](https://github.com/PITime01/Minha-Jornada/blob/master/README.md#user-roles)
* [User Stories](https://github.com/PITime01/Minha-Jornada/blob/master/README.md#user-stories)
* [story Card](https://github.com/PITime01/Minha-Jornada/blob/master/README.md#story-card)
* [Artefatos e Tecnologias](https://github.com/PITime01/Minha-Jornada#artefatos-e-tecnologias)
* [Cronograma de Entregas](https://github.com/PITime01/Minha-Jornada#cronograma-de-entegras)
* [Manual do Usuário](https://github.com/PITime01/Minha-Jornada/blob/master/README.md#manual-do-usu%C3%A1rio)


# Minha-Jornada
![minhajornada](https://github.com/PITime01/Minha-Jornada/blob/master/documentos/minhajornada.png)

No Brasil o sistema rodoviário é responsável por mais de 60% do escoamento de mercadorias. Este cenário, suscita uma demanda relevante de motoristas que percorrem as regiões do Brasil transportando as mesmas. 

Diante da demanda frequente de motoristas percorrerem grandes distâncias por um longo período para realizarem entregas, é necessário que haja um meio de registro de sua jornada de trabalho, repouso, horário de alimentação e hora extra. 

A jornada que um motorista deve cumprir varia de acordo com a filiação sindical do motorista, o que de fato traz complexidade no acompanhamento da jornada de trabalho tanto para o motorista quanto para a empresa de logística. 

A solução proposta por este software permite que o motorista e a empresa controlem a jornada de trabalho em um sistema único de forma a cumprir a lei e os acordos coletivos assinados pelos sindicatos representantes da categoria. Desta forma o software se adapta ao usuário e sua filiação sindical, evitando erros de registro.  

Portanto este software consolidará registros de acordo com o cumprimento da lei e dos acordos coletivos de forma parametrizável, removendo a complexidade do acompanhamento da jornada de trabalho dos motoristas. 

# Visão da Solução
O Minha Jornada é um software que oferece registro da jornada de trabalho do motorista que transporta entregas, ajustando-se ao acordo coletivo sindical do usuário, além de permitir o controle e visualização dos registros pela empresa de logística, assim como permite coletar dados para a folha de pagamento. 

# Benefícios
* Permite registro da jornada de trabalho
* Ajusta a jornada de trabalho com o acordo coletivo sindical
* Permite registro dos veículos utilizados para transporte
* Possui sistema de registros de alertas
* Extrai dados hora extra e banco de horas para folha de pagamento

# Principais deliverables 
* Interface de login com permissões e visualizações para perfis diferentes 
* Banco de dados de registro do motorista 
* Banco de dados dos sindicatos 
* Banco de dados de funcionários
* Banco de dados de veículos
* Botão de emergência para motorista comunicar central
* Sistema de alertas
* Status de usuários 
* Documento de Especificação 
* Documento de plano de teste 
* Manual do usuário 

# Limites e Restrições da Solução 
O acesso poderá ser feito por meio de aplicativo em tempo futuro, necessitando de um novo cronograma para criação de interface para sistemas android e IOS. 
O acesso se limita à locais com rede, podendo ser futuramente atualizado para armazenar registros e enviá-los quando houver rede disponível. 
O sistema não verifica geolocalização ou se o veículo está ligado. 

# User Roles 
Os usuários previstos estão descritos conforme imagem abaixo: 

![User Roles](https://github.com/PITime01/Minha-Jornada/blob/master/documentos/User%20Roles.jpg)

### Detalhamento das funções dos perfis: 


* Motorista: Registra sua jornada de trabalho contemplando hora extra, repouso e tempo trabalhado. Possui permissão de acesso para leitura e escrita destes dados para seu login.

* Administrador: Possui permissão de conceder acessos e realizar alterações em todos os registros. Sendo estes de escrita e leitura.

* Administrativo-gestor: Possui permissão para relatórios sobre o sistemas sem alterá-los.

* Equipe RH: Possui permissão de coletar dados da jornada de trabalho de modo a gerar a folha de pagamento.

# User Stories
[User Stories](https://github.com/PITime01/Minha-Jornada/blob/master/documentos/User%20Stories.pdf)
![Motorista_1](https://github.com/PITime01/Minha-Jornada/blob/master/imagens/USER%20STORIES/motorista_1.jpg)
![Motorista_2](https://github.com/PITime01/Minha-Jornada/blob/master/imagens/USER%20STORIES/motorista_2.jpg)
![Administrador_1](https://github.com/PITime01/Minha-Jornada/blob/master/imagens/USER%20STORIES/administrador_1.jpg)
![Administrador_2](https://github.com/PITime01/Minha-Jornada/blob/master/imagens/USER%20STORIES/administrador_2.jpg)
![Administrador Gestor_1](https://github.com/PITime01/Minha-Jornada/blob/master/imagens/USER%20STORIES/administrador%20gestor_1.jpg)
![Administrador Gestor_2](https://github.com/PITime01/Minha-Jornada/blob/master/imagens/USER%20STORIES/administrador%20gestor_2.jpg)
![Equipe RH](https://github.com/PITime01/Minha-Jornada/blob/master/imagens/USER%20STORIES/Equipe%20RH_1.jpg)

# Story Card

![Story Card](https://github.com/PITime01/Minha-Jornada/blob/master/documentos/STORY%20CARDS.gif)

# Artefatos e Tecnologias

![Artefatos e Tecnologias](https://github.com/PITime01/Minha-Jornada/blob/master/documentos/artefatos%20e%20tecnologias.gif)

# Cronograma de Entregas
|Data|Entrega|
|-----|--------|
|27/09|[SPRINT 0](https://github.com/PITime01/Minha-Jornada/blob/SPRINT_0/README.md)|
|18/10|[SPRINT 1](https://github.com/PITime01/Minha-Jornada/blob/SPRINT_1/README.md)|
|08/11|[SPRINT 2](https://github.com/PITime01/Minha-Jornada/blob/SPRINT-2/README.md)|
|29/11|[SPRINT 3](https://github.com/PITime01/Minha-Jornada/blob/SPRINT-3/README.md)|

# Manual do Usuário
[MANUAL DO USUÁRIO](https://github.com/PITime01/Minha-Jornada/blob/SPRINT-3/SPRINT%203/Manual__do_usu%C3%A1rio.md)

