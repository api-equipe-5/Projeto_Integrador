<?php
session_start();
include 'conexao.php'


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
  <link rel="stylesheet" href="css/linearicons.css">
  <link rel="stylesheet" href="css/themify-icons.css">
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/owl.carousel.css">
  <link rel="stylesheet" href="css/main.css">
  <link href="carousel.css" rel="stylesheet">
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

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Confirmação</h1>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Order Details Area =================-->
	<section class="order_details section_gap">
		<div class="container">
			<h3 class="title_confirmation">Obrigada. Sua compra foi feita com sucesso!</h3>
			<div class="row order_d_inner">
				<div class="col-lg-4">
					<div class="details_item">
					<?php		
					  $id_pedido = $_REQUEST['id'];
					  		  
					  $result_produtos = "SELECT * FROM pedidos where id_pedido = '$id_pedido'";
				 	  $resultado_produtos = mysqli_query($conexao, $result_produtos);
					  $infos_produto = mysqli_fetch_assoc($resultado_produtos);
					
						echo('<h4>Informação do Pedido</h4>
						<ul class="list">
							
							<li><a href="#"><span>Numero do Pedido</span> : '.$_REQUEST['id'].'</a></li>
							<li><a href="#"><span>Data</span> : 20/10/2020</a></li>
							
							<li><a href="#"><span>Método de pagamento</span> : '.$infos_produto["metodopag"].'</a></li>
							<li><a href="#"><span>Parcelado em</span> : '.$infos_produto["parcelas"].'x</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="details_item">
						<!--<h4>Billing Address</h4>
						<ul class="list">
							<li><a href="#"><span>Street</span> : 56/8</a></li>
							<li><a href="#"><span>City</span> : Los Angeles</a></li>
							<li><a href="#"><span>Country</span> : United States</a></li>
							<li><a href="#"><span>Postcode </span> : 36952</a></li>
						</ul>-->
					</div>
				</div>
				<div class="col-lg-4">
					<div class="details_item">
					<!-- <h4>Shipping Address</h4>
						<ul class="list">
							<li><a href="#"><span>Street</span> : 56/8</a></li>
							<li><a href="#"><span>City</span> : Los Angeles</a></li>
							<li><a href="#"><span>Country</span> : United States</a></li>
							<li><a href="#"><span>Postcode </span> : 36952</a></li>
						</ul> -->
					</div>
				</div>
			</div>
		
			<div class="order_details_table">
				<h2>Detalhes do pedido</h2>
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Produto</th>
								
								<th scope="col">Total</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<p>'.$infos_produto["titulo_produto"].'</p>
								</td>
								
								<td>
									<p>'.$infos_produto["preco"].'</p>
								</td>
							</tr>
							<tr>
								
								<td>
									<h5></h5>
								</td>
								<td>
									
								</td>
							</tr>
						</tbody>
					</table>');
					?>	
				</div>
			</div>
		</div>
		<br>
		<center> 

			
			<div class="button-group-area mt-40">
			<a href="#" class="genric-btn primary small" onClick="window.print()">Imprimir</a><a class="genric-btn primary small small" href="perfiluser.php">Download</a></div>

	</section>
	<!--================End Order Details Area =================-->

	<!-- Site footer -->
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


	<script src="js/vendor/jquery-2.2.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 crossorigin="anonymous"></script>
	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/countdown.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>
</body>

</html>