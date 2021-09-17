# Projeto Integrador 2° Semestre BD - Equipe 1 - Trinity
![Trinity_Logo](https://user-images.githubusercontent.com/60863640/94086088-4fb53a00-fde0-11ea-9915-3ac9be131de7.png)

## :pushpin: Introdução
A equipe Trinity foi solicitada pela empresa TecSUS para o desenvolvimento de um software que tem por objetivo facilitar a digitação por parte da sua equipe para as contas de água e luz. O software oferece uma facilidade maior para seus usuários, automatizando processos e diminuindo o tempo de cadastro, além da prevenção de erros por parte dos digitadores e gerando um relatório sobre o consumo e custos de água e luz de cada cliente.

### :book: Índice
* [Membros da equipe](#necktie-membros-da-equipe)
* [Product Backlog](#gift-product-backlog)
* [Sprints](#airplane-sprints)
* [Entregas](#dart-entregas)
* [Funcionamento do projeto](#paperclip-funcionamento-do-projeto)
* [Documentação](#cloud-Documentação)
* [Tecnologias utilizadas](#computer-tecnologias-utilizadas)


### :necktie: Membros da equipe
* [Bahij Jihad Noureddine](https://www.linkedin.com/in/bahij-noureddine-941b681b7/) - Developer
* [Ramon Fernandes Rosario](https://www.linkedin.com/in/ramon-fernandes-19244a1ab/) - Developer
* [Gabriel Timóteo dos Santos](https://www.linkedin.com/in/gabriel-santos-2563571b2/) - Developer
* [Gabriel Henrique de Souza Ferraz](https://www.linkedin.com/in/gabriel-henrique-de-souza-ferraz-4873581b2/) - Developer
* [Hugo Wagner da Silva Gomes dos Santos](https://www.linkedin.com/in/hugo-wagner-692b83150/) - Product Owner(PO)
* [Gabriel Soares Gonçalves](https://www.linkedin.com/in/gabriel-soares-gon%C3%A7alves-a2b35a1b2/) - Scrum Master


### :gift: Product Backlog
#### 1. Cadastro e visualização de contas/água de empresas.<br/>
Eu como digitador desejo uma plataforma simples e intuitiva para cadastro de contas de água e energia, além da visualização das contas já registradas, desse modo, proporcionando uma melhor produtividade e agilidade no processo de digitação, prevenindo possíveis erros. 
#### 2. Seleção dos tipos de conta.<br/>
Eu como digitador desejo um recurso para selecionar a categoria de conta a ser preenchida (água/energia). Abrindo uma aba específica para cada uma, com formulários distintos, contendo campos específicos relacionados a cada tipo de conta, para diminuir os erros de digitação.
#### 3. Prevenção de erros de registro.<br/>
Eu como digitador desejo ser alertado quando cometer erros de registros. A exemplo do envio de campos em branco e/ou falta de caracteres necessários. Para evitar possíveis erros no cadastro de contas.
#### 4. Automatização na obtenção de dados (Cliente/Fornecedor).<br/>
Eu como digitador espero obter informações de clientes e fornecedores já registrados, de forma automática, por meio da busca do Número de Instalação ou RGI. Sendo apenas necessário o preenchimento da telas de cadastro (água/energia). Com intuito de agilizar o processo de digitação.
#### 5. Gerador de relatórios de consumo e custos.<br/>
Eu como analista de água ou energia desejo obter acesso aos relatórios de consumo e custo de energia e água, agrupados por cliente, disponibilizados em PDF. Para análise dos dados, proporcionando ao cliente uma avaliação sobre gastos e consumos no mês vigente.

### :airplane: Sprints
1. Na primeira sprint, a equipe realizou a criação do layout das telas de cadastros com os campos de preenchimentos necessários e finalizou as configurações da plataforma Gitpod com as ferramentas necessárias para iniciar o desenvolvimento do projeto. Além disso foi realizado a criação do Product Backlog.<br/> Duração: 07/09/2020 até 27/09/2020.
2. Na segunda sprint, a equipe realizou o desenvolvimento das telas para o fluxo de cadastro de contas de uma nova instalação, com JavaFX para parte visual (front-end) e Java para lógica entre as telas (back-end). Além de elaborar a modelagem do Banco de Dados que será implementado em futuras sprints.<br/> Duração: 28/09/2020 até 18/10/2020.
3. Na terceira sprint, a equipe desenvolveu os Users Stories 2 e 3 do Product Backlog, implementou o banco de dados em MySQL, realizou ajustes necessários nas telas de cadastro, além de dar inicio ao desenvolvimento da documentação (Aplicativo executável e especificações mínimas necessárias da máquina) do projeto.<br/>
Duração: 19/10/2020 até 08/11/2020.
4. Na quarta sprint, a equipe realizou o Users Stories 4 e 5 do product Backlog, finalizou a documentação e  adicionou um novo fluxo para instalações já cadastradas. Atribuindo as funcionalidades de busca por CPF, CNPJ e CEP de cliente, além de entregar o relatório (água, energia e cliente) e o executável do projeto em suas formas finais.<br/>
Duração: 09/11/2020 até 29/11/2020

### :dart: Entregas
1. Apresentação da Equipe Trinity e da problemática do trabalho. Além da demonstração dos Wireframes (representação das telas do software) e Product Backlog (funcionalidades do sistema). Disponíveis nos seguintes links:
   * [PowerPoint](https://drive.google.com/file/d/1QBe3fj6P33IbdpLLv37yWxnmgwYGU8Tq/view?usp=sharing)
   * [Video(YouTube)](https://www.youtube.com/watch?v=k5cMXUFGKQs)
   
2. Apresentação do desenvolvimento realizado durante a segunda sprint, elaboração das telas para um primeiro cadastro e mudança no fluxo de funcionamento. Disponíveis nos seguintes links:
   * [PowerPoint](https://drive.google.com/file/d/1WFf6pF68s_2zgYqzR50OJI3VAGwB6fFH/view?usp=sharing)
   * [Video(YouTube)](https://www.youtube.com/watch?v=t8BieTIL9Lc&feature=youtu.be)
   
3. Apresentação do desenvolvimento realizado durante a terceira sprint, elaboração do Banco de Dados e da Documentação do Projeto. Disponível no seguinte link:
   * [Video(YouTube)](https://www.youtube.com/watch?v=HR_M4Nk9Ujk&feature=youtu.be)
 
4. Apresentação do desenvolvimento realizado durante a quarta sprint, elaboração do fluxo de Instalação já cadastrada e finalização da documentação, relatórios e executável. Disponível no seguinte link:
   * [Video(YouTube)](https://www.youtube.com/watch?v=eWoUZBkDxxY&feature=youtu.be)
   
   Entrega Final: 
   * [Video(YouTube)](https://www.youtube.com/watch?v=ypRg-BVygZI&feature=youtu.be)

### :paperclip: Funcionamento do projeto
#### A tela inicial apresenta três botões: Nova Instalação, Instalação já cadastrada e Relatórios. 

* Nova Instalação: Ao clicar nesse botão, o usuário será redirecionado para uma tela onde escolherá o tipo de cliente (Físico ou Jurídico) e cadastrará os dados da empresa e do fornecedor do serviço. Após isso, escolherá entre conta de água ou luz. Então, irá para outra página para preencher os dados da fatura, tendo uma opção para salvar os dados e voltar a tela inicial. Sendo que todos os passos apresentam uma confirmação de dados ao trocar de tela. Todos as informações registradas pelo funcionário serão reutilizadas no programa.

* Instalação já cadastrada: Ao clicar nesse botão, o usuário será redirecionado para uma tela onde vai colocar o RGI ou Número de Instalação de uma instalação que já foi cadastrada, assim será encaminhado para a página de escolha entre conta de água ou luz, e seguirá com o cadastro da conta escolhida, podendo salvá-la e retornar a tela inicial. O sistema reconhece as informações que se repetem de uma instalação já cadastrada e apenas requere campos que se modificam com novas contas, armazenando todos as informações necessárias.

* Relatórios: Ao clicar nesse botão, o usuário irá para uma página onde visualizará relatórios de consumo e custos das contas, agrupados por clientes. Podendo editar os dados presentes nessa seção.

### :cloud: Documentação

* [Repositório GitHUB](https://github.com/Hugowsgs/ART-Trinity)

###  :computer: Tecnologias utilizadas
* [Java](https://www.java.com/pt_BR/)
* [MySQL](https://www.mysql.com/)
* [Gitpod](https://www.gitpod.io/)
* [JavaFX](https://openjfx.io/)
* [MockFlow](https://mockflow.com/apps/wireframepro/)
* [Trello](https://trello.com/pt-BR)
* [StackEdit](https://stackedit.io/)
* [BrModelo2](http://www.sis4.com/brModelo/antigo.html)
