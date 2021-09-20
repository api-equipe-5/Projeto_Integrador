<?php

?>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="style.css" rel="stylesheet">
    <link rel="stylesheet" href="doacao.css">
    <link rel="icon" href="./foto.png" type="image/png">
    <style>
    #comeco{
    background-color: white;
    width: 85%;
    height: 100%; 
    position: absolute;
	left: 100px;
    top: 180px;
}

.doacao{
    background-color: #fff;
    width: 100%;
    float: right;
    color: #293241;
    margin-left:0px;
    padding-top: 0px;
    padding-right: 0px;
    height: 20%;
}

.local{
  margin-top: 30px;
  width: 100%; 
  background-color: #fff;
  height: 390px;
  position: absolute;
  float: left;
}

.pix{
    margin-left: 90px;
    width: 40%; 
    height: 390px;
    position: relative;
    float: left;
    padding-left: 5px;
    background-color: #fff;
    text-align: justify;;
    color: rgb(0, 0, 0);
    font-family: Helvetica,sans-serif;
    font-size: 16px;
}

.cartao{
    width: 40%; 
    background-color: #fff;
    height: 53%;
    position: right;
    float: right;
    text-align: justify;
    padding: 20px;
    padding-left: 30px;
    color: rgb(0, 0, 0);
    font-family: Helvetica,sans-serif;
    font-size: 16px;
}

.doadores{
    background: url('azul.png');
    width: 100%;
    height: 600px;
    color: #293241;
    margin-left:0px;
    padding-top: 0px;
    padding-right: 0px;
}


#caixa3{
  position: relative;
  width: 280px;
  height: 330px;
  border: 4px solid black;
  margin-left: 10%;
  bottom: -100px; 
  margin-top: -50px;
}

#caixa4{
  position: relative;
  width: 280px;
  height: 330px;
  margin-left: 40%;
  border: 4px solid black;
  bottom: -100px; 
  margin-top: -338px;
}

#caixa5{
  position: relative;
  width: 280px;
  height: 330px;
  border: 4px solid black;
  margin-left: 70%;
  bottom: -100px; 
  margin-top: -338px;
}

h4{
    font-size: 36px;
    color: rgb(0, 0, 0);
    font-family: Helvetica,sans-serif;
    font-weight: bold;
    text-align: center;
    margin-bottom: 0px;
  }

h3{
    font-size: 22px;
    color: #293241;
    font-family: Helvetica,sans-serif;
    font-weight: bold;
    text-align: center;
  }

ol{
    text-align: center;
    display: inline-block;
    margin: 0;
}

.menu2{
    margin-top: 40px;
    margin-bottom: 60px;
    margin-right: 80px;
    list-style: none;
    text-align: center;
    height: 75px;
    border: 2px solid #000; 
    height: 55px;
    align-items: center;
    width: 84%;
    margin-left: 90px;
}

h5{
    text-decoration: none;
    color: #000;
    font-size: 22px;
    font-family: Helvetica, sans-serif;
    margin-top: 0px;
    padding: 0px;
    margin-left: 50px;
    margin-right: 50px;
}

h5:hover {
    color: tomato;
  }

h6{
    text-decoration: none;
    color: #000;
    font-size: 17px;
    font-family: Helvetica,sans-serif;
    text-align: center;
    padding: 0;
    margin: 0;
}

.texto{
    color: #000;
    margin-top: 38%;
    font-size: 28px;
    font-family: Helvetica,sans-serif;
    text-align: center;
}

.odoacao{
    background: url('verde.png');
    width: 100%;
    float: right;
    color: #293241;
    margin-left:0px;
    padding-top: 0px;
    padding-right: 0px;
    height: 770px;
    margin-bottom: 60px;
}

.imagem{
    padding-left: 30px;
    padding-right: 30px;
    padding-top: 30px;
    padding-bottom: 30px;
}

.texto6{
    color: tomato;
    font-size: 22px;
    font-family: Helvetica,sans-serif;
    text-align: center;
    margin: 0;
    font-weight: bolder;
    margin-top: 0px;
}

.rodape{
    margin-top: 0px;
}

.maneiras{
    width: 100%; 
    background-color:#95d5b2;
    height: 300px;
    padding: 0;
}

.relatorios1{
    width: 50%; 
    background-color: #000;
    height: 300px;
    float: left;
    position: relative;
}

.relatorios2{
    width: 50%; 
    background: url('verde.png');
    float: right;
    position: relative;
    height: 300px;
}

.relatorio1{
    width: 50%; 
    background: url('verde.png');
    height: 300px;
    float: left;
    position: relative;
}

.relatorio2{
    width: 50%; 
    background: url('verde.png');
    float: right;
    position: relative;
    height: 300px;
}

.texto2{
    text-align: center;
    font-size: 20px;
    font-family: Helvetica,sans-serif;
}
  
  form {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between; /*criar espaço autom qdo dois input estiverem juntos*/
  }

  .full-box {
    flex: 1 1 30%;
  }
  
  .half-box {
    flex: 1 1 50%;
  }

  input:focus[type="submit"] {
    display:none;
  }
  
  input[type="submit"] {
    background-color: #323232;
    color: #FFF;
    padding: 8px 5px;
    color: #fff;
    font-family: Helvetica,sans-serif;
    font-size: 20px;  
    border: 1px solid #fff; 
    margin-bottom: 10px;  
    text-shadow: 0 1px 1px #333;
    -webkit-border-radius: 5px;
    border-radius: 20px;
  }
  
  input[type="submit"]:hover{
    background: tomato;
  }
  
  input, label[type="fullbox"] {
    width: 50%; 
  }
  
  label {
    font-family: Helvetica,sans-serif;
    font-size: 16px;  
  }
  
  input {
    border-bottom: 2px solid #323232;
    font-family: Helvetica,sans-serif;
    font-size: 16px;  
    margin-bottom: 15px;
    border-top: none;
    border-right: none;
    border-left: none;
  }
  
  input:focus /*quando vc clica no input*/{
    border-color: tomato;
    outline: none;
  }
  
  
  input[type="checkbox"] {
    background-color: #323232;
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
  
  .middle-box {
    flex: 1 1 50%;
    margin-left: 25%;
  }

  /* chat */

  
.container2 {
    display: none;
    height: 400;
    width: 23%;
    right: 25px;
    bottom: 20px;
    background-color: rgb(248, 187, 176);
    font-size: 17px;
    position: fixed;
}

.chat2{
    position: fixed;
    right: 10px;
    bottom: 0px;
}

#btn-div{
    background-color: blue; 
    bottom: 0;
    width: 0px;
    height: 0px;
    display: block;
    margin-bottom: 410px;
    margin-left: 100%;
    border-style: none;
    position: fixed;
}

#ok{
    background-color: transparent;
    bottom: 0;
    border-radius: 50%;
    margin-bottom: 1%;
    border-style: none;
    position: fixed;
    width: 40px;
    height: 5%;
    right: 38px;
    display: block;
}


.top{
    height: 50px;
    width: 100%;
    background-color: rgb(241, 119, 98); 
}

.bottom {
    height: 350px;
    width: 100%;
    bottom: 0px;
    background-color:  rgb(248, 187, 176); 
    position: relative;
    float: center;
    font-family: Helvetica, Arial, sans-serif;
    font-size: 16px;
}

.perfil{
    float: left;
    width: 80%;
    position: relative;
    background-color: rgb(241, 119, 98); 
    height: 100%;
}

.sair{
    margin-top: 15px;
    margin-right: 10px;
    float: right;
    width: 10%;
    position: relative;
    background-color: transparent; 
    height: 50%;
    text-align: center;
}

.exit{
    position: fixed;
    right: 36px;
    display: none;
    margin-bottom: auto;
}

.botao2{
    bottom: 0px;
    margin-right: 100%;
}

.foto{
    background-color: tomato;
    border-radius: 50% 50% 50% 50%;
    width: 40px;
    height: 80%;
    margin-left: 11px;
    position: relative;
    float: left;
    margin-top: 2%;
}

.nome {
    position: relative;
    margin-top: 3%;
    font-size: 20px;
    margin-left: 65px;
    background-color: transparent;
    width: 50%;
    height: 30px;
    font-family: Helvetica, Arial, sans-serif;
}

.estado {
    position: relative;
    margin-top: 0%;
    font-size: 13px;
    margin-left: 65px;
    background-color: transparent;
    width: 50%;
    bottom: 8px;
    font-family: Helvetica, Arial, sans-serif;
}


span {
	padding-right: 15px;
	padding-left: 15px;
    margin-top: 4px;
}

.container3 {
	width: 100%;
	height: 100%;
}

.chat {
    position: fixed;
    height: 370px;
    width: 23%;
	display: flex;
	flex-direction: column;
    text-align: left;
	align-items: center;
    margin: 0px;
    font-family: Helvetica, Arial, sans-serif;
    margin-right: 28px;
    bottom: 20px;
} 
 
input[type="submit2"] { 
	border: 0; 
	padding: 15px; 
	width: 90%;
    right: auto;
    margin: 0px;
    margin-bottom: 25px;
    background-color: transparent;
    border-color: transparent;
    font-family: Helvetica, Arial, sans-serif;
    font-size: 16px;
}

input[type="submit2"]:focus { 
	outline: thin dotted;
    outline: 0px auto;
    outline-offset: 0px;
}

.messages {
	display: flex;
	flex-direction: column;
	overflow: scroll;
	height: 100%;
	width: 90%;
	background-color: transparent;
	padding: 15px;
	margin: 0;
    margin-top: 0px;
	border-radius: 10px;
    font-size: 17px;
}

#bot {
	margin-left: auto;
}

#user {
    position: relative;
    align-items: right;
    float: right;
    margin-left: 73%;
}

.bot {
	font-family: Helvetica, Arial, sans-serif;
    position: relative;
    align-items: left;
    float: left;
}

.avatar {
	height: 30px;
}

.response {
	display: flex;
    margin: 0px;
    margin-bottom: 20px;
    margin-top: 14px;
}
    </style>
    <title>Doação</title>
</head>
<body> 
    <div class="header">
        <div class="logo">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <img src="foto.png" width="100" height="70">
        </div>
        <nav class="menu">
        <ul>
            <h1>
            <li><a href="index.html">Home</a></li>
		    <li><a href="sobre.html">Sobre nós</a></li>
	  		<li><a href="#">Ajude</a>
                <ul class="sub">
                <li><a href="indexvolunt.html">Voluntário</a></li>
                <li><a href="doacao.php">Seja doador</a></li>
                </ul>
		    <li><a href="indexprojetospag.html">Projetos</a></li>
		    <li><a href="tipo.html">Cadastros</a></li>
            <li><a href="indexaluno.html">Alunos</a></li>
            </h1></li>
        </ul>
        </nav>
        <div id="comeco">
            <!-- Menu interno -->
            <div class="menu2">
                <ul>
                    <ol><a href="#ndoar"><h5>Doação</h5></a></ol>
                    <ol><a href="#ndoadores"><h5>Doadores</h5></a></ol>
                    <ol><a href="#mdoar"><h5>Mais doações</h5></a></ol>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </ul>
            </div>
            <!-- Doação -->
            <h4><section id = "ndoar">Faça sua doação!</section></h4>
            <div class = "doacao"> 
                 <div class = "local">
                        <div class = "pix">
                            <div class = "texto2">
                            <img src="logo_pix.png" width="250"><br><br> 
                            CNPJ: 00.000.000/0001-00
                            <hr width="300">
                            <br>Banco Itaú 205<br>
                                Agência: 3105<br>
                                Conta Corrente: 132567-5<br>
                                <br>
                                Banco do Brasil 001<br>
                                Agência: 5234-1<br>
                                Conta Corrente: 121235-3<br>
                            </div>
                        </div>
                        <div class = "cartao"><br><br><br>
                            <form id="register-form" method = "POST" action="salva_doacao.php">
                                <div id="main-container">   
                                      <div class="half-box spacing">
                                        <label for="nome_resp">Nome do doador: </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;
                                        <input type="text" name="nome" id="nome_resp" placeholder="Ex. Inês dos Santos">
                                      </div>
                                    <div class="half-box spacing">
                                      <label for="nome">Descrição do doador: </label>&nbsp;&nbsp;
                                        <input type="text" name="descrição" id="Descrição" placeholder="Ex. Sou prefeito de Sanjasé...">
                                    </div>
                                    <div class="half-box">
                                      <label for="comprovante">Anexo do comprovante: </label>
                                      <input type="file" name="comprovante" id="anexo" required>
                                    </div>
                                    <div class="full-box"> 
                                        <label for="nome_resp">Desejo permanecer anônimo:</label>
                                        <input type="text" name="anonimo" placeholder="Sim/Não">
                                    </div>  <br>
                                    <div class="middle-box">
                                        <input id="btn-submit" type="submit" value="Enviar">
                                      </div>
                                    </form>
                            </div>
                    </div>
                </div>
            <br><br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br><br>
            <!-- Doadores -->
            <div class = "doadores"> 
                <h4><section id = "ndoadores">Doadores</h4></section>  
                    <h4><section id = "ndoadores">Alguns de nossos doadores!</section></h4>
                <div id="caixa3">
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <img src="paula.jpeg"
                    height="180px" style="margin: 20px;">
                    <p style="font-size:15px; text-align: center; margin-top: 3px;">
                            <br>
                            Foi um sonho poder contribuir com a ONG e ajudar as crianças.
                            <br>
                        <br>- Paula Santos
                    </p>
                </div>
                <div id="caixa4">
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <img src="pedro.jpeg"
                    height="180px" style="margin: 20px;">
                    <p style="font-size:15px; text-align: center; margin-top: 3px;">
                        <br>
                        É uma alegria imensa saber que fiz parte dessa ação.
                        <br>
                        <br>- Pedro Assis
                    </p>
                </div>
                <div id="caixa5">
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <img src="lizz.jpeg"
                       height="180px" style="margin: 20px">
                     <p style="font-size:15px; text-align: center; margin-top: 3px;">
                        <br>
                        Quando você doa, você leva alegria e esperança aos outros.
                        <br>
                        <br>- Elizabeth Souza
                    </p>
                </div>
            </div>
        <!-- Outras formas de doação -->
        <div class = "odoacao"> 
                <h4><section id = "mdoar">Outras formas de doar!</section></h4><br>
                <div class = "maneiras">
                    <div class = "relatorios1">
                        <div class = "relatorio1">
                            <div class="imagem">
                                <img src="ilustras-doacoes-materiais-Alimentos.PNG" width=78%>
                            </div>
                            <div class = "texto6">
                                Alimentos
                            </div>
                        </div>  
                        <div class = "relatorio2">
                            <div class="imagem">
                                <img src="ilustras-doacoes-materiais_Roupas.PNG" width=76%>
                            </div>
                            <div class = "texto6">
                                Roupas
                            </div>
                        </div> 
                    </div>  
                    <div class = "relatorios2">
                        <div class = "relatorio1">
                            <div class="imagem">
                                <img src="ilustras-doacoes-materiais-Brinquedos.PNG" width=76%>
                            </div>
                            <div class = "texto6">
                                Brinquedos
                            </div>
                        </div>  
                        <div class = "relatorio2">
                            <div class="imagem">
                                <img src="ilustras-doacoes-materiais-Livros.PNG" width=78%>
                            </div>
                            <div class = "texto6">
                                Livros
                            </div>
                        </div> 
                    </div>  
                </div>   
                <div class = "maneiras">
                    <div class = "relatorios1">
                        <div class = "relatorio1">
                            <div class="imagem">
                                <img src="ilustras-doacoes-materiais-ProdutosLimpeza.PNG" width=85% height=100%>
                            </div>
                            <div class = "texto6">
                                Produtos de limpeza
                            </div>
                        </div>  
                        <div class = "relatorio2">
                            <div class="imagem">
                                <img src="ilustras-doacoes-materiais-Fraldas.PNG" width=85%>
                            </div>
                            <div class = "texto6">
                                &nbsp;&nbsp;Fraldas
                            </div>
                        </div> 
                    </div>  
                    <div class = "relatorios2">
                        <div class = "relatorio1">
                            <div class="imagem">
                                <img src="ilustras-doacoes-materiais-Moveis.PNG" width=85% height=100%>
                            </div>
                            <div class = "texto6">
                                &nbsp;&nbsp;Móveis
                            </div>
                        </div>  
                        <div class = "relatorio2">
                            <div class="imagem">
                                <img src="ilustras-doacoes-materiais-ProdutosHigiene.PNG" width=85%>
                            </div>
                            <div class = "texto6">
                                Produtos de higiene 
                            </div>
                        </div> 
                    </div>  
                </div>  
            </div>
            <!-- rodapé -->
            <div class="rodape"><br><br>
                Endereço: R. Carlos Nunes de Paula, 1172 - Jardim ColonialSão José dos Campos - SP, 12234-000
                <br><br> contatovomariafelix@gmail.com
                <br><br>
                Telefone: (12) 3966-2823
                <br><br><br>
        </div>
    </div>     
    <div class="container2">
        <div class="top">
            <div class="perfil">
                <div class="foto">
                    <img src="ilustras-chatbot.png" height="40">                       
                 </div>
                 <div class="nome">
                    Atendente
                </div>
                <div class="estado">
                    Online
                </div>
            </div>
            <div class="sair">
            </div>
        </div>
        <div class="bottom">
        <div id="container3" class="container3">
            <div id="chat" class="chat">
                <div id="messages" class="messages"></div>
                <input id="input" type="submit2" placeholder="Envie uma mensagem..." autocomplete="off" autofocus="false" />
            </div>
            <button id="ok" class="ok">
                <div class="botao2">
                    <img src="seta.png" width="40" height="40">
                </div>
            </button>
        </div>
    </div>
    </div>
    <button id='btn-div'>
        <div class="chat2">
            <img src="chat.png" width="108" height="75">
        </div>
        <div class="exit">
            <img src="sair2.png" width="35" height="35">
        </div>
    </button>
<script type="text/javascript" src="chat.js"></script>
<script type="text/javascript" src="index.js" ></script>
<script type="text/javascript" src="constants.js" ></script>
<script type="text/javascript" src="speech.js" ></script>
</body>
</html>