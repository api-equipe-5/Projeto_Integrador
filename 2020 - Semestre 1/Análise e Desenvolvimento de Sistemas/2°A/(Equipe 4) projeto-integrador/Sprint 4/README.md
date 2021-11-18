![](https://github.com/marciosousa4/projeto-integrador/blob/master/Sprint%204/Sprint4.jpg)

# Objetivos

  - Apresentar o escopo do projeto e a nova documentação com as alterações solicitadas pelo cliente.
  - Sugerir o canal de comunicação entre o consumidor e a SPC Brasil para solicitação de inclusão no Auxílio emergencial positivo.
  - Apresentar o algoritmo desenvolvido para verificação dos clientes que solicitaram a exclusão dos seus dados do Cadastro Positivo e que ainda constam na tabela de pagamentos.
  -  O algoritmo desenvolvido para verificar a consistência do padrão de números do CPF dos consumidores.
  -  A interface que será utilizada pelo Assistente de Atendimento da SPC Brasil para dar suporte a solicitação do consumidor.
 
 # Requisitos Sprint 4

1.	Como consumidor preciso ser incluso no Auxílio emergencial positivo, pois estou em uma situação emergencial que está comprometendo o equilíbrio entre receitas e despesas em minha vida pessoal.
*	Disponibilizar Canais de contato para que seja feita essa solicitação (email, telefone ou presencial). Incluir o item no campo de atendimentos da página fale conosco da SPC Brasil. 
*	Informar para o consumidor quais são as reais situações que pode ser requerido o auxílio. Colocar na página da SPC Brasil o item explicativo do projeto. 
*	Ter uma interface que apresente o que é o Auxílio emergencial positivo, para colocar na página da SPC Brasil. 

2.	Como assistente de atendimento da SPC Brasil, quero dar suporte à solicitação do consumidor que precisa ser incluso no Auxílio emergencial positivo.
*	Ter uma aplicação para desktop, a fim de não comprometer a segurança das informações e facilitar a distribuição da ferramenta.
*	Ter uma interface contendo a tela inicial da ferramenta que mostre a opção de consulta de CPF do cliente.
*	Usar o framework Electron que permite o desenvolvimento de aplicações para desktop GUI com componentes criados para aplicações web.
*	No desenvolvimento da interface, utilizar a linguagem de marcação HTML e a folha de estilo CSS, por apresentarem grande versatilidade de edição de layout e cores.
*	Aplicar a 8 heurística de Jakob Nielsen, “estética e designer minimalista”, assim o assistente poderá verificar com rapidez agilidade e de forma desburocratizada a possibilidade de atendimento do consumidor. 
*	Manter consistência entre as telas da aplicação com as telas padrões da SPC Brasil será essencial para que não seja necessário o entendimento de vários padrões e formas de interações diferentes para cada tela. 
  
  # Comunicação: Consumidor e SPC Brasil para solicitar o Auxílio Emergencial Positivo
    

Para que o consumidor faça a solicitação do Auxílio emergencial positivo, sugerimos criar a opção na página da SPC Brasil contendo essa solicitação. Com a criação desse canal de relacionamento, a SPC Brasil já pode receber as solicitações dos consumidores enquanto aguarda o desenvolvimento do produto final.
E para os que não tem acesso aos canais web, fornecer os canais de teleatediemento e os postos de atendimento do consumidor.

![](https://github.com/marciosousa4/projeto-integrador/blob/master/Sprint%204/Tela%201.jpg)
![](https://github.com/marciosousa4/projeto-integrador/blob/master/Sprint%204/Tela%20Faleconosco.jpg)

# Tratamento de dados.

Elaboramos um algoritmo para verificar na tabela de pagamentos os consumidores que solicitaram a exclusão do cadastro positivo e retirá-los da base de dados que vai para o cadastro emergencial.
Também desenvolvemos um código que verifica na tabela de operações e cadastro de pessoa física, se os números de CPF estão dentro do padrão de 11 números. Se sim eles irão compor a base da dados do auxílio emergencial positivo.
Os algoritmos desenvolvidos são capazes de ler as extensões xlsx e csv da base de dados enviadas pelo SPC e fazer a verificação nas tabelas específicas onde se encontram os dados

![](https://github.com/marciosousa4/projeto-integrador/blob/master/Sprint%204/an%C3%A1lise%20tabelas.gif)


# Interface do Auxílio Emergencial Positivo
Desenvolvemos uma interface que será utilizada pelo Assistente de Atendimento da SPC Brasil. 

A interface contém:
* acesso a um passo a passo de como utilizar a ferramenta
* Tela de consulta do CPF
* Tela que contém as condições de recebimento do auxilio e o campo para anexar os docs comprobatórios.

Ambiente 

 * Usamos framework Electron que permite o desenvolvimento de aplicações para desktop GUI usando componentes criados para aplicações web.
* Utilizamos a linguagem de marcação HTML e a folha de estilo CSS, por apresentarem grande versatilidade de edição de layout e cores.


![](https://github.com/marciosousa4/projeto-integrador/blob/master/Sprint%204/Interface.gif)
