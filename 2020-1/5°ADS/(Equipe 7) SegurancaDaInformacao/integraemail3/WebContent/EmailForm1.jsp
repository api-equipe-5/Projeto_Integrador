<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

*{
	margin:0;
	padding:0;
}

#bg{
	width:100%;
	height:100%;
	top:0;
	left:0;
	background-color: rgba(0,0,0,.8);
	position: fixed;
	display:none;
}

#bg:target{
	display: block;
}

#bg:target ~ .box{
	top:150px;
	transition: all .3s;
	transition-delay: .2s;
}

.box{
	width: 720px;
	height:405px;
	position: absolute;
	margin-left: -360px;
	left:50%;
	background-image: url("assets/grey_back.jpg");
	top:-410px;
}

#im{
	top:3;
}

#message{
	
	color: black;
	font-family: 'Arial';
	text-decoration: none;
	font-size: 20px;	
}

.bt {
  background-color: #555555;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}

#close{
	color: #fff;
	font-family: 'Arial';
	text-decoration: none;
	font-size: 20px;
	position: absolute;
	background-color: red;
	width:7%;
	height:7%;
	text-align: center;
	right: 0;
	top:0;
}

#close: hover{
	opacity: .6;
}

</style>
</head>
<body>

<a href="#bg">Pop-Up</a>

<div id="bg"> </div>
<div class="box">
	<br/>
	<div id="message" align="center"> <p>As politicas de uso foram atualizadas.</p>
	<div id="im" align="center" ><img src="assets/company.png" width="243px" height="200px"></div>
	<a href="" id="close">X</a>

	
	<form action="SendMailAttachServlet" enctype="multipart/form-data"method="post" id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form" class="validate" target="_blank" novalidate>
    	<div id="mc_embed_signup_scroll">
			<input type="text" value="" name="recipient" class="email" id="mce-EMAIL" placeholder="email address" required>
		<div style="position: absolute; left: -5000px;" aria-hidden="true">
			<input type="text" name="b_d2cbde283d6642b5a7389bae1_346c16d244" tabindex="-1" value="">
		</div>
		
		<br><br/>
		<input type="checkbox" name="Pop_UP" id="popupTermos" value="UserAccept">
		<label for='popupTermos'>li e concordo com as novas políticas de uso de dados</label>
		<br><br/>

		<input type="submit" value="Confirmar" name="subscribe" id="mc-embedded-subscribe" class="bt">

    </div>
	</form>
	</div>
</div>

</body>
</html>