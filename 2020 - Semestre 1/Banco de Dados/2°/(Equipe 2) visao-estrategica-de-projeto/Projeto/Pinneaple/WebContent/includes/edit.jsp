<%@page import="java.sql.SQLException"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="../assets/css/styles.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<jsp:useBean id="fdao" class="br.com.pineapple.dao.FuncionarioDAO"/>
	
	<%@ page import ="java.util.ArrayList"%>
	<%@ page import ="java.util.List"%>
	<%@ page import ="br.com.pineapple.domain.Funcionario"%>
</head>
<body style="background-color: rgb(255,99,71);">
<%
	String cpf = request.getParameter("u");

	Funcionario f1 = new Funcionario();
	f1.setCpf(cpf);

	Funcionario f2 = fdao.consultarCPF(f1);
	
	String[] splitFuncionario = f2.toString().split(" ");

%>
<div class="conteudo">
<form action = "../FuncionarioUpdate" method="post" class="w3-container w3-card-4 w3-light-grey">
	<h3>Editar funcionario</h3>
	<p>  
	<label><b>CPF</b></label>
	 <input type="text" class="w3-input" id="cpf" name="cpf" value=<%= splitFuncionario[0] %>><br>
	 <label><b>Nome</b></label>
	 <input type="text" class="w3-input" id="nome" name="nome" value=<%= splitFuncionario[1] %>><br>
	 <label><b>E-mail</b></label>
	 <input type="text" class="w3-input" id="email" name="email" value=<%= splitFuncionario[2] %>><br>
	 
	 <input type="submit" class="cool-button" value="Atualizar !">
 </form>
 </div>
</body>
</html>