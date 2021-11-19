<?php session_start() ?>

<?php

  $usuario = $_SESSION['usuario'];
  $senha = $_SESSION['senha'];

  //$carrinho = $_SESSION['carrinho_cliente'];
  
  if (isset($_POST['idVenda'])){
    $_SESSION['idVenda'] = $_POST['idVenda'];
  }
  $idVenda = $_SESSION['idVenda'];
  if (!$usuario || !$senha) {
    header('Location: login_clientes.php');
  }

  include("conexao.php");

?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <?php include("cabecalho.php") ?>
  <link rel="stylesheet" href="cartao/css/normalize.css">
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Inconsolata'>
    <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Open+Sans'>
    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="cartao/css/style.css">
    <link rel="stylesheet" href="css/product.css">
    <link rel="stylesheet" href="css/customized.css">
     <link rel="stylesheet" href="css/bootstrap.min.css">
     <link rel="stylesheet" href="css/font-awesome.min.css">

    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="cartao/js/index.js"></script>
  <title>SOS Educa</title>
</head>
<body>
  <?php include("navbar.php") ?>
  <?php (include("progresso.php"))(2) ?>

  <div class="container">
    <div class="row">
      <h3>Selecione a forma de pagamento</h3>
      <div>
        <ul class="nav nav-tabs" role="tablist">
          <li role="presentation" class="active"><a href="#cartao" aria-controls="cartao" role="tab" data-toggle="tab">Cartão</a></li>
          <li role="presentation"><a href="#boleto" aria-controls="boleto" role="tab" data-toggle="tab">Boleto</a></li>
        </ul>
        <div class="tab-content">
          <div role="tabpanel" class="tab-pane active" id="cartao">
            <div class="panel" style="padding-top:20px">
              <form class="form" method="post" action="confirmar_produtos.php">
                <input type="hidden" name="forma_pagamento" value="cartao">
                <input type="hidden" name="idVenda" value="<?=$idVenda?>" />

                <div class="checkout">
  <div class="credit-card-box">
    <div class="flip">
      <div class="front">
        <div class="chip"></div>
        <div class="logo">
          <img src="http://cdn.flaticon.com/svg/39/39134.svg" alt="" />
        </div>
        <div class="number"></div>
        <div class="card-holder">
          <label>Nome do Titular</label>
          <div></div>
        </div>
        <div class="card-expiration-date">
          <label>Data de Vencimento</label>
          <div></div>
        </div>
      </div>
      <div class="back">
        <div class="strip"></div>
        <div class="logo">
          <img src="http://cdn.flaticon.com/svg/39/39134.svg" alt="" />
        </div>
        <div class="ccv">
          <label>CVV</label>
          <div></div>
        </div>
      </div>
    </div>
  </div>
  <form class="form" autocomplete="off" novalidate method="post" action="confirmar_produtos.php">
    <fieldset>
      <label for="card-number">Número do Cartão</label>
      <input type="num" id="card-number" name="numero_cartao" class="input-cart-number" maxlength="4" />
      <input type="num" id="card-number-1" class="input-cart-number" maxlength="4" />
      <input type="num" id="card-number-2" class="input-cart-number" maxlength="4" />
      <input type="num" id="card-number-3" class="input-cart-number" maxlength="4" />
      
    </fieldset>
    <fieldset>
      <label for="card-holder">Nome</label>
      <input type="text" id="card-holder" name="nome_titular"/>
    </fieldset>
    <fieldset class="fieldset-expiration">
      <label for="card-expiration-month">Data de Vencimento</label>
      <div class="select">
        <select id="card-expiration-month" name="data_validade">
          <option></option>
          <option>Jan</option>
          <option>Fev</option>
          <option>Mar</option>
          <option>Abr</option>
          <option>Mai</option>
          <option>Jun</option>
          <option>Jul</option>
          <option>Ago</option>
          <option>Set</option>
          <option>Out</option>
          <option>Nov</option>
          <option>Dez</option>
        </select>
      </div>
      <div class="select">
        <select id="card-expiration-year">
          <option></option>
          <option>2020</option>
          <option>2021</option>
          <option>2022</option>
          <option>2023</option>
          <option>2024</option>
          <option>2025</option>
          <option>2026</option>
          <option>2027</option>
          <option>2028</option>
          <option>2029</option>
          <option>2030</option>
        </select>
      </div>
    </fieldset>
    <fieldset class="fieldset-ccv">
      <label for="card-ccv">CCV</label>
      <input type="text" id="card-ccv" maxlength="3" name="cod_seguranca"/>
    </fieldset>
    <fieldset class="fieldset-expiration">
      <label for="card-expiration-month">Parcelas</label>
      <div class="select">
        <select id="parcelas" name="parcelas">
          <option></option>
          <option>1x s/juros</option>
          <option>2x s/juros</option>
          <option>3x s/juros</option>
          <option>4x s/juros</option>
          <option>5x s/juros</option>
          <option>6x s/juros</option>
          <option>7x s/juros</option>
          <option>8x s/juros</option>
          <option>9x s/juros</option>
          <option>10x s/juros</option>
        </select>
      </div>
    </fieldset>
    <fieldset>
      <label for="card-holder">Cupom de Desconto</label>
      <input type="text" id="card-holder" name="cupom_desconto"/>
    </fieldset>

    <div class="checkbox">
                  <label>
                    <input type="checkbox">
                    <strong>Lembrar deste cartão</strong>
                  </label>
                </div>
                <button type="submit" class="btn btn-primary btn-center">Continuar</button>
              </form>
    

               
            </div>
          </div>
          </div>
          <div role="tabpanel" class="tab-pane" id="boleto">
            <div class="panel" style="padding-top:20px">
              <form method="post" action="confirmar_produtos.php">
                <input type="hidden" name="forma_pagamento" value="boleto">
                <input type="hidden" name="idVenda" value="<?=$idVenda?>" />
                <button type="submit" class="btn btn-primary">Continuar com boleto</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <?php include("rodape.php") ?>
  <script>
    $('.nav-tabs').click(function (e) {
      e.preventDefault()
      $(this).tab('show')
    })
  </script>
</body>
</html>