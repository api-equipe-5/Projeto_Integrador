# Sprint 3 - 05/10 A 18/10

**O Objetivo dessa Sprint foi:**

1. Implementação de criptografia de dados, com a finalidade de ofuscar dados pessoais. 
    - Geração de chaves e códigos de autenticação utilizando o Java Cryptography Extension ou JCE.

    ### Implementação Back-end
    ![backend](images/backend.gif)

2. Implementar regra de compartilhamento visando dados estatística (dados sem link com o titular). 
    - Inserção de alguns [dados](https://github.com/RodrigoMarcelin/safe_share/blob/master/bd/data.sql) fictícios no Banco de Dados para testes. 

    - Foi criado um [trigger](https://github.com/RodrigoMarcelin/safe_share/blob/master/bd/trigger.sql) no Banco de dados para sempre que o titular modificar o campo se deseja ou não compartilhar os seus dados seja criado um log com data e campo modificado. 
    
    - Inicializado algumas especificações do front-end. 




### **Todos os passos podem ser reproduzidos localmente, seguindo cada passo a passo abaixo:**

[Backend](https://github.com/RodrigoMarcelin/safe_share/tree/master/backend)

[Frontend](https://github.com/RodrigoMarcelin/safe_share/tree/master/frontend)

[Banco de Dados](https://github.com/RodrigoMarcelin/safe_share/tree/master/bd)