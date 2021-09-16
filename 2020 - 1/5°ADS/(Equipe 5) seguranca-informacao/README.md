# Sistema
O capítulo 6 Lei Geral de Proteção de Dados(LGPD) dispõe sobre os agente de tratamenteo de Dados Pessoas e na segundo seção deste capítulo encontra-se informação sobre o Encarregado pelo Tratamento de Dados Pessoas (DPO, em inglês Data Protection Officer). Dentro desta seção encontra-se uma descrição das atividades do DPO e entre as suas atividades podemos citar: 


* I - aceitar reclamações e comunicações dos titulares, prestar esclarecimentos e adotar providências; 
* II - receber comunicações da autoridade nacional e adotar providências; 

A LGPD possibilita a terceirização, indicação de uma pessoa jurídica junto a autoridade nacional para assumir esta função. Podendo uma pessoa jurídica responder a mais de uma empresa.

Pensando nisso, propõe-se uma plataforma para centralização das atividades de receber comunicados(reclamações e comunicações) e seus evenetuais desdobramentos (respostas). 

A aplicação será no estilo de chat onde uma conversa representa um comunicado e seus desdobramentos são as respostas desta conversa.

Um comunicado pode ser aberto por uma pessoa ou pela autoridade nacional

Um DPO poderá fazer seu cadastro na plataforma e cadastrar as empresas para qual prestar serviço para passar a receber os comunicados pela plataforma. 

Além disso, teremos uma tela com a lista do DPOs cadastrados afim de torná-los acessíveis para contratação de novas empresas.

## Integrantes
* [Gabriel Carvalho](https://github.com/Gamebielo)


  [![LinkedIn][linkedin-shield]][linkedin-biel]
* [Lucas Salvador](https://github.com/LASalvador)
  
  
  [![LinkedIn][linkedin-shield]][linkedin-salva]
* [Lucas Ribeiro](https://github.com/lrsonnewend)


  [![LinkedIn][linkedin-shield]][linkedin-sonne]
* [Mayara Brígida](https://github.com/mayaramedeiros)


  [![LinkedIn][linkedin-shield]][linkedin-brigida]
* [Paulo Henrique Correia](https://github.com/PauloHenrique7010)


  [![LinkedIn][linkedin-shield]][linkedin-paulo]


## Entregas
### Backend
  **Sprint 1**
   - Criação de API REST com express
   - Adição de ORM
   - Adição dos modelos Comunicado e Resposta
   - Rotas de comunicado (get, post, put e delete)
     - crud de comunicado
   - Rotas de reposta (get, post, put e delete)
     - crud das resposta de um comunicado
   - Geração de chave de acesso para o comunicado
   
   
  **Sprint 2**
   - Adição do Modelo DPO
   - Rotas de DPO (get, post, put e delete);
     - Crud de DPO
   - Rotas de Validação de chave de acesso ao Comunicado

  **Sprint 3**
  - Rota de Login
    - geração de JSON Web Token(JWT) para validação de sessão do usuário
  - Adição de serviço de email(Nodemailer)
    - Criação de métodos que possibilitam o envio de email para um usuário

  **Sprint 4**
  - Adição de criptografia nas mensagens
  - Adição de criptografia para salvar senhas
  - Adição de envio de email ao cadastrar um comunicado
  
  **Sprint 5**
  - Geração de LOG
  - Atualização de alguns controllers
  
  **Sprint 6**
  - Adição de Log a nível de S.O
  - correção de endpoints e serviços

### FrontEnd
   **Sprint 1**
   - Criação de projeto react 
   - Adição de biblioteca Material-UI
   - Adição de telas e comportamentos
     - Tela de Chat
     - Tela de lista de comunicados

   **Sprint 2**
   - Tela de chat
     - Carregamento de mensagens já enviadas
     - Adição de novas mensagens
     - Cores diferentes para mensagens de DPO
     - Modal para adicionar chave(token) de acesso a conversa
   - Tela de lista de comunicados
     - Carregamento de comunicado abertos
     - Direcionamento para tela com mensagens do comunicado
   - Adição de tela de cadastro comunicado
     - Formulário para cadastramento de comunicado
  
  **Sprint 3**
   - Tela de Login para DPO
     - Criação de tela
     - Ligação com a API para realizar o login
   - Tela de cadastro para DPO
      - Criação de tela
      - Ligação com a API para realizar o cadastro
   - Tela de chat
     - Ligação com a API para validar o chave de acesso gerada
     
  **Sprint 4** 
   - Adição de controle de sessão do usuário usando JWT gerado
    
  **Sprint 5**
   - Criação de landing page
   - Atualização de rotas
   - Finalização de cadastro de comunicado
   
  **Sprint 6**
   - Adição da tela de Logs 
   - Correção de rotas
   - Limpando importações

## Tecnologias

* React.js
* Node.js

## Execução
### Execução client

> cd client 

> npm install

> npm run start

### Execução

> cd server

> npm install

> node index.js


[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-salva]: https://www.linkedin.com/in/lassalvador/
[linkedin-brigida]: https://www.linkedin.com/in/mayara-br%C3%ADgida-398733182/
[linkedin-paulo]: https://www.linkedin.com/in/paulo-henrique-36355316b/
[linkedin-biel]: https://www.linkedin.com/in/gabriel-carvalho-b937a5160/
[linkedin-sonne]: https://www.linkedin.com/in/lucas-sonnewend-a87a66180/
