package br.gov.sp.fatec.spc.pagamento.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScorePessoa {
    String pessoaFisica;
    Integer score;
}
