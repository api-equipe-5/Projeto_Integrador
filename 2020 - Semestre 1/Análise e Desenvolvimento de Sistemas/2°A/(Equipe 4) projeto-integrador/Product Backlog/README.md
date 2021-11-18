
# PRODUCT BACKLOG
<img src="https://raw.githubusercontent.com/marciosousa4/projeto-integrador/71c81031765f289e50ca9f34ab6ba9d5d0db86b3/image-article-agile-basics-illustration2_0.png" width="230" height="130" /> <img src="https://raw.githubusercontent.com/marciosousa4/projeto-integrador/376d71b42da02278e03b7af2472d9488a8f6bcf2/Logo%20auxilio%20emergencial.jpg" width="230" height="130" />


# Product Backlog - Novo Escopo
Após a reunião de validação das entregas com o cliente SPC Brasil no dia 04/06/2020, fizemos algumas mudanças no projeto para adaptar à necessidade do cliente. Foi pedido para o time que apresentasse um produto com valor para o negócio, e também, que o escopo do projeto estivesse claro com referência ao que vamos entregar. Diante dessas solicitações, apresentamos o novo escopo, com as alterações e adaptações feitas pelo time.

# Dados fundamentais para o funcionamento da aplicação.
1.  Dados de transações financeiras dos consumidores fornecidos pelas empresas credoras que constem os seguintes dados:
* Valor total da compra
* Valor e vencimento das parcelas
* Valor e data do pagamento 
* Parcelas a vencer
2.  Tabela de situações emergenciais. 
3. Canal de interação entre consumidor e SPC (web, tele-atendiemento ou Posto de Atendimento) 
 
 # Ações
- O consumidor entra em contato com a SPC solicitando a inclusão no Auxílio emergencial positivo.
- O assistente de atendimento recebe a solicitação e faz a verificação do histórico de pagamentos desse consumidor. 
- Se aprovado, o assistente de atendimento verifica se o consumidor enviou e documentação que comprove a necessidade da inclusão no auxílio. 
- Se reprovado, o assistente de atendimento responde para o consumidor, informado que não foi aprovada a solicitação e o motivo. 
- Se o consumidor foi aprovado e enviou a documentação, o Assistente de Atendimento faz a inclusão da documentação no cadastro do consumidor, marca a opção que gerou a necessidade e o Score do consumidor fica congelado por 60 dias.
- Se ele foi aprovado e não enviou a documentação, o Assistente de Atendimento faz a solicitação para o consumidor.

# Diagrama de caso de uso
![](https://raw.githubusercontent.com/marciosousa4/projeto-integrador/3bafc8f59cce9b46f4e6173ae71330dc82df095e/diagrama%20de%20caso%20de%20uso.jpg)

# Requisitos 

1.	Como consumidor preciso ser incluso no Auxílio Emergencial Positivo, pois estou em uma situação emergencial que está comprometendo o equilíbrio entre receitas e despesas em minha vida pessoal.
*	Disponibilizar Canais de contato para que seja feita essa solicitação (página web, tele-atendimento ou Posto de atendimento). 
* Incluir o item no campo de atendimentos da página fale conosco da SPC Brasil. 
*	Informar para o consumidor quais são as situações em que pode ser requerido o auxílio. 
* Colocar na página da SPC Brasil o item explicativo do projeto. 
*	Ter uma interface gráfica que apresente o que é o Auxílio Emergencial Positivo, para colocar na página da SPC Brasil. 

2.	Como assistente de atendimento da SPC Brasil, quero dar suporte à solicitação do consumidor que precisa ser incluso no cadastro emergencial positivo.
*	Ter uma aplicação para desktop, a fim de não comprometer a segurança das informações e facilitar a distribuição da ferramenta.
*	Ter uma interface contendo a tela inicial da ferramenta que mostre a opção de consulta de CPF do cliente.
*	Usar o framework Electron que permite o desenvolvimento de aplicações para desktop GUI com componentes criados para aplicações web.
*	No desenvolvimento da interface, utilizar a linguagem de marcação HTML e a folha de estilo CSS, por apresentarem grande versatilidade de edição de layout e cores.
*	Aplicar a 8 heurística de Jakob Nielsen, “estética e designer minimalista”, assim o assistente poderá verificar com rapidez agilidade e de forma desburocratizada a possibilidade de atendimento do consumidor. 
*	Manter consistência entre as telas da aplicação com as telas padrões da SPC Brasil será essencial para que não seja necessário o entendimento de vários padrões e formas de interações diferentes para cada tela. 

3.	Como assistente de atendimento preciso verificar se o cliente está adimplente nos últimos 12 meses para dar prosseguimento à solicitação.
* Fazer um código que faça a verificação da qualidade dos dados recebidos pelas instituições financeiras do cadastro positivo.
*	Fazer um código que separe os consumidores que estão inclusos no cadastro positivo. 
*	Fazer um código que faça a separação do histórico de pagamentos dos clientes e mostre esses dados individualizados por CPF. 
*	Para compor a estrutura de tratamento e análise de dados, usar a linguagem Python, por ter um grande acervo de bibliotecas específicas para tais funções.
*	Na integração dos arquivos python com a parte visual, utilizar a linguagem Javascript e o interpretador Nodejs (ambos próprios do Electron) juntamente com o módulo Python-Shell, que lê scripts em python a partir do Nodejs.
*	Interface que mostre a opção de consultar o CPF do consumidor e mostre esses dados individualizados. 
4.	Como assistente de atendimento preciso incluir a situação emergencial do consumidor e a documentação comprobatória da real necessidade do auxílio no cadastro positivo. 
*	Com a verificação positiva do cadastro do cliente, acrescentar uma interface que tenha um campo para marcar o motivo da requisição do auxílio.
*	Colocar as opções com caixas de marcação para facilitar a navegação do assistente nas opções de inclusão. 
*	Aplicar a 8 heurística de Jakob Nielsen, “estética e designer minimalista”, assim o assistente poderá verificar de forma ágil, qual a classificação do cliente e como inserir a documentação no cadastro. 
5.	Como assistente de atendimento preciso enviar a confirmação para o cliente que seu cadastro se encontra incluso no Auxílio Emergencial Positivo e que, por 2 meses as suas contas não serão computadas negativamente em seu cadastro, caso haja algum atraso nos pagamentos.

# A interface
Para o desenvolvimento do produto(aplicação desktop) do Auxílio Emergencial Positivo foram utilizados diversos recursos de Python, sendo o principal deles o Tkinter (biblioteca de interface gráfica padrão). Com o Tkinter, foram produzidas três diferentes telas, simples e funcionais, as quais se interligam por meio de botões. Outros recursos foram utilizados para funções específicas (Pandas, Messagebox, Filedialog, Datetime, Xlrd).

### Tela de início

Logo ao abrir o aplicativo, é exibida a tela de início, a qual contém um banner com o título, e botões com as opções “Começar”, “Ajuda” e “Sair”.

* Botão Começar: guia o funcionário para a tela de verificação;
* Botão Ajuda: guia o funcionário para a tela de ajuda;
* Botão Sair: fecha o aplicativo.

### Tela de Ajuda

Nesta tela são exibidas instruções em passo a passo, a fim de esclarecer qualquer dúvida que o funcionário que estiver utilizando a ferramenta possa ter. Para retornar para a Tela de Início, basta clicar no botão “Voltar”.

### Tela de Verificação
Esta é a tela em que o processo de inclusão no Auxílio Emergencial Positivo ocorre. Os botões “Verificar”, “Limpar”, “Selecionar” e “Concluir”, juntamente com os RadioButtons de situações emergenciais e a TextBox de inserção de CPF, fornecem o suporte necessário para que o processo ocorra:

* TextBox do CPF: área onde deve ser inserido o CPF da pessoa que solicitou a inclusão;
* Botão Verificar: analisa o CPF inserido e, caso este seja válido, dispara o comando de **exibição do histórico de pagamentos e do status** do respectivo consumidor;
* Botão Selecionar: abre uma tela de busca no Windows Explorer para que o documento comprobatório seja selecionado;
* RadioButtons de Situações Emergenciais: permite que o motivo da solicitação seja selecionado;
* Botão Concluir: realiza a operação de inclusão no Auxílio Emergencial Positivo caso todos os campos estejam preenchidos e o consumidor em questão seja apto;
* Botão Limpar: limpa tudo o que foi inserido para que uma nova consulta possa ser feita.

Além destas funcionalidades, há o botão “Voltar”, que retorna para a Tela de Início.

### Exibição do Histórico de Pagamentos e do Status

Feita a raspagem e análise de dados dos arquivos recebidos, é gerada uma Tabela única, a qual serve como uma Base de Dados para a aplicação. Através da consulta dessa tabela, os pagamentos a serem exibidos são selecionados e o status é definido.

# Manual de Instalação

Não é necessário nenhum recurso para executar a aplicação. Basta seguir os seguintes passos:
* Fazer o download da pasta que contém o arquivo.exe, o ícone, o arquivo.xlsx e a pasta de imagens;
* Descompactar a pasta compactada “Auxílio Emergencial Positivo.rar”;
* Entrar na pasta “Auxílio Emergencial Positivo” e clicar duas vezes no arquivo “AEP.exe”.

