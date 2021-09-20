<%@page import="java.sql.SQLException"%>
<%@page import="br.com.pineapple.dao.TarefaDAO"%>
<%@page import="br.com.pineapple.domain.Tarefa"%>
	<%@page import="java.util.Date"%>
	<%@page import="java.util.Calendar"%>
	<%@page import="java.text.SimpleDateFormat"%>
	<%@page import="br.com.pineapple.dao.ProjetoDAO"%>
	<%@page import="br.com.pineapple.domain.Projeto"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="br.com.pineapple.domain.Pendencia"%>
	<%@page import="br.com.pineapple.dao.PendenciaDAO"%>
	<html>
	<head>
	</head>
	<body>
	<%
	String proj = request.getParameter("n");
	String inicio = request.getParameter("d");
	String fim = request.getParameter("f");
	String parent = request.getParameter("p");
	
	String source = request.getParameter("s");
	String target = request.getParameter("t");
	
	String[] obj = proj.split(",");
	String[] obj2 = inicio.split(",");
	String[] obj3 = fim.split(",");
	String[] obj5 = parent.split(",");
	String[] objSource = source.split(",");
	String[] objTarget = target.split(",");
	int i = 0;
	ProjetoDAO pdao = new ProjetoDAO();
	TarefaDAO tdao = new TarefaDAO();
	PendenciaDAO pendao = new PendenciaDAO();
	Projeto p1 = new Projeto();
	Tarefa t1 = new Tarefa();
	Pendencia pen1 = new Pendencia();
			
			for(String sources : objSource){
				
				pen1.setTarefa_pai(source);
				pen1.setTarefa_filha(target);
				try{
					pendao.salvar(pen1);
				}
				catch(SQLException ex){
					out.println(ex);
				}
				
			}
	
			for(String objs : obj){
				String parents = obj5[i];
				int parseParent = Integer.parseInt(parents);
				String[] obj4 = obj2[i].split(" ");	
				String dt = obj4[0].replace("-","/"); 
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Calendar c = Calendar.getInstance();
				c.setTime(sdf.parse(dt));
				c.add(Calendar.DATE, Integer.parseInt(obj3[i])); 
				dt = sdf.format(c.getTime());  
				
				obj4[0] = obj4[0].replace("-","/");
				if (parseParent == 0){
					p1.setNome(objs);
					p1.setInicio(obj4[0]);
					p1.setEntrega(dt);
					try{
					pdao.atualizar(p1);
					}catch(SQLException ex){
						out.println(ex);
					}
				}else{
					t1.setNome_tarefa(objs);
					t1.setData_inicio(obj4[0]);
					t1.setData_termino(dt);
					try{
					tdao.atualizar(t1);
					}catch(SQLException ex){
						out.println(ex);
					}
				}
				i++;
		}
	
	response.sendRedirect("../index.jsp");
	%>
</body>
</html>