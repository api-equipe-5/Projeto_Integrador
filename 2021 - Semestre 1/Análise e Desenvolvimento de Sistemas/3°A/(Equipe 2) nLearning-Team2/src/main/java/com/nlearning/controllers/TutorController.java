package com.nlearning.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.nlearning.mapper.QuestaoMapper;
import com.nlearning.models.Curso;
import com.nlearning.models.Tutor;
import com.nlearning.models.Usuario;
import com.nlearning.models.Aluno;
import com.nlearning.models.AvaliacaoCompetenciaAluno;
import com.nlearning.repository.CursoRepository;
import com.nlearning.repository.QuestaoRepository;
import com.nlearning.repository.TutorRepository;
import com.nlearning.repository.AlunoRepository;
import com.nlearning.repository.AvaliacaoCompetenciaRepository;

@Controller
public class TutorController {

	@Autowired
	private TutorRepository tutorRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private QuestaoRepository questaoRepository;

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AvaliacaoCompetenciaRepository ACARepository;
	
	Long idAlunoLocal;

	// Validação de login
	@RequestMapping(value = "/cadastrarTutor", method = RequestMethod.GET)
	public String form(HttpSession sessao) {
		if (Usuario.tipoUsu == "admin" || Usuario.tipoUsu == "gestor") {
			return "tutor/form_tutor";
		} else {
			return "redirect:login";
		}
	}

	// Validação de login (MENU)
	@RequestMapping(value = "/menuTutor")
	public String checkMenu(HttpSession sessao) {
		if (Usuario.tipoUsu == "tutor") {
			return "tutor/menu_tutor";
		} else {
			return "redirect:login";
		}
	}

	// Validação de login (UPDATE)
	@RequestMapping(value = "/update_tutor")
	public String checkUpdate() {
		if (Usuario.tipoUsu == "aluno") {
			return "redirect:login";
		} else {
			return "redirect:alterarDadosTutor";
		}
	}

	// Encontra os dados do admin alvo
	@RequestMapping(value = "alterarDadosTutor", method = RequestMethod.GET)
	public ModelAndView dadosAdmin(Long idAdmin) {
		Tutor tutor = tutorRepository.findByIdTutor(Usuario.idUsu);
		ModelAndView mv = new ModelAndView("tutor/update_tutor");
		mv.addObject("tutor", tutor);

		return mv;
	}

	// Salva os dados do admin alvo e atualiza no banco
	@RequestMapping(value = "alterarDadosTutor", method = RequestMethod.POST)
	public String form_update(Tutor tutor, Long idTutor) {
		tutor.setIdTutor(Usuario.idUsu);
		tutorRepository.save(tutor);
		return "redirect:alterarDadosTutor";
	}

	@RequestMapping(value = "/cadastrarTutor", method = RequestMethod.POST)
	public String form(Tutor tutor, String senhaConfirmacao) {
		if (tutor.getSenha().equals(senhaConfirmacao)) {
			tutorRepository.save(tutor);
			return "redirect:login";
		} else {
			return "redirect:cadastrarTutor";
		}
	}

	@RequestMapping("/deletar/{id_tutor}")
	public String deletarTutor(Long idTutor) {
		Tutor tutor = tutorRepository.findByIdTutor(idTutor);
		tutorRepository.delete(tutor);
		return "redirect:/usuarios";
	}

	@RequestMapping(value = "/cursosQuestoes")
	public ModelAndView cursosQuestoes(Usuario usu) {

		ModelAndView mv = new ModelAndView("/curso/lista_cursos_tutor");
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

	@RequestMapping(value = "/criarQuestaoCurso")
	public ModelAndView criarQuestaoCurso(@RequestParam("idCurso") Long idCurso) {
		Curso curso = cursoRepository.findByIdCurso(idCurso);
		ModelAndView mv = new ModelAndView("/curso/criar_questao_curso");
		String imagem = Base64.getEncoder().encodeToString(curso.getImagem());
		curso.setImagem_string(imagem);
		mv.addObject("curso", curso);
		return mv;
	}

	// Cadastra os dados das questões no banco de dados
	@RequestMapping(value = "/criarQuestaoCurso", method = RequestMethod.POST,  consumes = { "multipart/form-data" })
	public String form(@RequestParam(value = "pergunta") MultipartFile pergunta, Long idCurso, @RequestParam(value = "video") MultipartFile video, String forms)
		throws IOException {
			questaoRepository.save(QuestaoMapper.converter(pergunta, idCurso, video, forms));
			return "redirect:menuTutor";
		}
	

	// Encontra os dados do aluno alvo para exibição
		@RequestMapping(value = "/DetalhesAluno/{id_aluno}", method = RequestMethod.GET)
		public ModelAndView dadosAluno(@PathVariable("id_aluno") Long idAluno) {
			idAlunoLocal = idAluno;
			Aluno aluno = alunoRepository.findByIdAluno(idAluno);
			ModelAndView mv = new ModelAndView("tutor/detalhes_aluno");
			mv.addObject("aluno", aluno);
			return mv;
		}
		
		@RequestMapping(value = "/DetalhesAluno/{idAluno}", method = RequestMethod.POST)
		public String competenciasAluno( AvaliacaoCompetenciaAluno aca) {
			aca.setIdAluno(idAlunoLocal);
			aca.setIdTutor(Usuario.idUsu);
			ACARepository.save(aca);
			return "redirect:/menuTutor";
		}		
}
