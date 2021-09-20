package app.models.dtos.getdadoscpf;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class GetDadosCPFResponseDTO {
    private final String cpf;
    private final String sexo;
    private final Integer anoNascimento;
    private final String cidade;
    private final String estado;
    private final List<GetDadosCPFOperacaoDTO> operacoes;

    @Override
    public String toString() {
        return "{" +
                "cpf='" + cpf + '\'' +
                ", sexo='" + sexo + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", operacoes=" + operacoes +
                '}';
    }
}
