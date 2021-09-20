<?php

include_once("conexao_cad_proj.php");
$nomeproj = filter_input (INPUT_POST, 'nomeproj', FILTER_SANITIZE_STRING);
$descricaoproj = filter_input (INPUT_POST, 'messageproj', FILTER_SANITIZE_STRING);
$transf_proj = "INSERT INTO sugestaoproj (Nome_do_Projeto, Descricao, Adicionado_em) VALUES ('$nomeproj', '$descricaoproj', NOW() )";
$transferido_proj = mysqli_query($conn, $transf_proj);
if (mysqli_insert_id($conn)){ header("Location: envio de projeto.html");} else{header("Location: envio de projeto.html");}

?>