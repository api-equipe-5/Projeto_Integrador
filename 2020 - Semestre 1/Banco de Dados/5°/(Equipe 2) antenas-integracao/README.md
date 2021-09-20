<h1 align="center">Projeto Antenas</h1
\
\

![Antenas Logo](https://gitlab.com/jesscahelen/antenas-integracao/uploads/1e6947974c3be4ac0bc1026f297f904a/image.png)

<p align="center">
    <a href="#visao-geral">Visão Geral</a> -
    <a href="#fases-dos-projetos">Fases dos Projetos</a> -
    <a href="#acesso-ao-sistema">Acesso ao Sistema</a> -
    <a href="#tecnologias-utilizadas">Tecnologias Utilizadas</a>
</p>


# Visão Geral
O projeto Antenas permite que empresas, em conjunto com alunos, professores e gestores da [Fatec São José dos Campos - Prof. Jessen Vidal.](https://fatecsjc-prd.azurewebsites.net/) (FATEC-SJC), colaborem para a resolução de problemas, criação de novas funcionalidades em seus produtos e recrutamento de profissionais do ramo da tecnologia.

Através da criação e acompanhamento de um projeto no sistema Antenas, qualquer empresa da região de São José dos Campos e proximidades pode sugerir a realização de alguma solução tecnológica (seja a criação de uma nova tecnologia ou a resolução de algum problema atual da organização) e, após a aprovação de gestores do [Centro de Apoio ao Desenvolvimento e Inovação](https://fatecsjc-prd.azurewebsites.net/cadi.php) (CADI) da FATEC-SJC, essa solução é direcionada para um time de alunos, orientados por um professor, para ser realizada e entregue à empresa solicitante.

### Disciplina Laboratório de Projetos de Bancos de Dados - Alunos e Histórico de Entregas
Este projeto foi desenvolvido por alunos do quinto semestre do curso de Tecnologia em Bancos de Dados da FATEC-SJC durante o primeiro semestre de 2020.
\
\
Visualize os membros do projeto e o histórico de entregas na página da [Wiki](https://gitlab.com/jesscahelen/antenas-integracao/-/wikis/Time-e-Hist%C3%B3rico-de-Entregas).


# Fases dos projetos
![Projeto](https://gitlab.com/jesscahelen/antenas-integracao/uploads/168eac80fffc7e03b71e25ae07768826/image.png)
Em resumo, as 6 fases de um projeto no sistema Antenas são compostas pelos seguintes passos:

### I - Cadastro Inicial:
- Empresa se cadastra no sistema envia uma primeira proposta de projeto contendo apenas uma breve descrição.

### II - Avaliação Inicial:
- Membro do CADI aprova a primeira proposta e dá prosseguimento ao projeto

### III - Cadastro Detalhado:
- Empresa envia proposta de projeto com informações adicionais, como descriçao completa, lista de tecnologias utilizadas e links externos

### IV - Avaliação Detalhada:
- Membro do CADI aceita a proposta completa enviada pela empresa e retorna a ela uma lista de datas para a realição de uma reunião presencial com os responsáveis pelo projeto e um membro do CADI

### V - Reunião:
- Empresa escolhe a data da reunião e, após sua realização, escolhe um professor responsável por supervisionar um time de alunos que desenvolverá o projeto

### VI - Entrega:
- Após a organização do time e estabelecimento de uma data de entrega, cada aluno envia a parte do projeto pela qual é responsável e a solução completa é enviada à empresa solicitante.

![Projeto](https://gitlab.com/jesscahelen/antenas-integracao/uploads/e007f1f61bc292170fb75021de1701f2/image.png)

# Acesso ao sistema
Acesse uma versão de demonstração do sistema Antenas em: [link](http://34.95.208.245/).

### Monitoramento
A aplicação de demonstração foi instalada em um cluster de 3 máquinas virtuais na plataforma Google Cloud. Visualize a atividade do cluster neste [link](http://34.95.196.227:8080).

### Teste a aplicação
Para testar uma versão do projeto em um ambiente local, clone o projeto para uma máquina com ambiente JDK e gerenciador de projeto Maven instalados e rode os seguintes comandos no diretório do projeto:

>mvn clean install

>java -jar ./target/antenas.jar

Após a inicialização da aplicação, acesse o sistema através do endereço http://localhost:8080/.

# Tecnologias utilizadas
Entre as principais tecnologias utilizadas no sistema estão:
- Uso do framework [Spring Boot](https://spring.io/projects/spring-boot) para maior segurança no back-end e maior velocidade na manutenção do código e criação de novas funcionalidades

- Banco de dados [Mongo Atlas](https://www.mongodb.com/cloud/atlas) hospedado em nuvem, propiciando segurança dos dados mantidos e versionamento baseado em novos lançamentos da aplicação

- Realização de testes unitarios e de integração após o envio de novos commits para garantia da estabilidade da aplicação 

- Ciclos de CI e CD implementados pela plataforma [GitLab](https://about.gitlab.com/). 

- Análise de performance da aplicação com a ferramenta [JavaMelody](https://github.com/javamelody/javamelody/wiki) e monitoramento de qualidade do código pela ferramenta [SonarQube Cloud](https://www.sonarqube.org/). Acesse o relatório de qualidade de código do projeto neste [link](https://sonarcloud.io/dashboard?id=jesscahelen_antenas-integracao).

![DEVOPS_Arctetura](/uploads/6473cc4b02f5602ad7788e6e767afc3e/DEVOPS_Arctetura.jpg)

Para detalhes das tecnologias do sistema, acesse nossa [Wiki](https://gitlab.com/jesscahelen/antenas-integracao/-/wikis/home).
