<?php
    include("conexao.php");

    if (isset($_POST['ok'])){

        $erro = [];

        $email = mysqli_real_escape_string ($conexao, $_POST['email']);

        if (!filter_var($email,FILTER_VALIDATE_EMAIL)){
            $erro[] = "E-mail inválido."; 
        }

        $sql_code = "SELECT senha FROM usuario WHERE email = '$email'";
        $sql_query = mysqli_query($conexao, $sql_code) or die ('Could not complete the action. :(');
        $dado = $sql_query->fetch_assoc();
        $total = $sql_query->num_rows;

        if ($total == 0) {
            $erro[] = "O e-mail informado não existe no banco de dados.";
        }

        if(count($erro) == 0 && $total >0) { 

            $novasenha = substr(md5(time()), 0, 6);
            $nscriptografada = md5(md5($novasenha));
            
            if(1==1 /*mail($email, "Sua nova senha", "Sua nova senha: ". $novasenha)*/){

                $sql_code = "UPDATE usuario SET senha = '$nscriptografada' WHERE email = '$email'";
                $sql_query = mysqli_query($conexao, $sql_code) or die ('Could not change the password. :(');
            }

        }
    }


?>
<!--<html>
    <head>
        <meta charset="utf-8">
    </head>
    <body>
        <?php 
            if (isset($_POST['ok'])){
                if(count($erro) > 0) {
                    foreach($erro as $msg){
                        echo "<p>$msg</p>";
                    }
                }
            }
        ?>
        <form method="POST" action="">
            <input value="<?php  if (isset($_POST['ok'])){echo $_POST['email'];} ?>" placeholder="Seu e-mail" name="email" type="text">
            <button name="ok" value="ok" type="submit">Ok</button>
        </form> 
    </body>
</html>-->



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<title>Esqueci a senha</title>
<link rel="stylesheet" href="css/estilocadastro.css" type="text/css">
<link rel="stylesheet" href="css/animations.css" type="text/css">
<link rel="stylesheet" href="css/estilonavbar.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<style>
body {
  background-image: url('Kashmir.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
</style>
 <!--   <ul>
        <li><a class="" href="index.php">Home</a></li>
        <li><a href="cadastro.php">Cadastro</a></li>
        <li><a href="verdados.php">Dados</a></li>
        <li><a href="sair.php">Sair</a></li>
    </ul> -->
    <div class="signup-form pt-page-moveToBottom">
        <form action="" method="post">
            <h2>Trocar a senha</h2>
            <p>Informe seus dados para que possamos trocar a sua senha!</p>
            <hr>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-envelope-square"></i></span>
                    <input type="email" class="form-control" name="email" placeholder="Email" required="required">
                </div>
                <?php 
            if (isset($_POST['ok'])){
                if(count($erro) > 0) {
                    foreach($erro as $msg){
                        ?>
                        <i class="fa fa-times" aria-hidden="true">
                    <?php
                        echo $msg;
                    ?>
                        </i>
                    <?php
                    }
                }
            }
        ?>
            </div>
            <center>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-lg" name="ok">Trocar</button>
                </div>
            </center>
        </form>
    </div>
</body>
</html>                            