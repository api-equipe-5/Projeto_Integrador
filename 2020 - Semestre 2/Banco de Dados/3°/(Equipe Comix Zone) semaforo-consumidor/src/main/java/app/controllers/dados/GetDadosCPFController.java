package app.controllers.dados;

import app.models.dtos.getdadoscpf.GetDadosCPFResponseDTO;
import app.models.dtos.listanegra.ListaNegraDTO;
import app.models.repository.DadosCPFRepository;
import app.models.repository.ListaNegraRepository;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetDadosCPFController {
    private static final Logger LOGGER = Logger.getLogger(GetDadosCPFController.class.getName());
    private static final String MENSAGEM_ERRO_SELECT = "CPF Não Foi Encontrado";
    private static final String MENSAGEM_NAO_AUTORIZADO = "Usuario Não Autorizado";

    private final DadosCPFRepository dadosCPFRepository = new DadosCPFRepository();
    private final ListaNegraRepository listaNegraRepository = new ListaNegraRepository();

    public final Route getDadosCPF = (Request request, Response response) -> {
        try {
            ListaNegraDTO lista = new ListaNegraDTO(request.params(":doc_cli"), request.session().attribute("doc_cli"));
            if(listaNegraRepository.selectListaNegra(lista) == null) {
                GetDadosCPFResponseDTO getDadosCPFResponse = dadosCPFRepository.getDadosCPFResponse(request.params(":doc_cli"));
                response.status(200);
                Gson gson = new Gson();
                return gson.toJson(getDadosCPFResponse);
            } else {
                response.status(403);
                response.body(MENSAGEM_NAO_AUTORIZADO);
                return response.body();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, e.getMessage());
            response.status(404);
            response.body(MENSAGEM_ERRO_SELECT);
            return response.body();
        }
    };
}
