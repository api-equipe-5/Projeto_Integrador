![Capa-Sprint](https://user-images.githubusercontent.com/57918707/93690172-ad2d4c00-faab-11ea-9a28-d5e5574bdac8.jpeg)

# SPRINT 4

### Entrega: 23/11/2020 a 29/11/2020

![Card-Sprint-4](https://user-images.githubusercontent.com/57918707/98486394-cb860d00-21fb-11eb-8038-afa2e9f5a565.png)


Os requisitos que estão sendo entregues na quarta sprint, seguindo o backlog aprovado pelo cliente, são:

- Implementação da funcionalidade que permite que a aplicação seja usada por multiplos usuários simultâneamente
- Correção de bugs

### Como foi a experiência de participar deste projeto:

O projeto integrador tem o propósito de trabalhar diversas áreas de nosso curso e aplica-lás em um único desáfio, como consequência, aperfeiçoamos varias habilidades para a elaboração desse projeto. Dentre elas podemos citar aquilo que foi ensinado para nós como PACER - Proatividade, Autonomia, Colaboração e Entrega de Resultados. Esse conceito nós auxiliou principalmente no trabalho em equipe e na organização e no desenvolvimento estrutural do projeto. 

Além disso foi de essêncial importância o direcionamento de nossos professores para a conclusão dessa ferramenta. Como exemplo, podemos mencionar o nosso querido professor Giuliano Bertotti, que contribuiu para o nosso aprendizado, nos auxiliando no amadurecimento de nossas ideias para as áreas de UI e UX.

Após esses fatos, gostariamos de agradecer todo o conhecimento e apoio que nos foi dado durante o semestre pelos nossos mestres. Temos a total certeza que sairemos com uma bagagem extensa de sabedoria que será essencial para o nosso desenvolvimento profissional e pessoal.

### Quais são as funcionalidades da nossa ferramenta?

A VisGEO surgiu com a finalidade de solucionar o problema proposto pelo nosso cliente, onde que, ele tinha a necessidade de ter um sistema ETL simples, intuitivo e de baixo custo. Com esse desafio em mãos, desenvolvemos uma aplicação web, na qual realiza uma extração de dados georreferenciados de shapefiles, transformando e carregando essas informações para um banco de dados geográfico.

A seguir temos a demonstração explicita de todas as funcionalidades da aplicação:

#### - Segurança:

Para a utilização de nossa ferramenta é necessário que todos os usuários sejam cadastrados e autenticados no sistema. 

![sem autenticação](https://user-images.githubusercontent.com/56441371/98485237-b3aa8b00-21f3-11eb-8004-bbd61514c6ef.gif)

Além disso, para se registrar e logar na aplicação utilizamos um token criptográfado, pois para nós a segurança de nossos usuários é prioridade.

![ezgif com-gif-maker](https://user-images.githubusercontent.com/56441371/98485048-70035180-21f2-11eb-909e-3cec1c97d671.gif)

#### - Usabilidade pensando na simplicidade:

Autênticação no banco de dados de maneira simples.

![upload](https://user-images.githubusercontent.com/55189046/93727271-ca881600-fb90-11ea-9664-bf09c9b0bae2.gif)

O usuário possui autonomia, pois com o sistema DE → PARA para a realização do upload dos shapefiles, ele decide o que será salvo.

![configuring](https://user-images.githubusercontent.com/55189046/93727270-c9ef7f80-fb90-11ea-83e5-c96e0ae2a0bc.gif)

E caso não seja necessário realizar a configuração do DE → PARA, pode-se enviar diretamente todas as informações para o banco de dados com apenas um clique

![salvando direto](https://user-images.githubusercontent.com/56441371/98487551-5964f680-2202-11eb-9386-2806fc1c0167.gif)

Conseguimos também facilmente, baixar todos os shapefiles salvos no banco de dados.

![sprint2](https://user-images.githubusercontent.com/56457600/100559745-7e450a80-3292-11eb-816b-b1cfe497f6ea.gif)

## Gerenciamento das tarefas na sprint

![image](https://user-images.githubusercontent.com/45850297/100568066-db4bbb00-32a8-11eb-9454-15fd692d0eb5.png)

As tarefas acima foram divididas da seguinte forma:

- Tarefa 1: adequar as rotas de download para receber o token de cada usuário autenticado;
- Tarefa 2: corrigir o bug de exibição do modal, para que o usuário não tenha que se autenticar a cada refresh da página;
- Tarefa 3: adequar as rotas de expansão de objetos geográficos para cada instância de conexão com o banco;
- Tarefa 4: refatorar as rotas para evitar redundâncias;
- Tarefa 5: adequar chamadas no frontend para incluir token nas operações de download;
- Tarefa 6: adequar chamadas no frontend para incluir token nas operações de upload.

### Gráfico de burndown referente ao andamento da sprint

![image](https://user-images.githubusercontent.com/45850297/100567320-f5849980-32a6-11eb-8727-4eae9599f275.png)


