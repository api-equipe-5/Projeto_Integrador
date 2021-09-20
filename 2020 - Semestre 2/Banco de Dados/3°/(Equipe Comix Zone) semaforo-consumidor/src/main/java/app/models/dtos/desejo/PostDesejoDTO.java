package app.models.dtos.desejo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class PostDesejoDTO {
    private final String cpf;
    private final List<Integer> idDesejosList;

    public PostDesejoDTO(Map<String, String> params) {
        this.cpf = params.get("cpf");
        this.idDesejosList = Arrays.stream(params.get("idDesejosList")
                .replace("[", "")
                .replace("]","")
                .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
