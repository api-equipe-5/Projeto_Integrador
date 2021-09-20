<?php
/*Admin indica se a pág está ou não em modo de edição*/
$admin         = isset($_GET['admin']) ? $_GET['admin'] : "0";
/*Texto_esquerdo faz atualização do lado esquerdo da home e salva no banco de dados */
$texto = isset($_POST['texto']) ? $_POST['texto'] : "";
if ($texto != "") {
    $conexao = mysqli_connect ("localhost", "root", "", "bd_participantes");
    $preparado = mysqli_prepare($conexao, "update tb_conteudo set conteudo = ? where pagina = 'cadastro_participantes' and localizacao = 'centro'");
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
        <link rel="stylesheet" type="text/css" href="cadastro_participantes.css" media="screen">
        <link rel="icon" href="../Home/imagem/Vó-logo.png">  

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Cabin+Sketch:wght@400;700&display=swap" rel="stylesheet">
        <title>Participantes</title>
        <script type="text/javascript">
            var onloadCallback = function() {
                grecaptcha.render('html_element', {
                'sitekey' : ' 6Lesd6caAAAAAOMb_uTxoAGkr7TS8bmKGJ31tc8S '
                });
            };
        </script>
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
                    <li><a href="../Contato/Contato2.php">Contato</a></li>
                    <li><a href="../Doaçao/formulario_doador.php">Doações</a></li>
                </ul><!--menu-->

                <ul class="menu-mobile">
                <img class="menu-mobile-icon" src="../Home/imagem/Vó-menu-mobile.png">
                    <div class="menu-itens">
                        <li><a href="../Home/index.php">Home</a></li>
                        <li><a href="../Sobre/sobre.php">Sobre</a></li>
                        <li><a href="../Projetos/projetos.php">Projetos</a></li>
                        <li><a href="../Voluntario/cadastro_voluntario.php">Seja um voluntário</a></li>
                        <li><a href="../Contato/Contato2.php">Contato</a></li>
                        <li><a href="../Doaçao/formulario_doador.php">Doações</a></li>
                    </div>
                </ul>

            </div><!--center-->
        </nav>

        <section class="conteudo-alunos">
            <div class="center-alunos">

                <div class="titulo-alunos">
                    <h2 class="titulo">Inscrição Aluno</h2>                      
                </div>

                <div class="texto">
                    <?php
                    /*Formulário de edição de texto */
                    if ($admin == "1") {
                        echo "<form action=\"cadastro_participantes.php\" method=\"POST\"> 
                                <textarea id=\"editor\" name=\"texto\">";
                    }
                        $conexao = mysqli_connect("localhost","root","","bd_participantes");
                        $consulta = "select conteudo from tb_conteudo where pagina = 'cadastro_participantes' and localizacao = 'centro'";
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
                    <!--<p>-Bem-vindo, a pré-inscrição online possibilita ao futuro estudante solicitar uma vaga para o ano vigente. Primeiramente solicitamos que preencha os campos abaixo.
                           Esses dados serão usados para chegarmos até você. <p>
                        A sua pré-inscrição será realizada de modo on-line e será analisada, e entramemos em contato caso tenha vaga.</p>
                    </p>-->
                </div>  
            </div><!--center-conteúdo-->
        </section><!--conteúdo-->

        <form class="formulario" method = "post" action="participante_concluido.php">
            <div class="center-form">

                <div class="titulo-form">
                    <h2 class="subtitulo">Cadastro de Aluno</h2>                      
                </div>

                <fieldset class="grupo">
                    <div class="preenchimento-form">
                        <div class="campo left">
                            <label for="nome"><strong>Nome do candidato</strong></label>
                            <input type="text" name="nome" id="nome" placeholder="Nome Completo" required>
                        </div>

                        <div class="campo right">
                            <label for="nascimento"><strong>Data de nascimento</strong></label>
                            <input type="date" name="nascimento" id="nascimento" required>
                        </div>
                    </div>

                    <div class="preenchimento-form">
                        <div class="campo left">
                            <label for="nome_pai"><strong>Nome do pai</strong></label>
                            <input type="text" name="nome_pai" id="nome_pai" placeholder="Nome Completo">
                            <br>
                            <label><strong>Pai não declarado</strong></label>
                            <input type="checkbox" id="pai_desconhecido" name="paternidade" value="Pai não declarado">
                        </div>
        
        
                        <div class="campo right">
                            <label for="nome_mae"><strong>Nome da mãe</strong></label>
                            <input type="text" name="nome_mae" id="nome_mae" placeholder="Nome Completo" required>
                        </div>
                    </div>

                    <div class="preenchimento-form">
                        <div class="campo left">
                            <label for="cpf"><strong>CPF do responsável</strong></label>
                            <input type="text" name="cpf" id="cpf" placeholder="xxx.xxx.xxx-xx" required maxlength="11">
                        </div>
            
                        <div class="campo right">
                            <label for="tel_number"><strong>Telefone de Contato</strong></label>
                            <input type="tel" name="tel_number" id="tel_number" placeholder="(00) 0000-0000" maxlength="14">
                        </div> 
                    </div>

                    <div class="preenchimento-form">
                       <div class="campo left">
                            <label for="celular"><strong>Celular de contato</strong></label>
                            <input type="tel" name="celular" id="celular" placeholder="(00) 00000-0000"required maxlength="15">
                        </div>

                        <div class="campo right">
                            <label for="email"><strong>Email</strong></label>
                            <input type="email" name="email" id="email" placeholder="name@name.com" required>
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
                        <div class="checkbox">
                            <label>Especifique</label>
                            <textarea row="3" id="especifique" name="especifique"></textarea>     
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