<?php
$id_adm = isset($_POST['userid']) ? $_POST['userid'] : "";

if ($id_adm != "") {
    $conection = mysqli_connect("localhost", "root", "", "vomariafelix");
    $preparado = mysqli_prepare($conection, "delete from admin where id = ?");
    mysqli_stmt_bind_param($preparado, "i", $id_adm);
    mysqli_stmt_execute($preparado);
    header('Location: alteradmin.php?');
}
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Atualizar informações</title>
    <link rel="stylesheet" type="text/css" href="./css/stylealt.css">
	<link rel="stylesheet" type="text/css" href="admin/css/admin_header.css">
    <link rel="stylesheet" type="text/css" href="admin/css/admin.css">
    <link rel="stylesheet" type="text/css" href="admin/css/style.css">
	<link rel="icon" href="favicon.ico">
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
    $botao_esquerdo['action'] = "admin/index.php";
    $welcome["css"] = "welcome-voltar";
    $botao_direito["css"] = "hidden";
    include('admin/admin_header.php');
    ?>
    <?php
	include("admin/_headeredit.php")
	?>
<style>
 h2 {
    font-family: 'Open Sans', sans-serif;
    font-size:42px;
    font-weight:lighter;
    font-stretch: expanded;
    text-align:center;
    color:black ;
	margin-bottom:5pt;

}
</style>
	<br>
	<br>
    <div>
	    <hr>
            <h2>Atualizar Informações do Site</h2>
            <p id="subtitulo">Nesta página você poderá atualizar algumas informações do site institucional do 
            CECOI Vó Maria Félix usando os campos abaixo. Preencha todos os campos da seção que deseja atualizar
            (Saiba mais, Projeto 1, Projeto 2 ou Dados para doação) e clique em "Salvar e ver alterações na página".</p>
     </div>
    <div id="formulario">
     <form action="processa_saibamais.php" method="POST" >
        <div class="camposaibamais">
            <h4>Página "Saiba Mais"</h4>
            
            <label for="saibatexto">Informações sobre a ONG (História, missão, etc.):</label><br>
            <input name="saibatexto" id="saibatexto" size="150" >
            <br><br>
            <label for="saibaend">Endereço da ONG:</label><br>
            <input type="text" name="saibaend" id="saibaend" size="100">
            <br><br>
            <label for="saibatel">Telefone(s) de contato da ONG: </label><br>
            <input type="text" name="saibatel" id="saibatel" size="100">
            <br><br>
            <label for="saibahor">Horário de funcionamento da ONG:</label><br>
            <input type="text" name="saibahor" id="saibahor" size="100">
            <br><br>
            <label for="saibaatend">Público atendido:</label><br>
            <input type="text" name="saibaatend" id="saibaatend" size="100"><br>
            <b><button type="submit" name="enviar" class="botao" >Salvar e ver alterações na página</button>
			
        </div>
     </form>
     <form action="processa_proj1.php" method="POST" >
        <div class="campoprojetos">
            <h4>Página "Projetos"</h4>
            <h4>Projeto 1</h4>

            <label for="projtit1">Título do Projeto (1):</label><br>
            <input type="text" name="projtit1" id="projtit1" size="50"> <br><br>

            <label for="projdesc1">Descrição do Projeto (1):</label><br>
            <input type="text" name="projdesc1" id="projdesc1" size="150"><br>
            <b><button type="submit" name="enviar" class="botao" >Salvar e ver alterações na página</button>
        </div>
     </form>
     <form action="processa_proj2.php" method="POST" >
        <div class="campoprojetos">
            <h4>Projeto 2</h4>

            <label for="projtit2">Título do Projeto (2):</label><br>
            <input type="text" name="projtit2" id="projtit2" size="50"><br><br>

            <label for="projdesc2">Descrição do Projeto (2):</label><br>
            <input type="text" name="projdesc2" id="projdesc2" size="150"><br><br>
            <b><button type="submit" name="enviar" class="botao" >Salvar e ver alterações na página</button>
        </div>
     </form>
     <form action="processa_doacao.php" method="POST">
        <div class="campodoacao">
            <h4>Página "Dados para doações"</h4>

            <label for="doabanco">Banco:</label><br>
            <input type="text" name="doabanco" id="doabanco" size="100"><br>

            <label for="doaagencia">Agência:</label><br>
            <input type="text" name="doaagencia" id="doaagencia" size="100"><br>

            <label for="doaconta">Conta:</label><br>
            <input type="text" name="doaconta" id="doaconta" size="100"><br>

            <label for="doacnpj">CNPJ do Favorecido:</label><br>
            <input type="text" name="doacnpj" id="doacnpj" size="100"><br>

            <label for="doafav">Favorecido (nome ou razão social):</label><br>
            <input type="text" name="doafav" id="doafav" size="100"><br>

            <label for="doapix">Chave Pix do recebedor:</label><br>
            <input type="text" name="doapix" id="doapix" size="100"><br>
            <b><button type="submit" name="enviar" class="botao" >Salvar e ver alterações na página</button>
        </div>
     </form>
    </div>
    

</body>
</html>