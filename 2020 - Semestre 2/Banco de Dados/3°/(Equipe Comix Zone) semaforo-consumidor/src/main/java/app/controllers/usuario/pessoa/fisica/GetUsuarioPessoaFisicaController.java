package app.controllers.usuario.pessoa.fisica;

import app.models.dtos.usuario.pessoa.fisica.GetUsuarioPessoaFisicaDTO;
import app.models.repository.UsuarioPessoaFisicaRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetUsuarioPessoaFisicaController {
    private static final Logger LOGGER = Logger.getLogger(GetUsuarioPessoaFisicaController.class.getName());
    private static final String MENSAGEM_ERRO_SELECT = "CPF Não Foi Encontrado";

    private final UsuarioPessoaFisicaRepository usuarioPessoaFisicaRepository = new UsuarioPessoaFisicaRepository();

    public final Route getUsuarioPessoaFisica = (Request request, Response response) -> {
        try {
            GetUsuarioPessoaFisicaDTO usuarioPessoaFisica = new GetUsuarioPessoaFisicaDTO(usuarioPessoaFisicaRepository
                    .selectUsuarioPessoaFisica(request.params(":doc_cli")));
            response.status(200);
            response.body(usuarioPessoaFisica.toString());
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, e.getMessage());
            response.status(404);
            response.body(MENSAGEM_ERRO_SELECT);
        }
        return response.body();
    };
}
