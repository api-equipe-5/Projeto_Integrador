package app.controllers.usuario.pessoa.fisica;

import app.models.repository.UsuarioPessoaFisicaRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteUsuarioPessoaFisicaController {
    private static final Logger LOGGER = Logger.getLogger(DeleteUsuarioPessoaFisicaController.class.getName());
    private static final String MENSAGEM_ERRO_DELETE = "Não Foi Possível Deletar os Registros";
    private static final String MENSAGEM_SUCESSO_DELETE = "O Registro foi Deletado com Sucesso";

    private final UsuarioPessoaFisicaRepository usuarioPessoaFisicaRepository = new UsuarioPessoaFisicaRepository();

    public final Route deleteUsuarioPessoaFisica = (Request request, Response response) -> {
        try {
            usuarioPessoaFisicaRepository.deleteUsuarioPessoaFisica(request.params(":doc_cli"));
            response.status(200);
            response.body(MENSAGEM_SUCESSO_DELETE);
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, e.getMessage());
            response.status(500);
            response.body(MENSAGEM_ERRO_DELETE);
        }
        return response.body();
    };
}
