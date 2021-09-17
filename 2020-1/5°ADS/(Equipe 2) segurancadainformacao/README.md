# Projeto Segurança da Informação

## Objetivo?
Projeto tem intuito de demonstrar modelagem de banco de dados ideal para um mercado se adequar com a LGPD, fazendo com que seja possível a exclusão de dados normais e sensiveis dos clientes. Por meio de uma aplicação que simule tal situação.

### Sistema de Agendamento para Salão de Cabelereiros
Usamos como aplicação pratica o caso de um salão de cabelereiro, com intúito de demonstrar nossa modelagem e solução para o novo modelo da LGPD. Onde os dados pessoais do cliente somente podem ser acessados por ele.
**Exemplo**
id |Nome | Telefone | Data do Agendamento | Valor
---|--- |--- |--- |---
1|Eduardo |12-34566789 | 01/06/20 | R$ 40,00
2|CRIPTOGRAFADO|CRIPTOGRAFADO| 01/06/20 | R$ 40,00

## Solução utilizada
A solução utilizada para desse problema foi utilização de criptografia assimetrica, que se trata de uma criptografia que utiliza duas chaves uma publica e uma privada, sendo a publica a chave utilizada para criptografar os dados e a privada para descriptografar o mesmo.
## O que é LGPD?
[![](http://img.youtube.com/vi/y7SamL2wYSc/0.jpg)](http://www.youtube.com/watch?v=y7SamL2wYSc "O que é LGPD?")

## Processo de Desenvolvimento
---

### Sprint 1
 - [x] Inicio da modelagem do banco de dados 
 - [x] Criação da base e estrutura MVC
 - [x] wireframes das paginas

### Sprint 2
- [x] Criação de controllers responsaveis pelo login e autenticação
- [x] Mudanças no banco de dados
- [x] Criação de bases HTML para as paginas
### Sprint 3
- [x] Metodos de anonimização de usuarios quando deletados
- [x] Controllers de agendamentos serviços e usuarios
- [x] Ajustes no modelo do banco de dados
### Sprint 4
- [x] Novo modelo do banco de dados
- [x] Novo banco de dados para chave privada
- [x] Criação de modulo de criptografia
- [x] Utilização do modulo de criptografia no controller de usuarios
### Sprint 5
- [x] Alteração de metodo de encriptação para simetrico
- [x] Mudança no modelo do banco para novo tipo de criptografia
- [x] Criação de paginas html utilizando Jinja2 (template padrão do flask)
- [x] Integração das Paginas com back-end
- [x] Inicio da navegação do sistema
- [x] Refatoração de padrão para nomes de metodos e variaveis
### Sprint 6
- [x] Finalizar navegação do sistema
- [x] Implementação de estilização do sistema
- [x] Gravação de video demonstração
## Instalação e Configuração do ambiente virtual


### Tecnologias utilizadas

* Python 3.8
* virtualenv
* pip
* Flask
* HTML e CSS
* MySQL

## Instalação
Abra o terminal de comando e execute os seguites comandos:

* Instalação do python 3\
`sudo apt-get install python3`

* Instalação do Pip, caso são possua instalado (pip é um sistema de gerenciamento de pacotes padrão da linguagem Python)\
 `sudo apt-get install python-pip`

* Instalação do Virtualenv (Criação de ambientes virtuais isolados)\
`pip install virtualenv`

* Criando uma virtualenv\
`virtualenv nome_da_virtualenv`

* Ativando a virtualenv\
`source nome_da_virtualenv/bin/activate`


* Intalando todas as depêndencias do projeto\
`pip install -r requirements.txt`

* Depois dos procedimentos, basta executar o projeto na IDE desejada e que interprete python

## Tecnologias utilizadas

* Python 
* Flask
* HTML e CSS
* MySQL

## Autores

* Marcio Ordonez [Linkedin](https://www.linkedin.com/in/marcio-ordonez "Linkedin") [GitHub](https://github.com/MarcioOrdonez "GitHub")
* Eduardo Nunes [Linkedin](https://www.linkedin.com/in/eduardonunes-santos "Linkedin") [GitHub](https://github.com/eduns "GitHub")
* Thiago Dias [Linkedin](https://www.linkedin.com/in/thiago-dias-918363190 "Linkedin") [GitHub](https://github.com/ThiagoDT "GitHub")
* Cauan Almeida [Linkedin](https://www.linkedin.com/in/cauancesar-almeida "Linkedin") [GitHub](https://github.com/Tsundek "GitHub")



## Licença
Esse sistema e seu código fonte são livres para serem estudados e utilizados por quaisquer interessados que desejem entender mais sobre seu funcionamento


## Agradecimento
Professor e Orientador da disciplina de Segurança da Informação da Fatec São José dos Campos
