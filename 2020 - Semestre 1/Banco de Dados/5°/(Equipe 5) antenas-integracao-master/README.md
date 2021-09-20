# Laboratório de Projeto de Banco de Dados

Este repositório é utilizado para mostrar as entregas para a disciplina de Laboratório de Projeto de Bando de Dados onde iremos implementar um conjunto de melhores práticas de desenvolvimento de software (Dev) e operações de TI (Ops) que é comumente chamado DevOps.  

### Alunos
- [Cristiano Gregio](https://gitlab.com/cristiano.gregio)
- [Kleber Rogério do Nascimento](https://github.com/kleberrogerio)
- [Maria Giovana Silva Realino](https://gitlab.com/mariagiovana)

### Professor
- [Eduardo Sakaue](https://github.com/esakaue)


## O que é o Antenas
- Antenas é um projeto em fase de desenvolvimento pelos alunos da FATEC - Professor Jessen Vidal, para conectar empresas em busca de soluções e alunos que as têm. Deste modo, tende também à possibilitar contratações de acordo com cada projeto e o aluno que o desenvolveu.
- Este projeto é destinado à facilitar o acesso de soluções da seguinte maneira: primeiro, o empresário cadastra o seu projeto dentro do seu painel, na plataforma. Após isto, o peojeto é enviado ao [CADI](https://fatecsjc-prd.azurewebsites.net/cadi.php) (Centro de Apoio ao Desenvolvimento e Inovação) que tem por objetivo solicitar mais informações e completar todos os dados do projeto, envia-lo ao professor que destinará cada um à um aluno ou um grupo. 


### Qual o objetivo do Antenas
- O Antenas tem por objetivo aproximar o aluno do mercado de trabalho, uma vez que cada projeto não é apenas didático, mas destinado a um cliente real.
- A imagem abaixo ilustra o que como é fluxo e o papel de cada de profissional em cada etapa dentro da plataforma CADI.

<img align="middle" src="/imagens/ETAPAS_ANTENAS.png">

## Entregas

O código-fonte da aplicação foi desenvolvido por outros alunos por meio de interdisciplinas. Para esta disciplina, nós iremos realizar as entregas abaixo: 

|   | Entregas                             |                                  Resultado                                         |
|---|--------------------------------------|------------------------------------------------------------------------------------|
| 1 | Deploy da Aplicação                  |O **deploy da aplicação Antenas** pode ser acessado em: http://165.227.80.192:8081/ |
| 2 | Utilização do Docker                 |Verificar o arquivo .gitlab-ci.yml onde a instalação do app é implementacação.      |
| 3 | Instalação do Mongo                  |Verificar o arquivo .gitlab-ci.yml onde o mongo é instalado usando Docker.          |
| 4 | Dividir ambientes: Dev, Stage e Prod |O projeto foi dividido em dev, staging e master(prod). Ver a Wiki para mais detalhes|
| 5 | Integração com Jenkins               |O **Jenkins** da aplicação Antenas pode ser acessado em: http://165.227.80.192:8080/|
| 6 | Automoção do MongoDB                 |Verificar o arquivo .gitlab-ci.yml. Conectar no banco e ver as tabelas populadas.   |


- Nossas atividades são gerenciadas pelo **Trello**. Para detalhes, acesse no board: https://trello.com/b/398kn2c3/lab-proj-banco-de-dados-antenas

- Para conhecer mais sobre nosso trabalho bem como as tecnologias empregadas, visite nossa [Wiki](https://gitlab.com/cristiano.gregio/antenas-integracao-master/-/wikis/Antenas)

- Status dos **Pipelines** de cada ambiente (CI / CD):

    Ambiente de Produção (MASTER) [![pipeline status](https://gitlab.com/cristiano.gregio/antenas-integracao-master/badges/master/pipeline.svg)](https://gitlab.com/cristiano.gregio/antenas-integracao-master/-/commits/master)

    Ambiente de Desenvolvimento (DEV) [![pipeline status](https://gitlab.com/cristiano.gregio/antenas-integracao-master/badges/dev/pipeline.svg)](https://gitlab.com/cristiano.gregio/antenas-integracao-master/-/commits/dev)

    Ambiente de Staging (STAGING) [![pipeline status](https://gitlab.com/cristiano.gregio/antenas-integracao-master/badges/staging/pipeline.svg)](https://gitlab.com/cristiano.gregio/antenas-integracao-master/-/commits/staging)
    
## Video de apresentação

- Nossa video de apresentação: https://youtu.be/RzECzv5cJ0U

</figure>