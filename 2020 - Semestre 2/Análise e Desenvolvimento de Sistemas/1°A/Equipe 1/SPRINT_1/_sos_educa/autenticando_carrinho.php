<!DOCTYPE html>
<html lang="pt-br">
<?php include('cabecalho.php');?>
<body>
  <script type="text/javascript">
    function loginsuccessfully(){
      setTimeout("window.location='logout_carrinho.php'",5000);
    }
    function loginfailed() {
          setTimeout("window.location='login_carrinho.php'",5000);
    }
  </script>
  <?php
    include("conexao.php");
    $usuario = $_POST['usuario'];
    $senha = $_POST['senha'];
    $query = mysqli_query($conexao, "SELECT * FROM cliente where email='$usuario' and senha='$senha'");
    $row=mysqli_num_rows($query);

    if ($row > 0) {
        session_start();
        $_SESSION['usuario']=$_POST['usuario'];
        $_SESSION['senha']=$_POST['senha'];

        $ass = mysqli_fetch_assoc($query);
        $_SESSION['id_cliente'] = $ass['id_cliente'];
        $_SESSION['id_cliente'] = $ass['id_cliente'];
        $_SESSION['nome_cliente'] = $ass['nome'];

        echo "<h1 class='alert-success'><i><center><b>Você foi autenticado com sucesso! Aguarde um instante.</b></center></i></h1>";
        echo "<script>loginsuccessfully()</script>";
        echo "<br><br><center><img src='imagens/ajax_load.gif'></center>";

    }else{
        echo "<center><h1 class='alert-danger'><b>Campo Usuário e/ou senha inválido! Aguade um instante para tentar novamente.</h1></b></center>";
        echo "<script>loginfailed()</script>";
        echo "<br><br><center><img src='imagens/ajax_load.gif'></center>";
    }
  ?>
  <?php include('rodape.php');?>
</body>
</html>