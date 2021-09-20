<!DOCTYPE html>
<html lang="pt-br">
<head>
  <?php session_start() ?>
  <?php include ('cabecalho.php') ?>
  <title>SOS Educa - Cadastro Cliente</title>
  <script src="js/vue.min.js"></script>
  <script src="js/vue-resource.min.js"></script>
  <script>
    function Mascara(objeto){
      if(objeto.value.length==0)
        objeto.value='(' +objeto.value;
          if(objeto.value.length==3)
            objeto.value= objeto.value +')';
          if(objeto.value.length==9)
            objeto.value=objeto.value +'-';     
    }	 
  </script>
  <script> 
    function Mascara_cpf(objeto){
      if(objeto.value.length==0)
        objeto.value='' +objeto.value;
          if(objeto.value.length==3)
            objeto.value= objeto.value +'.';
          if(objeto.value.length==7)
            objeto.value= objeto.value +'.';
          if(objeto.value.length==11)
            objeto.value=objeto.value +'-';     
    }	 
  </script>
  <script type="text/javascript">
    function Mascara_cep(objeto){
      if(objeto.value.length==0)
        objeto.value='' +objeto.value;
          if(objeto.value.length==5)
            objeto.value=objeto.value +'-';     
    }	 
  </script>
  <script type="text/javascript">
    $(document).ready(function() {
      $('#dica + span')
      .css({display:'none',
        border: '1px solid #336600',
        padding:'2px 4px',
        background:'#ffcc99',
        marginLeft:'10px'   });
    $('#dica').focus(function() {
      $(this).next().fadeIn(1500);       
      })
    .blur(function(){
      $(this).next().fadeOut(1500);
      });
    }); 
  </script>
  <script>
    function SomenteNumero(e){
      var tecla_digitada=(window.event)?event.keyCode:e.which;   
      if ((tecla_digitada>47 && tecla_digitada<58)) return true;
      else{
        if (tecla_digitada==8 || tecla_digitada==0) return true;
      else  return false;
      }
    }
  </script>
</head>
<body>
  <?php include("navbar.php") ?>
  <div class="container">
    <div class="row col-md-12">
      <div class="page-header">
      <div style='text-align:center'>  
      <h2 class='text-white bg-primary shadow-lg rounded'><br> Formulário de Cadastro <br><br></h2>
           </div>
        </div>
        <br/>
        <br/>
        <form class="form-group" action="concluir_cadastro.php" method="post">
          <input type="hidden" name="goto" value="index">
          <label >Nome</label>
          <input type="text" name="nome" id="dica" class="form-control" placeholder="Digite seu nome" value="<?php echo @$_SESSION['nome']?>" required><span>Digite apenas letras</span><br>
          <label>CPF</label>
          <input type="text" name="cpf" class="form-control" value="<?php echo @$_SESSION['cpf'];?>" onKeypress="Mascara_cpf(this); return SomenteNumero(event);" maxlength="14" placeholder="xxx.xxx.xxx-xx" required><br>          
          <div id="address_inputs">
            <label>CEP</label>
            <div class="row">
              <div class="col-md-2">
                <input type="text" v-model="cep" name="cep" id="cep" value="<?php echo @$_SESSION['cep']?>"  class="form-control" placeholder="Digite seu CEP" 
                onKeypress = "Mascara_cep(this); return SomenteNumero(event);" maxlength="9" required>
                <p v-show="erro" class="help-block"><p class="text-danger">
              </div>
              <div class="col-md-2 buttons">
                <button type="button" class="btn btn-success" @click="send($event)">Buscar Endereço</button>
              </div>
            </div>
            <div class="row" style="margin-bottom:30px;">
              <div class="col-md-2">
                <label>Bairro</label>
                <input type="text" name="bairro" v-model="resultado.bairro" id="bairro" class="form-control" value="<?php echo @$_SESSION['bairro']?>"  required>
              </div>
              <div class="col-md-4">
                <label >Rua</label>
                <input type="text" name="rua" v-model="resultado.logradouro" id="lougradouro" class="form-control" value="<?php echo @$_SESSION['rua']?>"  required>
              </div>
              <div class="col-md-2">
                <label>Cidade</label>
                <input type="text" name="cidade" v-model="resultado.localidade" id="cidade" class="form-control" value="<?php echo @$_SESSION['cidade']?>"  required>
              </div>
              <div class="col-md-2">
                <label>Estado</label>
                <input type="text" name="estado" v-model="resultado.uf" id="estado" class="form-control" value="<?php echo @$_SESSION['estado']?>"  required>
              </div>
              <div class="col-md-2">
                <label>Nº</label>
                <input type="text" name="num_casa" class="form-control" id="numero" placeholder="número da casa" value="<?php echo @$_SESSION['num_casa']?>" onKeypress='return SomenteNumero(event)' required>
              </div>
            </div>
          </div>
          <label>Telefone</label>
          <input type="text" name="telefone" class="form-control" maxlength="14" onKeypress="Mascara(this); return SomenteNumero(event);" placeholder="(xx)xxxxx-xxxx" value="<?php echo @$_SESSION['telefone']?>" required><br>
          <label>Email</label>
          <input type="email" name="email" class="form-control" placeholder="Digite seu email" value= "<?php echo @$_SESSION['email']?>" required><br>
          <label>Senha</label>
          <input type="password" name="senha" maxlength="8" class="form-control" placeholder="Digite sua senha" value="<?php echo @$_SESSION['senha']?>" required><br><br>
          <a href="arquivos/lei.pdf" download="">Política de Privacidade</a>
          <div class="checkbox">
            <label>
            <input type="checkbox" name="accept_terms" required>
            <strong>Declaro que li e aceito os termos da Lei Geral de Proteção de Dados Pessoais, Lei nº 13.709/2018</strong>
            </label>
          </div>
          <div class="checkbox" style="margin-bottom: 48px">
            <label>
              <input type="checkbox" name="accept_email">
              <strong>Autorizo o S.O.S Universitário a me enviar e-mails</strong>
            </label>
          </div>
          <p class="text-center">
            <input type="submit" value="Cadastrar" class="btn btn-primary" >
            <input type="reset" class="btn-danger btn" value="Limpar">
          </p>
          </form>
      </div>
    </div>
  </div>
  <script src="js/main.js"></script>
  <?php include ('rodape.php');?>
</body>
</html>

