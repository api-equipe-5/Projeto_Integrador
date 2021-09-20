package app.controllers.listanegra;

import app.models.dtos.listanegra.ListaNegraDTO;
import app.models.repository.ListaNegraRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static app.utils.JsonToPOJO.toMap;

public class PostListaNegraController {
    private static final String MENSAGEM_DOC_CLI_IGUAIS = "Doc Cli Iguais";
    private static final String MENSAGEM_CADASTRO_SUCESSO = "Cadastro Realizado Com Sucesso!";
    private static final String MENSAGEM_ERRO_CADASTRO = "Não Foi Possível Realizar o Cadastro";
    private static final Logger LOGGER = Logger.getLogger(PostListaNegraController.class.getName());
    private final ListaNegraRepository listaNegraRepository = new ListaNegraRepository();

    public final Route postListaNegra = (Request request, Response response) -> {

        ListaNegraDTO novaLista = new ListaNegraDTO(toMap(request));

        if(novaLista.getDocCliBloqueador().equals(novaLista.getDocCliBloqueado())) {
            response.status(400);
            response.body(MENSAGEM_DOC_CLI_IGUAIS);
            return response.body();
        }

        try {
            listaNegraRepository.insertListaNegra(novaLista);
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
