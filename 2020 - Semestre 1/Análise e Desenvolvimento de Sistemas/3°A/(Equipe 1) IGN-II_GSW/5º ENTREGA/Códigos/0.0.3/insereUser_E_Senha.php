<?php 
	
	$usuario = $_POST["username"];
	$senha = $_POST["password"];
	

	$conexao=mysqli_connect("localhost","root","","meuBanco");
	$SQL = "select * from adminUser";
	$resultado = mysqli_query($conexao,$SQL);
	//------------------------------------------------
	// comando sql 
	
			if (mysqli_num_rows($resultado)>0)
			{
				while ($linha = mysqli_fetch_assoc ($resultado)) {
					
					if ( $usuario == $linha["usuario"] and $senha == $linha["senha"] ) {
						header("Location: CRUD_empresa.html");;}
				   
				    else {header("Location: index.html");} 
				   
				// echo "usuario: ".$linha["usuario"]."<BR>";
				// echo "senha: ".$linha["senha"]."<BR>";		
				}
			}
			else 
			{
				echo "sem resultado";
			}
	// -----------------------------------------------------------------------------------------------	
	mysqli_close($conexao); 
		
	
?>