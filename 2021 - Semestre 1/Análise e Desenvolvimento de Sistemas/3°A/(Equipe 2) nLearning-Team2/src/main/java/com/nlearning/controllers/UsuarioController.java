package com.nlearning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.models.Admin;
import com.nlearning.models.Aluno;
import com.nlearning.models.Gestor;
import com.nlearning.models.Tutor;
import com.nlearning.repository.AdminRepository;
import com.nlearning.repository.AlunoRepository;
import com.nlearning.repository.GestorRepository;
import com.nlearning.repository.TutorRepository;

@Controller
public class UsuarioController {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private TutorRepository tutorRepository;

	@Autowired
	private GestorRepository gestorRepository;

	@GetMapping(value = "/usuarios")
	public ModelAndView listaCursos() {
		ModelAndView mv = new ModelAndView("/usuario/lista_usuarios");
		Iterable<Admin> admin = adminRepository.findAll();
		Iterable<Aluno> aluno = alunoRepository.findAll();
		Iterable<Tutor> tutor = tutorRepository.findAll();
		Iterable<Gestor> gestor = gestorRepository.findAll();

		mv.addObject("admin", admin);
		mv.addObject("aluno", aluno);
		mv.addObject("tutor", tutor);
		mv.addObject("gestor", gestor);

		return mv;
	}
}
