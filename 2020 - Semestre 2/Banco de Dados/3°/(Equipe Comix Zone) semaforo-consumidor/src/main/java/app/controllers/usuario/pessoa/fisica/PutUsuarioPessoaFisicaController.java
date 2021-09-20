package app.controllers.usuario.pessoa.fisica;

import app.models.dtos.usuario.pessoa.fisica.PutUsuarioPessoaFisicaDTO;
import app.models.repository.UsuarioPessoaFisicaRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static app.utils.JsonToPOJO.toMap;

public class PutUsuarioPessoaFisicaController {
    private static final Logger LOGGER = Logger.getLogger(PutUsuarioPessoaFisicaController.class.getName());
    private static final String MENSAGEM_ERRO_UPDATE = "Não Foi Possível Realizar a Edição";
    private static final String MENSAGEM_SUCESSO_UPDATE = "Edição Realizada com Sucesso";
    private static final String MENSAGEM_SENHA_INCORRETA = "Senha Incorreta";

    private final UsuarioPessoaFisicaRepository usuarioPessoaFisicaRepository = new UsuarioPessoaFisicaRepository();

    public final Route putUsuarioPessoaFisica = (Request request, Response response) -> {
        PutUsuarioPessoaFisicaDTO usuarioPessoaFisica = new PutUsuarioPessoaFisicaDTO(toMap(request));
        if(usuarioPessoaFisicaRepository.selectUsuarioPessoaFisica(usuarioPessoaFisica.getCpf()).getSenha()
                .equals(usuarioPessoaFisica.getSenhaAntiga())) {
            try {
                usuarioPessoaFisicaRepository.updateUsuarioPessoaFisica(usuarioPessoaFisica);
                response.status(200);
                response.body(MENSAGEM_SUCESSO_UPDATE);
            } catch (SQLException e) {
                LOGGER.log(Level.INFO, e.getMessage());
                response.status(500);
                response.body(MENSAGEM_ERRO_UPDATE);
            }
        } else {
            response.status(400);
            response.body(MENSAGEM_SENHA_INCORRETA);
        }
        return response.body();
    };
}
