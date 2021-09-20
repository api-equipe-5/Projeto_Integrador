<!DOCTYPE html>
<html lang="pt-br">
<head>
  <title>Efetuando Cadastro</title>
  <?php session_start() ?>
  <script type="text/javascript">
    function loginRedirect(destination) {
      if (!destination) {
        destination = 'admin_index'
      }
      
      setTimeout(function() {
        window.location.href = destination + ".php";
      })
    }
  </script>
</head>
<body>
  <?php include("conexao.php");

  $nome_func = $_POST['nome_func'];
  $login_func = $_POST['login_func'];
  $senha_func = $_POST['senha_func'];
 
  $_SESSION['nome_func'] = $nome_func;
  $_SESSION['login_func'] = $login_func;
  $_SESSION['senha_func'] = $senha_func;

  

  $query = "SELECT email, cpf FROM cliente";
  $sql = mysqli_query($conexao, $query);
  $data = mysqli_fetch_all($sql, MYSQLI_ASSOC);

      $insert = "
        INSERT INTO admin (nome_func, login_func, senha_func)
        VALUES ('$nome_func','$login_func','$senha_func')
      ";
      $_SESSION['nome_cliente'] = $nome;

      if (mysqli_query($conexao,$insert) or die(mysqli_error($conexao))) {
        unset(
            $_SESSION['nome_func'],
            $_SESSION['login_func'],
            $_SESSION['senha_func']

        );

        echo "<center><h1><i>Cadastrado com sucesso</i></h1></center>";
        ?>
          <script>
            loginRedirect("<?php echo (isset($_POST['goto']) && $_POST['goto'] === 'admin_contas') ? 'admin_contas' : 'admin_contas' ?>");
          </script>
    <?php
      }
    
    ?>  
</body>
</html>
