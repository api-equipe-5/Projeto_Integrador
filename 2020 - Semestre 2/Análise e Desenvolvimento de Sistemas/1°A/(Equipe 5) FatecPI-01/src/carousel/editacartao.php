<?php

    session_start();

    include("conexao.php");

    if(isset($_POST['alterar'])){

        $email = $_SESSION['email'];
        $titulo = $_POST['titulo'];
        $numero = $_POST['numero'];
        $validade = $_POST['validade'];
        $cvv = $_POST['cvv'];
        
      
            $sql = "update cartao set titulo='$titulo', numero='$numero', validade='$validade', cvv='$cvv' where email_usuario = '$email'";

            if ($conexao->query($sql) == true) {
               
                
           
                header("Location: perfiluser.php");
            }
            else{
                header("Location: perfiluser.php");
            }
        
}
else {


        $email = $_SESSION['email'];
        $titulo = $_POST['titulo'];
        $numero = $_POST['numero'];
        $validade = $_POST['validade'];
        $cvv = $_POST['cvv'];
        
      
            $sql = "delete from cartao where email_usuario = '$email'";

            if ($conexao->query($sql) == true) {
               
                
           
                header("Location: perfiluser.php");
            }
            else{
                header("Location: pagboleto.php");
            }

}
?>