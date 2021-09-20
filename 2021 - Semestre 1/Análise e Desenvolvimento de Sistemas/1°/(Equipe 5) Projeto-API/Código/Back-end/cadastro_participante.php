<?php

include_once './conexaopt.php';

?>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Vó Maria Felix</title>
		<link rel="stylesheet" type="text/css" href="formulario_participante.css" media="screen"/>
	</head>
	<body>
	<div>
       <h1 id="titulo">Cadastro de Participante</h1>
       <br>
       <br>   
    </div>
		<?php
				
		$dados = filter_input_array(INPUT_POST, FILTER_DEFAULT);

		if(!empty($dados['CadAluno']))
		{
			//var_dump($dados);
			
			$empty_input = false;
			
			$dados= array_map('trim', $dados);
			if (in_array("", $dados))
			{
				$empty_input = true;
				echo "<p style='color: #f00;'><strong>Erro: Necessário preencher todos os campos!</strong></p>";
			}elseif(!filter_var($dados['email'], FILTER_VALIDATE_EMAIL))
			{
				$empty_input = true;
				echo "<p style='color: #f00;'><strong>Erro: Necessário preencher o campo, com e-mail válido!</strong></p>";
			}
			
			if(!$empty_input)
			{
				$query_CadAluno= "INSERT INTO aluno (nome, rg, cpf, cep, endereco, nmmae, nmpai, email, senha) VALUES (:nome, :rg, :cpf, :cep, :endereco, :nmmae, :nmpai, :email, :senha) ";
				$cad_CadAluno = $conn->prepare($query_CadAluno);
				$cad_CadAluno->bindParam(':nome', $dados['nome'], PDO::PARAM_STR);
				$cad_CadAluno->bindParam(':rg', $dados['rg'], PDO::PARAM_STR);
				$cad_CadAluno->bindParam(':cpf', $dados['cpf'], PDO::PARAM_STR);
				$cad_CadAluno->bindParam(':cep', $dados['cep'], PDO::PARAM_STR);
				$cad_CadAluno->bindParam(':endereco', $dados['endereco'], PDO::PARAM_STR);
				$cad_CadAluno->bindParam(':nmmae', $dados['nmmae'], PDO::PARAM_STR);
				$cad_CadAluno->bindParam(':nmpai', $dados['nmpai'], PDO::PARAM_STR);
				$cad_CadAluno->bindParam(':email', $dados['email'], PDO::PARAM_STR);
				$cad_CadAluno->bindParam(':senha', $dados['senha'], PDO::PARAM_STR);
				$cad_CadAluno->execute();
				if($cad_CadAluno->rowCount())
				{
					echo "<p style='color: black;'><strong>Aluno cadastrado com sucesso!</strong></p>";
					unset($dados);
				}
				else
				{
					echo "<p style='color: #f00;'><strong>Erro: Aluno não cadastrado com sucesso!</strong></p>";
				}	
			}
			
		}
		?>
		<form name="aluno" method="POST" action="" id="formulario_paticipante">
		<fieldset class="grupo">
            <div class="campo">
			<label><strong>Nome Completo:</strong></label>
			<input type="text" name="nome" id="nome" placeholder="Digite seu nome completo" value="<?php 
			if 
			(isset($dados['nome']))
			{
				echo $dados['nome'];
			}
			?>">
			</div>
			
			<div class="campo">
			<label><strong>RG:</strong></label>
			<input type="text" name="rg" id="rg" placeholder="Digite seu RG" value="<?php 
			if 
			(isset($dados['rg']))
			{
				echo $dados['rg'];
			}
			?>">
			</div>
			
			<div class="campo">
			<label><strong>CPF:</strong></label>
			<input type="text" name="cpf" id="cpf" placeholder="Digite seu CPF" value="<?php 
			if 
			(isset($dados['cpf']))
			{
				echo $dados['cpf'];
			}
			?>">
			</div>
			
			<div class="campo">
			<label><strong>CEP:</strong></label>
			<input type="text" name="cep" id="cep" placeholder="Digite seu CEP" value="<?php 
			if 
			(isset($dados['cep']))
			{
				echo $dados['cep'];
			}
			?>">
			</div>
			
			<div class="campo">
			<label><strong>Digite seu endereço:</strong></label>
			<input type="text" name="endereco" id="endereco" placeholder="Digite seu endereço" value="<?php 
			if 
			(isset($dados['endereco']))
			{
				echo $dados['endereco'];
			}
			?>">
			</div>
			
			<div class="campo">
			<label><strong>Nome da Mãe:</strong></label>
			<input type="text" name="nmmae" id="nmmae" placeholder="Digite o nome da mãe" value="<?php 
			if 
			(isset($dados['nmmae']))
			{
				echo $dados['nmmae'];
			}
			?>">
			</div>
			
			<div class="campo">
			<label><strong>Nome do Pai:</strong></label>
			<input type="text" name="nmpai" id="nmpai" placeholder="Digite o nome do pai" value="<?php 
			if 
			(isset($dados['nmpai']))
			{
				echo $dados['nmpai'];
			}
			?>">
			</div>
			
			
			<div class="campo">
			<label><strong>E-mail:</strong></label>
			<input type="email" name="email" id="email" placeholder="Digite seu e-mail" value="<?php 
			if 
			(isset($dados['email']))
			{
				echo $dados['email'];
			}
			?>">
			</div>
			
			<div class="campo">
			<label><strong>Senha:</strong></label>
			<input type="password" name="senha" id="senha" placeholder="Digite sua senha" value="<?php 
			if 
			(isset($dados['senha']))
			{
				echo $dados['senha'];
			}
			?>">
			</div>
			
			<div class="campo">
			<button class="botao" type="submit" value="Cadastrar" name="CadAluno">Enviar</button>
			</div>
			</fieldset>
		</form>	
	</body>
</html>	