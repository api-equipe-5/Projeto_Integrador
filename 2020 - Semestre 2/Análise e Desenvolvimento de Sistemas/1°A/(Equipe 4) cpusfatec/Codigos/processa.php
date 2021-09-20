<?php
	session_start();
	include('verifica_login.php');
	include_once("conexao.php");
	$id = mysqli_real_escape_string($conexao, $_POST['id']);
	$nome = mysqli_real_escape_string($conexao, $_POST['nome']);
	$detalhes = mysqli_real_escape_string($conexao, $_POST['detalhes']);
	
	$result_cursos = "UPDATE cursos SET nome='$nome', detalhes = '$detalhes' WHERE id = '$id'";	
	$resultado_cursos = mysqli_query($conexao, $result_cursos);	
?>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
	</head>

	<body> <?php
		if(mysqli_affected_rows($conexao) != 0){
			echo "
				<META HTTP-EQUIV=REFRESH CONTENT = 'materia.php'>
				<script type=\"text/javascript\">
					alert(\"Curso alterado com Sucesso.\");
				</script>
			";	
			header('Location: materia.php');
			exit();
		}else{
			echo "
				<META HTTP-EQUIV=REFRESH CONTENT = 'materia.php'>
				<script type=\"text/javascript\">
					alert(\"Curso não foi alterado com Sucesso.\");
				</script>
			";	
			header('Location: materia.php');
			exit();
		}?>
	</body>
</html>
<?php $conexao->close(); ?>