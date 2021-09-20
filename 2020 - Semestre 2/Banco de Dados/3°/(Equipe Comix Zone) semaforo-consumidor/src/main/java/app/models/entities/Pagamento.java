package app.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@Getter
public class Pagamento {
    private final Integer id;
    private final String cpf;
    private final Integer idFonte;
    private final Long numeroContrato;
    private final Date dataVencimentoParcela;
    private final Date dataPagamentoParcela;
    private final BigDecimal valorPago;
    private final String codigoModalidade;
}
