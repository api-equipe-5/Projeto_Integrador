
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Questionário de Dados</title>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	
</head>
<body>

	<div class= "container mt-5">

	<form action="makepdf.php" method="post" >
		

		<h1>Questionário de Dados</h1>

		<p>Preencha os dados solicitados abaixo</p><br />


		<h4>Agentes de Tratamento</h4><br />

		<h5>Controlador</h5>
		<div class= " row mb-2">

			<div class="col-md-6">

			<input type="text" name="cname" placeholder="Nome" class="form-control" required>
		</div>

			<div class="col-md-6">
			<input type="text" name="clname" placeholder="Sobrenome" class="form-control" required>
		</div>

		</div>

		<h5>Operador</h5>
		<div class= " row mb-2">

			<div class="col-md-6">

			<input type="text" name="opname" placeholder="Nome" class="form-control" required>
		</div>

			<div class="col-md-6">
			<input type="text" name="oplname" placeholder="Sobrenome" class="form-control" required>
		</div>

		</div>

		<h5>Encarregado</h5>
		<div class= " row mb-2">

			<div class="col-md-6">

			<input type="text" name="ename" placeholder="Nome" class="form-control" required>
		</div>

			<div class="col-md-6">

			<input type="text" name="elname" placeholder="Sobrenome" class="form-control" required>
		</div>

	</div>

		<div class= " row mb-2">


		<div class="col-md-6">

			<input type="phone" name="etel" placeholder="Contato" class="form-control" required>
		</div>
		<div class="col-md-6">

			<input type="site" name="esite" placeholder="Site" class="form-control" required>
		</div>

		</div><br />

		<h4>Dados Pessoais</h4>
		<div class= " row mb-2">

			<div class="col-md-6">

			<input type="text" name="pdados" width="30" placeholder="Qual é o Dado?"  class="form-control" required> 
		</div>

			<div class="col-md-6">

			<input type="text" name="pjust" placeholder="Este dado é utilizado em que?" class= "form-control" required>
		</div>

		<div class="col-md-6">
		<input type="button" value="+" name="Adicionar" required>
	</div>


	</div><br />

	<h3>Dados Pessoais Sensiveis(opcional)</h3>
	<div class= " row mb-2">

			<div class="col-md-6">

			<input type="text" name="psdados" placeholder="Qual é o Dado?"  class="form-control" required> 
		</div>

			<div class="col-md-6">

			<input type="text" name="psjust" placeholder="Este dado é utilizado em que?" class= "form-control" required>
		</div>

		<div class="col-md-6">
		<input type="button" value="+" name="Adicionar" required>

	</div>
		
	</div><br />

	<h3>Segurança de Dados</h3><br />

	<h4>Possui Dados Anonimizados?</h4>
	<div class= " row mb-2">

			<div class="col-md-6">

			<input type="text" name="andados" placeholder="Sim ou Não?"  class="form-control" required> 
		</div>
	</div>

	<h4>Possui Dados Pessoais de Menores?(opcional)</h4>

	<textarea name="dmenor" placeholder="Dados de menores" class="form-control">
	</textarea><br />


	<h4>Boas Práticas da Empresa(opcional)</h4>

	<textarea name="empmsg" placeholder="Digite as boas práticas da sua empresa" class="form-control">
	</textarea><br />

	<?php
		session_start();
		echo "Relatório redigido por: ".$_SESSION['usuarioNome'];
		?>



		<button type="submit" class= "btn btn-success btn-lg btn-block">Gerar PDF</button>
	</form>
	<a href="sair.php">Sair</a>

	</div>
</body>
</html>