package com.nlearning.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.models.Gestor;
import com.nlearning.models.Usuario;
import com.nlearning.repository.GestorRepository;

@Controller
public class GestorController {

	@Autowired
	private GestorRepository gestorRepository;

	// Validação de login (CADASTRAR)
	@RequestMapping(value = "/cadastrarGestor", method = RequestMethod.GET)
	public String checkForm(HttpSession sessao) {
		if (Usuario.tipoUsu != "admin") {
			return "redirect:login";
		} else {
			return "gestor/form_gestor";
		}
	}

	// Validação de login (UPDATE)
	@RequestMapping(value = "/update_gestor")
	public String checkUpdate(HttpSession sessao) {
		if (Usuario.tipoUsu == "admin" || Usuario.tipoUsu == "gestor") {
			return "redirect:alterarDadosGestor";
		} else {
			return "redirect:login";
		}
	}

	// Validação de login (MENU)
	@RequestMapping(value = "/menuGestor")
	public String checkMenu(HttpSession sessao) {
		if (Usuario.tipoUsu == "gestor") {
			return "gestor/menu_gestor";
		} else {
			return "redirect:login";
		}
	}

	// Encontra os dados do gestor alvo para exibir na página
	@RequestMapping(value = "alterarDadosGestor", method = RequestMethod.GET)
	public ModelAndView dadosGestor(Long idGestor) {
		Gestor gestor = gestorRepository.findByIdGestor(Usuario.idUsu);
		ModelAndView mv = new ModelAndView("gestor/update_gestor");
		mv.addObject("gestor", gestor);

		return mv;
	}

	// Salva os dados do gestor alvo e atualiza no banco
	@RequestMapping(value = "alterarDadosGestor", method = RequestMethod.POST)
	public String form_update(Gestor gestor, Long idGestor) {
		gestor.setIdGestor(Usuario.idUsu);
		gestorRepository.save(gestor);
		return "redirect:/alterarDadosGestor";
	}

	// Cadastra os dados do gestor no banco de dados
	@RequestMapping(value = "/cadastrarGestor", method = RequestMethod.POST)
	public String form(Gestor gestor, String senhaConfirmacao) {
		if (gestor.getSenha().equals(senhaConfirmacao)) {
			gestorRepository.save(gestor);
			return "redirect:login";
		}
		else {
			return "redirect:cadastrarGestor";
		}
	}
	
	@RequestMapping("/deletar/{id_gestor}")
	public String deletarGestor(Long idGestor) {
		Gestor gestor = gestorRepository.findByIdGestor(idGestor);
		gestorRepository.delete(gestor);
		return "redirect:/usuarios";
	}
}