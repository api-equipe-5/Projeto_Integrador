package com.fatec.antenas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
	
	@RequestMapping("/")
	private String index() {
		return "index";
	}
	
	@RequestMapping("/empresario/painel")
	public String empresarioView( @RequestAttribute("idUsuarioLogado") String idUsuarioLogado) {
		return "empresario";
	}
	
	@RequestMapping("/cadi/painel")
	public String cadiView( @RequestAttribute("idUsuarioLogado") String idUsuarioLogado) {
		return "cadi";
	}
	
	@RequestMapping("/professor/painel")
	public String professorView( @RequestAttribute("idUsuarioLogado") String idUsuarioLogado) {
		return "professor";
	}
	
	@RequestMapping("/aluno/painel")
	public String alunoView( @RequestAttribute("idUsuarioLogado") String idUsuarioLogado) {
		return "aluno";
	}
	
	
}
