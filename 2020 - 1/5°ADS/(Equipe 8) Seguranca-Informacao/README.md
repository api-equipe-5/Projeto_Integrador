<img src="img/logo_fatecsjc.png" height=150px>

# Seguranca da Informacao
Projeto sobre LGPD desenvolvido nas aulas de Seguranca da Informação da Fatec SJC.

A LGPD, em seu art. 18, V, prevê o direito à portabilidade dos dados a outro fornecedor de serviço ou produto, mediante a uma requisição. Para que a portabilidade ocorra, o controlador deve fornecer os dados em um formato estruturado e interoperável entre os sistemas.

Para o desenvolvimento do projeto, foi escolhido um sistema para o gerenciamento de dispositivos IoT.

## Integrantes: 
Victor de Souza Dias Carvalho Goulart

## Tecnologias utilizadas:
- [<img src="img/logo_nodejs.png" height=40px>](https://nodejs.org/en/) Node.js

- [<img src="img/logo_react.png" height=40px>](https://reactjs.org/) React

- [<img src="img/logo_postgresql.png" height=40px>](https://www.postgresql.org/) PostgreSQL
  
# Sprints anteriores
- [Sprint 3: Backend + Frontend + BD para iniciar o desenvolvimento](https://github.com/GrT1212/Seguranca-Informacao/tree/V1.0.0)
- [Sprint 4: Rotas para requisitar portabilidade dos dados e criptografia](https://github.com/GrT1212/Seguranca-Informacao/tree/V2.1.0)
- [Sprint 5: : Autenticação com OAUTH 2.0](https://github.com/GrT1212/Seguranca-Informacao/tree/V3.0.0)
  
# Sprint 6: Entrega final
Nessa sprint foi atualizado o frontend, adicionado ao README um "manual" de instalação e execução e adicionada uma segunda aplicação para melhor demonstrar o funcionamento da portabilidade de dados.

# Instalação e execução
Para a execução do projeto, é necessaria a instalação do [Node.js](#tecnologias-utilizadas) e [PostgreSQL](#tecnologias-utilizadas).
## Nos diretórios backend e frontend (também na segunda_aplicacao):
### 1 - Instale as dependências do projeto
> npm install
## Na raiz do projeto
### 1 - Execute o comando para gerar a pasta "secrets" e arquivos necessários
> node config_project.js
### 2 - Edite os arquivos "backend/secrets/databaseConfiguration.js" e "segunda_aplicacao/backend/secrets/databaseConfiguration.js" com os dados do PostgreSQL
> user: Usuário do banco de dados,\
> host: Host do banco de dados,\
> database: Nome do banco de dados,\
> password: Senha do usuário do banco de dados,\
> port: Porta que o banco de dados utiliza
### 3 - Edite os arquivos "backend/secrets/index.js" e "segunda_aplicacao/backend/secrets/index.js"
> APP_SECRET = String que será usada para gerar *hashes* na aplicação
### 4 - Crie uma credencial OAuth utilizando uma conta google.
> Lembre-se que as aplicacoes estão configuradas para utilizar os ports 1234, 1235, 3000 e 3001
> https://support.google.com/googleapi/answer/6158849?hl=en
### 5 - Edite os arquivos "backend/secrets/keys.js" e "segunda_aplicacao/backend/secrets/keys.js"
> clientID: Client ID da credencial OAuth,\
> clientSecret: Client  da credencial OAuth,\
> cookieKey: String que será usada para gerar o cookie de sessão na aplicação
### 6 - Edite os arquivos ".pem" com um par de chaves privada e publica RSA