<?php
$name_adm       = isset($_POST['name']) ? $_POST['name'] : "";
$email_adm       = isset($_POST['email']) ? $_POST['email'] : "";
$password_adm       = isset($_POST['password']) ? $_POST['password'] : "";
$id_adm = isset($_GET['userid']) ? $_GET['userid'] : "";

if ($id_adm == "") {
    $id_adm = isset($_POST['userid']) ? $_POST['userid'] : "";
}
if ($id_adm == ""){
    $title_pag = "Adicionar Novo administrador";
}
else{
    $title_pag = "Editar Administrador";
}
if ($name_adm != "" || $email_adm != "" || $password_adm != "") {
    $conection = mysqli_connect("localhost", "root", "", "vomariafelix");
    if ($id_adm == "") {
        $preparado = mysqli_prepare($conection, "insert into admin (name, email, password) values (?, ?, ?)");
        mysqli_stmt_bind_param($preparado, "sss", $name_adm, $email_adm, $password_adm);
    } else {
        $preparado = mysqli_prepare($conection, "update admin set name = ?, email = ?, password = ? where id =?");
        mysqli_stmt_bind_param($preparado, "sssi", $name_adm, $email_adm, $password_adm, $id_adm);
    }
    mysqli_stmt_execute($preparado);
    header('Location: gerenciar_admin.php?');
}
$result_email = "";
$result_name = "";
$result_password = "";
if ($id_adm != "") {
    $conection = mysqli_connect("localhost", "root", "", "vomariafelix");
    $prepared = mysqli_prepare($conection, "select email, name, password from admin where id = ?");
    mysqli_stmt_bind_param($prepared, "i", $id_adm);
    $result = mysqli_stmt_execute($prepared); 

    mysqli_stmt_store_result($prepared); 

    $result_count = mysqli_stmt_num_rows($prepared);

    if (!$result || $result_count == '0') {
        $validated = FALSE;
    } else {
        mysqli_stmt_bind_result($prepared, $result_email, $result_name, $result_password);
        mysqli_stmt_fetch($prepared); 
    }
}
?>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/admin_header.css">
    <link rel="stylesheet" type="text/css" href="css/adm.css">

    <title><?= $title_pag ?></title>
</head>
<body class="fundo">
    <?php
    $botao_esquerdo['texto'] = "Voltar";
    $botao_esquerdo['action'] = "gerenciar_admin.php";
    $botao_direito["css"] = "hidden";
    $welcome["css"] = "welcome-voltar";
    include('admin_header.php');
    ?>
<style>

h1 {
    margin-bottom: 10px;
    color: black;
    margin-left:10pt;
	font-family: 'Open Sans', sans-serif;
}
label {
    margin-bottom: 10px;
    color: black;
    margin-left:10pt;
	font-family: 'Open Sans', sans-serif;
}
input {
    margin-bottom: 10px;
    color: black;
    margin-left:10pt;
	font-family: 'Open Sans', sans-serif;
}
button {
    margin-bottom: 10px;
    color: black;
    margin-left:10pt;
	font-family: 'Open Sans', sans-serif;
    color: white;
    font-size: 10pt;
    border: 0px;
    background: rgb(215, 102, 109);
    width: 100px;
	height: 35px;
	border-radius: 5px;
}
button:hover{
    background-image: linear-gradient(to right, #982b2e, #8C1317);
}
</style>
    <div class="background" id="tabela">

    <h1><font face="'Open Sans', sans-serif"><?= $title_pag ?></font></h1>

        <form action="editar_admin.php" method="POST">
            <div class="campo">
                <div>
                    <label for="name"><font size="3pt" face="'Open Sans', sans-serif">Nome</label></font> <br> <input type="text" name="name" value="<?= $result_name ?>" class="input" required>
                </div>

                <div>
                    <label for="email"><font size="3pt" face="'Open Sans', sans-serif">E-mail</label></font> <br> <input type="email" name="email" value="<?= $result_email ?>" class="input" required>
                </div>

                <div>
                    <label for="password"><font size="3pt" face="'Open Sans', sans-serif">Senha</label></font> <br> <input type="password" name="password" value="<?= $result_password ?>" class="input" required>
                </div>
            </div>

            <input type="hidden" name="userid" value="<?= $id_adm ?>">
            <div class="btn">
                <button class="save">Salvar</button>
            </div>
        </form>
    </div>
    <div class="footer"></div>
</body>

</html>