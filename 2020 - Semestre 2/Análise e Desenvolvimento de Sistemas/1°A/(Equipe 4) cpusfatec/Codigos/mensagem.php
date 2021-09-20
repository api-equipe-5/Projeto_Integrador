<?php
    $texto = $_GET["texto"];
    
    $mensagem = "Mensagem: $texto";
    //echo($mensagemCadastro); //Serve para escrever no html
    

    $emailsender = "contato@ti-an18.educacao.ws"; //Senha: Senac@123
    $headers = "MIME-Version: 1.1\n";
    $headers .= "Content-type: text/html; charset=utf-8\n";
    $headers .= "From: $emailsender\n";
    $quebra_linha = "\n";
    
    if(!mail( "c.sendreto9116@gmail.com" , "ChatBot Mensagem", $mensagem, $headers ,"-r".$emailsender)){
    }

?>