<?php

$servidor= "localhost";
$usuario = "root";
$senha= "";
$dbname = "vomariafelix";

try {
    $conn = new PDO("mysql:dbname=" . $dbname,$usuario,$senha);
//* echo "Conexão OK";
   } catch (Exception $ex){
//*   echo "Conexão NOK"; Teste da conexão com o banco de dados
}

?>