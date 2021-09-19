<?php

include("conexao.php");


$projtit1 = filter_input(INPUT_POST,'projtit1', FILTER_SANITIZE_STRING);
$projdesc1 = filter_input(INPUT_POST,'projdesc1', FILTER_SANITIZE_STRING);


$result_proj1 = "UPDATE `infosite`
SET `projtit1` = ('$projtit1'),
`projdesc1` = ('$projdesc1')
WHERE `ID` = (1)";

$resultado_proj1 = mysqli_query($conn, $result_proj1);

if(!$resultado_proj1){
	echo "Erro: " . mysqli_error($conn);
}


if(mysqli_insert_id($conn)){
	header("Location: projetos.php");
}else{
	header("Location: projetos.php");
}

$conn->close();