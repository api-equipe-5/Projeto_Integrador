<!DOCTYPE html>
<html lang="pt-br">
<head>
  <title>Efetuando Cadastro</title>
  <?php session_start() ?>
  <script type="text/javascript">
    function loginRedirect(destination) {
      if (!destination) {
        destination = 'index'
      }
      
      setTimeout(function() {
        window.location.href = destination + ".php";
      })
    }
  </script>
</head>
<body>
  <?php include("conexao.php");

  $nome = $_POST['nome'];
  $cpf = $_POST['cpf'];
  $senha = $_POST['senha'];
  $rua = $_POST['rua'];
  $bairro = $_POST['bairro'];
  $cidade = $_POST['cidade'];
  $estado = $_POST['estado'];
  $num = $_POST['num_casa'];
  $telefone = $_POST['telefone'];
  $email = $_POST['email'];
  $cep=$_POST['cep'];

  $accept_terms = $_POST['accept_terms'];
  $accept_email = $_POST['accept_email'];

  $_SESSION['nome'] = $nome;
  $_SESSION['cpf'] = $cpf;
  $_SESSION['cep'] = $cep;

  $_SESSION['usuario'] = $email;
  $_SESSION['senha'] = $senha;

  $_SESSION['rua'] = $rua;
  $_SESSION['bairro'] = $bairro;
  $_SESSION['cidade'] = $cidade;
  $_SESSION['estado'] = $estado;
  $_SESSION['num_casa'] = $num;
  $_SESSION['telefone'] = $telefone;
  $_SESSION['email'] = $email;

  $query = "SELECT email, cpf FROM cliente";
  $sql = mysqli_query($conexao, $query);
  $data = mysqli_fetch_all($sql, MYSQLI_ASSOC);

  $results = [
    "cpf" => [],
    "email" => []
  ];

  foreach ($data as $value) {
    if (!in_array($value["cpf"], $results["cpf"])) {
      $results["cpf"][] = $value["cpf"];
    }
    if (!in_array($value["email"], $results["email"])) {
      $results["email"][] = $value["email"];
    }
  }

  if ($accept_terms !== 'on') {
      echo "<center><h1><b>Você precisa aceitar os termos de uso para continuar.</b></h1></center>";
  ?> 
    <script>
      loginRedirect("<?php echo isset($_POST['goback']) ? $_POST['goback'] : 'cadastro_cliente'?>");
    </script> 
    <?php
  } else if ($rua == "" || $bairro == "" || $cidade == "") {
      echo "<center><h1><b>Digite o seu  CEP</b></h1></center>";
    ?> 
    <script>
      loginRedirect("<?php echo isset($_POST['goback']) ? $_POST['goback'] : 'cadastro_cliente'?>");
    </script> 
    <?php
    } else if ($cpf == "000.000.000-00") {
      echo "<center><h1><i>CPF inválido</i></h1></center>";
    ?> 
      <script>
        loginRedirect("<?php echo isset($_POST['goback']) ? $_POST['goback'] : 'cadastro_cliente'?>");
      </script> 
    <?php
    } else if (in_array($email, $results["email"])) {
        echo "<center><h1><i>Email já cadastrado</i></h1></center>";
    ?>
      <script>
        loginRedirect("<?php echo isset($_POST['goback']) ? $_POST['goback'] : 'login_clientes'?>");
      </script>
    <?php
    } else if (in_array($cpf, $results["cpf"])) {
        echo "<center><h1><i>CPF já cadastrado</i></h1></center>";
    ?>
      <script>
        loginRedirect("<?php echo isset($_POST['goback']) ? $_POST['goback'] : 'login_clientes'?>");
      </script>
    <?php
    }else{
      $insert = "
        INSERT INTO cliente (nome, cpf, senha, cep, rua, bairro, cidade, estado, num_casa, telefone, email)
        VALUES ('$nome','$cpf','$senha','$cep','$rua','$bairro','$cidade','$estado','$num','$telefone','$email')
      ";
      $_SESSION['nome_cliente'] = $nome;

      if (mysqli_query($conexao,$insert) or die(mysqli_error($conexao))) {
        unset(
          $_SESSION['nome'],
          $_SESSION['cep'],
          $_SESSION['rua'],
          $_SESSION['bairro'],
          $_SESSION['cidade'],
          $_SESSION['estado'],
          $_SESSION['num_casa'],
          $_SESSION['telefone'],
          $_SESSION['email']
        );

        echo "<center><h1><i>Cadastrado com sucesso</i></h1></center>";
        ?>
          <script>
            loginRedirect("<?php echo (isset($_POST['goto']) && $_POST['goto'] === 'payment') ? 'forma_pagamento' : 'index' ?>");
          </script>
    <?php
      }
    }
    ?>  
</body>
</html>
