# Sprint 6

### Produto Final: 
>Nessa sprint, apresentamos uma aplicação sem necessidade de instalação e com uma interface amigável. Baixe o repositório ou se preferir baixe essa versão diretamente desse link: [https://drive.google.com/file/d/1QN7DHXHW3LQXIf5wg6kZnjOomnOE5SOs/view?usp=sharing](https://drive.google.com/file/d/1QN7DHXHW3LQXIf5wg6kZnjOomnOE5SOs/view?usp=sharing). Abaixo apresentamos os benefícios gerados pela aplicação.

![](https://i.imgur.com/gFYhzp7.png)

**Soluções adotadas:**

 - Desenvolvimento da interface dos relatórios em documento HTML
 - Executável feito em Python com a biblioteca cx_freeze
 - Adoção de gráficos em formato interativo com a biblioteca plotly
 - Todos os códigos e arquivos desenvolvidos nessa sprint estão na pasta codigos_desenvolvidos

**Requisitos alcançados:**

![](https://i.imgur.com/PrMUCUV.jpg)

# Demonstração

**Executando o METAapp:**

![](https://i.imgur.com/SKwXzmw.gif)

**Visualização do relatório:**

![](https://i.imgur.com/TGv7iFU.gif)

# Instruções de Uso

**AVISO:** Essa aplicação é compatível somente com sistemas Windows.  

Não é preciso instalar nada, apenas baixe esse repositório, descompacte-o, navegue até a pasta SPRINT 6, descompacte o arquivo METAapp_4.zip e execute o arquivo METAapp_4.exe.  

Se preferir baixe o programa diretamente desse link: [https://drive.google.com/file/d/1QN7DHXHW3LQXIf5wg6kZnjOomnOE5SOs/view?usp=sharing](https://drive.google.com/file/d/1QN7DHXHW3LQXIf5wg6kZnjOomnOE5SOs/view?usp=sharing)  

# Histórico das Sprints

### Sprint 1

**Resultado da entrega:**
 - Nessa entrega, a equipe estava situando-se aos requisitos e necessidades do cliente, a primeira entrega trata-se de uma análise preliminar dos dados e desenvolvimento inicial de requisitos do cliente. Apenas usuários com conhecimento em programação conseguem utilizá-la, o que não interfere na usabilidade do produto pois esse tipo de usuário está entre os atores do projeto.

**O que o(s) usuário(s) consegue(m) fazer:**
 - Verificar validade dos CNPJs encontrados (requisito 8*, 10)
 - Verificar o valor total de parcelas movimentadas por modalidade (requisito 20)
 - Verificar o número de pagamentos por modalidade (requisito 39*)

>*Parcialmente resolvido

**Atividades desenvolvidas pela equipe:**
 - Definição da linguagem a ser desenvolvida: Python para análise de dados e HTML para a interface dos relatórios
 - Definição dos usuários da aplicação: administrador (posteriormente chamado de analista técnico) e colaborador (usuários da área administrativa)
 - Levantamento inicial de requisitos
 - Desenho inicial dos casos de uso pelos usuários
 - Desenvolvimento das análises através do Jupyter Notebook com a linguagem Python

### Sprint 2

**Resultado da entrega:**
 - Trata-se também de uma entrega para usuários técnicos, nessa entrega, já é possível obter alguns indicadores de forma automatizada, também é possível apenas abrir o documento Jupyter através da biblioteca voila e visualizar os resultados sem necessidade de interação pelo usuário, desde que todos os recursos estejam devidamente instalados. Encerra-se também nessa entrega, o levantamento de requisitos e desenho de casos de uso.

**O que o(s) usuário(s) consegue(m) fazer:**
 - Todos os recursos da entrega anterior
 - Verificar alguns indicadores de validação das tabelas (requisitos 11, 12*, 21 e 22*)
 - Verificar alguns indicadores de resultados da remessa (requisitos 17, 18, 19, 27, 28, 29, 30, 38, 39 e 40*)

>*Parcialmente resolvido

**Atividades desenvolvidas pela equipe:**
 - Fechamento do levantamento de requisitos
 - Fechamento do desenho de casos de usos
 - Desenvolvimento das análises através do Jupyter Notebook com a linguagem Python
 - Oferecimento de interação dos resultados do Jupyter Notebook através da biblioteca Voila

### Sprint 3

**Resultado da entrega:**
 - Apresentação de um protótipo de interface através do uso do terminal do sistema operacional com um menu simples sem necessidade de inserção de código de programação. Visualização dos resultados obtidos através da interface HTML, sendo esse último possível de ser utilizado por qualquer usuário, bastando apenas abrir o arquivo HTML no navegador de preferência do usuário. Porém, essa entrega, ainda trata-se de um software para usuário com conhecimento técnico em programação já que para utilizá-lo é necessário a instalação da IDE do Python e de todas as bibliotecas necessárias para o seu funcionamento.

**O que o(s) usuário(s) consegue(m) fazer:**
 - Todos os recursos das entregas anteriores
 - Verificar indicadores de validação das tabelas (requisitos 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 22, 23, 24, 25 e 26)
 - Verificar indicadores dos resultados da remessa (requisitos 40)
 - Visualizar os relatórios com os resultados obtidos (requisito 43*, 44*, 45*, 46*, 47* e 48*)

>*Parcialmente resolvido

**Atividades desenvolvidas pela equipe:**
 - Exportação dos códigos das análises inteiramente para linguagem Python
 - Adoção da biblioteca plotly para visualização de gráficos interativos
 - Desenvolvimento da interface dos relatórios em HTML

### Sprint 4

**Resultado da entrega:**
 - Nessa sprint, o usuário já é capaz de utilizar a aplicação sem necessidade de conhecimento em programação. O usuário pode selecionar a localização das tabelas e o local para salvar os relatórios. Com os resultados obtidos é possível obter informações sobre a validação das tabelas, os resultados de movimentações, pagamentos e operações e o índice de pagamento em dia.

**O que o(s) usuário(s) consegue(m) fazer:**
 - Todos os recursos das entregas anteriores
 - Utilizar uma interface para analisar os dados (requisito 1*, 90, 91 e 92)
 - Verificar indicadores de validação das tabelas (requisitos 61, 62, 63, 64, 65, 66, 67 e 68)
 - Verificar indicadores dos resultados da remessa (requisitos 31, 32, 33, 34, 35, 36, 37, 41, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59 e 60)
 - Verificar índice de pagamentos em dia (requisitos 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87 e 88)
 - Visualizar os relatórios com os resultados obtidos (requisito 49*, 89)
 - Manipular os dados preservando a privacidade dos dados sensíveis (requisito 42)
 - Manipular a visualização dos gráficos (requisitos 69, 70, 71)

>*Parcialmente resolvido

**Atividades desenvolvidas pela equipe:**
 - Ajuste de requisitos por solicitação do cliente
 - Ajuste do desenho de casos de uso
 - Ajuste da interface dos relatórios
 - Exportação dos códigos das análises inteiramente para linguagem Python
 - Desenvolvimento da interface da aplicação de análise com a biblioteca Tkinter e executável gerado com a biblioteca cx_Freeze
 - Adoção da biblioteca plotly para visualização de gráficos interativos
 - Desenvolvimento da interface dos relatórios em HTML

### Sprint 5

**Resultado da entrega:**
 - A sprint 5 mantém os valores da sprint anterior e finaliza ajustes da interface dos relatórios, traz também, um novo índice sobre o número de pagamentos por cliente para cada de faixa de valor.

**O que o(s) usuário(s) consegue(m) fazer:**
 - Todos os recursos das entregas anteriores
 - Verificar de Índice do Número de Pagamentos por Clientes (requisitos 93 e 94)
 - Visualizar os relatórios com os resultados obtidos (requisitos 43, 44, 45, 46, 47, 48, 49 e 95)

**Atividades desenvolvidas pela equipe:**
 - Ajuste final da interface dos relatórios
 - Exportação dos códigos das análises inteiramente para linguagem Python
 - Desenvolvimento da interface da aplicação de análise com a biblioteca Tkinter e executável gerado com a biblioteca cx_Freeze
 - Adoção da biblioteca plotly para visualização de gráficos interativos
 - Desenvolvimento da interface dos relatórios em HTML

### Sprint 6

**Resultado da entrega:**
 - Finalização do projeto, todos os requisitos são alcançados, aqui apresenta-se uma aplicação cuja a utilização é fácil, intuitiva e objetiva. Traz valor com os relatórios e índices obtidos e garante a integradidade da usabilidade.

**O que o(s) usuário(s) consegue(m) fazer:**
 - Todos os recursos das entregas anteriores
 - Utilizar uma interface para analisar os dados (requisito 1, 96, 97 e 98)

**Atividades desenvolvidas pela equipe:**
 - Ajuste final da interface da aplicação de análise seguindo preceitos de identidade visual, design e usabilidade
 - Exportação dos códigos das análises inteiramente para linguagem Python
 - Desenvolvimento da interface da aplicação de análise com a biblioteca Tkinter e executável gerado com a biblioteca cx_Freeze
 - Adoção da biblioteca plotly para visualização de gráficos interativos
 - Desenvolvimento da interface dos relatórios em HTML
