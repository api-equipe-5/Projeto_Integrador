<?php
	include_once('conexao.php');
	$objetivos = $_POST['objetivos'];
	$diferencial = $_POST['diferencial'];
	$caracteristicas = $_POST['características'];
    $envolvidos = $_POST['envolvidos'];
	$anexo = $_POST['anexo'];
	
	$result_msg_contato = "INSERT INTO `projetos` (id, objetivos, diferencial, `características`, envolvidos, anexo) VALUES ('', '$objetivos', '$diferencial', '$caracteristicas', '$envolvidos', '$anexo')";
	$resultado_msg_contato= mysqli_query($conn, $result_msg_contato);

	if($result_msg_contato){
    
		$_SESSION['objetivos'] = $_POST['objetivos'];
		$_SESSION['diferencial'] = $_POST['diferencial'];
		$_SESSION['características'] = $_POST['características'];
		$_SESSION['envolvidos'] = $_POST['envolvidos'];
		$_SESSION['anexo'] = $_POST['anexo'];
		
		echo 'Projeto enviado para análise!';
	} else{
		echo'Erro no preenchimento!';
	}
?>