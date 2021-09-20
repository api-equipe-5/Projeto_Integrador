<!DOCTYPE html>
<html lang="en">
<head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"></script>
    <link rel="sortcut icon" href="imagens/logo.jpeg" type="image/jpeg" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/admin.css" rel="stylesheet">
    <link rel="sortcut icon" href="imagens/logo.jpeg" type="image/jpeg"/>
    <title>Doação anonima</title>
    
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

    <div style="padding: 70px;">
        <table class="table table-striped table-hover table-bordered ">
            <thead>
                <tr>
                <th>ID</th>
                <th>Contribuição (R$)</th>
                <th>Criado</th>
                <th>Modificado</th>
                </tr>
            </thead>

            <tbody>
                <?php
                include_once("3conexao.php");

                $result_usuario = "SELECT * FROM anonima ORDER BY id DESC";
                $resultado_usuario = mysqli_query($conn, $result_usuario);  
                    if(($resultado_usuario) and ($resultado_usuario->num_rows != 0)){}
                        while($row_usuario = mysqli_fetch_assoc($resultado_usuario)){
                ?>
                <tr>
                    <th><?php echo $row_usuario['id']; ?></th>
                    <td><?php echo $row_usuario['contribuicao']; ?></td>
                    <td><?php echo $row_usuario['created']; ?></td>
                    <td><?php echo $row_usuario['modified']; ?></td>
                </tr>  
                <?php 
                        }
                ?>

            </tbody>
        </table>
    </div>

</body>

</html>