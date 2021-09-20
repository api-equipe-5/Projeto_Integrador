package app.models.dtos.getdadoscpf;

import lombok.Builder;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Builder
public class GetDadosCPFOperacaoDTO {
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
    private final List<GetDadosCPFMovimentoDTO> movimentos;

    @Override
    public String toString() {
        return "GetDadosCPFOperacao{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", numeroContrato=" + numeroContrato +
                ", idModalidade=" + idModalidade +
                ", codigoModalidade='" + codigoModalidade + '\'' +
                ", quantidadeParcelasContrato=" + quantidadeParcelasContrato +
                ", dataContrato=" + dataContrato +
                ", dataVencimentoUltimaParcela=" + dataVencimentoUltimaParcela +
                ", dataVencimento=" + dataVencimento +
                ", valorTotalContratadoParcelado=" + valorTotalContratadoParcelado +
                ", valorTotalContratadoConsorcio=" + valorTotalContratadoConsorcio +
                ", valorSaldoDevedor=" + valorSaldoDevedor +
                ", movimentos=" + movimentos +
                '}';
    }
}
