<?php
//arquivo da função do formulário de cadastro
session_start();
//conexão com o banco de dados do arquivo conexao.php
include_once("conexao_login.php");

//cria as variáveis login e senha a partir do preenchimento dos formulários
$cpf = $_POST['cpf'];
$senha = $_POST['senha'];
$query_select = "SELECT cpf FROM usuarios WHERE cpf = '$cpf'";

//verifica se o nome de usuario já existe, se for o caso, mostra msg de erro
$sql = $conexao->query("SELECT cpf FROM usuarios WHERE cpf ='$cpf'");
if(mysqli_num_rows($sql) != 0){
echo "Este CPF já foi cadastrado.";
exit();
} else {
//se nome de usuario ainda não existe, cria o cadastro e grava no banco de dados
$result_usuario = "INSERT INTO usuarios(cpf , senha) VALUES ('$cpf','$senha')";
    $resultado_usuario = mysqli_query($conexao, $result_usuario);
    
    if(mysqli_affected_rows($conexao) != 0){
                echo "Usuario cadastrado com Sucesso.";    
            }else{
                echo "O Usuario não foi cadastrado com Sucesso.";    
            }
        }
?>

<a href="index.php">Voltar para Página Inicial</a>
