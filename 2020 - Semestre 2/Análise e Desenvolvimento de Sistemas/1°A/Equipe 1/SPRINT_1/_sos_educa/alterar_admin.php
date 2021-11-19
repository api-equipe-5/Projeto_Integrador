<?php
	session_start();
	include("conexao.php");
	if (isset($_SESSION)){
		if(isset($_SESSION['id_func'])){
		  $id_func = intval($_SESSION['id_func']);
		}else{
		  $id_func = '';
		}
		$login_func_new=$_POST['login_func_new'];
		$senha_func_new=$_POST['senha_func_new'];
		$senha_func_confirmar=$_POST['senha_func_confirmar'];
		
        if($senha_func_new==$senha_func_confirmar){
		$result = "UPDATE cliente SET login_func ='$login_func_new', senha_func ='$senha_func_new', WHERE id_func = '$id_func'";
      
	
		$query = $conexao->prepare($result);
    	if($query->execute()){
               echo "<script language='javascript' type='text/javascript'>
                alert('Cadastro alterado com Sucesso!');window.location.href='admin_contas.php';
                  </script>";
          }else{
            echo "<script language='javascript' type='text/javascript'>
                    alert('Alteração inválida, tente novamente!!');window.location.href='admin_contas.php';
                  </script>";
          }
	}
        mysqli_close($conexao);
?>