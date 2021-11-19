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
<?php include("navbar.php") ?>

    <?php
 

?>
 

  <h1 class="text-center">Agradecemos o Pagamento</h1>
 <br /><br/><br />
    <div class="container conteudo  printable">
        <table class="table">
        <thead>
          <tr>
            <th>Nome do Produto</th>
            <th>Download</th>
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
               
                <td><?= $forma_pagamento === 'cartao' ? '<a href="arquivos/'.$produtos['arquivo'].'"target="_blank">Baixar Arquivo</a>' : '<a href="arquivos/'.$produtos['arquivo'].'"target="_blank">Baixar Arquivo</a>' ?>

                </td>
              
              </tr>
             <?php
        }
       
             ?>
      
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
      <a href="session_d.php">
        <button class="btn-success" >Voltar ao carrinho</button>
      </a>
  </div>  
  <br /><br/>
  <br /><br/>
  <br /><br/>
  
  <?php    include("rodape.php") ?>
</body>
</html>