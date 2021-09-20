<h1 align="center"> Manual de Usuário </h1> 

<h1 align="center">
  <img src="https://github.com/QuodJP/PI-SPCBrasil-2020/blob/sprint-6/arquivos_readme/Logo_nome_transparente-01.png" alt="VisualData" width="300"></a>
  <br>
</h1>


## 1. Introdução
Esse documento tem por objetivo guiar o usuário quanto à instalação e utilização da
solução “Visual Data”.
Os passos para instalação explicação de conceitos serão descritos de forma detalhada
nos próximos tópicos.

## 2. Instalação do Sistema
Esta seção demonstra os procedimentos necessários para que o usuário instale a
solução corretamente.
Para Instalação da solução, basta seguir os passos descritos abaixo:
###### 1. Abra o arquivo “Visual Data Setup”.
###### 2. Execute o arquivo como administrador.
###### 3. Selecione o idioma e clique em "OK".
###### 4. Escolha o diretório (o recomendável é que mantenha o padrão) e clique em "Próximo >".
###### 5. "Próximo >".
###### 6. Escolha a opção "Criar um atalho na área de trabalho" e clique em "Próximo >".
###### 7. "Instalar".
###### 8. "Concluir".

<img src="https://github.com/QuodJP/PI-SPCBrasil-2020/blob/sprint-6/arquivos_readme/2.png" width="800"></a>
  

Após o término da instalação do arquivo “visualdata-setup”, você terá instalado o arquivo
de configuração do sistema e o python 3.8.2 em seu computador.
O próximo passo, é instalar as bibliotecas do python para funcionamento adequado do
sistema.
Abra o arquivo "requirements" e em seguida pressione qualquer tecla para continuar.

<img src="https://github.com/QuodJP/PI-SPCBrasil-2020/blob/sprint-6/arquivos_readme/2.1.png" width="800"></a>

Em seguida, você deverá tratar as planilhas .csv. Para isso, prossiga com as
instruções abaixo:
###### 1. Abra o arquivo "UpDate" para tratamento das planilhas em formato .csv.
###### 2. Clique em "Selecionar" para escolher as respectivas planilhas: “pessoa_fisica”, “endereco_pessoa_fisica” e “opr".


<img src="https://github.com/QuodJP/PI-SPCBrasil-2020/blob/sprint-6/arquivos_readme/2.2.png" width="800"></a>

###### 3. "Processar".

<img src="https://github.com/QuodJP/PI-SPCBrasil-2020/blob/sprint-6/arquivos_readme/2.3.png" width="800"></a>

###### 4. "Sair".

## 2.1. Tratar nova remessa de dados
Para tratamento de novos dados, basta executar o arquivo “UpDate”, insira as novas
planilhas e processe os dados novamente.
Durante este processo é importante que a solução não esteja sendo executada em
segundo plano.

## 2.2. Visualização dos dados tratados
Para visualização dos dados tratados, basta abrir a solução (arquivo “VisualData.pbix”).

## 2.3. Atualização dos dados tratados
Caso haja alguma atualização em alguma das planilhas que foram importadas, não é
necessário que sejam tratadas novamente, basta clicar em “Atualizar”, conforme
imagem abaixo e os dados serão atualizados automaticamente.

<img src="https://github.com/QuodJP/PI-SPCBrasil-2020/blob/sprint-6/arquivos_readme/3.png" width="600"></a>

## 3. Indicadores do sistema
Este tópico aborda cada indicador, descrevendo seus conceitos e o que é apresentado
em cada indicador, conforme descrições abaixo:
### Guia “Nacional”
###### 1. Quantidade: Dados absolutos referentes ao total de financiamentos de
veículos de cada região e o somatório do país.
###### 2. Quantidade Brasil por região: Representação de gráfica em valores
absolutos e em porcentagem da participação de cada região no âmbito
nacional.
###### 3. Quantidade Brasil por faixa: Somatório de financiamentos de veículos, de
todas as regiões, agrupados por faixa de valor.
###### 4. Valor Brasil por região: Apresentação do montante de contratos de
financiamento e participação de cada região no mercado nacional.
###### 5. Quantidade Brasil por faixa e região: Comparativo de financiamento de veículos entre as regiões, agrupados por faixa de valor.


<img src="https://github.com/QuodJP/PI-SPCBrasil-2020/blob/sprint-6/arquivos_readme/3.1.png" width="600"></a>


### Guia “Região”
###### 1. Filtros: Escolha por faixa de valor ou por estado.
###### 2. Quantidade / Porcentagem por faixa: Apresentação gráfica em valores absolutos e em porcentagem referentes à participação de cada faixa em sua região.
###### 3. Nacional | Estado(s): Comparativo da quantidade de financiamentos com o país, em valores absolutos e porcentagem.
###### 4. Quantidade por faixa: Quantidade de financiamentos em valores absolutos, de cada estado, agrupados por faixas de valor
###### 5. Quantidade Financiamentos por Estado: Comparativo da quantidade de financiamentos entre estados.
###### 6. Valor Total Financiamento por Estado: Comparativo do montante de financiamentos entre estados.

<img src="https://github.com/QuodJP/PI-SPCBrasil-2020/blob/sprint-6/arquivos_readme/3.2.png" width="600"></a>
