<?php
  session_start();
  include("conexao.php");
  $nmat = $_SESSION['nmaterial'];
  $id = $_SESSION['id'];

    require_once 'vendor/autoload.php';

  $token = $_REQUEST["token"];
  $payment_method_id = $_REQUEST["payment_method_id"];
  $installments = $_REQUEST["installments"];
  $issuer_id = $_REQUEST["issuer_id"];

    MercadoPago\SDK::setAccessToken("TEST-6134362377299854-110614-cfccc150843aec7a02088196951627dd-492910028");
    //...
    $payment = new MercadoPago\Payment();
    $payment->transaction_amount = 166;
    $payment->token = $token;
    $payment->description = "Durable Paper Computer";
    $payment->installments = $installments;
    $payment->payment_method_id = $payment_method_id;
    $payment->issuer_id = $issuer_id;
    $payment->payer = array(
    "email" => "c.sendreto@gmail.com"
    );
    // Armazena e envia o pagamento
    $payment->save();
    //...
    // Imprime o status do pagamento
    $Pays = $payment->status;

    if ($Pays == "approved"){

      $sql = "UPDATE usuario SET $nmat = '0' WHERE usuario_id = '$id'";    
      
      if($conexao->query($sql) === TRUE) {

        $query = "SELECT * FROM usuario WHERE usuario_id = '$id'";

        $result = mysqli_query($conexao, $query);
        
        $row = mysqli_num_rows($result);
        
        if($row == 1) {

          $usuario_bd = mysqli_fetch_assoc($result);

          $_SESSION['ing'] = $usuario_bd['Ingles'];
          $_SESSION['mat'] = $usuario_bd['Matematica'];
          $_SESSION['har'] = $usuario_bd['Hardware'];
          $_SESSION['aoc'] = $usuario_bd['AOC'];
          $_SESSION['por'] = $usuario_bd['Portugues'];
          $_SESSION['pro'] = $usuario_bd['Programacao'];
          
          $conexao->close();
      
          header('Location: painel.php');
          exit;
        }
      }
      
    }
    else{
      echo erro;
    }
    //...5031 4332 1540 6351	
?>