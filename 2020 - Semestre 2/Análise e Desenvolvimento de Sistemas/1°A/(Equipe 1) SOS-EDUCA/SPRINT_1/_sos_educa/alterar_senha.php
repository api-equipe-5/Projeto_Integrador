<?php
 session_start();
  include("conexao.php");
  if (isset($_SESSION)){
    if(isset($_SESSION['id_cliente'])){
      $idCliente = intval($_SESSION['id_cliente']);
    }else{
      $idCliente = '';
    }
    $senha_nova=$_POST['senha_nova'];
    $confirmar_senha=$_POST['confirmar_senha'];
    
    
    if($senha_nova==$confirmar_senha){
      $result = "UPDATE cliente SET senha = $senha_nova WHERE id_cliente =  '$idCliente'";
      print_r($result);
      $query = $conexao->prepare($result);
       if($query->execute()){
               echo "<script language='javascript' type='text/javascript'>
                alert('Senha alterada com sucesso!');window.location.href='alterarsenha_cliente.php';
                  </script>";
          }else{
            echo "<script language='javascript' type='text/javascript'>
                    alert('As senhas não conferem, tente novamente!');window.location.href='alterar_senha.php';
                  </script>";
          }
      }
    }
		mysqli_close($conexao);
?>

