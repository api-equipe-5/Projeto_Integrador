<?php
session_start();
$nome_logado = '';
$islogado = FALSE;
if (isset($_SESSION) && isset($_SESSION['name'])) {
    if ($_SESSION['name']) {
        $islogado = TRUE;
        $nome_logado = $_SESSION['name'];
    }
}

if (!$islogado) {
    echo '<!--';
}
$admin = isset($_GET['admin']) ? $_GET['admin'] : "0";
$class_editar = ''; //habilita edição
$class_descartar = 'hidden';

if ($admin == '1') {

    $class_editar = 'hidden';
    $class_descartar = ''; //habilita descarte
}

if (!$islogado && $admin == '1') {
    header('Location: /Projeto-Site-Intitucional/Administrador/login.php'); //redirect
}

if (!isset($botao_esquerdo)) {
    $botao_customizado = "hidden";
    $botao_padrao = "show";
    $botao_esquerdo['action'] = "";
    $botao_esquerdo['texto'] = "";
} else {
    $botao_customizado = "show";
    $botao_padrao = "hidden";
}
if(!isset($botao_esquerdo['css'])){
    $botao_esquerdo['css'] = "";
}
if(!isset($botao_direito)){
    $botao_direito["css"] = "";
}
if(!isset($welcome)){
    $welcome["css"] = "";
}
?>

<div class="barra_admin btn">
    <div>
        <div class="<?=$botao_padrao?>">
            <form class="<?= $class_editar?>" action="" method="GET">
                <input type="hidden" name="admin" value="1">
                <button class="editar" title="Habilita edição do texto sobre a ONG e altera a imagem ao lado do texto">Editar página</button>
            </form>

            <form class="<?= $class_descartar ?>" action="" method="GET">
                <input type="hidden" name="admin" value="0">
                <button class="descartar" title="Descarta a edição do texto sobre a ONG e também as alterações da imagem ao lado do texto">Descartar</button>
            </form>
        </div>

        <div class="<?=$botao_customizado?>">
            <form action="<?=$botao_esquerdo['action']?>" method="GET">
                <button class="editar <?=$botao_esquerdo['css']?>"><?=$botao_esquerdo['texto']?></button>
            </form>
        </div>
    </div>
    <span class="welcome <?=$welcome['css']?>">
        Bem-vindo(a) <strong><?= $nome_logado ?></strong>
    </span>

    <div class="sair">
        <form action="../Administrador/login.php" method="POST">
            <input type="hidden" name="logout" value="True">
            <button class="sair">Sair</button>
        </form>
    </div>

    <div class="painel <?=$botao_direito["css"]?>">
        <form action="../Administrador/index.php" method="GET">
            <button class="painel">Painel Administrador</button>
        </form>
    </div>
</div>
<?php
if (!$islogado) {
    echo '-->';
}
?>