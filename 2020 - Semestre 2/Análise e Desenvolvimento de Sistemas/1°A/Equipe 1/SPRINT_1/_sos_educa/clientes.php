<?php 
  session_start();
  if(!isset($_SESSION['usuario']) && !isset($_SESSION['senha'])){
    header("location:login_cliente_geral.php");
    exit;          
  }else{
    echo "<center><h2 class='text-white bg-primary shadow-lg rounded m-0'><br>Área de Clientes <br><br></h2></center>";
  }
    
?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <?php include('cabecalho.php');?>
  <title>Login Cliente</title>
  <?php include('conexao.php');?>
</head>

<body>
    <?php include('navbar.php');?>
    
    <div class="container mb-4 main-container">
    <div class="row">
        <div class="col-lg-4 pb-5">
            <!-- Account Sidebar-->
            <div class="author-card pb-3">
                <div class="author-card-cover" style="background-image:url(https://image.freepik.com/free-photo/back-school-education-banner-background_8087-1192.jpg);"><a class="btn btn-style-1 btn-white btn-sm" href="#" data-toggle="tooltip" title="" data-original-title="You currently have 290 Reward points to spend"></a></div>
                <div class="author-card-profile">
                    <div class="author-card-avatar"><img src="images/users.png" alt="<?php ($_SESSION['nome_cliente'])?>">
                    </div>
                    <div class="author-card-details">
                    <?php
                    echo "<h5 class='author-card-name text-lg'>".($_SESSION['nome_cliente'])."</h5>"?><span class="author-card-position">Bem vindo(a) de volta!</span>  
                     
                    </div>
                </div>
            </div>
            <div class="wizard">
            <nav class="list-group list-group-flush">
                    <a class="list-group-item" href="clientes_index.php"><i class="fa fa-shopping-cart mr-1 text-muted"></i> Histórico de Pedidos</a>
                    <a class="list-group-item" href="cliente_cadastro_mudanca.php"><i class="fa fa-user text-muted"></i> Atualização de Cadastro</a>
                    <a class="list-group-item" href="cliente_senha.php"><i class="fa fa-lock text-muted bg-write"></i> Atualização de Senha</a>
                    <a class="list-group-item" href="descontos.php"><i class="fa fa-tag mr-1 text-muted"></i>  Saldo de Créditos</a>
                    <a class="list-group-item" href="logout_clientes.php"><i class="fa fa-user text-muted"></i> Sair</a>
                </nav>
            </div>
        </div>
        <div class="col-lg-8 pb-5">
        <div class="embed-responsive embed-responsive-16by9">
        <iframe src="pedidoscliente.php"  title="Iframe Example"></iframe>
        </div>
        <!-- Orders Table-->
        
    
</div>
  
</body>

</html>
