<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../Home/imagem/Vó-logo.png">
    <link rel="stylesheet" type="text/css" href="../Administrador/css/adm.css">
    <link rel="stylesheet" type="text/css" href="../Administrador/css/admin_header.css">

    <title>Painel administrativo</title>

</head>

<body class="fundo">
    <?php
       $botao_esquerdo["css"] = "hidden";
       $botao_esquerdo["action"] = "hidden";
       $botao_esquerdo["texto"] = "hidden";
       $botao_direito["css"] = "hidden";
       $_GET["admin"] = "1";
       include('../Administrador/admin_header.php');
    ?>
    <div class="botao btn">
        <a href="listagem_adm.php" class="botao">
            <button class="button" title="Edita, adiciona e descarta administradores">Gerenciador de administradores</button>
        </a>
        <a href="../Home/index.php" class="botao">
             <button class="button" title="Modo edição do site">Editar site</button>
        </a>
        <a href="../Administrador/relatorio.php" class="botao">
            <button class="button" title="Acessar dados cadastrados através dos formulários site">Acessar relatórios de dados</button>
        </a>
    </div>

    <div class="help">
        <a href="../Administrador/Ajuda.php" target="_blank">
            <div class="help">
                <img src="../Administrador/imagens/help-icon.png" alt="Imagem Ajuda" title="Dúvidas sobre painel administrativo? Acesse aqui.">
            </div>
        </a>
    </div>

</body>
</html>