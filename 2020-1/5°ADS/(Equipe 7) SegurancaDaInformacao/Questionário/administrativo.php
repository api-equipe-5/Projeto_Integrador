<?php
	session_start();
?>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
    <meta name="description" content="">
    

    <title>Login</title>

    <link href="css/bootstrap.css" rel="stylesheet">

    
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <link href="css/signin.css" rel="stylesheet">

    <script src="js/ie-emulation-modes-warning.js"></script>

    
  </head>

  <body>


  <div class="container">
  	<?php
	if(isset($_SESSION['msg']))
		echo  $_SESSION['msg'];
		unset($_SESSION['msg']);
	?>
 <form class="form-quest" method="POST" action="quest.php">
  <button class="btn btn-lg btn-danger btn-block" type="submit">Questionário</button>
</form>
  <form class="form-quest" method="POST" action="cadastrar.php">
  <button class="btn btn-lg btn-danger btn-block" type="submit">Cadastrar</button>
</form>
<form  class="form-quest" method="POST" action="consulta.php">
    <button class="btn btn-lg btn-danger btn-block" type="submit">Consultar Dados</button>
 </form>
 <a href="sair.php">Sair</a>
</div>
 <script src="js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>

