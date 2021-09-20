<?php
session_start();
if(!isset($_SESSION['itens']))
{
	$_SESSION['itens']= array();
}

if(isset($_GET['add']) && $_GET['add'] == "carrinho")
{
	//ADICIONA AO CARRINHO//
	$idArquivos = $_GET['id'];
	if(!isset($_SESSION['itens'][$idArquivos]))
	{
		$_SESSION['itens'][$idArquivos]=1;
	}
	else{
		$_SESSION['itens'][$idArquivos] +=1;
	}

	header("Location: ../cart.php");
		
}
?>