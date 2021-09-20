package app.controllers.login;

import app.models.dtos.login.PostLoginDTO;
import app.models.entities.UsuarioPessoaFisica;
import app.models.repository.UsuarioPessoaFisicaRepository;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

import static app.utils.JsonToPOJO.toMap;
import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

public class PostCPFLoginController {
    private static final String MENSAGEM_USUARIO_NA0_ENCONTRADO = "Usuario Não Encontrado";
    UsuarioPessoaFisicaRepository usuarioPessoaFisicaRepository = new UsuarioPessoaFisicaRepository();

    public final Route postCPFLogin = (Request request, Response response) -> {
        PostLoginDTO loginDTO = new PostLoginDTO(toMap(request));
        UsuarioPessoaFisica usuarioPessoaFisica = usuarioPessoaFisicaRepository.selectUsuarioPessoaFisica(loginDTO.getDoc_cli());
        if(usuarioPessoaFisica.getSenha().equals(md5Hex(loginDTO.getSenha())))
        {
            request.session(true);
            request.session().attribute("doc_cli", usuarioPessoaFisica.getCpf());
            request.session().attribute("anoNascimento", usuarioPessoaFisica.getAnoNascimento());
            request.session().attribute("cidade", usuarioPessoaFisica.getCidade());
            request.session().attribute("estado", usuarioPessoaFisica.getEstado());
            request.session().attribute("sexo", usuarioPessoaFisica.getSexo());
            request.session().attribute("senha", usuarioPessoaFisica.getSenha());
            Gson gson = new Gson();
            return gson.toJson(usuarioPessoaFisica);
        } else {
            response.status(404);
            response.body(MENSAGEM_USUARIO_NA0_ENCONTRADO);
        }
        return response.body();
    };
}
