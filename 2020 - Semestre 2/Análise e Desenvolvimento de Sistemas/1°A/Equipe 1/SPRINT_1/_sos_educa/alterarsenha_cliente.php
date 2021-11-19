      <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
      <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
      <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <link rel="stylesheet" href="css/login.css">
      <!------ Include the above in your HEAD tag ---------->
      
      <div class="wrapper fadeInDown">
        <div id="formContent">
          <!-- Tabs Titles -->

          <!-- Icon -->
          <div class="fadeIn first">
            <img src="images/senha.png" width="90px" height="90px" />
          </div>

          <!-- Login Form -->
          <form class="form-group" action="alterar_senha.php" method="POST" >
            <input type="text" id="login" class="fadeIn second" name="senha" placeholder="Senha Atual">
            <input type="text" id="password" class="fadeIn third" name="senha_nova" placeholder="Nova Senha">
            <input type="text" id="password" class="fadeIn third" name="confirmar_senha" placeholder="Confirmar Nova Senha">
            <input type="submit" class="fadeIn fourth" value="Alterar">
          </form>

        

        </div>
        </div>