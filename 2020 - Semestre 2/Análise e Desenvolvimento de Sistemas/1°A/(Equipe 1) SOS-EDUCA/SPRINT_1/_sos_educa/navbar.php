<!--Front End NavBar -->
     <!-- PRE LOADER -->
     <section class="preloader">
          <div class="spinner">

               <span class="spinner-rotate"></span>
               
          </div>
     </section>


     <!-- MENU -->
     <section class="navbar custom-navbar navbar-fixed-top" role="navigation">
          <div class="container">

               <div class="navbar-header">
                    <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                         <span class="icon icon-bar"></span>
                         <span class="icon icon-bar"></span>
                         <span class="icon icon-bar"></span>
                    </button>

                    <!-- lOGO TEXT HERE -->
                    <a href="#" class="navbar-brand"><img src="imagens/logo6.png" class="img-responsive" alt="placeholder+image" style="margin-top:-12px"height="100px" width="100px"></a>
               </div>

               <!-- MENU LINKS -->
               <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-nav-first">
                         <li><a href="index.php" class="smoothScroll">Início</a></li>
                         <li><a href="index.php#about" >Sobre</a></li>
                         <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                               <span>
                                    Jogos <i class="fa fa-angle-down"></i>
                                </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="./jogo_velha/index.html"target="_blank">Jogo da Velha</a>
                                <a class="dropdown-item" href="./jogo_forca/index.html"target="_blank">Jogo da Forca</a>
                                <a class="dropdown-item" href="./jogo_memoria/index.html"target="_blank">Jogo da Memória</a>
                            </div>
                        </li>
                         <li><a href="blog.php" class="smoothScroll">Notícias</a></li>
                         <li><a href="index_carrinho_cliente.php">Produtos</a></li>
                         <li><a href="index.php#contact" class="smoothScroll">Fale Conosco</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                         <li><a href="cadastro_cliente.php">Cadastro</a></li>
                         <li><a href="login.php">Login</a></li>
                         <li><a href="carrinho_cliente.php"><i class="fa fa-shopping-cart"></i></a></li>
                    </ul>
               </div>

          </div>
     </section>

<div vw class="enabled">
  <div vw-access-button class="active"></div>
    <div vw-plugin-wrapper>
      <div class="vw-plugin-top-wrapper"></div>
  </div>
</div>

<script src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
<script>
    new window.VLibras.Widget('https://vlibras.gov.br/app');
</script>