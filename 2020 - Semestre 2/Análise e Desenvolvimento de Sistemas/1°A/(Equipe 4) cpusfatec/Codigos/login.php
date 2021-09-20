<?php
session_start();
include('conexao.php');

if(empty($_POST['usuario']) || empty($_POST['senha'])) {
	header('Location: index.php');
	exit();
}

$usuario = mysqli_real_escape_string($conexao, $_POST['usuario']);
$senha = mysqli_real_escape_string($conexao, $_POST['senha']);

$query = "select * from usuario where usuario = '{$usuario}' and senha = md5('{$senha}')";

$result = mysqli_query($conexao, $query);

$row = mysqli_num_rows($result);

if($row == 1) {
	$usuario_bd = mysqli_fetch_assoc($result);
	$_SESSION['nivel'] = $usuario_bd['adm'];
	$_SESSION['id'] = $usuario_bd['usuario_id'];
	$_SESSION['usuario'] = $usuario_bd['usuario'];
	$_SESSION['email'] = $usuario_bd['nome'];
	$_SESSION['senha'] = $usuario_bd['senha'];
	
	$_SESSION['ing'] = $usuario_bd['Ingles'];
	$_SESSION['mat'] = $usuario_bd['Matematica'];
	$_SESSION['har'] = $usuario_bd['Hardware'];
	$_SESSION['aoc'] = $usuario_bd['AOC'];
	$_SESSION['por'] = $usuario_bd['Portugues'];
	$_SESSION['pro'] = $usuario_bd['programacao'];

	header('Location: painel.php');
	exit();

} else {
	$_SESSION['nao_autenticado'] = true;
	header('Location: index.php');
	exit();
}