<?php
    session_start(); 
    include("conexao.php");
    include('cabecalho.php');

    $id = $_GET['id'];
    mysqli_query($conexao, ("DELETE FROM produtos WHERE id_produto ='$id' "));
    echo '<meta charset=UTF-8>
    <script> alert("Produto excluído")</script>';
    echo "<script>
            window.location=\"admin_produto.php\"
          </script>";
    mysqli_close($conexao);
    
?>