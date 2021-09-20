<?php
$id_adm = isset($_POST['userid']) ? $_POST['userid'] : "";

if ($id_adm != "") {
    $conection = mysqli_connect("localhost", "root", "", "bd_admin");
    $preparado = mysqli_prepare($conection, "delete from tb_user where id = ?"); //deleta usuário
    mysqli_stmt_bind_param($preparado, "i", $id_adm);
    mysqli_stmt_execute($preparado);
    header('Location: /Projeto-Site-Intitucional/Administrador/listagem_adm.php?');
}

if ($id_adm == "") {
    $title_pag = "Adicionar novo administrador";
} else {
    $title_pag = "Editar administrador";
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

    <title>Administrador</title>
</head>

<body class="background fundo">
    <?php
    $botao_esquerdo['texto'] = "Voltar";
    $botao_esquerdo['action'] = "index.php";
    $welcome["css"] = "welcome-voltar";
    $botao_direito["css"] = "hidden";
    $_GET["admin"] = "1";
    include('../Administrador/admin_header.php');
    ?>
    <div class="background" id="tabela">
        <table>
            <tr class="cabecalho">
                <th>Nome</th>
                <th>E-mail</th>
                <th class="coluna_acoes">Ações</th>
            </tr>

            <?php
            $conection = mysqli_connect("localhost", "root", "", "bd_admin");
            $consulta = "select email, name, id from tb_user";
            $resultado = mysqli_query($conection, $consulta);
            if (!$resultado) {
                die("OPS! Algo deu errado :( Entre em contato conosco!" . mysqli_error($conection));
            }
            while ($item_da_lista_resultado = mysqli_fetch_assoc($resultado)) {
                echo "<tr>";
                echo "<td class=\"coluna\">" . $item_da_lista_resultado["name"] . "</td>";
                echo "<td class=\"coluna\">" . $item_da_lista_resultado["email"] . "</td>";
                echo "<td class=\"coluna\">";
                echo "  <form  class=\"left\" action=\"editar_adm.php\" method=\"GET\">";
                echo "      <button class=\"botao_acoes\">";
                echo "          <input type=\"hidden\" name=\"admin\" value=\"1\">";
                echo "          <input type=\"hidden\" name=\"userid\" value=\"" . $item_da_lista_resultado["id"] . "\">";
                echo "         <img class=\"\" src=\"imagens/Edit-icon.png\" alt=\"Imagem de edição\" title=\"Editar dados do administrador\">";
                echo "      </button>";
                echo "  </form>";
                echo "  <form class=\"right\" action=\"listagem_adm.php\" method=\"POST\">";
                if ($_SESSION["email"] == $item_da_lista_resultado["email"]) {
                    echo "      <button class=\"botao_acoes\"disabled>";
                } else {
                    echo "      <button class=\"botao_acoes\">";
                }
                echo "          <input type=\"hidden\" name=\"userid\" value=\"" . $item_da_lista_resultado["id"] . "\">";
                echo "          <img class=\"\" src=\"imagens/Trash-icon.png\" alt=\"Imagem de remoção\" title=\"Remover administrador\">";
                echo "      </button>";
                echo "  </form>";
                echo "</td>";
                echo "</tr>";
            }
            ?>

        </table>
        <div>
            <a href="../Administrador/editar_adm.php">
                <div class="newuser">
                    <img src="../Administrador/imagens/adduser.png" alt="Imagem add user" title="Adicionar novo administrador">
                </div>
            </a>
        </div>
    </div>
    <div class="footer">
        <div class="xtreme">by Equipe Xtreme <br>github.com/Xtreme-Equipe</div>
    </div>
</body>

</html>