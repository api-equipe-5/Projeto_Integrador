<%@page import="br.com.pineapple.dao.TarProjDAO"%>
<%@page import="br.com.pineapple.domain.TarProj"%>
<%@page import="java.sql.SQLException"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<%
	TarProjDAO pfdao = new TarProjDAO();
	String projeto = request.getParameter("d");
	String tarefa = request.getParameter("d2"); 
	
	TarProj tp = new TarProj();
	tp.setNome_projeto(projeto);
	tp.setNome_tarefa(tarefa);
	
	try{
	pfdao.excluir(tp);
	}catch(SQLException ex){
		
	}
	%>
	<c:redirect url="../index.jsp#t3"/>
</html>