<?php
	include('verifica_login.php');
	include_once("conexao.php");
	
	$id = $_GET['id'];
	
	$result_cursos = "DELETE FROM cursos WHERE id = '$id'";
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
					alert(\"Curso Apagado com Sucesso.\");
				</script>
			";	
			header('Location: materia.php');
			exit();
		}else{
			echo "
				<META HTTP-EQUIV=REFRESH CONTENT = 'materia.php'>
				<script type=\"text/javascript\">
					alert(\"Curso não foi Apagado com Sucesso.\");
				</script>
			";	
			header('Location: materia.php');
			exit();
		}?>
	</body>
</html>
<?php $conexao->close(); ?>