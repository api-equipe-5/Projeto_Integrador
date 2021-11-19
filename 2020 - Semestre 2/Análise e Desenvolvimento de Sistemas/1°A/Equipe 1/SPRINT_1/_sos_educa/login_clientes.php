<?php session_start(); ?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <?php include('cabecalho.php');?>
	<title>Login do cliente</title>
</head>
<body>
  <?php include('navbar.php');?>
  <?php (include("progresso.php"))(1);?>
 
  <div class="container">
	<!-- Main Content -->
	<div class="container-fluid">
		<div class="row main-content bg-success text-center">
			<div class="col-md-4 text-center company__info">
				<span class="company__logo"><h2><img src="images/sos.gif" alt="" width="120px" height="120px"></span></h2></img>
			</div>
			<div class="col-md-8 col-xs-12 col-sm-12 login_form ">
				<div class="container-fluid">
					<div class="row">
						<h2>Log In</h2>
					</div>
					<div class="row">
						<form control="" class="form-group" action="autenticando_clientes.php" method="POST">
							<div class="row">
								<input type="text" id="username" class="form__input" name="usuario" value="<?php echo @$_SESSION['usuario']?>"  placeholder="Digite seu Email">
							</div>
							<div class="row">
								<!-- <span class="fa fa-lock"></span> -->
								<input type="password" id="password" class="form__input" name="senha" <?= @$_SESSION['senha'] ? 'autofocus' : '' ?>  maxlength="8" placeholder="Digite sua senha">
							</div>
							<div class="row">
								<input type="submit" value="Login" class="btn2">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
  </div>
</div>
</body>
  <?php include('rodape.php');?> 
</body>
</html>

         

<style>
.main-content{
	width: 50%;
	border-radius: 20px;
	box-shadow: 0 5px 5px rgba(0,0,0,.4);
	margin: 5em auto;
	display: flex;
}
.company__info{
	background-color: #BC1452;
	border-top-left-radius: 20px;
	border-bottom-left-radius: 20px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	color: #fff;
}
.fa-android{
	font-size:3em;
}

.company__logo
{
  background-color: #ffffff;
  width: 200px;
  height: 200px;

  border-radius: 50%;

}
@media screen and (max-width: 640px) {
	.main-content{width: 90%;}
	.company__info{
		display: none;
	}
	.login_form{
		border-top-left-radius:20px;
		border-bottom-left-radius:20px;
	}
}
@media screen and (min-width: 642px) and (max-width:800px){
	.main-content{width: 70%;}
}
.row > h2{
	color:#27AE61;
}
.login_form{
	background-color: #fff;
	border-top-right-radius:20px;
	border-bottom-right-radius:20px;
	border-top:1px solid #ccc;
	border-right:1px solid #ccc;
}
form{
	padding: 0 2em;
}
.form__input{
	width: 100%;
	border:0px solid transparent;
	border-radius: 0;
	border-bottom: 1px solid #aaa;
	padding: 1em .5em .5em;
	padding-left: 2em;
	outline:none;
	margin:1.5em auto;
	transition: all .5s ease;
}
.form__input:focus{
	border-bottom-color: #008080;
	box-shadow: 0 0 5px rgba(0,80,80,.4); 
	border-radius: 4px;
}
.btn2{
	transition: all .5s ease;
	width: 70%;
	border-radius: 30px;
	color:#27AE61;
	font-weight: 600;
	background-color: #fff;
	border: 1px solid #27AE61;
	margin-top: 1.5em;
	margin-bottom: 1em;
}
.btn2:hover, .btn:focus{
	background-color:#27AE61;
	color:#fff;
}
</style>