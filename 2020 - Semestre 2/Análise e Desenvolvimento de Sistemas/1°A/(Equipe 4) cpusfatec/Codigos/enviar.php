<?php
    $email = $_GET["email"];
    $mensagem = $_GET["mensagem"];
    $nome = $_GET["nome"];

    $mensagemResposta = "
    <html>

    <head>
        <style>
            .msg {
                font-size: 30px;
                text-align: center;
                background-color: #183d68;
                width: 500px;
                height: 100px;
                color: white;
                margin: 0 auto;
                padding-top: 1px;
                font-family: Verdana, Geneva, Tahoma, sans-serif;
            }
    
            .msg2 {
                font-size: 17px;
                background-color: white;
                width: 439px;
                height: 120px;
                margin: 0 auto;
                padding-top: 9px;
                border-right: solid 0.5px black;
                border-left: solid 0.5px black;
                border-bottom: solid 0.5px black;
                padding-left: 30px;
                padding-right: 30px;
                text-align: center;
            }
    
        </style>
    </head>
    
    <body>
        <div class='msg'>
            <p>Sendreto - informa</p>
        </div>
    
        <div class='msg2'>
            <p>Olá, $nome </p>
            <p>Sua mensagem foi recebida.<br>Em breve responderemos.</p>
        </div>

    </body>
    
    </html>";

    $mensagemCadastro = "<p>E-mail: $email</p><br> <p>Mensagem: $mensagem</p><br>.";
    //echo($mensagemCadastro); //Serve para escrever no html
    

    $emailsender = "contato@ti-an18.educacao.ws"; //Senha: Senac@123
    $headers = "MIME-Version: 1.1\n";
    $headers .= "Content-type: text/html; charset=utf-8\n";
    $headers .= "From: $emailsender\n";
    $quebra_linha = "\n";
    
    if(!mail($emailsender,"Mensagem", $mensagemCadastro, $headers,"-r".$emailsender)){ 
    }
    if(!mail($email, "Fotografia", $mensagemResposta, $headers ,"-r".$emailsender)){
    }
    if(!mail("criasite9116@gmail.com", "Fotografia", $mensagemCadastro, $headers,"-r".$emailsender)){
    }
?>