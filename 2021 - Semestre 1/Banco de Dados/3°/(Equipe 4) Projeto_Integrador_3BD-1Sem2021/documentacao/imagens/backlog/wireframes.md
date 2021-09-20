<h2>Funcionamento da Ferramenta</h2>

<h3>Login</h3>
<h1 align="center"> <img src="https://github.com/GabrielSG20/Projeto_Integrador_3BD-1Sem2021/blob/main/documentacao/imagens/wireframe/login.jpg" width="1000"></h1>
<p align="justify"> Como pré-requisito, a empresa parceira solicitou que houvessem níveis de acesso a ferramenta. Dessa forma, teremos uma tela de login que diferenciará o acesso dependendo do nível do usuário (usuário administrador e usuário comum). </p>
<p align="justify"><b> Username: </b> o usuário deverá indicar seu username, identificação ou e-mail institucional para acesso ao menu principal.</p>
<p align="justify"><b> Password: </b> o usuário deverá indicar senha de acesso pessoal.</p>
<p align="justify"><b> Sign in: </b> o usuário deverá clicar neste botão para acessar o menu principal.</p>


<h3>Menu Principal</h3>
<h1 align="center"> <img src="https://github.com/GabrielSG20/Projeto_Integrador_3BD-1Sem2021/blob/main/documentacao/imagens/wireframe/menu.jpg" width="1000"></h1>
<p align="justify"> A ferramenta terá três APIs principais independentes. Portanto, o menu dará acesso a cada uma delas de acordo com a necessidade do usuário. </p>

<h4><ins>Codelist</ins></h4>
<p align="justify"><b> Descrição: </b> ferramenta para criar, alterar, salvar e deletar CodeList, usa somente input do usuário.</p>
<p align="justify"><b> Uso: </b> clique para abrir nossa aplicação de criação, alteração e exclusão de Codelist.</p>

<h4><ins>LEP (List of Effective Pages)</ins></h4>
<p align="justify"><b> Descrição: </b>  ferramenta para criar, salvar ou deletar LEP, usa input do usuário e informações da Codelist na construção da LEP.</p>
<p align="justify"><b> Uso: </b> clique para abrir nossa aplicação de criação, alteração e exclusão de LEPs.</p>

<h4><ins>PDF Compilation</ins></h4>
<p align="justify"><b> Descrição: </b>  ferramenta para compilar arquivos em pdf, usa input e informações da Codelist ou LEP para realizar a criação do PDF FULL ou DELTA.</p>
<p align="justify"><b> Uso: </b> clique para abrir nossa aplicação de criação de PDF FULL ou DELTA.</p>

<h3>Codelist</h3>
<h4><ins>Create Codelist</ins></h4>
<h1 align="center"> <img src="https://github.com/GabrielSG20/Projeto_Integrador_3BD-1Sem2021/blob/main/documentacao/imagens/wireframe/codelist_create.jpg" width="1000"></h1>
<p align="justify"> Esta função permite a criação e o armazenamento em Banco de Dados do codelist baseado nas inputs fornecidas pelo usuário. </p>

<h4><ins>Primary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite a primary key (código da aeronave).</p>

<h4><ins>Secundary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite, caso o arquivo possua, a secundary key (código que começa com "-", ex.: -50, -55, -60).</p>

<h4><ins>Tag</ins></h4>
<p align="justify"><b> Uso: </b> digite a tag para ser usada no banco de dados - geralmente o nome de um planeta ou estrela, ex.: Mars, Alpha Centauri, Saturn.</p>

<h4><ins>Atributos</ins></h4>
<p align="justify"><b> Section Number: </b> digite o número ou código da seção no campo.</p>
<p align="justify"><b> Subsection: </b> caso exista, digite o número da subseção no campo.</p>
<p align="justify"><b> Block Number: </b> digite o número do bloco no campo.</p>
<p align="justify"><b> Block Name: </b> digite o nome do bloco no campo.</p>
<p align="justify"><b> Code: </b> digite o código no campo.</p>

<h4><ins>Create</ins></h4>
<p align="justify"><b> Uso: </b> clique para criar a CodeList.</p>

<h4><ins>Back</ins></h4>
<p align="justify"><b> Uso: </b> clique para retornar ao menu principal.</p>

<h1 align="center"> <img src="https://github.com/GabrielSG20/Projeto_Integrador_3BD-1Sem2021/blob/PL001/images-codelist/import.png" width="1000"></h1>
<p align="justify"> Esta função permite a criação e o armazenamento em Banco de Dados do codelist baseado em codelists já existentes em arquivos .xlsm. </p>

<h4><ins>Primary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite a primary key (código da aeronave).</p>

<h4><ins>Escolher Arquivo</ins></h4>
<p align="justify"><b> Uso: </b> selecionar arquivo no formato .xlsm.</p>

<h4><ins>Create</ins></h4>
<p align="justify"><b> Uso: </b> clique para criar a CodeList.</p>

<h4><ins>Back</ins></h4>
<p align="justify"><b> Uso: </b> clique para retornar ao menu principal.</p>

<h4><ins>Consult Codelist</ins></h4>
<h1 align="center"> <img src="https://github.com/GabrielSG20/Projeto_Integrador_3BD-1Sem2021/blob/PL001/images-codelist/consult.png" width="1000"></h1>
<p align="justify"> Esta função permite a <b>consulta, edição e exclusão</b> de codelists armazenados no Banco de Dados. </p>

<h4><ins>Primary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite a primary key (código da aeronave).</p>

<h4><ins>Secundary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite, caso o arquivo possua, a secundary key (código que começa com "-", ex.: -50, -55, -60).</p>

<h4><ins>Block</ins></h4>
<p align="justify"><b> Uso: </b> digite o número do bloco no campo.</p>

<h4><ins>Botão Consult</ins></h4>
<p align="justify"><b> Uso: </b> clique para buscar a tabela que contenha a primary key, secundary key (caso for necessário) e tag.</p>

<h4><ins>:wastebasket:</ins></h4>
<p align="justify"><b> Uso: </b> Delete o codelist desejado.</p>

<h4><ins>:memo:</ins></h4>
<p align="justify"><b> Uso: </b> Edit o codelist desejado.</p>

<h4><ins>Back</ins></h4>
<p align="justify"><b> Uso: </b> clique para retornar ao menu principal.</p>

<h4><ins>Edit Codelist</ins></h4>
<h1 align="center"> <img src=https://github.com/GabrielSG20/Projeto_Integrador_3BD-1Sem2021/blob/PL001/images-codelist/edit.png width="1000"></h1>
<p align="justify"> Esta função permite que o usuário edit um codelist existente, caso ocorra alguma mudança em sua estrutura. </p>

<h4><ins>Secundary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite, caso o arquivo possua, a secundary key (código que começa com "-", ex.: -50, -55, -60).</p>

<h4><ins>Edição de Dados</ins></h4>
<p align="justify"><b> Uso: </b> clique e digite os novos dados.</p>

<h4><ins>Back</ins></h4>
<p align="justify"><b> Uso: </b> clique para retornar ao menu principal.</p>

<h4><ins>Edit</ins></h4>
<p align="justify"><b> Uso: </b> clique para salvar as alterações.</p>

<h4><ins>Delete Codelist</ins></h4>
<p align="justify"> Esta função permite que o usuário delete uma codelist que não tenha mais necessidade de estar armazenada no banco de dados por estar obsoleta. Está integrada ao Consult.</p>

<h3>List of Effective Pages (LEP)</h3>
<h4><ins>Create LEP</ins></h4>
<h1 align="center"> <img src="https://github.com/GabrielSG20/Projeto_Integrador_3BD-1Sem2021/blob/main/documentacao/imagens/wireframe/lep_create.jpg" width="1000"></h1>
<p align="justify"> Esta função permite a criação da LEP de forma automática lendo o rodapé das páginas e formando um sumário armazenados em arquivos do tipo .doc e .pdf . </p>

<h4><ins>Primary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite a primary key (código da aeronave).</p>

<h4><ins>Secundary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite, caso o arquivo possua, a secundary key (código que começa com "-", ex.: -50, -55, -60).</p>

<h4><ins>Tag</ins></h4>
<p align="justify"><b> Uso: </b> digite a tag para ser usada no banco de dados - geralmente o nome de um planeta ou estrela, ex.: Mars, Alpha Centauri, Saturn.</p>

<h4><ins>Date</ins></h4>
<p align="justify"><b> Uso: </b> digite a data de criação da LEP.</p>

<h4><ins>Version</ins></h4>
<p align="justify"><b> Uso: </b> selecione FULL ou DELTA.</p>

<h4><ins>Revision Number</ins></h4>
<p align="justify"><b> Uso: </b> digite o número da revisão da LEP.</p>

<h4><ins>Revision Date</ins></h4>
<p align="justify"><b> Uso: </b> digite a data em que a revisão foi realizada.</p>

<h4><ins>Create</ins></h4>
<p align="justify"><b> Uso: </b> clique para criar a LEP.</p>

<h4><ins>Select Folder</ins></h4>
<p align="justify"><b> Uso: </b> seleciona a pasta que contenha a estrutura de arquivos da documentação da aeronave.</p>

<h4><ins>Botão Upload</ins></h4>
<p align="justify"><b> Uso: </b> clique para fazer o upload da pasta selecionada.</p>

<h4><ins>Botão Download</ins></h4>
<p align="justify"><b> Uso: </b> clique para baixar a LEP desejada.</p>

<h4><ins>Back</ins></h4>
<p align="justify"><b> Uso: </b> clique para retornar ao menu principal.</p>

<h4><ins>Consult LEP</ins></h4>
<h1 align="center"> <img src="https://github.com/GabrielSG20/Projeto_Integrador_3BD-1Sem2021/blob/main/documentacao/imagens/wireframe/lep_consult.jpg" width="1000"></h1>
<p align="justify"> Esta função permite a leitura e download de LEPs já existentes a partir dos inputs fornecidos pelo usuário. </p>

<h4><ins>Primary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite a primary key (código da aeronave).</p>

<h4><ins>Secundary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite, caso o arquivo possua, a secundary key (código que começa com "-", ex.: -50, -55, -60).</p>

<h4><ins>Tag</ins></h4>
<p align="justify"><b> Uso: </b> digite a tag para ser usada no banco de dados - geralmente o nome de um planeta ou estrela, ex.: Mars, Alpha Centauri, Saturn.</p>

<h4><ins>Version</ins></h4>
<p align="justify"><b> Uso: </b> selecione FULL ou DELTA.</p>

<h4><ins>Revision Number</ins></h4>
<p align="justify"><b> Uso: </b> digite o número da revisão da LEP.</p>

<h4><ins>Filtro</ins></h4>
<p align="justify"><b> Uso: </b> após digitar a Tag e Revision Number(item 6) clique no botão para filtrar a visualização.</p>

<h4><ins>Botão Download</ins></h4>
<p align="justify"><b> Uso: </b> clique para realizar o download da LEP desejada.</p>

<h4><ins>Back</ins></h4>
<p align="justify"><b> Uso: </b> clique para retornar ao menu principal.</p>

<h4><ins>Edit LEP</ins></h4>
<h1 align="center"> <img src="https://github.com/GabrielSG20/Projeto_Integrador_3BD-1Sem2021/blob/main/documentacao/imagens/wireframe/lep_edit.jpg" width="1000"></h1>
<p align="justify"> Esta função permite criar e substituir a LEP de acordo com os inputs fornecidos pelo usuário, semelhante a função "Create LEP". </p>

<h4><ins>Primary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite a primary key (código da aeronave).</p>

<h4><ins>Secundary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite, caso o arquivo possua, a secundary key (código que começa com "-", ex.: -50, -55, -60).</p>

<h4><ins>Tag</ins></h4>
<p align="justify"><b> Uso: </b> digite a tag para ser usada no banco de dados - geralmente o nome de um planeta ou estrela, ex.: Mars, Alpha Centauri, Saturn.</p>

<h4><ins>Version</ins></h4>
<p align="justify"><b> Uso: </b> selecione FULL ou DELTA.</p>

<h4><ins>Revision Number</ins></h4>
<p align="justify"><b> Uso: </b> digite o número da revisão da LEP.</p>

<h4><ins>Select Folder</ins></h4>
<p align="justify"><b> Uso: </b> seleciona a pasta que contenha a estrutura de arquivos da documentação da aeronave.</p>

<h4><ins>Botão Download</ins></h4>
<p align="justify"><b> Uso: </b> clique para baixar a LEP desejada.</p>

<h4><ins>Botão Upload</ins></h4>
<p align="justify"><b> Uso: </b> clique para fazer o upload da pasta selecionada.</p>

<h4><ins>Botão Edit</ins></h4>
<p align="justify"><b> Uso: </b> clique para salvar a edição.</p>

<h4><ins>Back</ins></h4>
<p align="justify"><b> Uso: </b> clique para retornar ao menu principal.</p>

<h4><ins>Delete LEP</ins></h4>
<h1 align="center"> <img src="https://github.com/GabrielSG20/Projeto_Integrador_3BD-1Sem2021/blob/main/documentacao/imagens/wireframe/lep_delete.jpg" width="1000"></h1>
<p align="justify"> Esta função permite deletar a LEP de nossos bancos de dados, bem como da pasta em que se encontra.</p>

<h4><ins>Primary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite a primary key (código da aeronave).</p>

<h4><ins>Secundary Key</ins></h4>
<p align="justify"><b> Uso: </b> digite, caso o arquivo possua, a secundary key (código que começa com "-", ex.: -50, -55, -60).</p>

<h4><ins>Tag</ins></h4>
<p align="justify"><b> Uso: </b> digite a tag para ser usada no banco de dados - geralmente o nome de um planeta ou estrela, ex.: Mars, Alpha Centauri, Saturn.</p>
  
<h4><ins>Revision Number</ins></h4>
<p align="justify"><b> Uso: </b> digite o número da revisão da LEP.</p>

<h4><ins>Version</ins></h4>
<p align="justify"><b> Uso: </b> selecione FULL ou DELTA.</p>

<h4><ins>Search</ins></h4>
<p align="justify"><b> Uso: </b> clique para procurar a LEP.</p>

<h4><ins>Botão Delete</ins></h4>
<p align="justify"><b> Uso: </b> clique para excluir a LEP desejada.</p>

<h4><ins>Back</ins></h4>
<p align="justify"><b> Uso: </b> clique para retornar ao menu principal.</p>

<h3>PDF Compilation</h3>
<h1 align="center"> <img src="https://github.com/GabrielSG20/Projeto_Integrador_3BD-1Sem2021/blob/main/documentacao/imagens/wireframe/pdf_compilation.jpg" width="1000"></h1>
<p align="justify"> Esta função permite a compilação dos arquivos baseando-se no Codelist e na LEP e o download do arquivo compilado em .pdf, de acordo com os inputs do usuário. </p>

<h4><ins>Version</ins></h4>
<p align="justify"><b> Uso: </b> selecione FULL ou DELTA.</p>

<h4><ins>Revision Number</ins></h4>
<p align="justify"><b> Uso: </b> digite o número da revisão da LEP.</p>

<h4><ins>Tag</ins></h4>
<p align="justify"><b> Uso: </b> digite a tag para ser usada no banco de dados - geralmente o nome de um planeta ou estrela, ex.: Mars, Alpha Centauri, Saturn.</p>

<h4><ins>Create</ins></h4>
<p align="justify"><b> Uso: </b> clique para criar o pdf FULL ou DELTA.</p>

<h4><ins>Botão Download</ins></h4>
<p align="justify"><b> Uso: </b> clique para baixar o PDF desejado.</p>

<h4><ins>Back</ins></h4>
<p align="justify"><b> Uso: </b> clique para retornar ao menu principal.</p>

<h2>Instalação do Protótipo</h2>

<b> Link para download: [airPlan.zip](https://drive.google.com/file/d/130JL91hKQc2Wm1XfKkqr2ftpfOce8Wtz/view?usp=sharing) </b>

<b> Instalação: </b>

Descompacte airPlan.zip

<b> Uso: </b>

No Linux:

No terminal vá até a pasta em que você baixou o executável e digite:

$ java -jar airPlan-0.0.1.jar

No Windows:

Procure por "cmd" no menu iniciar, clique com o botão direito e inicie como administrador vá até a pasta onde baixou o executavél e digite:

java -jar airPlan-0.0.1.jar

Ou -caso tenha as permissões necessárias- dê um duplo clique no arquivo airPlan-0.0.1.jar
