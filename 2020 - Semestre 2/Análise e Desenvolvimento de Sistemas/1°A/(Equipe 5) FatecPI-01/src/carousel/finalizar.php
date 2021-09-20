<?php

	$id_arquivos = "";
	$titulo_produtos = "";
	$preco = 0.0;

	$parcelas = 1;
	$metodo = "cartao/boleto";

	session_start();

	$conexao = new PDO ('mysql:host=localhost;dbname=bd_pi01',"root","");

    foreach($_SESSION['dados'] as $arquivos){
		$conexao = new PDO ('mysql:host=localhost;dbname=bd_pi01',"root","");
			$id_arquivos .= $arquivos['id_arquivos'].',';
			$titulo_produtos .= $arquivos['titulo_produto'].',';
			$preco = floatval($arquivos['preco']) + $preco;
	}

	$insert = $conexao -> prepare ("INSERT INTO pedidos (id_produto, titulo_produto, preco, parcelas, metodopag) VALUES (?,?,?,?,?)");
	$insert->bindParam(1, $id_arquivos);
	$insert->bindParam(2, $titulo_produtos);
	$insert->bindParam(3, $preco);
	$insert->bindParam(4, $parcelas);
	$insert->bindParam(5, $metodo);
	$insert->execute();

	// header("Location: sucesso.php");

?>