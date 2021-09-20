<html>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<jsp:useBean id="fdao" class="br.com.pineapple.dao.FuncionarioDAO"/>
	
	<%@ page import ="java.util.ArrayList"%>
	<%@ page import ="java.util.List"%>
	<%@ page import ="br.com.pineapple.domain.Funcionario"%>
	
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>	
	  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	  
	<div class="conteudo">
		<form action="FuncionarioServlet" method="post" id="cadastro" class="w3-container w3-card-4 w3-light-grey">
			  <h3>Cadastro de funcionarios</h3>
			  <p>      
			  <label>CPF</label>
			  <input class="w3-input" type="text" name="cpf" id="cpf"></p>
			  <label>Nome</label>
			  <input class="w3-input" type="text" name="nome" id="nome""></p>
			  <label>E-mail</label>
			  <input class="w3-input" type="text" name="email" id="email"></p>
			  
		  	  <input type="submit" class="cool-button" value="Cadastrar !">
		  	  
		</form>
		<br>
		<button onclick="document.getElementById('id01').style.display='block'" class="cool-button" onclick="myFunction()">Mostrar cadastrados</button>
		<br>
				
		  <div id="id01" class="w3-modal" style="color: black;">
		    <div class="w3-modal-content">
		      <div class="w3-container">
		        <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-display-topright">&times;</span>
		        			<table class="table">
				<thead>
				<tr>
					<td>Nome</td>
					<td>E-mail</td>
					<td>CPF</td>
					<td>Alterar</td>
					<td>Excluir</td>
				</tr>
				</thead>
			<%
				ArrayList<Funcionario> lista = fdao.listar();
			
				for(Funcionario funcionario : lista){
			%>
			<tbody>
					<tr>
						<td><%= funcionario.getNome() %></td>
						<td><%= funcionario.getEmail() %></td>
						<td><%= funcionario.getCpf() %></td>
						<td><a href='includes/edit.jsp?u=<%= funcionario.getCpf() %>'>Alterar</a></td>
						<td><a href='includes/delete.jsp?d=<%= funcionario.getCpf() %>'>Excluir</a></td>
					</tr>
			<%
				}
			%>
			</tbody>
			</table>
		      </div>
		    </div>
		  </div>
				
		<br>
	</div>
</html>