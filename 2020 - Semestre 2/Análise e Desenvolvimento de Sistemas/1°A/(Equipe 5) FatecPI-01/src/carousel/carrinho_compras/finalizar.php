<?php

	session_start();

	print_r($_SESSION['dados']);
	
	$id_arquivos = ""; // variaveis que vao guardar as infos de cada produto
	$titulo_produtos = "";
	$preco = 0.0;

	$parcelas = $_POST['parcelas']; // pegando variaveis dos forms
	$metodo = $_POST['metodopag'];

	$conexao = new PDO ('mysql:host=localhost;dbname=bd_pi01',"root","");

    foreach($_SESSION['dados'] as $arquivos){
		
		$id_arquivos .= $arquivos['id_arquivos'].',';
		$titulo_produtos .= $arquivos['titulo_produto'].',';
		$preco = floatval($arquivos['preco']) + $preco;
	}

	$insert = $conexao -> prepare ("INSERT INTO pedidos (id_produto, titulo_produto, preco, parcelas, metodopag, email_usuario) VALUES (?,?,?,?,?,?)");
	$insert->bindParam(1, $id_arquivos);
	$insert->bindParam(2, $titulo_produtos);
	$insert->bindParam(3, $preco);
	$insert->bindParam(4, $parcelas);
	$insert->bindParam(5, $metodo);
	$insert->bindParam(6, $_SESSION['email']);
	$insert->execute();
	$id_pedido = $conexao->lastInsertId();

	unset($_SESSION['dados']);

	if ($metodo=="cartao") {
		 header("Location: ../pagcartao.php?id=$id_pedido");
	 }
	 else{
		 header("Location: ../pagboleto.php?id=$id_pedido");
	}
?>