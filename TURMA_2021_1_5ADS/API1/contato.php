<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, inicial-scale=1.0">
    <title>Contato</title>
    <link rel="stylesheet" type="text/css" href="./css/style_contato.css">
	<link rel="icon" href="favicon.ico">
	<style type="text/css"> 
    a:link 
    { 
     text-decoration:none; 
    } 
    </style>
</head>
<body>
<!--Cabeçalho feito na página header.php e incluso nas demais página para simplificar o código-->
<?php
	include("_header.php");
	
	use PHPMailer\PHPMailer\PHPMailer;
    use PHPMailer\PHPMailer\SMTP;
    use PHPMailer\PHPMailer\Exception;
	
	require './phpmailer/lib/vendor/autoload.php';
	
	include_once './phpmailer/conexao.php';
?> 
    <link rel="stylesheet" href="style_contato.css" media="all" />
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
   <hr>
   <h2>Contato</h2>
    <section class="contatoform">
      <h3>Formulário de contato</h3>

<?php
    $data = filter_input_array(INPUT_POST,FILTER_DEFAULT);
    if (!empty($data['submit'])){
	
	$query_msg = "INSERT INTO contato_msg (nome, email, mensagem) VALUES (:nome, :email, :mensagem)";
	$add_msg = $conn->prepare($query_msg);
	
	$add_msg -> bindParam(':nome',$data['nome'], PDO::PARAM_STR);
	$add_msg -> bindParam(':email',$data['email'], PDO::PARAM_STR);
	$add_msg -> bindParam(':mensagem',$data['mensagem'], PDO::PARAM_STR);
	
	$add_msg->execute();
	
	if ($add_msg->rowCount()) {
                $mail = new PHPMailer(true);
                try {
                    $mail->CharSet = 'UTF-8';
                    $mail->isSMTP();
                    $mail->Host = 'smtp.gmail.com';
                    $mail->SMTPAuth = true;
                    $mail->Username = 'grupo6api@gmail.com';
                    $mail->Password = '@goravai2021';
                    $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS;
                    $mail->Port = 587;

                    //Enviar e-mail para a empresa
                    $mail->setFrom('grupo6api@gmail.com', 'Contato');
                    $mail->addAddress('grupo6api@gmail.com');

                    $mail->isHTML(true);
                    $mail->Subject = 'Contato';
                    $mail->Body = "<big>Olá! Entraram em contato conosco!</big><br> <br><strong><big>Nome: </strong></big>" . $data['nome'] . "<br><br><strong><big>E-mail: </big></strong>" . $data['email'] . "<br><br><strong><big> Mensagem: </strong></big>" . $data['mensagem'];
                    

                    $mail->send();
                    unset($data);
                    echo "Mensagem enviada com sucesso!<br>";                    
                } catch (Exception $e) {
                    echo "Erro: Mensagem não enviada!<br>";
                }
            } else {
                echo "Erro: Mensagem não enviada!<br>";
            }
        }
        ?>

<!--	if($add_msg->rowCount()){
		echo "Mensagem enviada com sucesso!";
	}else{
		echo "Erro: Mensagem não enviada!";
	}
	
	} #TESTE
?>-->
     <style>
 h2 {
	 font-family: 'Open Sans', sans-serif;
	 text-align:center;
 } 
 textarea {
	 font-family:'Open Sans', sans-serif;
 }
     </style>

      <form name="add_msg" action="" method="POST"  class="form">
      <p class="nome">
        <label for="nome">Nome</label>
        <input id="nome"  name="nome"   type="text" placeholder="Seu Nome"  />
      </p>
      <p class="email">
        <label  for="email">E-mail</label>
        <input id="email"  name="email"  type="text" placeholder="exemplo@email.com.br" />
      </p>
      <p class="text">
        <label  for="mensagem">Mensagem</label>
        <textarea id="mensagem" name="mensagem" type='text' placeholder="Escreva sua mensagem"/></textarea>
      </p>
      <p class="submit">
        <input type="submit" name="submit" value="Enviar" />
      </p>
      </form>
    </section>
<section id="dados">
<h3>Fale conosco</h3>
   <img src="imagens/phone.png" alt="phone" width="25px"><a class="texto">  Tel: (12) 3966 2823</a><br>
   <br>
   <img src="imagens/map.png" alt="map" width="25px"> <a class="texto">  Rua Carlos Nunes de Paula, 1172 - Jardim Imperial <br>  São José dos Campos</a><br>
   <br>
   <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d14660.29387667944!2d-45.8999728!3d-23.27678!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xd429ce060f725c70!2sCECOI%20V%C3%B3%20Maria%20F%C3%A9lix!5e0!3m2!1spt-BR!2sbr!4v1622934169569!5m2!1spt-BR!2sbr" width="400" height="300" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
</section>

	<hr width="100%">
    <section id="contato">
        <br>
        <a class="face" href="https://www.facebook.com/cecoivomariafelix" target="_blank"><img src="imagens\facebook.png" width="50px"></a>
        <a class="youtube" href="https://www.youtube.com/channel/UCB-99VOkEEM07VF4VVsP7_g" target="_blank"><img src="imagens\youtube.png" width="50px"></a>
    </section>
    <hr width="100%">
<footer><strong>Desenvolvido por Grupo Rocket 2021</strong></footer>

</body>
</html>
