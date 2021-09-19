<?php 
session_start();
include('conexao.php');
require('verifica_login.php');

$query = "SELECT * FROM `json`";

$result = mysqli_query($conexao, $query);

$json_array = array();

while($row = mysqli_fetch_assoc($result)){
   $json_array[] = $row;
}
echo json_encode($json_array);
?>
