<%@page import="br.com.pineapple.domain.Funcionario"%>
<%@page import="br.com.pineapple.dao.FuncionarioDAO"%>
<%@page import="br.com.pineapple.domain.ProjFunc"%>
<%@page import="java.time.Instant"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="br.com.pineapple.domain.TarProj"%>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.GregorianCalendar" %>
<%@page import="java.util.TimeZone"%>
<%@page import="br.com.pineapple.domain.Tarefa"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.sql.SQLException"%>
<html>
    <%@page import="java.util.ArrayList"%>
    <%@ page import ="java.util.List"%>
    <%@ page import ="br.com.pineapple.domain.Projeto"%>
    <%@ page import ="br.com.pineapple.domain.Pendencia"%>
    <jsp:useBean id="pdaoG" class="br.com.pineapple.dao.ProjetoDAO"/>
    <jsp:useBean id="pdaoFG" class="br.com.pineapple.dao.FuncionarioDAO"/>
    <jsp:useBean id="pdaoFun" class="br.com.pineapple.dao.ProjFuncDAO"/>
    <jsp:useBean id="tdaoG" class="br.com.pineapple.dao.TarefaDAO"/>
    <jsp:useBean id="pdaoT" class="br.com.pineapple.dao.TarProjDAO"/>
    <jsp:useBean id="pdaoP" class="br.com.pineapple.dao.PendenciaDAO"/>
    <div class="conteudo">
    	<button onClick="MyWindow=window.open('http://localhost:8085/Pinneaple/index.jsp#t3','MyWindow','width=600,height=1000');"  class="w3-button w3-black" style="margin-left: 10px;">Nova tarefa</button>
    	<button onclick="myFunction()"  class="w3-button w3-black" style="margin-left: 10px;">Atualizar</button>
    	<input type="hidden" id="hiddenarray">
    </div>
        <div id="gantt_here" style='width:88%; height:98%; margin-left:130px; margin-top: 10px;'></div>

    <script>
        gantt.init("gantt_here");
		
        gantt.config.columns = [
            {name:"text",       label:"Projeto",  width: 100, tree:true },
            {name:"nome",       label:"Nome",  align:"center" },
            {name:"start_date", label:"Inicio", width: 80, align:"center" },
            {name:"duration",   label:"Duração",   align:"center" }
        ];
        
        gantt.parse({
            data: [
            	<%
				ArrayList<Projeto> listaSelectP = pdaoG.listar();
            	int i = 1;
            	HashMap<String, Integer> mapPT = new HashMap<String, Integer>();
				for(Projeto projetosG : listaSelectP){
					String projeto = projetosG.getNome();
					String data = projetosG.getInicio();
					String dataF = projetosG.getEntrega();
					ProjFunc pfGraf = new ProjFunc();
					pfGraf.setNome(projeto);
					ProjFunc consultapf = pdaoFun.consultarNome(pfGraf);
					FuncionarioDAO fdaoG = new FuncionarioDAO();
					Funcionario fg1 = new Funcionario();
					fg1.setCpf(consultapf.toString());
					Funcionario FuncionarioG = fdaoG.consultarCPF(fg1);
					String[] splitFuncG = FuncionarioG.toString().split(" ");
					
					Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(data);
					Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(dataF);
					long diffTime = date2.getTime() - date1.getTime();
					long diffDays = diffTime / (1000 * 60 * 60 * 24);
					
            	%>
            	 { id: <%= i %>, text: "<a href='#' onclick=\"popUpProjeto('<%= projeto %>')\"><%= projeto %></a>", nome: "<%= splitFuncG[1] %>", start_date: "<%= data %>", duration: <%= diffDays %>, progress: 0.4, open: false },
                <%
                mapPT.put(projeto, i);
                i++;
				}
                %>
                <%
                ArrayList<TarProj> listaSelectT = pdaoT.listar();
             	Tarefa tarefinha = new Tarefa();
                for(TarProj tarefaG : listaSelectT){
                	String tarefa = tarefaG.getNome_tarefa();
                	String projetoT = tarefaG.getNome_projeto();
                	tarefinha.setNome_tarefa(tarefa);
                	Tarefa consulta = tdaoG.consultarTarefa(tarefinha);
                	String[] splitTarefaG = consulta.toString().split(" ");
                	
                %>
                	{ id: <%= i %>, text: "<a href='#' onclick=\"popUpTarefa('<%= tarefa %>')\"><%= tarefa %></a>", nome: '', start_date: "<%= splitTarefaG[1] %>", duration: 4, progress: 0.6, parent: <%= mapPT.get(projetoT)%> },
                <%
                i++;
                }
                
                %>
            ],
            links: [
<%
            	int i2 = 1;
            	ArrayList<Pendencia> listarPendencia = pdaoP.listar();
             	Pendencia pendencia = new Pendencia();
                for(Pendencia tarefaPen : listarPendencia){
                	String tarefa_pai = tarefaPen.getTarefa_pai();
                	String tarefa_filha = tarefaPen.getTarefa_filha();
                	
            	%>
            		{id: <%= i2 %>, source: <%= tarefa_pai %>, target: <%= tarefa_filha%> , type: "1"}
            		//id precisa ser ultimo i + 1, source é a tarefa pai, target a tarefa filha, type não sera alterado            		//id e souce podem ser iguais 

				<%
				i2++;
                }
                
				%>
            ]
        });
        
		function teste() {	

      	}
		
        
		function popUpProjeto(nome) {	
			
			var popup = window.open("includes/editProj.jsp?u=" + nome,"mypopup","width=500,height=1000");
      	}
		
		function popUpTarefa(nome) {	
			
			var popup = window.open("includes/editTarefa.jsp?u=" + nome,"mypopup","width=500,height=1000");
      	}
        function myFunction() {	
        		
        	  var links = gantt.getLinks();
        	  json = gantt.serialize();
        	  var nomes = [];
        	  var datas = [];
        	  var fim = [];
        	  var parent = [];
        	  var source = [];
        	  var target = [];
        	  
        	  for(var i2 = 0; i2 < links.length; i2++){
        		  source.push(links[i2].source);
        		  target.push(links[i2].target);
        	  }
        	  console.log(source);
        	  console.log(target);
        	  for(var i = 0; i < json.data.length; i++) {
        		  var obj = json.data[i];       		    	    
	      		    var res = obj.text.split(">");
	      		    var res2 = res[1].split("<");
	      		    console.log(res2[0]);
	      		    nomes.push(res2[0]);
	      		    datas.push(obj.start_date);
	      		    fim.push(obj.duration);
	      		    parent.push(obj.parent);
        		    
        		    
        	  }     		
        	  window.location.replace("includes/cadProjs.jsp?d=" + datas + "&n=" + nomes + "&f=" + fim + "&p=" + parent + "&s=" + source + "&t=" +target);
        	}
    </script>
    
</html>