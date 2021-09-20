<?php include("conexao.php");?>
<?php
  $fild_nome=$_POST['nome_prod'];
  $preco=$_POST['preco'];
  //$estoque=$_POST['estoque'];
  $idcat=$_POST['sel_cat'];
  $desc=$_POST['desc'];

  /**
   * 
   * Destinado para salvar o imagem
   */

  $_img['pasta'] = 'imagens/';
  $_img['tamanho'] = 1024 * 1024 * 1024 * 1024 * 1024 * 1000; 
  $_img['extensoes'] = array('jpeg', 'jpg', 'png', 'gif');
  $_img['renomeia'] = false;

  $_img['erros'][0] = 'Não houve erro';
  $_img['erros'][1] = 'A imagem no upload é maior do que o limite do PHP';
  $_img['erros'][2] = 'A imagem ultrapassa o limite de tamanho especifiado no HTML';
  $_img['erros'][3] = 'O upload da imagem foi feito parcialmente';
  $_img['erros'][4] = 'Não foi feito o upload da imagem';

  if (@$_FILES['imagem']['error'] != 0) {	
    die("Não foi possível fazer o upload, erro:" . $_img['erros'][$_FILES['imagem']['error']]);
    exit;
  }

  @$extensao = strtolower(end(explode('.', $_FILES['imagem']['name'])));
  if (array_search($extensao, $_img['extensoes']) === false) {
    echo "Por favor, envie imagens com as seguintes extensões: jpeg, jpg, png";
    exit;
  }

  if (@$_img['tamanho'] < @$_FILES['imagem']['size']) {
    echo "A imagem enviada é muito grande, envie imagens de até 1000Mb.";
    exit;
  }

  if ($_img['renomeia'] == true) {
    $img = time().'.png';
  } else {
    $img = $_FILES['imagem']['name'];
  }

  /**
   * 
   * Destinado para salvar o arquivo
   */

  $_arq['pasta'] = 'arquivos/';
  $_arq['tamanho'] = 1024 * 1024 * 1024 * 1024 * 1024 * 1000; 
  $_arq['extensoes'] = array('jpg', 'png', 'gif' ,'txt','docx','xlsx','mp3','mp4','pdf');
  $_arq['renomeia'] = false;

  $_arq['erros'][0] = 'Não houve erro';
  $_arq['erros'][1] = 'O arquivo no upload é maior do que o limite do PHP';
  $_arq['erros'][2] = 'O arquivo ultrapassa o limite de tamanho especifiado no HTML';
  $_arq['erros'][3] = 'O upload do arquivo foi feito parcialmente';
  $_arq['erros'][4] = 'Não foi feito o upload do arquivo';

  if (@$_FILES['arquivo']['error'] != 0) {	
    die("Não foi possível fazer o upload, erro:" . $_arq['erros'][$_FILES['arquivo']['error']]);
    exit;
  }

  @$extensao = strtolower(end(explode('.', $_FILES['arquivo']['name'])));
  if (array_search($extensao, $_arq['extensoes']) === false) {
    echo "Por favor, envie arquivos com as seguintes extensões: jpg, png, xlsx, docx, txt, mp3 ou mp4";
    exit;
  }

  if (@$_arq['tamanho'] < @$_FILES['arquivo']['size']) {
    echo "O arquivo enviado é muito grande, envie arquivos de até 1000Mb.";
    exit;
  }

  if ($_arq['renomeia'] == true) {
    
    $arq = time().'.pdf';

  } else {
  
    $arq = $_FILES['arquivo']['name'];
  }

  if ((move_uploaded_file(@$_FILES['arquivo']['tmp_name'], $_arq['pasta'] . $arq)) && 
    (move_uploaded_file(@$_FILES['imagem']['tmp_name'], $_img['pasta'] . $img)) && 
    (isset($_POST['nome_prod']))){

  //Enviar uma query
    $cad = "INSERT INTO produtos (nome_prod,preco,imagem,descricao,id_categoria,arquivo)  VALUES ('$fild_nome','$preco','$img','$desc','$idcat','$arq')";
    echo $cad;
    $cadastraimg=mysqli_query($conexao, $cad);
    mysqli_close($conexao);
    echo "<script language='javascript' type='text/javascript'>
            alert('PRODUTO CADASTRADO COM SUCESSO');window.location.href='admin_produto.php';
          </script>"; 
    echo "Cadastro efetuado com sucesso!";
  } else {
    echo "Não foi possível enviar o arquivo, tente novamente";
  }
?>
