<?php
session_start();
include 'conexao.php';
$itens = $_SESSION['itens']; // peguei o id de cada produto comprado
$email = $_SESSION['email'];
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
  <link href="select.css" rel="stylesheet">


<style> 
 input[type=submit] {
  background-color: #5B2CBF;
  border: none;
  color: white;
  padding: 5px 5px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>


</head>


<body>

	<!-- Start Header Area -->
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

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>checkout</h1>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->


	<!--================Product Description Area =================-->
	<section class="product_description_area">
		<div class="container">
			<!--=================================-->	
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item">
					<a class="nav-link" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Cartão</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile"
					 aria-selected="false">Boleto</a>
				</li>
				<!--<li class="nav-item">
					<a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact"
					 aria-selected="false">Créditos</a>
				</li>-->
				

			</ul>
			  
			<!--================ =================-->		
			<div class="tab-content" id="myTabContent"> 
				<!--================DIV 1 =================-->
				<div class="tab-pane fade" id="home" role="tabpanel" aria-labelledby="home-tab">
				<!--================DIV 1 =================-->	


		<section class="checkout_area section_gap" style="padding-top: 10px;">
        <div class="container">
             
            <div class="billing_details">
               <div class="row">

                <div class="col-lg-8">



                            <h3>Cartão de crédito</h3>
                       
                    
						 <div class="form-row">
						    
				</div>

						  	<?php

					  	$email = $_SESSION['email'];
						$query = "select * from cartao where email_usuario = '$email'";
						$result = mysqli_query ($conexao, $query);
					    $row = mysqli_num_rows ($result);
					    $user = mysqli_fetch_assoc($result);

						$result = mysqli_query($conexao, $query); 
						 if (mysqli_num_rows($result) !=0) {
						 	$email = $_SESSION['email'];
							
					   echo('<br>
						  
						  <div class="form-group">
						    <label for="inputAddress">Titular do cartão</label>
						    <input type="text" class="form-control"  name="titulo" style="width: 400px" value="'.$user['titulo'].'">
						  </div>
						  <div class="form-group">
						    <label for="inputAddress2">Número do cartão</label>
						    <input type="text" class="form-control" name="numerocard"  style="width: 400px" value="'.$user['numero'].'">
						  </div>
						   <div class="input-group mb-3">
							<div class="row">
							  <div class="col-md-4 col-xs-4">
							    <div class="form-group">
							      <label for="volumeBolsa">Validade</label>
							      <input type="text" class="form-control" name="Validade" maxlength="4" value="'.$user['validade'].'">
							    
							    </div>
							  </div>
							  <div class="col-md-4 col-xs-4">
							    <div class="form-group">
							      <label for="volumeBolsa">CVV</label>
							      <input type="text" class="form-control" name="cvv" maxlength="4" value="'.$user['cvv'].'">
							      </div>
						</div>	     
					
							    </div>
							  </div>');
               }
               else {
               	
               	 echo ('Você não tem nenhum cartão cadastrado :( </br>
               	 	<br>
               	 	<a href="cadastrar.php" class="genric-btn primary small">cadastrar cartão</a>
               	 	<br>
               	');
               }
               ?>
						<br>
					</form>
								
				<div class="product_count">
					   
					<?php

			   		$preco = 0.0;
					$conexao = new PDO ('mysql:host=localhost;dbname=bd_pi01',"root","");
						foreach($itens as $idArquivos=>$quantidade)
						{
						$select = $conexao->prepare("SELECT * FROM arquivos WHERE id=?");
						$select->bindParam(1,$idArquivos);
						$select->execute();
						$arquivos = $select->fetchALL();
						$preco = floatval($arquivos[0]['preco']) + $preco;
						}
					?>	
					<form method="POST" action="carrinho_compras/finalizar.php">
					<label for="Parcelas">Parcelas</label>
							<input class="foo" type="number" min="1" max="12" maxlength="4" value="1" id="parcelas" name="parcelas">
							até <b>12x </b>sem juros.
							<!-- <button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst )) result.value++;return false;" class="increase items-count" type="button"><i class="lnr lnr-chevron-up"></i></button>
							<button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst ) &amp;&amp; sst > 0 ) result.value--;return false;" class="reduced items-count" type="button"><i class="lnr lnr-chevron-down"></i></button> -->

						</div>
						
						
						

					<!--<div class="button-group-area mt-40">
						<a href="#" class="genric-btn primary small">Usar outro cartão</a></div>-->

                    </div> 

                    <div class="col-lg-4">
					
                        <div class="order_box">
                        		  
                            <h2>Seu pedido</h2>
                            <div>
							  <div class="form-group row">
							  	 <input type="hidden" name="email_usuario" id="email_usuario" value="<?php echo($_SESSION['email']); ?>">
							  	<input type="hidden" name="id" value="">
							  	
							    <label for="staticEmail" class="col-sm-2 col-form-label">Itens:</label>
							    <div class="col-sm-10">
									<?php

										$preco = 0.0;
										$conexao = new PDO ('mysql:host=localhost;dbname=bd_pi01',"root","");
										foreach($itens as $idArquivos=>$quantidade)
										{
											$select = $conexao->prepare("SELECT * FROM arquivos WHERE id=?");
											$select->bindParam(1,$idArquivos);
											$select->execute();
											$arquivos = $select->fetchALL();
											echo(
											$arquivos[0]["titulo_produto"].'<br>
											preço: R$
											'.$arquivos[0]["preco"].'<br>')
											;

											$preco = floatval($arquivos[0]['preco']) + $preco;
										}
									?>	
							    </div>
							  </div>
							  <div class="form-group row">
							    <label for="staticEmail" class="col-sm-2 col-form-label">Total: </label>
							    <div class="col-sm-10">
							      <input type="text" readonly class="form-control-plaintext" id="preco" name="preco" value="R$ <?php echo($preco); ?>">
							    </div>
							  </div>
							  <hr/>
							</div>
							<input type="hidden" name="metodopag" id="metodopag" value="cartao">
							
				
							<input type="submit" name="Enviar" style="width: 250px;">
						</form>
                        
                         
                            

							

                            
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </section>



    			<!--================DIV 1 =================-->
				</div>
				<!--================ FIM DIV 1 =================-->

				<!--================ DIV 2 =================-->
				<div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
				


	<section class="checkout_area section_gap" style="padding-top: 10px;">
        <div class="container">
             
            <div class="billing_details">
               <div class="row">

                
               	<!---------------boleto--------------->
                            
              	<?php
					  	// $email = $_SESSION['email'];
						// $query = "select * from usuario where email = '$email'";
					    // $result = mysqli_query ($conexao, $query);
					    // $row = mysqli_num_rows($result);
					    // $user = mysqli_fetch_assoc($result);

						echo('<div class="col-lg-8">
                        <h3>Boleto</h3>
                         <div class="form-row">
						    <div class="form-group col-md-6">
						     
						      <label for="nome">Nome completo</label>
						      <input type="text" class="form-control" id="nome" value="'.$_SESSION['nome'].'">
						    </div>
						   
						       
						   <div class="form-group col-md-6">
						      <label for="email_usuario">E-mail</label>
						      <input type="text" class="form-control" id="email_usuario" name="email_usuario" value="'.$_SESSION['email'].'">
						    </div>
						</div> ');
                  
                   ?>

                   <!--<div class="button-group-area mt-40">
						<a href="#" class="genric-btn primary small">Editar</a></div>-->
			

					

                    </div>
					<?php

						$preco = 0.0;
						$conexao = new PDO ('mysql:host=localhost;dbname=bd_pi01',"root","");
						foreach($itens as $idArquivos=>$quantidade)
						{
							$select = $conexao->prepare("SELECT * FROM arquivos WHERE id=?");
							$select->bindParam(1,$idArquivos);
							$select->execute();
							$arquivos = $select->fetchALL();
							

							$preco = floatval($arquivos[0]['preco']) + $preco;
						}
?>	
				
                    <div class="col-lg-4">
                        <div class="order_box">
                            <h2>Seu pedido</h2>
                            <form method="POST" action="carrinho_compras/finalizar.php">
                            	<div>
							  <div class="form-group row">

							    <label for="staticEmail" class="col-sm-2 col-form-label">Itens:</label>
							    <div class="col-sm-10">
									<?php
										$preco = 0.0;
										$conexao = new PDO ('mysql:host=localhost;dbname=bd_pi01',"root","");
										foreach($itens as $idArquivos=>$quantidade)
										{
											$select = $conexao->prepare("SELECT * FROM arquivos WHERE id=?");
											$select->bindParam(1,$idArquivos);
											$select->execute();
											$arquivos = $select->fetchALL();
											echo(
											$arquivos[0]["titulo_produto"].'<br/>
											Preço:
											'.$arquivos[0]["preco"].'<br/>')
											;

											$preco = floatval($arquivos[0]['preco']) + $preco;
										}
									?>
							    </div>
							  </div>
							  <div class="form-group row">
							    <label for="staticEmail" class="col-sm-2 col-form-label">Total:</label>
							    <div class="col-sm-10">
							      <input type="text" readonly class="form-control-plaintext" id="preco" name="preco" value="R$<?php echo($preco); ?>">
							      <hr/>
							    </div>
							  </div>
							</div>
							<input type="hidden" name="metodopag" id="metodopag" value="boleto">
							<input type="hidden" name="parcelas" id="parcelas" value="1">
							<input type="submit" name="Enviar" style="width: 250px;">
							
				</form>
							


                    
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </section>





				</div>
				<!--================ FIM DIV 2 =================-->




<!--================--------------------------------------------------------------PAGAMENTO COM CRÉDITOS-------------------------------------------------------- =================-->
				<div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">


		<section class="checkout_area section_gap" style="padding-top: 10px;">
        <div class="container">
             
            <div class="billing_details">
               <div class="row">

                <div class="col-lg-8">



                            <h3>Créditos</h3>

                            Saldo disponivel: <input type="text" readonly class="form-control-plaintext" id="preco" name="preco" value="R$" style="width: 80px;">
							
							
							
						
						

					<!--<div class="button-group-area mt-40">
						<a href="#" class="genric-btn primary small">Usar outro cartão</a></div>-->

                    </div> 

                    <div class="col-lg-4">
					
                        <div class="order_box">
                        		  
                            <h2>Seu pedido</h2>
                            <div>
                            	 <form method="POST" action="carrinho_compras/finalizar.php">
							  <div class="form-group row">
							  	 <input type="hidden" name="email_usuario" id="email_usuario" value="<?php echo($_SESSION['email']); ?>">
							  	<input type="hidden" name="id" value="">
							  	
							    <label for="staticEmail" class="col-sm-2 col-form-label">Itens:</label>
							    <div class="col-sm-10">
									<?php

										$preco = 0.0;
										$conexao = new PDO ('mysql:host=localhost;dbname=bd_pi01',"root","");
										foreach($itens as $idArquivos=>$quantidade)
										{
											$select = $conexao->prepare("SELECT * FROM arquivos WHERE id=?");
											$select->bindParam(1,$idArquivos);
											$select->execute();
											$arquivos = $select->fetchALL();
											echo(
											$arquivos[0]["titulo_produto"].'<br>
											preço: R$
											'.$arquivos[0]["preco"].'<br>')
											;

											$preco = floatval($arquivos[0]['preco']) + $preco;
										}
									?>	
							    </div>
							  </div>
							  <div class="form-group row">
							    <label for="staticEmail" class="col-sm-2 col-form-label">Total: </label>
							    <div class="col-sm-10">
							      <input type="text" readonly class="form-control-plaintext" id="preco" name="preco" value="R$ <?php echo($preco); ?>">
							    </div>
							  </div>
							  <hr/>
							</div>
							<input type="hidden" name="metodopag" id="metodopag" value="credito">
							
				
							<input type="submit" name="Enviar" style="width: 250px;">
						</form>
                        
                         
                            

							

                            
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </section>



    			<!--================DIV 1 =================-->
				</div>
				<!--================ FIM DIV 1 =================-->






				</div>
			<!--================ =================-->	
			</div>
		<!--================ =================-->	
		</div>
	</section>
	<!--================End Product Description Area =================-->



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
   			  <!--<li><a href="https://www.linkedin.com/in/bryan-santos-77b53317b/" target="_blank">Bryan Santos</a></li> -->
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



			<!-- mascara inputs -->


			<!-- mascara inputs -->

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