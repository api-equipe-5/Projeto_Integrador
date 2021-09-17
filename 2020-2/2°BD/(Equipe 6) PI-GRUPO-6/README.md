# PROJETO INTEGRADOR - GRUPO 6
_FATEC Profº Jessen Vidal, São José dos Campos, 2º semestre de 2020, Curso: Tecnologia em Banco de Dados_

_________________________________________________________________________________________________
### **Grupo:**
- Arnaldo Pascoal Almeida Barbosa
- Carlos Henrique da Silva Lopes: https://www.linkedin.com/in/carlos-henrique-54754a99/
- José Rangel Gonçalves Andrade: https://www.linkedin.com/in/rangel-andrade-38130b65
- Marcelo Ricardo Fernandes: https://www.linkedin.com/in/marcelo-fernandes-ab18a986
- Isabella Rosa Peixoto Segundo: https://www.linkedin.com/in/isabellarps/
- Helen Cristina Alevato Rodrigues: https://www.linkedin.com/in/helen-alevato-ab15b6177
- José Francisco Forneiro Junior


_________________________________________________________________________________________________
**Objetivo:** Sistema de digitação e edição de contas


_________________________________________________________________________________________________
# SPRINT 1

- Pasta: https://github.com/rangelandrade/PI-GRUPO-6/tree/master/EntregaSprint0
- Vídeo: https://youtu.be/moQdPIZ4aZQ

### **Itens entregáveis:**
**User Stories**

- Prioridade 1 -> Agente digitador, gostaria de poder filtrar e selecionar o tipo de conta desejado referente a um cliente, pois o digitador necessita verificar qual tipo de conta será editada e qual mês e ano de referência.
Motivo-> Alterar, visualizar e separar os tipos de contas para auxiliar na correção de possíveis erros nas contas.

- Prioridade 2 -> Agente digitador, gostaria de poder gerenciar cada tipo de conta em um campo específico, que seja no modelo da empresa escolhida, pois a dificuldade está na forma que o digitador coloca os dados no sistema, cada conta tendo seus campos específicos ficará mais intuitivo e prático para que o resultado final tenha mais agilidade.
Motivo-> Analisar, alterar e acessar os campos necessários referentes a cada conta.

**Wireframes**

- Telas

_________________________________________________________________________________________________
# SPRINT 2

- Pasta: https://github.com/rangelandrade/PI-GRUPO-6/tree/master/ProjetoPIGrupo6
- Vídeo: https://drive.google.com/file/d/1OuOShNbeQQrYNLkN5BvrwVTcF5X3buaX/view

### **Itens entregáveis:**
**Início Banco de Dados**

**Início Back End**

_________________________________________________________________________________________________
# SPRINT 3

- Vídeo Explicativo: https://www.youtube.com/watch?v=HpcrH5d8OK8

**Ferramentas utilizadas:** 
- Eclipse 
- Java Fx scene builder 
-	MYSQL Workbench 8.0.( https://dev.mysql.com/downloads/workbench/)
-	MYSQL SERVER 8.0 (https://www.mysql.com/downloads/)
-	JAVA versão 11( https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
-	Sistema operacional Windows 10 ou superior.

**Criação das seguintes telas:**
- Menu 
- Cadastro usuário 
- Cadastro cliente
- Conta água
- Conta gás 
- Conta luz

**Conexão  com o banco de dados e criação do botão  cadastrar para as seguintes telas:**
- Cadastro usuário 
- Cadastro cliente
- Conta de luz

**Criação do botão limpar para todas as telas criadas**

**Implementação de máscaras para os seguintes itens:**
- Cpf
- Cep
- Telefone 
- Data

**Extração de dados  do cadastro do cliente para a conta de luz usando outro botão de busca para completar os campos referentes ao cadastro do cliente na conta de luz.**

_________________________________________________________________________________________________
# SPRINT 4

- Manual Técnico: https://docs.google.com/document/d/1gjrtvYIsYYBayCiXREWgUd-vdLu5SQN6t-x3VPzorGs/edit?usp=sharing
- Manual da Aplicação:  https://docs.google.com/document/d/1sm-Uz3IaWa2FP-Dy6Gu4_sQ61fB27xHBulweyc-dGdg/edit#
- Vídeo Explicativo: https://www.youtube.com/watch?v=DF_1mwpM1Tk
- JAR: <a id="raw-url" href="https://github.com/rangelandrade/PI-GRUPO-6/blob/helen/JAR/Sistema%20TecSUS%20G6.jar">Download FILE</a>

## **FUNCIONALIDADES DA ENTREGA SPRINT 4**

**Adição da tela Cadastro Imóvel**
- Criação da tabela Imovel no MySQL Workbench
- Mascara para CEP
- Implementação do botão Limpar
- Implementação do busca por cliente
- Adição de Choice Box

**Criação das Classes Faltantes**

**Fazer Busca usando a tecla Tab, nas seguintes telas**
- Conta Água (pelo RGI)
- Conta Gás (pelo Código do Usuário)
- Conta Luz (pelo Número de Instalação)

**Adição do Tooltip dentro das telas**

**Implementação da funcionalidade de redirecionar o cadastro para os três tipos de conta, dentro da tela Cadastro Imovel**

**Criptografia da senha do Usuário**

**Tela de Login**

**Priorização dos campos principais, não deixando que o cadastramento prossiga, a menos que os campos especificados estejam preenchidos**

**Caixa de confirmação pop-up para cada tela que tem a funcionlidade de cadastro**

**Criação da tela de Busca**
- A busca pode ser feita por meio de um filtro, entre Água, Gás ou Luz
