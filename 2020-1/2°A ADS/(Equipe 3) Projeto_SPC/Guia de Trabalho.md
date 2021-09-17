# Guia de Trabalho

- Os arquivos da SPRINT atual devem ser colocados na respectiva pasta  
- **NÃO SUBIR ARQUIVOS ANTES DO DIA DA ENTREGA**  
```
    Disponibilizar os arquivos no grupo privado do WhatsApp
    e diretamente com o membro que solicitar
```
- Indicar no arquivo requirements.txt da respectiva SPRINT, as bibliotecas utilizadas. Se a biblioteca já constar no arquivo, não alterar  
- Outras regras surgirão no decorrer das SPRINTs  

## O TIME

**Product Owner:** Guilherme
```
    Responsável por:  contatar o cliente, levantar requisitos e estórias do usuário com o cliente,
                      definir tarefas e entregas dos sprints junto ao cliente,
                      definir o nível de dificuldade junto ao Scrum Master
```
**Scrum Master:** Diego
```
    Responsável por:  prepar documentação, delegar tarefas e preparar fluxo de trabalho,
                      dar assistência a todos os membros, fazer pontes internas,
                      definir o nível de dificuldade junto ao Product Owner
```
**Developers:** Diego, Guilherme, João, Rodrigo, Thalles, William

## SPRINT 6

~~Desenvolver identidade gráfica do produto~~  
~~Atualizar HTML~~  
~~Atualizar executável~~  
~~Realizar testes e corrigir os códigos~~  

## SPRINT 5

~~Corrigir Backlog~~  
~~Gerar indicar sobre número de movimentações, operações e pagamentos por clientes~~  
~~Desenvolver índice sobre o número de pagamentos por clientes~~  
~~Atualizar HTML~~  
~~Atualizar executável~~  
~~Realizar testes e corrigir os códigos~~  

## SPRINT 4

~~Corrigir Backlog~~  
~~Corrigir Diagrama de Casos de Uso~~  
~~Desenvolver interface gráfica~~  
~~Atualizar HTML~~  
~~Atualizar executável~~  
~~Realizar testes e corrigir os códigos~~  

## SPRINT 3

**Guilherme**  
**`Teste Principal`** ~~Testar a possibilidade de chamar frames de HTML dentro das páginas~~  
**`Teste Opcional`** ~~Testar a possibilidade de gerar HTMLs com a biblioteca Dash~~  
~~Desenvolver HTML~~  

**Diego**  
~~Padronizar legendas, cores e organização~~  
~~Desenvolver layout das informações~~  

**O Time**  
~~Quebrar gráficos (dividí-los) para melhorar a visualização das informações~~  
~~Utilizar a biblioteca plotly~~  
~~Gerar executável do tratamento dos gráficos~~  

## SPRINT 1 e SPRINT 2

**Guilherme (STG_FNT_ITT)**  
`único` ~~Contar CNPJs válidos~~  
`único` ~~Contar nome social e razão social com valores únicos~~  
*`comum`* ~~Verificar recência dos dados~~  
*`comum`* ~~Contar linhas com campos completos e desprezar os invalidados nas análises~~  

**Diego (STG_MVT_CRD)**  
*`comum`* ~~Contar linhas com campos completos e desprezar os invalidados nas análises~~  
*`comum`* ~~Validar as modalidades~~  
*`comum`* ~~Verificar recência dos dados~~  
`único` ~~Contar número de clientes únicos por modalidade~~  
`único` ~~Contar número de movimentações por modalidade~~  
`único` ~~Valor das parcelas do saldo utilizado por modalidade~~  
`único` ~~Valor total  das faturas no cartão de crédito~~  
`único` ~~Valor mínimo das faturas no cartão de crédito~~  

**Thalles / William (STG_OPR_ITT)**  
*`comum`* ~~Contar número de linhas com todos os campos preenchidos e deprezar na análise as invalidadas~~  
*`comum`* ~~Validar as modalidades~~  
*`comum`* ~~Verificar recência dos dados~~  
`único` ~~Número de operações por modalidade~~  
`único` ~~Comparar valor total e valor não pago do contratado da modalidade (C01/Consócio)~~  
`único` ~~Número de parcelas por modalidade~~  

**João / Rodrigo (STG_PGT)**  
*`comum`* ~~Contar número de linhas com todos os campos preenchidos e deprezar na análise as invalidadas~~  
*`comum`* ~~Validar as modalidades~~  
*`comum`* ~~Verificar recência dos dados~~  
`único` ~~Número de pagamentos por modalidade~~  
`único` ~~Número de registros vencidos por modalidade~~  
`único` ~~Valor total de pagamentos por modalidade~~  
