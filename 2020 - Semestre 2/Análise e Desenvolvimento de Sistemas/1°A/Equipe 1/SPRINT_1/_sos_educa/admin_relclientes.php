<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Relatório de Clientes</title>

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

    <?php include('conexao.php');?>

    
  <?php 
    session_start(); 
    
    
  ?>

  </head>

  <body id="reportsPage">
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

                            <a class="nav-link dropdown-toggle" href="admin_relvendas.php" id="navbarDropdown" role="button" data-toggle="dropdown"
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
                            <a class="nav-link" href="admin_contas.php">
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
    
      
          <div class="tm-bg-primary-dark tm-block tm-block-products">
            <table class="table table-hover tm-table-large tm-product-table table-condensed printable">
                <thead style="text-align: center;">
                  <tr>
                    <th scope="col">NOME DO CLIENTE</th>
                    <th scope="col">CPF</th>
                    <th scope="col">TELEFONE</th>
                    <th scope="col">E-MAIL</th>
                    
                  </tr>
                </thead>
               
                        <?php
                            $resultado=mysqli_query($conexao,  "SELECT * FROM cliente");
                            if($resultado){
                                while($row = mysqli_fetch_assoc($resultado)){
                        ?>
                      <tbody style="text-align: center;">
                      <tr>
                        <td>
                            <?php 
                            echo "<p></p>".($row['nome']);
                            ?>
                        </td>
                        <td>
                            <?php 
                            echo "<p></p>".($row['cpf']);
                            ?>
                        </td>
                        <td>
                            <?php 
                            echo "<p></p>".($row['telefone']);
                            ?>
                        </td>
                        <td>
                            <?php 
                            echo "<p></p>".($row['email']);
                            ?>
                        </td>
                      </tr>
                      </tbody>
            <?php
                  }//fim do while
                }//fim do if
              ?>
                
              </table>
            
            <!-- table container -->

            <style>
                @media print {
                html, body {
                    margin: 20px;
                    padding: 0;
                    border: 0;
                }
                .printable {
                    margin: 0;
                    padding: 0;
                    border: 0;
                    font-size: 14px;
                }
                .printable ~ * {
                    display: none;
                }
                }
            </style>
            <script>
                function printBy(selector){

                var $print = $(selector)
                .clone()
                .addClass('print')
                .prependTo('body');
                
                // Stop JS execution
                window.print();
                
                // Remove div once printed
                $print.remove();
                }
            </script>
            <div class="btn btn-primary btn-block text-uppercase mb-3" onclick="printBy('.printable');">Exportar Relatório</div>
          </div>

        
    <footer class="tm-footer row tm-mt-small">
      <div class="col-12 font-weight-light">
        <p class="text-center text-white mb-0 px-4 small">
        Copyright &copy; Todos os direitos reservados - <b>SOS EDUCA</b>
            <strong> - 2020</strong>
          
         
        </p>
      </div>
    </footer>



  </body>
</html>