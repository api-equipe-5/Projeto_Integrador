<?php
include ('conexao1.php');

$nome = mysqli_real_escape_string ($conexao1, trim($_POST['nome']));
$email = mysqli_real_escape_string ($conexao1, trim(md5($_POST['email'])));
$assunto = mysqli_real_escape_string  ($conexao1, trim($_POST['assunto']));
$mensagem = mysqli_real_escape_string ($conexao1, trim($_POST['mensagem']));


$result_contato = "INSERT INTO contato (nome, email, assunto, mensagem) VALUES ('$nome', '$email', '$assunto', '$mensagem')";
$resultado_contato = mysqli_query($conexao1, $result_contato);

if(mysqli_insert_id($conexao1)){
    $_SESSION['msg'] = "<p style='color:green;'>Mensagem enviada com sucesso</p>";
    header("Location: contato.php");
}
else{
    $_SESSION['msg'] = "<p style='color:red;'>Mensagem não foi enviada</p>";
    header("Location: contato.php");
}
?>