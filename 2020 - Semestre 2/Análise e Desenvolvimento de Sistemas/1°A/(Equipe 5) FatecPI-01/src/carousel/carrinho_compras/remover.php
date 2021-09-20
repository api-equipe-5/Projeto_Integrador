<?php
    session_start();
	$idArquivos=$_GET['id'];
	if(isset($_GET['remover']) && $_GET['remover'] == "carrinho")
	{
		$idArquivos = $_GET['id'];
		unset($_SESSION['itens'][$idArquivos]);
		echo '<META HTTP-EQUIV="REFRESH" CONTENT="0;URL=../cart.php"/>';
	}
?>