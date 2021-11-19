<!DOCTYPE html>
<html lang="pt-br">
<head>
    <?php include("cabecalho.php") ?>
    <title>Editar produto</title>
</head>
<body>
  <?php
    include("conexao.php"); 
    include('navbar.php');
  ?>
  <section class="newsletter container bg-black">
    <h2 class="alert-info">Alterar Informações dos Produtos </h2>
      <form class="form-horizontal" name="form_alterar" method="POST" action="alterar_2.php">
        <?php
          $idAlt=$_GET['id'];
          $resultado=mysqli_query($conexao, "SELECT * FROM produtos where id_produto='$idAlt'");
          if($resultado){
            while($row=mysqli_fetch_assoc($resultado)){
        ?>
              <input class="input-sm" readonly="true" type="hidden" id="id_prod" name="id_produto" value="<?php echo $row['id_produto']; ?>" />
              <br />
              <input class="input-sm" type="text" id="nome_prod" name="nome_prod" value="<?php echo $row['nome_prod']; ?>" size="30" />
              <br />
              <input class="input-sm" type="text" id="preco" name="preco" value="<?php echo $row['preco']; ?>" size="25" />
     
              <br />
          <?php
            } //fim while
          }//fim if
          ?>
        <input type="submit" class="btn-danger" name="alterar" value="Alterar" />
      </form>
  </section>
  <?php mysqli_close($conexao); ?>
  <?php include('rodape.php');?>
</body>
</html>