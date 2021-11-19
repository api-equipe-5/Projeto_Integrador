<?php date_default_timezone_set('America/Sao_Paulo');?>

<?php session_start();
  include("conexao.php");

  if (isset($_POST['idVenda'])){
    $_SESSION['idVenda'] = $_POST['idVenda'];
  }

  $idVenda = $_SESSION['idVenda'];

  $queryVenda = "SELECT vd.* from vendas as vd  WHERE  (vd.id_venda = $idVenda)";
  $resultadoVenda = mysqli_query($conexao, $queryVenda);
  $dadosVenda = mysqli_fetch_all($resultadoVenda, MYSQLI_ASSOC);


  // $queryItens = "SELECT it.*,pd.* from itens_venda as it, produtos as pd  WHERE (it.id_produto=pd.id_produto) AND (it.id_venda = $idVenda)";
  // $resultadoItens = mysqli_query($conexao, $queryItens);
  // $itensVenda = mysqli_fetch_all($resultadoItens, MYSQLI_ASSOC);

  $forma_pagamento = $_SESSION['forma_pagamento'];
   

    
  if (isset($_GET['acao'])) {
   if ($_GET['acao'] == 'add') {
      $id = intval($_GET['id']);
      if (!isset($_SESSION['carrinho_cliente'][$id])) {
        $_SESSION['carrinho_cliente'][$id] = 1;
      } 
      else { 
        $_SESSION['carrinho_cliente'][$id] += 1;
      }
    }
    if ($_GET['acao'] == 'del') {
      $id = intval($_GET['id']);
      if (isset($_SESSION['carrinho_cliente'][$id])) {
        unset($_SESSION['carrinho_cliente'][$id]);
      }
    }
    if ($_GET['acao'] == 'up_c') {
      if (is_array(@$_POST['prod'])) {
        foreach ($_POST['prod'] as $id => $qtd) {
          $id = intval($id);
          $qtd = intval($qtd);
          if (!empty($qtd) || $qtd != 0) {
            $_SESSION['carrinho_cliente'][$id] = $qtd;
          } 
          else {
            unset($_SESSION['carrinho_cliente'][$id]);
          }
        }
      }
    }
  }
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <?php include("cabecalho.php") ?>
  <title>
    <?= $forma_pagamento === 'cartao' ? 'Pagamento realizado' : 'Boleto gerado' ?>
  </title>
  <style>
   @media print {
    html, body {
        margin: 0;
        padding: 0;
        border: 0;
    }
    #printable {
        margin: 0;
        padding: 0;
        border: 0;
        font-size: 14px;
    }
    #printable ~ * {
        display: none;
    }
}
  </style>


</head>
<body class="printable">
<?php

?>
  <?php include("navbar.php") ?>
  <?php (include("progresso.php"))(4);?>
    <div class="conteudo printable">
      <div class="container text-center">
          <img  src="imagens/logo6.png" alt="placeholder+image" height="80px" width="100px">
              <?php
                $data = date("d/m/Y");
                $hora = date("H:i:s");
                @$nome_cli = $_POST['nome_cli'];

                echo "<b>" . " CNPJ " . "</b>" . "00.000.000/0000-00" . "<br>";
                echo "<b>" . "Endereço: " . "</b>" . "Avenida Cesare Monsueto Giulio Lattes" . " - " . "Nº " . "1350" . " - " . "Eugênio de Melo" . "<br>";
                echo "Data: " . $data;
                echo "  Hora: " . $hora . "<br>";
                echo "<div class='container'>
                        <div class='row'>
                          <div class='col-sm-12' style='background-color:#0099cc;'></div>
                          <div class='col-sm-12' style='background-color:#0099cc;'></div>
                        </div>
                      </div>";
                echo "<br>" . "Nome do Comprador:" . "<h2 class='text-danger'>" . utf8_encode(@$_SESSION['nome_cliente']) . "</h2>";
                echo @$nome_cli;
              ?>

        
        <br/><br/>
       
      </div>
    </div>
   
  <div class="container printable">
  
    <h3 style="text-align:center"><?= $forma_pagamento === 'cartao' ? 'Pagamento realizado' : 'Boleto gerado' ?> com sucesso.</h3>
    <?php 
    if ($forma_pagamento=="boleto"){


    ?>
    <img src="imagens/cod_barra3.jpg" alt="codigo_de_barra" class="img-responsive"  >
    <?php 
    } else {
      $dados_cartao = $_SESSION['dados_cartao'];
      ?>
    <table class="table table-responsive printable">
      <tbody>
        <tr>
          <th style="text-align:right">Titular</th>
          <td style="width:75%"><?= $dados_cartao['titular'] ?></td>
        </tr>
        <tr>
            <th style="text-align:right">Nº do Cartão</th>
            <td style="width:75%"><?= $dados_cartao['numero'].'.XXXX.XXXX.XXXX' ?></td>
        </tr>
        <tr>
            <th style="text-align:right">Parcelas</th>
            <td style="width:75%"><?= $dados_cartao['parcelas'] ?></td>
        </tr>
      </tbody>
    </table>
          <?php
    }
    ?>

    <table class="table">
        <thead>
          <tr>
            <th>Nome do Produto</th>
            <th>Quantidade</th>
            <th>Link</th>
            <th>Preço</th>
          </tr>
        </thead>
        <tbody>
        <?php
    include("conexao.php");
    
    $queryItens = "SELECT it.*,pd.* from itens_venda as it, produtos as pd  WHERE (it.id_produto=pd.id_produto) AND (it.id_venda = $idVenda)";
    $resultadoItens = mysqli_query($conexao, $queryItens);
    $itensVenda = mysqli_fetch_all($resultadoItens, MYSQLI_ASSOC);

  ?>
        <?php 
        $total = 0;
        foreach ($itensVenda as $produtos) {
          $total+= (float) $produtos['qtd_item']*$produtos['preco'];
        ?>
              <tr>
                <td><?= $produtos['nome_prod'] ?></td>
                <td><?= $produtos['qtd_item'] ?></td>
                <td><?= $forma_pagamento === 'cartao' ? '<a href="arquivos/'.$produtos['arquivo'].'"target="_blank">Baixar Arquivo</a>' : '<a href="realizandoPag.php">Aguardando pagamento</a>' ?>

                </td>
                <td>R$ <?= number_format($produtos['preco'], 2, ',', '.') ?></td>
              </tr>
             <?php
        }
             ?>
          <tfoot>
              <tr>
                <th colspan="2">TOTAL</th>
                <td>R$ <?= number_format($total, 2, ',', '.') ?> </td>
              </tr>
          </tfoot>
        </tbody>
    </table>
  </div>
  <script>
    function printBy(selector){
    var $print = $(selector)
        .clone()
        .addClass('print')
        .prependTo('body');

    // Stop JS execution
    window.print();
     
    // Remove div once printed
    $print.remove();
};
    
  </script>
  <div class="text-center">
  <input type="button" onclick="printBy('.printable');" class="btn-success btn"  value="Imprimir"> 
      <a href="session_d.php">
        <button class="btn-danger" >Encerrar venda</button>
      </a>
  </div>  
  <br /><br />
  <?php include("rodape.php") ?>
</body>
</html>