package app.controllers.produto;

import app.models.dtos.produto.PostProdutoDTO;
import app.models.repository.ProdutoRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static app.utils.JsonToPOJO.toMap;

public class PostProdutoController {
    private static final String MENSAGEM_CADASTRO_SUCESSO = "Cadastro Realizado Com Sucesso!";
    private static final String MENSAGEM_ERRO_CADASTRO = "Não Foi Possível Realizar o Cadastro";
    private static final Logger LOGGER = Logger.getLogger(PostProdutoController.class.getName());
    private final ProdutoRepository produtoRepository = new ProdutoRepository();

    public final Route postProduto = (Request request, Response response) -> {

        PostProdutoDTO postProdutoDTO = new PostProdutoDTO(toMap(request));

        try {
            produtoRepository.insertProduto(postProdutoDTO);
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
