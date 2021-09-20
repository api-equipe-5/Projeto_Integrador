<?php
	session_start();
	include('verifica_login.php');
	include_once("conexao.php");
	$num = $_SESSION['materia'];
	$nome = mysqli_real_escape_string($conexao, $_POST['nome']);
	$detalhes = mysqli_real_escape_string($conexao, $_POST['detalhes']);
	
	$result_cursos = "INSERT INTO cursos (nome, categoria_id, detalhes) VALUES ('$nome', '$num', '$detalhes')";	
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
					alert(\"Curso Cadastrado com Sucesso.\");
				</script>
			";	
			header('Location: materia.php');
			exit();
		}else{
			echo "
				<META HTTP-EQUIV=REFRESH CONTENT = 'materia.php'>
				<script type=\"text/javascript\">
					alert(\"Curso não foi cadastrado com Sucesso.\");
				</script>
			";	
			header('Location: materia.php');
			exit();
		}?>
	</body>
</html>
<?php $conexao->close(); ?>