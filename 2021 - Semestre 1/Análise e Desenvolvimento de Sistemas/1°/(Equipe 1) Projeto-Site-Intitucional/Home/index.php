<?php
/*Admin indica se a pág está ou não em modo de edição*/
$admin         = isset($_GET['admin']) ? $_GET['admin'] : "0";
/*Texto_esquerdo faz atualização do lado esquerdo da home e salva no banco de dados */
$texto_esquerdo = isset($_POST['texto_esquerdo']) ? $_POST['texto_esquerdo'] : "";
if ($texto_esquerdo != "") {
    $conexao = mysqli_connect ("localhost", "root", "", "bd_home");
    $preparado = mysqli_prepare($conexao, "update tb_conteudo set conteudo = ? where pagina = 'home' and localizacao = 'esquerda'");
    mysqli_stmt_bind_param($preparado, "s", $texto_esquerdo);
    mysqli_stmt_execute($preparado);
}
/*Imagem_direita faz atualização da imagem direita da home(ao lado do texto equerdo) e salva a imagem no hd*/
$imagem_direita = isset($_FILES['imagem_direita']) ? $_FILES['imagem_direita'] : "";
if ($imagem_direita) {
    $temp_filename = $imagem_direita["tmp_name"];
    $newfile = 'imagem/uploaded.img';
    copy($temp_filename, $newfile);
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Vó Maria Félix</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="../Home/imagem/Vó-logo.png">

    <!-- Estilo customizado -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Cabin+Sketch&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="../Administrador/css/admin_header.css"><!--não remover, faz parte do admin!-->
    <script src="../ckeditor_4.16.0_b1a78bed529d/ckeditor/ckeditor.js"></script><!--não remover, faz parte do admin!-->

</head>
<body>
    <?php
        include('../Administrador/admin_header.php'); //não remover, faz parte do admin!
    ?>

    <div id="container"><!-- Início container -->

        <header>
            <div class="center-header">
                <div class="vó-fundo">
                    <img src="../Home/imagem/fundo-3.jpeg">
                </div><!--vó-fundo-->
            </div><!--center-->
        </header>

        <nav>
            <div class="center-nav">
                <div class="logo">
                    <img src="../Home/imagem/Vó-logo.png">
                </div><!--logo-->

                <ul class="menu">
                    <li><a class="btn-menu" href="../Home/index.php">Home</a></li>
                    <li><a href="../Sobre/sobre.php">Sobre</a></li>
                    <li><a href="../Projetos/projetos.php">Projetos</a></li>
                    <li><a href="../Voluntario/cadastro_voluntario.php">Seja um voluntário</a></li>
                    <li><a href="../Contato/Contato2.php">Contato</a></li>
                    <li><a href="../Doaçao/formulario_doador.php">Doações</a></li>
                </ul><!--menu-->

                <ul class="menu-mobile">
                <img class="menu-mobile-icon" src="../Home/imagem/Vó-menu-mobile.png">
                    <div class="menu-itens">
                        <li><a class="btn-menu" href="../Home/index.php">Home</a></li>
                        <li><a href="../Sobre/sobre.php">Sobre</a></li>
                        <li><a href="../Projetos/projetos.php">Projetos</a></li>
                        <li><a href="../Voluntario/cadastro_voluntario.php">Seja um voluntário</a></li>
                        <li><a href="../Contato/Contato2.php">Contato</a></li>
                        <li><a href="../Doaçao/formulario_doador.php">Doações</a></li>
                    </div>
                </ul>

            </div><!--center-->
        </nav>

        <section class="main">
            <div class="center-main">
                <div class="main_cta">
                    <h2>Vó Maria Félix</h2> 
                    <p>Centro comunitário de convivência infantil</p>
                </div><!--main-cta-->
            </div><!--center-->
        </section><!--main--> 

        <section class="vó-content">
            <div class="center-vó">
                <div class="vó-content-left">
                    <?php
                    /*Formulário de edição de texto */
                    if ($admin == "1") {
                        echo "<form action=\"index.php\" method=\"POST\"> 
                            <textarea id=\"editor\" name=\"texto_esquerdo\">";
                    }
                    $conexao = mysqli_connect("localhost","root","","bd_home");
                    $consulta = "select conteudo from tb_conteudo where pagina = 'home' and localizacao = 'esquerda'";
                    $resultado = mysqli_query($conexao, $consulta);
                    if (!$resultado) {
                        die ("OPS! Algo deu errado :( Entre em contato conosco!" . mysqli_error($conexao));
                    }
                    while ($item_da_lista_resultado = mysqli_fetch_assoc($resultado)) {
                        echo $item_da_lista_resultado["conteudo"];
                    }
                    ?>
                           
                    <?php
                    if ($admin == "1") {
                        echo "</textarea> <button type=\"submit\">Salvar</button>
                    </form>";
                    }
                    ?>
                </div>
                <div class="vó-content-right">
                <?php
                /*Adiciona o formulário de edição de imagem*/
                    if ($admin == "1") {
                        echo "<form action=\"index.php\" method=\"POST\"enctype=\"multipart/form-data\">";
                    }
                    $date = date("Y-m-d-h:i:sa");
                    echo "<img class=\"vó-img\" src=\"imagem/uploaded.img?date=$date\" />";
                    if ($admin == "1") {
                        echo "<label for=\"conteudo\">Enviar imagem:</label>
                        <input type=\"file\" name=\"imagem_direita\" accept=\"image/*\"> <button type=\"submit\">Salvar</button>
                    </form>";
                    }
                ?>
                    <!--<img class="vó-img" src="imagem/img-vó-1.jpeg" /> -->
                </div>
                
            </div><!--center-->
        </section><!--vó-->

        <section class="você-pode">
            <div class="center-você-pode">
                <div class="você-pode-left">
                    <p>
                        <span class="azul">Você</span>
                        <span>pode ser a</span>
                        <span class="laranja">mudança</span>
                        <span>na vida de uma</span>
                        <span class="laranja">criança</span>
                        <span class="azul">hoje!</span>
                    </p>
                </div>

                <div class="você-pode-right">
                    <a href="../Doaçao/formulario_doador.php"><button>Seja um doador<img src="imagem/vó-doe.jpeg"></button></a>
                    <a href="../Voluntario/cadastro_voluntario.php"><button>Seja um voluntário<img src="imagem/vó-voluntário.jpeg"></button></a>
                    <a href="../Participantes/cadastro_participantes.php"><button>Inscreva seu filho<img src="imagem/vó-inscreva.jpeg"></button></a>
                </div>
            </div><!--center-->
        </section><!--você-pode-->

        <footer class="footer-vó">
            <div class="center-footer">
                <div class="footer-left">
                        <p>Telefone : (12) 3966- 2833</p>
                        <p>E-mail: administracao@aamu.org.br</p>
                        <p>Horário de Segunda a Sexta, das 07:00h às 17:00hs</p>
                </div>

                <div class="footer-right" style="justify-content: center;
                flex-wrap: wrap;">
                    <p>Você pode nos ajudar compartilhando nossa causa</p>
                    <span>
                        <a target="_blank" href="javascript:void(0)" onclick="share()">
                            <img class="vó-icons-share"src="../Home/imagem/compartilhar.png" />
                        </a>
                            
                        <a target="_blank" href="https://www.instagram.com/explore/locations/1023028168/cecoi-vo-maria-felix/">
                            <img class="vó-icons-share vó-icons-share-insta"src="../Home/imagem/logo-instagram.png" />
                        </a>

                        <a target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=https://www.facebook.com/fatecjessenvidal/">
                            <img class="vó-icons-share vó-icons-share-face" src="../Home/imagem/logo-facebook.png" >
                        </a>
                            
                        <a target="_blank" href="https://api.whatsapp.com/send?text=https://www.facebook.com/fatecjessenvidal/">
                            <img class="vó-icons-share vó-icons-share-whats" src="../Home/../Home/imagem/logo-whatsapp.png" />
                        </a>
                    </span>
                </div>

                <div class="footer-center">
                    <p>2021 
                    <a href="">Vó Maria Félix</a> 
                    - Todos os direitos reservados.</p>
                </div>

            </div>
        </footer>

    </div><!--/fim container -->

    <script>
        function share(){
            if (navigator.share !== undefined) {
                navigator.share({
                    title: 'Maria Vó Félix',
                    text: 'Um texto de resumo',
                    url: 'https://www.facebook.com/fatecjessenvidal/',
                })
                    .then(() => console.log('Successful share'))
                    .catch((error) => console.log('Error sharing', error));
                }
            }
    </script>

    <script>

        var el = document.querySelector('.menu-mobile-icon');

        el.addEventListener('click',()=>{
            //Queremos mostrar o menu.
            var menuItens = document.querySelector('.menu-itens');
            if(menuItens.classList.contains('show')){
                menuItens.classList.add('hide'); 
                menuItens.classList.remove('show'); 
            }else{
                menuItens.classList.add('show'); 
                menuItens.classList.remove('hide'); 
            }       
        });
    </script>

    <script>
        document.addEventListener(
            "DOMContentLoaded", 
            function() {
                CKEDITOR.replace("editor", false) /*inicializa o editor de texto após o carregamento da página */
            }
        )
    </script>
    
</body>
</html>