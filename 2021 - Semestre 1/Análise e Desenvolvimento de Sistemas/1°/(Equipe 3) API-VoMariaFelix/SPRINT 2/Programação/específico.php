<?php

?>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="./foto.png" type="image/png">
    <title>Vó Maria Félix</title>
    <link rel="stylesheet" href="especifico.css">
</head>
<body>
  <div id="main-container">
    <a href="index.html"><img src="x.png" width="10" height="10"></a>
    <h1>Cadastre-se como Voluntário Especifíco</h1><BR>
    <form id="register-form" method = "POST" action="salva_especifico.php">
      <div class="full-box">
        <label for="nome">Nome</label>
        <input type="text" name="nome" id="nome" placeholder="Digite seu nome completo" required>
      </div>
      <div class="full-box">
        <label for="endereço">Endereço</label>
        <input type="text" name="endereço" id="endereço" placeholder="Digite seu endereço" required>
      </div>
    <div class="half-box spacing">
      <label for="email">E-mail</label>
      <input type="email" name="email" id="email" placeholder="Digite seu e-mail" required>
    </div>
    <div class="half-box">
        <label for="cpf">Número do CPF</label>
        <input type="text" name="cpf" id="cpf" placeholder="Ex.: 000.000.000-00" required>
      </div>
      <div class="half-box spacing">
          <label>Currículo <input type="file" name="curriculo" multiple="multiple"></label>
      </div>
      <div class="half-box">
            <label>Certificado <input type="file" name="certificado" multiple="multiple"></label>
        </div>
      <div class="full-box">
      <label for="experiencia">Experiências</label>
      <input type="text" name="experiencia" id="experiencia" placeholder="Digite suas experiencias" required>
    </div>
      <div class="full-box">
        <label for="caracteristicas">Caracteristicas que podem ajudar</label>
        <input type="text" name="caracteristicas" id="caracteristicas" placeholder="Digite suas caracteristicas" required>
      </div>
      <div class="half-box spacing">
        <label for="caracteristicas">Objetivos</label>
        <input type="text" name="objetivos" id="objetivos" placeholder="Digite seus objetivos com a ONG" required>
      </div>
      <div class="half-box">
        <label for="hora">Horários disponíveis</label>
        <input type="text" name="hora" id="hora" placeholder="Ex.: 00:00 até 00:00" required>
      </div>
      <div class="half-box spacing">
        <label for="password">Senha</label>
        <input type="password" name="password" id="password" placeholder="Digite sua senha" required>
      </div>
      <div class="half-box">
        <label for="passconfirmation">Confirmação de senha</label>
        <input type="password" name="passconfirmation" id="passwordconfirmation" placeholder="Digite novamente sua senha" required>
      </div><br><br>
      <div class="full-box">&nbsp;
        <input type="checkbox">
        <label for="checkbox" >Eu li e aceito os <a href="#">termos de uso</a></label> <br<br><br><br>
    </div>
    <div class="middle-box">
      <input id="btn-submit" type="submit" value="Registrar">
    </div><br><br>
      <p class="link">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          Já tem uma conta?
          <a href="indexlogin.html">&nbsp;&nbsp;Logar&nbsp;&nbsp;</a>
      </p>
      </form>
      </body>
</html>
    
