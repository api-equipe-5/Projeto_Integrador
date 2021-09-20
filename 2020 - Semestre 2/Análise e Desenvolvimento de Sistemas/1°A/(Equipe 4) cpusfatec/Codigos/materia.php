<?php
	session_start();
	include('verifica_login.php');
	include_once("conexao.php");
	$num = $_SESSION['materia'];
	$result_cursos = "SELECT * FROM cursos WHERE categoria_id = '$num'";
	$resultado_cursos = mysqli_query($conexao, $result_cursos);
?>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>CPU | Materia</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container theme-showcase" role="main">
			<div class="page-header">
				<h1>Lista do Curso</h1>
			</div>
			<div class="">
				<a href="painel.php" class="btn btn-xs btn-primary">Voltar</a>
	<?php
        if ($_SESSION['nivel'] == 3){
                echo '<button type="button" class="btn btn-xs btn-success" data-toggle="modal" data-target="#myModalcad">Cadastrar</button>';
        }  
    ?>
			
			</div>
			<!-- Inicio Modal -->
			<div class="modal fade" id="myModalcad" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<h4 class="modal-title text-center" id="myModalLabel">Cadastrar Curso</h4>
						</div>
						<div class="modal-body">
							<form method="POST" action="processa_cad.php" enctype="multipart/form-data">
								<div class="form-group">
									<label for="recipient-name" class="control-label">Nome:</label>
									<input name="nome" type="text" class="form-control">
								</div>
								<div class="form-group">
									<label for="message-text" class="control-label">Detalhes:</label>
									<textarea name="detalhes" class="form-control"></textarea>
								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-success">Cadastrar</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- Fim Modal -->
			
			<div class="row">
				<div class="col-md-12">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>Nome do Curso</th>
								<th>Ação</th>
							</tr>
						</thead>
						<tbody>
							<?php while($rows_cursos = mysqli_fetch_assoc($resultado_cursos)){ ?>
								<tr>
									<td><?php echo $rows_cursos['id']; ?></td>
									<td><?php echo $rows_cursos['nome']; ?></td>
									<td>
										<button type="button" class="btn btn-xs btn-primary" data-toggle="modal" data-target="#myModal<?php echo $rows_cursos['id']; ?>">Visualizar</button>
										
	<?php
        if ($_SESSION['nivel'] == 3){
				echo '<button type="button" class="btn btn-xs btn-warning" data-toggle="modal" data-target="#exampleModal" data-whatever="'; echo $rows_cursos['id']; echo '" data-whatevernome="'; echo $rows_cursos['nome'];  echo '" data-whateverdetalhes="'; echo $rows_cursos['detalhes']; echo '">Editar</button>';
				echo '<a href="processa_apagar.php?id='; echo $rows_cursos['id']; echo '><button type="button" class="btn btn-xs btn-danger">Apagar</button></a>';
        }  
    ?>																				
									</td>
								</tr>
								<!-- Inicio Modal -->
								<div class="modal fade" id="myModal<?php echo $rows_cursos['id']; ?>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
												<h4 class="modal-title text-center" id="myModalLabel"><?php echo $rows_cursos['nome']; ?></h4>
											</div>
											<div class="modal-body">
												<p><?php echo $rows_cursos['id']; ?></p>
												<p><?php echo $rows_cursos['nome']; ?></p>
												<p><?php echo $rows_cursos['detalhes']; ?></p>
											</div>
										</div>
									</div>
								</div>
								<!-- Fim Modal -->
							<?php } ?>
						</tbody>
					 </table>
				</div>
			</div>		
		</div>
		
		
	
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="exampleModalLabel">Cursos</h4>
					</div>
					<div class="modal-body">
						<form method="POST" action="processa.php" enctype="multipart/form-data">
							<div class="form-group">
								<label for="recipient-name" class="control-label">Nome:</label>
								<input name="nome" type="text" class="form-control" id="recipient-name">
							</div>
							<div class="form-group">
								<label for="message-text" class="control-label">Detalhes:</label>
								<textarea name="detalhes" class="form-control" id="detalhes-text"></textarea>
							</div>
							<input name="id" type="hidden" id="id_curso">
							<div class="modal-footer">
								<button type="button" class="btn btn-primary" data-dismiss="modal">Cancelar</button>
								<button type="submit" class="btn btn-danger">Alterar</button>
							</div>
						</form>
					</div>			  
				</div>
			</div>
		</div>

	<?php
        if ($_SESSION['nivel'] == 3){
                echo '<form name="form" method="post" action="trocarpdf.php" enctype="multipart/form-data">
				<fieldset class="infraFieldset">
				<legend class="infraLegend">Enviar Arquivos</legend>
				<label id="lblArquivo" for="txtArquivo" class="infraLabelObrigatorio">Documento:</label>
				<input type="file" id="txtArquivo" name="txtArquivo" value="" />
				<button type="submit" accesskey="S" name="sbmSalvar" class="infraButton"><span class="infraTeclaAtalho">E</span>nviar</button>
				</form>';
        }  
    ?>
		<embed src= "pdf/<?php echo $num?>.pdf" width="100%" height="500" type='application/pdf'>

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$('#exampleModal').on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget) // Button that triggered the modal
				var recipient = button.data('whatever') // Extract info from data-* attributes
				var recipientnome = button.data('whatevernome')
				var recipientdetalhes = button.data('whateverdetalhes')
				// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
				// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
				var modal = $(this)
				modal.find('.modal-title').text('ID do Curso: ' + recipient)
				modal.find('#id_curso').val(recipient)
				modal.find('#recipient-name').val(recipientnome)
				modal.find('#detalhes-text').val(recipientdetalhes)
			})
		</script>
	</body>
</html>