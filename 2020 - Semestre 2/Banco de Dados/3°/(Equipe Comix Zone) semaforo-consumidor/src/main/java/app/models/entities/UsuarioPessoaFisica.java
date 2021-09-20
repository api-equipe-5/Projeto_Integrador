package app.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class UsuarioPessoaFisica {
    private String cpf;
    private String sexo;
    private Integer anoNascimento;
    private String cidade;
    private String estado;
    private String senha;
}
