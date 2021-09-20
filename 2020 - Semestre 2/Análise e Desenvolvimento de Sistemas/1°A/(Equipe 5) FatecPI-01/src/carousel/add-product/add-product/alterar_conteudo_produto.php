<?php

    $id = $_REQUEST['id'];

    include("conexao.php");

    if (isset($_POST['enviar'])):

        $descricao = $_POST['descricao'];
        $disciplina = $_POST['disciplina'];
        $titulo_produto = $_POST['titulo_produto'];
        $preco = $_POST['preco'];

        if (isset($_FILES['file_cv']) && strlen($_FILES['file_cv']['name']) > 0){

            $formatosPermitidos = array ("pdf", "doc","docx");

                $extensao = pathinfo($_FILES['file_cv']['name'], PATHINFO_EXTENSION);
                if (in_array($extensao, $formatosPermitidos)):
                    $pasta = "arquivos/";
                    $temporario = $_FILES ['file_cv']["tmp_name"];
                    $nome = $_FILES['file_cv']['name'];
                    $caminho = $pasta.$nome;

                    if (move_uploaded_file($temporario, $pasta.$nome)):
                        echo  "<script>alert('Material cadastrado com sucesso');</script>";

                        $sql = "update arquivos set titulo_produto='$titulo_produto', nome_arquivo='$nome', disciplina='$disciplina', descricao='$descricao', extensao_arquivo='$extensao', preco='$preco', caminho='$caminho' where id='$id'";
                        mysqli_query($conexao, $sql);
                        header('Location:../../edicao_concluida.php');
                    else:
                        header('Location:../../change-product.php');
                    endif;
                else:
                    header('Location:../../change-product.php');
                endif;
        }
        else {
            $sql = "update arquivos set titulo_produto='$titulo_produto', disciplina='$disciplina', descricao='$descricao', preco='$preco' where id='$id'";
            mysqli_query($conexao, $sql);
            header('Location:../../edicao_concluida.php');
        }
            
    endif;

?>