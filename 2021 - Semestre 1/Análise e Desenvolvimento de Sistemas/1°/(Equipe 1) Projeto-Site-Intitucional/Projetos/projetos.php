<?php
/*Admin indica se a pág está ou não em modo de edição*/
$admin         = isset($_GET['admin']) ? $_GET['admin'] : "0";
/*Texto_esquerdo faz atualização do lado esquerdo da home e salva no banco de dados */
$texto_esquerdo = isset($_POST['texto_esquerdo']) ? $_POST['texto_esquerdo'] : "";
if ($texto_esquerdo != "") {
    $conexao = mysqli_connect ("localhost", "root", "", "bd_projetos");
    $preparado = mysqli_prepare($conexao, "update tb_conteudo set conteudo = ? where pagina = 'projetos' and localizacao = 'esquerda'");
    mysqli_stmt_bind_param($preparado, "s", $texto_esquerdo);
    mysqli_stmt_execute($preparado);
}

/*Imagem_direita faz atualização da imagem direita da home(ao lado do texto equerdo) e salva a imagem no hd*/
$imagem_direita = isset($_FILES['imagem_direita']) ? $_FILES['imagem_direita'] : "";
if ($imagem_direita) {
    $temp_filename = $imagem_direita["tmp_name"];
    $newfile = 'imagens/uploaded.img';
    copy($temp_filename, $newfile);
}
?>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../Home/css/style.css" media="screen">
    <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    <link rel="icon" href="../Home/imagem/Vó-logo.png">  

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Cabin+Sketch:wght@400;700&display=swap" rel="stylesheet">
    <title>Projetos</title>
    <script type="text/javascript">
        var onloadCallback = function() {
          grecaptcha.render('html_element', {
            'sitekey' : ' 6Lesd6caAAAAAOMb_uTxoAGkr7TS8bmKGJ31tc8S '
          });
        };
    </script>
    <link rel="stylesheet" type="text/css" href="../Administrador/css/admin_header.css">
    <script src="../ckeditor_4.16.0_b1a78bed529d/ckeditor/ckeditor.js"></script>
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
                    <li><a class="btn-menu" href="../Projetos/projetos.php">Projetos</a></li>
                    <li><a href="../Voluntario/cadastro_voluntario.php">Seja um voluntário</a></li>
                    <li><a href="../Contato/Contato2.php">Contato</a></li>
                    <li><a href="../Doaçao/formulario_doador.php">Doações</a></li>
                </ul><!--menu-->

                <ul class="menu-mobile">
                <img class="menu-mobile-icon" src="../Home/imagem/Vó-menu-mobile.png">
                    <div class="menu-itens">
                        <li><a href="../Home/index.php">Home</a></li>
                        <li><a href="../Sobre/sobre.php">Sobre</a></li>
                        <li><a class="btn-menu" href="../Projetos/projetos.php">Projetos</a></li>
                        <li><a href="../Voluntario/cadastrovoluntario.php">Seja um voluntário</a></li>
                        <li><a href="../Contato/Contato2.php">Contato</a></li>
                        <li><a href="../Doaçao/formulario_doador.php">Doações</a></li>
                    </div>
                </ul>

            </div><!--center-->
        </nav>


        <section class="conteudo">
            <div class="center-conteudo">

                <div class="titulo-projetos">
                    <h2 class="titulo">Projetos</h2>                      
                </div>

                <div class="texto">
                    <?php
                        /*Formulário de edição de texto */
                        if ($admin == "1") {
                            echo "<form action=\"projetos.php\" method=\"POST\"> 
                                <textarea id=\"editor\" name=\"texto_esquerdo\">";
                        }
                        $conexao = mysqli_connect("localhost","root","","bd_projetos");
                        $consulta = "select conteudo from tb_conteudo where pagina = 'projetos' and localizacao = 'esquerda'";
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

                <div class="imagem">
                    <?php
                    /*Adiciona o formulário de edição de imagem*/
                        if ($admin == "1") {
                            echo "<form action=\"projetos.php\" method=\"POST\"enctype=\"multipart/form-data\">";
                        }
                        $date = date("Y-m-d-h:i:sa");
                        echo "<img class=\"vó-img\" src=\"imagens/uploaded.img?date=$date\" />";
                        if ($admin == "1") {
                            echo "<label for=\"conteudo\">Enviar imagem:</label>
                            <input type=\"file\" name=\"imagem_direita\" accept=\"image/*\"> <button type=\"submit\">Salvar</button>
                        </form>";
                        }
                    ?>
                </div>

                <div class="saiba-mais">
                    <a href="https://pt-br.facebook.com/cecoivomariafelix/" target="_blank"><button  class="botao left" type="submit" >Saiba mais</button></a>
                </div>
                
            </div><!--center-conteúdo-->
        </section><!--conteúdo-->

        <form class="formulario" method = "post" action="cadastrado_com_sucesso_projeto.php">
            <div class="center-form">

                <div class="titulo-form">
                    <h2 class="subtitulo">Cadastro de Projetos</h2>                      
                </div>

                <fieldset class="grupo">
                    <div class="preenchimento-form">
                        <div class="campo left">
                            <label for="nome"><strong>Nome do empreendedor</strong></label>
                            <input type="text" name="nome" id="nome" placeholder="Nome Completo" required>
                        </div>

                        <div class="campo right">
                            <label for="empresa"><strong>Nome da empresa</strong></label>
                            <input type="text" name="nome_empresa" id="nome_empresa" placeholder="Insira o nome da empresa (opcional)">
                        </div>
                    </div>

                    <div class="preenchimento-form">
                        <div class="campo left">
                            <label for="cpf"><strong>CPF/CNPJ</strong></label>
                            <input type="text" name="cpf" id="cpf" placeholder="Insira seu CPF ou CNPJ" required maxlength="11">
                        </div>
        
                        <div class="campo right">
                            <label class="email"><strong>Email</strong> </label>
                            <input type="email" name="email" id="email" placeholder="Insira seu email" required maxlength="50">
                        </div>
                    </div>

                    <div class="preenchimento-form">
                        <div class="campo left">
                            <label for="tel_number"><strong>Telefone de Contato</strong></label>
                            <input type="tel" name="tel_number" id="tel_number" placeholder="(00) 0000-0000" maxlength="14">
                        </div>
            
                        <div class="campo right">
                            <label for="celular"><strong>Celular de contato</strong></label>
                            <input type="tel" name="celular" id="celular" placeholder="(00) 00000-0000"required maxlength="15">
                        </div> 
                    </div>

                    <div class="preenchimento-form">
                       <div class="campo left">
                            <label for="cidade"><strong>Cidade</strong></label>
                            <input type="text" name="cidade" id="cidade" placeholder="Insira sua cidade" required>
                        </div>

                        <div class="campo right">
                            <label for="estado"><strong>Estado</strong></label>
                            <input type="text" name="estado" id="estado" placeholder="Insira seu estado"required maxlength="15">
                        </div> 
                    </div>

                    <div class="preenchimento-form">
                       <div class="campo inline left">
                       <label>
                                <input type="radio" name="fisica_juridica" value="física" checked>Pessoa Física
                            </label>
                            <label>
                                <input type="radio" name="fisica_juridica" value="jurídica">Pessoa Jurídica
                            </label>
                        </div>
                    </div>

                    <div class="preenchimento-form">
                        <div class="onde-conheceu">
                            <label><b>Como você conheceu a ONG?</b></label><br>
                            <input type="checkbox" id="redesocial" name="redesocial" value="Redes social">
                            <label for="Redes Sociais">Redes sociais</label>
                            <input type="checkbox" id="youtube" name="youtube" value="Youtube">
                            <label for="Youtube">Youtube</label>
                            <input type="checkbox" id="outros" name="outros" value="Outros">
                            <label for="outros">Outros</label>
                        </div>
                    </div>

                    <div class="preenchimento-form">
                        <div class="campo left">
                            <label for="projeto"><strong>Descrição do projeto</strong></label>
                            <input type="text" name="descricao" id="descricao" placeholder="Descreva seu projeto aqui" required>  
                        </div>
                    </div>

                    <div class="preenchimento-form">
                        <div class="campo center">
                            <div id="html_element"></div>
                            <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
                            async defer>
                            </script>   
                        </div> 
                   </div>

                    <div class="preenchimento-form">
                        <div class="campo center">
                            <button class="botao" type="submit">Enviar</button>
                        </div> 
                   </div>
                   
                </fieldset>

            </div>
        </form>

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