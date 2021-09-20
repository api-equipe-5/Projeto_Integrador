<?php
session_start();
include ('conexao.php');



$email_usuario = $_SESSION['email'];
$titulo = $_POST['titulo'];
$numero = $_POST['numero'];
$validade = $_POST['validade'];
$cvv = $_POST['cvv'];
$saldo = $_POST['saldo'];




$result_contato = "INSERT INTO credito (email_usuario, titulo, numero, validade, cvv, saldo) VALUES ('$email_usuario', '$titulo', '$numero', '$validade', '$cvv', '$saldo')";
$resultado_contato = mysqli_query($conexao, $result_contato);

if(mysqli_insert_id($conexao)){
    
    header("Location: perfiluser.php");
}
else{
    
    header("Location: adicionar_saldo.php");
}
?>