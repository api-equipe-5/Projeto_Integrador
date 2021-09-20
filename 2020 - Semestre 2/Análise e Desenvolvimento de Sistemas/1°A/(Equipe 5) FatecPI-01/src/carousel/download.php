<?php

include('conexao.php');

// $id = $_REQUEST['id'];
// <a href="download.php?id='.$row_usuario["id"].'" class="social-info"> colocar isso aqui na página do produto (para passar o id do produto)
$id = $_REQUEST['id'];
$result_produtos = "SELECT * FROM arquivos WHERE id = $id";
$resultado_produtos = mysqli_query($conexao, $result_produtos);
$infos_produto = mysqli_fetch_assoc($resultado_produtos);

//  if (isset($_GET['file']) and (isset($_GET['nome']) and isset($_GET['tipo'])){

    // $file = "".$_GET['file'];
    // $nome = $_GET['nome'];
    // $tipo = $_GET ['tipo'];

    $nome = $infos_produto['nome_arquivo'];
    $tipo = $infos_produto['extensao_arquivo'];
    $file = 'add-product/add-product/' . $infos_produto['caminho']; // teste

    function setHeaders ($nome, $file, $tipo){
        header ("content-disposition: attachment; filename={$nome}");
        header ("content-type: application/{$tipo}");
        readfile($file);
    }
    

 setHeaders($nome, $file, $tipo);

//  }
?>