<?php

include("conexao.php");

$nome = filter_input(INPUT_POST,'nome', FILTER_SANITIZE_STRING);
$sexo = filter_input(INPUT_POST,'sexo', FILTER_SANITIZE_STRING);
$cpf = filter_input(INPUT_POST,'cpf', FILTER_SANITIZE_STRING);
$datanasc = filter_input(INPUT_POST,'date2', FILTER_SANITIZE_STRING);
$endereço = filter_input(INPUT_POST,'endereço', FILTER_SANITIZE_STRING);
$cidade = filter_input(INPUT_POST,'cidade', FILTER_SANITIZE_STRING);
$telefone = filter_input(INPUT_POST,'telefone', FILTER_SANITIZE_NUMBER_INT);
$email = filter_input(INPUT_POST,'email', FILTER_SANITIZE_EMAIL);
$profissao = filter_input(INPUT_POST,'profissao', FILTER_SANITIZE_STRING);
$horario = filter_input(INPUT_POST,'horario', FILTER_SANITIZE_STRING);



//echo "Nome: $nome <br>";
//echo "Sexo: $sexo <br>";
//echo "CPF: $cpf <br>";
//echo "Data de Nascimento: $datanasc <br>";
//echo "Endereço: $endereço <br>";
//echo "Cidade: $cidade <br>";
//echo "Telefone: $telefone <br>";
//echo "E-mail: $email <br>";
//echo "Profissão: $profissao <br>";
//echo "Disponibilidade de horario: $horario <br>";

//<!--após INSERT INTO colocar o nome da tabela contida no banco de dados-->

$result_voluntario_apoio = "INSERT INTO voluntario_apoio (`Nome`, `Sexo`, `CPF`, `Data de nascimento`, `Endereço`, `Cidade`, `Telefone`, `Email`, `Profissão`, `Disponibilidade`) VALUES ('$nome', '$sexo', '$cpf', '$datanasc', '$endereço', '$cidade', '$telefone', '$email', '$profissao', '$horario')";
$resultado_voluntario_apoio = mysqli_query($conn, $result_voluntario_apoio);
//echo "Resultado: " . $resultado_voluntario_apoio . " - Query: ". $result_voluntario_apoio;
if(!$resultado_voluntario_apoio){
	echo "Erro: " . mysqli_error($conn);
}


if(mysqli_insert_id($conn)){
	header("Location: voluntario_apoio.php");
}else{
	header("Location: voluntario_apoio.php");
}

$conn->close();
