<?php
	session_start();
	include_once("conexao.php");
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
  <link href="css/darkmode.css" rel="stylesheet">
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
										} else {
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
							<li class="nav-item"><a href="cart.php" class="cart"><span class="lnr lnr-cart"></span></a></li>
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

	
<main role="main">

  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <a href="#" svg class="bd-placeholder-img">
        	<img src="imagens\esquerda.png" width="100%" height="100%"  xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%"  fill="#777"/></svg></a>
        <div class="container">
          <div class="carousel-caption text-left">
          	<div id = slide1>
          	<h3>Preparando você para o futuro</h3>
          	<p>Tudo planejado e desenvolvido para você se acomodar e ter um modo de estudos divertido e prazeroso, estudar nunca foi tão fácil.</p>
          </div>
            <h1></h1>
            <p></p>
            <br>
            <br>
           </div>
        </div>
      </div>
      <div class="carousel-item">
         <a href="#" svg class="bd-placeholder-img"><img src="imagens/centro.png" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#777"/></svg></a>
        <div class="container">
          <div class="carousel-caption">
          	<div id = slide2>
          	<h3>Seja bem vindo</h3>
          	<p>A Mr. Academy está feliz com sua presença em nosso site, obtenha conhecimento com nossos materiais. Faça Login e vincule-se a nós.
          	</p>
          	<h1></h1>
          	<p></p>
          </div>
            <br>
            <br>
          </div>
        </div>
      </div>
      <div class="carousel-item">
         <a href="#" svg class="bd-placeholder-img"><img src="imagens/direita.png" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#777"/></svg></a>
        <div class="container">
          <div class="carousel-caption text-right">
          	<div id = slide3>
          	<h3>Aqui você aprende mais!</h3>
          	<p>A Mr. Academy preparou para você ótimos materiais didáticos para seus estudos, e o melhor, tudo isso por um preço que cabe no seu bolso. Aprenda conosco, você sempre pronto!
          	</p>
          </div>
            <h1></h1>
            <p></p>
            <br>
            <br>
          </div>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>

  <br>
  <br>


	<!-- start features Area -->
	<section class="features-area section_gap">
		<div class="container">
			<div class="row features-inner">
				<!-- single features -->
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="single-features">
						<div class="f-icon">
							<img src="imagens/outros/f-icon1.png" alt="">
						</div>
						<h6>Entrega imediata</h6>
						<p>Produto disponibilizado imediatamente para download</p>
					</div>
				</div>
				<!-- single features -->
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="single-features">
						<div class="f-icon">
							<img src="imagens/outros/f-icon2.png" alt="">
						</div>
						<h6>Materiais Revisados</h6>
						<p>Materiais revisados por professores</p>
					</div>
				</div>
				<!-- single features -->
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="single-features">
						<div class="f-icon">
							<img src="imagens/outros/f-icon3.png" alt="">
						</div>
						<h6>Suporte</h6>
						<p>Suporte 24/7</p>
					</div>
				</div>
				<!-- single features -->
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="single-features">
						<div class="f-icon">
							<img src="imagens/outros/f-icon4.png" alt="">
						</div>
						<h6>Pagamento Seguro</h6>
						<p>Aqui seus dados ficam seguros com a gente</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- end features Area -->

	

	<!-- start product Area -->
	<!-- <section class="owl-carousel active-product-area section_gap"> -->
		<!-- single product slide -->
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>Materiais Didáticos</h1>
							<p>Todos os materiais didáticos disponiveis</p>
						</div>
					</div>
				</div>
				<div class="row">
					<?php

					// if(isset($_SESSION['msg'])){
					// 	echo $_SESSION['msg'];
					// 	unset($_SESSION['msg']);
					// }

					$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Português'";
					$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
					while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
						echo('<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="imagens/produtos/p7.jpg" alt="">
							<div class="product-details">
								<h6>'.$row_usuario['titulo_produto'].'</h6>
								<h6>'.$row_usuario['disciplina'].'</h6>
								<div class="price">
									<h6>R$'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
									<h6 class="l-through">'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
								</div>
								<div class="prd-bottom"> 

									<a href="carrinho_compras/carrinho.php?add=carrinho&id='.$row_usuario["id"].'" class="social-info">
										<span class="ti-bag"></span>
										<p class="hover-text">Adicionar</p>
									</a>
									
									<a href="single-product.php?id='.$row_usuario["id"].'" class="social-info">
										<span class="lnr lnr-arrow-right-circle"></span>
										<p class="hover-text">Ver Mais</p>
									</a>
									');
									if (isset($_SESSION["tipo_usuario"]) && $_SESSION["tipo_usuario"] == "admin")
										echo ("<a href='add-product/add-product/change-product.php?id=".$row_usuario['id']."' class='social-info'>
											<span class='lnr lnr-cog'></span>
											<p class='hover-text'>Editar</p>
										</a>");
									echo ('
								</div>
							</div>
						</div>
					</div> ');

					}

					$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Inglês'";
					$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
					while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
						echo('<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="imagens/produtos/p1.jpg" alt="">
							<div class="product-details">
								<h6>'.$row_usuario['titulo_produto'].'</h6>
								<h6>'.$row_usuario['disciplina'].'</h6>
								<div class="price">
									<h6>R$'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
									<h6 class="l-through">'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
								</div>
								<div class="prd-bottom"> 

								<a href="carrinho_compras/carrinho.php?add=carrinho&id='.$row_usuario["id"].'" class="social-info">
									<span class="ti-bag"></span>
									<p class="hover-text">Adicionar</p>
								</a>
									
									<a href="single-product.php?id='.$row_usuario["id"].'" class="social-info">
										<span class="lnr lnr-arrow-right-circle"></span>
										<p class="hover-text">Ver Mais</p>
									</a>
									');
									if (isset($_SESSION["tipo_usuario"]) && $_SESSION["tipo_usuario"] == "admin")
										echo ("<a href='add-product/add-product/change-product.php?id=".$row_usuario['id']."' class='social-info'>
											<span class='lnr lnr-cog'></span>
											<p class='hover-text'>Editar</p>
										</a>");
									echo ('
								</div>
							</div>
						</div>
					</div> ');

					}
					
					$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Matemática Discreta'";
					$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
					while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
						echo('<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="imagens/produtos/p6.jpg" alt="">
							<div class="product-details">
								<h6>'.$row_usuario['titulo_produto'].'</h6>
								<h6>'.$row_usuario['disciplina'].'</h6>
								<div class="price">
									<h6>R$'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
									<h6 class="l-through">'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
								</div>
								<div class="prd-bottom"> 

								<a href="carrinho_compras/carrinho.php?add=carrinho&id='.$row_usuario["id"].'" class="social-info">
									<span class="ti-bag"></span>
									<p class="hover-text">Adicionar</p>
								</a>
									
									<a href="single-product.php?id='.$row_usuario["id"].'" class="social-info">
										<span class="lnr lnr-arrow-right-circle"></span>
										<p class="hover-text">Ver Mais</p>
									</a>
									');
									if (isset($_SESSION["tipo_usuario"]) && $_SESSION["tipo_usuario"] == "admin")
										echo ("<a href='add-product/add-product/change-product.php?id=".$row_usuario['id']."' class='social-info'>
											<span class='lnr lnr-cog'></span>
											<p class='hover-text'>Editar</p>
										</a>");
									echo ('
								</div>
							</div>
						</div>
					</div> ');

					}

					$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Laboratório de Hardware'";
					$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
					while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
						echo('<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="imagens/produtos/p4.jpg" alt="">
							<div class="product-details">
								<h6>'.$row_usuario['titulo_produto'].'</h6>
								<h6>'.$row_usuario['disciplina'].'</h6>
								<div class="price">
									<h6>R$'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
									<h6 class="l-through">'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
								</div>
								<div class="prd-bottom"> 

								<a href="carrinho_compras/carrinho.php?add=carrinho&id='.$row_usuario["id"].'" class="social-info">
									<span class="ti-bag"></span>
									<p class="hover-text">Adicionar</p>
								</a>

									<a href="single-product.php?id='.$row_usuario["id"].'" class="social-info">
										<span class="lnr lnr-arrow-right-circle"></span>
										<p class="hover-text">Ver Mais</p>
									</a>
									');
									if (isset($_SESSION["tipo_usuario"]) && $_SESSION["tipo_usuario"] == "admin")
										echo ("<a href='add-product/add-product/change-product.php?id=".$row_usuario['id']."' class='social-info'>
											<span class='lnr lnr-cog'></span>
											<p class='hover-text'>Editar</p>
										</a>");
									echo ('
								</div>
							</div>
						</div>
					</div> ');

					}

					$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Administração Geral'";
					$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
					while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
						echo('<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="imagens/produtos/p3.jpg" alt="">
							<div class="product-details">
								<h6>'.$row_usuario['titulo_produto'].'</h6>
								<h6>'.$row_usuario['disciplina'].'</h6>
								<div class="price">
									<h6>R$'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
									<h6 class="l-through">'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
								</div>
								<div class="prd-bottom"> 

								<a href="carrinho_compras/carrinho.php?add=carrinho&id='.$row_usuario["id"].'" class="social-info">
									<span class="ti-bag"></span>
									<p class="hover-text">Adicionar</p>
								</a>
									
									<a href="single-product.php?id='.$row_usuario["id"].'" class="social-info">
										<span class="lnr lnr-arrow-right-circle"></span>
										<p class="hover-text">Ver Mais</p>
									</a>
									');
									if (isset($_SESSION["tipo_usuario"]) && $_SESSION["tipo_usuario"] == "admin")
										echo ("<a href='add-product/add-product/change-product.php?id=".$row_usuario['id']."' class='social-info'>
											<span class='lnr lnr-cog'></span>
											<p class='hover-text'>Editar</p>
										</a>");
									echo ('
								</div>
							</div>
						</div>
					</div> ');

					}

					$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Algoritmos e Lógica de Programação'";
					$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
					while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
						echo('<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="imagens/produtos/p2.jpg" alt="">
							<div class="product-details">
								<h6>'.$row_usuario['titulo_produto'].'</h6>
								<h6>'.$row_usuario['disciplina'].'</h6>
								<div class="price">
									<h6>R$'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
									<h6 class="l-through">'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
								</div>
								<div class="prd-bottom"> 

								<a href="carrinho_compras/carrinho.php?add=carrinho&id='.$row_usuario["id"].'" class="social-info">
									<span class="ti-bag"></span>
									<p class="hover-text">Adicionar</p>
								</a>
									
									<a href="single-product.php?id='.$row_usuario["id"].'" class="social-info">
										<span class="lnr lnr-arrow-right-circle"></span>
										<p class="hover-text">Ver Mais</p>
									</a>
									');
									if (isset($_SESSION["tipo_usuario"]) && $_SESSION["tipo_usuario"] == "admin")
										echo ("<a href='add-product/add-product/change-product.php?id=".$row_usuario['id']."' class='social-info'>
											<span class='lnr lnr-cog'></span>
											<p class='hover-text'>Editar</p>
										</a>");
									echo ('
								</div>
							</div>
						</div>
					</div> ');

					}


					$result_usuarios = "SELECT * FROM arquivos WHERE disciplina = 'Arquitetura e Organização de Computadores'";
					$resultado_usuarios = mysqli_query($conexao, $result_usuarios);
					while($row_usuario = mysqli_fetch_assoc($resultado_usuarios)){
						echo('<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="imagens/produtos/p5.jpg" alt="">
							<div class="product-details">
								<h6>'.$row_usuario['titulo_produto'].'</h6>
								<h6>'.$row_usuario['disciplina'].'</h6>
								<div class="price">
									<h6>R$'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
									<h6 class="l-through">'.number_format($row_usuario["preco"], 2, ',', '').'</h6>
								</div>
								<div class="prd-bottom"> 

								<a href="carrinho_compras/carrinho.php?add=carrinho&id='.$row_usuario["id"].'" class="social-info">
									<span class="ti-bag"></span>
									<p class="hover-text">Adicionar</p>
								</a>
								
									<a href="single-product.php?id='.$row_usuario["id"].'" class="social-info">
										<span class="lnr lnr-arrow-right-circle"></span>
										<p class="hover-text">Ver Mais</p>
									</a>
									');
									if (isset($_SESSION["tipo_usuario"]) && $_SESSION["tipo_usuario"] == "admin")
										echo ("<a href='add-product/add-product/change-product.php?id=".$row_usuario['id']."' class='social-info'>
											<span class='lnr lnr-cog'></span>
											<p class='hover-text'>Editar</p>
										</a>");
									echo ('
								</div>
							</div>
						</div>
					</div> ');

					}
					?>
				</div>
			</div>
		</div>

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