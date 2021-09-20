package app.models.dtos.desejo;

import app.models.entities.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class GetDesejoResponseDTO {
    private final String cpf;
    private final List<Categoria> categorias;
}
