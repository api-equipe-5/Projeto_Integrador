<?php
session_start();
?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, inicial-scale=1.0">
    <title>Como Ajudar</title>
    <link rel="stylesheet" type="text/css" href="./css/style_comoajudar.css">
	<link rel="icon" href="favicon.ico">
	<style type="text/css"> 
    a:link 
    { 
     text-decoration:none; 
    } 
    </style>
</head>
<body>
    <!--Aqui começa o cabeçalho do site, essa parte é igual em todas as páginas-->
<?php
	include("_header.php");
?>
    <!--Fim do cabeçalho-->
    <hr>
    <h2>Como Ajudar</h2>
    <div class="wrapper">
    <section id="voluntarios">
            <figure class="iconevolunt">
                <img src="imagens/help.png" alt="voluntários" width="200px">
            </figure>
            <p>Estou disponível para ser voluntário em qualquer função</p>
            <a class="botao" href="voluntario_apoio.php">Cadastro de Voluntários de Apoio</a>
            <br><br>
            <p>Atuo em uma  função específica e gostaria de disponibilizar meu trabalho e/ou sugerir um projeto</p>
            <a class="botao" href="voluntario_especifico.php">Voluntário Específico / Projetos</a>
            <br><br>
    </section>

    <section id="doacaoecontato">
            <figure class="iconedoacao">
                <img src="imagens/donation.png" alt="doação" width="200px">
            </figure>
            <p>Quero fazer uma doação</p>
            <br>
            <a class="botao" href="doacao.php">Dados para Doações</a>
            <!--página de doacoes ainda não criada-->
            <br><br>
            <p>Tem alguma outra ideia de como ser nosso parceiro? Entre em contato e envie sua sugestão</p>
            <a class="botao" href="contato.php">Contato</a>
            <br><br>
    </section>
    </div>

<?php
	include("_footer.php");
?>

</body>
</html>