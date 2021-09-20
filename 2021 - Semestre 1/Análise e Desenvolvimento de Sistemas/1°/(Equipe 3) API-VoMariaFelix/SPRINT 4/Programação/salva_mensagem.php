<?php
	include_once('conexao.php');
	$nome_resp = $_POST['nome_resp'];
    $cpf = $_POST['cpf'];
    $nome = $_POST['nome'];
    $turma = $_POST['turma'];
	$email = $_POST['email'];
	$endereço = $_POST['endereço'];
	
	$result_msg_contato = "INSERT INTO participantes (id, aluno, `data de nascimento`, responsável, `data de nascimento responsável`, endereço, email, telefone, turma, `período`, cpf) VALUES ('', '$nome', '', '$nome_resp', '', '$endereço', '$email', '', '', '', '$cpf')";
	$resultado_msg_contato= mysqli_query($conn, $result_msg_contato);

	if($result_msg_contato){
    
		$_SESSION['nome_resp'] = $_POST['nome_resp'];
		$_SESSION['cpf'] = $_POST['cpf'];
		$_SESSION['nome'] = $_POST['nome'];
		$_SESSION['turma'] = $_POST['turma'];
		$_SESSION['email'] = $_POST['email'];
		$_SESSION['endereço'] = $_POST['endereço'];
		
		echo 'Cadastro concluído com sucesso!';
	} else{
		echo'Erro no cadastro';
	}
?>