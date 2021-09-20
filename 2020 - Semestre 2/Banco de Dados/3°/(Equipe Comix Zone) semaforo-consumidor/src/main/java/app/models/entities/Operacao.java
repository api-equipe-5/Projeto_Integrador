package app.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@Getter
public class Operacao {
    private final Integer id;
    private final String cpf;
    private final Long numeroContrato;
    private final Integer idModalidade;
    private final String codigoModalidade;
    private final Integer quantidadeParcelasContrato;
    private final Date dataContrato;
    private final Date dataVencimentoUltimaParcela;
    private final Date dataVencimento;
    private final BigDecimal valorTotalContratadoParcelado;
    private final BigDecimal valorTotalContratadoConsorcio;
    private final BigDecimal valorSaldoDevedor;
}
