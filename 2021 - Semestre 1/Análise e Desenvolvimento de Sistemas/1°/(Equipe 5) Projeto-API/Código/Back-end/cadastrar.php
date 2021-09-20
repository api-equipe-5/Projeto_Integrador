<?php
include_once './conexao.php';
?>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="icon" type="image" href="https://www.flaticon.com/authors/pixelmeetup" />
        <title>Vó Maria Felix</title>
        <link rel="stylesheet" type="text/css" href="cadastro de voluntario" media="screen"/>


    </head>
    <body>
        <h1>Cadastrar Voluntarios</h1>
        <?php
        //Receber os dados do formulário
        $dados = filter_input_array(INPUT_POST, FILTER_DEFAULT);

        //Verificar se o usuário clicou no botão
        if (!empty($dados['CadVoluntarios'])) {
            //var_dump($dados);

            $empty_input = false;

            $dados = array_map('trim', $dados);
            if (in_array("", $dados)) {
                $empty_input = true;
                echo "<p style='color: #f00;'>Erro: Necessário preencher todos campos!</p>";
            } elseif (!filter_var($dados['email'], FILTER_VALIDATE_EMAIL)) {
                $empty_input = true;
                echo "<p style='color: #f00;'>Erro: Necessário preencher com e-mail válido!</p>";
            }

            if (!$empty_input) {
                $query_voluntarios = "INSERT INTO voluntarios (nome, cpf, profissao, email, senha, horario, tpVoluntario) VALUES (:nome, :cpf, :profissao, :email, :senha, :horario, :tpVoluntario) ";
                $cad_voluntarios = $conn->prepare($query_voluntarios);
                $cad_voluntarios->bindParam(':nome', $dados['nome'], PDO::PARAM_STR);
                $cad_voluntarios->bindParam(':cpf', $dados['cpf'], PDO::PARAM_STR);
				$cad_voluntarios->bindParam(':profissao', $dados['profissao'], PDO::PARAM_STR);
                $cad_voluntarios->bindParam(':email', $dados['email'], PDO::PARAM_STR);
				$cad_voluntarios->bindParam(':senha', $dados['senha'], PDO::PARAM_STR);
                $cad_voluntarios->bindParam(':horario', $dados['horario'], PDO::PARAM_STR);
                $cad_voluntarios->bindParam(':tpVoluntario', $dados['tpVoluntario'], PDO::PARAM_STR);
                $cad_voluntarios->execute();
                if ($cad_voluntarios->rowCount()) {
                    echo "<p style='color: black;'>Usuário cadastrado com sucesso!</p>";
                    unset($dados);
                } else {
                    echo "<p style='color: #f00;'>Erro: Usuário não cadastrado com sucesso!</p>";
                }
            }
        }
        ?>
       <form name="cad-voluntarios" method="POST" action="" id="formulario">
        <fieldset class="grupo">
        <div class="campo">
            <label for="nome"><strong>Nome Completo:</strong></label>
            <input type="text" name="nome" id="nome" placeholder="Nome completo" value="<?php
            if (isset($dados['nome'])) {
                echo $dados['nome'];
            }
            ?>"></div>
            
            <div class="campo">
			<label><strong>CPF:</strong> </label>
            <input type="text" name="cpf" id="cpf" placeholder="Digite seu CPF" value="<?php
            if (isset($dados['cpf'])) {
                echo $dados['cpf'];
            }
            ?>"></div>
            
            <div class="campo">
			<label><strong>Qual sua profissão?</strong> </label>
            <input type="text" name="profissao" id="profissao" placeholder="Digite sua profissão" value="<?php
            if (isset($dados['profissao'])) {
                echo $dados['profissao'];
            }
            ?>"></div>
            
            <div class="campo">
            <label><strong>E-mail:</strong> </label>
            <input type="email" name="email" id="email" placeholder="Seu e-mail" value="<?php
            if (isset($dados['email'])) {
                echo $dados['email'];
            }
            ?>"></div>
			
            <div class="campo">
			<label><strong>Senha:</strong></label>
            <input type="password" name="senha" id="senha" placeholder="Digite sua senha" value="<?php
            if (isset($dados['senha'])) {
                echo $dados['senha'];
            }
            ?>"></div>
			
            <div class="campo">
			<label><strong>Qual seu horário disponível? </label>
            <input type="text" name="horario" id="horario" placeholder="Digite um período" value="<?php
            if (isset($dados['horario'])) {
                echo $dados['horario'];
            }
            ?>">
            </div>
			
            <div class="campo">
            <label for="tipo"><strong>Tipo de voluntário</strong></label>
            <select type="tipo"  name="tpVoluntario" id="tpVoluntario" required>
                <option value="geral">geral</option>
                <option value="especifico">específico</option>
            </select>
            <?php if(isset($dados['tpVoluntario']))
                echo $dados['tpVoluntario'];  ?>
	      
        
           <div class="campo">
           <button class="botao" type="submit" value="Cadastrar" name="CadVoluntarios">enviar</button>
            </div>
           
            </fieldset>
       </form>
    </body>
</html>
