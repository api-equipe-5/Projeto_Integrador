<?php
	include_once('conexao.php');
	$nome = $_POST['nome'];
	$endereço = $_POST['endereço'];
	$email = $_POST['email'];
    $cpf = $_POST['cpf'];
	$curriculo = $_POST['curriculo'];
	$certificado = $_POST['certificado'];
	$experiencia = $_POST['experiencia'];
	$caracteristicas = $_POST['caracteristicas'];
	$objetivos = $_POST['objetivos'];
	$hora = $_POST['hora'];
	
	$result_msg_contato = "INSERT INTO `voluntário específico` (id, nome, `data de nascimento`, cpf , endereço, email, telefone, currículo, certificado, experiência, `horários disponíveis`, características, objetivos) VALUES ('', '$nome', '', '$cpf', '$endereço', '$email', '', '$curriculo', '$certificado', '$experiencia', '$hora', '$caracteristicas', '$objetivos')";
	$resultado_msg_contato= mysqli_query($conn, $result_msg_contato);

	if($result_msg_contato){
    
		$_SESSION['nome'] = $_POST['nome'];
		$_SESSION['endereço'] = $_POST['endereço'];
		$_SESSION['email'] = $_POST['email'];
		$_SESSION['cpf'] = $_POST['cpf'];
		$_SESSION['curriculo'] = $_POST['curriculo'];
		$_SESSION['certificado'] = $_POST['certificado'];
		$_SESSION['experiencia'] = $_POST['experiencia'];
		$_SESSION['caracteristicas'] = $_POST['caracteristicas'];
		$_SESSION['objetivos'] = $_POST['objetivos'];
		$_SESSION['hora'] = $_POST['hora'];
		
		echo 'Cadastro concluído com sucesso!';
	} else{
		echo'Erro no cadastro';
	}
?>