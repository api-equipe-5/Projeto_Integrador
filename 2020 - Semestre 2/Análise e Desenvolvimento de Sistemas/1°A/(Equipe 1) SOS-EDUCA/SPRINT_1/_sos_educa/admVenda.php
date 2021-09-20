<table id="venda" class="table table-striped table-bordered table-condensed table-hover printable"  >
  <thead >
    <tr >
      <th>Cliente</th>
      <th>Quantidade</th>
      <th>Itens</th>
      <th>Data da Compra</th>
      <th>Total </th>
      <th>Forma pagamento</th>
    </tr>
  </thead>  
  <script>
    function data($data){
    return date("d/m/Y", strtotime($data));
  }
  </script>
  <?php
    $resultado=mysqli_query($conexao,  "SELECT vd.*,cl.* from vendas as vd, cliente as cl  WHERE (vd.id_cliente=cl.id_cliente)" );
    
    
      if($resultado){
        while($row = mysqli_fetch_assoc($resultado)){
          $idVenda = $row['id_venda'];
          $itensVendidos=mysqli_query($conexao,  "SELECT it.*,pr.* from itens_venda as it, produtos as pr  WHERE (it.id_produto=pr.id_produto) AND (it.id_venda='$idVenda')" );
  ?>
          <tbody style="text-align: center;">
              <tr>
                <td>
                  <?php echo ($row['nome']);?>
                </td>
                <td>
                  <?php echo ($row['qtd_itens']);?>
                </td>
                <td>
                  
                    <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseOne<?=$row['id_venda']?>" aria-expanded="false" aria-controls="collapseOne">
                      Clique aqui para verificar os Itens comprados
                    </button>
                    <div id="collapseOne<?=$row['id_venda']?>" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                      <ul>
                        <?php while($rowItem = mysqli_fetch_assoc($itensVendidos)){
                        ?>
                        <li><?=$rowItem['nome_prod']?></li>
                        <?php
                      }
                      ?>
                      </ul>
                    </div>
                </td>
                <td>
                  <?php echo date("d/m/Y", strtotime($row['data_venda'])); ?>
                </td>
                <td>
                  <?php echo "R$: ".($row['total']);?>
                </td>
                <td>
                  <?php echo ($row['forma_pagamento']);?>
                </td>
               
              </tr>
          </tbody>
         
  
    <?php
    
        }//fim do while
      }//fim do if

    ?>
  
</table>
<style>
    @media print {
      html, body {
        margin: 20px;
        padding: 0;
        border: 0;
      }
      .printable {
        margin: 0;
        padding: 0;
        border: 0;
        font-size: 14px;
      }
      .printable ~ * {
        display: none;
      }
    }
  </style>
<script>
    function printBy(selector){

      var $print = $(selector)
      .clone()
      .addClass('print')
      .prependTo('body');
      
      // Stop JS execution
      window.print();
      
      // Remove div once printed
      $print.remove();
    }
  </script>
<div class="text-center">
    <input type="button" onclick="printBy('.printable');" class="btn-success btn"  value="Imprimir"> 
    </div> 