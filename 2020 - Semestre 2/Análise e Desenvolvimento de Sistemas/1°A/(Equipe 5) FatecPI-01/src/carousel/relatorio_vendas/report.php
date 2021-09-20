<?php

    include("conexao.php");
    session_start();

?>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Relatório de vendas</title>
  <link rel="stylesheet" href="./style.css">
  <link rel="stylesheet" href="../css">

</head>
<body>
<style type="text/css">
body {
  background-color: black;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
</style>
<!-- partial:index.partial.html -->
<html>
    <head>
        <link rel="stylesheet" href="index.css">
    </head>
    
    <body>
        <sidebar></sidebar>
        <main>
            <h1>Relatório de vendas</h1>
            <?php

                $query = "select count(*) from pedidos;";
                $result = mysqli_query($conexao, $query);
                $contador = mysqli_fetch_assoc($result);

                $query = "select sum(preco) from pedidos;";
                $result = mysqli_query($conexao, $query);
                $dinheiro = mysqli_fetch_assoc($result);

                $query = "select * from arquivos";
                $result = mysqli_query($conexao, $query);
                
                $idMaisAvaliado = 0;
                $idMenosAvaliado = 0;
                $maisAvaliado = 0;
                $menosAvaliado = 100;
                while ($arquivo = mysqli_fetch_assoc($result)) {
                    $qtdEstrelas = 0;
                    $id_arquivo = $arquivo['id'];

                    $consultaAvaliacao = "select * from avaliacao where id_produto = $id_arquivo;";
                    $resultadoAvaliacao = mysqli_query($conexao, $consultaAvaliacao);

                    while ($avaliacao = mysqli_fetch_assoc($resultadoAvaliacao)) {
                        // echo("<br>Id: ".$id_arquivo);
                        // echo("<br>Estrelas: ".$avaliacao['qnt_estrela']);
                        $qtdEstrelas = intval($avaliacao['qnt_estrela']) + $qtdEstrelas;
                    }

                    if ($qtdEstrelas > $maisAvaliado) {
                        $maisAvaliado = $qtdEstrelas;
                        $idMaisAvaliado = $id_arquivo;
                    }

                    if ($qtdEstrelas < $menosAvaliado) {
                        $menosAvaliado = $qtdEstrelas;
                        $idMenosAvaliado = $id_arquivo;
                    }

                }

                $query = "SELECT * from arquivos WHERE id = $idMaisAvaliado";
                $result = mysqli_query($conexao, $query);
                $produtoMaisAvaliado = mysqli_fetch_assoc($result);

                $query = "SELECT * from arquivos WHERE id = $idMenosAvaliado";
                $result = mysqli_query($conexao, $query);
                $produtoMenosAvaliado = mysqli_fetch_assoc($result);

                echo "
                <div class='content'>
                    <h3>Dados do relatório</h3>
                    <ul>
                        <li><strong>Total de vendas</strong><span>".$contador['count(*)']."</span></li>
                        <li><strong>Dinheiro arrecadado com vendas</strong><span>R$".number_format($dinheiro['sum(preco)'], 2, ',', '')."</span></li>
                        <li><strong>Mais bem avaliado</strong><span>".$produtoMaisAvaliado['titulo_produto']." - ".$produtoMaisAvaliado['disciplina']." (".$produtoMaisAvaliado['id'].")</span></li>
                        <li><strong>Menos avaliado</strong><span>".$produtoMenosAvaliado['titulo_produto']." - ".$produtoMenosAvaliado['disciplina']." (".$produtoMenosAvaliado['id'].")</span></li>
                    </ul>
                </div>";
            ?>
            <br>
            <br>
            <?php

                $query = "SELECT * FROM pedidos;";
                $result = mysqli_query($conexao, $query);

                while($pedidos = mysqli_fetch_assoc($result)){
                    echo("
                    <div class='content'>
                        <h3>Dados da venda</h3>
                        
                        <ul>
                            <li><strong>Id: </strong><span>".$pedidos['id_pedido']."</span></li>
                            <li><strong>Total da venda: </strong><span>".$pedidos['preco']."</span></li>
                            <li><strong>Produtos: </strong><span>".$pedidos['id_produto']."</span></li>
                            <li><strong>Parcelas: </strong><span>".$pedidos['parcelas']."</span></li>
                            <li><strong>Método de pagamento: </strong><span>".$pedidos['metodopag']."</span></li>
                            <li><strong>E-mail do comprador: </strong><span>".$pedidos['email_usuario']."</span></li>
                        </ul>
                    </div>
                    <br>
                    <br>");
                }
            ?>
        </main>
        <!-- <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-sm-12 col-md-6">
            <h6>Sobre nós</h6>
            <p class="text-justify">A idealização deste site trata-se de um projeto integrador (PI), da instituição FATEC Jessen Vidal (São José dos Campos – SP).</p>
          </div>

          <div class="col-xs-6 col-md-3">
            <h6>Equipe</h6>
            <ul class="footer-links">
              <li><a href="https://www.linkedin.com/in/juliane-freitas-9b6287163/" target="_blank">Juliane Freitas</a></li>
              <li><a href="https://www.linkedin.com/in/leticia-amorim-4761b1185/" target="_blank">Leticia Amorim</a></li>
              <li><a href="https://www.linkedin.com/in/pedro-ferreira-6a8417190/" target="_blank">Pedro Ferreira</a></li>
              <li><a href="https://www.linkedin.com/in/rogério-camargo-3a01191a5/" target="_blank">Rogério Camargo</a></li>
              <li><a href="https://www.linkedin.com/in/thomas-palma-0764b81b3/" target="_blank">Thomas Palma</a></li>
            </ul>
          </div>
          <div class="col-xs-6 col-md-3">
            <h6>Contato</h6>
            <ul class="footer-links">
              <li><a href="contato.php">Fale Conosco</a></li>
            </ul>
          </div>
        </div>
        <hr>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-md-8 col-sm-6 col-xs-12">
            <p class="copyright-text">Copyright © 2020, Mr. Academy Inc. <a href="#"></a></p>
</footer> -->
    </body>
<!-- partial -->
  
</body>
</html>
