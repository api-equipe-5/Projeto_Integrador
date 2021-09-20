<?php
session_start();
$num = $_SESSION['materia'];

$pathToSave = $_SERVER["DOCUMENT_ROOT"].
"/pdf/";

/*Checa se a pasta existe - caso negativo ele cria*/
if (!file_exists($pathToSave)) {
    mkdir($pathToSave);
}

if ($_FILES) { // Verificando se existe o envio de arquivos.

    if ($_FILES['txtArquivo']) { // Verifica se o campo não está vazio.
        $dir = $pathToSave; // Diretório que vai receber o arquivo.
        $tmpName = $_FILES['txtArquivo']['tmp_name']; // Recebe o arquivo temporário.

        if($num == 1){
            $name = '1.pdf'; // Recebe o nome do arquivo.
        }
        else if($num == 2){
            $name = '2.pdf'; // Recebe o nome do arquivo.
        }
        else if($num == 3){
            $name = '3.pdf'; // Recebe o nome do arquivo.
        }
        else if($num == 4){
            $name = '4.pdf'; // Recebe o nome do arquivo.
        }
        else if($num == 5){
            $name = '5.pdf'; // Recebe o nome do arquivo.
        }
        else if($num == 6){
            $name = '6.pdf'; // Recebe o nome do arquivo.
        }

        preg_match_all('/\.[a-zA-Z0-9]+/', $name, $extensao);
        if (!in_array(strtolower(current(end($extensao))), array('.txt', '.pdf', '.doc', '.xls', '.xlms'))) {
            echo('Permitido apenas arquivos doc,xls,pdf e txt.');
            header('Location: materia.php');
            die;
        }

        // move_uploaded_file( $arqTemporário, $nomeDoArquivo )
        if (move_uploaded_file($tmpName, $dir.$name)) { // move_uploaded_file irá realizar o envio do arquivo.        
            echo('Arquivo adicionado com sucesso.');
        } else {
            echo('Erro ao adicionar arquivo.');
        }    
    }  
}
?>