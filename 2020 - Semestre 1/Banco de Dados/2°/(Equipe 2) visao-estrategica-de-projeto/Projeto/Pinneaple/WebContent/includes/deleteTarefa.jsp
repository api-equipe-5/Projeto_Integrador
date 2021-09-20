<%@page import="java.sql.SQLException"%>
<%@page import="br.com.pineapple.domain.Tarefa"%>
<%@page import="br.com.pineapple.dao.TarefaDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<%
	TarefaDAO tdao = new TarefaDAO();
	String nome_tarefa = request.getParameter("d");

	Tarefa t1 = new Tarefa();
	t1.setNome_tarefa(nome_tarefa);

	tdao.excluir(t1);
	
	
	%>
	<c:redirect url="../index.jsp#t4"/>
	
</html>