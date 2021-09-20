<?php
    session_start();
    include ('conexao.php');

    if (empty( $_POST ['email']) || empty ($_POST['password'])) {
        header ('Location:index.php');
        exit();
    } 

    $email = mysqli_real_escape_string($conexao, $_POST['email']);
    $senha = mysqli_real_escape_string($conexao,$_POST['password']);

    $query = "select * from usuario where email = '$email' and senha = md5 ('$senha')";
    $result = mysqli_query ($conexao, $query);
    $row = mysqli_num_rows ($result);
    $user = mysqli_fetch_assoc($result);

    if ($row == 1){
        $_SESSION['email'] = $email;
        $_SESSION['senha'] = $senha;
        $_SESSION['tipo_usuario'] = $user['tipo_usuario'];
        $_SESSION['nome'] = $user['nome'];
        $_SESSION['nickname'] = $user['nickname'];

        header ('Location: produtos.php');
        exit ();
    }
    else {  
        header ('Location: logar.php');
        exit ();
    }
?>