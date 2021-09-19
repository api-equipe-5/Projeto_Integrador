<?php
//esse arquivo é uma função que verifica se não está em uma sessão, encaminha pra página de login
session_start();
if(!$_SESSION['cpf']) {
    header('Location: pag_login.php');
    exit();
}
?>