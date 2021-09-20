package com.nlearning.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.mapper.CursoMapper;
import com.nlearning.models.Aluno;
import com.nlearning.models.Curso;
import com.nlearning.models.CursoAluno;
import com.nlearning.models.CursoControllerModel;
import com.nlearning.models.Usuario;
import com.nlearning.repository.AlunoRepository;
import com.nlearning.repository.CursoAlunoRepository;
import com.nlearning.repository.CursoRepository;

@Controller
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private CursoAlunoRepository cursoAlunoRepository;

	// Rota para o get do form Tutor
	@RequestMapping(value = "/cadastrarCurso", method = RequestMethod.GET)
	public String form() {
		return "curso/form_curso_tutor";
	}

	// Cadastra os dados do curso no banco de dados
	@RequestMapping(value = "/cadastrarCurso", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String form(@RequestParam(value = "imagem") MultipartFile imagem, CursoControllerModel curso, @RequestParam(value = "video") MultipartFile video)
			throws IOException {
		cursoRepository.save(CursoMapper.converter(curso, imagem, video));
		return "redirect:menuTutor";
	}
	
	// Rota para o get do form Admin
		@RequestMapping(value = "/cadastrarCursoAdmin", method = RequestMethod.GET)
		public String formAdmin() {
			return "curso/form_curso_admin";
		}

		// Cadastra os dados do curso no banco de dados
		@RequestMapping(value = "/cadastrarCursoAdmin", method = RequestMethod.POST, consumes = { "multipart/form-data" })
		public String formAdmin(@RequestParam(value = "imagem") MultipartFile imagem, CursoControllerModel curso, @RequestParam(value = "video") MultipartFile video)
				throws IOException {
			cursoRepository.save(CursoMapper.converter(curso, imagem, video));
			return "redirect:menuAdmin";
		}

	@GetMapping(value = "/cursos")
	public ModelAndView listaCursos() throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("/curso/lista_cursos");
		Iterable<Curso> curso = cursoRepository.findAllByIdTutor(Usuario.idUsu);

		List<Curso> cursosTutor = new ArrayList<>();

		mv.addObject("curso");

		for (Curso cursos : curso) {

			String imagem = Base64.getEncoder().encodeToString(cursos.getImagem());
			cursos.setImagem_string(imagem);
			cursosTutor.add(cursos);
		}

		mv.addObject("curso", cursosTutor);

		return mv;
	}
	
	@GetMapping(value = "/cursosAdmin")
	public ModelAndView listaCursosAdmin() throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("/curso/cursos_admin");
		Iterable<Curso> curso = cursoRepository.findAllByIdTutor(Usuario.idUsu);

		List<Curso> cursosAdmin = new ArrayList<>();

		mv.addObject("curso");

		for (Curso cursos : curso) {

			String imagem = Base64.getEncoder().encodeToString(cursos.getImagem());
			cursos.setImagem_string(imagem);
			cursosAdmin.add(cursos);
		}

		mv.addObject("curso", cursosAdmin);

		return mv;
	}

	@RequestMapping(value = "/selectCurso")
	public ModelAndView telaCurso(@RequestParam("idCurso") Long idCurso) {
		Curso curso = cursoRepository.findByIdCurso(idCurso);
		ModelAndView mv = new ModelAndView("/curso/update_curso");
		String imagem = Base64.getEncoder().encodeToString(curso.getImagem());
		curso.setImagem_string(imagem);
		String pilula = Base64.getEncoder().encodeToString(curso.getPilula());
		curso.setPilula_string(pilula);
		
		Iterable<CursoAluno> cursoAluno = cursoAlunoRepository.findByIdCurso(idCurso);
		
		List<Aluno> listIdAlunos = new ArrayList<>();

		for (CursoAluno cursos : cursoAluno) {

			long id_aluno = cursos.getIdAluno();
			Aluno aluno = alunoRepository.findAllByIdAluno(id_aluno);
			listIdAlunos.add(aluno);
		}
		
		mv.addObject("curso", curso);
		mv.addObject("aluno", listIdAlunos);
		return mv;
	}

	@RequestMapping(value = "selectCurso", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String form_update(@RequestParam("idCurso") Long idCurso,
			@RequestParam(value = "imagem") MultipartFile imagem, @RequestParam(value = "video") MultipartFile video, CursoControllerModel curso) throws IOException {
		Curso cursoUpdate = CursoMapper.converter(curso, imagem, video);
		cursoUpdate.setIdCurso(idCurso);
		cursoRepository.save(cursoUpdate);
		return "redirect:/cursos";
	}
	
	@RequestMapping(value = "/selectCursoAdmin")
	public ModelAndView telaCursoAdmin(@RequestParam("idCurso") Long idCurso) {
		Curso curso = cursoRepository.findByIdCurso(idCurso);
		ModelAndView mv = new ModelAndView("/curso/update_curso_admin");
		String imagem = Base64.getEncoder().encodeToString(curso.getImagem());
		curso.setImagem_string(imagem);
		String pilula = Base64.getEncoder().encodeToString(curso.getPilula());
		curso.setPilula_string(pilula);
		mv.addObject("curso", curso);
		return mv;
	}

	@RequestMapping(value = "selectCursoAdmin", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String form_update_admin(@RequestParam("idCurso") Long idCurso,
			@RequestParam(value = "imagem") MultipartFile imagem, @RequestParam(value = "video") MultipartFile video, CursoControllerModel curso) throws IOException {
		Curso cursoUpdate = CursoMapper.converter(curso, imagem, video);
		cursoUpdate.setIdCurso(idCurso);
		cursoRepository.save(cursoUpdate);
		return "redirect:/cursosAdmin";
	}

	@RequestMapping("/deletar/{id_curso}")
	public String deletarCurso(Long idCurso) {
		Curso curso = cursoRepository.findByIdCurso(idCurso);
		cursoRepository.delete(curso);
		return "redirect:/cursos";
	}
	
	
}
