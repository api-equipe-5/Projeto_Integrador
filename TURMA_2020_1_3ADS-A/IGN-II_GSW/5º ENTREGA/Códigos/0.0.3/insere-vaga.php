<?php 
	
	$nome = $_POST["nome"];
	$Data_entrada = $_POST["Data_entrada"];
	$Data_saida = $_POST["Data_saida"];
	$Descricao = $_POST["Descricao"];
	

	
	$conexao=mysqli_connect("localhost","root","","meuBanco");
	//------------------------------------------------
	// comando sql 
	$SQL = "insert into vagas (vag_nome,vag_data_incial,vag_data_final,vag_descricao) values ('".$nome."','".$Data_entrada."','".$Data_saida."','".$Descricao."')";
			if (mysqli_query($conexao,$SQL)) 
			{
				echo "A tabela foi  populada!";
			}
			else 
			{
				echo "A tabela não foi  populada!".mysqli_error($conexao);
			}
	// -----------------------------------------------------------------------------------------------	
	mysqli_close($conexao); 
		
	// -----------------------------------------------------------------------------------------------	
// -------------------------------------------------------------------------------------------------------------
		
	
	
?>