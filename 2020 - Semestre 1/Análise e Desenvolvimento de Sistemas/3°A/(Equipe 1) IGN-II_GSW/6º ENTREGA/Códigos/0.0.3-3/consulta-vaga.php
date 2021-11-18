<?php 

	$servidor = "localhost";
	$username = "root";
	$password="";
	$dbname = "meuBanco";
	$nome = $_POST["nome"];
	
	$conn=mysqli_connect($servidor,$username,$password,$dbname);
	if (!$conn)
	{
		die ("connection failed:".mysqli_connect_error());
	}
	// comando SQL 
	//"SELECT * FROM tbl_carrinho WHERE tbl_carrinho.cod = '".$cod."'  AND tbl_carrinho.sessao = '".session_id()."'";
	$SQL = "select * from vagas where vag_nome like '".$nome."' ";
	$resultado = mysqli_query($conn,$SQL);
	
	if (mysqli_num_rows($resultado)>0)
	{
		while ($linha = mysqli_fetch_assoc ($resultado))
		{
			echo "Nome da vaga: ".$linha["vag_nome"]."<BR>";
			echo "Data de insercao : ".$linha["vag_data_incial"]."<BR>";
			echo "Data de saida: ".$linha["vag_data_final"]."<BR>";
			echo "Descricao: ".$linha["vag_descricao"]."<BR>";
			echo "<BR>";
			
			
		}
	}
	else 
	{
		echo "sem resultado";
	}
	mysqli_close($conn);
	?>