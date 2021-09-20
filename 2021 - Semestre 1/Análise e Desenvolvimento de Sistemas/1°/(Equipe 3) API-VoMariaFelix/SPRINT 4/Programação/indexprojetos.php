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
  /* form login*/
  #main-container2 {
    width: 50%;
    height: 66%;
    margin-left: 25%;
    margin-top: 70px;
    margin-right: auto;
    background-color: #FFF;
    border-radius: 10px;
    padding-top: 20px;
    padding-right: 20px;
    padding-left: 35px;
    position: fixed;
  }
  
  #main-container2 h1 {
    text-align: center;
    font-size: 1.8rem;
  }
  /* form */
  #main-container {
    width: 50%;
    height: 62%;
    margin-top: 90px;
    margin-left: 25%;
    margin-right: auto;
    background-color: #FFF;
    border-radius: 10px;
    padding-top: 20px;
    padding-right: 20px;
    padding-left: 35px;
    position: fixed;
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

  .half-box2 {
    flex: 1 1 45%;
    position: relative;
    margin-top: -1%;
  }
  
  .middle-box {
    flex: 1 1 50%;
    position: absolute;
    width: 95%;
    margin-top: 35%;
  }
  
  .middle-box2 {
    flex: 1 1 50%;
    position: absolute;
    width: 100%;
    margin-top: 3%;
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
    <h1>Cadastrar Projeto</h1><BR>
    <form id="register-form" method = "POST" action="salva_projetos.php">
      <div class="half-box spacing">
        <label for="objetivos">Objetivos</label>
        <input type="text" name="objetivos" id="objetivos" placeholder="Ex.: aumentar o monitoramento, trazendo mais confiança para a ONG e conforto para os pais" required>
      </div>
    <div class="half-box spacing">
      <label for="diferencial">Diferencial</label>
        <input type="text" name="diferencial" id="diferencial" placeholder="Ex.: aumentar a segurança das crianças" required >
    </div>
    <div class="full-box">
      <label for="características">Características</label>
      <input type="text" name="características" id="características" placeholder="Ex.: adicionaremos câmeras por toda a escola, e traremos novos seguranças" required>
    </div>
    <div class="half-box">
      <label for="envolvidos">Envolvidos</label>
      <input type="text" name="envolvidos" id="envolvidos" placeholder="Ex.: os seguranças da Costa & Souza" required>
    </div>
    <div class="half-box2 spacing">
        <label for="anexo">Documento/Projeto</label>
        <input type="file" name="anexo" id="anexo">
    </div>
    <div class="full-box">
      <label for="email">E-mail para contato</label>
      <input type="email" name="email" id="email" placeholder="Ex: jose.ferreira@gmail.com" required>
    </div>
    <div class="middle-box">
      <br><br>
      <input id="btn-submit" type="submit" value="Cadastrar">
    </div><br><br>
      </form>
      </body>
</html>