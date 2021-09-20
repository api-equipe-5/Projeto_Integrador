package app.models.dtos.listanegra;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class ListaNegraDTO {
    private final String docCliBloqueador;
    private final String docCliBloqueado;

    public ListaNegraDTO(Map<String, String> params) {
        this.docCliBloqueador = params.get("docCliBloqueador");
        this.docCliBloqueado = params.get("docCliBloqueado");
    }
}
