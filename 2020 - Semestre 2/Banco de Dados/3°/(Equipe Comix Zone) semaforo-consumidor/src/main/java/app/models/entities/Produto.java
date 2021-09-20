package app.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Produto {
    private final Integer idCategoria;
    private final String cnpj;
    private final String url;
}
