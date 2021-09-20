<?php
  session_start();
  include_once("conexao.php");
?>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
    <meta name="description" content="">
    

    <title>Clientes</title>

    <link href="css/bootstrap.css" rel="stylesheet">

    
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <link href="css/signin.css" rel="stylesheet">

    <script src="js/ie-emulation-modes-warning.js"></script>

    
  </head>

  <body>

  <div class="container">

  	<h1>Lista de Clientes</h1>
    <?php
    $result_clientes = "SELECT * FROM clientes";
    $resultado_clientes = mysqli_query($conn, $result_clientes );
    while($row_cname = mysqli_fetch_assoc($resultado_clientes)){
      echo "ID: " . $row_cname['id'] . "<br>";
      echo "Nome: " . $row_cname['cname'] . "<br>";
      echo "Sobrenome: " . $row_cname['clname'] . "<br>";
      echo "Endereço: " . $row_cname['cend'] . "<br>";
      echo "CEP: " . $row_cname['ccep'] . "<br>";
      echo "Telefone: " . $row_cname['ctel'] . "<br>";
      echo "E-mail: " . $row_cname['cemail'] . "<br><hr>";
  }
    ?>
 
 <a href="sair.php">Sair</a>
</div>
 <script src="js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
