<?php
	include_once('conexao.php');
	$nome = $_POST['nome'];
	$descrição = $_POST['descrição'];
    $comprovante = $_POST['comprovante'];
	$anonimo = $_POST['anonimo'];

	
	$result_msg_contato = "INSERT INTO `doações` (id, nome, descrição, comprovante, anonimo) VALUES ('', '$nome', '$descrição', '$comprovante','$anonimo')";
	$resultado_msg_contato= mysqli_query($conn, $result_msg_contato);


	if($result_msg_contato){
    
		$_SESSION['nome'] = $_POST['nome'];
		$_SESSION['descrição'] = $_POST['descrição'];
		$_SESSION['comprovante'] = $_POST['comprovante'];
		$_SESSION['anonimo'] = $_POST['anonimo'];

		echo 'Enviado com sucesso!';
	} else{
		echo'Erro no preenchimento!';
	}
?>