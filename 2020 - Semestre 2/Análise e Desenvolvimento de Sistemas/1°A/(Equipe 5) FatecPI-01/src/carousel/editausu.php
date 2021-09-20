<?php

    session_start();

    include("conexao.php");

        $emailNovo = $_POST['emailNovo'];
        $emailAntigo = $_SESSION['email'];
        $nome = $_POST['nome'];
        $senha = (md5($_POST['senha']));
        $senhaconfirm = (md5($_POST['senhaconfirm']));
        
        if ($senha == $senhaconfirm){
            $sql = "update usuario set email='$emailNovo', nome='$nome', senha='$senha' where email = '$emailAntigo'";

            if ($conexao->query($sql) == true) {
                // se eu troquei o email, vou ter que passar esse e-mail novo para a session também:
                $_SESSION['email'] = $emailNovo;
           
                header("Location: perfiluser.php");
            }
            else{
                header("Location: perfiluser.php");
            }
        }


?>