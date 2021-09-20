package br.gov.sp.fatec.spc.pagamento.payload;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = { "statusPagamento" })
@AllArgsConstructor
public class PagamentoData {
    private String statusPagamento;
    private Double percentual;
}
