<?php
/*
    PERFORMANCE DO PRODUTO
    SQL 1. TRAZ O VALOR TOTAL QUE CADA PRODUTO VENDEU, COM O NOME DO PRODUTO E CATEGORIA
    SQL 2. TRAZ O VALOR TOTAL POR MÊS E ANO
    SQL 3. TRAZ O VALOR TOTAL POR CATEGORIA
*/
$sql1 = "SELECT b.nome_prod produto,
                          SUM(b.preco * a.qtd_item) valor_total,
                          c.nome_cat categoria
                     FROM itens_venda a
               INNER JOIN produtos b ON (a.id_produto = b.id_produto)
               INNER JOIN categorias c ON (b.id_categoria = c.id_cat)
                 GROUP BY b.id_produto";

$sql2 = "SELECT COUNT(a.id_venda) QNT,
                          MONTH(x.data_venda) MES,
                          YEAR(x.data_venda) ANO,
                          SUM(b.preco * a.qtd_item) valor_total
                     FROM itens_venda a
               INNER JOIN vendas x ON (a.id_venda = x.id_venda)
               INNER JOIN produtos b ON (a.id_produto = b.id_produto)
               INNER JOIN categorias c ON (b.id_categoria = c.id_cat)
                 GROUP BY ANO, MES";

$sql3 = "SELECT SUM(b.preco * a.qtd_item) valor_total,
                          c.nome_cat categoria
                     FROM itens_venda a
               INNER JOIN produtos b ON (a.id_produto = b.id_produto)
               INNER JOIN categorias c ON (b.id_categoria = c.id_cat)
                 GROUP BY c.id_cat";

$sql4 = "SELECT COUNT(a.id_venda) QNT,
                          c.nome_cat categoria
                     FROM itens_venda a
               INNER JOIN vendas x ON (a.id_venda = x.id_venda)
               INNER JOIN produtos b ON (a.id_produto = b.id_produto)
               INNER JOIN categorias c ON (b.id_categoria = c.id_cat)
                 GROUP BY c.id_cat";                 

// VOU POR SOMENTE O RESULTADO DO SQL1, CASO QUEIRA POR OUTROS GRÁFICOS, É SÓ USAR AS QUERIES
$performe = $conn->query($sql4); // ESTOU USANDO A QUERIE 3 - CATEGORIAS
$row_performance = $performe->fetch_all(MYSQLI_ASSOC);
// vamos criar um array organizado de acordo com oque o gráfico precisa
$arr_data   = array();
$arr_lbls   = array();
$arr_colors = array();
foreach ($row_performance as $k => $v) {
  // $k = index do array que veio do banco de dados
  // $v = o array em si - ex. $v['produto'] = nome do produto
  $label = $v['categoria'];
  $valor = $v['QNT'];
  $arr_data[] = $valor;
  $arr_lbls[] = $label;
  $arr_colors[] = rand_color();
}
?>
<canvas id="barChart"></canvas>
<script>
  ctxBar = document.getElementById("barChart").getContext("2d");
  optionsBar = {
    legend: {
      labels: {
        fontColor: '#FFF'
      }
    },
    title: {
      display: true,
      fontColor: 'white',
      text: 'Vendas por Matérias'
    },
    responsive: true,
    scales: {
      yAxes: [
        {
          barPercentage: 0.5,
          ticks: {
            beginAtZero: true,
            fontColor: 'white'
          }
        }
      ],
      xAxes: [{
        ticks: {
          fontColor: 'white'
        },
      }]
    }
  };
  optionsBar.maintainAspectRatio =
    $(window).width() < width_threshold ? false : true;
  configBar = {
    type: "horizontalBar",
    data: {
      labels: ['<?=implode("','", $arr_lbls);?>'],
      datasets: [
        {
          label: "# Maior Venda",
          data: [<?=implode(",", $arr_data);?>],
          backgroundColor: ['<?=implode("','", $arr_colors);?>'],
          borderWidth: 0
        }
      ] 
    },
    options: optionsBar
  };
  barChart = new Chart(ctxBar, configBar);
</script>