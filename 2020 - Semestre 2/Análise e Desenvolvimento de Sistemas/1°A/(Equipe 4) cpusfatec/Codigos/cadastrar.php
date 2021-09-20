<?php
session_start();
include("conexao.php");


if(empty($_POST['usuario']) || empty($_POST['senha']) || empty($_POST['nome'])) {
	header('Location: edição.php');
	exit();
}

$nome = mysqli_real_escape_string($conexao, trim($_POST['nome']));
$usuario = mysqli_real_escape_string($conexao, trim($_POST['usuario']));
$senha = mysqli_real_escape_string($conexao, trim(md5($_POST['senha'])));

$sql = "select count(*) as total from usuario where usuario = '$usuario'";
$result = mysqli_query($conexao, $sql);
$row = mysqli_fetch_assoc($result);

if($row['total'] == 1) {
	$_SESSION['usuario_existe'] = true;
	header('Location: cadastro.php');
	exit;
}

$sql = "INSERT INTO usuario (nome, usuario, senha, data_cadastro, adm, Ingles, Matematica, Hardware, AOC, Portugues, programacao) VALUES ('$nome', '$usuario', '$senha', NOW(), '2', '1', '1', '1', '1', '1', '1')";

if($conexao->query($sql) === TRUE) {
	$_SESSION['status_cadastro'] = true;
}
include('verifica_login.php');
$conexao->close();

header('Location: cadastro.php');
exit;
?>