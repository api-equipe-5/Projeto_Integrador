package app.controllers.desejo;

import app.models.dtos.desejo.GetDesejoResponseDTO;
import app.models.entities.Categoria;
import app.models.entities.Desejo;
import app.models.repository.CategoriaRepository;
import app.models.repository.DesejoRepository;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetDesejosController {
    private static final Logger LOGGER = Logger.getLogger(GetDesejosController.class.getName());
    private static final String MENSAGEM_ERRO_SELECT = "CPF Não Foi Encontrado";

    private final DesejoRepository desejoRepository = new DesejoRepository();
    private final CategoriaRepository categoriaRepository = new CategoriaRepository();

    public final Route getDesejos = (Request request, Response response) -> {
        try {
            String cpf = request.params(":doc_cli");
            List<Categoria> categorias = categoriaRepository.selectCategorias();
            List<Desejo> desejos = desejoRepository.selectDesejos(cpf);
            response.status(200);
            List<Categoria> categoriaResponse = new ArrayList<>();
            for (Desejo desejo : desejos) {
                for (Categoria c : categorias) {
                    if (c.getId().equals(desejo.getIdCategoria())) {
                        categoriaResponse.add(c);
                    }
                }
            }
            GetDesejoResponseDTO getDesejoResponseDTO = new GetDesejoResponseDTO(cpf, categoriaResponse);
            Gson gson = new Gson();
            return gson.toJson(getDesejoResponseDTO);
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, e.getMessage());
            response.status(404);
            response.body(MENSAGEM_ERRO_SELECT);
            return response.body();
        }
    };
}
