  <?php
    $email = isset($_POST['email']) ? $_POST['email'] : "";
    $password = isset($_POST['password']) ? $_POST['password'] : "";
    if ($email) {
        $validated = FALSE;
        $conection = mysqli_connect("localhost", "root", "", "vomariafelix");
        $prepared = mysqli_prepare($conection, "select email, name from admin where email = ? and password = ?");
        mysqli_stmt_bind_param($prepared, "ss", $email, $password);
        $result = mysqli_stmt_execute($prepared);

        mysqli_stmt_store_result($prepared);

        $result_count = mysqli_stmt_num_rows($prepared);

        if (!$result || $result_count == '0') {
            $validated = FALSE;
        }
        else {
            mysqli_stmt_bind_result($prepared, $result_email, $result_name);
            mysqli_stmt_fetch($prepared);
            $validated = TRUE;
            session_start();
            $_SESSION['name'] = $result_name; 
            $_SESSION['email'] = $result_email;

            header('Location: index.php');
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
	<title>Login ADM</title>
    <link rel="stylesheet" href="./css/login_admin.css">
    <link rel="icon" href="../favicon.ico">
</head>
<body>
    <form class="form" action="login.php" method="POST">
        <div class="card">
            <div class="card-top">
                <img class="imglogin" src="imagens/pss.png" alt="Imagem de usuário">
                <h2 class="title">Painel de controle</h2>
                <p>Gerenciador do site</p>
            </div>

            <div class="card-group">
                <label>E-mail</label>
                <input type="email" name="email" placeholder="Digite seu e-mail" required>
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
			<br>
            <div class="card-group">
            <button type="submit">ACESSAR</button>
            </div>
			<br>
			<br>
			<br>

        </div>
    </form>
    
</body>
</html>