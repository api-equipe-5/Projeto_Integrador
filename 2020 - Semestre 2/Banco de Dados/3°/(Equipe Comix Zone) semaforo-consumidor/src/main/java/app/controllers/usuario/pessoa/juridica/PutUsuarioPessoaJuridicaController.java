package app.controllers.usuario.pessoa.juridica;

import app.models.dtos.usuario.pessoa.juridica.PutUsuarioPessoaJuridicaDTO;
import app.models.repository.UsuarioPessoaJuridicaRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static app.utils.JsonToPOJO.toMap;

public class PutUsuarioPessoaJuridicaController {
    private static final Logger LOGGER = Logger.getLogger(PutUsuarioPessoaJuridicaController.class.getName());
    private static final String MENSAGEM_ERRO_UPDATE = "Não Foi Possível Realizar a Edição";
    private static final String MENSAGEM_SUCESSO_UPDATE = "Edição Realizada com Sucesso";
    private static final String MENSAGEM_SENHA_INCORRETA = "Senha Incorreta";

    UsuarioPessoaJuridicaRepository usuarioPessoaJuridicaRepository = new UsuarioPessoaJuridicaRepository();

    public final Route putUsuarioPessoaJuridica = (Request request, Response response) -> {
        PutUsuarioPessoaJuridicaDTO usuarioPessoaJuridica = new PutUsuarioPessoaJuridicaDTO(toMap(request));
        if(usuarioPessoaJuridicaRepository.selectUsuarioPessoaJuridica(usuarioPessoaJuridica.getCnpj()).getSenha()
                .equals(usuarioPessoaJuridica.getSenhaAntiga())) {
            try {
                usuarioPessoaJuridicaRepository.updateUsuarioPessoaJuridica(usuarioPessoaJuridica);response.status(200);
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
