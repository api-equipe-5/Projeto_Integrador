<?php
session_start();
include_once("conexao.php");
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<title>Produtos</title>
	</head>
		<h1>Produtos</h1>
		<?php
		if(isset($_SESSION['msg'])){
			echo $_SESSION['msg'];
			unset($_SESSION['msg']);
		}	
		echo "Português <br> <hr>";
		$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Português'";
		$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
		while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
			echo "Título do produto: " . $row_usuario['titulo_produto'] . "<br>";
			echo "Arquivo: " . $row_usuario['nome_arquivo'] . "<br>";
			echo "Disciplina: " . $row_usuario['disciplina'] . "<br>";
			echo "Descrição: " . $row_usuario['descricao'] . "<br>";
			echo "Preço: " . $row_usuario['preco'] . "<br> <br>";
		}

		echo "Inglês <br> <hr>";
		$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Inglês'";
		$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
		while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
			echo "Título do produto: " . $row_usuario['titulo_produto'] . "<br>";
			echo "Arquivo: " . $row_usuario['nome_arquivo'] . "<br>";
			echo "Disciplina: " . $row_usuario['disciplina'] . "<br>";
			echo "Descrição: " . $row_usuario['descricao'] . "<br>";
			echo "Preço: " . $row_usuario['preco'] . "<br> <br>";
		}
		
		echo "Matemática Discreta <br> <hr>";
		$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Matemática Discreta'";
		$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
		while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
			echo "Título do produto: " . $row_usuario['titulo_produto'] . "<br>";
			echo "Arquivo: " . $row_usuario['nome_arquivo'] . "<br>";
			echo "Disciplina: " . $row_usuario['disciplina'] . "<br>";
			echo "Descrição: " . $row_usuario['descricao'] . "<br>";
			echo "Preço: " . $row_usuario['preco'] . "<br> <br>";
		}
		echo "Laboratório de Hardware <br> <hr>";
		$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Laboratório de Hardware'";
		$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
		while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
			echo "Título do produto: " . $row_usuario['titulo_produto'] . "<br>";
			echo "Arquivo: " . $row_usuario['nome_arquivo'] . "<br>";
			echo "Disciplina: " . $row_usuario['disciplina'] . "<br>";
			echo "Descrição: " . $row_usuario['descricao'] . "<br>";
			echo "Preço: " . $row_usuario['preco'] . "<br> <br>";
		}
		echo "Administração Geral <br> <hr>";
		$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Administração Geral'";
		$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
		while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
			echo "Título do produto: " . $row_usuario['titulo_produto'] . "<br>";
			echo "Arquivo: " . $row_usuario['nome_arquivo'] . "<br>";
			echo "Disciplina: " . $row_usuario['disciplina'] . "<br>";
			echo "Descrição: " . $row_usuario['descricao'] . "<br>";
			echo "Preço: " . $row_usuario['preco'] . "<br> <br>";
		}
		echo "Algoritmos e Lógica de Programação <br> <hr>";
		$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Algoritmos e Lógica de Programação'";
		$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
		while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
			echo "Título do produto: " . $row_usuario['titulo_produto'] . "<br>";
			echo "Arquivo: " . $row_usuario['nome_arquivo'] . "<br>";
			echo "Disciplina: " . $row_usuario['disciplina'] . "<br>";
			echo "Descrição: " . $row_usuario['descricao'] . "<br>";
			echo "Preço: " . $row_usuario['preco'] . "<br> <br>";
		}
		echo "Arquitetura e Organização de Computadores <br> <hr>";
		$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Arquitetura e Organização de Computadores'";
		$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
		while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
			echo "Título do produto: " . $row_usuario['titulo_produto'] . "<br>";
			echo "Arquivo: " . $row_usuario['nome_arquivo'] . "<br>";
			echo "Disciplina: " . $row_usuario['disciplina'] . "<br>";
			echo "Descrição: " . $row_usuario['descricao'] . "<br>";
			echo "Preço: " . $row_usuario['preco'] . "<br> <br>";
		}

		?>		
	</body>
</html>