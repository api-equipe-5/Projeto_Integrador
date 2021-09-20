<?php
/*Admin indica se a pág está ou não em modo de edição*/
$admin         = isset($_GET['admin']) ? $_GET['admin'] : "0";
/*Texto_esquerdo faz atualização do lado esquerdo da home e salva no banco de dados */
$texto = isset($_POST['texto_esquerdo']) ? $_POST['texto_esquerdo'] : "";
if ($texto != "") {
    $conexao = mysqli_connect ("localhost", "root", "", "bd_contato");
    $preparado = mysqli_prepare($conexao, "update tb_conteudo set conteudo = ? where pagina = 'Contato2' and localizacao = 'esquerda'");
    mysqli_stmt_bind_param($preparado, "s", $texto);
    mysqli_stmt_execute($preparado);
}
?>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../Home/css/style.css" media="screen">
    <link rel="stylesheet" type="text/css" href="contato.css" media="screen">
    <link rel="icon" href="../Home/imagem/Vó-logo.png">  

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Cabin+Sketch:wght@400;700&display=swap" rel="stylesheet">
    <title>Formulário de Contato</title>
    <link rel="stylesheet" type="text/css" href="../Administrador/css/admin_header.css"><!--não remover, faz parte do admin!-->
    <script src="../ckeditor_4.16.0_b1a78bed529d/ckeditor/ckeditor.js"></script> <!--não remover, faz parte do admin!-->
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
                    <li><a href="../Sobre/sobre.php">Sobre</a></li>
                    <li><a href="../Projetos/projetos.php">Projetos</a></li>
                    <li><a href="../Voluntario/cadastro_voluntario.php">Seja um voluntário</a></li>
                    <li><a class="btn-menu" href="../Contato/Contato2.php">Contato</a></li>
                    <li><a href="../Doaçao/formulario_doador.php">Doações</a></li>
                </ul><!--menu-->

                <ul class="menu-mobile">
                <img class="menu-mobile-icon" src="../Home/imagem/Vó-menu-mobile.png">
                    <div class="menu-itens">
                        <li><a href="../Home/index.php">Home</a></li>
                        <li><a href="../Sobre/sobre.php">Sobre</a></li>
                        <li><a href="../Projetos/projetos.php">Projetos</a></li>
                        <li><a href="../Voluntario/cadastrovoluntario.php">Seja um voluntário</a></li>
                        <li><a class="btn-menu" href="../Contato/Contato2.php">Contato</a></li>
                        <li><a href="../Doaçao/formulario_doador.php">Doações</a></li>
                    </div>
                </ul>

            </div><!--center-->
        </nav>


        <section class="conteudo">
            <div class="center-conteudo">

                <div class="titulo-contato">
                    <h2 class="titulo">Contato</h2>                      
                </div>

                <div class="left">
                    <?php
                    /*Formulário de edição de texto */
                    if ($admin == "1") {
                        echo "<form action=\"Contato2.php\" method=\"POST\"> 
                                <textarea id=\"editor\" name=\"texto_esquerdo\">";
                    }
                    $conexao = mysqli_connect("localhost", "root", "", "bd_contato");
                    $consulta = "select conteudo from tb_conteudo where pagina = 'Contato2' and localizacao = 'esquerda'";
                    $resultado = mysqli_query($conexao, $consulta);
                    if (!$resultado) {
                        die("OPS! Algo deu errado :( Entre em contato conosco!" . mysqli_error($conexao));
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

                <div class="imagem">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d14660.29387667944!2d-45.8999728!3d-23.27678!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xd429ce060f725c70!2sCECOI%20V%C3%B3%20Maria%20F%C3%A9lix!5e0!3m2!1sen!2sbr!4v1617325066947!5m2!1sen!2sbr" width="500" height="350" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
                </div>

            </div><!--center-conteúdo-->
        </section><!--conteúdo-->

        <form class="formulario" name="formtest" method="post" action="cadastrado_com_sucesso_contato.php">
            <div class="center-formulario">

                <div class="titulo-formulario">
                    <h2 class="titulo-form">FALE CONOSCO</h2>                      
                </div>

                <fieldset class="grupo">
                    <div class="preenchimento-form">
                        <div class="campo center">
                            <input type="text" name="nome" placeholder="Nome:" required="required">
                        </div>
                    </div>

                    <div class="preenchimento-form">
                        <div class="campo center">
                            <input type="email" name="email" placeholder="E-mail:" required="required">
                        </div>
                    </div>

                    <div class="preenchimento-form">
                        <div class="campo center">
                            <input type="tel" name="telefone" placeholder="Telefone:" required="required">
                        </div>
                    </div>

                    <div class="preenchimento-form-textarea">
                        <div class="campo center">
                            <textarea type="textarea" maxlength="120" name="descricao" placeholder="Descreva o motivo do contato:" required="required"></textarea>
                        </div>
                    </div>

                    <div class="preenchimento-form">
                        <div class="campo center">
                            <button class="botao" type="submit">Enviar</button>
                        </div> 
                   </div>

                </fieldset>


            </div><!--center-conteúdo-->
        </form><!--conteúdo-->

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
                        <a target="_blank" href="javascript:void(0)" onclick="share()" >
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
                CKEDITOR.replace("editor", false) /*inicializa o editor de texto após o carregamento da página */
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