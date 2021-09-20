<%@page import="java.sql.SQLException"%>
<%@page import="br.com.pineapple.domain.ProjFunc"%>
<%@page import="br.com.pineapple.dao.ProjFuncDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<%
	ProjFuncDAO pfdao = new ProjFuncDAO();
	String nome = request.getParameter("d");
	String cpf = request.getParameter("d2"); 
	
	ProjFunc p = new ProjFunc();
	p.setNome(nome);
	p.setCpf(cpf);
	
	try{
	pfdao.excluir(p);
	}catch(SQLException ex){
		
	}
	%>
	<c:redirect url="../index.jsp#t3"/>
</html>