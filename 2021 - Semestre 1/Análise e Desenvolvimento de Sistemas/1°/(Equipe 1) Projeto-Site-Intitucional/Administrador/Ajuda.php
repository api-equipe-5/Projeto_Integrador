<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../Home/imagem/Vó-logo.png">
    <link rel="stylesheet" type="text/css" href="../Administrador/css/adm.css">
    <link rel="stylesheet" type="text/css" href="../Administrador/css/admin_header.css">

    <title>Ajuda</title>
</head>

<body class="fundo">

    <?php
    $botao_esquerdo['texto'] = "Voltar";
    $botao_esquerdo['action'] = "index.php";
    $welcome["css"] = "welcome-voltar";
    $botao_direito["css"] = "hidden";
    $_GET["admin"] = "1";
    include('../Administrador/admin_header.php');
    ?>
    <div class="video_center">
        <h1>Como adicionar, editar e excluir administradores</h1>
        <video width="500" controls>
            <source src="videos/editoradm.mp4" type="video/mp4">
        </video>

        <h1>Como editar site</h1>
        <video width="500" controls>
            <source src="videos/editordesite.mp4" type="video/mp4">
        </video>

        <h1>Como acessar relatório</h1>
        <video width="500" controls>
            <source src="videos/relatrorio.mp4" type="video/mp4">
        </video>
        <div class="footer">
            <div class="xtreme">by Equipe Xtreme <br>github.com/Xtreme-Equipe</div>
        </div>
    </div>




</body>

</html>