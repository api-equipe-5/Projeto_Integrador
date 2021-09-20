<?php
$id_adm = isset($_POST['userid']) ? $_POST['userid'] : "";

if ($id_adm != "") {
    $conection = mysqli_connect("localhost", "root", "", "vomariafelix");
    $preparado = mysqli_prepare($conection, "delete from admin where id = ?");
    mysqli_stmt_bind_param($preparado, "i", $id_adm);
    mysqli_stmt_execute($preparado);
    header('Location: ../projetos.php?');
}
include("conexao.php");

$consulta = "SELECT `projtit1`, `projdesc1`, `projtit2`, `projdesc2` FROM `infosite` WHERE `ID`=(1)";
$con = $conn->query($consulta) or die($mysqli->error); 
$dado = $con->fetch_array();
$projtit1 = $dado["projtit1"];
$projdesc1 = $dado["projdesc1"];
$projtit2 = $dado["projtit2"];
$projdesc2 = $dado["projdesc2"];
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, inicial-scale=1.0">
    <title>Projetos</title>
    <link rel="stylesheet" href="./css/style_projeto.css">
    <link rel="stylesheet" type="text/css" href="admin/css/admin_header.css">
    <link rel="stylesheet" type="text/css" href="admin/css/admin.css">
	<link rel="icon" href="favicon.ico">
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
    $botao_esquerdo['action'] = "alteradmin.php";
    $welcome["css"] = "welcome-voltar";
    $botao_direito["css"] = "hidden";
    include('admin/admin_header.php');
?>
<?php
	include("_header.php");
?>
<style>
 h2 {
    font-family: 'Open Sans', sans-serif;
    font-size:42px;
    font-weight:lighter;
    font-stretch: expanded;
    text-align:center;
    color:black ;
	margin-bottom:5pt;

}
</style>
    <hr width="100%">
    <h2>Projetos</h2>
	<br>
    <hr>
	<section id="projeto1">
        <div>
            <figure class="projeto1">
             <img src="imagens/projeto 1.jpg" alt="projeto1" width="320px">
            </figure>
            <h3><?php echo($projtit1); ?></h3> <!-- Título do projeto = variável copiada do banco de dados -->
            <p><?php echo($projdesc1); ?></p> <!-- descrição do projeto = variável copiada do banco de dados -->
         </div>
    </section>
    <hr width="100%">
    <section id="projeto2">
        <div>
            <figure class="Projeto2">
             <img src="imagens/projeto 2.jpg" alt="projeto2" width="320px">
            </figure>
            <h3><?php echo($projtit2); ?></h3>
            <p><?php echo($projdesc2); ?></p>
		</div>	
    </section>   
    <hr width="100%"> <br>
    <a class="btn" href="voluntario_especifico.php">Quero inscrever um projeto!</a><br><br>
	
	
<?php
	include("_footer.php");
?>
	
</body>
</html>