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
                <li><a href="indexapoio.php">Seja doador</a></li>
                </ul>
		    <li><a href="indexprojetospag.html">Projetos</a></li>
		    <li><a href="indexlogin.html">Login</a></li>
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
                                        &nbsp;
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
                <div class="rodape">
                  <p>
                    Endereço: R. Carlos Nunes de Paula, 1172 - Jardim Colonial, São José dos Campos - SP, 12234-000
                  </p>
                  Telefone: (12) 3966-2823
                </div>
                  <br><br><br>
        </div>
    </div>     
    <div id="chat">
        <img src="chat.png" width="95" height="70">
    </div>
</body>
</html>