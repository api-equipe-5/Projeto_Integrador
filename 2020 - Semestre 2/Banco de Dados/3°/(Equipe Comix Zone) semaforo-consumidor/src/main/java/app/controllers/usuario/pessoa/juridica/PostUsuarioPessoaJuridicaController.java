package app.controllers.usuario.pessoa.juridica;

import app.models.dtos.usuario.pessoa.juridica.PostUsuarioPessoaJuridicaDTO;
import app.models.repository.UsuarioPessoaJuridicaRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static app.utils.JsonToPOJO.toMap;

public class PostUsuarioPessoaJuridicaController {

    private static final String MENSAGEM_SENHAS_DIFERENTES = "Senhas Diferentes";
    private static final String MENSAGEM_CADASTRO_SUCESSO = "Cadastro Realizado Com Sucesso!";
    private static final String MENSAGEM_ERRO_CADASTRO = "Não Foi Possível Realizar o Cadastro";

    private static final Logger LOGGER = Logger.getLogger(PostUsuarioPessoaJuridicaController.class.getName());
    private final UsuarioPessoaJuridicaRepository usuarioPessoaJuridicaRepository = new UsuarioPessoaJuridicaRepository();

    public final Route postUsuarioPessoaJuridica = (Request request, Response response) -> {
        PostUsuarioPessoaJuridicaDTO usuarioPessoaJuridica = new PostUsuarioPessoaJuridicaDTO(toMap(request));

        if(!usuarioPessoaJuridica.getSenha().equals(usuarioPessoaJuridica.getConfirmarSenha())) {
            response.status(400);
            response.body(MENSAGEM_SENHAS_DIFERENTES);
            return response.body();
        }

        try {
            usuarioPessoaJuridicaRepository.insertUsuarioPessoaJuridica(usuarioPessoaJuridica);
            response.status(201);
            response.body(MENSAGEM_CADASTRO_SUCESSO);
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, e.getMessage());
            response.status(500);
            response.body(MENSAGEM_ERRO_CADASTRO);
        }

        return response.body();
    };
}
