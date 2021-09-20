<?php
$name_adm       = isset($_POST['name']) ? $_POST['name'] : "";
$email_adm       = isset($_POST['email']) ? $_POST['email'] : "";
$password_adm       = isset($_POST['password']) ? $_POST['password'] : "";
$id_adm = isset($_GET['userid']) ? $_GET['userid'] : "";

if ($id_adm == "") {
    $id_adm = isset($_POST['userid']) ? $_POST['userid'] : "";
}

if ($id_adm == ""){
    $title_pag = "Adicionar novo administrador";
}
else{
    $title_pag = "Editar administrador";
}


if ($name_adm != "" || $email_adm != "" || $password_adm != "") {
    $conection = mysqli_connect("localhost", "root", "", "bd_admin");
    if ($id_adm == "") {
        $preparado = mysqli_prepare($conection, "insert into tb_user (name, email, password) values (?, ?, ?)");
        mysqli_stmt_bind_param($preparado, "sss", $name_adm, $email_adm, $password_adm); //cria um novo usuário
    } else {
        $preparado = mysqli_prepare($conection, "update tb_user set name = ?, email = ?, password = ? where id =?");
        mysqli_stmt_bind_param($preparado, "sssi", $name_adm, $email_adm, $password_adm, $id_adm); //edita usuário já existente
    }
    mysqli_stmt_execute($preparado);
    header('Location: /Projeto-Site-Intitucional/Administrador/listagem_adm.php?'); //redireciona para listagem de adm
}

$result_email = "";
$result_name = "";
$result_password = "";

if ($id_adm != "") {
    $conection = mysqli_connect("localhost", "root", "", "bd_admin");
    $prepared = mysqli_prepare($conection, "select email, name, password from tb_user where id = ?");
    mysqli_stmt_bind_param($prepared, "i", $id_adm); // envia os dados dos 'filtros'
    $result = mysqli_stmt_execute($prepared); // aplica o 'filtro'  

    mysqli_stmt_store_result($prepared); //traz os metadados da consulta

    $result_count = mysqli_stmt_num_rows($prepared); //quantas linhas a consulta retornou

    if (!$result || $result_count == '0') {
        $validated = FALSE;
    } else {
        mysqli_stmt_bind_result($prepared, $result_email, $result_name, $result_password); //associa as variáveis com os campos do select
        mysqli_stmt_fetch($prepared); //traz o resultado para as variáveis acima
    }
}

?>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../Home/imagem/Vó-logo.png">
    <link rel="stylesheet" type="text/css" href="../Administrador/css/admin_header.css">
    <script src="../ckeditor_4.16.0_b1a78bed529d/ckeditor/ckeditor.js"></script>
    <link rel="stylesheet" type="text/css" href="../Administrador/css/adm.css">

    <title><?= $title_pag ?></title>
</head>

<body class="fundo">
    <?php
    $botao_esquerdo['texto'] = "Voltar";
    $botao_esquerdo['action'] = "listagem_adm.php";
    $botao_direito["css"] = "hidden";
    $welcome["css"] = "welcome-voltar";
    $_GET["admin"] = "1";
    include('../Administrador/admin_header.php');
    ?>
    <div class="background" id="tabela">

    <h1><?= $title_pag ?></h1>

        <form action="editar_adm.php" method="POST">
            <div class="campo">
                <div>
                    <label for="name">Nome</label> <br> <input type="text" name="name" value="<?= $result_name ?>" class="input" required>
                </div>

                <div>
                    <label for="email">Email</label> <br> <input type="email" name="email" value="<?= $result_email ?>" class="input" required>
                </div>

                <div>
                    <label for="password">Senha</label> <br> <input type="password" name="password" value="<?= $result_password ?>" class="input" required>
                </div>
            </div>

            <input type="hidden" name="userid" value="<?= $id_adm ?>">
            <div class="btn">
                <button class="save">Salvar</button>
            </div>
        </form>
    </div>
    <div class="footer">
      <div class="xtreme">by Equipe Xtreme <br>github.com/Xtreme-Equipe</div> 
    </div>
</body>

</html>