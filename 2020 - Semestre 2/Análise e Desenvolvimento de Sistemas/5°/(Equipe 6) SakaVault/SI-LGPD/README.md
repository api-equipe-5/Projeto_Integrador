<p align="center">
  <img src="https://user-images.githubusercontent.com/45819790/95216216-30e37a00-07c8-11eb-8e66-08c43c80747e.png" alt="Logo do Saka Vault" height="120px" style=max-width:100%>
</p>
  
  ##
<p align="center">
  <a href="#problema">Problema</a> |
  <a href="#solução">Solução</a> |
  <a href="#tecnologias-utilizadas">Tecnologias Utilizadas</a> |
  <a href="#overview-técnico">Tech Overview</a> |
  <a href="#metodologia-owasp">Owasp</a> |
  <a href="#modelo-de-dados">Modelo de Dados</a> |
  <a href="#chaves-externas-de-criptografia">Chaves Externas</a> |
  <a href="#entregas">Entregas</a> |
  <a href="#saiba-mais">Saiba mais</a>
</p>

##
FATEC São José dos Campos - Professor Jessen Vidal

**Professor:** Eduardo Sakaue

O SakaVault é um gerenciador de senhas e ele permite o armazenamento de nomes de usuário e senhas das suas contas online em um local seguro. Ao usar um gerenciador de senhas, você pode usar uma senha exclusiva e complexa para cada uma das suas contas online, sem precisar se lembrar de todas elas.  

## Equipe: 

| **INTEGRANTES**         									|
|---------------------------------------------------|          
| Caroline Faria Nunes                    | 
| Davi Ramos Andrade								|
| Débora Cristina Santos                 |
| Eduardo Vinicius Maia								|
| Luan Matheus Satiro de Oliveira					|
| Pedro Henrique Cerqueira Fernandes (Scrum Master)	|
| Rafael Augusto Campos Plinio						|

## Problema
### Como proteger o acesso aos dados privados do usuário? :closed_lock_with_key:
Com a nova LGPD, prevista para 03 de maio de 2021, os dados sensíveis dos usuários precisarão ser criptografados no banco de dados, sendo necessária a utilização de alguma tecnologia para a implementação da segurança destes dados.

## Solução
* Utilizar uma chave única e simétrica para cada usuário para criptografar (AES) os dados sensíveis;
* As chaves únicas serão armazenadas na nuvem;
* A chave será utilizada somente quando houver a necessidade de acessar os dados criptografados.

A imagem abaixo ilustra o fluxo da <a href="https://sakavault.netlify.app">aplicação</a>:
<p align="left">
  <img src="https://user-images.githubusercontent.com/45819790/100869791-4ef1f180-347c-11eb-8695-9a99f20dad30.png" alt="Fluxograma" height="400px" style=max-width:100%>

**Na ida :arrow_right:**: o usuário cadastra um segredo, a API recebe os dados do front, processa, criptografa e salva no BD, na primeira vez, é gerada uma chave, que é armazenada na AWS. 
* Caso o usuário edite sua senha na aplicação, a chave da AWS permanece a mesma. Não rotacionamos as chaves do usuário.

**Na volta :back::** Nós geramos um hash MD5 sobre algumas informações do usuário pra buscar o key/secret na AWS e com isso descriptografar os dados dele do banco, a retornando então, a informação para o usuário através do frontend.
</p>

## Tecnologias Utilizadas
* <p>
  <a href="https://elixir-lang.org">
  <img alt="Elixir" src="https://user-images.githubusercontent.com/45819790/95101838-067eb780-0709-11eb-91c8-5ffde324230a.png" height="30px" style="max-width:100%;"> </a> Elixir                                                                                                                                           


* <p>
  <a href="https://www.docker.com">
  <img alt="Docker" src="https://user-images.githubusercontent.com/45819790/95104220-f7e5cf80-070b-11eb-8cca-4b97334d668f.png" height="30px" style="max-width:100%;"> </a> Docker                                                                                                                                           
</p>

* <p>
  <a href="https://www.postgresql.org">
  <img alt="PostgreSQL" src="https://user-images.githubusercontent.com/45819790/95104283-0502be80-070c-11eb-8368-6b479d142327.png" height="30px" style="max-width:100%;"> </a> PostgreSQL                                                                                                                                          
</p>

* <p>
  <a href="https://react-cn.github.io/react/downloads.html">
  <img alt="React" src="https://user-images.githubusercontent.com/45819790/100808607-34cff900-3413-11eb-8b1f-067825b60738.png" height="30px" style="max-width:100%;"> </a> React

* <p>
  <a href="https://nodejs.org/en/">
  <img alt="React" src="https://user-images.githubusercontent.com/45819790/100808616-37cae980-3413-11eb-8da8-7eb868f5bd79.png" height="30px" style="max-width:100%;"> </a> NodeJS                                                                                                                                      
</p>

  Para conhecer os pré-requisitos e tecnologias gerais do Saka Vault, <a href="https://github.com/SEGURANCA-DA-INFORMACAO-LGPD/SI-LGPD/wiki">visite a nossa wiki.</a>
  
## Overview técnico

Nós não estamos "reinventando a criptografia" ou usando o "nosso algoritmo", todos nós sabemos que isso é uma "péssima idéia": https://security.stackexchange.com/questions/18197/why-shouldnt-we-roll-our-own
Nós estamos seguindo o padrão da indústria que foi amplamente testado na prática. Estamos usando:

- Advanced Encryption Standard (AES) para criptografar dados sensíveis.
    - <a href="https://en.wikipedia.org/wiki/Galois/Counter_Mode"> **Galois/CounterMode** </a> para criptografia de chave simétrica recomendada por diversos experts de segurança e criptografia, incluindo Matthew Green, Niels Ferguson e Bruce Schneier
    - "Por baixo dos panos" estamos usando a bibliotecta crypto do Erlang, especificamente AES com chaves de **256 bits** (a mesma usada nos serviços AWS/Google KMS), <a href="http://erlang.org/doc/man/crypto.html#block_encrypt-4"> veja </a>.
-  "Hashing" de senhas usando <a href="https://en.wikipedia.org/wiki/Argon2"> **Argon2** </a> (key derivation function / KDF), especificamente a implementação em Elixir do Argon2 escrita por <a href="https://github.com/riverrun/argon2_elixir">David Whitlock</a>, que por sua vez usa a referência da implementação em C como um "submodule do Git".
 
 ## Metodologia OWASP
Este projeto segue as diretrizes e metodologias da Open Web Application Security Project (OWASP) para senhas e criptografia. <a href="https://github.com/SEGURANCA-DA-INFORMACAO-LGPD/SI-LGPD/blob/master/metodologiaoasp.md">Clique aqui </a>para saber mais.

## Modelo de dados 
#### User

```elixir
schema :users do
  field :name, :binary
  field :email, :binary

  field :email_hash, :binary
  field :password_hash, :binary
end
```

Os campos `nome` e `email` são criptografados no banco de dados usando o módulo <a href="https://github.com/SEGURANCA-DA-INFORMACAO-LGPD/SI-LGPD/blob/master/kriptoeaes.md">Krypto e AES</a>, que veremos a seguir. Já os campos `email_hash` e `password_hash` são guardados em formato de hash.

- `password_hash` é o hash da senha do usuário usando Argon2
- `email_hash` é o hash do e-mail do usuário, assim conseguimos fazer um "lookup" para que este consiga fazer login sem comprometer a segurança dos dados

#### Secret

```elixir
schema "secrets" do
  field :user_id, :uuid
  
  field :name, :binary
  field :notes, :binary
  field :username, :binary
  field :password, :binary
end

```
:bulb: **Para a explicação completa** do modelo de dados, <a href="https://github.com/SEGURANCA-DA-INFORMACAO-LGPD/SI-LGPD/blob/master/modelodedados.md"> acesse este link.</a>

## Chaves externas de criptografia

As chaves de criptografia são armazenadas no serviço [AWS Secrets Manager](https://aws.amazon.com/secrets-manager). Elas são criadas para cada usuário, para que sua chave de criptografia esteja completamente segura.

Para identificar as chaves de cada usuário no AWS Secrets Manager, também chamados de `secret_id`, criamos uma chave única de identificação usando `email_hash + password_hash`, que são indecifráveis. Também *temperamos* este novo hash com a chave de 64 caracteres da aplicação, também chamada de `secret key base`. Após esse processo, aplicamos a função de codificar essa chave em `base16`:

```
399C7E909CB5650DC39824B5D953710E17D9F175B88C3A8171B95EACE3BE906A
```

Para criar as chaves de criptografia, usamos o `secret_id` junto de um *salt* aleatório da biblioteca Argon2 e fazemos o *salt* disso tudo usando o mesmo `secret key base` da aplicação. Após esse processo, aplicamos a função de codificar essa chave em `base64`:

```
4SXtCiIPBgRSHukhA/+a2PiO3WMfPTsX+30bU8revNM=
```
 ## Saiba mais
  #### :bellhop_bell: Links úteis, FAQ e Leitura:
 Acesse <a href="https://github.com/SEGURANCA-DA-INFORMACAO-LGPD/SI-LGPD/blob/master/moreinfo.md"> aqui </a> para saber mais.

 
## Entregas
### Sprint 1 : 
* Requisitos
* Modelagem do Banco de Dados
* Inicio da criação Arquitetura do Frontend
* Arquitetura do Backend
* Data: (07/09/2020 a 20/09/2020)

### Sprint 2 :
* Conclusão da coleta dos requisitos
* Criação de todos os Segredos dos Usuários (Chave-simétrica) 
* Login e Autenticação
* Arquitetura do Backend
* Criação da Arquitetura do Frontend. 
* Finalização das funcionalidades principais da API do Backend
* Data: (21/09/2020 a 04/10/2020)


### Sprint 3 :
* Integração do Backend com Secret Manager da Amazon
* Documentação do Projeto.
* Data: (05/10/2020 a 18/10/2020)

### Sprint 4 :
* Deploy do Front
* Configurações com a AWS Usuarios
* Diagramação UML
* Integração do Frontend com o Backend
* Data: (19/10/2020 a 01/11/2020)

### Sprint 5 :
* Configurações com a AWS Segredos
* Ajustes Finais no Front
* Remoção dos Usuários
* Documentação dos requisitos do Front
* Data: (2/11/2020 a 15/11/2020)

### Sprint 6 :
* Documentação dos fluxos de Segurança
* Documentação dos requisitos do Back
* Revisão do Projeto
* Gravação da Apresentação Final
* Conclusão
* Data: (16/11/2020 a 29/11/2020)

### Apresentação Final :
* Data: (30/11/2020 a 06/12/2020)


