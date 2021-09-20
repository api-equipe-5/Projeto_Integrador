 <!-- processa do participante -->
 <?php

session_start();
include_once("2conexao.php");

$paname = filter_input(INPUT_POST, 'paname', FILTER_SANITIZE_STRING);
$pacpf = filter_input(INPUT_POST, 'pacpf', FILTER_SANITIZE_STRING);
$ndata = filter_input(INPUT_POST, 'ndata', FILTER_SANITIZE_STRING);
$responsavel = filter_input(INPUT_POST, 'responsavel', FILTER_SANITIZE_STRING);
$esname = filter_input(INPUT_POST, 'esname', FILTER_SANITIZE_STRING);
$cname = filter_input(INPUT_POST, 'cname', FILTER_SANITIZE_STRING);
$rname = filter_input(INPUT_POST, 'rname', FILTER_SANITIZE_STRING);
$emname = filter_input(INPUT_POST, 'emname', FILTER_SANITIZE_EMAIL);

// echo "Nome: $responsavel <br>";

$result_usuario = "INSERT INTO participante (nomedoparticipante, cpf, datadenascimento, responsavel, estado, cidade, rua, email, created) VALUES ('$paname', '$pacpf', '$ndata', '$responsavel', '$esname', '$cname', '$rname', '$emname', NOW())";
$rresultado_usuario = mysqli_query($conn, $result_usuario);

if(mysqli_insert_id($conn)){
    $_SESSION['msg'] = "<p style='color:green;'>Voluntário cadastrado com sucesso</p>";
   header("Location: participantes.php");
} else {
   $_SESSION['msg'] = "<p style='color:red;'>O Voluntário não foi cadastrado com sucesso</p>";
   header("Location: participantes.php");
}