package app.models.dtos.produto;

import lombok.Getter;

import java.util.Map;

import static java.lang.Integer.parseInt;

@Getter
public class PostProdutoDTO {
    private final Integer idCategoria;
    private final String cnpj;
    private final String url;

    public PostProdutoDTO(Map<String, String> params) {
        this.idCategoria = parseInt(params.get("idCategoria"));
        this.cnpj = params.get("cnpj");
        this.url = params.get("url");
    }
}
