package app.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Desejo {
    private final String cpf;
    private final Integer idCategoria;
}
