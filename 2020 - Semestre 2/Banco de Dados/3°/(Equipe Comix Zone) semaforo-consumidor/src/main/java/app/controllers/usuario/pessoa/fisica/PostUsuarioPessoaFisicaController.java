package app.controllers.usuario.pessoa.fisica;

import app.models.dtos.usuario.pessoa.fisica.PostUsuarioPessoaFisicaDTO;
import app.models.repository.PessoaFisicaRepository;
import app.models.repository.UsuarioPessoaFisicaRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static app.utils.JsonToPOJO.toMap;

public class PostUsuarioPessoaFisicaController {

    private static final String MENSAGEM_SENHAS_DIFERENTES = "Senhas Diferentes";
    private static final String MENSAGEM_CADASTRO_SUCESSO = "Cadastro Realizado Com Sucesso!";
    private static final String MENSAGEM_ERRO_CADASTRO = "Não Foi Possível Realizar o Cadastro";
    private static final String MENSAGEM_CPF_NAO_ENCONTRADO = "CPF Não Encontrado";
    private static final Logger LOGGER = Logger.getLogger(PostUsuarioPessoaFisicaController.class.getName());
    private final PessoaFisicaRepository pessoaFisicaRepository = new PessoaFisicaRepository();
    private final UsuarioPessoaFisicaRepository usuarioPessoaFisicaRepository = new UsuarioPessoaFisicaRepository();

    public final Route postUsuarioPessoaFisica = (Request request, Response response) -> {

        PostUsuarioPessoaFisicaDTO novoCadastro = new PostUsuarioPessoaFisicaDTO(toMap(request));

        if(!novoCadastro.getSenha().equals(novoCadastro.getConfirmarSenha())) {
            response.status(400);
            response.body(MENSAGEM_SENHAS_DIFERENTES);
            return response.body();
        }

        if(pessoaFisicaRepository.selectPessoaFisicaPorCPF(novoCadastro.getCpf()) != null) {
            try {
                usuarioPessoaFisicaRepository.insertUsuarioPessoaFisica(novoCadastro);
                response.status(201);
                response.body(MENSAGEM_CADASTRO_SUCESSO);
            } catch (SQLException e) {
                LOGGER.log(Level.INFO, e.getMessage());
                response.status(500);
                response.body(MENSAGEM_ERRO_CADASTRO);
            }
        } else {
            response.status(404);
            response.body(MENSAGEM_CPF_NAO_ENCONTRADO);
        }
        return response.body();
    };
}
