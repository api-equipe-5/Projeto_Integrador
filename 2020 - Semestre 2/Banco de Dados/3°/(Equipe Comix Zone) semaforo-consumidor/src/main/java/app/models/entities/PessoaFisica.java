package app.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PessoaFisica {
    private final String cpf;
    private final String sexo;
    private final Integer anoNascimento;
    private final String cidade;
    private final String estado;
}
