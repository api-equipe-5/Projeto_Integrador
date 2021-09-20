<?php
session_start();
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, inicial-scale=1.0">
    <title>CECOI Vó Maria Félix</title>
    <link rel="stylesheet" type="text/css" href="./css/style.css">
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
<!--Cabeçalho feito na página header.php e incluso nas demais página para simplificar o código-->
    <hr>
    <section id="bemvindo">
        <div>
            <figure class="aluno">
                <img src="imagens/site 2m.jpg" alt="criança" width="320px">
            </figure>
          <style>
          p {
	      font-family:'Open Sans', sans-serif;
          }
          </style>
            <h2>Bem-Vindos!</h2>
            <p>O Centro Comunitário de Convivência Infantil Vó Maria Félix atende crianças de 0 a 7 anos com pré-escola e outros projetos pedagógicos.</p>
            <a class="btn" href="participantes.php">Quero Participar</a>
          </div>
    </section>
	
    <hr width="100%">
	
    <section id="projetos">
        <div>
            <figure class="proj">
                <img src="imagens/projeto 1.jpg" alt="projeto1" width="320px">
            </figure>
            <h2>Conheça nossos projetos!</h2>
            <p>Saiba mais sobre projetos realizados em parceria com nossos voluntários.</p>
            <br>
            <a class="btn" href="projetos.php">Projetos</a>
          </div>
    </section>
	
    <hr width="100%">
	
    <section id="ajudar">
        <div>
            <figure class="ajudar">
                <img src="imagens/site 1.jpg" alt="professora" width="320px">
            </figure>
            <h2>Como Ajudar</h2>
            <p>Saiba como ajudar nossa instituição através de projetos, voluntariado ou doações.</p>
            <br>
            <a class="btn" href="comoajudar.php">Quero ajudar!</a>
          </div>
    </section>
	
<?php
	include("_footer.php");
?>
	
</body>
</html>