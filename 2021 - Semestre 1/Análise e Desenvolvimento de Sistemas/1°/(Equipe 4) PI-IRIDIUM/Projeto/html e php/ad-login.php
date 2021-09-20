<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/login.css" rel="stylesheet">
    <title>Login</title>

</head>

<body>
    
    <form class="form" method="POST" action="ad-login-sistema.php">
        <div class="card">
            <div class="card-top">
                <img class="imglogin" src="imagens/logo.jpeg" alt="">
                <h2 class="titulo">Área de Administração</h2>
            </div>

            <div class="card-group">
                <label>Email</label>
                <input type="email" name="usuario" placeholder="Digite seu email" required>
            </div>

            <div class="card-group">
                <label>Senha</label>
                <input type="password" name="senha" placeholder="Digite sua senha" required>
            </div>

            <div class="card-group">
                <button type="submit">Acessar</button>
            </div>

        </div>
    </form>

</body>
</html>