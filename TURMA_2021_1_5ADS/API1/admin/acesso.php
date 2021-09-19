<?php
$id_adm = isset($_POST['userid']) ? $_POST['userid'] : "";

if ($id_adm != "") {
    $conection = mysqli_connect("localhost", "root", "", "bd_admin");
    $preparado = mysqli_prepare($conection, "delete from tb_user where id = ?");
    mysqli_stmt_bind_param($preparado, "i", $id_adm);
    mysqli_stmt_execute($preparado);
    header('Location: acesso.php');
}
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Administrador</title>
    <link rel="icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/admin_header.css">
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <style type="text/css"> 
     a:link 
     { 
     text-decoration:none; 
     } 
    </style>
</head>
<body class="background fundo">
    <?php
    $botao_esquerdo['texto'] = "Voltar";
    $botao_esquerdo['action'] = "index.php";
    $welcome["css"] = "welcome-voltar";
    $botao_direito["css"] = "hidden";
    include('admin_header.php');
    ?>
    <?php
	include("_headeredit.php")
	?>
	<br>
	<br>	
<style> <!--estilo da tabela-->
tr{
  font-family: 'Open Sans', sans-serif;
  font-size: 16pt;

  color: white;
}

table {
  border-color:transparent;
}
table td:hover{
   background-color:#8C1317;
}
						
td{
  font-size: 16pt;
  background-color: #d7666d;
  color: white;
  padding:40px;
  text-align:center;
  border: 15px solid #FFFFFF;	
  cursor:pointer;
}
</style>	
	<table id="acessos" cellspacing="0"  border="20px">
      <tr>
	    <td onclick="location.href='print_participante.php'">Participantes</td>
        <td onclick="location.href='print_apoio.php'">Voluntários<br>de Apoio</td> 
	    <td onclick="location.href='print_especifico.php'">Voluntários<br>Específicos </td> 
        <td onclick="location.href='print_projetos.php'">⠀Projetos⠀</td>
	  </tr>
    </table>
	<br>	
    <hr width="100%">
    <footer>Desenvolvido por Grupo Rocket 2021</footer>
</body>
</html>