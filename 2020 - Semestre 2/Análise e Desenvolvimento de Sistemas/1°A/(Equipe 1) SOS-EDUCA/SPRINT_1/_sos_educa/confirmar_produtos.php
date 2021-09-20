<?php session_start() ?>

<?php
  
  $forma_pagamento = $_POST['forma_pagamento'];
  if (isset($_POST['idVenda'])){
    $_SESSION['idVenda'] = $_POST['idVenda'];
  }
  $idVenda = $_SESSION['idVenda'];

  if (isset($_POST['forma_pagamento'])){
    $_SESSION['forma_pagamento'] = $_POST['forma_pagamento'];
  }

  $forma_pagamento = $_SESSION['forma_pagamento'];

  $idCliente = $_SESSION['id_cliente'];
  $usuario = $_SESSION['usuario'];
  $senha = $_SESSION['senha'];
  include("conexao.php");
  $query_pagamento = "update vendas set forma_pagamento='$forma_pagamento', id_cliente='$idCliente' where id_venda='$idVenda' ";
  //echo $query_pagamento;
  mysqli_query($conexao, $query_pagamento);   
  if (!$forma_pagamento) {
    header('location: forma_pagamento.php');
  }

  if ($forma_pagamento === 'cartao') {
    $_SESSION['dados_cartao'] = [
      "numero" => $_POST['numero_cartao'],
      "cod_seg" => $_POST['cod_seguranca'],
      "parcelas" => $_POST['parcelas'],
      "validade" => $_POST['data_validade'],
      "titular" => $_POST['nome_titular'],
      "cupom" => $_POST['cupom_desconto']
    ];
  }
  
  if (!$usuario || !$senha) {
    header('Location: login_clientes.php');
  }

  include("conexao.php");

  $produtos = [];
  $produtos_ids = [];
  $queryItens = "SELECT it.*,pd.* from itens_venda as it, produtos as pd  WHERE (it.id_produto=pd.id_produto) AND (it.id_venda = $idVenda)";
  $resultadoItens = mysqli_query($conexao, $queryItens);
  $itensVenda = mysqli_fetch_all($resultadoItens, MYSQLI_ASSOC);

?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <?php include("cabecalho.php") ?>
  <title>SOS Educa</title>
</head>
<body>
  <?php include("navbar.php") ?>
  <?php (include("progresso.php"))(3) ?>

  <div class="container">
    <div class="row">
      <div class="col-md-9 panel">
        <?php if (sizeof($itensVenda) === 0): ?>
          <span>Nenhum item foi adicionado a lista.</span>
        <?php else: ?>
          <table class="table">
            <tbody>
            <?php
            $total = 0;
              foreach ($itensVenda as $produto) {
                $total += (float) $produto['valor_unitario'] * (int) $produto['qtd_item'];

                
            ?>
                  <tr>
                    <td>
                      <img src="imagens/<?= $produto['imagem'] ?>" style="width:120px;height:160px;float:left;margin-right:20px">
                      <h3 style="margin-top:0"><?= $produto['nome_prod'] ?></h3>
                      <div>
                      <strong>Quantidade: 
                          <span ><?= $produto['qtd_item'] ?></span>
                       </strong>
                      </div>
                      <div>
                      <strong>Preço: 
                        <span>R$ <?= number_format($produto['preco'], 2, ',', '.') ?></span>
                      </strong>
              
                       
                      </div>
                    </td>
                  </tr>
              <?php 
              } 
              ?>
            </tbody>
            <tfoot>
              <tr>
                <td class="active" style="font-size:16px">
                  <strong>Total: 
                    <span style="float:right">R$ <?= number_format($total, 2, ',', '.')?></span>
                  </strong>
                </td>
              </tr>
            </tfoot>
          </table>
        <?php endif ?>
      </div>
      <div class="col-md-3">
        <?php if (sizeof($itensVenda) === 0): ?>
          <a href="index_carrinho_cliente.php" class="btn btn-primary btn-block">Ir até a loja</a>
        <?php else: ?>
          <a href="carrinho_cliente.php" class="btn">Voltar ao carrinho</a>
          <a href="logout_carrinho.php" class="btn btn-success btn-block">Finalizar compra</a>
        <?php endif ?>
      </div>
    </div>
  </div>
  <a href="session_d.php">
  <?php include("rodape.php") ?>
</body>
</html>