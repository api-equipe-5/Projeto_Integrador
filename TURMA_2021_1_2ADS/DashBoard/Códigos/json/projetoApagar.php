<?php
session_start();
include("conexao.php");
require('verifica_login.php');

$id = $_GET['id'];

$query = " DELETE FROM `json` WHERE `id` = '$id'";

$result = mysqli_query($conexao, $query);

echo "Apagado!";
?>