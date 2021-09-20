<?php
include ('conexao.php');

$email_usuario = $_POST['email_usuario'];
$titulo = $_POST['titulo'];
$numero = $_POST['numero'];
$validade = $_POST['validade'];
$cvv = $_POST['cvv'];


$result_contato = "INSERT INTO cartao (email_usuario, titulo, numero, validade, cvv) VALUES ('$email_usuario', '$titulo', '$numero', '$validade', '$cvv')";
$resultado_contato = mysqli_query($conexao, $result_contato);

if(mysqli_insert_id($conexao)){
    
    header("Location: perfiluser.php");
}
else{
    
    header("Location: perfiluser.php");
}
?>