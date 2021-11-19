<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <!-- ESTILOS - não importar cabeçalho pois dá imcompatibilidade com product.css -->
    <link rel="stylesheet" href="css/product.css">
    <link rel="stylesheet" href="css/customized.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <!-- SCRIPTS -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/smoothscroll.js"></script>
    <script src="js/custom.js"></script>
    <script src="js/jquery.parallax.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/magnific-popup-options.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <title>SOS Educa - Carrinho</title>
  </head>

  <body>
    <?php include("conexao.php");?>
    <?php include('navbar.php') ?>

    
    <div style='text-align:center'>

        <div class="page-header">
          <h2 class='text-white bg-primary shadow-lg rounded'><b><br> Lista de Produtos </b><br><br></h2>
			    <br>
		    </div>
      </div>
    
		
    <form name="cons" method="post" action="index_carrinho_cliente.php">
      <div style='text-align:center'>
        <h4 class="text-primary">Escolha uma matéria</h4>
          <select name='sel_cat'>
            <option value="0">Todos</option>
              <?php 
                @$pagina = $_GET['pagina'];
                @$idcat = $_POST['sel_cat'];

                $resultado = mysqli_query($conexao,"SELECT * FROM categorias");
                $selecionado = "";
                while($item = mysqli_fetch_assoc($resultado)): ?>
              <?php 
                if ($item['id_cat']==$idcat){
                  $selecionado = "selected";
                } else
                {
                  $selecionado = "";
                }
              ?>
              <option <?php echo $selecionado ?> value="<?= $item['id_cat']?>">
                <?= $item['nome_cat'] ?>
              </option>
            <?php endwhile ?>
          </select> 
          <button type="submit" class="btn btn-success">Consultar</button>
      </div>
    </form>
    
    <div class="container-fluid">
      <div class="row">
          <?php
            //Declaração da página inicial
            //Calculando o registro inicial
            @$pagina = $_GET['pagina'];
            @$idcat = $_POST['sel_cat'];

            if($pagina==""){
              $pagina="1";
            }

            //Máximo de registros por páginas
            $maximo = 9;
            $inicio = $pagina - 1;
            $inicio = $maximo * $inicio;

            $query = "SELECT * FROM produtos";

            if ($idcat) {
              $query .= " WHERE id_categoria = $idcat";
            }
            
            //Conta os resultados no total da query
            $total = mysqli_num_rows(mysqli_query($conexao, $query));

            if (!$idcat) {
            //   $query .= " WHERE id_categoria=$idcat";
            // } else {
              $query .= " limit $inicio, $maximo";
            }

            $sql=mysqli_query($conexao, $query);
          ?>

          <?php while($linha=mysqli_fetch_object($sql)): // CONTENT ?>
          <form action="carrinho_cliente.php" method="POST">
          
            <div class="col-md-4 col-sm-4">
              <div class="product-card">
                <div class="product-card-image" style="background-image: url(imagens/<?= $linha->imagem ?>)">
                  <div class="product-card-description">
                    <strong>Descrição</strong>

                    <?= $linha->descricao ?>
                  </div>
                </div>

                <strong><?= $linha->nome_prod ?></strong>

                <footer>
                  <div class="price">
                    <?= number_format($linha->preco , 2, ',', '.') ?>
                  </div>
                  
                  <button id="car" class="fa fa-cart-plus" type="submit" name="enviar"></button>
                  <input type="hidden" name="acao" value="add"/>
                  <input type="hidden" name="idProduto" value="<?= $linha->id_produto ?>" />
                  
                  </a>
                </footer>
              </div>
            </div>
            </form>
          <?php endwhile /* END OF CONTENT */ ?>
      </div>
    </div>

    <?php // PAGINATION SETTINGS
      $menos = $pagina - 1;
      $mais = $pagina + 1;
      $pgs = ceil($total / $maximo);
    ?>

    <?php if ($pgs > 1): // PAGINATION ?>
      <div class="col-md-12 text-center">
        <ul class="pagination">
          <?php if ($menos > 0): ?>
            <li>
              <a href="<?= $_SERVER['PHP_SELF'] ?>?pagina=<?= $menos ?>">
                <span class="fa fa-chevron-left"></span>
              </a>
            </li>
          <?php endif ?>
          
          <?php for ($i = 1; $i <= $pgs; $i++): ?>
            <?php if ($i == $pagina): ?>
              <li class="active">
                <span><?= $i ?></span>
              </li>
            <?php else: ?>
              <li>
                <a href="<?= $_SERVER['PHP_SELF'] ?>?pagina=<?= $i ?>"><?= $i ?></a>
              </li>
            <?php endif ?>
          <?php endfor ?>
                
          <?php if ($mais <= $pgs): ?>
            <li>
              <a href="<?= $_SERVER['PHP_SELF'] ?>?pagina=<?= $mais ?>">
                <span class="fa fa-chevron-right"></span>
              </a>
            </li>
            
          <?php endif ?>
          </div> 
        </ul>
        
        <br/><br/><br/><br/>
          
        <?php include("rodape.php");?>
      </div>
    <?php endif // END OF PAGINATION ?>
        

  </body>
  
</html>
