# Projeto Antenas (Devops)

![logo](https://raw.githubusercontent.com/mrocha98/antenas-front/master/public/apple-touch-icon.png)

Este repositório é utilizado para compartilhar as entregas para a disciplina de Laboratório de Projeto de Bando de Dados V, ministrada pelo professor Eduardo Sakaue.
O objetivo do projeto é implementar um conjunto de melhores práticas de desenvolvimento de software (Dev) e operações de TI (Ops), DevOps para disponibilizar a aplicação web Antenas.

## Índice

- [Projeto Antenas (Devops)](#projeto-antenas-devops)
  - [Índice](#índice)
  - [O que é](#o-que-é)
  - [Equipe](#equipe)
  - [Repositórios](#repositórios)
  - [Acesso à aplicação](#acesso-à-aplicação)
  - [Configuração do ambiente de desenvolvimento](#configuração-do-ambiente-de-desenvolvimento)
  - [Tecnologias](#tecnologias)
    - [AWS (EC2)](#aws-ec2)
    - [GitHub](#github)
    - [Docker-compose](#docker-compose)
    - [Jest](#jest)
    - [Robot Framework](https://robotframework.org)
    - [MongoDB Atlas](#mongodb-atlas)
    - [Zabbix](#zabbix)
  - [Road Map](#road-map)
  - [Entregas](#entregas)
    - [Sprint 01 – 20/09/2020](#sprint-01--20092020)
    - [Sprint 02 – 04/10/2020](#sprint-02--04102020)
    - [Sprint 03 – 18/10/2020](#sprint-03--18102020)
    - [Sprint 04 – 01/11/2020](#sprint-04--01112020)
    - [Sprint 05 – 15/11/2020](#sprint-05--15112020)
    - [Sprint 06 – 29/11/2020](#sprint-06--29112020)

## O que é

Projeto desenvolvido pelos alunos da FATEC - Professor Jessen Vidal, para a matéria Padrões de Projeto, ministrada pelo Professor Giuliano.
O software é uma iniciativa para aproximar os alunos das necessidades do mercado de trabalho. Consiste em uma aplicação web onde empresas da área de tecnologia propõem desafios, o conteúdo é avaliado pelos professores da Fatec e então enviado para que os alunos proponham soluções.

## Equipe

- [Bruno Akira Ota](https://www.linkedin.com/in/bruno-akira-ota-32a29744/)
- [Carlos Henrique Monteiro Neto](https://www.linkedin.com/in/carlos-henrique-monteiro-neto-b62a0413a)
- [Leticia Macedo Prudente de Carvalho](https://www.linkedin.com/mwlite/in/leticia-macedo-prudente-de-carvalho-a0413416a)
- [Matheus Rocha da Silva](https://www.linkedin.com/in/matheus-rocha-da-silva-b8504a1a5/)
- [Thaís Bitencourt de Meneses](https://www.linkedin.com/in/thaisbitencourt/)
- [Vanessa Bessa Diogenes Castellano](https://www.linkedin.com/in/vanessa-bessa)
- [Yan Rodrigues de Azevedo](https://www.linkedin.com/in/yan-rodrigues)

## Repositórios

Front-end: <https://github.com/mrocha98/antenas-front>

Back-end: <https://github.com/mrocha98/antenas-back>

Teste Automatizado: <https://github.com/Baota2/Antenas_Robot>

Guia do Usuário: <https://github.com/mrocha98/antenas-devops/wiki>

## Acesso à aplicação

Servidor de Desenvolvimento: <http://antenas-front.herokuapp.com/>

Servidor de QA: <http://ec2-3-138-134-237.us-east-2.compute.amazonaws.com/>

Servidor de Produção: <http://ec2-54-226-210-129.compute-1.amazonaws.com>

## Configuração do ambiente de desenvolvimento

- Back-end: <https://github.com/mrocha98/antenas-back#%EF%B8%8F-como-executar-a-aplica%C3%A7%C3%A3o>
- Front-end: <https://github.com/mrocha98/antenas-front#%EF%B8%8F-como-executar-a-aplica%C3%A7%C3%A3o>

## Tecnologias

### AWS (EC2)

Utilizado para hospedar e disponibilizar o software online para o cliente. Escolhemos a plataforma pela popularidade, por conta da escalabilidade de servidores e pela fácil integração com os demais serviços que a empresa oferece.

### GitHub

Aplicação web utilizada para o versionamento e centralização do projeto.

### Docker-compose

Utilizado para criar imagem do mongobd para que a infraestrutura não precise ser configurada. Foi utilizado para que os participantes do projeto não tivessem problemas de compatibilidade de ambiente. 

### Jest

Estrutura de teste de JavaScript, utilizada para fazer testes unitários e garantir que a aplicação está funcionando de acordo com os requisitos do negócio. Foi escolhido por ser open source, não necessitar configuração manual, possuir relatório de código de fácil acesso e pela velocidade, pois roda testes em paralelo.

### Robot Framework

O Robot Framework é uma estrutura genérica de automação de teste para testes de aceitação e desenvolvimento orientado a testes de aceitação. É uma estrutura de teste orientada por palavras-chave que usa a sintaxe tabular dos dados de teste.

### MongoDB Atlas

Banco de dados em nuvem para MongoDB. A ferramenta foi escolhida por estar disponível via web e porque a infraestrutura, manutenção das máquinas e segurança não precisam de configuração manual.

### Zabbix

Uma ferramenta de software de monitoramento de código aberto para diversos componentes de TI, incluindo redes, servidores, máquinas virtuais e serviços em nuvem. O Zabbix fornece métricas de monitoramento, entre outras, utilização da rede, carga da CPU e consumo de espaço em disco.

## Road Map

![ilustração do road map](.github/images/roadmap.jpeg)

## Entregas

### Sprint 01 – 20/09/2020

- Deploy do Frontend e Backend: disponibilizar aplicação em ambiente remoto na [AWS EC2](https://aws.amazon.com/ec2/?ec2-whats-new.sort-by=item.additionalFields.postDateTime&ec2-whats-new.sort-order=desc).
- [Configuração do arquivo Docker-compose](https://github.com/mrocha98/antenas-back/blob/master/docker-compose.yml) : integrar MongoDB e NodeJs para utilizar em ambiente de desenvolvimento; e para utilizarmos em desenvolvimento.
- Criação do banco em nuvem:  disponibilizar a base de dados em ambiente remoto, no [MongoDB Atlas](https://www.mongodb.com/cloud/atlas).

### Sprint 02 – 04/10/2020

- Testes unitários: utilizado para verificar a menor parte testável da aplicação, garantindo que o software esteja de acordo com as regras de negócio, minimizando o retrabalho e tornando as correções mais ágeis.
- Integração contínua: fará com que cada alteração passe pelos testes antes de efetivar o commit, trazendo mais segurança e agilidade ao processo de desenvolvimento já que os testes são executados automaticamente.

### Sprint 03 – 18/10/2020

- Divisão de Ambientes: Criação de ambientes isolados para desenvolvimento, testes e produção. Necessário para não impactar o cliente final durante o período de desenvolvimento (de correções e/ou novas funcionalidades) e período de testes. A separação garante à equipe de desenvolvimento liberdade para implementar e explorar sem riscos de impacto no cliente final, à equipe de testes a integridade do ambiente durante a execução dos testes, e ao cliente final uma base de produção limpa e segura, e sem interrupção durante o processo de entrega das funcionalidades.
- Deploy Automático: Processo que controla as alterações enviadas para as branchs alteradas. A aplicação possui 3 ambientes atualmente, desenvolvimento, testes e produção, o deploy automático se encarrega de executar uma bateria de testes pré definida sobre cada commit enviado para a branch antes de permitir que esse seja efetivamente enviado para o respectivo servidor.

### Sprint 04 – 01/11/2020

- Integração da ferramenta de monitoramento Zabbix para gerar logs: A geração de logs é importante para que possamos avaliar o sistema e fazer o monitoramento para que no  caso de o sistema lançar algum erro, seja possível identificar de forma rápida e precisa e assim tratar o problema com uma correção mais acertiva.
- Load Balancer: Distribui o tráfego de entrada do aplicativo por várias instâncias EC2 em diversas Zonas de disponibilidade. Isso aumenta a tolerância a falhas dos aplicativos. O load balancer serve como ponto único de contato para os clientes, isso aumenta a disponibilidade da aplicação. É possível adicionar e remover instâncias do load balancer conforme mudarem as necessidades, sem perturbar o fluxo geral de solicitações para sua aplicação. 

Link para Download do video de apresentação da sprint: https://drive.google.com/file/d/1JPKvS2Xj7bek64HRX7QRtdmJ5I_6jQeS/view?usp=sharing

### Sprint 05 – 15/11/2020

- Testes E2E (end-to-end) automatizado: Testes utilizando Selenium WebDriver e Robot Framework. Esse tipo de teste visa o fluxo completo da aplicação de forma automatizada reduzindo o tempo de execução.

### Sprint 06 – 29/11/2020

- Documentação de funcionalidades para usuários.
- Vídeo de apresentação para a feira de soluções.

