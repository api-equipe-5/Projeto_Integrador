<?php
    session_start();
    include('conexao.php');
?>    
<?php
        if (isset($_POST['enviar'])):
            $formatosPermitidos = array ("pdf", "apk");

                $extensao = pathinfo($_FILES['file_cv']['name'], PATHINFO_EXTENSION);
                if (in_array($extensao, $formatosPermitidos)):
                    $pasta = "arquivos/";
                    $temporario = $_FILES ['file_cv']["tmp_name"];
                    $nome = $_FILES['file_cv']['name'];
                    $descricao = $_POST['descricao'];
                    $disciplina = $_POST['disciplina'];
                    $titulo_produto = $_POST['titulo_produto'];
                    $preco = $_POST['preco'];
                    $caminho = $pasta.$nome;

                    if (move_uploaded_file($temporario, $pasta.$nome)):
                        echo  "<script>alert('Material cadastrado com sucesso');</script>";
                        // echo("<a href='../../produtos.php#'>Voltar para a página de produtos</a>");

                        $sql = "insert into arquivos (titulo_produto, nome_arquivo, disciplina, descricao, extensao_arquivo, preco, caminho) values ('$titulo_produto', '$nome', '$disciplina', '$descricao', '$extensao', '$preco', '$caminho')";
                        mysqli_query($conexao, $sql);
                        header('Location:../../upload_concluido.php');
                    else:
                        echo  "<script>alert('Erro ao cadastrar material');</script>";
                    endif;
                else:
                     echo  "<script>alert('Extensão não permitida');</script>";
                endif;
        endif;
    ?>