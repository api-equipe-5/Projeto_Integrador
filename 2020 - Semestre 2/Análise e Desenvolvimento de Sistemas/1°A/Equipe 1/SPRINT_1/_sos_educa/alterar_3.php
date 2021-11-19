<?php
	session_start();
	include("conexao.php");
	if (isset($_SESSION)){
		if(isset($_SESSION['id_cliente'])){
		  $idCliente = intval($_SESSION['id_cliente']);
		}else{
		  $idCliente = '';
		}
		$cep=$_POST['cep'];
		$bairro=$_POST['bairro'];
		$rua=$_POST['rua'];
		$cidade=$_POST['cidade'];
		$estado=$_POST['estado'];		
		$num_casa=$_POST['num_casa'];
		$telefone=$_POST['telefone'];
		$email=$_POST['email'];

		$result = "UPDATE cliente SET cep ='$cep', rua ='$rua', cidade ='$cidade', estado ='$estado', bairro ='$bairro', num_casa = '$num_casa', telefone = '$telefone', email = '$email' WHERE id_cliente = '$idCliente'";
      
	
		$query = $conexao->prepare($result);
    	if($query->execute()){
               echo "<script language='javascript' type='text/javascript'>
                alert('Cadastro alterado com Sucesso!');window.location.href='alterarcadastro_cliente.php';
                  </script>";
          }else{
            echo "<script language='javascript' type='text/javascript'>
                    alert('Alteração inválida, tente novamente!!');window.location.href='alterarcadastro_cliente.php';
                  </script>";
          }
	}
        mysqli_close($conexao);
?>