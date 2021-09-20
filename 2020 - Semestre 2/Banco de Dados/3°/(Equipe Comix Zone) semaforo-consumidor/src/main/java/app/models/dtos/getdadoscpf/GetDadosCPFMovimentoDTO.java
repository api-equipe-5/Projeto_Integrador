package app.models.dtos.getdadoscpf;

import app.models.entities.Pagamento;
import lombok.Builder;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Builder
public class GetDadosCPFMovimentoDTO {
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
    private final List<Pagamento> pagamentos;

    @Override
    public String toString() {
        return "GetDadosCPFMovimento{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", idFonte=" + idFonte +
                ", numeroContrato=" + numeroContrato +
                ", dataVencimentoParcela=" + dataVencimentoParcela +
                ", quantidadeParcelasVencer=" + quantidadeParcelasVencer +
                ", quantidadeParcelasPagar=" + quantidadeParcelasPagar +
                ", valorTotalFatura=" + valorTotalFatura +
                ", valorMinimoFatura=" + valorMinimoFatura +
                ", valorParcela=" + valorParcela +
                ", tipoMovimento='" + tipoMovimento + '\'' +
                ", periodicidade='" + periodicidade + '\'' +
                ", pagamentos=" + pagamentos +
                '}';
    }
}
