[![MIT license](https://img.shields.io/badge/License-MIT-blue.svg)](https://lbesson.mit-license.org/)
![Status](https://img.shields.io/badge/Status-In_progress-orange.svg)
# <center> POC - Processos Otimizados de Contas </center> :envelope:
<img src="https://github.com/MikeBBatista/pi-fatec-java/blob/develop/app/src/img/rsz_3poc.png" width="270px" heigth="270px" align="i"> 

## Equipe

### Dev Team :computer:

* [Felipe Duo](https://www.linkedin.com/in/felipe-duo-209651127/)
* [Geysa Santos](https://www.linkedin.com/in/geysa-fernanda-f-f-santos-97159b10a/)  
* [Jefferson Neves](https://www.linkedin.com/in/jeferson-tadeu-das-neves-a98343190/)

### Master :chart_with_upwards_trend:

* [Mike Barcelos](https://www.linkedin.com/in/mike-barcelos-b4648016a/)  

### Product Owner :clipboard:

* [Guilherme Tavares](https://www.linkedin.com/in/guilhermeftavares/)


### Apresentação Sprint 0 (27/09/2020) 
* [User Story](https://drive.google.com/file/d/1FgCiddxV0BacmEHiR5Xw8v0SLv4diTsZ/view?usp=sharing)
* [Sprint 0](https://drive.google.com/file/d/1EVJPpmEamyzXfEI8WTmrKYo8Iq_8sBKT/view?usp=sharing)


### Apresentação Sprint I (17/10/2020) 
* [Sprint 1](https://drive.google.com/file/d/1nOgl_S0vtLXNuLil7aBkkigiMFR3jACz/view?usp=sharing)
* [Executável Beta](https://drive.google.com/file/d/1VomvKVPfKELb7qm2l9W4r22lDG6mXhUk/view?usp=sharing)

### Apresentação Sprint II (08/11/2020)
* [Sprint 2](https://drive.google.com/file/d/1zbDut4F2GjHMc__KgvFkvAMpVFmTIL-Q/view?usp=sharing)
* [Executável Beta 2.0](https://drive.google.com/file/d/1qVH_Uh_dj-nzQ76ZDc63U17FUGkoBmyb/view?usp=sharing)

### Apresentação Sprint III (29/11/2020)
* [Sprint 3](https://drive.google.com/file/d/1zbDut4F2GjHMc__KgvFkvAMpVFmTIL-Q/view?usp=sharing)
* [Executável Beta 2.0](https://drive.google.com/file/d/1q8Y5Dw6evqfcJk7u29KN_WqzrD-RnjYq/view?usp=sharing)

### O que é POC?
 
 POC é uma aplicação que facilita e otimiza a inserção de informações de contas despradonizadas de energia e água
 
### Por que ele está sendo desenvolvido? :gift:
 
 Devido a grande diversidade de layouts nas contas de água e energia no Brasil, digitalizar um grande volume de contas não é uma tarefa fácil! Ai vem o POC para facilitar o trabalho com a digitação de dados fornecendo uma plataforma simples, objetiva, exclusiva e funcional
 
### Ferramentas :wrench:

Para desenvolver a aplicação estamos usando:
- JAVA SE 14 :coffee:
- MYSQL 8.0.21.0
- MySQL Connector/J 5.1.49
- ECLIPSE JAVA 2018 09

### Pré Requisitos :cd:

Para rodar o POC você vai precisar:
- JAVA SE 14
- MYSQL 8.0.21.0
- MySQL Connector/J 5.1.49
- ECLIPSE JAVA 2018 09

### TUTORIAL :rainbow:

- Para utilizar o aplicativo POC, você só precisa estar de acordo com os requisitos acima, baixar o executavel da pasta aplication_exe:

- No Linux: 

	 - No terminal vá até a pasta em que você baixou o executável e digite:

   		```$ java -jar POC_beta.jar ```
- No Windows:
	- Procure por "cmd" no menu iniciar, clique com o botão direito e inicie como administrador vá até a pasta onde baixou o executavél e digite:
  
		```java -jar POC_beta.jar ```
  

- Após Instalação:
  - A primeira tela é o Menu Principal:
   - Nele podemos escolher uma ação que irá nos direcionar a outras telas, todas as ações já disponíveis nessa versão, incluem um atalho:

      - alt + 1 para abrir a opção de cadastrar fornecedores;
      - alt + 2 para abrir a opção de cadastrar cliente;
      - alt + 3 para cadastrar uma conta;


 - As telas de cadastrar fornecedores e clientes, seguem um padrão simples onde se digita os dados descritos na tela e então escolhe entre salvar os dados ou retornar para o menu.

   - Nessas telas temos os atalhos:

      - alt + S para salvar o conteúdo dos formulários no banco;
      - alt + B para voltar pro menu principal;

   - Quando escolhida a opção de cadastrar uma conta: 
     - Uma tela intermediária irá surgir, onde é necessário escolher o tipo da conta a ser cadastrado (conta de água ou de energia):
     - Após a escolha, uma nova tela irá abrir pedindo dados referentes aquele tipo de conta:

   - A tela de água segue o mesmo padrão das telas de fornecedores e clientes:

       - alt + S para salvar o conteúdo do formulário no banco;
       - alt + B para voltar ao menu principal;

  - Já a tela de cadastro de energia: 
    - É divida em duas telas devido a quantidade de dados, e podemos navegar entre as telas com os seguintes atalhos:

       - alt + 1 primeira tela do formulário de energia;
       - alt + 2 segunda tela do formulário de energia;

    - Na segunda tela do formulário de energia, podemos notar os botões salvar e voltar e seguem os mesmos atalhos das telas anteriores:

       - alt + S para salvar o conteúdo do formulário no banco;
       - alt + B para voltar para o menu principal.

  - Tela de edição dos dados cadastrados:
    - É dividida em duas funções, sendo a primeira a listagem dos dados cadastrados no banco na tabela, para verificação e alteração dos dados;
    - Para listar um dado, escolha entre fornecedor, cliente ou conta e clicar em "pesquisar", cada qual tem seu próprio filtro por exemplo:
       - Para Listar um fornecedor único é necessário informar o cnpj, já para um cliente é necessário informar o cpf;
       - Caso nenhum filtro seja passado a aplicação irá listar todos dados daquela entidade na tela;
       - A conta é uma entidade que precisa que seja passado também seu tipo, para que possa ser listada de acordo.
    - Para alterar um dado listado da tabela, precisamos apenas clicar sobre o dado e mudar seu valor e então clicar fora da cédula e por fim clicar em "Update";
    - Só é possível alterar uma linha de dado por update.
