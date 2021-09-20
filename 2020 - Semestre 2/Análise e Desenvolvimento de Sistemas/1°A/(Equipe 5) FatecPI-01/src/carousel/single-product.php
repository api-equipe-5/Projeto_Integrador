<?php
session_start();
	include("conexao.php");

	$id = $_REQUEST['id'];
	$result_produtos = "SELECT * FROM arquivos WHERE id = $id";
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
  <link rel="stylesheet" href="css/linearicons.css">
  <link rel="stylesheet" href="css/themify-icons.css">
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/owl.carousel.css">
  <link rel="stylesheet" href="css/main.css">
  <link href="carousel.css" rel="stylesheet">
  <link href="css/star.css" rel="stylesheet">
  <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

</head>




	<!-- Start Header Area -->
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
					<h1>Detalhes do Produto</h1>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Single Product Area =================-->
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<?php
				if ($infos_produto["disciplina"] == "Português") {
					echo '<img src="imagens/produtos/p7.jpg" alt="">';
				}
				else if ($infos_produto["disciplina"] == "Inglês") {
					echo '<img src="imagens/produtos/p1.jpg" alt="">';
				}
				else if ($infos_produto["disciplina"] == "Matemática Discreta") {
					echo '<img src="imagens/produtos/p6.jpg" alt="">';
				}
				else if ($infos_produto["disciplina"] == "Laboratório de Hardware") {
					echo '<img src="imagens/produtos/p4.jpg" alt="">';
				}
				else if ($infos_produto["disciplina"] == "Administração Geral") {
					echo '<img src="imagens/produtos/p3.jpg" alt="">';
				}
				else if ($infos_produto["disciplina"] == "Algoritmos e Lógica de Programação") {
					echo '<img src="imagens/produtos/p2.jpg" alt="">';
				}
				else {
					echo '<img src="imagens/produtos/p8.jpg" alt="">';
				}


				?>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text">
						<h3><?php echo($infos_produto["titulo_produto"]); ?></h3>
						<h2><?php echo("R$".number_format($infos_produto["preco"], 2, ',', '')); ?></h2>
						<ul class="list">
							<li><a class="active" href="#"><span>Categoria:</span><?php echo($infos_produto["disciplina"]); ?></a></li>					
							<br>
							<div class="card_area d-flex align-items-center">
								<a class="primary-btn" href="carrinho.php?add=carrinho&id=<?php echo($infos_produto['id']); ?>">Comprar</a>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================End Single Product Area =================-->

	<!--================Product Description Area =================-->
	<section class="product_description_area">
		<div class="container">
			<ul class="nav nav-tabs" id="myTab" role="tablist">

				<li class="nav-item">
					<a class="nav-link" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Descrição</a>
				</li>
				
				
				<li class="nav-item">
					<a class="nav-link active" id="review-tab" data-toggle="tab" href="#review" role="tab" aria-controls="review"
					 aria-selected="false">Avaliações</a>
				</li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade" id="home" role="tabpanel" aria-labelledby="home-tab">
					<?php echo($infos_produto["descricao"]); ?>
				</div>

				
				<div class="tab-pane fade show active" id="review" role="tabpanel" aria-labelledby="review-tab">
					<div class="row">
						<div class="col-lg-6">
							<div class="row total_rate">
								<div class="col-6">
									
								</div>
							
							
							</div>
							<?php
							$id = $_REQUEST['id'];
							$result_usuarios = "SELECT * FROM avaliacao where id_produto=$id";
					        $resultado_usuarios = mysqli_query($conexao, $result_usuarios);
					        while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
					 
								echo('<div class="review_list">
									<div class="review_item">
										<div class="media">
											<div class="d-flex">
												
											</div>
											<div class="media-body">
												<h4>'.$row_usuario['nome'].'</h4>
												<!--<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>
												<i class="fa fa-star" aria-hidden="true"></i>-->
											</div>
										</div>
										<p>'.$row_usuario['mensagem'].'</p>
										<hr/>
									</div>
									</div>
								');
						}
						?>







					</div>
						<div class="col-lg-6">
							<div class="review_box">
								<h4>Adicionar sua avaliação</h4>
								
								
									
<?php
								$id = $_REQUEST['id'];
							  	$email = $_SESSION['email'];
								$query = "select * from usuario where email = '$email'";
							    $result = mysqli_query ($conexao, $query);
							    $row = mysqli_num_rows ($result);
							    $user = mysqli_fetch_assoc($result);
								echo ('

								<form action="avaliacao.php" method="post" class="ratized" enctype="multipart/form-data">
								<input type="radio" id="vazio" name="estrela" value="" checked>
								  <input id="1" type="radio" name="estrela" value="1"><label for="1">&#9733;</label>

								  <input id="2" type="radio" name="estrela" value="2">
								  <label for="2">&#9733;</label>

								  <input id="3" type="radio" name="estrela"value="3">
								  <label for="3">&#9733;</label>

								  <input id="4" type="radio" name="estrela" value="4">
								  <label for="4">&#9733;</label>

								  <input id="5" type="radio" name="estrela" value="5">
								  <label for="5">&#9733;</label>

								
								<br>
								
								<br>
									<div class="col-md-12">
									<input type="hidden" name="id_produto" value="'.$_REQUEST['id'].'">
										<div class="form-group">
											<input type="text" class="form-control" id="nome" name="nome"  value="'.$_SESSION['nome'].'">
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<input type="email" class="form-control" id="email" name="email" value="'.$_SESSION['email'].'">
										</div>
									</div>
									
									<div class="col-md-12">
										<div class="form-group">
											<textarea class="form-control" name="mensagem" id="mensagem" rows="1" placeholder="Descreva aqui sua avaliação" style="height:214px;""></textarea>
										</div>
									</div>
									<div class="col-md-12 text-right">
										<button type="submit" value="submit" class="primary-btn">Enviar</button>
									</div>
								</form>')
								?>
							</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>



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