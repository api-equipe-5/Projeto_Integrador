<?php
session_start();
include("conexao.php");
require('verifica_login.php');

$id = $_GET['id'];
$status = $_GET['status'];
$amountHours = $_GET['amountHours'];
$startedAt = $_GET['startedAt'];
$cardDescription = $_GET['cardDescription'];

if(empty($status) || empty($amountHours) || empty($startedAt) || empty($cardDescription)) {
    echo "ERRO - Preencha todos os campos";
	exit();
}


$query = "UPDATE `json` SET `status` = '$status', `amountHours` = '$amountHours', `startedAt` = '$startedAt', `cardDescription` = '$cardDescription' WHERE `id` = '$id'";

$result = mysqli_query($conexao, $query);

echo "Alterado!";
?>