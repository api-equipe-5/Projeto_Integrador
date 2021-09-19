<?php 
session_start();
include('conexao.php');
require('verifica_login.php');

$string = $_GET['nome'];
$words = explode(" ", $string);
// Primeira palavra:
$primeiraPalavra = $words[0];
// Última palavra
$ultimaPalavra = $words[count($words)-1];

$user = $primeiraPalavra;
$user_last = $ultimaPalavra;

$query = "SELECT `email`,`avatar` FROM `json` WHERE `user` = '$user' AND `user_last` = '$user_last'";

$result = mysqli_query($conexao, $query);

$json_array = array();

while($row = mysqli_fetch_assoc($result)){
   $json_array[] = $row;
}

echo json_encode($json_array);


?>