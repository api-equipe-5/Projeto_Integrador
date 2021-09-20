package com.pi3.scorewizard.movimento;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/movimento")
public class MovimentoController {
    
    @Autowired
    private MovimentoRepository movimentoRepository;
    
    @GetMapping(path="/getMovimentosByCpf")
    public @ResponseBody ArrayList<Movimento> getAllPessoaFisica(String documento) {
        return movimentoRepository.findByPessoaFisicaDocumento(documento);
    }

}
