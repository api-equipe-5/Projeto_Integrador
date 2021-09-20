# Sprint 2 - 21/09 A 04/10

**O Objetivo dessa Sprint foi:**

1. Estrutura do Banco de Dados da aplicação. 
    * [Modelo](https://github.com/RodrigoMarcelin/safe_share/blob/master/bd/modelo.sql) físico do Banco de dados utilizando o SGBD PostgreSql.

2. Back-end inicial para simulação de dados. 
    * O projeto foi iniciado com Spring Boot, com os módulos de persistência JPA (para persistir objetos Java), Lombok(biblioteca Java focada em produtividade e redução de código). E o compilador Maven. Mais detalhes da configuração inicial do projeto pode ser vista em [Pom](backend/pom.xml).
    * Diagrama de Classe.
    * Criação das entidades bem como os endpoints.
    * Adição do projeto no Swagger (que é um framework para descrição, consumo e visualização de serviços RESTful, bem como a documentação da implementação).
    * Deploy da API, que pode ser acessada pelo site: https://safe-share-si.herokuapp.com/swagger-ui.html#/
    
    ![deploy](images/deploy.gif)  


### **Todos os passos podem ser reproduzidos localmente, seguindo cada passo a passo abaixo:**

[Backend](https://github.com/RodrigoMarcelin/safe_share/tree/master/backend)

[Banco de Dados](https://github.com/RodrigoMarcelin/safe_share/tree/master/bd)