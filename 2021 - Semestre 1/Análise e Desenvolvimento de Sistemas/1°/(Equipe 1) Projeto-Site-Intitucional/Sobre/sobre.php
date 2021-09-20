<?php
/*Admin indica se a pág está ou não em modo de edição*/
$admin         = isset($_GET['admin']) ? $_GET['admin'] : "0";
/*Texto_direito(missao, visao valores) fazem atualização dos textos informativos do lado direito sobre missão visão e valores da instituição */
$texto_direito_missao = isset($_POST['texto_direito_missao']) ? $_POST['texto_direito_missao'] : "";
if ($texto_direito_missao != "") {
    $conexao = mysqli_connect ("localhost", "root", "", "bd_sobre");
    $preparado = mysqli_prepare($conexao, "update tb_conteudo set conteudo = ? where pagina = 'sobre' and localizacao = 'direita_missao'");
    mysqli_stmt_bind_param($preparado, "s", $texto_direito_missao);
    mysqli_stmt_execute($preparado);
}

$texto_direito_visao = isset($_POST['texto_direito_visao']) ? $_POST['texto_direito_visao'] : "";
if ($texto_direito_visao != "") {
    $conexao = mysqli_connect ("localhost", "root", "", "bd_sobre");
    $preparado = mysqli_prepare($conexao, "update tb_conteudo set conteudo = ? where pagina = 'sobre' and localizacao = 'direita_visao'");
    mysqli_stmt_bind_param($preparado, "s", $texto_direito_visao);
    mysqli_stmt_execute($preparado);
}

$texto_direito_valores = isset($_POST['texto_direito_valores']) ? $_POST['texto_direito_valores'] : "";
if ($texto_direito_valores != "") {
    $conexao = mysqli_connect ("localhost", "root", "", "bd_sobre");
    $preparado = mysqli_prepare($conexao, "update tb_conteudo set conteudo = ? where pagina = 'sobre' and localizacao = 'direita_valores'");
    mysqli_stmt_bind_param($preparado, "s", $texto_direito_valores);
    mysqli_stmt_execute($preparado);
}
?>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../Home/css/style.css" media="screen">
    <link rel="stylesheet" type="text/css" href="sobre.css" media="screen">
    <link rel="icon" href="../Home/imagem/Vó-logo.png">  

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script&family=Leckerli+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Cabin+Sketch:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../Administrador/css/admin_header.css"><!--não remover, faz parte do admin!-->
    <script src="../ckeditor_4.16.0_b1a78bed529d/ckeditor/ckeditor.js"></script> <!--não remover, faz parte do admin!-->
    <title>Sobre</title>
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
                    <a href="../Home/index.php">
                    <img src="../Home/imagem/Vó-logo.png">
                    </a>
                </div><!--logo-->

                <ul class="menu">
                    <li><a href="../Home/index.php">Home</a></li>
                    <li><a class="btn-menu" href="../Sobre/sobre.php">Sobre</a></li>
                    <li><a href="../Projetos/projetos.php">Projetos</a></li>
                    <li><a href="../Voluntario/cadastro_voluntario.php">Seja um voluntário</a></li>
                    <li><a href="../Contato/Contato2.php">Contato</a></li>
                    <li><a href="../Doaçao/formulario_doador.php">Doações</a></li>
                </ul><!--menu-->

                <ul class="menu-mobile">
                <img class="menu-mobile-icon" src="../Home/imagem/Vó-menu-mobile.png">
                    <div class="menu-itens">
                        <li><a href="../Home/index.php">Home</a></li>
                        <li><a class="btn-menu" href="../Sobre/sobre.php">Sobre</a></li>
                        <li><a href="../Projetos/projetos.php">Projetos</a></li>
                        <li><a href="../Voluntario/cadastro_voluntario.php">Seja um voluntário</a></li>
                        <li><a href="../Contato/Contato2.php">Contato</a></li>
                        <li><a href="../Doaçao/formulario_doador.php">Doações</a></li>
                    </div>
                </ul>

            </div><!--center-->
        </nav>


        <section class="titulo-conteudo">
            <div class="center-titulo">
                <div class="titulo-sobre-nos">
                    <h2 class="titulo">Sobre Nós</h2>  
                </div>
            </div>
        </section>

        <section class="sobre-nos">
            <div class="center-sobre-nos">

                <div class="paragrafo-missao">
                    <div class="texto-missao">
                        <h2 class="missao">Missão</h2> 
                    </div>
                    <div class="p-missao">
                        <?php
                        /*Formulário de edição de texto */
                        if ($admin == "1") {
                            echo "<form action=\"sobre.php\" method=\"POST\"> 
                                <textarea id=\"editor_missao\" name=\"texto_direito_missao\">";
                        }
                        $conexao = mysqli_connect("localhost","root","","bd_sobre");
                        $consulta = "select conteudo from tb_conteudo where pagina = 'sobre' and localizacao = 'direita_missao'";
                        $resultado = mysqli_query($conexao, $consulta);
                        if (!$resultado) {
                            die ("OPS! Algo deu errado :( Entre em contato conosco!" . mysqli_error($conexao));
                        }
                        while ($item_da_lista_resultado = mysqli_fetch_assoc($resultado)) {
                            echo $item_da_lista_resultado["conteudo"];
                        }
                        
                        if ($admin == "1") {
                            echo "</textarea> <button type=\"submit\">Salvar</button>
                        </form>";
                        }
                        ?>
                    </div>
                </div>

                <div class="paragrafo-visao">
                    <div class="texto-visao">
                        <h2 class="visao">Visão</h2> 
                    </div>
                    <div class="p-visao">
                        <?php
                        /*Formulário de edição de texto */
                        if ($admin == "1") {
                            echo "<form action=\"sobre.php\" method=\"POST\"> 
                                <textarea id=\"editor_visao\" name=\"texto_direito_visao\">";
                        }
                        $conexao = mysqli_connect("localhost","root","","bd_sobre");
                        $consulta = "select conteudo from tb_conteudo where pagina = 'sobre' and localizacao = 'direita_visao'";
                        $resultado = mysqli_query($conexao, $consulta);
                        if (!$resultado) {
                            die ("OPS! Algo deu errado :( Entre em contato conosco!" . mysqli_error($conexao));
                        }
                        while ($item_da_lista_resultado = mysqli_fetch_assoc($resultado)) {
                            echo $item_da_lista_resultado["conteudo"];
                        }
                        
                        if ($admin == "1") {
                            echo "</textarea> <button type=\"submit\">Salvar</button>
                        </form>";
                        }
                        ?>  
                    </div>
                </div>

                <div class="paragrafo-valores">
                    <div class="texto-valores">
                        <h2 class="valores">Valores</h2> 
                    </div>
                    <div class="p-valores">
                        <?php
                        /*Formulário de edição de texto */
                        if ($admin == "1") {
                            echo "<form action=\"sobre.php\" method=\"POST\"> 
                                <textarea id=\"editor_valores\" name=\"texto_direito_valores\">";
                        }
                        $conexao = mysqli_connect("localhost","root","","bd_sobre");
                        $consulta = "select conteudo from tb_conteudo where pagina = 'sobre' and localizacao = 'direita_valores'";
                        $resultado = mysqli_query($conexao, $consulta);
                        if (!$resultado) {
                            die ("OPS! Algo deu errado :( Entre em contato conosco!" . mysqli_error($conexao));
                        }
                        while ($item_da_lista_resultado = mysqli_fetch_assoc($resultado)) {
                            echo $item_da_lista_resultado["conteudo"];
                        }
                        
                        if ($admin == "1") {
                            echo "</textarea> <button type=\"submit\">Salvar</button>
                        </form>";
                        }
                        ?>
                    </div>
                </div>
                    
            </div><!--center-->
        </section><!--sobre-nos-->


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
                            <img class="vó-icons-share vó-icons-share-whats" src="../Home/imagem/logo-whatsapp.png" />
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
        document.addEventListener(
            "DOMContentLoaded", 
            function() {
                CKEDITOR.replace("editor_missao", false) /*inicializa o editor de texto após o carregamento da página */
                CKEDITOR.replace("editor_visao", false)
                CKEDITOR.replace("editor_valores", false)
            }
        )

    </script>

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

</body>

</html>