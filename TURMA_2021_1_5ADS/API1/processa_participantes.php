<?php

include("conexao.php");

$nome = filter_input(INPUT_POST,'nome', FILTER_SANITIZE_STRING);
$sexo = filter_input(INPUT_POST,'sexo', FILTER_SANITIZE_STRING);
$datanasc = filter_input(INPUT_POST,'date', FILTER_SANITIZE_STRING);
$certidao = filter_input(INPUT_POST,'certidao', FILTER_SANITIZE_STRING);
$deficiencia = filter_input(INPUT_POST,'devweb', FILTER_SANITIZE_STRING);
$descreva = filter_input(INPUT_POST,'descreva', FILTER_SANITIZE_STRING);
$renda = filter_input(INPUT_POST,'renda', FILTER_SANITIZE_STRING);
$nomer = filter_input(INPUT_POST,'nomeresp', FILTER_SANITIZE_STRING);
$sexor = filter_input(INPUT_POST,'sexor', FILTER_SANITIZE_STRING);
$grau = filter_input(INPUT_POST,'parentesco', FILTER_SANITIZE_STRING);
$escreva = filter_input(INPUT_POST,'escreva', FILTER_SANITIZE_STRING);
$cpf = filter_input(INPUT_POST,'cpf', FILTER_SANITIZE_STRING);
$telefone = filter_input(INPUT_POST,'telefone', FILTER_SANITIZE_NUMBER_INT);
$data = filter_input(INPUT_POST,'date2', FILTER_SANITIZE_STRING);
$endereço = filter_input(INPUT_POST,'endereço', FILTER_SANITIZE_STRING);
$email = filter_input(INPUT_POST,'email', FILTER_SANITIZE_EMAIL);

//echo "Nome: $nome <br>";
//echo "Sexo: $sexo <br>";
//echo "Data de Nascimento: $datanasc <br>";
//echo "Certidão de Nascimento: $certidao <br>";
//echo "Possui Deficiência: $deficiencia <br>";
//echo "Descreva: $descreva <br>";
//echo "Renda: $renda <br>";
//echo "Nome do Responsável: $nomer <br>";
//echo "Sexo Resp.: $sexor <br>";
//echo "Grau parentesco.: $grau <br>";
//echo "Grau (Outros): $escreva <br>";
//echo "CPF: $cpf <br>";
//echo "Telefone: $telefone <br>";
//echo "Data de Nascimento: $data <br>";
//echo "Endereço: $endereço <br>";
//echo "E-mail: $email <br>";

$result_participantes = "INSERT INTO participantes (`nome`, `sexo`, `dt_nascimento`, `deficiencia`, `descreva`, `renda`, `nome_responsavel`, `sexo_responsavel`, `grau_parentesco`, `grau`, `cpf`, `telefone`, `dt_nascimento_responsavel`, `endereco`, `email`) VALUES ('$nome', '$sexo', '$datanasc', '$deficiencia', '$descreva', '$renda', '$nomer', '$sexor', '$grau', '$escreva', '$cpf', '$telefone', '$data', '$endereço', '$email')";
$resultado_participantes = mysqli_query($conn, $result_participantes);
//echo "Resultado: " . $resultado_participantes . " - Query: ". $result_participantes;
if(!$resultado_participantes){
	echo "Erro: " . mysqli_error($conn);
}


if(mysqli_insert_id($conn)){
	header("Location: participantes.php");
}else{
	header("Location: participantes.php");
}

$conn->close();
