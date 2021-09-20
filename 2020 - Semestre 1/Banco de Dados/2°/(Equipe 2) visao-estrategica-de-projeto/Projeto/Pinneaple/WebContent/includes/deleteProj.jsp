
<%@page import="br.com.pineapple.domain.Projeto"%>
<%@page import="br.com.pineapple.dao.ProjetoDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<%
	ProjetoDAO pdao = new ProjetoDAO();
	String nome = request.getParameter("d");

	Projeto p = new Projeto();
	p.setNome(nome);

	pdao.excluir(p);
	
	%>
	<c:redirect url="../index.jsp#t3"/>
</html>