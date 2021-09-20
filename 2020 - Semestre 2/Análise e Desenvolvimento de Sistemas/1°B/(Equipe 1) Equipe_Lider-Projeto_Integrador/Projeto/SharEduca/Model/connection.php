<?php
	namespace Model;

	// Classe que faz conexão ao banco de dados e executa comandos SQL.
	Class Connection{
		var $link;
		var $result;

		protected $host = "localhost:3308";
		protected $user = "root";
		protected $pass   = "";
		protected $db    = "shareducadb";

		// Conecta-se ao banco de dados.
		function connect(){
			$this->link = mysqli_connect($this->host, $this->user, $this->pass, $this->db);
		}
		// Desconecta-se ao banco de dados.
		function disconnect(){
			mysqli_close($this->link);
		}
		

		// Executa o comando ($query) informado e retorna um array, 
		//	tendo seu indice 0 o indicatívo de retorno sem erros (booleano) 
		//	e o indice 1 o resultado obtido.
		function execute($query){
			
			$request = "";

			try{

				$this->connect();

				$this->result = mysqli_query($this->link,$query);
				if (!empty($this->result)){
					return [1, $this->result];

				}else{
					return [0, "Erro na execução: ".$this->link->error];
				}
				
			}catch(mysqli_sql_exception $e){
				throw $e;//throw new Exception($e);// mysqli_error($this->link);
				
			}finally{
				$this->disconnect();
			}
		}
	}
?>
