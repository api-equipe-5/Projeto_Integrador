<?php
/* esse arquivo é da função de login, que vai pegar o usuario e senha do primeiro formulario, 
comparar com o banco de dados e se for um usuario e senha válidos, inicia a sessão */
session_start();
//proxima linha é o link com o banco de dados que tá no arquivo conexao.php
include_once("conexao_login.php");

//aqui é uma condição que se um dos campos estiver vazio, ele volta pro formulário até que entre com dados válidos
if(empty($_POST['cpf']) || empty($_POST['senha'])) {
    header('Location: pag_login.php');
    exit();
}

//cria as variáveis a partir das informações preenchidas pelo usuário
$cpf = mysqli_real_escape_string($conexao, $_POST['cpf']);
$senha = mysqli_real_escape_string($conexao, $_POST['senha']);

//busca no banco de dados se os dados preenchidos já existem
$query = "SELECT ID, cpf, senha FROM usuarios WHERE cpf = '{$cpf}' AND senha = '{$senha}' ";

$result = mysqli_query($conexao, $query);
//o resultado da busca vai retornar 1 linha (row) se der match ou 0 linha se não achou aquele cadastro
$row = mysqli_num_rows($result);

//se o numero de linhas = 1, inicia a sessão daquele usuário e direciona para outra página qualquer (a decidir)
//se não for = 1, não inicia sessão de usuário (fica na sessão 'nao_autenticado') e retorna pro formulário em branco
if($row == 1) {
    $_SESSION['cpf'] = $cpf;
    header('Location: index.php');
    exit();
} else {
    $_SESSION['nao_autenticado'] = true;
    header('Location: pag_login.php');
    exit();
}


?>