<?php
include("conexao_tabela.php");

$consulta = "SELECT * FROM participantes";
$con = $mysqli->query($consulta) or die($mysqli->error);
?>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="widtd=device-widtd, inicial-scale=1.0">
    <link rel="icon" href="favicon.ico">
	<title>Participantes</title>
	<link rel="stylesheet" type="text/css" href="css/admin_header.css">
    <link rel="stylesheet" type="text/css" href="css/admin.css">
	<style type="text/css"> 
    a:link 
    { 
    text-decoration:none; 
    } 
    </style>
</head>
<body class="background fundo">
    <?php
    $botao_esquerdo['texto'] = "Voltar";
    $botao_esquerdo['action'] = "acesso.php";
    $welcome["css"] = "welcome-voltar";
    $botao_direito["css"] = "hidden";
    include('admin_header.php');
    ?>
    <?php
	include("_headeredit.php")
	?>
	<br>
	<br>
<style>
a {
	color:white;
}

tr {
    font-family: 'Open Sans', sans-serif;
    font-size: 10pt;
    background-color: white;
    color: black;
}
table {
	border-color:black;
	width: 95% !important;
    margin: auto;
}
	
th{
    font-size: 10pt;
    background-color: #d7666d;
    color: white;
	padding:5px;
	text-align:center;
    border: 1px solid black;	
}
</style>

 <h3>Participantes</h3>
 <table border="1" cellpadding="5px" cellspacing="0">
  <tr>
    <th>ID</th>
    <th>Nome</th>
    <th>Sexo</th>
    <th>Data de Nascimento</th>
	<th>Deficiência?</th>
	<th>Descrição Deficiência</th>
	<th>Renda</th>
	<th>Nome do Responsável</th>
	<th>Sexo do Responsável</th>
	<th>Grau de Parentesco</th>
	<th>Grau - Outro</th>
	<th>CPF</th>
	<th>Telefone</th>
    <th>Data de Nascimento - Responsável</th>
    <th>Endereço</th>
    <th>Email</th>
    <th>Data Cadastro</th>
  </tr>
 <?php while($dado=$con->fetch_array()){?>
   <tr>
     <td><?php echo $dado["id"];?></td>
	 <td><?php echo $dado["nome"];?></td>
	 <td><?php echo $dado["sexo"];?></td>
	 <td><?php echo $dado["dt_nascimento"];?></td>
	 <td><?php echo $dado["deficiencia"];?></td>
	 <td><?php echo $dado["descreva"];?></td>
	 <td><?php echo $dado["renda"];?></td>
	 <td><?php echo $dado["nome_responsavel"];?></td>
	 <td><?php echo $dado["sexo_responsavel"];?></td>
	 <td><?php echo $dado["grau_parentesco"];?></td>
	 <td><?php echo $dado["grau"];?></td>
	 <td><?php echo $dado["cpf"];?></td>
	 <td><?php echo $dado["telefone"];?></td>
	 <td><?php echo $dado["dt_nascimento_responsavel"];?></td>
	 <td><?php echo $dado["endereco"];?></td>
	 <td><?php echo $dado["email"];?></td>
	 <td><?php echo $dado["criado"];?></td>
	</tr> 
 <?php }?>
 </table>
    <br>
	<br>
	<br>
	<br>
	<br>
    <hr width="100%">
    <footer>Desenvolvido por Grupo Rocket 2021</footer>
 </body>
</html>
 </body>
</html>