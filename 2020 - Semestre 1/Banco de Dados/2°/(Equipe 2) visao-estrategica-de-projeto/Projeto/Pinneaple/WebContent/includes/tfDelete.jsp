<%@page import="java.sql.SQLException"%>
<%@page import="br.com.pineapple.domain.TarFunc"%>
<%@page import="br.com.pineapple.dao.TarFuncDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
	TarFuncDAO tfdao = new TarFuncDAO();
	String nome_tarefa = request.getParameter("d");
	String cpf = request.getParameter("d2"); 

	TarFunc t = new TarFunc();
	t.setNome_tarefa(nome_tarefa);
	t.setCpf(cpf);

	try{
		tfdao.excluir(t);
		}catch(SQLException ex){
			ex.printStackTrace();
			ex.getMessage();
		}
	
	%>
	<c:redirect url="../index.jsp#t4"/>
	
</html>