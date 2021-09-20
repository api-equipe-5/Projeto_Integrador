<!DOCTYPE html>
<html lang="pt-br">
<head>
   <?php include('cabecalho.php');?>
   <title>Área Restrita</title>
</head>
<body>
  <?php include('navbar.php');?>
    <section class="newsletter container bg-black">
      <div class="page-header">
        <div class="alert alert-info" role="alert">
          <div style='text-align:center'>
          <h2 class="text-primary"> <b> Área Restrita </b></h2>
          <br>
        </div>
      </div>
      <br />
      <br />
      <div style='text-align:center'>
        <h3 class="text-success"><b> Login </b></h3>
            <form class="form-inline" action="autenticado_usuario.php" method="POST" >
              <input class="form-control" type="email" name="email" style="min-width:100%;" placeholder="Login" value="<?php echo @$_SESSION['email']?>" ><br>
              <br/>
              <input class="form-control" type="password" name="senha" style="min-width:100%;" placeholder="Sua senha" value="<?php echo @$_SESSION['senha']?>" ><br>
              <br/>
              <button class="btn-success btn-block btn-lg"> Entrar </button>
            </form>
      </div>
    </section>
    <br />
  <?php include('rodape.php');?>
</body>
</html>