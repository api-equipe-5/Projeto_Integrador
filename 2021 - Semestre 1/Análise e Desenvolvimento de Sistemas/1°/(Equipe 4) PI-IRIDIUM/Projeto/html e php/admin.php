<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/admin.css" rel="stylesheet">
    <link rel="sortcut icon" href="imagens/logo.jpeg" type="image/jpeg"/>
    <title>Admin</title>

</head>

<body>

     <input type="checkbox" id="check">
     <label id="icone" for="check"><img src="imagens/logo-admin-menu.png" alt="logo" /></label>
        
    <div class="barra">

        <nav>
            <a href="ad-banco-projeto.php"><div class="link">Projetos</div></a>
            <a href="ad-banco-participantes.php"><div class="link">Participantes</div></a>
            <a href="ad-banco-doacao.php"><div class="link">Doação</div></a>
            <a href="ad-banco-doacao-anonima.php"><div class="link">Doação anonima</div></a>
            <a href="ad-banco-voluntario.php"><div class="link">Voluntarios</div></a>
            <a href="logout.php"><div class="link">Sair</div></a>

        </nav>

    </div> 

    <div class="imagens">

        <center><img src="imagens/manual-pt1" width="45%">
        <center><img src="imagens/manual-pt2-1" width="35%">
        <center><img src="imagens/manual-pt2-2" width="35%">
        <center><img src="imagens/manual-pt-3" width="35%">
        <center><img src="imagens/manual-pt4" width="35%">

            
    </div>

</body>

</html>