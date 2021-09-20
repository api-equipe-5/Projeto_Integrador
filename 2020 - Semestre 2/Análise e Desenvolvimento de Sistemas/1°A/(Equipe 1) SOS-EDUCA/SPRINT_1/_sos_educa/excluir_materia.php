<?php


    session_start(); 
    include("conexao.php");
    include('cabecalho.php');
  
    $id = $_GET['id'];
    
    mysqli_query($conexao, ("DELETE FROM categorias WHERE id_cat ='$id' "));
   
    
    echo '<meta charset=UTF-8>
    <script> alert("Matéria excluída")</script>';
    echo "<script>
            window.location=\"admin_produto.php\"
          </script>";
    mysqli_close($conexao);
    
?>

