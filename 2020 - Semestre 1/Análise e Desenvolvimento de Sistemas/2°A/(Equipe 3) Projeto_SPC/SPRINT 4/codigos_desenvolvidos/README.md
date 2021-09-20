# Preparando o ambiente de programação

**AVISO:** Antes de começar você precisa ter em seu computador o programa Python (64 bits) instalado com a opção **PATH**.

1. Baixe os arquivos dessa pasta e descompacte-os em seu computador, inclua também nessa pasta os lotes do cadastro positivo que você deseja analisar;

2. Clique no botão do Menur Iniciar, digite **cmd** e tecle ENTER ou segure as teclas WINDOWS + R, digite cmd e tecle ENTER;

![](https://i.imgur.com/NLmiPyY.gif)

3. Navegue até a pasta desse readme, e no prompt digite **cd Endereço_da_Pasta** e tecle ENTER;

![](https://i.imgur.com/VyGIL6P.gif)

4. Instale os repositórios necessários, digite **pip install -r requirements.txt**, tecle ENTER e aguarde a finalização da instalação.

![](https://i.imgur.com/wPJKJUI.gif)
    
# Uso dos arquivos de programação

Disponibilizamos duas formas de uso: **python** ou **jupyter notebook**.  

Para executar no **python** basta abrir o arquivo **METAapp.py** clicando duas vezes.  

Para abrir o **jupyter notebook** e editar os arquivos **IPYNB**, basta digitar no prompt de comando: **jupyter notebook**.  

>Lembre-se que o prompt deve estar na pasta com o arquivos ipynb e lotes do cadastro positivo.

Após o carregamento uma página será aberta no seu navegador padrão. Para começar a tratar os dados, abra um dos arquivos notebooks, **selecione a célula**, e clique no botão com o símbolo **Play**. Execute célula por célula na ordem apresentada e não execute qualquer célula fora da ordem. Caso execute, retorne a primeira célula e execute todas as células novamente.  

# Como gerar o executável para sistemas Windows

**IMPORTANTE:** É necessário navegar até a pasta com o arquivo setup.py para realizar qualquer um dos procedimentos abaixo.

Abra o prompt de comando, navegue até essa pasta e digite linha por linha dos comandos abaixo e aguardando a finalização:  
> py -m pip install --user virtualenv  
> py -m venv env  
> .\env\Scripts\activate  
> pip install -r requirements.txt  
> python setup.py build  

# Linha de comando para limpar todos os packages instalados no sistema

**AVISO:** Ao executar esse comando todos as biblitoecas serão desinstaladas, utilize com cuidado.

Abra o cmd e digite:  
> pip freeze > requirements.txt && pip uninstall -r requirements.txt -y