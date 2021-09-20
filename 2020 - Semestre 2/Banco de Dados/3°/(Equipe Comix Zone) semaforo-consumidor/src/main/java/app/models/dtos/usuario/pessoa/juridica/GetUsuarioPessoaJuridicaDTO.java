package app.models.dtos.usuario.pessoa.juridica;

import app.models.entities.UsuarioPessoaJuridica;
import lombok.Getter;

@Getter
public class GetUsuarioPessoaJuridicaDTO {
    private final String cnpj;
    private final String email;
    private final String celular;
    private final String cidade;
    private final String estado;

    @Override
    public String toString() {
        return "{" +
                "'cnpj': '" + cnpj + "'," +
                "'email': '" + email + "'," +
                "'celular': '" + celular + "'," +
                "'cidade': '" + cidade + "'," +
                "'estado': '" + estado + "'" +
                '}';
    }

    public GetUsuarioPessoaJuridicaDTO(UsuarioPessoaJuridica usuarioPessoaJuridica) {
        this.cnpj = usuarioPessoaJuridica.getCnpj();
        this.email = usuarioPessoaJuridica.getEmail();
        this.celular = usuarioPessoaJuridica.getCelular();
        this.cidade = usuarioPessoaJuridica.getCidade();
        this.estado = usuarioPessoaJuridica.getEstado();
    }
}
