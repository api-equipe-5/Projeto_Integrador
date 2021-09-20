package app.models.repository;

import app.models.dtos.getdadoscpf.GetDadosCPFMovimentoDTO;
import app.models.dtos.getdadoscpf.GetDadosCPFOperacaoDTO;
import app.models.dtos.getdadoscpf.GetDadosCPFResponseDTO;
import app.models.entities.Movimento;
import app.models.entities.Operacao;
import app.models.entities.Pagamento;
import app.models.entities.PessoaFisica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DadosCPFRepository {
    private final PessoaFisicaRepository pessoaFisicaRepository = new PessoaFisicaRepository();
    private final OperacaoRepository operacaoRepository = new OperacaoRepository();
    private final MovimentoRepository movimentoRepository = new MovimentoRepository();
    private final PagamentoRepository pagamentoRepository = new PagamentoRepository();

    public GetDadosCPFResponseDTO getDadosCPFResponse(String cpf) throws SQLException {
        PessoaFisica pessoaFisica = pessoaFisicaRepository.selectPessoaFisicaPorCPF(cpf);

        if(pessoaFisica == null)
            return null;

        List<Operacao> operacoes = operacaoRepository.selectOperacoesPorCpf(pessoaFisica.getCpf());
        List<GetDadosCPFOperacaoDTO> dadosOperacao = new ArrayList<>();
        for(Operacao operacao : operacoes) {
            List<Movimento> movimentos = movimentoRepository
                    .selectMovimentosPorCpfENumeroContrato(operacao.getCpf(), operacao.getNumeroContrato());

            List<GetDadosCPFMovimentoDTO> dadosMovimentos = new ArrayList<>();
            for(Movimento movimento : movimentos) {
                List<Pagamento> pagamentos = pagamentoRepository
                        .selectMovimentosPorCpfENumeroContrato(
                                movimento.getCpf(),
                                movimento.getNumeroContrato(),
                                movimento.getDataVencimentoParcela());

                dadosMovimentos.add(GetDadosCPFMovimentoDTO.builder()
                        .cpf(movimento.getCpf())
                        .dataVencimentoParcela(movimento.getDataVencimentoParcela())
                        .id(movimento.getId())
                        .idFonte(movimento.getIdFonte())
                        .numeroContrato(movimento.getNumeroContrato())
                        .periodicidade(movimento.getPeriodicidade())
                        .quantidadeParcelasPagar(movimento.getQuantidadeParcelasPagar())
                        .quantidadeParcelasVencer(movimento.getQuantidadeParcelasVencer())
                        .tipoMovimento(movimento.getTipoMovimento())
                        .valorMinimoFatura(movimento.getValorMinimoFatura())
                        .valorParcela(movimento.getValorParcela())
                        .valorTotalFatura(movimento.getValorTotalFatura())
                        .pagamentos(pagamentos)
                        .build());
            }
            dadosOperacao.add(GetDadosCPFOperacaoDTO.builder()
                    .codigoModalidade(operacao.getCodigoModalidade())
                    .cpf(operacao.getCpf())
                    .dataContrato(operacao.getDataContrato())
                    .dataVencimento(operacao.getDataVencimento())
                    .dataVencimentoUltimaParcela(operacao.getDataVencimentoUltimaParcela())
                    .id(operacao.getId())
                    .idModalidade(operacao.getIdModalidade())
                    .numeroContrato(operacao.getNumeroContrato())
                    .quantidadeParcelasContrato(operacao.getQuantidadeParcelasContrato())
                    .valorSaldoDevedor(operacao.getValorSaldoDevedor())
                    .valorTotalContratadoConsorcio(operacao.getValorTotalContratadoConsorcio())
                    .valorTotalContratadoParcelado(operacao.getValorTotalContratadoParcelado())
                    .movimentos(dadosMovimentos)
                    .build());
        }

        return GetDadosCPFResponseDTO.builder()
                .anoNascimento(pessoaFisica.getAnoNascimento())
                .cidade(pessoaFisica.getCidade())
                .cpf(pessoaFisica.getCpf())
                .estado(pessoaFisica.getEstado())
                .sexo(pessoaFisica.getSexo())
                .operacoes(dadosOperacao)
                .build();
    }
}
