package com.pi3.scorewizard.experiencia;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/ExperienciaVerificacao")
public class ExperienciaVerificacaoController {

	@Autowired
	private ExperienciaVerificacaoRepository experienciaverificacaorepository;
	 
	@PostMapping(path="/AddExp")
	public @ResponseBody String addExp(@RequestParam String documentoCliente,
	                                            @RequestParam String tipoPagamento,
	                                            @RequestParam int qtd_parcelas_operacoes,
	                                            @RequestParam int qtd_parcelas_movimentos,
	                                            @RequestParam Date data_login) {

		ExperienciaVerificacao experiencia = new ExperienciaVerificacao(documentoCliente,tipoPagamento,qtd_parcelas_operacoes,qtd_parcelas_movimentos,data_login);
		experienciaverificacaorepository.save(experiencia);
		return "Saved";
	}
	
    @GetMapping(path="/getExperienciaVerificacao")
    public @ResponseBody ArrayList<ExperienciaVerificacao> getAllExperienciaVerificacao() {
        return experienciaverificacaorepository.findAll();
    }
}
