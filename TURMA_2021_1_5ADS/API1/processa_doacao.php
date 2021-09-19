<?php

include("conexao.php");


$doabanco = filter_input(INPUT_POST,'doabanco', FILTER_SANITIZE_STRING);
$doaagencia = filter_input(INPUT_POST,'doaagencia', FILTER_SANITIZE_STRING);
$doaconta = filter_input(INPUT_POST,'doaconta', FILTER_SANITIZE_STRING);
$doacnpj = filter_input(INPUT_POST,'doacnpj', FILTER_SANITIZE_STRING);
$doafav = filter_input(INPUT_POST,'doafav', FILTER_SANITIZE_STRING);
$doapix = filter_input(INPUT_POST,'doapix', FILTER_SANITIZE_STRING);


$result_doacao = "UPDATE `infosite`
SET `doabanco` = ('$doabanco'),
`doaagencia` = ('$doaagencia'),
`doaconta` = ('$doaconta'),
`doacnpj` = ('$doacnpj'),
`doafav` = ('$doafav'),
`doapix` = ('$doapix')
WHERE `ID` = (1)";

$resultado_doacao = mysqli_query($conn, $result_doacao);

if(!$resultado_doacao){
	echo "Erro: " . mysqli_error($conn);
}


if(mysqli_insert_id($conn)){
	header("Location: doacao.php");
}else{
	header("Location: doacao.php");
}

$conn->close();