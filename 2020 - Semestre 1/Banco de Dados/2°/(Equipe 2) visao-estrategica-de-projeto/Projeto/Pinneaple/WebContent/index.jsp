<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/styles.css">
<link rel="stylesheet" type="text/css" href="jsgantt.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script language="javascript" src="jsgantt.js"></script>
<script language="javascript" src="graphics.js"></script>

<script src="codebase/dhtmlxgantt.js?v=7.0.4"></script>
<link rel="stylesheet" href="codebase/dhtmlxgantt.css?v=7.0.4">

<title>Pineapple</title>
</head>
<body>
 <div class="ct" id="t1">
  <div class="ct" id="t2">
    <div class="ct" id="t3">
      <div class="ct" id="t4">
         <div class="ct" id="t5">
          <ul id="menu">
            <a href="#t1"><li class="icon fa fa-bolt" id="uno"></li></a>
            <a href="#t2"><li class="icon fa fa-keyboard-o" id="dos"></li></a>
            <a href="#t3"><li class="icon fa fa-rocket" id="tres"></li></a>
            <a href="#t4"><li class="icon fa fa-dribbble" id="cuatro"></li></a>
          </ul>
          <div class="page" id="p1">
             <section class="icon fa fa-bolt"><span class="title">Relatório</span></section>  
             <%@ include file="includes/grafico.jsp" %>
          </div>
          <div class="page" id="p2">
            <!--  <section class="icon fa fa-keyboard-o"><span class="title">Cadastro de funcionario</span></section>-->
            <%@ include file="includes/cadastroFuncionario.jsp" %>
          </div>  
          <div class="page" id="p3">
            <%@ include file="includes/cadastroProjeto.jsp" %>
          </div>
          <div class="page" id="p4">
            <%@ include file="includes/cadastroTarefas.jsp" %>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="assets/js/actions.js"></script>

</body>
</html>