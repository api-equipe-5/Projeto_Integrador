# Sprint 4 - 19/10 A 01/11

**O Objetivo dessa Sprint foi:**

1. Implementação de uma regra de negócio, onde o compartilhamento de dados pessoais, só aconteça com prévia autorização do titular, isso por solicitação de compartilhamento, deixando claro os fins para tratamento desses dados. 
    - Afim de melhorar o gerenciamento de Log's da aplicação, foi implementado o [LoggerFactory](https://github.com/RodrigoMarcelin/safe_share/blob/master/backend/src/main/java/com/si/safe_share/resource/ConfiguracaoCompartilhamentoResource.java), com o intuito de deixar mais consistente sem possibilidade de manipulação dos dados. 
    - [Criação](https://github.com/RodrigoMarcelin/safe_share/blob/3884a6c49adc45c548e291df348c8782dc9df5ec/backend/src/main/java/com/si/safe_share/resource/ConfiguracaoCompartilhamentoResource.java#L72) de uma tabela para armazenar o id do usuário e a chave gerada aleatóriamente. 
    - Implementação do [select](https://github.com/RodrigoMarcelin/safe_share/blob/master/bd/selects.sql). 
    - Funcionalidades do front-end. 

### **Todos os passos podem ser reproduzidos localmente, seguindo cada passo a passo abaixo:**

[Backend](https://github.com/RodrigoMarcelin/safe_share/tree/master/backend)

[Frontend](https://github.com/RodrigoMarcelin/safe_share/tree/master/frontend)

[Banco de Dados](https://github.com/RodrigoMarcelin/safe_share/tree/master/bd)