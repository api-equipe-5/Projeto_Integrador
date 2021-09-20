package app.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Categoria {
    private final Integer id;
    private final String descricao;
}
