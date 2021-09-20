<%@page import="java.sql.SQLException"%>
<%@page import="br.com.pineapple.domain.Funcionario"%>
<%@page import="br.com.pineapple.dao.FuncionarioDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<%
	FuncionarioDAO fdao = new FuncionarioDAO();
	String cpf = request.getParameter("d");

	Funcionario f1 = new Funcionario();
	f1.setCpf(cpf);

	fdao.excluir(f1);
	
	
	%>
	<c:redirect url="../index.jsp#t2"/>
	
</html>