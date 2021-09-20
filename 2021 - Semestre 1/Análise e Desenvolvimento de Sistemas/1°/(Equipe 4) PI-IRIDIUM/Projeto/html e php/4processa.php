 <!-- processa do doacao anonima -->
 <?php

session_start();
include_once("3conexao.php");

$tquantity = filter_input(INPUT_POST, 'tquantity', FILTER_SANITIZE_STRING);


$result_usuario = "INSERT INTO anonima (contribuicao, created) VALUES ('$tquantity', NOW())";
$rresultado_usuario = mysqli_query($conn, $result_usuario);

if(mysqli_insert_id($conn)){
   header("Location: forma-de-pagamento.html");
} else {
   $_SESSION['msg'] = "<p style='color:red;'>O Voluntário não foi cadastrado com sucesso</p>";
   header("Location: doacao-anonima.php");
}