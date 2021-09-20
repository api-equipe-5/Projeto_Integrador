<?php
// Arquivo responsável por conectar a nossa base de dados
$hostname_conn = "localhost";
$database_conn = "meuBanco";
$username_conn = "root";
$password_conn = "";

$conn = mysqli_connect ($hostname_conn,$username_conn,$password_conn,"meuBanco"); 

// Conectamos ao nosso servidor MySQL
if(!$conn) 
{
   echo "Erro ao conectar ao MySQL." . mysqli_connect_error();
   exit; 
   
}
//----------------------------------------------------------------
// ATÉ AQUI OK
//---------------------------------------------------------------
/* Selecionamos nossa base de dados MySQL
if(!($conn = mysqli_select_db($database_conn,$conn))) 
{
   echo "Erro ao selecionar ao MySQL.";
   exit;
}*/
?>