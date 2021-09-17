# TempVerify :snowflake::fire:
Seja muito bem-vindo ao repositório do TempVerify!

## Como é o TempVerify? :iphone:
<div align="center">
  <img src="https://github.com/cacauisadog/hexagono-fatec/blob/master/images/tela_inicial.png" width="400" hspace="5"/>
  <img src="https://github.com/cacauisadog/hexagono-fatec/blob/master/images/login.png" width="400" hspace="5"/>
  <img src="https://github.com/cacauisadog/hexagono-fatec/blob/master/images/tela_principal.png" width="400" hspace="5"/>
  <img src="https://github.com/cacauisadog/hexagono-fatec/blob/master/images/menu.png" width="400" hspace="5"/>
  <img src="https://github.com/cacauisadog/hexagono-fatec/blob/master/images/perfil_usuario.png" width="400" hspace="5"/>
  <img src="https://github.com/cacauisadog/hexagono-fatec/blob/master/images/notificacao_dentro.png" width="400" hspace="5"/>
  <img src="https://github.com/cacauisadog/hexagono-fatec/blob/master/images/notificacao_fora.png" width="400" hspace="5"/>
</div>

## O TempVerify em funcionamento
Para conferir o TempVerify funcionando você pode clicar [aqui](https://www.youtube.com/watch?v=AYty7aQO1_A&ab_channel=fatecsjc).

## Ferramentas utilizadas :building_construction:

### Firebase 
O Firebase é uma ferramenta de banco de dados não relacional que pode ser acessada na nuvem, é suportada pelas principais plataformas móveis como Android e iOS (ideal para este projeto), permite desenvolvimento em qualquer dispositivo, além de ser uma plataforma gratuita.

É focado em aumentar a base de usuários e gerar maiores benefícios econômicos, através de recursos como o Dynamic Links (permite que o aplicativo seja utilizado por outros usuários), Cloud Messaging (sistema de notificações) e possui uma ferramenta de analytics.

### Flutter
O Flutter, criado pela Google, é um framework que se utiliza da linguagem Dart e possui código aberto. As aplicações geradas com o Flutter conseguem acessar os recursos do dispositivo que estão sendo executadas com maior eficiência, sem ajuda de terceiros como bridges, tal funcionalidade levou o Flutter a se popularizar no cenário mobile.

### NodeMCU
Quanto ao hardware, foi optado pela placa NodeMCU, muito utilizado na área de IoT principalmente em projetos menores que utilizam o chip ESP32, que permite conexão Wi-Fi com microcontroladores através de um SoC com o protocolo TCP/IP.

Apesar de ser mais poderoso que um Arduino, possui poucas GPIO (portas programáveis de entrada e saída de dados), possuindo apenas 4, sendo que 2 são dedicadas à comunicação serial. Ao todo, o dispositivo conta com:
- Conversor Serial
- Regulador de Tensão
- Pinos para I2C
- SPI
- Analógico

### OneSignal
O OneSignal é uma ferramenta web que oferece o envio de notificações push para dispositivos das principais plataformas atuais: Android e iOS. É um serviço inicialmente gratuito, mas que se o usuário precisar de mais algumas funcionalidades será necessário pagamento. As notificações podem ser enviadas somente a um segmento de usuários ou a todos. Também é possível programar o horário que a notificação será enviada (instantaneamente ou daqui a algumas horas, por exemplo). Há outras configurações, como ícones, imagens e prioridade. Além disso o OneSignal envia notificações e as exibe em três estados: com o app totalmente fechado, com o app minimizado e com o app aberto.

## Como o app funciona? 

### Login
O login do TempVerify é feito somente pela conta do Google, pois o gerenciamento e a segurança dos dados são assegurados devido às autenticações do Google. Através do login o app poderá utilizar a foto de perfil do usuário, o nome e sobrenome e o e-mail (que constam na conta do Google).

### Exibição da temperatura e da umidade
A exibição da temperatura e da umidade é feita através de uma API, que está vinculada ao Realtime Database do projeto no Firebase. A página que exibe o banco de dados gera todos os campos e seus valores no formato de um dicionário, que é reorganizado às necessidades do app. Sendo assim os dados são exibidos após conversões realizadas no código do aplicativo.

### Como os dados chegam ao banco de dados
Os dados chegam ao banco de dados através do NodeMCU, o nosso hardware. Sua programação foi feita através da interface do Arduino, portanto, também utiliza C++. A conexão é feita através do link da internet pertencente ao banco de dados do Firebase. A partir desse link as informações do ambiente monitorado são enviadas pelo NodeMCU e utilizadas pelo app.

### Envio de notificações
O envio das notificações é feito através do OneSignal. Para isso é necessário que ele seja configurado no código do aplicativo e, também, no Firebase e no site do OneSignal. Para enviar notificações é necessário logar na conta do OneSignal em que o app está registrado e programar o envio de uma nova mensagem. Após a confirmação a notificação é enviada no horário mencionado nas configurações.

## Equipe
- Cauê Bittencourt (Scrum Master)
- [Bárbara Port](https://www.linkedin.com/in/b%C3%A1rbara-port-402158198) (Development Team)
- Giovanni Santos (Development Team)
- Adriele Martins (Development Team)
- Levi Motta (Development Team)
- Felipe Silva (Development Team)
