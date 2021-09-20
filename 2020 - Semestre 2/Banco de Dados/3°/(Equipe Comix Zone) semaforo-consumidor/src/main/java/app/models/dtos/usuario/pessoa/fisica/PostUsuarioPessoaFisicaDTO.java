package app.models.dtos.usuario.pessoa.fisica;

import lombok.Getter;

import java.util.Map;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

@Getter
public class PostUsuarioPessoaFisicaDTO {
    private final String cpf;
    private final Integer anoNascimento;
    private final String sexo;
    private final String cidade;
    private final String estado;
    private final String senha;
    private final String confirmarSenha;

    public PostUsuarioPessoaFisicaDTO(Map<String, String> params) {
        this.cpf = params.get("cpf");
        this.anoNascimento = Integer.valueOf(params.get("anoNascimento"));
        this.sexo = params.get("sexo");
        this.cidade = params.get("cidade");
        this.estado = params.get("estado");
        this.senha = md5Hex(params.get("senha"));
        this.confirmarSenha = md5Hex(params.get("confirmarSenha"));
    }
}
