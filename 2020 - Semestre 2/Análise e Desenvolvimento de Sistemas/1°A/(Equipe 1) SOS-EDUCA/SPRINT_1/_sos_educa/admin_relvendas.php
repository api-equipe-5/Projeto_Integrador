<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Relatório de Vendas</title>

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
    
    <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

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

                            <a class="nav-link dropdown-toggle" href="admin_relclientes.php" id="navbarDropdown" role="button" data-toggle="dropdown"
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

              <thead style="text-align: center;" >
                <tr >
                  <th>Cliente</th>
                  <th>Quantidade</th>
                  <th>Itens</th>
                  <th>Data da Compra</th>
                  <th>Total </th>
                  <th>Forma pagamento</th>
                </tr>
              </thead>  
              <script>
                function data($data){
                return date("d/m/Y", strtotime($data));
              }
              </script>
              <?php
                $resultado=mysqli_query($conexao,  "SELECT vd.*,cl.* from vendas as vd, cliente as cl  WHERE (vd.id_cliente=cl.id_cliente)" );
                
                
                  if($resultado){
                    while($row = mysqli_fetch_assoc($resultado)){
                      $idVenda = $row['id_venda'];
                      $itensVendidos=mysqli_query($conexao,  "SELECT it.*,pr.* from itens_venda as it, produtos as pr  WHERE (it.id_produto=pr.id_produto) AND (it.id_venda='$idVenda')" );
              ?>
                      <tbody style="text-align: center;">
                          <tr>
                            <td>
                              <?php echo ($row['nome']);?>
                            </td>
                            <td>
                              <?php echo ($row['qtd_itens']);?>
                            </td>
                            <td>
                              
                                <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseOne<?=$row['id_venda']?>" aria-expanded="false" aria-controls="collapseOne">
                                  Clique aqui para verificar os Itens comprados
                                </button>
                                <div id="collapseOne<?=$row['id_venda']?>" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                                  <ul>
                                    <?php while($rowItem = mysqli_fetch_assoc($itensVendidos)){
                                    ?>
                                    <li><?=$rowItem['nome_prod']?></li>
                                    <?php
                                  }
                                  ?>
                                  </ul>
                                </div>
                            </td>
                            <td>
                              <?php echo date("d/m/Y", strtotime($row['data_venda'])); ?>
                            </td>
                            <td>
                              <?php echo "R$: ".($row['total']);?>
                            </td>
                            <td>
                              <?php echo ($row['forma_pagamento']);?>
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

        
     

  


    
  </body>

</html>