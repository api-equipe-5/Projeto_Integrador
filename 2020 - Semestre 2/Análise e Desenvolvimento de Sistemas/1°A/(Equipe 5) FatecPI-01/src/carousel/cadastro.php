<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<title>Cadastro</title>
<link rel="stylesheet" href="css/estilocadastro.css" type="text/css">
<link rel="stylesheet" href="css/animations2.css" type="text/css">
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
<!--  <ul>
        <li><a class="" href="index.php">Home</a></li>
        <li><a href="cadastro.php">Cadastro</a></li>
        <li><a href="verdados.php">Dados</a></li>
        <li><a href="sair.php">Sair</a></li>
    </ul>  -->
    <div class="signup-form pt-page-moveToBottom">
        <form action="cadastrar.php" method="post">
            <h2>Cadastre-se!</h2>
            <p>Informe seus dados para que possamos criar a sua conta!</p>
            <hr>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-envelope-square"></i></span>
                    <input type="email" class="form-control" name="email" placeholder="Email" required="required">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" class="form-control" name="nickname" placeholder="Usuário" required="required">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" class="form-control" name="name" placeholder="Nome completo" required="required">
                </div>
            </div>
            
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" class="form-control" name="password" placeholder="Senha" required="required">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <span class="input-group-addon">
                        <i class="fa fa-lock"></i></span>
                    </span>
                    <input type="password" class="form-control" name="confirm_password" placeholder="Confirme a sua senha" required="required">
                </div>
            </div>
            <center>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-lg">Confirmar dados</button>
                </div>
            </center>
        </form>
        <div class="text-center">Você já possui uma conta? <a href="logar.php">Logue-se!</a></div>
    </div>
</body>
</html>                            