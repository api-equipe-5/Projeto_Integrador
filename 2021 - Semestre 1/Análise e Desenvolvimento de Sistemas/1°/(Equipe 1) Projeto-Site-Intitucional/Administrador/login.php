<?php
    /*Verifca se email e password estão atribuídos ao POST, caso não esteja retorna string vazia*/
    $email = isset($_POST['email']) ? $_POST['email'] : "";
    $password = isset($_POST['password']) ? $_POST['password'] : "";
    if ($email) {
        $validated = FALSE;
        $conection = mysqli_connect("localhost", "root", "", "bd_admin");
        $prepared = mysqli_prepare($conection, "select email, name from tb_user where email = ? and password = ?"); //prepara o BD para receber os dados do input(email e senha)
        mysqli_stmt_bind_param($prepared, "ss", $email, $password); // envia os dados dos 'filtros'
        $result = mysqli_stmt_execute($prepared); // aplica o 'filtro'  

        mysqli_stmt_store_result($prepared); //traz os metadados da consulta

        $result_count = mysqli_stmt_num_rows($prepared); //quantas linhas a consulta retornou

        if (!$result || $result_count == '0') { // verifica se houve erro na execução do comando ou se não localizou o e-mail e a senha
            $validated = FALSE;
        }
        else {
            mysqli_stmt_bind_result($prepared, $result_email, $result_name); //associa as variáveis com os campos do select
            mysqli_stmt_fetch($prepared); //traz o resultado para as variáveis acima
            $validated = TRUE;
            session_start();
            $_SESSION['name'] = $result_name; 
            $_SESSION['email'] = $result_email; //As sessions verifica se o usuário está logado.

            header('Location: /Projeto-Site-Intitucional/Administrador/index.php'); //redireciona para a página home
        }

        if (!$validated) {
            $message = "Email e/ou senha inválido(s)!";
        }

    }
    $logout = isset($_POST['logout']) ? $_POST['logout'] : "False";

    if ($logout == 'True'){
        session_start();
        session_destroy();
    }
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/login_admin.css">
    <link rel="icon" href="../Home/imagem/Vó-logo.png">

    <title>Controle de acesso</title>

</head>
<body>

    <form class="form" action="./login.php" method="POST">
        <div class="card">
            <div class="card-top">
                <img class="imglogin" src="imagens/person-icon.png" alt="Imagem de usuário">
                <h2 class="title">Painel de controle</h2>
                <p>Gerenciador do site</p>
            </div>

            <div class="card-group">
                <label>Email</label>
                <input type="email" name="email" placeholder="Digite seu email" required>
            </div>

            <div class="card-group">
                <label>Senha</label>
                <input type="password" name="password" placeholder="Digite sua senha" required>
            </div>

            <div class="card-group">            
                <?php 
                if (isset($message)){
                     echo "<p><strong>$message</strong></p>";
                }
                   
                ?>
            </div>


            <div class="card-group btn">
                <button type="submit">ACESSAR</button>
            </div>

        </div>
    </form>
    
</body>
</html>