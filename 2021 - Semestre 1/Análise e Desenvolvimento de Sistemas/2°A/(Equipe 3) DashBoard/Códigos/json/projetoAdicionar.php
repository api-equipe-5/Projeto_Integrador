<?php
session_start();
include("conexao.php");
require('verifica_login.php');

$string = $_GET['user'];
$words = explode(" ", $string);
// Primeira palavra:
$primeiraPalavra = $words[0];
// Última palavra
$ultimaPalavra = $words[count($words)-1];

$status = $_GET['status'];
$user = $primeiraPalavra;
$user_last = $ultimaPalavra;
$email = $_GET['email'];
$avatar = $_GET['avatar'];
$amountHours = $_GET['amountHours'];
$startedAt = $_GET['startedAt'];
$project = $_GET['project'];
$cardDescription = $_GET['cardDescription'];

if(empty($status) || empty($startedAt) || empty($project)|| empty($cardDescription)) {
    echo "ERRO - Preencha todos os campos";
	exit();
}

if($amountHours== "") {
    $amountHours = null;
}


$query = "INSERT INTO `json` (`status`,`user`,`user_last`,`email`,`avatar`,`amountHours`,`startedAt`,`project`,`cardDescription`) VALUES ('$status','$user','$user_last','$email','$avatar','$amountHours','$startedAt','$project','$cardDescription')";

$result = mysqli_query($conexao, $query);

echo "Adicionado!";

?>