<?php

include("conexao.php");

$nome = filter_input(INPUT_POST,'nome', FILTER_SANITIZE_STRING);
$sexo = filter_input(INPUT_POST,'sexo', FILTER_SANITIZE_STRING);
$cpf = filter_input(INPUT_POST,'cpf', FILTER_SANITIZE_STRING);
$date = filter_input(INPUT_POST,'date', FILTER_SANITIZE_STRING);
$endereço = filter_input(INPUT_POST,'endereço', FILTER_SANITIZE_STRING);
$cidade = filter_input(INPUT_POST,'cidade', FILTER_SANITIZE_STRING);
$telefone = filter_input(INPUT_POST,'telefone', FILTER_SANITIZE_NUMBER_INT);
$email = filter_input(INPUT_POST,'email', FILTER_SANITIZE_EMAIL);
$horario = filter_input(INPUT_POST,'horario', FILTER_SANITIZE_STRING);
$especializacao = filter_input(INPUT_POST,'especializacao', FILTER_SANITIZE_STRING);
$proj = filter_input(INPUT_POST,'projeto', FILTER_SANITIZE_STRING);
$projdescrição = filter_input(INPUT_POST,'projdescricao', FILTER_SANITIZE_STRING);

//echo "Nome: $nome <br>";
//echo "Sexo: $sexo <br>";
//echo "CPF: $cpf <br>";
//echo "Data de Nascimento: $datanasc <br>";
//echo "Endereço: $endereço <br>";
//echo "Cidade: $cidade <br>";
//echo "Telefone: $telefone <br>";
//echo "E-mail: $email <br>";
//echo "Disponibilidade: $horario <br>";
//echo "Especialização: $especializacao <br>";

//<!--após INSERT INTO colocar o nome da tabela contida no banco de dados-->

$result_voluntario_especifico = "INSERT INTO voluntario_especifico (`Nome`, `Sexo`, `CPF`, `Data Nascimento`, `Endereço`, `Cidade`, `Telefone`, `Email`, `Disponibilidade`, `Especialização`) VALUES ('$nome', '$sexo', '$cpf', '$date', '$endereço', '$cidade', '$telefone', '$email', '$horario', '$especializacao')";
$resultado_voluntario_especifico = mysqli_query($conn, $result_voluntario_especifico);
//echo "Resultado: " . $resultado_voluntario_especcifico . " - Query: ". $result_voluntario_especifico;

$result_projetos = "INSERT INTO projetos (`Nome`, `Telefone`, `Email`, `Especialização`,`Projeto`,`Descrição do Projeto`) VALUES ('$nome', '$telefone', '$email', '$especializacao','$proj','$projdescrição')";
$resultado_projetos = mysqli_query($conn, $result_projetos);
//echo "Resultado: " . $resultado_projetos . " - Query: ". $result_projetos;


//<!--O código abaixo faz a página limpar os dados do formulário e abrir ela de novo-->
if(!$resultado_voluntario_especifico){
	echo "Erro: " . mysqli_error($conn);
}

if(!$resultado_projetos){
	echo "Erro: " . mysqli_error($conn);
}

if(mysqli_insert_id($conn)){
	header("Location: voluntario_especifico.php");
}else{
	header("Location: voluntario_especifico.php");
}

$conn->close();