<p align="center">
  <img src="https://antenas.s3.amazonaws.com/Logo.svg" alt="Logo do Projeto Antenas" />
</p>

<h1 align="center">Projeto Antenas</h1>

<p align="center">
    <a href="#equipe">Equipe</a> •
    <a href="#o-que-é-o-antenas">O que é o Antenas?</a> •
    <a href="#vida-de-um-projeto-no-antenas">Vida de um projeto</a> •
    <a href="#entregas">Entregas</a> •
    <a href="#tecnologia">Tecnologia</a>
</p>

---

## Equipe:
- [Danielly Jardim](https://github.com/daniellygj) _Dev_
- [Fábio Romeiro](https://github.com/FabioRomeiro) _Scrum Master_
- [Giovanna Xavier](https://github.com/giovannaxavierm) _Dev_
- [Mateus Machado](https://github.com/Mateusmsouza) _Dev_ / _DevOps_
- [Thiago Dias](https://github.com/ThiagoDisk) _Dev_ / _DevOps_

## O que é o Antenas?

O Antenas é uma **plataforma online para conectar a FATEC com as empresas do mercado** que desejam realizar projetos e recrutar alunos. Neste site o empresário cadastra seu projeto, e este é enviado para o [CADI (Centro de Apoio ao Desenvolvimento e Inovação)](https://fatecsjc-prd.azurewebsites.net/cadi.php), que o analisa, pede mais informações, e finalmente depois de uma reunião com o empresário, libera o projeto para um professor responsável poder aplica-lo com os seus alunos.

Esta abordagem proporciona ao aluno uma experiência mais próxima do que ele encontrará no mercado de trabalho quando sair da faculdade, uma vez que o projeto não esta sendo aplicado apenas por razões didáticas, mas sim para servir um cliente real.

Para saber mais, acesse o tópico [O que é o Antenas?](https://github.com/antena-dream-team/Antenas/wiki/Conceito#o-que-%C3%A9-o-antenas) na nossa wiki.


## Vida de um projeto no Antenas

<p align="center">
  <img src="https://antenas.s3.amazonaws.com/vida-projeto.svg" alt="Diagrama do fluxo do projeto" />
</p>


## Entregas

#### Entrega 1
- Planejamento da nova arquitetura do sistema
- Configuração inicial da API utilizando Spring Boot
- Configuração inicial e desenvolvimento dos primeiros componentes Vue do Front-end

#### Entrega 2
- Rotas essenciais (CRUD) da API construídas
- Persistencia da API no banco de dados MySQL
- Views da plataforma construídas no Front-end
- Componentes de formulário e gerenciamento de projetos criados no Front-end
- Sass configurado e estilos globais (reset.css, variaveis, funções, mixins, ...) criados no Front-end
- Implementação incial do CI na API utilizando CircleCI

#### Entrega 3
- Serviços de integração desenvolvido no front-end utilizando dados mockados
- CircleCI configurado para avisar membros pelo Telegram caso algum commit com falha nos testes unitários seja subido para o repositório remoto
- Sistema de autenticação utilizando Spring Security implementado

#### Entrega 4
- [Issue#2](https://github.com/antena-dream-team/AntenasClient/issues/2) - Deploy automatizado do front-end
- [Service - Issue#5](https://github.com/antena-dream-team/AntenasService/issues/5) - Deploy automatizado da API

#### Entrega 5
- [Service - Issue#7](https://github.com/antena-dream-team/AntenasService/issues/7) - Resolver bugs apontados no SonarCloud 
- [Service - Issue#8](https://github.com/antena-dream-team/AntenasService/issues/8) - Resolver problemas de login e autenticação
- [Client - Issue#11](https://github.com/antena-dream-team/AntenasClient/issues/11) - Visualização de home para Cadi
- [Client - Issue#9](https://github.com/antena-dream-team/AntenasClient/issues/9) - Visualização de home para Professores
- [Client - Issue#3](https://github.com/antena-dream-team/AntenasClient/issues/3) - Integrar autenticação de usuário com a API
- [Client - Issue#4](https://github.com/antena-dream-team/AntenasClient/issues/4) - Integrar busca de informações de usuário com a API
- [Client - Issue#5](https://github.com/antena-dream-team/AntenasClient/issues/5) - Integrar o cadastro de usuário
- [Client - Issue#6](https://github.com/antena-dream-team/AntenasClient/issues/6) - Integrar a busca de projetos
- [Client - Issue#7](https://github.com/antena-dream-team/AntenasClient/issues/7) - Integrar endpoints de cadastro, edição e deleção de projeto

#### Entrega 6
- [Client - Issue#10](https://github.com/antena-dream-team/AntenasClient/issues/10) - Visualização de home para Alunos
- [Global - Issue#1](https://github.com/antena-dream-team/Antenas/issues/1) - Vídeo de introdução da aplicação


## Tecnologia

Foi optado por separa o projeto em dois grandes módulos:

- **AntenasClient**: Este repositório foi exclusivamente criado para servir a parte do front-end do projeto, isto é, a parte visual e a lógica necessária para apresentar ao usuário todas as informações que ele precisa ter acesso.

- **AntenasService**: Este repositório foi criado para servir a API do antenas, isto é, o local onde os dados entrados no sistema são processados e também a fonte de onde o AntenasClient busca as informações que aparecerão para o usuário final.

Para descobrir como executar o projeto ou explorar o código fonte, visite a página inicial de cada repositório:

- [Front-end (AntenasClient)](https://github.com/antena-dream-team/AntenasClient)
- [API (AntenasService)](https://github.com/antena-dream-team/AntenasService)

**Para conhecer os pré-requisitos, tecnologias utilizadas e motivação para a refatoração geral do Antenas, [visite a nossa wiki](https://github.com/antena-dream-team/Antenas/wiki).**

<p align="center">
  <a href="http://fatecsjc-prd.azurewebsites.net/" target="_blank">
    <img src="https://antenas.s3.amazonaws.com/fatec-logo.png" alt="Logo do Projeto Antenas" width="150" />
  </a>
</p>
