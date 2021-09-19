<?php

include("conexao.php");

$nome = filter_input(INPUT_POST,'nome', FILTER_SANITIZE_STRING);
$email = filter_input(INPUT_POST,'email', FILTER_SANITIZE_EMAIL);
$mensagem = filter_input(INPUT_POST,'mensagem', FILTER_SANITIZE_STRING);


$result_contato = "INSERT INTO contato (`nome`, `email`, `mensagem`,) VALUES ('$nome', '$email', '$mensagem')";
$resultado_contato = mysqli_query($conn, $result_contato);
//echo "Resultado: " . $resultado_participantes . " - Query: ". $result_participantes;
if(!$resultado_contato){
	echo "Erro: " . mysqli_error($conn);
}


if(mysqli_insert_id($conn)){
	header("Location: contato.php");
}else{
	header("Location: contato.php");
}

$conn->close();
