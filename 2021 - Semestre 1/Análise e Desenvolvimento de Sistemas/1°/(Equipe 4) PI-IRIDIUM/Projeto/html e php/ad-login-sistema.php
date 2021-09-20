<?php
session_start();
// local onde vai validar o usuario e senha do login
include('loginConexao.php');

$usuario = mysqli_real_escape_string($conexao, $_POST['usuario']);
$senha = mysqli_real_escape_string($conexao, $_POST['senha']);

$query = "select usuario from usuario where usuario = '$usuario' and senha = md5('$senha')"; 

$result = mysqli_query($conexao, $query);

$row = mysqli_num_rows($result);

if($row == 1) {
    $_SESSION['usuaio'] = $usuario;
    header('Location: admin.php');
    exit();
}   else {
    header('Location: ad-login.php');
    exit();
}

?>