# Planner
https://docs.google.com/spreadsheets/d/1iBjzTlbTCAl8IbTy4ZK2eDo1gXeKv9yw4qn_5Ui3_EU/edit?ts=5f69525f#gid=0

## Sprint 2 - 04/10/2020

### Implementação de Jenkins 
- Link Jenkins: 34.122.170.162:8080
- Implementação e criação de Job.
- Dashboard com o job criado. Onde podemos visualizar o estado de “saúde” do projeto.

<h1 align="center">
    <img alt="Jenkins" src="/imagem/Jenkins/dashboard.png" />
</h1>

### Gerenciador de logs do servidor 
- Gerenciador de LOG da aplicação.

### Software de monitoramento - Zabbix Grafana
#### Endpoints (Itens monitorados)
- [health] - Mostra informações de integridade do aplicativo (um status' simples quando acessado por uma conexão não autenticada ou detalhes completos da mensagem quando autenticado); não é sensível por padrão
- [info] – Exibe informações arbitrárias do aplicativo; não sensível por padrão
- [auditevents] – lista eventos relacionados à auditoria de segurança, como login/logout do usuário. Além disso, podemos filtrar por principal ou tipo, entre outros campos
- [beans] - r retorna todos os beans disponíveis em nosso BeanFactory. Ao contrário de /auditevents, ele não suporta filtragem
- [conditions] – anteriormente conhecido como/autoconfig, cria um relatório de condições em torno da configuração automática
- [configprops] – nos permite buscar todos os beans _ @ ConfigurationProperties_
- [env] – retorna as propriedades atuais do ambiente. Além disso, podemos recuperar propriedades únicas
- [flyway] – fornece detalhes sobre nossas migrações de banco de dados Flyway
- [heapdump] – constrói e retorna um dump de heap da JVM usada por nosso aplicativo
- [logfile] – retorna logs de aplicativos comuns
- [loggers] – nos permite consultar e modificar o nível de log do nosso aplicativo
- [metrics] – detalha as métricas de nosso aplicativo. Isso pode incluir métricas genéricas e personalizadas
- [prometheu] – retorna métricas como a anterior, mas formatada para funcionar com um servidor Prometheus
- [scheduletasks] – fornece detalhes sobre todas as tarefas agendadas em nosso aplicativo
- [sessions] – lista as sessões HTTP, pois estamos usando o Spring Session
- [shutdown] – executa um desligamento normal do aplicativo */threaddump – despeja as informações de encadeamento da JVM subjacente

    - Examples

<h1 align="center">
    <img alt="Gobarber" src="/imagem/actuator.png" />
</h1>

<h1 align="center">
    <img alt="Gobarber" src="/imagem/env.png" />
</h1>



