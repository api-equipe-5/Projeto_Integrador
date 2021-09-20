<?php
session_start();
include("conexao.php");
include('verifica_login.php');

if(empty($_POST['usuario']) || empty($_POST['senha']) || empty($_POST['nome'])) {
	header('Location: cadastro.php');
	exit();
}

$id = mysqli_real_escape_string($conexao, trim($_POST['id']));
$nome = mysqli_real_escape_string($conexao, trim($_POST['nome']));
$usuario = mysqli_real_escape_string($conexao, trim($_POST['usuario']));
$senha = mysqli_real_escape_string($conexao, trim(md5($_POST['senha'])));

$sql = "UPDATE usuario SET nome = '$nome', senha = '$senha', usuario = '$usuario' WHERE usuario_id = '$id'";

if($conexao->query($sql) === TRUE) {
	$_SESSION['status_cadastro'] = true;
}
$conexao->close();

header('Location: ediçãoeditor.php');
exit;
?>