<?php
//session_start();
include('verifica_login.php');
//essa página é só de exemplo pra ver se o login deu certo, quando estiver tudo ok mandar esses códigos para a home
?>

<?php
//exibir o nome do usuario (ver onde incluir no html)
echo $_SESSION['cpf'];
?>

<a href="logout.php">Sair</a>