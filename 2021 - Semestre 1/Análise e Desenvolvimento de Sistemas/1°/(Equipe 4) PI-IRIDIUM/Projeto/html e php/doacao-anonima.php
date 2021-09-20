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
    <title>Doação anonima</title>

</head>
<body>
<!-- Tags para formação do menu fixo, com botões que podem ter o nome alterado dentro das tags<li><a...-->
<div class="teo">
        <div class="main">
            <nav style="display: flex; float: center">
                <a href="#"></a>
                <ul>
                    <img src="imagens/logo.jpeg" class="logo1">
                    <header>
                        <li><a href="index.php" class="botao">Home</a></li>
                        <li><a href="voluntarios.php" class="botao">Voluntários</a></li>
                        <li><a href="participantes.php" class="botao">Participantes</a></li>
                        <li><a href="projetos.php" class="botao">Projetos</a></li>
                        <li><a href="ad-login.php" class="botao">Admin</a></li>
                    </header>
                </ul>        
            </nav>
        </div>
    </div>

    <div>             
            <table>
                    <tr>
                    <!--abaixo o titulo-->
                        <td><h2>DOAÇÕES ANONIMAS</h2></td> 
                     <!--abaixo a imagem que fica ao lado do titulo-->
                        <td><img style="text-align: center;" width="75" height="75" src='imagens/anonymous.png'/></td>
            
                    </tr>
            </table>
        </div> 

        <?php
        if(isset($_SESSION['msg']))
            echo $_SESSION['msg'];
            unset($_SESSION['msg'])
        ?>

    <form method="POST" action="4processa.php" action="/action_page.php">
        <!--abaixo fieldset que agrupa uma caixa para preenchimento de valor de doação e um botão de enviar-->
        <fieldset id="botoespagamento">

                R$<input type="text" name="tquantity" step="5.0" min="5.0" placeholder="insira o valor a ser doado">
                <input type="submit" value="Enviar"  onclick="Enviar">

                <!--abaixo frase de efeito centralizada, para alterar mude o texto entre as tags <h2>-->
            <h2>Doe e junte-se a nós!</h2>

        </fieldset>

    </form>    

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

</body>

</html>