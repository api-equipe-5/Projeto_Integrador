<?php
	include_once('conexao.php');
	$objetivos = $_POST['objetivos'];
	$diferencial = $_POST['diferencial'];
	$caracteristicas = $_POST['características'];
    $envolvidos = $_POST['envolvidos'];
	$anexo = $_POST['anexo'];
	$email = $_POST['email'];
	
	$result_msg_contato = "INSERT INTO `projetos` (id, objetivos, diferencial, `características`, envolvidos, anexo, email) VALUES ('', '$objetivos', '$diferencial', '$caracteristicas', '$envolvidos', '$anexo', '$email')";
	$resultado_msg_contato= mysqli_query($conn, $result_msg_contato);

	if($result_msg_contato){
    
		$_SESSION['objetivos'] = $_POST['objetivos'];
		$_SESSION['diferencial'] = $_POST['diferencial'];
		$_SESSION['características'] = $_POST['características'];
		$_SESSION['envolvidos'] = $_POST['envolvidos'];
		$_SESSION['anexo'] = $_POST['anexo'];
		$_SESSION['email'] = $_POST['email'];
		
		echo 'Projeto enviado para análise!';
	} else{
		echo'Erro no preenchimento!';
	}
?>