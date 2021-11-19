<!DOCTYPE html>
<html lang="pt-br">
<head>
	<?php include('cabecalho.php');?>
	<title>SOS Educa - login</title>
	<?php session_start(); ?>


</head>

<body>

<?php include('navbar.php');?>
	
<div class="container login-container">
            <div class="row">
                <div class="col-md-6 login-form-1">
                <form  class="form-group" action="autenticando_clientes_geral.php" method="POST" >
                    <h3>Login Clientes</h3>
                    
                        <div class="form-group">
                            <input type="text" class="form-control" name="usuario" placeholder="Seu Email *" value="<?php echo @$_SESSION['usuario']?>" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="senha" placeholder="Sua Senha *" value="<?= @$_SESSION['senha'] ? 'autofocus' : '' ?>"  maxlength="8" />
                        </div>
                        <div class="form-group">
                            <input  type="submit" class="btnSubmit" value="Login" />
                        </div>
                        <br>
                </form>

                </div>
                <div class="col-md-6 login-form-2">
                    <div class="login-logo">
                        <img src="images/sos.gif" alt=""/>
                    </div>
                    <form class="form-group" action="autenticado_usuario.php" method="POST" > 
                    <h3>Login Administrador</h3>
                        <div class="form-group">
                            <input type="text" class="form-control" name="email" placeholder="Seu Email *" value="<?php echo @$_SESSION['email']?>" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" name="senha" placeholder="Sua Password *" value="<?php echo @$_SESSION['senha']?>" maxlength="8" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btnSubmit" value="Login" />
                        </div>

                        <br>
                    </form>
                        
                </div>
            </div>
</div>

        <?php include ("rodape.php");?>

    </body>
</html>