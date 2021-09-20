<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="icon" href="../Home/imagem/Vó-logo.png">
  <link rel="stylesheet" type="text/css" href="/Administrador/css/relatorio.css" media="screen">
  <link rel="stylesheet" type="text/css" href="../Administrador/css/admin_header.css">
  <link href="https://fonts.googleapis.com/css2?family=Cabin+Sketch:wght@400;700&display=swap" rel="stylesheet">

  <title>Admin Dados</title>
  <script type="text/javascript">
    var onloadCallback = function() {
      grecaptcha.render('html_element', {
        'sitekey': ' 6Lesd6caAAAAAOMb_uTxoAGkr7TS8bmKGJ31tc8S '
      });
    };
  </script>
</head>

<body class="fundo">
  <?php
  $botao_esquerdo['texto'] = "Voltar";
  $botao_esquerdo['action'] = "../Administrador/index.php";
  $botao_direito["css"] = "hidden";
  $welcome["css"] = "welcome-voltar";
  include('../Administrador/admin_header.php'); //não remover, faz parte do admin!
  ?>
  <header class="back">
    <section class="man">
      <h1 class="titu">Projetos</h1>
      <div class="formm">
        <form method="POST">
          <label class="ordernar">Ordenar por:</label>
          <input type="submit" name='id' value="Data de Inscrição" />
          <input type="submit" name='id' value="Ordem Alfabetica (A-Z)" />
        </form>
      </div>
      <br>
      <table class="tabela">
        <tr>
          <th>ID</th>
          <th>Nome Empreendedor</th>
          <th>Nome Empresa</th>
          <th>CPF/CNPJ</th>
          <th>E-mail</th>
          <th>Telefone</th>
          <th>Celular</th>
          <th>Cidade</th>
          <th>Estado</th>
          <th>Pessoa fis/jur</th>
          <th>Rede_Social</th>
          <th>Youtube</th>
          <th>Outros</th>
          <th>Descricao do Projeto</th>
        </tr>

        <?php #Comando para que o botao escolha entre as alternativas de ORDEM
        $ordem_projetos = isset($_POST['id']) ? $_POST['id'] : "Data de Inscrição";
        switch ($ordem_projetos) {
          case "Data de Inscrição":
            $sql_projeto = 'SELECT * FROM tb_projetos  GROUP by cpf ORDER BY id';
            break;
          case "Ordem Alfabetica (A-Z)":
            $sql_projeto = 'SELECT * FROM tb_projetos  GROUP by cpf ORDER BY nome';
            break;
        }
        ?>
        <?php
        $conexao = mysqli_connect("localhost", "root", "", "bd_projetos"); #conexao com o banco de dados voluntarios
        $consultas_projeto = mysqli_query($conexao, $sql_projeto);
        ?>

        <?php while ($dados_projetos = $consultas_projeto->fetch_array()) { ?>
          <tr>
            <td><?php echo $dados_projetos['id']; ?></td>
            <td><?php echo $dados_projetos['nome']; ?></td>
            <td><?php echo $dados_projetos['nome_empresa']; ?></td>
            <td><?php echo $dados_projetos['cpf']; ?></td>
            <td><?php echo $dados_projetos['email']; ?></td>
            <td><?php echo $dados_projetos['tel_number']; ?></td>
            <td><?php echo $dados_projetos['celular']; ?></td>
            <td><?php echo $dados_projetos['cidade']; ?></td>
            <td><?php echo $dados_projetos['estado']; ?></td>
            <td><?php echo $dados_projetos['fisica_juridica']; ?></td>
            <td><?php echo $dados_projetos['redesocial']; ?></td>
            <td><?php echo $dados_projetos['youtube']; ?></td>
            <td><?php echo $dados_projetos['outros']; ?></td>
            <td><?php echo $dados_projetos['descricao']; ?></td>
            </td>
          </tr>
        <?php } ?>
      </table>
      <br>

      <h1 class="titu">Participantes</h1>
      <br>

      <table class="tabela">
        <tr>
          <th>ID</th>
          <th>Nome</th>
          <th>Nome_Pai</th>
          <th>Nascimento</th>
          <th>Nome_Mae</tdh>
          <th>CPF</th>
          <th>Telefone</th>
          <th>Celular</th>
          <th>E-mail</th>
          <th>Rede_Social</th>
          <th>Youtube</th>
          <th>Outros</th>
          <th>Especifique</th>

        </tr>

        <?php #Comando para que o botao escolha entre as alternativas de ORDEM
        $ordem_participantes = isset($_POST['id']) ? $_POST['id'] : "Data de Inscrição";
        switch ($ordem_participantes) {
          case "Data de Inscrição":
            $sql_participantes = 'SELECT * FROM tb_participantes WHERE nascimento BETWEEN "2015-01-01" AND "2021-12-31" GROUP by cpf ORDER BY id';
            break;
          case "Ordem Alfabetica (A-Z)":
            $sql_participantes = 'SELECT * FROM tb_participantes WHERE nascimento BETWEEN "2015-01-01" AND "2021-12-31" GROUP by cpf ORDER BY nome';
            break;
        }
        ?>

        <?php
        $conexao = mysqli_connect("localhost", "root", "", "bd_participantes"); #conexao com o banco de dados participantes
        $consulta_participantes = mysqli_query($conexao, $sql_participantes);
        ?>

        <?php while ($dados_participantes = $consulta_participantes->fetch_array()) {  ?>
          <tr>
            <td><?php echo $dados_participantes['id']; ?></td>
            <td><?php echo $dados_participantes['nome']; ?></td>
            <td><?php echo $dados_participantes['nome_pai']; ?></td>
            <td><?php echo $dados_participantes['nascimento']; ?></td>
            <td><?php echo $dados_participantes['nome_mae']; ?></td>
            <td><?php echo $dados_participantes['cpf']; ?></td>
            <td><?php echo $dados_participantes['tel_number']; ?></td>
            <td><?php echo $dados_participantes['celular']; ?></td>
            <td><?php echo $dados_participantes['email']; ?></td>
            <td><?php echo $dados_participantes['redesocial']; ?></td>
            <td><?php echo $dados_participantes['youtube']; ?></td>
            <td><?php echo $dados_participantes['outros']; ?></td>
            <td><?php echo $dados_participantes['especifique']; ?></td>
            </td>
          </tr>
        <?php } ?>
      </table>
      <br>

      <h1 class="titu">Voluntários</h1>
      <br>
      <table class="tabela">
        <tr>
          <th>ID</th>
          <th>Nome</th>
          <th>Nascimento</th>
          <th>CPF</th>
          <th>RG</th>
          <th>Telefone</th>
          <th>Celular</th>
          <th>E-mail</th>
          <th>Voluntario</th>
          <th>Rede_Social</th>
          <th>Youtube</th>
          <th>Outros</th>
          <th>Especialidade</th>
        </tr>
        <?php #Comando para que o botao escolha entre as alternativas de ORDEM
        $ordem_voluntarios = isset($_POST['id']) ? $_POST['id'] : "Data de Inscrição";
        switch ($ordem_voluntarios) {
          case "Data de Inscrição":
            $sql_voluntario = 'SELECT * FROM tb_voluntario  GROUP by cpf ORDER BY id';
            break;
          case "Ordem Alfabetica (A-Z)":
            $sql_voluntario = 'SELECT * FROM tb_voluntario  GROUP by cpf ORDER BY nome';
            break;
        }
        ?>
        <?php
        $conexao = mysqli_connect("localhost", "root", "", "bd_voluntario"); #conexao com o banco de dados voluntarios
        $consultas_voluntario = mysqli_query($conexao, $sql_voluntario)
        ?>

        <?php while ($dados_voluntario = $consultas_voluntario->fetch_array()) { ?>
          <tr>
            <td><?php echo $dados_voluntario['id']; ?></td>
            <td><?php echo $dados_voluntario['nome']; ?></td>
            <td><?php echo $dados_voluntario['nascimento']; ?></td>
            <td><?php echo $dados_voluntario['cpf']; ?></td>
            <td><?php echo $dados_voluntario['rg']; ?></td>
            <td><?php echo $dados_voluntario['tel_number']; ?></td>
            <td><?php echo $dados_voluntario['celular']; ?></td>
            <td><?php echo $dados_voluntario['email']; ?></td>
            <td><?php echo $dados_voluntario['voluntario']; ?></td>
            <td><?php echo $dados_voluntario['redesocial']; ?></td>
            <td><?php echo $dados_voluntario['youtube']; ?></td>
            <td><?php echo $dados_voluntario['outros']; ?></td>
            <td><?php echo $dados_voluntario['especialidade']; ?></td>
            </td>
          </tr>
        <?php } ?>
      </table>
      <br>

      <h1 class="titu">Doações</h1>
      <br>
      <table class="tabela">
        <tr>
          <th>ID</th>
          <th>Nome</th>
          <th>CPF</th>
          <th>Telefone</th>
          <th>Celular</th>
          <th>Endereco</th>
          <th>Doador</th>
        </tr>

        <?php #Comando para que o botao escolha entre as alternativas de ORDEM
        $ordem_doaçoes = isset($_POST['id']) ? $_POST['id'] : "Data de Inscrição";
        switch ($ordem_doaçoes) {
          case "Data de Inscrição":
            $sql_doacao = 'SELECT * FROM tb_doacao GROUP by cpf ORDER BY id';
            break;
          case "Ordem Alfabetica (A-Z)":
            $sql_doacao = 'SELECT * FROM tb_doacao GROUP by cpf ORDER BY nome';
            break;
        }
        ?>
        <?php
        $conexao = mysqli_connect("localhost", "root", "", "bd_doacao"); #conexao com o banco de dados doaçao
        $consulta_doacao = mysqli_query($conexao, $sql_doacao)
        ?>

        <?php while ($dado_doacao = $consulta_doacao->fetch_array()) { ?>
          <tr>
            <td><?php echo $dado_doacao['id']; ?></td>
            <td><?php echo $dado_doacao['nome']; ?></td>
            <td><?php echo $dado_doacao['cpf']; ?></td>
            <td><?php echo $dado_doacao['tel_number']; ?></td>
            <td><?php echo $dado_doacao['celular']; ?></td>
            <td><?php echo $dado_doacao['endereco']; ?></td>
            <td><?php echo $dado_doacao['anonimo']; ?></td>
            </td>
          </tr>
        <?php } ?>
      </table>
      <br>

      <h1 class="titu">Contato</h1>
      <br>
      <table class="tabela">
        <tr>
          <th>ID</th>
          <th>Nome</th>
          <th>Telefone</th>
          <th>E-mail</th>
          <th>Descrição</th>
        </tr>

        <?php #Comando para que o botao escolha entre as alternativas de ORDEM
        $ordem_contato = isset($_POST['id']) ? $_POST['id'] : "Data de Inscrição";
        switch ($ordem_contato) {
          case "Data de Inscrição":
            $sql_contato = 'SELECT * FROM tb_contato  GROUP by nome ORDER BY id';
            break;
          case "Ordem Alfabetica (A-Z)":
            $sql_contato = 'SELECT * FROM tb_contato  GROUP by nome ORDER BY nome';
            break;
        }
        ?>
        <?php
        $conexao = mysqli_connect("localhost", "root", "", "bd_contato"); #conexao com o banco de dados voluntarios
        $consultas_contato = mysqli_query($conexao, $sql_contato)
        ?>

        <?php while ($dados_contato = $consultas_contato->fetch_array()) { ?>
          <tr>
            <td><?php echo $dados_contato['id']; ?></td>
            <td><?php echo $dados_contato['nome']; ?></td>
            <td><?php echo $dados_contato['telefone']; ?></td>
            <td><?php echo $dados_contato['email']; ?></td>
            <td><?php echo $dados_contato['descricao']; ?></td>
            </td>
          </tr>
        <?php } ?>
      </table>
    </section>

    <!--<script>
          function share(){
              if (navigator.share !== undefined) {
                  navigator.share({
                      title: 'Maria Vó Félix',
                      text: 'Um texto de resumo',
                      url: 'https://www.facebook.com/fatecjessenvidal/',
                  })
                      .then(() => console.log('Successful share'))
                      .catch((error) => console.log('Error sharing', error));
                  }
              }
      </script>

      <script>

          var el = document.querySelector('.menu-mobile-icon');

          el.addEventListener('click',()=>{
              //Queremos mostrar o menu.
              var menuItens = document.querySelector('.menu-itens');
              if(menuItens.classList.contains('show')){
                  menuItens.classList.add('hide'); 
                  menuItens.classList.remove('show'); 
              }else{
                  menuItens.classList.add('show'); 
                  menuItens.classList.remove('hide'); 
              }       
          });
      </script>-->

    <div class="footer">
      <div class="xtreme">by Equipe Xtreme <br>github.com/Xtreme-Equipe</div> 
    </div>
</body>

</html>