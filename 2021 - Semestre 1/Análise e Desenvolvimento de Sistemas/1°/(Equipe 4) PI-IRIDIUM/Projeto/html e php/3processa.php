<!-- processa do doação -->
<?php

session_start();
include_once("3conexao.php");

$tNome = filter_input(INPUT_POST, 'tNome', FILTER_SANITIZE_STRING);
$tSobrenome = filter_input(INPUT_POST, 'tSobrenome', FILTER_SANITIZE_STRING);
$tcpf = filter_input(INPUT_POST, 'tcpf', FILTER_SANITIZE_STRING);
$tMail = filter_input(INPUT_POST, 'tMail', FILTER_SANITIZE_STRING);
$tCelular = filter_input(INPUT_POST, 'tCelular', FILTER_SANITIZE_STRING);
$tNasc = filter_input(INPUT_POST, 'tNasc', FILTER_SANITIZE_STRING);
$quantity = filter_input(INPUT_POST, 'quantity', FILTER_SANITIZE_STRING);


$result_usuario = "INSERT INTO doacao (nome, sobrenome, cpf, email, celular, nascimento, doacao, created) VALUES ('$tNome', '$tSobrenome', '$tcpf', '$tMail', '$tCelular', '$tNasc', '$quantity', NOW())";
$rresultado_usuario = mysqli_query($conn, $result_usuario);

if(mysqli_insert_id($conn)){
   header("Location: forma-de-pagamento.html");
} else {
   $_SESSION['msg'] = "<p style='color:red;'>O Voluntário não foi cadastrado com sucesso</p>";
   header("Location: doacao.php");
}










