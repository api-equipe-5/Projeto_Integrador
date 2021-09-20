<?php
$id_adm = isset($_POST['userid']) ? $_POST['userid'] : "";

if ($id_adm != "") {
    $conection = mysqli_connect("localhost", "root", "", "vomariafelix");
    $preparado = mysqli_prepare($conection, "delete from admin where id = ?");
    mysqli_stmt_bind_param($preparado, "i", $id_adm);
    mysqli_stmt_execute($preparado);
    header('Location: gerenciar_admin.php?');
}
if ($id_adm == ""){
    $title_pag = "Adicionar novo administrador";
}
else{
    $title_pag = "Editar administrador";
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
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <title>Administrador</title>
</head>

<body class="background fundo">
    <?php
    $botao_esquerdo['texto'] = "Voltar";
    $botao_esquerdo['action'] = "index.php";
    $welcome["css"] = "welcome-voltar";
    $botao_direito["css"] = "hidden";
    include('admin_header.php');
    ?>
<style>
table {
	border-color:black;
	width: 100% !important;
    margin: auto;
}
</style>
    <div class="background"id="tabela">
        <table border="1" cellpadding="5px" cellspacing="0">
            <tr class="cabecalho" >
                <th>Nome</th>
                <th>E-mail</th>
                <th class="coluna_acoes">Ações</th>
            </tr>

            <?php
            $conection = mysqli_connect("localhost", "root", "", "vomariafelix");
            $consulta = "select email, name, id from admin";
            $resultado = mysqli_query($conection, $consulta);
            if (!$resultado) {
                die("OPS! Algo deu errado :( Entre em contato conosco!" . mysqli_error($conection));
            }
            while ($item_da_lista_resultado = mysqli_fetch_assoc($resultado)) {
                echo "<tr>";
                echo "<td class=\"coluna\"><font face=\"'Open Sans', sans-serif\">" . $item_da_lista_resultado["name"] ."</font></td>";
                echo "<td class=\"coluna\"><font face=\"'Open Sans', sans-serif\">" . $item_da_lista_resultado["email"] ."</font></td>";
                echo "<td class=\"coluna\">";
                echo "  <form  class=\"left\" action=\"editar_admin.php\" method=\"GET\">";
                echo "      <button class=\"botao_acoes\">";
                echo "          <input type=\"hidden\" name=\"admin\" value=\"1\">";
                echo "          <input type=\"hidden\" name=\"userid\" value=\"" . $item_da_lista_resultado["id"] . "\">";
                echo "         <img class=\"\" src=\"imagens/editar.png\" alt=\"Imagem de edição\" title=\"Editar dados do administrador\">";
                echo "      </button>";
                echo "  </form>";
                echo "  <form class=\"right\" action=\"gerenciar_admin.php\" method=\"POST\">";
                if($_SESSION["email"] == $item_da_lista_resultado["email"]){
                    echo "      <button class=\"botao_acoes\"disabled>";
                }
                else{
                     echo "      <button class=\"botao_acoes\">";
                }
                echo "          <input type=\"hidden\" name=\"userid\" value=\"" . $item_da_lista_resultado["id"] . "\">";
                echo "          <img class=\"\" src=\"imagens/descartar.png\" alt=\"Imagem de remoção\" title=\"Remover administrador\">";
                echo "      </button>";
                echo "  </form>";
                echo "</td>";
                echo "</tr>";
            }
            ?>
        </table>
        <div>
            <a href="../admin/editar_admin.php">
		</div>
        <div class="newuser">
                <img src="./imagens/add.png" alt="img add" title="Adicionar novo administrador">
        </div>
        
    </div>
    <div class="footer"></div>
</body>
</html>