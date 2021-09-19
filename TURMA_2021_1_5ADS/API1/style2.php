<?php
header("Content-type: text/css");
?>

@import url('https://fonts.googleapis.com/css2?family=Pacifico&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');

header {
    background-image:url(https://img.wallpapersafari.com/desktop/1680/1050/14/18/jXrad2.jpg);
    background-attachment: fixed;
    background-size: cover;
    padding:0pt;
    margin:0%;
}

ul {
    padding:10pt;
    margin:10pt;
    list-style:none;
    text-align:end;
}

ul li { 
    display: inline; 
}

ul li a {
    padding: 2px 10px;
    color:white;
    font-family: 'Open Sans', sans-serif;
    font-size:16px;
}

h1 {
    font-family: 'Pacifico', cursive;
    font-size:69px;
    font-weight: 100;
    font-stretch: expanded;
    text-align:center;
    color:rgb(243, 243, 217) ;
}

h2 {
    font-family: 'Open Sans', sans-serif;
    font-size:42px;
    font-weight:lighter;
    font-stretch: expanded;
    text-align:center;
    color:black ;
	margin-left: 40pt;
	margin-right:50pt;
}


#subtitulo{
    font-family: sans-serif;
    color: rgb(112, 99, 99);
    margin-left: 40pt;
	margin-right:50pt;
}

fieldset{
    margin-left: 40pt;
	margin-right:30pt;
	border:0;
    font-family: sans-serif;
}


input, select, textarea, button{
    border-radius: 5px;
}

.campo{
    margin-bottom: 5pt;
}

.campo label{
    margin-bottom: 5pt;
    color: rgb(48, 47, 47);
	
}

.campo #nome{
	width:300px;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;
}

.campo #certidao{
	width:300px;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;

}

.campo #endereço{
	width:300px;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;

}


.campo #descreva{
	width:300px;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;
}

.campo #nomeresp{
	width:300px;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;
}

.campo #escreva{
	width:300px;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;
}

.campo #email{
	width:350px;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;
	
}

.campo #cpf{
	width:150px;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;
	
}

.campo #telefone{
	width:150px;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;
	
}

.campo select{
	width:150px;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;
	
}


.campo #date,#date2{
    width:140px;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;
}

.campo #profissao{
	width:300px;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;
}

.campo #especializacao{
	width:80%;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;
}

.campo #projdescricao{
	width:80%;
    height:fit-content;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;
}

.campo #horario{
	width:300px;
	padding: 0.2em;
    border: 1px solid rgb(48, 47, 47);
    box-shadow: 1px 1px 1px rgb(99, 41, 46);
	margin-bottom: 4pt;
}

.campo select option{
    padding-right: 1em;
}

.campo input:focus, .campo select:focus{
    background: rgb(185, 220, 236);
}

.botao{
    font-size: 1.2em;
    background: rgb(215, 102, 109);
    border: 0;
    margin-bottom: 1em;
    color: rgb(2, 34, 44);
    padding: 0.2em 0.6em;
    box-shadow: rgb(168, 173, 97);
    text-shadow: 1px 1px 1px rgb(96, 105, 26);
    position: static;
    top: 72%;
    left: 47.5%;
    margin-right: 50pt;
	margin-left: 65pt;
	margin-top: 1%;
   
}

.botao:hover{
    background: rgb(153, 70, 75);
    box-shadow: rgb(168, 173, 97);
    text-shadow: none;
}

.botao, select{
    cursor: pointer;

}

.botao, #enviar{
    cursor: pointer;
	font-size: 1.1em;
	background-color:rgb(215, 102, 109);
    text-align: center;
	color: white;
	text-shadow: none;
	font-weight:bold;

	margin-right: 50pt;
	margin-left: 40pt;
}

form{
    margin-top: 2%;
	margin-bottom: 3,5%;
}

p {
    font-family: 'Open Sans', sans-serif;
    font-size:18px;
}

#contato {
    margin-right: 50pt;
    padding:10pt;
    text-align: center;
}

a.face {
    padding-right: 50pt;
}

a.youtube {
    padding-left: 50pt;
}