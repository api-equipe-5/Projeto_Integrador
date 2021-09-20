package app.models.dtos.login;

import lombok.Getter;

import java.util.Map;

@Getter
public class PostLoginDTO {
    private final String doc_cli;
    private final String senha;

    public PostLoginDTO(Map<String, String> params) {
        this.doc_cli = params.get("doc_cli");
        this.senha = params.get("senha");
    }
}
