package app.controllers.produto;

import app.models.entities.Produto;
import app.models.repository.ProdutoRepository;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

public class GetProdutosController {
    private static final Logger LOGGER = Logger.getLogger(GetProdutosController.class.getName());
    private static final String MENSAGEM_ERRO_CNPJ = "CNPJ Não Foi Encontrado";
    private static final String MENSAGEM_ERRO_CATEGORIA = "Categoria Não Foi Encontrada";

    private final ProdutoRepository produtoRepository = new ProdutoRepository();

    public final Route getProdutosPorCNPJ = (Request request, Response response) -> {
        try {
            String cnpj = request.params(":doc_cli");
            List<Produto> produtos = produtoRepository.selectDesejosPorCNPJ(cnpj);
            response.status(200);
            Gson gson = new Gson();
            return gson.toJson(produtos);
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, e.getMessage());
            response.status(404);
            response.body(MENSAGEM_ERRO_CNPJ);
            return response.body();
        }
    };

    public final Route getProdutosPorCategoria = (Request request, Response response) -> {
        try {
            Integer idCategoria = parseInt(request.params(":idCategoria"));
            List<Produto> produtos = produtoRepository.selectDesejosPorCategoria(idCategoria);
            response.status(200);
            Gson gson = new Gson();
            return gson.toJson(produtos);
        } catch (SQLException e) {
            LOGGER.log(Level.INFO, e.getMessage());
            response.status(404);
            response.body(MENSAGEM_ERRO_CATEGORIA);
            return response.body();
        }
    };
}
