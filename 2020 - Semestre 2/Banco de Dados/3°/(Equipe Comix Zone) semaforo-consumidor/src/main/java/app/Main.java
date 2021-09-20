package app;

import app.controllers.dados.GetDadosCPFController;
import app.controllers.desejo.GetDesejosController;
import app.controllers.desejo.PostDesejosController;
import app.controllers.listanegra.PostListaNegraController;
import app.controllers.login.PostCPFLoginController;
import app.controllers.produto.GetProdutosController;
import app.controllers.produto.PostProdutoController;
import app.controllers.score.GetScoreController;
import app.controllers.usuario.pessoa.fisica.DeleteUsuarioPessoaFisicaController;
import app.controllers.usuario.pessoa.fisica.GetUsuarioPessoaFisicaController;
import app.controllers.usuario.pessoa.fisica.PostUsuarioPessoaFisicaController;
import app.controllers.usuario.pessoa.fisica.PutUsuarioPessoaFisicaController;
import app.controllers.usuario.pessoa.juridica.DeleteUsuarioPessoaJuridicaController;
import app.controllers.usuario.pessoa.juridica.GetUsuarioPessoaJuridicaController;
import app.controllers.usuario.pessoa.juridica.PostUsuarioPessoaJuridicaController;
import app.controllers.usuario.pessoa.juridica.PutUsuarioPessoaJuridicaController;

import static spark.Spark.*;

public class Main {
    public static final String ORACLE_USER = "system";
    public static final String ORACLE_USER_PASSWORD = "admin";
    public static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";

    private static final String URI_USUARIO_PESSOA_FISICA = "/api/v1/UsuarioPessoaFisica";
    private static final String URI_USUARIO_PESSOA_JURIDICA = "api/v1/UsuarioPessoaJuridica";
    private static final String URI_SCORE = "/api/v1/Score";
    private static final String URI_DADOS_PF = "/api/v1/DadosPF";
    private static final String URI_LISTA_NEGRA = "/api/v1/ListaNegra";
    private static final String URI_LOGIN = "/api/v1/Login";
    private static final String URI_DESEJOS = "/api/v1/Desejos";
    private static final String URI_PRODUTOS = "/api/v1/Produtos";

    private static final String DOC_CLI = "/:doc_cli";
    private static final String ID_CATEGORIA = "/:idCategoria";

    public static void main(String[] args) {
        String projectDir = System.getProperty("user.dir");
        String staticDir = "/src/main/resources/public";
        staticFiles.externalLocation(projectDir + staticDir);

        //CONTROLLERS USUARIO PESSOA FISICA
        PostUsuarioPessoaFisicaController postUsuarioPessoaFisicaController = new PostUsuarioPessoaFisicaController();
        PutUsuarioPessoaFisicaController putUsuarioPessoaFisicaController = new PutUsuarioPessoaFisicaController();
        DeleteUsuarioPessoaFisicaController deleteUsuarioPessoaFisicaController = new DeleteUsuarioPessoaFisicaController();
        GetUsuarioPessoaFisicaController getUsuarioPessoaFisicaController = new GetUsuarioPessoaFisicaController();

        //CONTROLLERS USUARIO PESSOA JURIDICA
        PostUsuarioPessoaJuridicaController postUsuarioPessoaJuridicaController = new PostUsuarioPessoaJuridicaController();
        PutUsuarioPessoaJuridicaController putUsuarioPessoaJuridicaController = new PutUsuarioPessoaJuridicaController();
        DeleteUsuarioPessoaJuridicaController deleteUsuarioPessoaJuridicaController = new DeleteUsuarioPessoaJuridicaController();
        GetUsuarioPessoaJuridicaController getUsuarioPessoaJuridicaController = new GetUsuarioPessoaJuridicaController();

        //CONTROLLER SCORE
        GetScoreController getScoreController = new GetScoreController();

        //CONTROLLER DADOS CPF
        GetDadosCPFController getDadosCPFController = new GetDadosCPFController();

        //CONTROLLER LISTA NEGRA
        PostListaNegraController postListaNegraController = new PostListaNegraController();

        //CONTROLLER LOGIN
        PostCPFLoginController postCPFLoginController = new PostCPFLoginController();

        //CONTROLLERS DESEJO
        GetDesejosController getDesejosController = new GetDesejosController();
        PostDesejosController postDesejosController = new PostDesejosController();

        //CONTROLLERS PRODUTO
        GetProdutosController getProdutosController = new GetProdutosController();
        PostProdutoController postProdutoController = new PostProdutoController();

        // ROTAS
        get("/", (req, res) -> "" );
        //ROTAS API USUARIO PESSOA FISICA
        get(URI_USUARIO_PESSOA_FISICA + DOC_CLI, getUsuarioPessoaFisicaController.getUsuarioPessoaFisica);
        post(URI_USUARIO_PESSOA_FISICA, postUsuarioPessoaFisicaController.postUsuarioPessoaFisica);
        put(URI_USUARIO_PESSOA_FISICA, putUsuarioPessoaFisicaController.putUsuarioPessoaFisica);
        delete(URI_USUARIO_PESSOA_FISICA + DOC_CLI, deleteUsuarioPessoaFisicaController.deleteUsuarioPessoaFisica);
        //ROTAS API USUARIO PESSOA JURIDICA
        get(URI_USUARIO_PESSOA_JURIDICA + DOC_CLI, getUsuarioPessoaJuridicaController.getUsuarioPessoaJuridica);
        post(URI_USUARIO_PESSOA_JURIDICA, postUsuarioPessoaJuridicaController.postUsuarioPessoaJuridica);
        put(URI_USUARIO_PESSOA_JURIDICA, putUsuarioPessoaJuridicaController.putUsuarioPessoaJuridica);
        delete(URI_USUARIO_PESSOA_JURIDICA + DOC_CLI, deleteUsuarioPessoaJuridicaController.deleteUsuarioPessoaJuridica);
        //ROTAS API LISTA NEGRA
        post(URI_LISTA_NEGRA, postListaNegraController.postListaNegra);
        //ROTA API SCORE
        //FAKE POR ENQUANTO
        get(URI_SCORE + DOC_CLI, getScoreController.getScore);
        //ROTA API DADOS PF
        get(URI_DADOS_PF + DOC_CLI, getDadosCPFController.getDadosCPF);
        //ROTA LOGIN
        post(URI_LOGIN, postCPFLoginController.postCPFLogin);
        //ROTAS DESEJOS
        get(URI_DESEJOS + DOC_CLI, getDesejosController.getDesejos);
        post(URI_DESEJOS, postDesejosController.postDesejos);
        //ROTAS PRODUTOS
        get(URI_PRODUTOS + "/CNPJ" + DOC_CLI, getProdutosController.getProdutosPorCNPJ);
        get(URI_PRODUTOS + "/Categoria" + ID_CATEGORIA, getProdutosController.getProdutosPorCategoria);
        post(URI_PRODUTOS, postProdutoController.postProduto);
    }
}