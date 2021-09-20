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
    <style>
      /* CSS reset */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box; /*para os inputs respeitarem a largura*/
  font-family: Helvetica, sans-serif;
  color: #323232;
  border: none;
}

body{
  margin:5px;
  padding-top:2vh; /*basicamente 5% do topo - view height*/
  background-image:url('./imagem.png') ;
  background-size: cover; /*ocupar a tela inteira, centralizada*/
}

a{
  text-decoration: none;
}

/* esconde as ancoras da tela */
a.links{
  display: none;
}

/* formatando o cabeçalho dos formulários */
h1{
  font-size: 36px;
  color: rgb(0, 0, 0);
  font-family: Helvetica,sans-serif;
  font-weight: bold;
  text-align: center;

}
h1:after{
  content: ' ';
  display: block;
  width: 100%;
  height: 2px;
  margin-top: 10px;
  background: -webkit-linear-gradient(left, rgba(147,184,189,0) 0%,rgba(147,184,189,0.8) 20%,rgba(147,184,189,1) 53%,rgba(147,184,189,0.8) 79%,rgba(147,184,189,0) 100%); 
  background: linear-gradient(left, rgba(147,184,189,0) 0%,rgba(147,184,189,0.8) 20%,rgba(147,184,189,1) 53%,rgba(147,184,189,0.8) 79%,rgba(147,184,189,0) 100%); 
}

p{

  position:relative;
}

p:first-child{
  margin: 0px;
}

input:not([type="checkbox"]){
    font-family: Helvetica,sans-serif;
    width: 95%;
    margin-top: 1px;
    padding: 10px;
    transition: all 0.2s linear;
    margin-bottom: 22px;
    border-bottom: 2px solid #323232
}

/* form */
#main-container {
  width: 50%;
  height: 100%;
  margin-left: 25%;
  margin-right: auto;
  background-color: #FFF;
  border-radius: 10px;
  padding-top: 20px;
  padding-right: 20px;
  padding-left: 35px;
  position:sticky;
}

#main-container h1 {
  text-align: center;
  font-size: 1.6rem;
}


form {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between; /*criar espaço autom qdo dois input estiverem juntos*/
}

.full-box {
  flex: 1 1 100%;
  position: relative;

}

.half-box {
  flex: 1 1 45%;
  position: relative;
}

.middle-box {
  flex: 1 1 50%;
  position: absolute;
  width: 95%;
  margin-top: 65%;
}


input:focus[type="submit"] {
  display:none;
}

input[type="submit"] {
  background-color: #3579a0;
  color: #FFF;
  padding: 8px 5px;
  color: #fff;
  font-size: 20px;  
  border: 1px solid #fff; 
  margin-bottom: 10px;  
  text-shadow: 0 1px 1px #333;
  -webkit-border-radius: 5px;
  border-radius: 20px;
}

input[type="submit"]:hover{
  background: #1f2792;
}

input, label[type="fullbox"] {
  width: 100%; 
}

label {
  font-weight: bold;
  font-size: .8rem;
}

input {
  border-bottom: 2px solid #323232;
  padding: 15px;
  font-size: .9rem;
  margin-bottom: 40px;
}

input:focus /*quando vc clica no input*/{
  border-color: #3579a0;
  outline: none;
}


input:focus [type="lastname"] /*quando vc clica no input*/{
  outline: none;
display: block;
}


input[type="checkbox"] {
  background-color: #3579a0;
  color: #FFF;
  border: none;
  cursor: pointer;
  margin-bottom: 10px;
  margin-left: 80px;
  text-align: right;
  padding: 0px;
  width: 5%;
  flex-wrap: none;
  margin-left: -2%;
  position: relative;
}

input:focus[type="checkbox"] {
  display:inline-block;
}

a {
  color: #3579a0;
  text-decoration: none;
}

a.links{
  display: none;
}

/*marcando os links para mudar de um formulário para outro */
.link{
  position: right;
  margin-left: 44%;
  margin-top: 50px;
  background: #ffffff;
  color: #7f7c7c;
  padding: 17px 30px 20px 30px;
  font-size: 16px;
  border-top: 1px solid #ffffff;
  -webkit-border-radius: 0 0  5px 5px;
  border-radius: 0 0  5px 5px;
}

.link a {
  font-weight: bold;
  background: #f7f8f1;
  padding: 6px;
  color: #3579a0;
  margin-left: 10px;
  border: 1px solid #7f7c7c;

  -webkit-border-radius: 4px;
  border-radius: 4px;  
}
.link a:hover {
  color: #1f2792;
  background: #f7f7f7;
  border: 1px solid #1f2792;
}

.spacing{
  height: 10%;
  width: 10%;
}

/*js*/

#agreement {
  margin-right: 5px;
}

#agreement, #agreement-label {
  display: inline-block;
  width: auto;
}

.error-validation {
  color: #ff1a1a;
  position: absolute;
  top: 57px;
  font-size: 12px;
}

.template {
  display: none;
}

    </style>
</head>
<body>
  <div id="main-container">
    <a href="index.html"><img src="x.png" width="10" height="10"></a>
    <h1>Cadastre-se como Voluntário de Apoio</h1><BR>
    <form id="register-form" method="POST" action="salva_apoio.php">
      <div class="full-box">
        <label for="name">Nome</label>
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
        <input type="password" name="passconfirmation" id="passwordconfirmation" required>
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
    

