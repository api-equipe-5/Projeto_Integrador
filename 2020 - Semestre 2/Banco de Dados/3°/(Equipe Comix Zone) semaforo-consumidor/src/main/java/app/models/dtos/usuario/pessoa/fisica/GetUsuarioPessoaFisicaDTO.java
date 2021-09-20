package app.models.dtos.usuario.pessoa.fisica;

import app.models.entities.UsuarioPessoaFisica;
import lombok.Getter;

@Getter
public class GetUsuarioPessoaFisicaDTO {
    private final String cpf;
    private final String sexo;
    private final Integer anoNascimento;
    private final String cidade;
    private final String estado;

    @Override
    public String toString() {
        return "{" +
                "'cpf': '" + cpf + "'," +
                "'sexo': '" + sexo + "'," +
                "'anoNascimento': '" + anoNascimento + "'," +
                "'cidade': '" + cidade + "'," +
                "'estado': '" + estado + "'" +
                '}';
    }

    public GetUsuarioPessoaFisicaDTO(UsuarioPessoaFisica usuarioPessoaFisica) {
        cpf = usuarioPessoaFisica.getCpf();
        sexo = usuarioPessoaFisica.getSexo();
        anoNascimento = usuarioPessoaFisica.getAnoNascimento();
        cidade = usuarioPessoaFisica.getCidade();
        estado = usuarioPessoaFisica.getEstado();
    }
}
