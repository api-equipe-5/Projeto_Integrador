$(function() {

 
  $("#mesContas").change(function() {
    loadGraph();
  });

  $("#anosContas").change(function() {
    loadGraph();
  });

  loadGraph();
  
  function loadGraph() {
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);
  
    function drawChart() {
  
      var mes = $("#mesContas :selected").val();
      var ano = $("#anosContas :selected").val();
  
      var endpoint = "http://localhost:9000/pagamentos";
  
      if(mes != "" && ano != "") {
        endpoint += "/" + mes + "/" + ano;
      }
  
      $.getJSON(endpoint, function(data) {
          
      }).done(function(data) {
          var myArray = [];
          myArray.push(['Tipo', 'Porcentagem']);
          $.each(data, function(i, item){
              myArray.push([item['statusPagamento'], item['percentual']])
          });
      
          var data = google.visualization.arrayToDataTable(myArray);
  
          var options = {
  
          };
  
          var chart = new google.visualization.PieChart(document.getElementById('piechart'));
  
          chart.draw(data, options);
      });
    }
  }
 

});