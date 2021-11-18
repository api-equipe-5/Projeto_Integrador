<?php 
	
	$nome = $_POST["nome"];
	$cpf = $_POST["cpf"];
	$email = $_POST["email"];
	$radio1 = $_POST["Estado_Atual"];
	
	
	
	if ($radio1 == ""){$radio1="nao";}
	else {$radio1="sim";}
	
	
	
	$conexao=mysqli_connect("localhost","root","","meuBanco");
	//------------------------------------------------
	// comando sql 
	$SQL = "insert into cadastro_cliente (nome,cpf,email,funcionario_check) values ('".$nome."','".$cpf."','".$email."','".$radio1."')";
	
	
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
	// INSERT DE INFOMAÇÕES DO CURRICULO 
	if ($_POST) {        
            include("./core/dadosconexao.php");
            $arquivo = $_FILES["arquivo"]["tmp_name"]; // recebendo doc anexo
            $tamanho = $_FILES["arquivo"]["size"]; // tamanho obtido  direto do doc
            $tipo    = $_FILES["arquivo"]["type"]; // tipo tamanho obtido direto do doc 
            $nome  = $_FILES["arquivo"]["name"];
            
			

            if ( $arquivo != "none" ) // gerenciar arquivo 
            {
                $fp = fopen($arquivo, "rb"); // abrir
                $conteudo = fread($fp, $tamanho); /// ler 
                $conteudo = addslashes($conteudo); // tratamento de string 
                fclose($fp);                 
                
            
                try { 	$conecta = new PDO("mysql:host=$servidor;dbname=$banco", $usuario , $senha); //  
                      
			           $SQL = "insert into curriculo (arquivo_nome,arquivo_conteudo,arquivo_tipo) values ('".$nome."','".$conteudo."','".$tipo."')";
				                                                                               
					 
					 
			         $grava = $conecta->prepare($SQL); 
			         $grava->execute(array()); 	                                        
                     echo '<br/><div class="alert alert-success" role="alert">
                                tabela curriculo foi populada! 
                            </div>';
		          } catch(PDOException $e) { // NÃO ALTERAR ESSA LINHA - tratamento de erro. 
                     
                     echo '<br/><div class="alert alert-success" role="alert">
                                Erro ' . $e->getMessage() . 
                          '</div>';
		          }
            }}
// -------------------------------------------------------------------------------------------------------------
		
	
	
?>