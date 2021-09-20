<%@page import="br.com.pineapple.dao.FuncionarioDAO"%>
<%@page import="br.com.pineapple.domain.ProjFunc"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../assets/css/styles.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Projetos</title>
	<jsp:useBean id="pdao" class="br.com.pineapple.dao.ProjetoDAO"/>
	<jsp:useBean id="pfdao" class="br.com.pineapple.dao.ProjFuncDAO"/>
	<jsp:useBean id="fdao" class="br.com.pineapple.dao.FuncionarioDAO"/>
	<jsp:useBean id="ptdao" class="br.com.pineapple.dao.TarProjDAO"/>
	<jsp:useBean id="tdao" class="br.com.pineapple.dao.TarefaDAO"/>
	
	
	<%@ page import ="java.util.ArrayList"%>
	<%@ page import ="java.util.List"%>
	<%@ page import ="br.com.pineapple.domain.Projeto"%>
	<%@ page import ="br.com.pineapple.domain.TarProj"%>
</head>
<body style="background-color: rgb(255,215,0);">
<%
	String nome = request.getParameter("u");

	Projeto p1 = new Projeto();
	p1.setNome(nome);

	Projeto p2 = pdao.consultarNome(p1);
	
	String[] splitFuncionario = p2.toString().split(" ");

%>
<div class="conteudo">
<form action = "../ProjetoUpdate" method="post" class="w3-container w3-card-4 w3-light-grey">
	<h3>Editar Projeto</h3>
	<p>  
	<label><b>Projeto</b></label>
	 <input type="text" id="nome" name="nome" class="w3-input" value=<%= splitFuncionario[0] %>><br><br>
	 <label><b>Data de inicio</b></label>
	 <input type="text" id="inicio" name="inicio" class="w3-input" value=<%= splitFuncionario[1] %>><br><br>
	 <label><b>Data de entrega</b></label>
	 <input type="text" id="entrega" name="entrega" class="w3-input" value=<%= splitFuncionario[2] %>><br><br>
	 
	 <input type="submit" value="Atualizar !" class="cool-button">
 </form>

 <br>
 
  	  <button onclick="document.getElementById('id777').style.display='block'" class="w3-button w3-black">Editar Tarefas</button>

  	<div id="id777" class="w3-modal">
     <div class="w3-modal-content w3-card-4">
      <header class="w3-container w3-black"> 
        <span onclick="document.getElementById('id777').style.display='none'" 
        class="w3-button w3-display-topright">×</span>
        
		        <h3>Tarefas</h3>
		      </header>
		      
		      <div class="w3-container">
		
			<%@ page import ="br.com.pineapple.domain.Tarefa"%>
			
			 <form action="../TarefaServlet" method="post" class="w3-container w3-card-4 w3-light-grey">
			 <input type="text" id="projetos" name="projetos" hidden="true" value="<%= splitFuncionario[0] %>" >
				  <h3>Cadastro de tarefas</h3>
				  <p>      
				  <label>Nome da Tarefa</label>
				  <input class="w3-input" type="text" name="nome_tarefa">
				  <label>Data Inicio</label>
				  <input class="w3-input" type="text" name="data_inicio">
				  <label>Data Entrega</label>
				  <input class="w3-input" type="text" name="data_termino">
				  <br>
				  <input type="submit">
			  </form>
			  
			<div class="conteudo">
				<br>
				<form action = "../TarProjServlet" method="post">
					
					<table class="table">
						<thead>
						<tr>
							<td>Nome da tarefa</td>
							<td>Data inicio</td>
							<td>Data termino</td>
							<td>Alterar</td>
							<td>Excluir</td>
						</tr>
						</thead>
	  				  <%
	  					TarProj tp = new TarProj();
	                   	tp.setNome_projeto(nome);
	  				  
					  	ArrayList<TarProj> listaSelectT = ptdao.listarEdit(tp);
						
					  	Tarefa t = new Tarefa();
					  	
						for(TarProj tarefa : listaSelectT){
							t.setNome_tarefa(tarefa.getNome_tarefa());
							Tarefa t2 = tdao.consultarTarefa(t);
							
							String[] splitT = t2.toString().split(" ");
							
					  %>	  	
						  <tbody>
							<tr>
								<td><%= splitT[0] %></td>
								<td><%= splitT[1] %></td>
								<td><%= splitT[2] %></td>
								<td><a href='editTarefa.jsp?u=<%= t.getNome_tarefa() %>'>Alterar</a></td>
								<td><a href='ptDelete.jsp?d=<%= splitFuncionario[0] + "&d2=" + t.getNome_tarefa() %>'>Excluir</a></td>
							</tr>
					  <%
						}
					  %>
					</tbody>
		</table>
       </form>
      </div>
     </div>
     </div>
	 </div>

 
 	  <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-black">Editar Funcionarios</button>
  </div>	  
    <div id="id01" class="w3-modal">
    <div class="w3-modal-content w3-card-4">
      <header class="w3-container w3-black"> 
        <span onclick="document.getElementById('id01').style.display='none'" 
        class="w3-button w3-display-topright">x</span>
        
        <h3>Funcionarios</h3>
      </header>
      
      <div class="w3-container">

    <%@ page import ="java.util.ArrayList"%>
	<%@ page import ="java.util.List"%>
	<%@ page import ="br.com.pineapple.domain.Funcionario"%>
	
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	
	<div class="conteudo">
		<br>
		<form action = "../ProjFuncServlet" method="post">
			<input type="text" id="nomeP" name="nomeP" hidden="true" value="<%= splitFuncionario[0] %>" >
				<label>Nome do Funcionario</label>
				<select name="funcionarios" id="funcionarios">
					<%
					  	ArrayList<Funcionario> listaSelect = fdao.listar();
						
						for(Funcionario funcionario : listaSelect){
					  %>	  	
					  		 <option value = <%= funcionario.getCpf() %> > <%= funcionario.getNome() %> </option>
					  <%
						}
					  %>
				</select>
				
			<input type="submit" value="Adicionar" class="w3-button w3-black">
		
		</form>
		</div>	
		<br>
		<div id="myDIV" style="margin-left: 10px;" class="w3-container w3-card-4 w3-light-grey">
		
			<table class="table">
				<thead>
				<tr>
					<td>Nome</td>
					<td>E-mail</td>
					<td>Delete</td>
				</tr>
				</thead>
			<%	
				ProjFunc pj = new ProjFunc();	
				pj.setNome(nome);	
			
				ArrayList<ProjFunc> lista = pfdao.listar(pj);
				
				Funcionario f = new Funcionario();
				
				for(ProjFunc rel : lista){
					f.setCpf(rel.getCpf());
					f.setCpf(f.getCpf());
					Funcionario f2 = fdao.consultarCPF(f);
					String[] splitF = f2.toString().split(" ");
					
			%>
			<tbody>
					<tr>
						<td><%= splitF[1] %></td>
						<td><%= splitF[2] %></td>
						<td><a href='pjDelete.jsp?d=<%= splitFuncionario[0] + "&d2=" + f.getCpf() %>'>Excluir</a></td>
					</tr>
			<%
				}
			%>
			</tbody>
			</table>	

		</div>
		<br>
	 </div>
    </div>
  </div>
   
</body>
</html>