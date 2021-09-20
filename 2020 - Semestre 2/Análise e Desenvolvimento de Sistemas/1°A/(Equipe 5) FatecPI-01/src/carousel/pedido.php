<?php
session_start();
include ('conexao.php');



$email_usuario = $_SESSION['email'];
$titulo = $_POST['titulo'];
$numero = $_POST['numero'];
$validade = $_POST['validade'];
$cvv = $_POST['cvv'];
$saldo = $_POST['saldo'];




if ($metodopag == "credito" && $saldo >= $preco) {
	$parcelas = 0;
	$result_contato = "INSERT INTO credito (email_usuario, titulo, numero, validade, cvv, saldo) VALUES ('$email_usuario', '$titulo', '$numero', '$validade', '$cvv', '$saldo')";
}
else {
	echo ('você não tem saldo suficiente');
}

if ($conexao->query($result_contato) == TRUE && $metodopag=="credito") {
	$id_pedido = mysqli_insert_id($conexao);
     header("Location: pagcartao.php?id=$id_pedido");
 }
 else{
 	$id_pedido = mysqli_insert_id($conexao);
     header("Location: pagboleto.php?id=$id_pedido");
}
?>