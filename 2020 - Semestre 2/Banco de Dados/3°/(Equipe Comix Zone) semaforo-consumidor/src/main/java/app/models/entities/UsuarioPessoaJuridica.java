package app.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioPessoaJuridica {
    private String cnpj;
    private String email;
    private String celular;
    private String cidade;
    private String estado;
    private String senha;
}
