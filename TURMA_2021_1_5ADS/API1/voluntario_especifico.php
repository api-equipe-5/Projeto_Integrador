<?php
    include_once("recaptchalib.php");
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voluntários de Específicos e Projetos</title>
	<script src="https://www.google.com/recaptcha/api.js?hl=pt-BR"></script>																		
    <link rel="stylesheet" type="text/css" href="./css/style_especifico.css">
	<link rel="icon" href="favicon.ico">
	<style type="text/css"> 
	 a:link 
    { 
     text-decoration:none; 
    } 
	</style>
</head>
<body>

<?php 
     
	 include("_header.php");
?>
    <div>
	  <hr>
        <h2>Cadastro de Voluntários Específicos e Projetos</h2>
        <p id="subtitulo">Se você tem uma especialidade e deseja colaborar conosco ou implementar um projeto, preencha o formulário abaixo e entraremos em contato. </p>
    </div>
    <!--em action colocar página para qual as infomações do formulário serão enivadas-->
    <form action="processa_especifico.php" method="POST" >
        <fieldset class="grupo">
            <div class="campo">
                <label for="nome"><strong>Nome:</strong></label>
                <input type="text" name="nome" id="nome" required>
                <label for="sexo"><strong>Sexo:</strong></label>
                <select name="sexo" id="sexo" required>
                    <option selected disabled value="">Selecione</option>
                    <option>Masculino</option>
                    <option>Feminino</option>
                </select>
            </div>

            <div class="campo">
                <label><strong>CPF:</strong></label>
                <input type="number" name="cpf" id="cpf" required>
                <label><strong>Data de nascimento:</strong></label>
                <input type="date" name="date2" id="date2" required>
                <br>
                <label><strong>Endereço:</strong></label>
                <input type="text number" name="endereço" id="endereço" required>
                <label><strong>Cidade:</strong></label>
                <input type="text" name="cidade" id="cidade" required>
                <label><strong>Telefone:</strong></label>
                <input type="number" name="telefone" id="telefone">
            </div>
            <div class="campo">
                <label><strong>Email:</strong></label>
                <input type="email" name="email" id="email"required><br>
                <label><strong>Disponibilidade de Horário:</strong></label>
                <input type="text" name="horario" id="horario"required>
            </div>
            <div class="campo">
                <label><strong>Descreva sua Especialização:</strong></label>
                <input type="text" name="especializacao" id="especializacao" required>
            </div>
            <div class="campo">
                <label><strong>Deseja implementar um Projeto?</strong></label>
                <input type="checkbox" name="projeto" id="projeto">
            </div>
            <div class="campo">
                <label><strong>Se sim, descreva o projeto:</strong></label>
                <input type="text" name="projdescricao" id="projdescricao">
            </div>
<div class="g-recaptcha" data-sitekey="6LfJqPIUAAAAAF0gPthIM5MT7bqKjbzeV6RAR8W-"></div>
<?php
        $secret = "6LfJqPIUAAAAADqcPDNbqnrfBPBv1O1Hp9ryFpsg";

        $response = null;
        $reCaptcha = new reCaptcha($secret);
		   

        if(isset($_POST['g-recaptcha-response'])){
            $response = $reCaptcha->verifyResponse($_SERVER['REMOTE_ADDR'], $_POST['g-recaptcha-response']);
        }

        if($response != null && $response->success){
            echo "Pronto";
        }

?>																					   
        </fieldset>
        <b><button type="submit" name="enviar" class="botao">Enviar</b></button>
    </form>

<?php
	include("_footer.php");
?>
</body>
</html>