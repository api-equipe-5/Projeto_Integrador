package br.gov.sp.fatec.spc.pagamento.controller;

import br.gov.sp.fatec.spc.pagamento.payload.PagamentoData;
import br.gov.sp.fatec.spc.pagamento.payload.ScorePessoa;
import br.gov.sp.fatec.spc.pagamento.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public Set<PagamentoData> contabilizarEstatistica() {
        return pagamentoService.contabilizar();
    }

    @GetMapping("/{mes}/{ano}")
    public Set<PagamentoData> contabilizarEstatistica(@PathVariable("mes") Integer mes, @PathVariable("ano") Integer ano) {
        return pagamentoService.contabilizar(mes, ano);
    }

    @GetMapping("/{pessoaFisica}")
    public ScorePessoa buscarScorePessoa(@PathVariable("pessoaFisica") String pessoaFisica){
        return pagamentoService.buscarScorePessoa(pessoaFisica);
    }
}
