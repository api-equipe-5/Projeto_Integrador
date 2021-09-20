<?php include("conexao.php");?>
<?php
  $nome_cat=$_POST['nome_cat'];

  if (isset($_POST['nome_cat'])){

  //Enviar uma query
    $cad = "INSERT INTO categorias (nome_cat)  VALUES ('$nome_cat')";
    echo $cad;
    $cadastraimg=mysqli_query($conexao, $cad);
    mysqli_close($conexao);
    echo "<script language='javascript' type='text/javascript'>
            alert('MATÉRIA CADASTRADA COM SUCESSO');window.location.href='admin_produto.php';
          </script>"; 
    echo "Inclusão efetuada com sucesso!";
    } else {
    echo "Não foi possível incluir, tente novamente";
  }
?>
