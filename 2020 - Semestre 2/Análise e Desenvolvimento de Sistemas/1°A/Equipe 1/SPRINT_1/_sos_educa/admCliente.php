<table class="table table-striped table-dark table-hover" >
  <thead>
    <tr>
      <th>Nome</th>
      <th>CPF</th>
      <th>Telefone</th>
      <th>E-mail</th>
    </tr>
  </thead>
  
  <?php
    $resultado=mysqli_query($conexao,  "SELECT * FROM cliente");
      if($resultado){
        while($row = mysqli_fetch_assoc($resultado)){
  ?>
          <tbody>
            <tr>
              <td>
                <?php 
                  echo "<p></p>".($row['nome']);
                ?>
              </td>
              <td>
                <?php 
                  echo "<p></p>".($row['cpf']);
                ?>
              </td>
              <td>
                <?php 
                  echo "<p></p>".($row['telefone']);
                ?>
              </td>
              <td>
                <?php 
                  echo "<p></p>".($row['email']);
                ?>
              </td>
            </tr>
          </tbody>
<?php 
        }//fim do while
      } //fim do if
?>
</table>