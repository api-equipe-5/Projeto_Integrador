![Sprint2](https://github.com/marciosousa4/projeto-integrador/blob/master/Sprint%202/sprint%202.jpg)
# Prioridade da Sprint 2

Essa Sprint está classificada como uma obrigação para o time. Ela representa uma necessidade não-negociável para o projeto, pois para fazer a análise e apontar os indicativos de qualidade e negócio dos dados, é preciso que todas as informações recebidas estejam corretas. 
Seria um despedício de tempo submeter todos os dados aos processo de qualificação analítica, sem que eles forneçam algum valor de produção para o négócio. Por isso, foi priorizado nessa entrega a qualificação e separação dos dados utéis, que seguirão para as próximas etapas, dos dados que apresentaram erro de processamento, que seguirão de volta para os agentes de negócio.

# Requisitos Funcionais Sprint 2

* O time de desenvolvimento deve criar um código para verificar a consistência, completude e confiabiliade dos dados;
* O código deve permitir que o time de desenvolivimento da SPC Brasil faça a verificação das tabelas e apresente um relatório de erros encontrados;
* O código deve separar os dados usáveis que serão enviados para a proxima etapa do desenvolvimento;
* O código deve separar os dados que apresentaram erros de processamento;
* O time de desenvolvimento deve enviar de volta para os agentes finaceiros os dados que apresentaram erros de processamento para a correção.

# Requisitos não - funcionais
* Previnir de erros;
* Ajudar os usuários a reconhecer, diagnosticar e recuperar erros;
* Sistematizar as informações (numéricas e em forma de texto), que devem ser apresentadas de forma clara e precisa, para facilitar a leitura e a compreensão dos dados.
* Garantir a confiabilidade e a segurança dos dados. 
* Melhorar a usabilidade dos dados, pois eles serão filtrados de forma fácil utilizando os códigos de programação.
* Desenvolver  a governança dos dados para que nas próximas etapas eles estejam mais consistentes e, assim, melhorar a experiência do usuário;


# Apresentação dos códigos desenvolvidos
Para fazer a o tratamento e análise dos dados das tabelas que recebemos do SPC, e assim, assegurar de forma ágil e com segurança o compartilhamento e integração das informações, apontaremos os indicadores de Confiabilidade, Completude e Consistência.
Esse relatório tem como objetivo, mostrar o que cada campo de código criado executa e qual a sua importência para o desenvolvimento do projeto. Analisando cada um desses itens, cumpriremos o objetivo principal dessa Sprint de apresentar de forma sintetizada e consistente os erro de processamento que possivelmente ocorrem no recebimento do lote de dados. 

# Confiabiliade 
Para verificar esse indicador, nós trabalhamos com a tabela que consta a fonte dos fornecedores de dados para o SPC, pois essa tabela possui um campo que pode ser verificado se o valor tem o formato correto, neste caso o campo de CNPJ.
Com o código desenvolvido pode ser verificada a quantidade de CNPJs que estão dentro do padrão, que são 14 dígitos entre CNPJ e o seu complemento. Tudo que está dentro do padrão é atribuído para à lista “usáveis”, tudo que está fora do padrão é atribuído à lista “nao usáveis”. Essa lista atende aos requisitos listados acima e aumenta o valor dos dados para o negócio.

# Completude 
Para verificar a completude dos dados, verificamos as tabelas de Movimentação, Operações, Pagamento e Fontes. Essas informações precisam estar completas para que os relatórios gerados estejam de acordo com as regras de negócio e possam ser, também, geradores de produtos e perfis de consumidores. Ao fazer a verificação o código também apresenta a representação gráfica do que foi analisado, dessa forma, o cliente poderá ter uma visão mais clara e intuitiva do que está sendo recebido. 

# Consistência
Se refere à integridade cruzada entre duas ou mais fontes que armazenam o mesmo dado. verifica se  O atributo está de acordo com as regras de negócios e suas dependências. Tendo em vista essa definição, verificamos todas as tabelas, tentando cruzar os dados de cada coluna com a sua tabela de origem, para checar se estava consistente.
Na tabela STG_PGT (Pagamentos), a coluna DAT_VCT tem como tabela de origem “dat_vct”.
O restante das colunas tem como tabela de origem “pgt_cad_pos”.
Na tabela STG_MVT_CRD, todas as colunas tem como tabela de origem “mvt_cad_pos”.
Na tabela STG_OPR_ITT, todas as colunas tem como tabela de origem “opr_cad_pos”.
Na tabela STG_FNT_ITT, todas as colunas tem como tabela de origem “fonte_cad_positivo”.
Na tabela STG_MDL, todas as colunas tem como tabela de origem “modalidade_bancaria_cad_pos”.
Nós nâo temos acesso à nenhuma dessas tabelas, da origem, portanto não é possível calcular o indicador de Consistência.

# Representações Gráficas

Os gráficos passarão por processos de refinamento no desenvolvimento do projeto, e com a integração na interface serão ferramentas decisivas no critério de devolução dos dados para o agente financeiro ou continuidade na aplicação dos indicadores de negócio. 
Os gráficos se referem sequencialmente a:
* Gráfico de completude da tabela Fontes
* Gráfico de completude da tabela Movimentação
* Gráfico de completude da tabela Pagamentos
* Gráfico de completude na tabela Operações
* Gráfico de duplicidade da tabela Fontes 
* Gráfico de duplidades da tabela Modalidades

![Gráfico de Completude da Tabela Fontes](https://raw.githubusercontent.com/marciosousa4/projeto-integrador/c32a42a93512432fcf48e13a823cffe0d8b947d6/Completude%20de%20dados%20FNT.jpeg)

![Gráfico de Completude da Tabela Movimentação](https://raw.githubusercontent.com/marciosousa4/projeto-integrador/c32a42a93512432fcf48e13a823cffe0d8b947d6/Completude%20de%20dados%20MVT.jpeg)

![Gráfico de Completude da Tabela Pagamentos](https://raw.githubusercontent.com/marciosousa4/projeto-integrador/0ae6932a0b55667f2f3f7868bfa18596dfe253ec/Completude%20Pagamentos.jpeg)

![Gráfico de Completude da Tabela Operações](https://raw.githubusercontent.com/marciosousa4/projeto-integrador/0ae6932a0b55667f2f3f7868bfa18596dfe253ec/Completude%20Opera%C3%A7%C3%B5es.jpeg)

![Gráfico de duplicidade da Tabela Fontes](https://raw.githubusercontent.com/marciosousa4/projeto-integrador/c32a42a93512432fcf48e13a823cffe0d8b947d6/Duplicidade%20FNT.jpeg)

![Gráfico de duplicidade da Tabela ](https://raw.githubusercontent.com/marciosousa4/projeto-integrador/c32a42a93512432fcf48e13a823cffe0d8b947d6/Duplicidade%20MDL.jpeg)

# Visualização dos códigos
Os códigos podem ser visualizados em execução nos vídeos que seguem após as instruções de navegação. Essas instruções são para executar os códigos no computador.  

* **Instruções e Navegações**
* Coloque as tabelas “.xlsx” e o arquivo “.ipynb” todos na mesma pasta.
* Instale Python 3.6 ou superior, selecionando a opção PATH na instalação.
* Após a instalação do Python abrir o prompt de comando (CMD) e digitar:
* pip install jupyter notebook
* Após isso instale a biblioteca necessária:
* pip install pandas
*Após a instalação, para abrir o Jupyter Notebook, abra o prompt de comando (CMD) e digite:

* start jupyter notebook


[Clique aqui para visualizar o código completude Movimentação](https://youtu.be/bqfsDZ2YdSQ)<img src="https://raw.githubusercontent.com/marciosousa4/projeto-integrador/1187733de59909b469e1f261c4219da7e665232e/download%20you%20tube.png" width="50" height="50" /> 


[Clique aqui para visualizar o código completude - Fontes](https://youtu.be/GJnrySIjHO8)<img src="https://raw.githubusercontent.com/marciosousa4/projeto-integrador/1187733de59909b469e1f261c4219da7e665232e/download%20you%20tube.png" width="50" height="50" />
 

[Clique aqui para visualizar o código duplicidades - Modalidades](https://youtu.be/UHmXvOQGb9A)<img src="https://raw.githubusercontent.com/marciosousa4/projeto-integrador/1187733de59909b469e1f261c4219da7e665232e/download%20you%20tube.png" width="50" height="50" />

[Clique aqui para visualizar o código duplicidades - Fontes](https://youtu.be/Lh_nIWh4GRw)<img src="https://raw.githubusercontent.com/marciosousa4/projeto-integrador/1187733de59909b469e1f261c4219da7e665232e/download%20you%20tube.png" width="50" height="50" />


[Clique aqui para visualizar o código completude - Operações](https://youtu.be/_zoLoQuPlWk)<img src="https://raw.githubusercontent.com/marciosousa4/projeto-integrador/1187733de59909b469e1f261c4219da7e665232e/download%20you%20tube.png" width="50" height="50" />


[Clique aqui para visualizar o código completude - Pagamentos](https://youtu.be/Z-t11YYYQQw)<img src="https://raw.githubusercontent.com/marciosousa4/projeto-integrador/1187733de59909b469e1f261c4219da7e665232e/download%20you%20tube.png" width="50" height="50" />



