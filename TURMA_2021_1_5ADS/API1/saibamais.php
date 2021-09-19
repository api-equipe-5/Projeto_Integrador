<?php
$id_adm = isset($_POST['userid']) ? $_POST['userid'] : "";

if ($id_adm != "") {
    $conection = mysqli_connect("localhost", "root", "", "vomariafelix");
    $preparado = mysqli_prepare($conection, "delete from admin where id = ?");
    mysqli_stmt_bind_param($preparado, "i", $id_adm);
    mysqli_stmt_execute($preparado);
    header('Location: ../saibamais.php?');
}
include("conexao.php");

$consulta = "SELECT `saibatexto`, `saibaend`, `saibatel`, `saibahor`, `saibaatend` FROM `infosite` WHERE `ID`=(1)";
$con = $conn->query($consulta) or die($mysqli->error); 
$dado = $con->fetch_array();
$saibatexto = $dado["saibatexto"];
$saibaend = $dado["saibaend"];
$saibatel = $dado["saibatel"];
$saibahor = $dado["saibahor"];
$saibaatend = $dado["saibaatend"];
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, inicial-scale=1.0">
    <title>CECOI Vó Maria Félix</title>
    <link rel="stylesheet" type="text/css" href="./css/style_saibamais.css">
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
    <hr>
    <h2>Conheça o CECOI Vó Maria Félix</h2><br>
        <section id="texto">

        <p align="justify"> <?php echo($saibatexto) ?> </p>

        </section>
                    <!-- Vídeo incorporado do canal no Youtube "Cecoi vó Maria Félix" -->
        <div id="carregando" class="center" align="center">
        <br><br><iframe width="560" height="315" src="https://www.youtube.com/embed/hB0W7N2_Ujo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen align="middle"></iframe>
        </div>
        
		<section id="info">
            <p><b>Endereço:</b><br>
            <?php echo nl2br($saibaend); ?> <br>
            <b>Telefone:</b> <br>
            <?php echo($saibatel); ?> <br>
            <b>Horário:</b><br>
            <?php echo($saibahor); ?> <br>
            <b>Atendimento:</b><br>
            <?php echo($saibaatend); ?> </p>           
		</section>	
            
	<hr width="100%">
    <section id="contato">
        <br>
        <a class="face" href="https://www.facebook.com/cecoivomariafelix" target="_blank"><img src="imagens\facebook.png" width="50px"></a>
        <a class="youtube" href="https://www.youtube.com/channel/UCB-99VOkEEM07VF4VVsP7_g" target="_blank"><img src="imagens\youtube.png" width="50px"></a>
    </section>
    <hr width="100%">
    <footer><strong>Desenvolvido por Grupo Rocket 2021</strong></footer>
</body>
</html>