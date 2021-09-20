# Semaforo do Consumidor

## 1. Apresentação do Projeto
O Semáforo do Consumidor tem como objetivo premiar os consumidores brasileiros com saúde financeira e incentivar o empreendedorismo como saída para consumidores brasileiros que estão passando por um momento de dificuldade em fazer o pagamento de suas contas em dia. 

Através da análise das informações do cadastro positivo, avaliar o histórico de pagamentos, recompensando com descontos exclusivos, cashback, crédito, etc aqueles que tem o semáforo verde ou amarelo e auxiliar quem está no vermelho com um dicas, cursos personalizados e incentivos para começar o seu negócio através de cursos e descontos em plataformas de marketplace, assim, promovendo o desenvolvimento de negócios locais.

### 1.1 Visão do Projeto
A entrega de valor do Semáforo do consumidor está em estimular toda a cadeia de consumo de forma consciente, estimulado aqueles que estão com uma situação financeira ruim a conseguir sua independência financeira, para aqueles que estão confortáveis financeiramente incentivos ao consumo com qualidade e com as melhores condições, e para empresas parceiras o direcionamento de consumidores qualificados, aumentando assim o índice de vendas e comissões.

### 1.2. Apresentação da Evolução do Projeto

Sprint 0  | Sprint 1 | Sprint 2 | Sprint 3  
--------- |--------- |--------- |--------- |
[Apresentação 0](https://github.com/pi-fatec-bd/cadastro-mais/blob/master/assets/sprint0.pdf) |[Apresentação 1](https://www.youtube.com/watch?v=7KiylucX0bA&feature=youtu.be) |[Apresentação 2](https://youtu.be/gPBcxXvGQVM) |[Apresentação 3 - Final](https://drive.google.com/file/d/1gxDq6ierIRJOLF05VfDvxJMG-zqsA8_M/view) |

#### Burndown da Sprint 2

[Burndown 2](https://github.com/pi-fatec-bd/semaforo-consumidor/blob/master/assets/burndown.png)

#### Burndown da Sprint 2

[Burndown 3](https://github.com/pi-fatec-bd/semaforo-consumidor/blob/master/assets/burndown-sprint3.PNG)


### 1.3. Plano de Negócios

* [Plano de Negócios](https://github.com/pi-fatec-bd/semaforo-consumidor/wiki/PLANO-DE-NEG%C3%93CIOS----SEM%C3%81FORO-DO-CONSUMIDOR)

### 1.4. Wiki do Projeto

Na Wiki do projeto você pode conferir mais detalhes do projeto como as Personas, o Setup, regras para criação de APIs e muitos outros detalhes da documentação.

* [Wiki Semáforo do consumidor](https://github.com/pi-fatec-bd/semaforo-consumidor/wiki)

### 1.5. Equipe

Equipe 3 - Comix

---

## 2. Arquitetura do Projeto
![Arquitetura Macro](https://github.com/pi-fatec-bd/cadastro-mais/blob/master/Arquitetura%20Macro.png)
### 2.1. Front-end

#### 2.1.1. View
Camada única do front-end com nenhuma regra de negócio.

### 2.2. Back-end

####  2.2.1. REST Controller
Camada dos controllers seguindo o padrão REST

####  2.2.2. Model
Camada do Model concentrando as regras de negócio, DTOs, serviços e entidades.

#### 2.2.1. DTO
Camada para transformação das entidades em modelos adaptados para o front-end.

#### 2.2.2. Service
Camada de regra de negócio que envolve duas ou mais entidades.

#### 2.2.3. Entity
Camada refletindo as entidades do banco de dados, concentrando as regras de negócios referente as entidades e conexões com o banco de dados

### 2.3 DB
Banco de dados

---

## 3. Backlog

### 3.1. Requisitos Funcionais (Story Cards)

#### 3.1.1 Sprint 1
R01. Como PF (pessoa física), o usuário pode se cadastrar no Semáforo do Consumidor através da tela de cadastro;

R02. Como PF (pessoa física), o usuário pode se descadastrar no Semáforo do Consumidor;

R03. Como PF (pessoa física), o usuário pode consultar seu score;

R04. Como PF (pessoa física), o usuário deve ser capaz de entender seu score;

R05. Como PF (pessoa física), o usuário pode consultar seus dados (endereço, informações de contato, dívidas e pagamentos realizados) no Semáforo do Consumidor;

R09. Como PF (pessoa física), o usuário pode consultar o score de CPFs de terceiros;

R10. Como PF (pessoa física), o usuário pode consultar os dados (endereço, informações de contato, situação do CPF na receita, dívidas e pagamentos realizados) de CPFs de terceiros caso estes estejam disponíveis;

R15. Como PJ (pessoa jurídica), o usuário pode se cadastrar no Semáforo do Consumidor;

R16. Como PJ (pessoa jurídica), o usuário pode se descadastrar no Semáforo do Consumidor;

#### 3.1.2 Sprint 2
R07. Como PF (pessoa física), o usuário pode bloquear a visualização dos seus dados (com exceção do score) para uma empresa específica;

R08. Como PF (pessoa física), o usuário consegue bloquear a visualização dos seus dados para todos os usuários;

R17. Como PJ (pessoa jurídica), o usuário pode consultar o score de CPFs de terceiros;

R18. Como PJ (pessoa jurídica), o usuário pode consultar o dados financeiros de CPFs de terceiros se eles estiverem desbloqueados;

R19. Como PJ (pessoa jurídica), o usuário deve entender o que significa o score e como ele é calculado;

#### 3.1.3 Sprint 3
R12. Como PF (pessoa física), o usuário com score médio ou alto pode cadastrar intenção de compra de algum produto ou serviço para receber dicas e descontos sobre o produto;

R13. Como PF (pessoa física), o usuário com score baixo receberá descontos e incentivos para que ele possa empreender e aumentar o seu score;

R14. Como PF (pessoa física), o usuário com score médio/alto receberá dicas de empresas que podem oferecer produtos e descontos do interesse dele de acordo com o seu perfil de compras;

R20. Como PF (pessoa física) ou PJ (pessoa jurídica), o usuário pode consultar uma base de dados de perguntas comuns ou base de conhecimento;

R33. Como PJ (pessoa jurídica), o usuário pode cadastrar oportunidades de incentivo ao empreendedorismo.

R34. Com PF (pessoa física), o usuário pode consultar o histórico de pagamentos próprio e de terceiros.

### 3.2. Requisitos não Funcionais
R21. Linguagem programação (Stack) Java - Requisito Fatec;

R22. Banco de dados relacional - Requisito Fatec;

R23. Plano de negócio (forma de venda e monetização da informação);

R24. Sistema estruturado para tratar grande volume de dados;

R25. Regras de negócio parametrizáveis para adequação rápida às novas normas;

R26. Camadas de integração explícitas no projeto;

R27. Atender à legislação do cadastro positivo;

R28. As informações devem ser apresentadas de forma organizada, amigável e intuitiva;

R29. Os relatórios não poderão apresentar informações pessoais, confidenciais ou sigilosas;

R30. O design consistente e padronizado;

R31. Prevenção de erros;

R32. Ajuda e documentação do produto;

---

## 4. Wireframe
Aqui temos o Wireframe incial do projeto. Wireframe é um protótipo usado em design de interface para sugerir a estrutura de uma aplicação ou site. Aqui, estão os designs inciais das telas de login, sign up, perfil do usário e adição de dados do próprio usuário.

### 4.1. Tela de login
Tela inicial da aplicação para o usuário realizar o login. Caso não possua conta, há um link que o redireciona para a criação de conta.
<p align="center"> Versão desktop </p>
<p align="center">
  <img src="./media/login/web.png" alt="Logo" width=50% height=50%>
</p>
<p align="center"> Versão Mobile </p>
<p align="center">
  <img src="./media/login/phone.png" alt="Logo" width=50% height=50%>
</p>

### 4.2. Tela de criação de usuário
Nesta tela o usuário fornece alguns dados para validação e criação de conta.
<p align="center"> Versão desktop </p>
<p align="center">
  <img src="./media/signUp/web.png" alt="Logo" width=50% height=50%>
</p>
<p align="center"> Versão Mobile </p>
<p align="center">
  <img src="./media/signUp/phone.png" alt="Logo" width=50% height=50%>
</p>

### 4.3. Tela do perfil do usuário
Nesta tela o usuário pode ver detalhes de sua conta. O item principal é o score com os motivos da nota e um CTA para dicas de como aumentar seu score, seja fornecendo dados para a análise ou de outras maneiras.
<p align="center"> Versão desktop </p>
<p align="center">
  <img src="./media/user/window.png" alt="Logo" width=50% height=50%>
</p>
<p align="center"> Versão Mobile </p>
<p align="center">
  <img src="./media/user/phone.png" alt="Logo" width=50% height=50%>
</p>

### 4.4. Tela para usuário informar novos dados
Nesta tela o usuário atualiza sua conta, informando dados não obrigatórios, mas que auxiliam no cálculo do score e para mapeamento dos usuários por região, renda e etc.
<p align="center"> Versão desktop </p>
<p align="center">
  <img src="./media/userdata/web.png" alt="Logo" width=50% height=50%>
</p>
<p align="center"> Versão Mobile </p>
<p align="center">
  <img src="./media/userdata/phone.png" alt="Logo" width=50% height=50%>
</p>

---

## 5. Modelagem do Banco de Dados
<p align="center">
  <img src="./media/uml.png" alt="uml" width=50% height=50%>
</p>

---

## 6. Equipe

* André Luiz Dias Custódio - [linkedIn](https://www.linkedin.com/in/andr%C3%A9-luiz-d-146213a7/)

* André Lars da Cunha - [linkedIn](https://www.linkedin.com/in/andre-lars-da-cunha/)

* Dalwesley Ferreira Duarte - [linkedIn](https://www.linkedin.com/in/dalwesley-duarte/)

* Felipe Gustavo Braga - [linkedIn](https://www.linkedin.com/in/felipegbraga/)

* Vinicius Fernandes de Lima - [linkedIn](https://www.linkedin.com/in/vin%C3%ADcius-fernandes-de-lima-06160b162/)
