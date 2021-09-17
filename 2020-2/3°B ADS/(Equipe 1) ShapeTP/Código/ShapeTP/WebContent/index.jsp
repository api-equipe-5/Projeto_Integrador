<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.fatec.model.UserInterface"%>
<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>ShapeTP - Shapefile/Postgis miniETL</title>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="img/ico.png">
</head>
<body>
<div id="corpo">
<header id="ieuh" class="header-banner">
  <img id="iyjhl" src="img/topo.png"/>
</header>
<section id="i0qt6" class="bdg-sect">
  <div data-tabs="1" id="ivtb4">
    <nav data-tab-container="1" id="ijyt5" class="tab-container">
      <a href="#tab1" data-tab="1" id="i0dkh" class="tab">Shapefile para PostgreSQL/PostGIS</a>
      <a href="#tab2" data-tab="1" id="izllg" class="tab">PostgreSQL/PostGIS para Shapefile</a>
    </nav>
    <div id="tab1" data-tab-content="1" class="tab-content">
    	<div id="iou88" class="row">
	        <div id="iro8u" class="cell"></div>
	        <div id="izcux" class="cell">
	          <div id="iwjia">Para carregar os dados do Shapefile para uma tabela existente do banco de dados, selecione a tabela alvo e escolha o Shapefile. Após isso, aparecerá a parametrização onde você deve relacionar os campos.</div>
	        </div>
	    </div>
      <div id="i3wlj" class="cell">
        <form action="/Parametrizacao" method="post" id="iqdd6" class="form">
          <label id="io2ol" class="label">Selecionar tabela alvo</label>
          <select id="in59v" name="ShapeToPost" class="select" required>
              <%
                for(String tab: UserInterface.tables()){
                    String opt = String.format("<option value=\"%s\">%s</option>", tab, tab);
                    out.print(opt);
                }
              %>
          </select>
          <button type="submit" id="is3kp" class="button" onclick="document.body.className = 'loading'">Selecionar Shapefile</button>
        </form>
        <form id="ivcqd" class="form">
          <div class="form-group">
          </div>
        </form>
      </div>
    </div>
    <div id="tab2" data-tab-content="1" class="tab-content">
      <div id="iou88" class="row">
        <div id="iro8u" class="cell">
        </div>
        <div id="izcux" class="cell">
          <div id="iwjia">Para converter uma de nossas tabelas do banco de dados para um Shapefile, basta apenas selecionar a tabela desejada, clicar em converter e selecionar onde devemos salvar o Shapefile.
          </div>
        </div>
      </div>
      <form action="/PostToShape" method="post" id="if3ky" class="form">
        <select id="imf5i" name="PostToShape" class="select" required>
            <%
                for(String tab: UserInterface.tables()){
                    String opt = String.format("<option value=\"%s\">%s</option>", tab, tab);
                    out.print(opt);
                }
            %>
        </select>
        <button type="submit" id="iykqd" class="button" onclick="document.body.className = 'loading'">Converter</button>
      </form>
    </div>
  </div>
</section>
<footer id="i2x84b" class="footer-under">
  <div id="ibkqs1" class="copyright">
    <div id="iga0s5" class="container-width">
      <div id="i49cmd" class="made-with">
        <a href="https://fatecsjc-prd.azurewebsites.net/" target="_blank" id="i5fli" class="link">DESENVOLVIDO POR ALUNOS DA  FACULDADE DE TECNOLOGIA DE SÃO JOSÉ DOS CAMPOS - PROF. JESSEN VIDAL</a>
      </div>
      <img id="iouth" src="img/github.png" alt="github"/>
      <div id="ik8es" class="made-with">
        <a draggable="true" href="" id="ixxy2" class="link"></a>
        <a draggable="true" href="https://github.com/WeDias/ShapeTP" target="_blank" title="" id="i6asz" class="link"></a>
        <a href="https://github.com/WeDias/ShapeTP" target="_blank" title="" id="ih7my" class="link">PROJETO INTEGRADOR 3ºSEMESTRE ADS</a>
      </div>
      <div id="ipaj3" class="made-with">
        <a draggable="true" href="" class="link"></a>
        <a draggable="true" href="https://github.com/WeDias/ShapeTP" target="_blank" title="" class="link"></a>
        <a href="https://www.visionaespacial.com.br/" target="_blank" title="" id="ix26f" class="link">VISIONA TECNOLOGIA ESPACIAL S.A.</a>
      </div>
      <div class="foot-social-btns">
      </div>
      <div id="ijbw2" class="clearfix">
      </div>
    </div>
  </div>
</footer>
</div>
<script>var items = document.querySelectorAll('#ivtb4');
  for (var i = 0, len = items.length; i < len; i++) {
    (function(){
      var t,e=this,a="[data-tab]",n=document.body,r=n.matchesSelector||n.webkitMatchesSelector||n.mozMatchesSelector||n.msMatchesSelector,o=function(){
        var a=e.querySelectorAll("[data-tab-content]")||[];
        for(t=0;t<a.length;t++)a[t].style.display="none"}
      ,i=function(n){
        var r=e.querySelectorAll(a)||[];
        for(t=0;t<r.length;t++){
          var i=r[t],s=i.className.replace("tab-active","").trim();
          i.className=s}
        o(),n.className+=" tab-active";
        var l=n.getAttribute("href"),c=e.querySelector(l);
        c&&(c.style.display="")}
      ,s=e.querySelector(".tab-active"+a);
      s=s||e.querySelector(a),s&&i(s),e.addEventListener("click",function(t){
        var e=t.target;
        r.call(e,a)&&i(e)})}.bind(items[i]))();
  }
</script>
</body>
</html>