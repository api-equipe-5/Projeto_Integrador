<?php

session_start();
include("conexao.php");

  $result_produtos = "SELECT * FROM arquivos WHERE disciplina";
  $resultado_produtos = mysqli_query($conexao, $result_produtos);
  $infos_produto = mysqli_fetch_assoc($resultado_produtos);

?>

<!DOCTYPE html>
<html lang="pt-br">

<head>

  <link rel="shortcut icon" href="imagens/fav.ico">
  <meta charset="UTF-8">
  <!-- Site Title -->
  <title>Mr.Academy</title>

    <!--
            CSS
            ============================================= -->
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/linearicons.css">
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/nouislider.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/main.css">
</head>

<body>

  <!-- Start Header Area -->
  <header class="header_area sticky-header">
    <div class="main_menu">
      <nav class="navbar navbar-expand-lg navbar-light main_box">
        <div class="container">
          <!-- Brand and toggle get grouped for better mobile display -->
          <a class="navbar-brand logo_h" href="produtos.php"><img src="imagens/logo.png" width="150px"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
           aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
            <ul class="nav navbar-nav menu_nav ml-auto">
              <li class="nav-item active"><a class="nav-link" href="produtos.php">Inicio</a></li>
                <!--<li class="nav-item submenu dropdown">
                 <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                 aria-expanded="false">Materiais didáticos</a>
                <ul class="dropdown-menu">
                  <li class="nav-item"><a class="nav-link" href="">Português</a></li>
                  <li class="nav-item"><a class="nav-link" href="">Inglês</a></li>
                  <li class="nav-item"><a class="nav-link" href="">Matemática Discreta</a></li>
                  <li class="nav-item"><a class="nav-link" href="">Laboratório de Hardware</a></li>
                  <li class="nav-item"><a class="nav-link" href="">Administração Geral</a></li>
                  <li class="nav-item"><a class="nav-link" href="">Algoritmos e Lógica de Programação</a></li>
                  <li class="nav-item"><a class="nav-link" href="">Arquitetura e Organização de Computadores</a></li>
                </ul>
              </li> -->
              <li class="nav-item submenu dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                 aria-expanded="false">Meu Perfil</a>
                <ul class="dropdown-menu">
                  <?php
                    if (isset($_SESSION['tipo_usuario']) && $_SESSION['tipo_usuario'] == "user") {
                      echo '<li class="nav-item"><a class="nav-link" href="perfiluser.php">Editar Perfil</a></li>';
                    }else {
                      echo '<li class="nav-item"><a class="nav-link" href="perfiladm.php">Editar Perfil</a></li>';
                    }
                  ?>

                  <?php
                    if (isset($_SESSION['tipo_usuario']) && $_SESSION['tipo_usuario'] == "admin") {
                      echo '<li class="nav-item"><a class="nav-link" href="add-product/add-product/add-product.php">Cadastrar Material</a></li>';
                    }
                  ?>
                  <?php
                    if (isset($_SESSION['tipo_usuario']) && $_SESSION['tipo_usuario'] == "admin") {
                      echo '<li class="nav-item"><a class="nav-link" href="relatorio_vendas/report.php" target="_blank">Relatório de Vendas</a></li>';
                    }
                  ?>
                  <li class="nav-item"><a class="nav-link" href="deslogar.php">Logout</a></li>
                  <!-- <li class="nav-item"><a class="nav-link" href=".html">Relatório de Vendas</a></li> -->
                </ul>
              </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class="nav-item"><a href="#" class="cart"><span class="lnr lnr-cart"></span></a></li>
              <li class="nav-item">
                <button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
    <div class="search_input" id="search_input_box" style="height: 45px;">
      <div class="container">
        <form class="d-flex justify-content-between">
          <input type="text" class="form-control" id="search_input" placeholder="O que você procura?">
          <button type="submit" class="btn"></button>
          <span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
        </form>
      </div>
    </div>
  </header>
  <!-- End Header Area -->
	<!-- End Header Area -->

    <!-- Start Banner Area -->
    <section class="banner-area organic-breadcrumb">
        <div class="container">
            <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                <div class="col-first">
                    <h1>Carrinho de compras</h1>
                </div>
            </div>
        </div>
    </section>
    <!-- End Banner Area -->

    <!--================Cart Area =================-->
<br><br><br>








<div class = "Interface">
<div class="shopping-cart">

  <div class="column-labels">

    <label class="product-image">Image</label>
    <label class="product-details">Preço</label>
    <label class="product-price" style="padding-bottom: 39px;"></label>
    <label class="product-removal">Remove</label>
    <label class="product-line-price" style="padding-bottom: 39px;"></label>
  </div>
 
   <?php

if(!isset($_SESSION['itens']) || count($_SESSION['itens'])==0){
	echo 'Opa, parece que seu carrinho esta vazio :(<br><br><a href="produtos.php" class="genric-btn primary small">Adicionar itens</a>';
}
else{
	$_SESSION['dados'] = array();
	$conexao = new PDO ('mysql:host=localhost;dbname=bd_pi01',"root","");
	foreach($_SESSION['itens'] as $idArquivos=>$quantidade)
	{
    $select = $conexao->prepare("SELECT * FROM arquivos WHERE id=?");
    $select->bindParam(1,$idArquivos);
    $select->execute();
    $arquivos = $select->fetchALL();
    echo('<div class="product">
  
    <div class="product-details">

      <div class="product-title"><br>'.$arquivos[0]["titulo_produto"].'</div>
    </div>
    <div class="product-price"><br>R$'.$arquivos[0]["preco"].'</div>
     <div class="product-removal"><br>
    <a href="remover.php?remover=carrinho&id='.$idArquivos.'" class="remove-product" style="padding-top: 5px; padding-bottom: 5px; padding-right: 5px; padding-left: 5px;">Remover</a></div>');?>

    <div class="product-image"> 
    <?php   
    if($arquivos[0]["disciplina"] == "Português"){
            echo '<img src="imagens/produtos/p7.jpg" alt=""> </div>
    </div>';
          }
    else if ($arquivos[0]["disciplina"] == "Inglês") {
            echo '<img src="imagens/produtos/p1.jpg" alt=""> </div>
    </div>';
          }
          else if ($arquivos[0]["disciplina"] == "Matemática Discreta") {
            echo '<img src="imagens/produtos/p6.jpg" alt=""> </div>
    </div>';
          }
          else if ($arquivos[0]["disciplina"] == "Laboratório de Hardware") {
            echo '<img src="imagens/produtos/p4.jpg" alt=""> </div>
    </div>';
          }
          else if ($arquivos[0]["disciplina"] == "Administração Geral") {
            echo '<img src="imagens/produtos/p3.jpg" alt=""> </div>
    </div>';
          }
          else if ($arquivos[0]["disciplina"] == "Algoritmos e Lógica de Programação") {
            echo '<img src="imagens/produtos/p2.jpg" alt="">
    </div>
    </div>';
          }
          else {
            echo '<img src="imagens/produtos/p8.jpg" alt="" >';
          }
    '</div>
    </div>';

      array_push($_SESSION['dados'],
      array('id_arquivos' => $idArquivos,
      'titulo_produto'=> $arquivos[0]['titulo_produto'],
      'preco' => $arquivos[0]['preco']));
  }

						$preco = 0.0;
						$conexao = new PDO ('mysql:host=localhost;dbname=bd_pi01',"root","");
						foreach($_SESSION["itens"] as $idArquivos=>$quantidade)
						{
							$select = $conexao->prepare("SELECT * FROM arquivos WHERE id=?");
							$select->bindParam(1,$idArquivos);
							$select->execute();
							$arquivos = $select->fetchALL();
							

							$preco = floatval($arquivos[0]['preco']) + $preco;
						}}
						  // print_r($_SESSION['dados']);


          

if ($preco ==0) {
  echo ('<div class="totals">
  <div class="totals-item totals-item-total">
        <br>
        <label style = "color: #5c5a5a; text-indent: -40px; text-align: center;"></a>Total: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;R$00.00</a> </label>
      </div>
    </div>
    </div></div></div>');
}
else {

    echo ('<div class="totals">
    <div class="totals-item totals-item-total">
      <label style = "color: #5c5a5a; text-indent: -40px; text-align: center;"><br><a>Total: R$'.$preco.'</a> </label>
      </div>
    </div>
    </div></div></div>');
}
  ?>
  <br>


<!--<div class="product">
    <div class="product-image">
      <img src="https://s.cdpn.io/3/large-NutroNaturalChoiceAdultLambMealandRiceDryDogFood.png">
    </div>
    <div class="product-details">
      <div class="product-title">Nutro™ Adult Lamb and Rice Dog Food</div>
    </div>
    <div class="product-price">45.99</div>
    <div class="product-removal">
      <button class="remove-product">
        Remover
      </button>
    </div>
    <div class="product-line-price">45.99</div>
  </div> -->
  <!--<div class="totals">
    <div class="totals-item totals-item-total">
      <label>Total:</label>
      <div class="totals-value" id="cart-total"></div>
    </div>-->

  </div></div>
     <a href="checkout.php"><button class="checkout"><p style="padding-top: 8px;">Checkout de pagamento</p></button></a>
      <a href="produtos.php"><button class="continue" ><p style="padding-top: 8px;">Adicionar novos produtos</p></button></a>
</div> 

<br><br><br><br><br><br>
<br>
    <!--================End Cart Area =================-->

    <!-- start footer Area -->
    <footer class="site-footer">
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
</footer>
    <!-- End footer Area -->

    <!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script><script  src="js\script1.js"></script>
    <script src="js/vendor/jquery-2.2.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 crossorigin="anonymous"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
    <script src="js/nouislider.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<!--gmaps Js-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="js/gmaps.min.js"></script>
	<script src="js/main.js"></script>
</body>

</html>