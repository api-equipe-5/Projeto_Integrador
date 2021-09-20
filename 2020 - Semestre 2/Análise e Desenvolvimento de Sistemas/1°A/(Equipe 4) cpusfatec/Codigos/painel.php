<?php
session_start();

    if ($_SESSION['id'] == 22){
    $_SESSION['materia'] = 1;
    }
    else if ($_SESSION['id'] == 23){
    $_SESSION['materia'] = 2;
    }
    else if ($_SESSION['id'] == 24){
    $_SESSION['materia'] = 3;
    }
    else if ($_SESSION['id'] == 25){
    $_SESSION['materia'] = 4;
    }
    else if ($_SESSION['id'] == 26){
    $_SESSION['materia'] = 5;
    }
    else if ($_SESSION['id'] == 27){
    $_SESSION['materia'] = 6;
    }

?>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta name="google-site-verification" content="zsq6wdhnN2BIzJ0euw0vvIp2lLjoR3fdOBuX3jIoHYM" />
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    
    <title>CPU | Oficial website</title>
    <link href="img/logo.ico" rel="icon">
    <link href="animate.css" rel="stylesheet">
    <link href="js/css/site.css" rel="stylesheet">

    <script src="jquery-3.4.1.min.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.css" />
    <script src="https://cdn.jsdelivr.net/gh/fancyapps/fancybox@3.5.7/dist/jquery.fancybox.min.js"></script>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="css/bulma.min.css" />
    <link rel="stylesheet" type="text/css" href="css/login.css">

    <link href="estilo2.css" rel="stylesheet">

    <script src="js/dist/wow.min.js"></script>
    <script>
        new WOW().init();
    </script>

</head>

<body id="topo-ir">

    <div id="inv"></div>

    <nav class="topo">

        <label id="giro" for="bt-menu" onclick="nav()">&#9776;</label>

        <a href="#topo-ir"><div class="topo-logo"><img class="loguinho" src="img/logo.png" ></div></a>

        <div id="topo-tudo">

            <div class="topo-textos">


            <?php if($_SESSION['nivel'] == 1){               
               echo '<a href="ediçãoeditor.php">
               <div id="topo7" class="topo-texto" style="background-color:  rgb(25, 42, 95);">Editores</div>
                </a>';
            }
            else if ($_SESSION['nivel'] == 3){
                echo '<a href="materia.php">
                <div id="topo7" class="topo-texto" style="background-color:  rgb(25, 42, 95);">Material</div>
                 </a>';
            }  
            ?>

            <a href="edição.php">
                <div id="topo7" class="topo-texto" style="background-color:  rgb(25, 42, 95);">Dados</div>
            </a>

            <a href="logout.php">
                <div id="topo7" class="topo-texto" style="background-color:  rgb(25, 42, 95);">Sair</div>
            </a>
            </div>

        </div>
    </nav>

    <div id="topo-tudo2">

        <div class="topo-textos">

            <?php if($_SESSION['nivel'] == 1){               
               echo '<a href="ediçãoeditor.php">
               <div id="topo7" class="topo-texto" style="background-color:  rgb(25, 42, 95);">Editores</div>
                </a>';
            }
            else if ($_SESSION['nivel'] == 3){
                echo '<a href="materia.php">
                <div id="topo7" class="topo-texto" style="background-color:  rgb(25, 42, 95);">Material</div>
                 </a>';
            }  
            ?>

            <a href="edição.php">
                <div id="topo7" class="topo-texto" style="background-color:  rgb(25, 42, 95);">Dados</div>
            </a>

            <a href="logout.php">
                <div id="topo3" class="topo-texto" style="background-color:  rgb(25, 42, 95);">Sair</div>
            </a>
        </div>

    </div>


    <div id="containe" style="height: 0px; width: 0px;">

        <div id="bot-titulo" style="display: none;">
            <p>
                <Recent</p> <h4>ChatBot</h4>
        </div>

        <ul id="chats" style="display: none;">
            <li class="chats-left">
                Olá
            </li>

        </ul>
        <div id="input" style="display: none;">
            <input id="testexx" type="text" placeholder="Digite uma mensagem..." />
            <button class="submit-button" id="mens" name="mens">Enviar</button>
        </div>

    </div>
    
    <div id="bot" onclick="bot()"><img class="robo-img" src="img/robo.png" height="50" width="50"></div>

    <div id="hero-image">
        <h1 id="app" class="center__text1 glitch is-glitching" style="margin-top: 40px; top: 40%"></h1>
        <h1 id="app2" class="center__text" style="color: white; top: 60%">
        <?php if($_SESSION['nivel'] == 1){
            echo adm;
        }
        else if ($_SESSION['nivel'] == 2){
             echo aluno;
        }
        else if ($_SESSION['nivel'] == 3){
            echo editor;
        }  
        ?>
        </h1>
    </div>

    <?php   
        if ($_SESSION['nivel'] == 2){
            echo '<div id="trabalhos-ir-v"></div>
            <div id="trabalhos-ir" style="overflow: hidden;">
            <div class="trabalhos-titulo">MATÉRIAS</div>
    
            <div class="conteiner">';
    
               echo '<div class="wow fadeIn card" data-wow-duration="1.5s" data-wow-delay="0.2s" style="float: left">
                    <div class="zoom">
                        <a data-fancybox="gallery1" href="img/ming.jpg">
                            <img src="img/ing.jpg" class="img-responsive" height="300px" width="499">
                        </a>
                    </div>
    
                    <div class="wow fadeIn card-body" data-wow-duration="1.5s" data-wow-delay="0.3s">
                        <h5 class="card-title">Inglês</h5>';

                        if ($_SESSION['ing'] == 1){
                            echo '<form onclick="ing()" action="controle.php" method="POST">
                            <script src="https://www.mercadopago.com.br/integrations/v1/web-tokenize-checkout.js" 
                            data-public-key="TEST-24ed4197-3717-4e67-b5a9-f59bb8855a25" 
                            data-transaction-amount="69.90"
                            data-button-label="COMPRAR">
                            </script></form></div>
                            </div>';
                        }else{
                            echo '<button class="btn btn-primary" onclick="ing2()" type="button" style="width:100%">ENVIAR</button></div>
                            </div>';
                        }
            
                        
            echo '<div class="wow fadeIn card" data-wow-duration="1.5s" data-wow-delay="0.2s" style="float: right">
                    <div class="zoom">
                        <a data-fancybox="gallery2" href="img/mmat.jpg">
                            <img src="img/mat.jpg" class="img-responsive" height="300px" width="499">
                        </a>
                    </div>
    
                    <div class="wow fadeIn card-body" data-wow-duration="1.5s" data-wow-delay="0.3s">
                        <h5 class="card-title">Matemática</h5>';

                        if ($_SESSION['mat'] == 1){
                            echo '<form onclick="mat()" action="controle.php" method="POST">
                            <script src="https://www.mercadopago.com.br/integrations/v1/web-tokenize-checkout.js" 
                            data-public-key="TEST-24ed4197-3717-4e67-b5a9-f59bb8855a25" 
                            data-transaction-amount="79.90"
                            data-button-label="COMPRAR">
                            </script></form></div>
                            </div>';
                        }else{
                            echo '<button class="btn btn-primary" onclick="mat2()" type="button" style="width:100%">ENVIAR</button></div>
                            </div>';
                        }         
                                
                   
            echo '<div class="wow fadeIn card" data-wow-duration="1.5s" data-wow-delay="0.2s" style="float: left">
                    <div class="zoom">
                        <a data-fancybox="gallery3" href="img/mhar.jpg">
                            <img src="img/hard.jpg" class="img-responsive" height="300px" width="499">
                        </a>
                    </div>
    
                    <div class="wow fadeIn card-body" data-wow-duration="1.5s" data-wow-delay="0.3s">
                        <h5 class="card-title">Hardware</h5>';

                        if ($_SESSION['har'] == 1){
                            echo '<form onclick="har()" action="controle.php" method="POST">
                            <script src="https://www.mercadopago.com.br/integrations/v1/web-tokenize-checkout.js" 
                            data-public-key="TEST-24ed4197-3717-4e67-b5a9-f59bb8855a25" 
                            data-transaction-amount="79.90"
                            data-button-label="COMPRAR">
                            </script></form></div>
                            </div>';
                        }else{
                            echo '<button class="btn btn-primary" onclick="har2()" type="button" style="width:100%">ENVIAR</button></div>
                            </div>';
                        }   


            echo '<div class="wow fadeIn card" data-wow-duration="1.5s" data-wow-delay="0.2s" style="float: right">
                    <div class="zoom">
                        <a data-fancybox="gallery4" href="img/marq.jpg">
                            <img src="img/aoc.jpg" class="img-responsive" height="300px" width="499">
                        </a>
                    </div>
    
                    <div class="wow fadeIn card-body" data-wow-duration="1.5s" data-wow-delay="0.3s">
                        <h5 class="card-title">Arquitetura e organização de computadores</h5>';

                        if ($_SESSION['aoc'] == 1){
                            echo '<form onclick="aoc()" action="controle.php" method="POST">
                            <script src="https://www.mercadopago.com.br/integrations/v1/web-tokenize-checkout.js" 
                            data-public-key="TEST-24ed4197-3717-4e67-b5a9-f59bb8855a25" 
                            data-transaction-amount="89.90"
                            data-button-label="COMPRAR">
                            </script></form></div>
                            </div>';
                        }else{
                            echo '<button class="btn btn-primary" onclick="aoc2()" type="button" style="width:100%">ENVIAR</button></div>
                            </div>';
                        } 


                    echo '</div>
    
    
            </div>
    
            <div id="mais-add" style="display: none;">
    
            <div class="conteiner">
    
                <div class="wow fadeIn card" data-wow-duration="1.5s" style="float: left">
                    <div class="zoom">
                        <a data-fancybox="gallery5" href="img/mpor.jpg">
                            <img src="img/por.jpg" class="img-responsive" height="300px" width="499">
                        </a>
                    </div>
    
                    <div class="wow fadeIn card-body" data-wow-duration="1.5s" data-wow-delay="0.3s">
                        <h5 class="card-title">Português</h5>';

                        if ($_SESSION['por'] == 1){
                            echo '<form onclick="por()" action="controle.php" method="POST">
                            <script src="https://www.mercadopago.com.br/integrations/v1/web-tokenize-checkout.js" 
                            data-public-key="TEST-24ed4197-3717-4e67-b5a9-f59bb8855a25" 
                            data-transaction-amount="69.90"
                            data-button-label="COMPRAR">
                            
                            </script></form>';
                        }else{
                            echo '<button class="btn btn-primary" onclick="por2()" type="button" style="width:100%">ENVIAR</button>';
                        } 

                    echo '</div>
                </div>
    
                <div class="wow fadeIn card" data-wow-duration="1.5s" style="float: right">
                    <div class="zoom">
                        <a data-fancybox="gallery6" href="img/mlog.jpg">
                            <img src="img/pro.jpg" class="img-responsive" height="300px" width="499">
                        </a>
                    </div>
    
                    <div class="wow fadeIn card-body" data-wow-duration="1.5s" data-wow-delay="0.3s">
                        <h5 class="card-title">Lógica de programação</h5>';

                        if ($_SESSION['pro'] == 1){
                            echo '<form onclick="pro()" action="controle.php" method="POST">
                            <script src="https://www.mercadopago.com.br/integrations/v1/web-tokenize-checkout.js" 
                            data-public-key="TEST-24ed4197-3717-4e67-b5a9-f59bb8855a25" 
                            data-transaction-amount="89.90"
                            data-button-label="COMPRAR">
                            
                            </script></form>';
                        }else{
                            echo '<button class="btn btn-primary" onclick="pro2()" type="button" style="width:100%">ENVIAR</button>';
                        }

                    echo '</div>
                </div>
    
            </div>
            </div>
    
    
            <div id="mais" onclick="mais()">+</div>';
    }
    ?>
    <script>
        function ing(){
            $.ajax({url:"teste2.php?nome=a",success:function(result)
            {
            }
            })
        };
        function ing2(){
            $.ajax({url:"teste3.php?nome=a",success:function(result)
            {
                if(result != ""){
                    window.location.replace("materia.php");
                }
            }
            })
        };

        function mat(){
            $.ajax({url:"teste3.php?nome=b",success:function(result)
            {
            }
            })
        };
        function mat2(){
            $.ajax({url:"teste3.php?nome=b",success:function(result)
            {
                if(result != ""){
                    window.location.replace("materia.php");
                }
            }
            })
        };

        function har(){
            $.ajax({url:"teste2.php?nome=c",success:function(result)
            {
            }
            })
        };
        function har2(){
            $.ajax({url:"teste3.php?nome=c",success:function(result)
            {
                if(result != ""){
                    window.location.replace("materia.php");
                }
            }
            })
        };

        function aoc(){
            $.ajax({url:"teste2.php?nome=d",success:function(result)
            {
            }
            })
        };
        function aoc2(){
            $.ajax({url:"teste3.php?nome=d",success:function(result)
            {
                if(result != ""){
                    window.location.replace("materia.php");
                }
            }
            })
        };

        function por(){
            $.ajax({url:"teste2.php?nome=e",success:function(result)
            {
            }
            })
        };
        function por2(){
            $.ajax({url:"teste3.php?nome=e",success:function(result)
            {
                if(result != ""){
                    window.location.replace("materia.php");
                }
            }
            })
        };

        function pro(){
            $.ajax({url:"teste2.php?nome=f",success:function(result)
            {
            }
            })
        };
        function pro2(){
            $.ajax({url:"teste3.php?nome=f",success:function(result)
            {
                if(result != ""){
                    window.location.replace("materia.php");
                }
            }
            })
        };
    </script>

    <!--Slide no site-->
    <script>
        $(function() {
            $('.topo-texto').click(function() {
                $('.topo-texto-sel').removeClass('topo-texto-sel');
                $(this).addClass('topo-texto-sel');
            });
        });

        var $doc = $('html, body');
        $('a').click(function() {
            $doc.animate({
                scrollTop: $($.attr(this, 'href')).offset().top
            }, 500);
            return false;
        });
    </script>

    <!--Escrever automatico-->
    <script src="escrever.js"></script>
    <script>
        var app = document.getElementById('app');

        var typewriter = new Typewriter(app, {
            loop: true
        });

        typewriter.typeString('ÁREA DO')
            .pauseFor(1000)
            .deleteAll()
            .typeString('ÁREA DO')
            .pauseFor(1000)
            .deleteAll()
            .start();
    </script>

    <!--Bot conf-->
    <script>
        var mande = 0;

        $('#mens').on('click', function() {
            addMessage();
        });

        $(document).on('click', '.response-button', function() {
            var data = $(this).data('hook');
            addMessage(data);
        });

        $(document).on('keydown', function(evt) {
            if (evt.keyCode == 13) {
                addMessage();
            }
        })

        function createMessage(val, side, responses, image) {
            responses = responses || false;
            image = image || false;
            var chatMsg = '<li class="chats-' + side + ' pre">';
            chatMsg += val;

            if (image) {
                chatMsg += '<img src="' + image + '" class="response-image"/>';
            }

            if (responses) {
                for (var i = 0; i < responses.length; i++) {
                    chatMsg += '<button class="response-button" data-hook="' + responses[i] + '">' + responses[i] + '</button>';
                }
            }

            chatMsg += '</li>';
            return chatMsg;
        }

        function clearPre() {
            setTimeout(function() {
                $('.pre').removeClass('pre');
            }, 0);
        }

        function scroll() {
            clearPre();
            $('#chats').stop().animate({
                scrollTop: $('#chats')[0].scrollHeight
            }, 500, function() {

            });
        }

        function addMessage(data) {
            data = data || false;
            var delay = 100;
            var val = $('input').val();
            var testex = document.getElementById('testexx').value;

            testex2 = testex.toLowerCase();

            function removerAcentos(newStringComAcento) {
                var string = newStringComAcento;
                var mapaAcentosHex = {
                    a: /[\xE0-\xE6]/g,
                    e: /[\xE8-\xEB]/g,
                    i: /[\xEC-\xEF]/g,
                    o: /[\xF2-\xF6]/g,
                    u: /[\xF9-\xFC]/g,
                    c: /\xE7/g,
                    n: /\xF1/g
                };

                for (var letra in mapaAcentosHex) {
                    var expressaoRegular = mapaAcentosHex[letra];
                    string = string.replace(expressaoRegular, letra);
                }

                return string;
            }

            var teste = removerAcentos(testex2);

            if (!data) {

                delay = 1000;
            }

            setTimeout(function() {

                tente = 2;
                responde = 0;

                $('#chats').append(createMessage(testex, 'right'));

                if (teste.indexOf("oi") >= 0) {
                    $('#chats').append(createMessage("Como posso te ajudar?", 'left'));
                    tente = 0;
                    responde = 0;
                }
                if (teste.indexOf("ola") >= 0) {
                    $('#chats').append(createMessage("Como posso te ajudar?", 'left'));
                    tente = 0;
                    responde = 0;
                }
                if (teste.indexOf("ajuda") >= 0) {
                    $('#chats').append(createMessage("Como posso te ajudar?", 'left'));
                    tente = 0;
                    responde = 0;
                }

                if (teste.indexOf("falo") >= 0) {
                    $('#chats').append(createMessage("Entre em contato pelas redes sociais ou mande um email", 'left'));
                    tente = 0;
                    responde = 1;
                }
                if (teste.indexOf("contato") >= 0) {
                    $('#chats').append(createMessage("Entre em contato pelas redes sociais ou mande um email", 'left'));
                    tente = 0;
                    responde = 1;
                }
                if (teste.indexOf("agendo") >= 0) {
                    $('#chats').append(createMessage("Entre em contato pelas redes sociais ou mande um email", 'left'));
                    tente = 0;
                    responde = 1;
                }
                if (teste.indexOf("marco") >= 0) {
                    $('#chats').append(createMessage("Entre em contato pelas redes sociais ou mande um email", 'left'));
                    tente = 0;
                    responde = 1;
                }
                if (teste.indexOf("telefone") >= 0) {
                    $('#chats').append(createMessage("O telefone é 40028922", 'left'));
                    tente = 0;
                    responde = 1;
                }
                if (teste.indexOf("celular") >= 0) {
                    $('#chats').append(createMessage("O celular é 40028922", 'left'));
                    tente = 0;
                    responde = 1;
                }
                if (teste.indexOf("servico") >= 0) {
                    $('#chats').append(createMessage("Fazemos sessões de Gravidas, Recém-Nascidos, Books, Famílas ou Eventos", 'left'));
                    tente = 0;
                    responde = 1;
                }
                if (teste.indexOf("trabalho") >= 0) {
                    $('#chats').append(createMessage("Fazemos sessões de Gravidas, Recém-Nascidos, Books, Famílas ou Eventos", 'left'));
                    tente = 0;
                    responde = 1;
                }
                if (teste.indexOf("preço") >= 0) {
                    $('#chats').append(createMessage("Fazemos sessões de:" + "<br>" + " Gravidas = R$ 100,00" + "<br>" + " Recém-Nascidos = R$ 100,00 " + "<br>" + " Books = R$ 150,00 " + "<br>" + " Famílas = R$100,00 " + "<br>" + " Eventos = R$ 150,00", 'left'));
                    tente = 0;
                    responde = 1;
                }

                if (teste.indexOf("nao") >= 0) {
                    $('#chats').append(createMessage(["Tente outra mensagem"], 'left'));
                    tente = 0;
                    responde = 0;
                    mande += 1;
                }
                if (teste.indexOf("sim") >= 0) {
                    $('#chats').append(createMessage(["Se precisar estou aqui"], 'left'));
                    tente = 0;
                    responde = 0;
                }

                if (responde == 1) {
                    $('#chats').append(createMessage(["Isso responde a sua pergunta?"], 'left'));
                }
                if (tente == 1) {
                    $('#chats').append(createMessage(["Tente outra mensagem"], 'left'));
                    mande += 1;

                    $.ajax({
                        url: "mensagem.php?texto=" + testex,
                        success: function(result) {
                            // $("#salvar_" + ID).html('');
                        }
                    });
                }

                if (tente == 2) {
                    $('#chats').append(createMessage(["Tente outra mensagem"], 'left'));
                    mande += 1;
                }

                if (mande == 3) {
                    $('#chats').append(createMessage(["Caso esteja com dificuldade para tirar suas duvidas, mande um Email"], 'left'));
                    mande = 0;
                }


                tente = 0;
                responde = 0;
                scroll();
            }, delay);

            $('input').val('');
        }

        scroll();
    </script>

    <!--Mapa-->
    <script>
        var num3 = 0;

        function mapa() {
            num3++;
            if (num3 == 1) {
                function AbrirMapa() {

                    var AltMapa = window.innerHeight;
                    var LarMapa = window.innerWidth;

                    if (LarMapa > 880) {

                        AltMapa = 460;
                        LarMapa = 100;
                    } else {

                        AltMapa = 360;
                        LarMapa = 100;
                    }

                    if (num3 == 1) {
                        document.getElementById("mapa").style.height = AltMapa + "px";
                        document.getElementById("mapa").style.width = LarMapa + "%";
                        document.getElementById("x-mapa").style.display = 'block';
                    }
                };

                AbrirMapa();

                window.addEventListener('resize', function() {
                    AbrirMapa();

                });
            } else if (num3 == 2) {
                document.getElementById("mapa").style.height = "0px";
                document.getElementById("mapa").style.width = "0px";
                document.getElementById("x-mapa").style.display = 'none';

                num3 = 0;
            }
        }
    </script>

    <!--Tamanhos bot-->
    <script>
        function MargemContaine() {
            var windowHeight = window.innerHeight;
            var windowWidth = window.innerWidth;

            if (windowWidth > 880) {

                windowHeight -= 80;
                windowWidth -= 100;

                document.getElementById("containe").style.marginTop = windowHeight + "px";
                document.getElementById("containe").style.marginLeft = windowWidth + "px";
            } else {
                windowHeight -= 50;
                windowWidth -= 10;

                document.getElementById("containe").style.marginTop = windowHeight + "px";
                document.getElementById("containe").style.marginLeft = windowWidth + "px";
            }
        };

        MargemContaine();

        window.addEventListener('resize', function() {
            MargemContaine();

        });


        var num1 = 0;

        function bot() {
            num1++;

            if (num1 == 1) {
                function sizeOfThings2() {

                    var windowHeight = window.innerHeight;
                    var windowHeight2 = window.innerHeight;
                    var windowWidth = window.innerWidth;
                    var windowWidth2 = window.innerWidth;

                    if (windowWidth > 880) {

                        windowHeight = 150;
                        windowWidth -= 550;
                        windowWidth2 = 400;
                        windowHeight2 -= 180;

                        if (num1 == 1) {
                            document.getElementById("containe").style.marginTop = windowHeight + "px";
                            document.getElementById("containe").style.marginLeft = windowWidth + "px";
                            document.getElementById("containe").style.width = windowWidth2 + "px";
                            document.getElementById("containe").style.height = windowHeight2 + "px";
                            document.getElementById("containe").style.transitionDuration = "1s";

                            var mapa = document.getElementById('chats').style = 'block';
                            var mapa = document.getElementById('input').style = 'block';
                            var mapa = document.getElementById('bot-titulo').style = 'block';
                        }
                    } else {
                        if (num1 == 1) {
                            windowHeight = 0;
                            windowWidth = 0;
                            windowWidth2 -= 0;
                            windowHeight2 -= 80;
                            document.getElementById("containe").style.marginTop = windowHeight + "px";
                            document.getElementById("containe").style.marginLeft = windowWidth + "px";
                            document.getElementById("containe").style.width = windowWidth2 + "px";
                            document.getElementById("containe").style.height = windowHeight2 + "px";
                            document.getElementById("containe").style.transitionDuration = "1s";

                            var mapa = document.getElementById('chats').style = 'block';
                            var mapa = document.getElementById('input').style = 'block';
                            var mapa = document.getElementById('bot-titulo').style = 'block';
                        }
                    }
                };

                sizeOfThings2();

                window.addEventListener('resize', function() {
                    sizeOfThings2();

                });



                function sizeOfThings3() {

                    var windowHeight = window.innerHeight;
                    var windowHeight2 = window.innerHeight;
                    var windowWidth = window.innerWidth;
                    var windowWidth2 = window.innerWidth;

                    if (windowWidth > 880) {

                        windowWidth2 = 95;
                        windowHeight2 = 95;

                        document.getElementById("chats").style.width = windowWidth2 + "%";
                        document.getElementById("chats").style.height = windowHeight2 + "%";
                    } else {

                        windowWidth2 -= 0;
                        windowHeight2 -= 180;

                        document.getElementById("chats").style.width = windowWidth2 + "px";
                        document.getElementById("chats").style.height = windowHeight2 + "px";
                    }

                };

                sizeOfThings3();

                window.addEventListener('resize', function() {
                    sizeOfThings3();
                });
            } else if (num1 == 2) {

                MargemContaine();

                document.getElementById("containe").style.height = "0px";
                document.getElementById("containe").style.width = "0px";

                num1 = 0;
            }
        }

        function sizeOfThings() {

            var windowHeight = window.innerHeight;
            var windowHeight2 = window.innerHeight;
            var windowWidth = window.innerWidth;
            var windowWidth2 = window.innerWidth;

            if (windowWidth > 880) {

                windowHeight -= 100;
                windowHeight2 -= 200;

                windowWidth -= 140;
                windowWidth2 -= 145;
            } else {
                windowHeight -= 80;
                windowHeight2 -= 160;

                windowWidth -= 60;
                windowWidth2 -= 70;
            }
            document.getElementById("bot").style.marginTop = windowHeight + "px";
            document.getElementById("bot").style.marginLeft = windowWidth + "px";
        };

        sizeOfThings();

        window.addEventListener('resize', function() {
            sizeOfThings();

        });
    </script>

    <!--add trabalho-->
    <script>
        var num = 0;

        function mais() {
            num++;

            function sizeOfThings() {

                var windowWidth = window.innerWidth;

                if (windowWidth >= 1080) {

                    if (num == 1) {
                        var mais = document.getElementById('mais-add').style = 'block';
                        var mais = document.getElementById('trabalhos-ir').style.height = 1060 + "px";
                        var mais = document.getElementById('mais').style.display = 'none';

                    } else if (num == 2) {
                        var mais = document.getElementById('mais').style.display = 'none';
                        var mais = document.getElementById('mais-add').style.height = 500 + "px";
                        var mais = document.getElementById('mais-add2').style = 'block';
                        var mais = document.getElementById('trabalhos-ir').style.height = 1060 + "px";

                    }
                } else if (windowWidth >= 801) {

                    if (num == 1) {
                        var mais = document.getElementById('mais-add').style = 'block';
                        var mais = document.getElementById('trabalhos-ir').style.height = 2060 + "px";
                        var mais = document.getElementById('mais-add').style.height = 1100 + "px";
                        var mais = document.getElementById('mais').style.display = 'none';

                    } else if (num == 2) {
                        var mais = document.getElementById('mais').style.display = 'none';
                        var mais = document.getElementById('mais-add').style.height = 1000 + "px";
                        var mais = document.getElementById('mais-add2').style = 'block';
                        var mais = document.getElementById('mais-add2').style.height = 1100 + "px";
                        var mais = document.getElementById('trabalhos-ir').style.height = 2060 + "px";

                    }

                } else {

                    if (num == 1) {
                        var mais = document.getElementById('mais-add').style = 'block';
                        var mais = document.getElementById('trabalhos-ir').style.height = 1660 + "px";
                        var mais = document.getElementById('mais-add').style.height = 900 + "px";
                        var mais = document.getElementById('mais').style.display = 'none';

                    } else if (num == 2) {
                        var mais = document.getElementById('mais').style.display = 'none';
                        var mais = document.getElementById('mais-add').style.height = 800 + "px";
                        var mais = document.getElementById('mais-add2').style = 'block';
                        var mais = document.getElementById('mais-add2').style.height = 950 + "px";
                        var mais = document.getElementById('trabalhos-ir').style.height = 1660 + "px";

                    }
                }
            };

            sizeOfThings();

            window.addEventListener('resize', function() {
                sizeOfThings();

            });



        }
    </script>

    <!--topo movimentações-->
    <script>
        var num4 = 0;

        function nav() {
            num4++;
            if (num4 == 1) {
                var mapa = document.getElementById('topo-tudo2').style.marginTop = '60px';
                document.getElementById("logo-caixa").style.marginTop = "-400px";

                document.getElementById('giro').style.transform = "rotate(90deg)";
                numlog = 0;

            } else if (num4 == 2) {
                var mapa = document.getElementById('topo-tudo2').style.marginTop = '0px';
                document.getElementById('giro').style.transform = "rotate(0deg)";

                num4 = 0;
            }
        }

        numlog = 0;

        function login() {
            numlog++;
            if (numlog == 1) {
                document.getElementById("logo-caixa").style.marginTop = "0px";
                document.getElementById('topo-tudo2').style.marginTop = '0px';
                document.getElementById('giro').style.transform = "rotate(0deg)";
                num4 = 0;
            } else if (numlog == 2) {
                document.getElementById("logo-caixa").style.marginTop = "-400px";

                numlog = 0;
            }
        }

    </script>

    <!--Background ajustavel-->
    <script>
        function back() {

            var windowHeight = window.innerHeight;
            var windowHeight2 = window.innerHeight;
            var windowHeight3 = window.innerHeight;
            var windowWidth = window.innerWidth;

            windowHeight2 -= 300;
            windowHeight3 -= 400;


            document.getElementById("app").style.marginBottom = windowHeight2 + "px";
            document.getElementById("app2").style.marginBottom = windowHeight3 + "px";


            if (windowWidth > 880) {
                document.getElementById("hero-image").style.height = windowHeight + "px";
            } else {
                document.getElementById("hero-image").style.height = "580px";
            }


        };

        back();

        window.addEventListener('resize', function() {
            back();

        });
    </script>

</body>

</html>