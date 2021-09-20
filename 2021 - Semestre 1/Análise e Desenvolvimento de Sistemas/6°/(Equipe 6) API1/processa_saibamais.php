<?php

include("conexao.php");

//Declarar variáveis

$saibatexto = filter_input(INPUT_POST,'saibatexto', FILTER_SANITIZE_STRING);
$saibaend = filter_input(INPUT_POST,'saibaend', FILTER_SANITIZE_STRING);
$saibatel = filter_input(INPUT_POST,'saibatel', FILTER_SANITIZE_STRING);
$saibahor = filter_input(INPUT_POST,'saibahor', FILTER_SANITIZE_STRING);
$saibaatend = filter_input(INPUT_POST,'saibaatend', FILTER_SANITIZE_STRING);

//fazer uma função para cada campo?
$result_saibamais = "UPDATE `infosite`
SET `saibatexto` = ('$saibatexto'),
`saibaend` = ('$saibaend'),
`saibatel` = ('$saibatel'),
`saibahor` = ('$saibahor'),
`saibaatend` = ('$saibaatend')
WHERE `ID` = (1)";

$resultado_saibamais = mysqli_query($conn, $result_saibamais);

if(!$resultado_saibamais){
	echo "Erro: " . mysqli_error($conn);
}

if(mysqli_insert_id($conn)){
	header("Location: saibamais.php");
}else{
	header("Location: saibamais.php");
}

$conn->close();