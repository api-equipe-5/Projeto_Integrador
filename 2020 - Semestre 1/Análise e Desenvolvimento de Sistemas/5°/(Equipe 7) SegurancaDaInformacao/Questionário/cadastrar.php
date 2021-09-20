<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Questionário de Dados</title>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	
</head>
<body>

	<div class= "container mt-5">

	<form action="processa.php" method="POST" >
		

		<h1>Cadastrar Cliente</h1>


		<p>Preencha os dados solicitados abaixo</p><br />
		<h5>Dados Pessoais</h5>
		<div class= " row mb-2">

			<div class="col-md-6">

			<input type="text" name="cname" placeholder="Nome" class="form-control" required>
		</div>

			<div class="col-md-6">
			<input type="text" name="clname" placeholder="Sobrenome" class="form-control" required>
		</div>

		</div>
		<div class= " row mb-2">

			<div class="col-md-6">

			<input type="text" name="cend" placeholder="Endereço" class="form-control" required>
		</div>

			<div class="col-md-6">
			<input type="text" name="ccep" placeholder="CEP" class="form-control" required>
		</div>

		</div>
		<div class= " row mb-2">

			<div class="col-md-6">

			<input type="tel" name="ctel" placeholder="Telefone" class="form-control" required>
		</div>

			<div class="col-md-6">
			<input type="email" name="cemail" placeholder="E-mail" class="form-control" required>
		</div>

		</div>
		<button type="submit" class= "btn btn-success btn-lg btn-block">Salvar</button>
	</form>

	</div>
</body>
</html>