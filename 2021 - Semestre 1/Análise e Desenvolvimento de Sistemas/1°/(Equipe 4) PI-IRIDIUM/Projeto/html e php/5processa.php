 <!-- processa do participante -->
 <?php

session_start();
include_once("4conexao.php");

$tVoluntario = filter_input(INPUT_POST, 'tVoluntario', FILTER_SANITIZE_STRING);
$tcpf = filter_input(INPUT_POST, 'tcpf', FILTER_SANITIZE_STRING);
$tEmail = filter_input(INPUT_POST, 'tEmail', FILTER_SANITIZE_STRING);
$tProjeto = filter_input(INPUT_POST, 'tProjeto', FILTER_SANITIZE_STRING);
$tEnsino = filter_input(INPUT_POST, 'tEnsino', FILTER_SANITIZE_STRING);
$tlocal = filter_input(INPUT_POST, 'tlocal', FILTER_SANITIZE_STRING);
$ttransporte = filter_input(INPUT_POST, 'ttransporte', FILTER_SANITIZE_STRING);


// echo "Nome: $responsavel <br>";

$result_usuario = "INSERT INTO projeto (voluntario, cpf, email, projeto, atividade, llocal, transporte, created) VALUES ('$tVoluntario', '$tcpf', '$tEmail', '$tProjeto', '$tEnsino', '$tlocal', '$ttransporte', NOW())";
$rresultado_usuario = mysqli_query($conn, $result_usuario);

if(mysqli_insert_id($conn)){
    $_SESSION['msg'] = "<p style='color:green;'>Voluntário cadastrado com sucesso</p>";
   header("Location: projetos.php");
} else {
   $_SESSION['msg'] = "<p style='color:red;'>O Voluntário não foi cadastrado com sucesso</p>";
   header("Location: projetos.php");
}