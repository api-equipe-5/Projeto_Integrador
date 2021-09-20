<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
      <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
      <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <link rel="stylesheet" href="css/login.css">
      <!------ Include the above in your HEAD tag ---------->

      <?php
        include("conexao.php"); 
        
      ?>

      <?php session_start(); ?>
      <div class="wrapper fadeInDown">
        <div id="formContent">
          <!-- Tabs Titles -->

          <!-- Icon -->
          <div class="fadeIn first">
            <img src="images/cadastro.png" width="70px" height="70px" />
          </div>
          

          <!-- Login Form -->
          <form class="form-horizontal" name="form_alterar" method="POST" action="alterar_3.php">
          <?php
          $id_cliente=$_SESSION['id_cliente'];
          $resultado=mysqli_query($conexao, "SELECT * FROM cliente where id_cliente = $id_cliente");
          if($resultado){
            while($row=mysqli_fetch_assoc($resultado)){
                ?>
            <input type="text" id="cep" class="fadeIn second" name="cep" placeholder="CEP" value="<?php echo $row['cep']; ?>">
            <input type="text" id="password" class="fadeIn third" name="rua" placeholder="Rua" value="<?php echo $row['rua']; ?>">
            <input type="text" id="password" class="fadeIn third" name="num_casa" placeholder="Nº da Casa" value="<?php echo $row['num_casa']; ?>">
            <input type="text" id="password" class="fadeIn third" name="bairro" placeholder="Bairro" value="<?php echo $row['bairro']; ?>">            
            <input type="text" id="password" class="fadeIn third" name="cidade" placeholder="Cidade" value="<?php echo $row['cidade']; ?>">
            <input type="text" id="password" class="fadeIn third" name="estado" placeholder="Estado" value="<?php echo $row['estado']; ?>">
            <input type="text" id="password" class="fadeIn third" name="telefone" placeholder="Telefone" value="<?php echo $row['telefone']; ?>">
            <input type="text" id="password" class="fadeIn third" name="email" placeholder="E-mail" value="<?php echo $row['email']; ?>">
            <input type="submit" class="fadeIn fourth" value="Alterar">
            <?php
            } //fim while
          }//fim if
          mysqli_close($conexao);
          ?>
          </form>

          


        </div>
        </div>