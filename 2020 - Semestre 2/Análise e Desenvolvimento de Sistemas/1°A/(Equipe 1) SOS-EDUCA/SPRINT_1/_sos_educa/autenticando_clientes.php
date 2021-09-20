<!DOCTYPE html>
<html lang="pt-br">
<head>
  <?php include('cabecalho.php');?>
  <?php session_start(); ?>
  <title>Autenticando...</title>
</head>
<body>
  <?php include('navbar.php');?>
    <script type="text/javascript">
      function loginsuccessfully(){
        setTimeout("window.location='forma_pagamento.php'",5000);
      }
      function loginfailed() {
              setTimeout("window.location='login_clientes.php'",5000);
      }
    </script>
    <?php include("conexao.php");
      $usuario = $_POST['usuario'];
      $senha = $_POST['senha'];
      $query = mysqli_query($conexao, "SELECT * FROM cliente where email='$usuario' and senha='$senha'");
      $row=mysqli_num_rows($query);

      if ($row > 0) {
          
          $_SESSION['usuario']=$_POST['usuario'];
          $_SESSION['senha']=$_POST['senha'];

          $ass = mysqli_fetch_assoc($query);
          $_SESSION['id_cliente'] = $ass['id_cliente'];
          $_SESSION['id_cliente'] = $ass['id_cliente'];
          $_SESSION['nome_cliente'] = $ass['nome'];
        
          echo "<h1 class='alert-success'><i><center><b>Você foi autenticado com sucesso! Aguarde um instante.</b></center></i>";
          echo "<script>loginsuccessfully()</script><h1>";
          echo "<br><br><center><img src='imagens/ajax_load.gif'></center>";

      }else{
          echo "<h1 class='alert-danger'><i><center><b>Campo Usuário e/ou senha inválido! Aguarde um instante para tentar novamente.</b></center></i><h1>";
          echo "<script>loginfailed()</script>";
          echo "<br><br><center><img src='imagens/ajax_load.gif'></center>";
      }
    ?>
    <?php include('rodape.php');?>
</body>
</html>