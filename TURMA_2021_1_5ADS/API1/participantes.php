<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
    <link rel="stylesheet" type="text/css" href="./css/style_participantes.css">
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
        <h2>Cadastro de Participantes (Alunos)</h2>
        <p id="subtitulo">Preencha o formulário abaixo para a pré-inscrição da criança no CECOI Vó Maria Félix. De acordo com a disponibilidade de vagas entraremos em contato!</p>
     </div>
     <form action="processa_participantes.php" method="POST" >
        <fieldset class="grupo">
            <div class="campo">
                <label for="nome"><strong>Nome:</strong></label>
                <input type="text" name="nome" id="nome" required />
                <label for="sexo"><strong>Sexo:</strong></label>
                <select name="sexo" id="sexo" required>
                    <option selected disabled value="">Selecione</option>
                    <option>Masculino</option>
                    <option>Feminino</option>
                </select>
            </div>

			<div class="campo">
                <label for="data"><strong>Data de Nascimento:</strong></label>
                <input type="date" name="date" id="date" required />
            </div>

            <div class="campo">
                <label for="certidao"><strong>Certidão de Nascimento:</strong></label>
                <input type="number" name="certidao" id="certidao" type="text" required />
            </div>

            <div class="campo">
                <label><strong>Portador de alguma limitação física/mental:</strong></label>
                <label>
                    <input type="radio" name="devweb" value="sim"/>Sim
                    <input type="text" name="descreva" id="descreva"/>
                </label>
                <label>
                    <input type="radio" name="devweb" value="nao"/>Não
                </label>
                <br>
                <label><strong>Renda familiar:</strong></label>
                <select name="renda" required>
                    <option selected disabled value="">Selecione</option>
                    <option>Abaixo de um salário</option>
                    <option>Um a dois salários</option>
                    <option>Dois a quatro salários</option>
                    <option>Quatro a cinco salários</option>
                    <option>Mais de cinco salários</option>
                </select>
            </div>

            <div class="campo">
                <label><strong>Nome do Responsável:</strong></label>
                <input type="text" name="nomeresp" id="nomeresp"/>
                <label for="sexor"><strong>Sexo:</strong></label>
                <select name="sexor" id="sexor" required>
                    <option selected disabled value="">Selecione</option>
                    <option>Masculino</option>
                    <option>Feminino</option>
                </select>
                <br>
                <label><strong>Selecione o grau de parentesco:</strong></label>
                <label for="grau"></label>
                <select name="parentesco" id="grau" required>
                    <option selected disabled value="">Selecione</option>
                    <option>Pai</option>
                    <option>Mãe</option>
                    <option>Irmã(o)</option>
                    <option>Avô(ó)</option>
                    <option>Outros</option>
                </select>
                <label><strong>Em caso de outros, descreva:</strong></label>
                <input type="text" name="escreva" id="escreva"/>
                <br>
                <label><strong>CPF do responsável:</strong></label>
                <input type="number" name="cpf" id="cpf" required />
                <label><strong>Telefone:</strong></label>
                <input type="number" name="telefone" id="telefone"/>
                <label><strong>Data de nascimento:</strong></label>
                <input type="date" name="date2" id="date2" required />
                <br>
                <label><strong>Endereço:</strong></label>
                <input type="text number" name="endereço" id="endereço" required />
                <label><strong>Email:</strong></label>
                <input type="email" name="email" id="email"required />
            </div>
        </fieldset>
        <b><button type="submit" name="enviar" class="botao">Enviar</b></button>
     </form>
<?php
	include("_footer.php");
?>

</body>
</html>