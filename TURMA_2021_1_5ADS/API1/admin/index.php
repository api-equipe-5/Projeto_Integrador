<?php
$id_adm = isset($_POST['userid']) ? $_POST['userid'] : "";
if ($id_adm != "") {
    $conection = mysqli_connect("localhost", "root", "", "bd_admin");
    $preparado = mysqli_prepare($conection, "delete from tb_user where id = ?");
    mysqli_stmt_bind_param($preparado, "i", $id_adm);
    mysqli_stmt_execute($preparado);
    header('Location:index.php?');
}
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Painel Administrativo</title>
    <link rel="icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <link rel="stylesheet" type="text/css" href="css/admin_header.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body class="fundo">
    <?php
       $botao_esquerdo["css"] = "hidden";
       $botao_esquerdo["action"] = "hidden";
       $botao_esquerdo["texto"] = "hidden";
       $botao_direito["css"] = "hidden";
       include('admin_header.php');
    ?>
<style> <!--estilo da tabela dos acessos para visualizar os banco de dados-->
tr{
  font-family: 'Open Sans', sans-serif;
  font-size: 16pt;
  background-color: white;
  color: white;
}

table {
  border-color:transparent;
}
table td:hover{
   background-color:#8C1317;
}
						
td{
  font-family: 'Open Sans', sans-serif;
  font-size: 16pt;
  background-color: #d7666d;
  color: white;
  padding:40px;
  text-align:center;
  border: 15px solid #FFFFFF;	
  cursor:pointer;
  margin:auto;
}
</style>
	
	<table id="acessos" cellspacing="0"  border="20px">
      <tr>
        <td onclick="location.href='gerenciar_admin.php'" id="1" title="Edita, adiciona e descarta administradores">Gerenciar<br>Aministradores</td> 
	    <td onclick="location.href='/ong/alteradmin.php'" id="2" title="Editar site">Editar Site</td> 
        <td onclick="location.href='acesso.php'" id="3"title="Acessar dados cadastrados">⠀Acessar Banco de Dados<br>dos Cadastros</td> 
	  </tr>
    </table>
</body>
</html>