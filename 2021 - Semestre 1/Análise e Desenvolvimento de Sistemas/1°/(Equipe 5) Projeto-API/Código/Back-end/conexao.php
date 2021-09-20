<?php

$host = "localhost";
$user = "root";
$pass = "";
$dbname = "celke";
$port = 3306;

//Conexao com a porta
$conn = new PDO("mysql:host=$host;port=$port;dbname=".$dbname, $user, $pass);

//Conexao sem a porta
//$conn = new PDO("mysql:host=$host;dbname=".$dbname, $user, $pass);

