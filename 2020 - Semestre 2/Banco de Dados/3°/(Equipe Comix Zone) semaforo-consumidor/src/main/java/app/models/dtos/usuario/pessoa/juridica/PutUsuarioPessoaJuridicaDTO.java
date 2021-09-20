package app.models.dtos.usuario.pessoa.juridica;

import lombok.Getter;

import java.util.Map;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

@Getter
public class PutUsuarioPessoaJuridicaDTO {
    private final String cnpj;
    private final String email;
    private final String celular;
    private final String cidade;
    private final String estado;
    private final String senhaAntiga;
    private final String senhaNova;
    private final String confirmarSenhaNova;

    public PutUsuarioPessoaJuridicaDTO(Map<String, String> params) {
        this.cnpj = params.get("cnpj");
        this.email = params.get("email");
        this.celular = params.get("celular");
        this.cidade = params.get("cidade");
        this.estado = params.get("estado");
        this.senhaAntiga = md5Hex(params.get("senhaAntiga"));
        this.senhaNova = md5Hex(params.get("senhaNova"));
        this.confirmarSenhaNova = md5Hex(params.get("confirmarSenhaNova"));
    }
}
