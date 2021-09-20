<?php
include ('conexao.php');

$email = mysqli_real_escape_string ($conexao, trim($_POST['email']));
$senha = mysqli_real_escape_string ($conexao, trim(md5($_POST['password'])));
$nome = mysqli_real_escape_string  ($conexao, trim($_POST['name']));
$usuario = mysqli_real_escape_string ($conexao, trim($_POST['nickname']));
$senhaconfirm = mysqli_real_escape_string ($conexao, trim(md5($_POST['confirm_password'])));


$sql = "select * from usuario where email = '$email'";
$result = mysqli_query($conexao, $sql);
$row = mysqli_fetch_assoc($result);

if($row == 1) {
    $_SESSION['usuario_existente'] = true;
    header ('Location: cadastro.php');
    exit;
}

if ($senha === $senhaconfirm){
    $sql = "INSERT INTO usuario (email, senha, nome, nickname, tipo_usuario) VALUES ('$email','$senha','$nome','$usuario', 'user')";

    if ($conexao->query($sql) === true) {
        $_SESSION ['status_cadastro'] = true;
        header ('Location: logar.php');
        exit;
    }

    $conexao->close();
}
else {
    $_SESSION ['status_senha'] = true; 
    header('Location: cadastro.php');
    exit;
}
?>