<?php
session_start();
include('conexao.php');
require('verifica_login.php');

$id = $_GET['id'];


$query = "SELECT * FROM `json` WHERE `id` = $id";

$result = mysqli_query($conexao, $query);

$json_array = array();

while($row = mysqli_fetch_assoc($result)){
   $json_array[] = $row;
}
echo json_encode($json_array);
?>
