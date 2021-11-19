<!DOCTYPE html>
<html lang="pt-br">
<head>
	<?php include('cabecalho.php');?>
  <title>SOS Educa - Gerar boleto</title>
  <?php session_start(); ?>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css
">
  <link rel="stylesheet" href="css/login.css">
</head>
<body>
<?php include("conexao.php");?>
   
      <?php
        $pesquisa = $_SESSION['id_cliente'];
        $resultado=mysqli_query($conexao,  "SELECT vd.* from vendas as vd  WHERE vd.id_cliente=$pesquisa" );
   
    
            if($resultado){
                $credito = 0;
                while($row = mysqli_fetch_assoc($resultado)){
                $idVenda = $row['id_venda'];
                $itensVendidos=mysqli_query($conexao,  "SELECT it.*,pr.* from itens_venda as it, produtos as pr  WHERE (it.id_produto=pr.id_produto) AND (it.id_venda='$idVenda')" );
                $total = $row['total'];
  
            if($total>20){
                $credito = $credito + 1;
            }else{
                $credito = $credito;
            }
  
   
                }//fim do while
            }//fim do if
        ?>

                   
        <br>
      

        <p>
        <?php

            $restante = 5 - $credito;

            if($restante<=0){
                $desconto = "cupom";
            } else{
                $desconto = "";
            }  
        
        ?>


<div class="wrapper fadeInDown">
<div class="jumbotron">

      <div class="row">
      <div class="fadeIn first">
        <div class="col-md-8">
            <div class="card border-info shadow-lg mx-sm-2 p-4 round">
                <div class="card border-info shadow-lg text-info p-3 my-card" >
                   
                <span class="fa fa-money" aria-hidden="true"></span></div>
                <div class="text-info text-center mt-3"><h4>Saldo de Créditos</h4></div>
                <div class="text-info text-center mt-2"><h1><b><?php echo "$credito"?></b></h1></div>
            </div>
          </div>  
        </div>
        </div>
        <br>
        <br>
        <div class="row">
        <div class="fadeIn second">  
        <div class="col-md-8">
            <div class="card border-success shadow-lg mx-sm-2 p-4 round">
                <div class="card border-success shadow-lg text-success p-3 my-card"><span class="fa fa-flask" aria-hidden="true"></span></div>
                <div class="text-success text-center mt-3"><h4>Créditos para o <br> próximo desconto</h4></div>
                <div class="text-success text-center mt-2"><h1><b><?php echo "$restante"?></b></h1></div>
            </div>
          </div>  
        </div>
        </div>
        <br>
        <br>
        <div class="row">
        <div class="fadeIn third">   
        <div class="col-md-8">
            <div class="card border-danger shadow-lg mx-sm-2 p-4 round">
                <div class="card border-danger shadow-lg text-danger p-3 my-card" ><span class="fa fa-ticket" aria-hidden="true"></span></div>
                <div class="text-danger text-center mt-3"><h4>  Cupom de *-30%* <br> disponível  </h4></div>
                <div class="text-danger text-center mt-2"><h1><b><?php echo "$desconto"?></b></h1></div>
            </div>
          </div>  
        </div>
      </div>  
     </div>
  
</div>
</body>
</html>