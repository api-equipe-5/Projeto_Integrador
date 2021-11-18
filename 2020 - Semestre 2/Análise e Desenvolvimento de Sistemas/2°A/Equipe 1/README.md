<head>
       <p><img src="https://img.shields.io/badge/status%20do%20projeto-concluído-green?style=for-the-badge&logo=appveyor"></p>
       <p><img src="https://img.shields.io/badge/Sprint%20atual-Projeto%20concluído-green?style=for-the-badge&logo=appveyor"></p>
       <p>
       <img src="https://img.shields.io/badge/dependências-JavaFX%3A%2014.0.2.1-green">
       <img src="https://img.shields.io/badge/dependências-JDK%3A%2014.0.2.1-green">
       <img src="https://img.shields.io/badge/dependências-Hibernate%3A%205.4.21-green">
       <img src="https://img.shields.io/badge/dependências-PostgreSQL%20JDBC%3A%2042.2.16-green">
       </p>
         
</head>
<body>
        <nav>
            <p><h1>RoadTracker :truck::computer:</h1></p>
            <p>Seja bem-vindo ao repositório do RoadTracker!</p>
              <p align="justify">
                     :articulated_lorry: Para instalar o RoadTracker, clique <a href="https://drive.google.com/file/d/1fA-FX0-etznHQP1P7XiAMuUqErzwXtAw/view?usp=sharing">aqui</a>.
              </p>
              <p align="justify">
                     :wink: Precisa de alguma ajuda? Confira o nosso <a href="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/manual_de_uso/Manual%20de%20uso%20RoadTracker.pdf">manual do usuário</a>.
              </p>
            <p><h2>O nosso desafio</h2></p>
            <p align="justify">Nosso cliente é a empresa IACIT. Foi solicitado para nós desenvolvermos um sistema para o gerenciamento e controle da jornada de trabalho de motoristas sendo parametrizável, visando à disponibilização de funcionalidades de planejamento, acompanhamento, controlando a jornada de trabalho de cada um desses colaboradores. Nosso sistema deverá oferecer um cadastro para motoristas (tendo nome, CPF, matrícula e ID do equipamento do caminhão), um cadastro para os dados do veículo (como a placa, a marca e versão do rastreador e o ID do equipamento), a escala dos motoristas (turno, carga horária, dias de trabalho e de folga), um cadastro de alertas (contendo ocorrência, sigla, ícone, descrição do alerta e regra/parâmetro) e um cadastro de status (cadastrar status e regras de negócio de acordo com cada situação ocorrida durante a jornada, ID dos macros/mensagens, status de início e fim de jornada, tempo de trabalho, espera, refeição e descanso).</p>
<ul>
<li><a href="https://github.com/Syank/PI-JornadaDeMotoristas#o-que-%C3%A9-o-roadtracker"> O que é o RoadTracker?</a></li>
<li><a href="https://github.com/Syank/PI-JornadaDeMotoristas#integrantes-da-equipe-girlboy"> Integrantes da equipe</a></li>
       <li><a href="https://github.com/Syank/PI-JornadaDeMotoristas#Branches-de-cada-entrega">Branches de cada entrega</a></li>
<li><a href="https://github.com/Syank/PI-JornadaDeMotoristas#cards-das-sprints-entregas-do-sistema">Cards das Sprints (entregas) do sistema</a></li>
<li><a href="https://github.com/Syank/PI-JornadaDeMotoristas#nosso-sistema-em-funcionamento-at%C3%A9-o-momento">Nosso sistema em funcionamento até o momento</a></li>
<li><a href="https://github.com/Syank/PI-JornadaDeMotoristas#wireframes-do-roadtracker-">Wireframes do RoadTracker</a></li>
</ul>
</nav>
</section>

<section id="o_que_e">
            <h3>O que é o RoadTracker?</h3>
            <p align="justify">Nosso sistema, RoadTracker, tem o objetivo de realizar o controle das jornadas de trabalho de motoristas, pois, muitas vezes, não há o monitoramento e acompanhamento necessário do expediente desses trabalhadores. Todas as filiais de uma empresa devem ser cadastradas, assim como seus motoristas e suas respectivas jornadas de trabalho, viagens a serem realizadas e o veículo que será utilizado em cada uma dessas viagens. Além disso, a filial terá acesso a várias informações sobre o status do motorista durante a viagem!</p>
               
</section>

<section id="integrantes">
            <h3>Integrantes da equipe :girl::boy:</h3>
       <ul>
            <li><p><a href="https://www.linkedin.com/in/rafael-furtado-613a9712a/" target = "_blank">Rafael Furtado Rodrigues dos Santos</a>  (<i>Scrum Master</i>)</p>
            <li><p><a href="https://www.linkedin.com/in/b%C3%A1rbara-port-402158198/" target = "_blank">Bárbara dos Santos Port</a> (<i>Product Owner</i>)</p>
            <li><p><a href="https://www.linkedin.com/in/ana-clara-godoy-2973381b2/" target = "_blank">Ana Clara Ferreira de Godoy</a> (<i>Development Team</i>)</p>
            <li><p><a href="https://www.linkedin.com/in/giovanni-santos-546412154/" target = "_blank">Giovanni dos Santos Alves</a> (<i>Development Team</i>)</p>
            <li><p><a href="https://www.linkedin.com/in/ana-carolina-lima-099955136/" target = "_blank">Ana Carolina da Silva Lima</a> (<i>Development Team</i>)</p>
            <li><p><a href="https://www.linkedin.com/in/anna-yukimi-yamada-6ba23b149/" target = "_blank">Anna Yukimi Yamada</a> (<i>Development Team</i>)</p>
       </ul>
</section>
<section id="branches_entregas">
       <h3><i>Branches</i> de cada entrega</h3>
       <table>
              <thead>
                     <th width=100px>Entregas</th>
                     <th>Descrições</th>
                     <th width=215px>Datas</th>
                     <th>Links</th>
              </thead>
              <tbody>
                     <tr>
                            <td>Entrega 1</td>
                            <td>CRUD do administrador envolvendo os funcionários das filiais.</td>
                            <td>07/09/2020 a 27/09/2020</td>
                            <td><a href="https://github.com/Syank/PI-JornadaDeMotoristas/tree/sprint_0">Visualizar</td>
                     </tr>
                     <tr>
                            <td>Entrega 2</td>
                            <td>CRUD do administrador englobando filiais, veículos e viagens. Leitura de avisos por parte dos supervisores e administradores.</td>
                            <td>28/09/2020 a 18/10/2020</td>
                            <td><a href="https://github.com/Syank/PI-JornadaDeMotoristas/tree/sprint_1">Visualizar</td>
                     </tr>
                     <tr>
                            <td>Entrega 3</td>
                            <td>O motorista poderá inserir dados sobre a viagem e o supervisor poderá visualizar e alterar dados dos motoristas.</td>
                            <td>19/10/2020 a 08/11/2020</td>
                            <td><a href="https://github.com/Syank/PI-JornadaDeMotoristas/tree/sprint_2">Visualizar</a></td>
                     </tr>
                      <tr>
                            <td>Entrega 4</td>
                            <td>O supervisor poderá visualizar e alterar dados dos veículos e viagens. Todos os usuários poderão recuperar suas senhas.</td>
                            <td>09/11/2020 a 29/11/2020</td>
                            <td><a href="https://github.com/Syank/PI-JornadaDeMotoristas/tree/sprint_3">Visualizar</td>
                     </tr>
              </tbody>
       </table>
       <h4><a href="https://docs.google.com/spreadsheets/d/1HuQ9GrWlmToOBW_bJGg-9X_d5m0Zey0G/edit#gid=1949042978">Visualizar <i>burndown</i> de cada sprint</a></h4>
</section>

<section id="cards">
       <h3><i>Cards</i> das <i>sprints</i> (entregas) do sistema</h3>
       <h4>Primeira entrega :clock12:</h4>
       <p align="justify">Os funcionários são os principais agentes do sistema. Dentre eles destaca-se o motorista. Sendo assim, vimos a oportunidade de impressionar aqueles que estivessem utilizando o sistema para administrar as informações da empresa e dos funcionários. Por isso, oferecemos uma interface intuitiva que permite ao administrador organizar as informações dos funcionários de cada filial em um único local, disponibilizar os dados destes para o melhor conhecimento e o controle das atividades de cada colaborador presente. O usuário administrador é capaz de atualizar essas informações a qualquer momento de forma dinâmica e simplificada. Quantidade de <i>story cards</i> restantes: 31.</p>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/Cards/card1.png" width=550px height=300px>
       <h4>Segunda entrega :clock4:</h4>
       <p align="justify">O projeto pode ser basicamente separado em três partes, de acordo com os perfis de acesso: motorista, supervisor e administrador. Como a entrega anterior focava no perfil do administrador, optamos, para a sprint 1, por finalizar todas as funcionalidades deste perfil. Sendo assim, o usuário já pode ter uma experiência de uso mais concreta do nosso sistema, podendo cadastrar todas as entidades, acessar as informações de outros usuários, editá-las ou apagá-las, se assim desejar. As funcionalidades do administrador são a base para as atividades do supervisor e do motorista. Devido a isso, é necessário concluir todas as deste usuário primeiro, pois sem um ele não há filial, sem filial não é possível cadastrar veículos e outros funcionários, sem funcionários não há viagens, e assim por diante. Para que as próximas entregas sejam coesas, é preciso que já existam os cadastros das entidades que são imprescindíveis na realização de uma viagem. Quantidade de <i>story cards</i> restantes: 16.</p>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/Cards/card2.png" width=550px height=300px>
       <h4>Terceira entrega :clock8:</h4>
       <p align="justify">Com toda a parte fundamental para a criação de uma viagem finalizada, é hora de implementar a principal parte do sistema: a inserção do status da viagem através do motorista. Este poderá informar os status da sua jornada de trabalho, definir o momento em que ele deu início à viagem, o horário que parou para almoçar, descansar ou abastecer, assim como quando retornou desta pausa e quando concluiu sua viagem. Como o motorista terá boa parte das suas funcionalidades nesta entrega, serão criadas também, as atividades de um novo tipo de usuário: o supervisor. Adicionaremos o básico das suas funcionalidades com o intuito de facilitar o acesso aos dados, caso algum administrador esteja ausente. Desta forma, o sistema englobará boa parte do processo de gerenciamento e acompanhamento das jornadas.</p>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/Cards/card3.png" width=550px height=300px>
       <h4>Quarta entrega :clock12:</h4>
       <p align="justify">Todas as funcionalidades do supervisor estarão presentes no sistema, proporcionando uma melhor experiência para os três níveis de acesso. Caso um administrador não possa resolver algo no momento, um supervisor poderá solicitar o cadastro (caso seja necessário) ou ele mesmo poderá alterar os dados sobre viagens e motoristas presentes no sistema. Como forma de manter o acesso de todos os usuários ao sistema, todos poderão recuperar suas senhas através da interface, sem depender de cargos superiores para realizar esse tipo de alteração. Desta forma todo o nosso sistema estará consolidado em todas as partes. Além disso, serão feitos ajustes finais para melhorar ainda mais a experiência do usuário.</p>
       <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/Cards/card4.png" width=550px height=300px>
</section>
    
<section id="sistema_ate_o_momento">
        <h3>Nosso sistema em funcionamento</h3>
       
<div>
       <h4>Tela de login e recuperação de senha</h4>
<img align="left" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/apresentacao_entrega_4/GIFS%20entrega%20final/GIF%20Senha.gif" width="400"/>

<p align="justify">Ao realizar o login, o sistema automaticamente detectará o tipo de conta do usuário e o redirecionará para o seu nível de acesso.
</p>
<p align="justify">Caso não se lembre da senha, o usuário poderá alterá-la, clicando em <i>"Esqueceu sua senha? Clique aqui"</i>.
</p>
<p align="justify">Para a alteração, é necessário fornecer os dados da conta em questão e, caso os dados estejam corretos, a senha será trocada, podendo ser utilizada no mesmo momento.
</p>
</div>

<div>
       <h4 align="right">Perfil de administradores</h4>
<img align="right" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/apresentacao_entrega_4/GIFS%20entrega%20final/GIF%20Administrador.gif" width="400"/>

<p align="justify">Administradores têm todo acesso ao sistema e ao banco de dados, podendo criar, alterar ou excluir qualquer entidade.
</p>
<p align="justify">Somente para eles é disponibilizada a funcionalidade de visualizar o registro de atividades que todos os usuários geram ao utilizar o sistema.
</p>
<p align="justify">Com isso, também podem, em seu perfil, solicitar ao <i>software</i> que gere um arquivo PDF com esses dados de auditoria, podendo inclusive escolher quais dados constem nele.
</p>
</div>
</br></br>
<div>
       <h4>Perfil dos supervisores</h4>
<img align="left" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/apresentacao_entrega_4/GIFS%20entrega%20final/GIF%20Supervisor.gif" width="400"/>

<p align="justify">Supervisores tem acesso à lista de motoristas, de veículos e de viagens cadastrados no sistema. Dentre esses, pode modificar os dados apenas dos dois primeiros.
</p>
<p align="justify">Eles podem solicitar o cadastro, aos administradores, de novos motoristas no sistema.
</p>
<p align="justify">Para este perfil também conta a funcionalidade de visualização de avisos, em que podem visualizar os que estão no sistema e ter uma noção maior de como as viagens e funcionários se encontram.
</p>
</div>

<div>
       <h4 align="right">Perfil dos motoristas</h4>
<img align="right" src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/apresentacao_entrega_4/GIFS%20entrega%20final/GIF%20Motorista.gif" width="400"/>

<p align="justify">Ao entrar com uma conta de motorista, o usuário logo notará a tela inicial, onde são exibidas as informações da viagem atual e os controles para regular seus tempos.
</p>
<p align="justify">O motorista tem acesso a uma lista que contém todas as viagens que foram atribuídas a ele, podendo iniciá-las ou pausá-las.
</p>
<p align="justify">Caso surja alguma complicação durante seu trabalho, ele poderá emitir avisos ao sistema, que serão visíveis aos administradores e supervisores, cabendo a eles a responsabilidade de auxiliar o funcionário.
</p>
</div>
</br>
<p align="justify">
       Para fins de auditoria, todas as atividades que qualquer usuário realiza no sistema ou dados das entidades são armazenadas no banco de dados e podem ser acessadas somente pelos administradores. Sendo assim, eles podem solicitar arquivos que contenham essas todas essas informações, que são ajustáveis de acordo com suas necessidades.
</p>       

</section>
<section id="Wireframes">
    <h3>Wireframes do RoadTracker </h3>
        <p>
    <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/wireframes/login.jpeg" width="400px">
    <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/wireframes/Administrador/gerar_relatorio.bmp" width="400px" >
       </p>
        <p>
               <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/wireframes/Motorista/viagem_atual.png" width="400px">
               <img src="https://github.com/Syank/PI-JornadaDeMotoristas/blob/master/doc/wireframes/Supervisor/inicio_sup.png" width="400px">
       </p>
       <h4><a href="https://github.com/Syank/PI-JornadaDeMotoristas/tree/master/doc/wireframes">Visualizar todos os <i>wireframes</i> do sistema</a></h4>
 </section>
