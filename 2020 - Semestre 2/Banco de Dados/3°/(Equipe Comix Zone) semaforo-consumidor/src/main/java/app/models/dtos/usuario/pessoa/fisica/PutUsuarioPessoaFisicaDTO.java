package app.models.dtos.usuario.pessoa.fisica;

import lombok.Getter;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;

@Getter
public class PutUsuarioPessoaFisicaDTO {
    private final String cpf;
    private final Integer anoNascimento;
    private final String sexo;
    private final String cidade;
    private final String estado;
    private final String senhaAntiga;
    private final String senhaNova;
    private final String confirmarSenhaNova;

    public PutUsuarioPessoaFisicaDTO(Map<String, String> params) {
        this.cpf = params.get("cpf");
        this.anoNascimento = Integer.valueOf(params.get("anoNascimento"));
        this.sexo = params.get("sexo");
        this.cidade = params.get("cidade");
        this.estado = params.get("estado");
        this.senhaAntiga = DigestUtils.md5Hex(params.get("senhaAntiga"));
        this.senhaNova = DigestUtils.md5Hex(params.get("senhaNova"));
        this.confirmarSenhaNova = DigestUtils.md5Hex(params.get("confirmarSenhaNova"));
    }
}
