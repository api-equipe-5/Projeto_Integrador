<?php session_start(); ?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
   <?php include('cabecalho.php');?>
   <title>Login Cliente</title>
</head>
<body>
  <?php include('navbar.php');?>
    <section class="newsletter container bg-black">
      <div class="page-header">
        <div class="alert alert-info" role="alert">
          <div style='text-align:center'>
          <h2 class="text-primary"> <b> Login Cliente </b></h2>
          <br>
        </div>
      </div>
        </div>
      </div>    
    <form  class="form-group" action="autenticando_clientes_geral.php" method="POST" >
      <input class="input-group" type="text"  name="usuario" value="<?php echo @$_SESSION['usuario']?>"  placeholder="Digite seu Email"/><br>
      <input  class="input-group" type="password" name="senha" <?= @$_SESSION['senha'] ? 'autofocus' : '' ?>  maxlength="8" placeholder="Digite sua senha" />
      <br />
      <input type="submit" class="btn-success" value="Entrar" >
    </form>     
  </div>
  <?php include('rodape.php');?> 
</body>
</html>