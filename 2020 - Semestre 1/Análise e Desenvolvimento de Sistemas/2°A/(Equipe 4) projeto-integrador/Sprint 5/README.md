![](https://github.com/marciosousa4/projeto-integrador/blob/master/Sprint%205/Sprint5%20.jpg?raw=true)

# MVP

### Apresentamos a ferramenta que será utilizada pelo Assistente de Atendimento da SPC Brasil para dar suporte a solicitação do consumidor.
Desenvolvimento de um aplicativo desktop para os Assistentes de Atendimento verificarem a viabilidade de inclusão do consumidor no Auxilio Emergencial Positivo.
### Instruções de uso
* Não é preciso fazer instalações, baixe os arquivos do repositório pelo [Link de Execução](https://drive.google.com/drive/folders/15MyXBWSNzSivNCF3UrefY9Zy2nXDP2bN?usp=sharing), 
e execute o arquivo AEP.exe.
* Para verificação dos códigos desenvolvidos na interface gráfica, acessar o Link [códigos interface](https://github.com/marciosousa4/projeto-integrador/blob/master/Sprint%205/Codigo_Interface_AEP.py)

### Benefícios 
* Agilidade e segurança para a inlcusão do consumidor no Auxílio Emergencial Positivo.
* O Assistente de atendimento poderá realizar testes com a ferramenta até a implantação do projeto.
* Adaptação das planilhas de dados ao formato da ferramenta desenvolvida.
* Interface com estética e design minimalista
* Uma documentação de auxílio ao usuário do sistema. 
* Segurança para o consumidor optar pela permanência no Cadastro Positivo, pois não haverá risco de um problema esporádico e temporário comprometer o seu score.
* Melhorar o relacionamento e integração da SPC Brasil com os consumidores, mantendo assim seu pontecial competitivo no mercado.
* Construção de uma base confiável entre a SPC Brasil e o consumidor
* Responsablidade Social que imprime o caráter de liderança da empresa já que gera valor, não unicamente a ela, mas também à sociedade e ao entorno em que ela opera, reunindo valores intangíveis.


# Apresentação dos Códigos Desenvolvidos testados e aprovados

* Desenvolvemos 5 dataframes com as tabelas PGT_NOVA.xlsx, OPR_NOVA.xlsx, MVT_NOVA.xlsx, PF_NOVA.xlsx, Endereço PF_NOVA.xlsx.
* Desenvolvemos um dataframe para a Tabela Única, com as colunas principais das outras 5 tabelas.
* Para adicionar todos os dados no dataframe da Tabela Única, iniciamos por um laço na tabela PGT, adicionando os dados dessa tabela nas respectivas colunas, e com o 
id_opr_cad_pos, relacionamos os dados da tabela OPR, com o cpf da tabela OPR, relacionamos os dados da tabela pessoa física com o id e, por fim, relacionamos com os dados da tabela de endereço 
de pessoa físicas e adicionamos todos os dados de cada clienta no dataframe da Tabela Única.
* Reorganizamos a tabela para os CPFs ficarem agrupados.
* Corrigimos os formatos de data, para todos ficarem no mesmo padrão: 00/00/0000.
* Comparamos os dados de pagamentos de cada cliente para classificarmos como APTO ou NÃO APTO. Se o cliente fez todos os pagamento até a data de vencimento, ele é classificado como APTO, caso tenha atrasado algum pagamento, ele é classificado como NÃO APTO.
* Após todas as análises é criado um arquivo excel (xlsx) da Tabela Única, para ser utilizada na busca do executável.

![](https://github.com/marciosousa4/projeto-integrador/blob/master/Sprint%205/c%C3%B3digo%20tablea%20%C3%BAnica.gif?raw=true)

# Requisitos atingidos na Sprint 5

![](https://github.com/marciosousa4/projeto-integrador/blob/master/Sprint%205/Lista%20de%20requisitos.png?raw=true)

# Demonstração da Ferramenta 
![](https://github.com/marciosousa4/projeto-integrador/blob/master/Sprint%205/RELACIONAMENTO%20sprint%205.gif?raw=true)


