<?php

include("conexao.php");


$projtit2 = filter_input(INPUT_POST,'projtit2', FILTER_SANITIZE_STRING);
$projdesc2 = filter_input(INPUT_POST,'projdesc2', FILTER_SANITIZE_STRING);


$result_proj2 = "UPDATE `infosite`
SET `projtit2` = ('$projtit2'),
`projdesc2` = ('$projdesc2')
WHERE `ID` = (1)";

$resultado_proj2 = mysqli_query($conn, $result_proj2);

if(!$resultado_proj2){
	echo "Erro: " . mysqli_error($conn);
}


if(mysqli_insert_id($conn)){
	header("Location: projetos.php");
}else{
	header("Location: projetos.php");
}

$conn->close();