<?php
/*
    VENDAS
    SQL 1. TOTAL DE VENDAS POR MES E ANO
*/
$sql1 = "SELECT COUNT(id_venda) QNT,
                SUM(total) TOTAL,
                CONCAT(MONTH(data_venda), '/', YEAR(data_venda)) MES
           FROM vendas
       GROUP BY MES";


// VOU POR SOMENTE O RESULTADO DO SQL1, CASO QUEIRA POR OUTROS GRÁFICOS, É SÓ USAR AS QUERIES
$performe = $conn->query($sql1); // ESTOU USANDO A QUERIE 3 - CATEGORIAS
$row_performance = $performe->fetch_all(MYSQLI_ASSOC);
// vamos criar um array organizado de acordo com oque o gráfico precisa
$arr_data   = array();
$arr_lbls   = array();
$arr_colors = array();
foreach ($row_performance as $k => $v) {
  // $k = index do array que veio do banco de dados
  // $v = o array em si - ex. $v['produto'] = nome do produto
  $valor = $v['TOTAL'];
  $label = '('.$v['QNT'].') ' .$v['MES'];
  $arr_data[] = $valor;
  $arr_lbls[] = $label;
  $arr_colors[] = rand_color();
}
?>
<canvas id="lineChart"></canvas>
<script>
  ctxLine = document.getElementById("lineChart").getContext("2d");
  optionsLine = {
    legend: {
      labels: {
        fontColor: '#FFF'
      }
    },
    title: {
      display: true,
      fontColor: 'white',
      text: 'Valor Ganho Por Mês (R$)'
    },
    scales: {
      yAxes: [
        {
          ticks: {
            beginAtZero: true,
            fontColor: 'white'
          },
        }
      ],
      xAxes: [{
        ticks: {
          fontColor: 'white'
        },
      }]
    }
  };

  // Set aspect ratio based on window width
  optionsLine.maintainAspectRatio =
    $(window).width() < width_threshold ? false : true;

  configLine = {
    type: "line",
    data: {
      labels: ['<?=implode("','", $arr_lbls);?>'],
      datasets: [
        {
          label: "Vendas",
          data: [<?=implode(",", $arr_data);?>],
          fill: false,
          borderColor: "rgb(75, 192, 192)",
          cubicInterpolationMode: "monotone",
          pointRadius: 0
        }
        /*,
        {
          label: "Popular Hits",
          data: [33, 45, 37, 21, 55, 74, 69],
          fill: false,
          borderColor: "rgba(255,99,132,1)",
          cubicInterpolationMode: "monotone",
          pointRadius: 0
        },
        {
          label: "Featured",
          data: [44, 19, 38, 46, 85, 66, 79],
          fill: false,
          borderColor: "rgba(153, 102, 255, 1)",
          cubicInterpolationMode: "monotone",
          pointRadius: 0
        }
         // SE QUISER FAZER POR ANO, POR EXEMPLO... ELE VAI CRIANDO VARIAS LINHAS AQUI... CADA DATASET EH UMA LINHA NO GRAFICO
        */
      ]
    },
    options: optionsLine
  };

  lineChart = new Chart(ctxLine, configLine);
  
</script>
