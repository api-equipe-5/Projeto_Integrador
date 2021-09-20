package app.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@Getter
public class Movimento {
    private final Integer id;
    private final String cpf;
    private final Integer idFonte;
    private final Long numeroContrato;
    private final Date dataVencimentoParcela;
    private final Integer quantidadeParcelasVencer;
    private final Integer quantidadeParcelasPagar;
    private final BigDecimal valorTotalFatura;
    private final BigDecimal valorMinimoFatura;
    private final BigDecimal valorParcela;
    private final String tipoMovimento;
    private final String periodicidade;
}
