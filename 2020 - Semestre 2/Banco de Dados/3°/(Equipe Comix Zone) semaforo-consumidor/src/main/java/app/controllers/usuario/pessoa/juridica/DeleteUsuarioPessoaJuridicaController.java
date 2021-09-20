package app.controllers.usuario.pessoa.juridica;

import app.models.repository.UsuarioPessoaJuridicaRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteUsuarioPessoaJuridicaController {
    private static final Logger LOGGER = Logger.getLogger(DeleteUsuarioPessoaJuridicaController.class.getName());
    private static final String MENSAGEM_ERRO_DELETE = "Não Foi Possível Deletar os Registros";
    private static final String MENSAGEM_SUCESSO_DELETE = "O Registro foi Deletado com Sucesso";

    UsuarioPessoaJuridicaRepository usuarioPessoaJuridicaRepository = new UsuarioPessoaJuridicaRepository();

    public final Route deleteUsuarioPessoaJuridica = (Request request, Response response) -> {
        try {
            usuarioPessoaJuridicaRepository.deleteUsuarioPessoaJuridica(request.params(":doc_cli"));
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
