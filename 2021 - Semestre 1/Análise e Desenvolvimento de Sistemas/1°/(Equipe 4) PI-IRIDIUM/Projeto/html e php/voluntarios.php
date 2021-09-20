<?php
session_start();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Asap:ital,wght@1,600&family=Nunito:ital,wght@1,800&family=Yellowtail&display=swap" rel="stylesheet">
    <link href="css/3style.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="sortcut icon" href="imagens/logo.jpeg" type="image/jpeg"/>
    <title>Voluntarios</title>
</head>
 <!-- Tags para formação do menu fixo, com botões que podem ter o nome alterado dentro das tags<li><a...-->
<body>
    <div class="teo">
        <div class="main">
            <nav style="display: flex; float: center">
                <a href="#"></a>
                <ul>
                    <img src="imagens/logo.jpeg" class="logo1">
                    <header>
                        <li><a href="index.php" class="botao">Home</a></li>
                        <li><a href="participantes.php" class="botao">Participantes</a></li>
                        <li><a href="projetos.php" class="botao">Projetos</a></li>
                        <li><a href="ad-login.php" class="botao">Admin</a></li>
                    </header>
                </ul>        
            </nav>
        </div>
    </div>
    <!--Abaixo titulo-->
    <h2 style="font-weight: 500;">CADASTRO DE VOLUNTARIOS</h2>
    
    
    <?php
    
    if(isset($_SESSION['msg'])){
        echo $_SESSION['msg'];
        unset($_SESSION['msg']);
    }
    ?>

    <!--Tags de caixas de texto para aquisição de informações-->
    
    <div>
        <form method="POST" action="processa.php">
            <fieldset id="mensagem">
                <p>Tipo de Voluntário:<input type="text" name="vvoluntario" id="cNome" size="50" maxlength="70" placeholder="Ex: dar aulas, monitoria, atividades recreativas, dentre outros"/></p>
                <p>Nome:<input type="text" name="vnome" id="cNome" size="50" maxlength="70" placeholder="Nome Completo"/></p>
                <p>CPF:<input type="text" name="vcpf" id="ccpf" size="50" maxlength="70" placeholder="EX: 54362474214"/></p>
                <p>Email de contato:<input type="text" name="vemail" id="cMail" size="50" maxlength="70" placeholder="Example@gmail.com"/></p>
                <p>Como pretende contribuir para a ONG? (Especificar resumidamente se será em sua área de formação acadêmica, prestação de serviços gerais, etc)<input type="text" name="vcontribuicao" id="cNome" size="100" maxlength="75" placeholder="Resumo das intenções do voluntario"/></p>        
                <input type="submit" value="Enviar" id="tEnviar" onclick="Enviar">
            </fieldset>
        </form>
    </div>

    <div style="padding-top: 1%;">
        <div class="redesSociais" align="center">
            <a href="https://www.instagram.com/"><img src="imagens/instagram-logo.png" class="logo" width="50" height="50"></a>
            <a href="https://www.facebook.com/"><img src="imagens/face-logo.png" class="logo" width="50" height="50"></a>
        </div>

        <div>
            <section id="contato">
                <p>Horário de funcionamento: de Segunda a Sexta, das 7:00h às 17:00h</p>
                <img src="imagens/mail.png">
                <p>E-mail: <a href=mailto:iridium@gmail.com>iridium@gmail.com</a></p>
                <img src="imagens/tel.png">
                <p>Contato: <a href=mailto:(12)12345-6789>(12) 12345-6789</a></p>
            </section>
        </div>
    </div>

    <span id="conteudo"></span>
    <script>
        $(document).ready(function () {
            $.post('voluntarios.php', function(retorna){
                $("conteudo").html(retorna);
            });
        });
    </script>

</body>
</html>