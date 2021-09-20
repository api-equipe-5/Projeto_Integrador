<!DOCTYPE html>
<html lang="pt-br">
<head>
	<?php include('cabecalho.php');?>
	<title>SOS Educa - Gerar boleto</title>
	
</head>
<body>
	<?php include('navbar.php');?>
	<?php (include("progresso.php"))(1);?>

 
    
    <div class="container login-container">
            <div class="row">
                <div class="col-md-6 login-form-1">
                    <h3>Já Possui Login?</h3>
                    <h2>Entre na sua Conta</h2>
                    <div style='text-align:center'>
                        <div class="form-group">
                        <a href="login_clientes.php"><input type="submit" class="btnSubmit" value="Login" /></a>
                        </div>
                    </div>
                    <br>
                </div>
                <div class="col-md-6 login-form-2">
                    <div class="login-logo">
                        <img src="images/sos.gif" alt=""/>
                    </div>
                    <h3>Ainda não tem Login?</h3>
                    <h2>Cadastre-se Agora</h2>
                    <div style='text-align:center'>
                        <div class="form-group">
                        <a href="form_compra.php"><input type="submit" class="btnSubmit" value="Cadastre-se" /></a>
                        </div>                       
                    </div>
                    <br>
                </div> 
                
            </div>
    </div>

  
	<?php include('rodape.php');?>
</body>
</html>