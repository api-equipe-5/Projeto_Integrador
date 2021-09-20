package com.nlearning.controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.models.Curriculo;
import com.nlearning.repository.CurriculoRepository;

@Controller
public class CurriculoController {
	
	@Autowired
	private CurriculoRepository curriculoRepository;
	
	@RequestMapping(value = "/candidatos", method = RequestMethod.GET)
	public ModelAndView listaCandidatos() throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("/candidato/lista_candidatos");
		Iterable<Curriculo> candidato = curriculoRepository.findAll();
		List<Curriculo> lista_candidatos = new ArrayList<>();

		for (Curriculo candidatos : candidato) {
			String imagem = Base64.getEncoder().encodeToString(candidatos.getCurriculo());
			candidatos.setCurriculo_string(imagem);
			lista_candidatos.add(candidatos);
		}

		mv.addObject("candidato", lista_candidatos);

		return mv;
	}

	@RequestMapping(value = "/curriculo/{id_candidato}", method = RequestMethod.GET)
	public ModelAndView listCursos(@PathVariable("id_candidato") Long id_candidato) {
		Curriculo candidato = curriculoRepository.findByIdCandidato(id_candidato);
		ModelAndView mv = new ModelAndView("/candidato/curriculo");

		String imagem = Base64.getEncoder().encodeToString(candidato.getCurriculo());
		candidato.setCurriculo_string(imagem);
		mv.addObject("candidato", candidato);
		return mv;
	}
	
	@RequestMapping("/deletar/{id_candidato}")
	public String deletarCandidato(Long idCandidato) {
		Curriculo candidato = curriculoRepository.findByIdCandidato(idCandidato);
		curriculoRepository.delete(candidato);
		return "redirect:/candidatos";
	}
}
