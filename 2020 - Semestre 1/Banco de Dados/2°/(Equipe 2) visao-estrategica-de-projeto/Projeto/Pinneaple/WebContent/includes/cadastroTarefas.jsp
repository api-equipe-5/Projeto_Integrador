<html>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<jsp:useBean id="tdao" class="br.com.pineapple.dao.TarefaDAO"/>
	<jsp:useBean id="pdao2" class="br.com.pineapple.dao.ProjetoDAO"/>
	
	<%@ page import ="java.util.ArrayList"%>
	<%@ page import ="java.util.List"%>
	<%@ page import ="br.com.pineapple.domain.Tarefa"%>
	<%@ page import ="br.com.pineapple.domain.Projeto"%>
	
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

	<div class="conteudo">
		<form action="TarefaServlet" method="post" class="w3-container w3-card-4 w3-light-grey">
			  <h3>Cadastro de tarefas</h3>
			  <p>      
			  <label>Nome da Tarefa</label>
			  <input class="w3-input" type="text" name="nome_tarefa"></p>
			  <label>Data Inicio</label>
			  <input class="w3-input" type="text" name="data_inicio"></p>
			  <label>Data Entrega</label>
			  <input class="w3-input" type="text" name="data_termino"></p>

			  <br>
			  <label>Adicionar no projeto</label>
			  <br>
			  
			  <select name="projetos" id="projetos">
			  <%
			  	ArrayList<Projeto> listaG = pdao2.listar();
				
				for(Projeto projeto : listaG){
			  %>
			  		<option value = <%= projeto.getNome() %> > <%= projeto.getNome() %> </option>
			  <%
				}
			  %>
			  
			  </select>
			  
			  <br>
			  <br>
		  	  <input type="submit" class="cool-button" value="Cadastrar !">
			  <br>
		</form>
		

		<br>
	</div>
</html>