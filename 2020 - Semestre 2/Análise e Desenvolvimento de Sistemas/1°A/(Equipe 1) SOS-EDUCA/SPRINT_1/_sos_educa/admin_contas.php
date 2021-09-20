<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Contas - Admin</title>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link rel="stylesheet" href="css/admin/css/fontawesome.min.css">
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="css/admin/css/bootstrap.min.css">
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="css/admin/css/templatemo-style.css">
    <!--
	Product Admin CSS Template
	https://templatemo.com/tm-524-product-admin
    -->
    <script src="css/admin/js/jquery-3.3.1.min.js"></script>
    <!-- https://jquery.com/download/ -->
    <script src="css/admin/js/moment.min.js"></script>
    <!-- https://momentjs.com/ -->
    <script src="css/admin/js/Chart.min.js"></script>
    <!-- http://www.chartjs.org/docs/latest/ -->
    <script src="css/admin/js/bootstrap.min.js"></script>
    <!-- https://getbootstrap.com/ -->
    <script src="css/admin/js/tooplate-scripts.js"></script>

    
    <?php session_start() ?>
    <?php
        include("conexao.php"); 
        
      ?>

  </head>

  <body id="reportsPage">
    <div class="" id="home">
      <nav class="navbar navbar-expand-xl">
        <div class="container h-100">
          <a class="navbar-brand" href="admin_index.php">
            <h1 class="tm-site-title mb-0">Painel do Administrador</h1>
          </a>
          <button
            class="navbar-toggler ml-auto mr-0"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <i class="fas fa-bars tm-nav-icon"></i>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto h-100">
                        <li class="nav-item">
                            <a class="nav-link" href="admin_index.php">
                                <i class="fas fa-tachometer-alt"></i>
                                Dashboard
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item dropdown">

                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-file-alt"></i>
                                <span>
                                    Relatórios 
                                </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="admin_relvendas.php">Relatório de Vendas</a>
                                <a class="dropdown-item" href="admin_relclientes.php">Relatório de Clientes</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="admin_produto.php">
                                <i class="fas fa-shopping-cart"></i>
                                Produtos
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-gamepad"></i>
                                <span>
                                    Jogos 
                                </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="./jogo_velha/index.html"target="_blank">Jogo da Velha</a>
                            <a class="dropdown-item" href="./jogo_forca/index.html"target="_blank">Jogo da Forca</a>
                            <a class="dropdown-item" href="./jogo_memoria/index.html"target="_blank">Jogo da Memória</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="admin_msgclientes.php">
                                <i class="fa fa-envelope"></i>
                                Mensagens
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="admin_contas.php">
                                <i class="far fa-user"></i>
                                Contas
                            </a>
                        </li>
             
            </ul>
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link d-block" href="login.php">
                  Admin, <b>Logout</b>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <div class="container mt-5">
        <div class="row tm-content-row">
          <div class="col-12 tm-block-col">
            <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
            <form action="cadastrar_admin.php" name="upload_insere" method="post" enctype="multipart/form-data" class="tm-edit-product-form">
              <h2 class="tm-block-title">Incluir uma Conta de Administrador</h2>
              
                <div class="form-group mb-3">
                    <label
                      for="name"
                      >Nome do Admin
                    </label>
                    <input
                      
                      id="name"
                      name="nome_func"
                      type="text"
                      class="form-control validate"
                      required
                      placeholder="Digite o nome do Novo Admin"
                      value="<?php echo @$_SESSION['nome_func']?>"
                    />
                  </div>
                  <div class="form-group mb-3">
                    <label
                      for="login"
                      >E-mail do Admin
                    </label>
                    <input
                      
                      id="login"
                      name="login_func"
                      type="text"
                      class="form-control validate"
                      required
                      placeholder="Digite o e-mail para Login do Novo Admin"
                      value="<?php echo @$_SESSION['login_func']?>"
                    />
                  </div>
                  <div class="form-group mb-3">
                    <label
                      for="senha"
                      >Senha do Admin
                    </label>
                    <input
                      
                      id="senha"
                      name="senha_func"
                      type="text"
                      class="form-control validate"
                      required
                      placeholder="Digite a senha para Login do Novo Admin"
                      value="<?php echo @$_SESSION['senha_func']?>"
                    />
                  </div>
                  <div class="form-group mb-3">
                  <label class="tm-hide-sm">&nbsp;</label>
                  <button
                    type="submit"
                    class="btn btn-primary btn-block text-uppercase"
                  >
                   Incluir Perfil
                  </button>
                </div>
            </div>
          </div>
        </div>
        <!-- row -->
        
        <div class="row tm-content-row">
          <div class="col-12 tm-block-col">
            <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
      
           
              <h2 class="tm-block-title">Configurações da Conta</h2>
              <form action="alterar_admin.php" class="tm-signup-form row">
                <div class="form-group mb-3">
                  <label for="email">E-mail da Conta</label>
                  <input
                      id="email"
                      name="login_func_new"
                      type="email"
                      class="form-control validate"
                      required
                      placeholder="Digite o Novo e-mail"
                      
                  />
                </div>
                <div class="form-group mb-3">
                  <label for="password">Senha</label>
                  <input
                      id="password"
                      name="senha_func_new"
                      type="password"
                      class="form-control validate"
                      required
                      placeholder="Digite a Nova Senha"
                      
                  />
                </div>
                
                <div class="form-group mb-3">
                  <label for="password2">Digite novamente a Senha</label>
                  <input
                    id="password2"
                    name="senha_func_confirmar"
                    type="password"
                    class="form-control validate"
                    required
                    placeholder="Confirmar Senha"
                    
                  />
                </div>
                <div class="form-group mb-3">
                  <label class="tm-hide-sm">&nbsp;</label>
                  <button
                    type="submit"
                    class="btn btn-primary btn-block text-uppercase"
                  >
                    Atualize seu Perfil
                  </button>
                </div>

                
              </form>
            </div>
          </div>
        </div>
      </div>
      <footer class="tm-footer row tm-mt-small">
        <div class="col-12 font-weight-light">
          <p class="text-center text-white mb-0 px-4 small">
            Copyright &copy; Todos os direitos reservados - <b>SOS EDUCA</b>
            <strong> - 2020</strong>
          </p>
        </div>
      </footer>
    </div>

    <?php mysqli_close($conexao); ?>
  </body>
</html>
