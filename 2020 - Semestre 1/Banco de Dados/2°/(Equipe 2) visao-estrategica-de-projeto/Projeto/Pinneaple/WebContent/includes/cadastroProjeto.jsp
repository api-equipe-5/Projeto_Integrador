	<%@ page import="java.util.ArrayList"%>
	<%@ page import ="java.util.List"%>
	<%@ page import ="br.com.pineapple.domain.Projeto"%>
	<%@ page import ="br.com.pineapple.domain.Funcionario"%>
	<%@ page import ="br.com.pineapple.domain.Tarefa"%>
	<jsp:useBean id="pdao" class="br.com.pineapple.dao.ProjetoDAO"/>
	<jsp:useBean id="fdao2" class="br.com.pineapple.dao.FuncionarioDAO"/>

	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<html>
	<div class="conteudo">	

		<form method="post" action="ProjetoServlet" class="w3-container w3-card-4 w3-light-grey">
			  <h3>Cadastro de projetos</h3>
			  <p>      
			  <label>Nome do projeto</label>
			  <input class="w3-input" type="text" id="nome" name="nome"></p>
			  <label>Data inicio</label>
			  <input class="w3-input" type="text" id="inicio" name="inicio"></p>
			  <label>Data entrega</label>
			  <input class="w3-input" type="text" id="entrega" name="entrega"></p>
			  <br>
			  <label>Adicionar funcionarios</label>
			  <br>
			  <select name="funcionarios" id="funcionarios">
			  <%
			  	ArrayList<Funcionario> listaSelect = fdao2.listar();
				
				for(Funcionario funcionario : listaSelect){
			  %>
			  	
			  		 <option value = <%= funcionario.getCpf() %> > <%= funcionario.getNome() %> </option>
			  <%
				}
			  %>
				</select>

			  <br>
			  <br>
		  	  <input type="submit" class="cool-button" value="Cadastrar !">
		</form>
		
		<br>
		<button onclick="document.getElementById('id02').style.display='block'" class="cool-button" onclick="myFunction()">Mostrar cadastrados</button>
		<br>

			  <div id="id02" class="w3-modal" style="color: black;">
			    <div class="w3-modal-content">
			      <div class="w3-container">
			        <span onclick="document.getElementById('id02').style.display='none'" class="w3-button w3-display-topright">&times;</span>
			   <table class="table">
				<thead>
				<tr>
					<td>Nome do projeto</td>
					<td>Data inicio</td>
					<td>Data termino</td>
					<td>Alterar</td>
					<td>Excluir</td>
				</tr>
				</thead>
			<%
				ArrayList<Projeto> listarG = pdao.listar();
			
				for(Projeto projeto : listarG){
			%>
			<tbody>
					<tr>
						<td><%= projeto.getNome() %></td>
						<td><%= projeto.getInicio() %></td>
						<td><%= projeto.getEntrega() %></td>
						<td><a href='includes/editProj.jsp?u=<%= projeto.getNome() %>'>Alterar</a></td>
						<td><a href='includes/deleteProj.jsp?d=<%= projeto.getNome() %>'>Excluir</a></td>
					</tr>
			<%
				}
			%>
			</tbody>
			</table>
			      </div>
			    </div>
			  </div>
			</div>	

		<br>
		<br>
	</div>
</html>