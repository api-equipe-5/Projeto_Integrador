<?php
//session_start(); verificado no admin_header.php
$id_adm = isset($_POST['userid']) ? $_POST['userid'] : "";

if ($id_adm != "") {
    $conection = mysqli_connect("localhost", "root", "", "vomariafelix");
    $preparado = mysqli_prepare($conection, "delete from admin where id = ?");
    mysqli_stmt_bind_param($preparado, "i", $id_adm);
    mysqli_stmt_execute($preparado);
    header('Location: ../doacao.php?');
}
include("conexao.php");

$consulta = "SELECT `doabanco`, `doaagencia`, `doaconta`, `doacnpj`, `doafav`, `doapix` FROM `infosite` WHERE `ID`=(1)";
$con = $conn->query($consulta) or die($mysqli->error); 
$dado = $con->fetch_array();
$doabanco = $dado["doabanco"]; 
$doaagencia = $dado["doaagencia"];
$doaconta = $dado["doaconta"];
$doacnpj = $dado["doacnpj"];
$doafav = $dado["doafav"];
$doapix = $dado["doapix"];
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, inicial-scale=1.0">
    <title>Doação</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
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
<!--Cabeçalho feito na página header.php e incluso nas demais página para simplificar o código-->
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
 p {
	 font-family:'Open Sans', sans-serif;
	 text-align:center;
 }
</style>
<hr>
<h2>Doações</h2>
    <section id="corpodoacao">
    <p><b>Ajude-nos a manter nosso trabalho! Aceitamos doações de qualquer valor, os dados para transferência são:</b><br><br>
    BANCO: <?php echo($doabanco); ?> <br>
    AGENCIA: <?php echo($doaagencia); ?> <br>
    CONTA: <?php echo($doaconta); ?> <br>
    CNPJ: <?php echo($doacnpj); ?> <br>
    FAVORECIDO: <?php echo($doafav); ?> <br><br>
    CHAVE PIX: <?php echo($doapix); ?> </p>
    </section>
    <br>
    <br>

<?php
	include("_footer.php");
?>

</body>
</html>