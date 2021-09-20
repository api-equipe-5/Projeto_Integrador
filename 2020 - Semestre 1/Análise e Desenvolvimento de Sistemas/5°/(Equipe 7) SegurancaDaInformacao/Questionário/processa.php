<?php
	session_start();
	include_once("conexao.php");

	$cname = filter_input(INPUT_POST, 'cname', FILTER_SANITIZE_STRING);
	$clname = filter_input(INPUT_POST, 'clname', FILTER_SANITIZE_STRING);
	$cend = filter_input(INPUT_POST, 'cend', FILTER_SANITIZE_STRING);
	$ccep = filter_input(INPUT_POST, 'ccep', FILTER_SANITIZE_STRING);
	$ctel = filter_input(INPUT_POST, 'ctel', FILTER_SANITIZE_STRING);
	$cemail = filter_input(INPUT_POST, 'cemail', FILTER_SANITIZE_EMAIL);


$result_clientes = "INSERT INTO clientes (cname, clname, cend, ccep, ctel, cemail) VALUES ('$cname', '$clname',  
'$cend', '$ccep', '$ctel', '$cemail')";
$resultado_clientes = mysqli_query($conn, $result_clientes);

if(mysqli_insert_id($conn)){
	$_SESSION['msg'] = "Usuário Cadastrado com SUCESSO!";
	header("Location: administrativo.php");
}else{
	header("Location: administrativo.php");
}
