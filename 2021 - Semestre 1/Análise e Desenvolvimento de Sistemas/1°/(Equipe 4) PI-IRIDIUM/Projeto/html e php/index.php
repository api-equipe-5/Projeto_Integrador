<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="sortcut icon" href="imagens/logo.jpeg" type="image/jpeg" />
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Asap:ital,wght@1,600&family=Nunito:ital,wght@1,800&family=Yellowtail&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/carrossel.css">
    <meta chartset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VóMariaFélix</title>
</head>

<body>
<!--Menu, boltões entre tags <li><a-->
    <div class="teo">
        <div class="main">
            <nav style="display: flex; float: rigth">
                <a href="#"></a>
                <ul>
                    <img src="imagens/logo.jpeg" class="logo1">
                    <header>

                        <li><a href="voluntarios.php" class="botao">Voluntários</a></li>
                        <li><a href="participantes.php" class="botao">Participantes</a></li>
                        <li><a href="projetos.php" class="botao">Projetos</a></li>
                        <li><a href="ad-login.php" class="botao">Admin</a></li>
                    </header>
                </ul>        
            </nav>
        </div>
        <!--Frase principal do site, para alterar mudar texto entre tagds <h2>-->
        <div id="frase">
            <h2> Fazer o bem muda o mundo!<br>Ensinar uma criança a amar, só é possível amando-a.</h2>
        </div>
    </div>

    <fieldset style="padding: 30px 50px;">
        <div class="menu">
            <div style="padding: 60px">
                <a href="doacao.php" id="doe" class="botao">Doe aqui</a>
                
                <h3 style="width: 100%; display: flex; float: bottom; height: 70px">Doar  é simples e pode transformar vidas, contribua com qualquer quantia, 
                o que é pouco para você pode ser tudo para essas crianças.</h3>
            </div>
        </div>
        <!--abaixo imagens em movimento, para alterar as imagens coloque a imagem png/jpg na pasta imagens depois altere de acordo com o nome dela o que está entre <img src=>-->
        <div class="carrossel" style="padding: 0px 30px">
            <ul>
                <li> 
                <img src="imagens/atividades2.jpeg" alt="">
                </li>
                <li>
                <img src="imagens/brincadeira.jpeg" alt="">
                </li>
                <li>
                <img src="imagens/atividades.jpeg"alt="" >
                </li>
            </ul>
        </div>
    </fieldset>
    
    <fieldset style="padding: 60px 0px; margin: auto;">    
        

        <!--cada section se refere a uma seção de texto, para modificar os textos aletere o que esta dentro das tags <p></p>-->
        
        <section id="sobre" style="width: 42.2%; display: flex; float: left;">
            <h1>Sobre nós</h1>
            <p>
                A ONG vó Maria Felix tem o intuito de receber crianças de 0 a 7 anos para realização de projetos em busca de enriquecimento em suas vidas. 
                Atualmente fornecemos apoio para 250 crianças, mas estamos em uma constante busca por expansão, para isso precisamos ampliar espaços, mantimentos 
                e verbas. Buscamos colaboração de voluntários. Para ser voluntario ou implementar algum projeto de caráter de assistência, educativo, social, 
                cultural ou que possa contribuir para o bem dessas crianças de alguma forma cadastre-se ou entre em contato conosco! O objetivo da ONG é integrar 
                essas crianças socialmente em novos ambientes e situações, fazendo com que o cotidiano delas seja repleto de experiencias de grande valor.
            </p>
            <div class="botao" style="display: flex; float: left;">
                <a href="ver-mais.HTML" >Ver mais</a>
            </div>
    
        </section>

        <div id="voluntários" style="width: 42.2%">
            <h1>Voluntários</h1>
            <p>
                Quantas pessoas, de maneira voluntária, sem buscar um reconhecimento, fazem algo pelas pessoas carentes ?                                                                                                                                   Pelo simples fato de querer ajudar o próximo, posso afirmar que muitos se doam a esse voluntariado, e garanto que a grande maioria não tenha dinheiro sobrando ou patrocínio para isso. Acredito que ninguém é tão pobre que não possa doar por alguns minutos do seu dia para ajudar uma ONG ou alguém próximo que esteja precisando muito.                                                                                                                                                              Em muitas situações, o simples fato de parar e ouvir uma história de vida, já faz uma grande diferença no seu dia. O voluntariado faz com que sua vida seja mais leve, e você pode estar se perguntando: Mas onde posso ajudar? Com quem posso falar?  
                A ONG vó Maria Felix tem o intuito de receber crianças de 0 a 7 anos para realização de projetos em busca de enriquecimento em suas vidas. 
                Atualmente fornecem apoio para 250 crianças, mas estão em uma constante busca por expansão, para isso precisam ampliar espaços, mantimentos e verbas. 
                Assim, buscando colaboração de voluntários.<br>                                                                                                             Para ser voluntário ou implementar algum projeto de caráter de assistência, educativo, social, cultural ou que possa contribuir para o bem dessas crianças de alguma forma ,deve entrar em contato conosco e seguir a triagem necessária para a realização da doação.                                                                                                                            O objetivo da ONG é integrar essas crianças socialmente em novos ambientes e situações, fazendo com que o cotidiano delas seja repleto de experiencias de grande valor.
                Seja um Voluntário !!!
            </p>
        </div>
       
        <section id="participantes" style="width: 92%; display: flex; float: center">
            <article>
                <h1>História de uma aluna da Vó Maria Felix</h1>
                <p><b>Motivos para uma criança ser participante:</b> O período da primeira infância é muito importante 
                    para o desenvolvimento de uma criança, é essencial que ela seja inserida em atividades que 
                    tragam experiencias positivas e educacionais, assim possibilitando o desenvolvimento de 
                    habilidades sociais, trazendo a compreensão de que ela tem importância em uma sociedade e 
                    pode conquistar coisas boas através de seu esforço e dedicação. A ONG vó Maria Felix busca 
                    proporcionar um ambiente acolhedor e sociável, garantindo que os participantes fiquem longe 
                    da marginalidade e do sentimento de solidão, tendo seu tempo preenchido com aprendizado.
                    As crianças participantes desenvolvem atividades educacionais, esportivas e recreativas, 
                    entre outras modalidades de acordo com os projetos e parcerias da ONG. Elas são monitoradas 
                    por voluntários preparados sendo divididas por faixa etária, seguindo cronogramas para melhor 
                    aproveitamento do tempo incluindo horário de lanche.</p>
                    Relato de ex participate: Ana Souza
                    <p>Eu participei da ONG Vó Maria Felix dos meus 5 anos aos 7, me lembro muito bem de como foi 
                    importante, lá pude aprender muita coisa, tive acesso a um ensino diferenciado, esportes e 
                    outras atividades por meio dos projetos, além do acolhimento e contato com outras crianças. 
                    Graças as experiencia que tive na ONG desde cedo compreendi a importância de me dedicar em tudo 
                    que faço para conquistar meus objetivos e que ter iniciativa pode mudar vidas. Hoje sigo estudando 
                    e fazendo cursos, pretendo prestar vestibular e fazer faculdade de pedagogia. Acredito que a ONG 
                    ajuda muito e pode ajudar ainda mais se conseguir mais voluntários e doações. </p>
            </article>
        </section>
        <!-- abaixo dentro das tags <div><a segue o link da localização no google-->
        <section id="localizacao" style="display: flex; float: bottom">
            <fieldset><img src="imagens/local.png" width="700" height="400"><br><br>
                <div><a href="https://goo.gl/maps/NQ99RbYZg7eiTeck6" class="botao">Localização</a></div>
            </fieldset>
        </section>
        <!--Para alterar os mantenedores troque "Exemplo de tal", dentro das tags <p> pelo nome desejado-->
        <section id="mantenedores">
            <fieldset>
                <div>
                    <h1>Contribuidores:</h1>
                    <p>Exemplo de Tal</p>
                    <p>Exemplo de Tal</p>
                </div>
            </fieldset>
        </section>
        <!--Dentro das tags <a href=" ... é colocado o link das redes sociais-->
        <div class="redesSociais" aling="center">
            <h2>Redes sociais</h2>
            <center>
            <a href="https://www.instagram.com/"><img src="imagens/instagram-logo.png" class="logo" width="50" height="50"></a>
            <a href="https://www.facebook.com/"><img src="imagens/face-logo.png" class="logo" width="50" height="50"></a>
        </div>
    </fieldset>

    <!-- informações de contato da ong-->
    <div>
        <section id="contato">
            <p>Horário de funcionamento: de Segunda a Sexta, das 7:00h às 17:00h</p>
            <img src="imagens/mail.png">
            <p>E-mail: <a href=mailto:iridium@gmail.com>iridium@gmail.com</a></p>
            <img src="imagens/tel.png">
            <p>Contato: <a href=mailto:(12)12345-6789>(12) 12345-6789</a></p>
        </section>
    </div>

</body>
</html>