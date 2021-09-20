![Capa-Sprint](https://user-images.githubusercontent.com/57918707/93690172-ad2d4c00-faab-11ea-9a28-d5e5574bdac8.jpeg)

# SPRINT 3

![Card-Sprint-3](https://user-images.githubusercontent.com/57918707/98486400-d50f7500-21fb-11eb-9fdc-882e493c35a1.jpeg)

A terceira sprint possui as seguintes funcionalidades a serem entregues, conforme o backlog aprovado:

- Feature 1: Implementação do CRUD de usuários da ferramenta;
- Feature 2: Permitir a criação de novas tabelas pelo usuário, possibilitando salvar qualquer shapefile.

### Justificativa de priorização das features entregues:

Os últimos requisitos funcionais estabelecidos pelo cliente foram entregues na sprint 2, que eram os seguintes:

- RF01: Sistema web ETL enviando e salvando shapefiles na base de dados do cliente;
- RF02: Interface funcional de seleção relacionando os campos do shapefile com as colunas das tabelas pré-definidas;
- RF03: Expansão dos objetos de forma multipolígono, multilinha e multiponto para polígono, linha e ponto, respectivamente;
- RF04: Sistema de download de shapefiles extraídos de tabelas existentes em qualquer base de dados Postgis.

### Por que selecionamos estas novas funcionalidades para esta sprint?

Desenvolvemos um sistema focado no upload e download de 3 arquivos escolhidos pelo cliente. Entretanto, a nossa ferramenta poderia se aplicar para qualquer shapefile, e não apenas para este escopo limitado. 

Pensando neste valor, que é possibilitar o uso para qualquer caso, definimos a feature 2 desta sprint. Ela consiste da opção de salvar o shapefile diretamente, criando uma nova tabela no banco de dados com o nome do arquivo escolhido, com todos os seus campos. Desta forma, o usuário pode salvar shapefiles com tabelas existentes, e, caso prefira, apenas salvá-los diretamente.

Com estas funcionalidades, o cliente pode salvar o que quiser, tendo o suporte para salvar e extrair qualquer shapefile.
Além disso, agora o uso da ferramenta pode ser controlado pois é possível realizar cadastros, que é uma funcionalidade entregue além dos requisitos mínimos.

Portanto, atendemos os seguintes novos requisitos, que foram combinados no backlog total do produto:

- RF05: Permitir a carga de qualquer shapefile, mesmo sem nenhuma tabela já existente para comportá-lo;
- RF06: Cadastro de usuários na VisGeo;
- RF07: Autenticação dos usuários cadastrados para uso da ferramenta.

### Protótipo da ferramenta

O projeto já está funcional, e o guia de execução está disponível no readme da branch master. Entretanto, caso queira visualizar o wireframe da VisGeo, ele pode ser acessado clicando <a href="https://www.figma.com/proto/pZ40saBOjKAdqq4we9BzuN/Projeto-Visiona?node-id=112%3A38&scaling=scale-down" target="_blank">aqui.</a>

### Novas funcionalidades em execução

Quando o usuário tenta entrar sem estar autenticado damos a opção para ele fazer o login ou se registrar, ou seja nenhum usuário sem registro pode usar a aplicação:

![sem autenticação](https://user-images.githubusercontent.com/56441371/98485237-b3aa8b00-21f3-11eb-8004-bbd61514c6ef.gif)

Usuário se registrando e entrando na aplicação com o token:

![ezgif com-gif-maker](https://user-images.githubusercontent.com/56441371/98485048-70035180-21f2-11eb-909e-3cec1c97d671.gif)

Funcionalidade de criar uma tabela e salvar o shapefile diretamente com todos os campos:

![salvando direto](https://user-images.githubusercontent.com/56441371/98487551-5964f680-2202-11eb-9386-2806fc1c0167.gif)


### Acompanhamento das tarefas na sprint:

As tarefas da sprint 3 foram organizadas da seguinte forma:

![table-tasks](https://user-images.githubusercontent.com/45850297/98471242-b09aa500-21c9-11eb-80e8-bb9c281e24f2.png)

Com as seguintes atribuições:

- Tarefa 1: criar as classes para o CRUD de usuários (Evandro, Raquel e Matheus);
- Tarefa 2: organizar a aplicação de autenticação e cadastro no formato MVC (Evandro, Raquel e Matheus);
- Tarefa 3: criar método e rota de carga de shapefiles de forma automática, sem preparação "de-para" (José e Cristiane);
- Tarefa 4: ajustar a interface gráfica no protótipo para adequar a nova funcionalidade (Washington e Luis);
- Tarefa 5: adicionar os novos ajustes no front-end (Leonardo e Pedro);
- Tarefa 6: deploy dos ajustes no front-end com integração com a nova rota do backend (Leonardo e Pedro);
- Tarefa 7: documentação da sprint, explicando a priorização e valores entregues (José, Cristiane, Washington e Luis).

![burndown-3](https://user-images.githubusercontent.com/45850297/98470141-94473a00-21c2-11eb-9e37-d790605c5add.png)


