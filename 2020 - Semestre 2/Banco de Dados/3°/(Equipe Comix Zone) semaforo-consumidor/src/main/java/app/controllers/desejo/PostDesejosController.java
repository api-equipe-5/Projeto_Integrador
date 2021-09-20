package app.controllers.desejo;

import app.models.dtos.desejo.PostDesejoDTO;
import app.models.repository.DesejoRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static app.utils.JsonToPOJO.toMap;

public class PostDesejosController {
    private static final String MENSAGEM_CADASTRO_SUCESSO = "Cadastro Realizado Com Sucesso!";
    private static final String MENSAGEM_ERRO_CADASTRO = "Não Foi Possível Realizar o Cadastro";
    private static final Logger LOGGER = Logger.getLogger(PostDesejosController.class.getName());
    private final DesejoRepository desejoRepository = new DesejoRepository();

    public final Route postDesejos = (Request request, Response response) -> {

        PostDesejoDTO postDesejoDTO = new PostDesejoDTO(toMap(request));

        try {
            desejoRepository.insertDesejos(postDesejoDTO);
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
