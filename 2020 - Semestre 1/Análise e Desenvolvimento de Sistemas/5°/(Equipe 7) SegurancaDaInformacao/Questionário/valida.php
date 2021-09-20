<?php

session_start();
include_once("conexao.php");

if((isset($_POST['user'])) && (isset($_POST['senha']))){
	$usuario = mysqli_real_escape_string($conn, $_POST['user']);
	$senha = mysqli_real_escape_string($conn, $_POST['senha']);
	//$senha = md5($senha);


	$sql = "SELECT * FROM 	login WHERE user = '$usuario' && senha = '$senha' ";
	$result = mysqli_query($conn, $sql);
	$resultado = mysqli_fetch_assoc($result);

	if(empty($resultado)){
	$_SESSION['loginErro'] = 'Usuário ou Senha incorreto!';
	header("Location: index.php");
	
	}elseif (isset($resultado)) {
		$_SESSION['usuarioUsuario'] = $resultado['user'];
		$_SESSION['usuarioSenha'] = $resultado['senha'];
		$_SESSION['usuarioNome'] = $resultado['nome'];
		header("Location: administrativo.php");
		
	}else{

	$_SESSION['loginErro'] = 'Usuário ou Senha incorreto!';
	header("Location: index.php");
	}



}
else{
	$_SESSION['loginErro'] = 'Usuário ou Senha incorreto!';
	header("Location: index.php");

}

?>

