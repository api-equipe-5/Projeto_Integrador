<?php 
// processa do voluntarios
session_start();
include_once("conexao.php");

$vvoluntario = filter_input(INPUT_POST, 'vvoluntario', FILTER_SANITIZE_STRING);
$vnome = filter_input(INPUT_POST, 'vnome', FILTER_SANITIZE_STRING);
$vcpf = filter_input(INPUT_POST, 'vcpf', FILTER_SANITIZE_STRING);
$vemail = filter_input(INPUT_POST, 'vemail', FILTER_SANITIZE_STRING);
$vcontribuicao = filter_input(INPUT_POST, 'vcontribuicao', FILTER_SANITIZE_STRING);

$result_usuario = "INSERT INTO 	voluntario (tipodevoluntario, nome, cpf, email, contribuicao, created) VALUES ('$vvoluntario', '$vnome', '$vcpf', '$vemail', '$vcontribuicao', NOW())";
$resultado_usuario = mysqli_query($conn, $result_usuario);

 if(mysqli_insert_id($conn)){
     $_SESSION['msg'] = "<p style='color:green;'>Voluntário cadastrado com sucesso</p>";
    header("Location: voluntarios.PHP");
} else {
    $_SESSION['msg'] = "<p style='color:red;'>O Voluntário não foi cadastrado com sucesso</p>";
}

?>