# Planner

https://docs.google.com/spreadsheets/d/1TkCrRUHple8hmNI0jp1qU20dUsHuNtXHd2m8KdDF88I/edit#gid=0

## Sprint 3 

Detalhar as atividades realizadas:

- Deploy (AWS) (DevOps)
  - Foram criadas as maquinas no E2 AWS e configurada aplicação.
<h1 align="center">
    <img alt="GoBarber" src="/imagem/AWS-Deploy.png" />
</h1>

<h1 align="center">
    <img alt="GoBarber" src="/imagem/Server_Aplicação_Portainer.io.jpeg" />
</h1>

<h1 align="center">
    <img alt="GoBarber" src="/imagem/Server_Jenkins.jpeg" />
</h1>

- Gerenciador de pipeline (DevOps)

- Link Jenkins: 34.122.170.162:8080

- Nosso job é do tipo Pipeline job, onde criamos procuramos criar nossa esteira de CI (integração contínua) e CD (entrega contínua).

<h1 align="center">
    <img alt="Jenkins" src="/imagem/Jenkins/pipeline1.jpg" />
</h1>

- O projeto foi configurado para olhar o nosso repositório de código no GitHub e manter um histórico mínimo de builds. 

<h1 align="center">
    <img alt="Jenkins" src="/imagem/Jenkins/configuracaoJenkins.jpg" />
</h1>

<h1 align="center">
    <img alt="Jenkins" src="/imagem/Jenkins/configuracaoJenkins2.jpg" />
</h1>

<h1 align="center">
    <img alt="Jenkins" src="/imagem/Jenkins/buidJenkins.jpg" />
</h1>

- Também foi configurado para estar constantemente olhando para as alterações que são feitas no repositório (commits).

<h1 align="center">
    <img alt="Jenkins" src="/imagem/Jenkins/buidTriggerJenkins.jpg" />
</h1>

- Nosso Pipeline possui algumas configurações e estágios: Primeiramente são configurados os agentes que pode executar o pipeline.
Temos também a configuração das ferramentas necessárias, no nosso caso especifico, temos a configuração do Maven.
Estágio de Checkout, onde buscamos o código do repositório no GitHub.
Estágio de Test, estágio onde a aplicação é testada e passa por um processo de validação.
Estágio de Build, onde após os testes é feita a construção do projeto.
Esses estágios citados anteriormente são importantes pois nos permitem monitorar a aplicação, onde temos algumas ferramentas que nos ajudam a identificar possíveis erros e falhas.
Temos abas que nos ajudam a monitorar o status do projeto, as mudanças realizadas e a nível de build, podemos visualizar até mesmo uma saída via console com os logs.

-(Dashboard de um build do projeto).

<h1 align="center">
    <img alt="Jenkins" src="/imagem/Jenkins/dashboardBluid.jpg" />
</h1>

- (Tela do console).

<h1 align="center">
    <img alt="Jenkins" src="/imagem/Jenkins/consoleBuild.jpg" />
</h1>

- Todos esses estágios da nossa esteira são programados via pipeline script com pipeline syntax.

<h1 align="center">
    <img alt="Jenkins" src="/imagem/Jenkins/sintax.jpg" />
</h1>

<h1 align="center">
    <img alt="Jenkins" src="/imagem/Jenkins/sintax2.jpg" />
</h1>

- Por fim, temos um panorama da nossa esteira de CI/CD. Que nos permite identificar as etapas de validação pelas quais o projeto passa até ser realizada sua construção e o mesmo ir para deploy no servidor.

<h1 align="center">
    <img alt="Jenkins" src="/imagem/Jenkins/esteiraJenkins.jpg" />
</h1>

- Configuração Docker (Preparação do ambiente)(DevOps)
  - O Pacote Docker foi criado e testado para subir com a aplicação se a necessidade de demais configurações no ambiente:
  - Arquivo DockerFile
  
  ```bash
  FROM openjdk:11
  ARG PROFILE
  ARG ADDITIONAL_OPTS

  ENV PROFILE=${PROFILE}
  ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

  WORKDIR /opt/spring_boot

  COPY /target/spring-boot*.jar spring_boot_produtora.jar

  SHELL ["/bin/sh", "-c"]

  EXPOSE 5005
  EXPOSE 8080

  CMD java ${ADDITIONAL_OPTS} -jar spring_boot_produtora.jar --spring.profiles.active=${PROFILE}
  ```
- Configuração Docker (Preparação do ambiente)
  - Container configurado e UP pelo CMD utilizando o comando docker-compose up:
<h1 align="center">
    <img alt="GoBarber" src="/imagem/DockerUPcmd.jpg" />
</h1>

  - Imagens:
<h1 align="center">
    <img alt="GoBarber" src="/imagem/ImagesRunningDocker.jpg" />
</h1>

  - Container rodando com sucesso:
<h1 align="center">
    <img alt="GoBarber" src="/imagem/ContainerRunning.jpg" />
</h1>

- Segurança por token com JWT (Back-end) 
  - Atividade realizada no Back-end
