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
$class_editar = ''; /*inutilizado*/
$class_descartar = ''; /*inutilizado*/
 
if ($admin == '1') {

    $class_editar = 'hidden'; /*inutilizado*/
    $class_descartar = '';    /*inutilizado*/
}
if (!$islogado && $admin == '1') {
    header('Location: /admin/login.php');
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
<link rel="stylesheet" type="text/css" href="css/admin_header.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<style type="text/css"> 
</style>
<div class="barra_admin">
    <div>
        <div class="<?=$botao_padrao?>">
            </form>
        </div>
        <div class="<?=$botao_customizado?>">
            <form action="<?=$botao_esquerdo['action']?>" method="GET">
                <button class="editar <?=$botao_esquerdo['css']?>"><?=$botao_esquerdo['texto']?></button>
            </form>
        </div>
    </div>
	
    <span class="welcome <?=$welcome['css']?>">
        Olá <strong><?= $nome_logado ?></strong>
    </span>
    <div class="sair">
        <form action="/ong/admin/login.php" method="POST">
            <input type="hidden" name="logout" value="True">
            <button class="sair">Sair</button>
        </form>
    </div>
</div>
<?php
if (!$islogado) {
    echo '-->';
}
?>