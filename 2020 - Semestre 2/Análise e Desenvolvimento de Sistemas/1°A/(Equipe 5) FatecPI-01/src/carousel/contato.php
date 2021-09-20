<?php
session_start();
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
      <nav class="navbar navbar-expand-lg navbar-light main_box" style="height: 80px;">
        <div class="container">
          <!-- Brand and toggle get grouped for better mobile display -->
          <a class="navbar-brand logo_h" href="index.html"><img src="imagens/logo.png" width="150px"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
           aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
            <ul class="nav navbar-nav menu_nav ml-auto">
              <li class="nav-item active"><a class="nav-link" href="index.html">Inicio</a></li>
              <li class="nav-item submenu dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                 aria-expanded="false">Entrar</a>
                <ul class="dropdown-menu">
                  <li class="nav-item"><a class="nav-link" href="logar.php">Login</a></li>
                  <li class="nav-item"><a class="nav-link" href="cadastro.php">Cadastrar</a></li>
                </ul>
              </li>
              <li class="nav-item"><a class="nav-link" href="contato.php">Contato</a></li>
             
            </ul>
          </div>
        </div>
      </nav>
    </div>
    <div class="search_input" id="search_input_box">
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
        <a href="#" svg class="bd-placeholder-img"><img src="imagens/img1.jpg" width="100%" height="550px" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#777"/></svg></a>
        <div class="container">
          <div class="carousel-caption text-left">
            <h1>Seja bem vindo!</h1>
            <p>A Mr. Academy está feliz com sua presença em nosso site, obtenha conhecimento com nossos produtos. Faça seu login e vincule-se a nós.</p>
             <br>
            <br>
          </div>
        </div>
      </div>
      <div class="carousel-item">
         <a href="#" svg class="bd-placeholder-img"><img src="imagens/img2.jpg" width="100%" height="550px" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#777"/></svg></a>
        <div class="container">
          <div class="carousel-caption">
            <h1>Preparando você para o futuro</h1>
            <p>Tudo planejado e desenvolvido para o melhor do cliente, ambiente onde você se acomodar e ter um modo de estudos divertido e prazeroso, estudar nunca foi tão legal como na Mr. Academy</p>
            <br>
            <br>
          </div>
        </div>
      </div>
      <div class="carousel-item">
         <a href="#" svg class="bd-placeholder-img"><img src="imagens/img3.jpg" width="100%" height="550px" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img"><rect width="100%" height="100%" fill="#777"/></svg></a>
        <div class="container">
          <div class="carousel-caption text-right">
            <h1>Aqui você aprende mais!</h1>
            <p>A Mr. Academy preparou para você ótimos materiais didáticos para seus estudos, e o melhor, tudo isso por um preço que cabe no seu bolso. Aprenda conosco, você não vai se arrepender!</p>
             <br>
            <br>
          </div>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Anterior</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Próximo</span>
    </a>
  </div>
		<!-- End Banner Area -->

	<!--================Contact Area =================-->
		<section class="contact_area section_gap_bottom">
		<div class="container">
			<center><h2>Fale Conosco</h2></center>
			<center><p>Preencha os dados a seguir para entrar em contato conosco</p></center>
			<?php
		if(isset($_SESSION['msg'])){
			echo $_SESSION['msg'];
			unset($_SESSION['msg']);
		}
		?>
			<br>
			<br>
			<div class="row">
				<div class="col-lg-3">
					<div class="contact_info">
						<div class="info_item">

							<i class="lnr lnr-home"></i>
							<h6>São José Dos Campos/SP</h6>
							<p>Eugênio de Melo</p>
						</div>
						<div class="info_item">
							<i class="lnr lnr-phone-handset"></i>
							<h6><a href="#">(12) 9 9999-0000</a></h6>
							<p>Atendimento 24/7</p>
						</div>
						<div class="info_item">
							<i class="lnr lnr-envelope"></i>
							<h6><a href="#">support@mracademy.br</a></h6>
							<p>Nos mande sua dúvida a qualquer momento!</p>
						</div>
					</div>
				</div>
				<div class="col-lg-9">
					<form class="row contact_form" action="contact_process.php" method="post" id="contactForm" novalidate="novalidate">
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control" id="nome" name="nome" placeholder="Digite seu nome" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Digite seu nome'">
							</div>
							<div class="form-group">
								<input type="email" class="form-control" id="email" name="email" placeholder="Digite seu e-mail cadastrado" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Digite seu e-mail cadastrado'">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="assunto" name="assunto" placeholder="Digite o assunto" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Assunto da mensagem'">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<textarea class="form-control" name="mensagem" id="mensagem" rows="1" placeholder="Escreva sua mensagem..." onfocus="this.placeholder = ''" onblur="this.placeholder = 'Escreva sua mensagem...'"></textarea>
							</div>
						</div>
						<div class="col-md-12 text-right">
							<button type="submit" value="submit" class="primary-btn">Enviar Mensagem</button>
						</div>
					</form>
				</div>
			</div>
		</div>
</section>
	<!-- end product Area -->

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