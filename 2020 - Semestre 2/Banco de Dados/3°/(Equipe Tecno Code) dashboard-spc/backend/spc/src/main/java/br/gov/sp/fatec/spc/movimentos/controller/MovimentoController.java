package br.gov.sp.fatec.spc.movimentos.controller;

import br.gov.sp.fatec.spc.movimentos.model.Movimento;
import br.gov.sp.fatec.spc.movimentos.service.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movimentos")
public class MovimentoController {
    @Autowired
    private MovimentoService movimentoService;

    @GetMapping("/{mes}/{ano}")
    public List<Movimento> find(@PathVariable("mes") Integer mes, @PathVariable("ano") Integer ano) {
        return movimentoService.buscarPorMesEAno(mes, ano);
    }
}
