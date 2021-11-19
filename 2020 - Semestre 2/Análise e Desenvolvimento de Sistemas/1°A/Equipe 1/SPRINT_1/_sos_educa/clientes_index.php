<div id="sair">
  <?php 
    session_start();
    if(!isset($_SESSION['usuario']) && !isset($_SESSION['senha'])){
      header("location:login_cliente_geral.php");
      exit;          
    }else{
      echo "<center><h2 class='text-white bg-primary shadow-lg rounded m-0'><br>Área de Clientes <br><br></h2></center>";
    }
    
  ?>
</div>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Login Cliente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  
    <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>

    <style type="text/css">
    	body{
    background:url("https://lohcus.com.br/wp-content/uploads/2015/09/Fundo-Artigos-videos-04.png");    
    }
    .main-container{
        margin-top:40px; 
    
        
    }
    .widget-author {
    margin-bottom: 58px;
    }
    .author-card {
    position: relative;
    padding-bottom: 48px;
    background-color: #fff;
    box-shadow: 0 12px 20px 1px rgba(64, 64, 64, .09);
    
    
    }
    .author-card .author-card-cover {
    position: relative;
    width: 100%;
    height: 100px;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    }
    .author-card .author-card-cover::after {
    display: block;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    content: '';
    opacity: 0.5;
    }
    .author-card .author-card-cover > .btn {
    position: absolute;
    top: 12px;
    right: 12px;
    padding: 0 10px;
    }
    .author-card .author-card-profile {
    display: table;
    position: relative;
    margin-top: -22px;
    padding-right: 15px;
    padding-bottom: 16px;
    padding-left: 20px;
    z-index: 5;
    
    }
    .author-card .author-card-profile .author-card-avatar, .author-card .author-card-profile .author-card-details {
    display: table-cell;
    vertical-align: middle;
    
    }
    .author-card .author-card-profile .author-card-avatar {
    width: 85px;
    border-radius: 50%;
    box-shadow: 0 8px 20px 0 rgba(0, 0, 0, .15);
    overflow: hidden;
    }
    .author-card .author-card-profile .author-card-avatar > img {
    display: block;
    width: 100%;
    }
    .author-card .author-card-profile .author-card-details {
    padding-top: 20px;
    padding-left: 15px;
    }
    .author-card .author-card-profile .author-card-name {
    margin-bottom: 2px;
    font-size: 14px;
    font-weight: bold;
    }
    .author-card .author-card-profile .author-card-position {
    display: block;
    color: #8c8c8c;
    font-size: 12px;
    font-weight: 600;
    }
    .author-card .author-card-info {
    margin-bottom: 0;
    padding: 0 25px;
    font-size: 13px;
    
    }
    .author-card .author-card-social-bar-wrap {
    position: absolute;
    bottom: -18px;
    left: 0;
    width: 100%;
    }
    .author-card .author-card-social-bar-wrap .author-card-social-bar {
    display: table;
    margin: auto;
    background-color: #fff;
    box-shadow: 0 12px 20px 1px rgba(64, 64, 64, .11);
    }
    .btn-style-1.btn-white {
        background-color: #fff;
    }
    .list-group-item i {
        display: inline-block;
        margin-top: -1px;
        margin-right: 8px;
        font-size: 1.2em;
        vertical-align: middle;
    }
    .mr-1, .mx-1 {
        margin-right: .25rem !important;
    }

    .list-group-item.active:not(.disabled) {
        border-color: #e7e7e7;
        background: #fff;
        color: #ac32e4;
        cursor: default;
        pointer-events: none;
    }
    .list-group-flush:last-child .list-group-item:last-child {
        border-bottom: 0;
    }

    .list-group-flush .list-group-item {
        border-right: 0 !important;
        border-left: 0 !important;
    }

    .list-group-flush .list-group-item {
        border-right: 0;
        border-left: 0;
        border-radius: 0;
    }
    .list-group-item.active {
        z-index: 2;
        color: #fff;
        background-color: #007bff;
        border-color: #007bff;
    }
    .list-group-item:last-child {
        margin-bottom: 0;
        border-bottom-right-radius: .25rem;
        border-bottom-left-radius: .25rem;
    }
    a.list-group-item, .list-group-item-action {
        color: #404040;
        font-weight: 600;
    }
    .list-group-item {
        padding-top: 16px;
        padding-bottom: 16px;
        -webkit-transition: all .3s;
        transition: all .3s;
        border: 1px solid #e7e7e7 !important;
        border-radius: 0 !important;
        color: #404040;
        font-size: 12px;
        font-weight: 600;
        letter-spacing: .08em;
        text-transform: uppercase;
        text-decoration: none;
    }
    .list-group-item {
        position: relative;
        display: block;
        padding: .75rem 1.25rem;
        margin-bottom: -1px;
        background-color: #fff;
        border: 1px solid rgba(0,0,0,0.125);
    }
</style>
<?php include('cabecalho.php');?>
    <title>Login Cliente</title>
   
    <script type="text/javascript">
      $(document).ready(function() {
          $('.dica + span')
          .css({display:'none',
                border: '1px solid #336600',
                padding:'2px 4px',
                background:'#999966',
                marginLeft:'10px'   });
          $('.dica').focus(function() {
            $(this).next().fadeIn(1500);    	 	
          })
          .blur(function(){
            $(this).next().fadeOut(1500);
          });
      });
    </script>

    <?php include('conexao.php');?>
    </style>
</head>
<body>
<?php include('navbar.php');?>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

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
                    <a class="list-group-item" href="logout_clientes.php"><i class="fa fa-user text-muted"></i>Sair</a>
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