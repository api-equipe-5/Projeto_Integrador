package com.nlearning.controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.models.Aluno;
import com.nlearning.models.Curso;
import com.nlearning.models.CursoAluno;
import com.nlearning.models.Questao;
import com.nlearning.models.Trilha;
import com.nlearning.models.Usuario;
import com.nlearning.repository.AlunoRepository;
import com.nlearning.repository.CursoAlunoRepository;
import com.nlearning.repository.CursoRepository;
import com.nlearning.repository.QuestaoRepository;
import com.nlearning.repository.TrilhaRepository;

@Controller
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private CursoAlunoRepository cursoAlunoRepository;

	@Autowired
	private QuestaoRepository questaoRepository;

	@Autowired
	private TrilhaRepository trilhaRepository;

	// Validação de login (CADASTRAR)
	@RequestMapping(value = "/cadastrarAluno")
	public String checkForm(HttpSession sessao) {
		if (Usuario.tipoUsu == "admin" || Usuario.tipoUsu == "gestor") {
			return "aluno/form_aluno";
		} else {
			return "redirect:login";
		}
	}

	// Cadastra os dados do aluno no banco de dados
	@RequestMapping(value = "/cadastrarAluno", method = RequestMethod.POST)
	public String form(Aluno aluno, String senhaConfirmacao) {
		if (aluno.getSenha().equals(senhaConfirmacao)) {
			alunoRepository.save(aluno);
			return "redirect:cadastrarAluno";
		} else {
			return "redirect:cadastrarAluno";
		}
	}

	// Validação de login (MENU)
	@RequestMapping(value = "/menuAluno")
	public String checkMenu(HttpSession sessao) {
		if (Usuario.tipoUsu == "aluno") {
			return "aluno/menu_aluno";
		} else {
			return "redirect:login";
		}
	}

	// Validação de login (UPDATE)
	@RequestMapping(value = "/update_aluno")
	public String checkUpdate() {
		if (Usuario.tipoUsu == "tutor") {
			return "redirect:login";
		} else {
			return "redirect:alterarDadosAluno";
		}
	}

	// Encontra os dados do aluno alvo
	@RequestMapping(value = "alterarDadosAluno", method = RequestMethod.GET)
	public ModelAndView dadosAluno(Long idAluno) {
		Aluno aluno = alunoRepository.findByIdAluno(Usuario.idUsu);
		ModelAndView mv = new ModelAndView("aluno/update_aluno");
		mv.addObject("aluno", aluno);

		return mv;
	}

	// Salva os dados do aluno alvo e atualiza no banco
	@RequestMapping(value = "alterarDadosAluno", method = RequestMethod.POST)
	public String form_update(Aluno aluno, Long idAluno) {
		aluno.setIdAluno(Usuario.idUsu);
		alunoRepository.save(aluno);
		return "redirect:alterarDadosAluno";
	}

	@RequestMapping("/deletar/{id_aluno}")
	public String deletarAluno(Long idAluno) {
		Aluno aluno = alunoRepository.findByIdAluno(idAluno);
		alunoRepository.delete(aluno);
		return "redirect:/usuarios";
	}

	@GetMapping(value = "/cursosnLearning")
	public ModelAndView listaCursos() throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("/curso/lista_cursos_aluno");
		Iterable<Curso> curso = cursoRepository.findAll();
		List<Curso> lista_cursos = new ArrayList<>();

		for (Curso cursos : curso) {
			String imagem = Base64.getEncoder().encodeToString(cursos.getImagem());
			cursos.setImagem_string(imagem);
			lista_cursos.add(cursos);
		}

		mv.addObject("curso", lista_cursos);

		return mv;
	}

	@RequestMapping(value = "/comprarCurso")
	public ModelAndView telaCurso(@RequestParam("idCurso") Long idCurso) {
		Curso curso = cursoRepository.findByIdCurso(idCurso);
		ModelAndView mv = new ModelAndView("/curso/comprar_curso");
		String imagem = Base64.getEncoder().encodeToString(curso.getImagem());
		curso.setImagem_string(imagem);
		mv.addObject("curso", curso);
		return mv;
	}

	@RequestMapping(value = "/comprarCurso", method = RequestMethod.POST)
	public String alunoCursoCad(@RequestParam("idCurso") Long idCurso, CursoAluno cursoAluno, Usuario usu) {
		cursoAluno.setIdAluno(Usuario.idUsu);
		cursoAluno.setIdCurso(idCurso);
		cursoAlunoRepository.save(cursoAluno);
		return "redirect:/menuAluno";
	}

	@RequestMapping(value = "/seusCursos")
	public ModelAndView seusCursos(Usuario usu) {

		ModelAndView mv = new ModelAndView("/curso/lista_cursos_aluno_comprado");
		Iterable<CursoAluno> cursoAluno = cursoAlunoRepository.findAllByIdAluno(Usuario.idUsu);

		List<Curso> cursosAluno = new ArrayList<>();

		mv.addObject("curso");

		for (CursoAluno cursos : cursoAluno) {
			Long idCurso = cursos.getIdCurso();

			Curso cursosDoAluno = cursoRepository.findAllByIdCurso(idCurso);
			String imagem = Base64.getEncoder().encodeToString(cursosDoAluno.getImagem());
			cursosDoAluno.setImagem_string(imagem);
			cursosAluno.add(cursosDoAluno);
		}

		mv.addObject("curso", cursosAluno);

		return mv;
	}

	@RequestMapping(value = "/visualizarQuestoesCurso")
	public ModelAndView telaVisualizarQuestoes(@RequestParam("idCurso") Long idCurso) {
		Curso curso = cursoRepository.findAllByIdCurso(idCurso);
		Usuario.IdCurso = idCurso;
		ModelAndView mv = new ModelAndView("/curso/curso_questoes");
		String imagem = Base64.getEncoder().encodeToString(curso.getImagem());
		curso.setImagem_string(imagem);
		String pilula = Base64.getEncoder().encodeToString(curso.getPilula());
		curso.setPilula_string(pilula);

		mv.addObject("curso", curso);
		return mv;
	}

	@RequestMapping(value = "/acessoQuestoesCurso")
	public ModelAndView VisualizarQuestoes() {
		Iterable<Questao> questao = questaoRepository.findByIdCurso(Usuario.IdCurso);
		ModelAndView mv = new ModelAndView("/curso/curso_questoes_totais");

		List<Questao> questoesCurso = new ArrayList<>();

		for (Questao questoes : questao) {

			if (questoes.getPergunta() == null) {

				questoesCurso.add(questoes);

			} else {
				String pdf = Base64.getEncoder().encodeToString(questoes.getPergunta());
				questoes.setPdfStringQuestao(pdf);

				questoesCurso.add(questoes);
			}
		}

		mv.addObject("questao", questoesCurso);

		return mv;
	}

	@RequestMapping(value = "/acessoVideosCurso")
	public ModelAndView VisualizarVideos(@RequestParam("idCurso") Long idCurso) {
		Iterable<Questao> video = questaoRepository.findByIdCurso(idCurso);
		ModelAndView mv = new ModelAndView("/curso/curso_videos_totais");

		List<Questao> videosTotais = new ArrayList<>();

		for (Questao videos : video) {

			if (videos.getVideo() == null) {
				videosTotais.add(videos);
			}

			else {
				String videos_totais = Base64.getEncoder().encodeToString(videos.getVideo());
				videos.setVideoString(videos_totais);

				videosTotais.add(videos);
			}
		}

		Trilha trilha = trilhaRepository.findByIdCursoAndIdAluno(idCurso, Usuario.idUsu);
		if (trilha != null) {
			trilha.setAulasCurso(videosTotais.size());
			mv.addObject("trilha", trilha);
		}
		mv.addObject("video", videosTotais);
		return mv;
	}

	@RequestMapping(value = "/acessoVideosCurso", method = RequestMethod.POST)
	public String trilhaAprendizado(@RequestParam("idCurso") Long idCurso, Trilha trilha, Usuario usu) {

		Trilha teste = trilhaRepository.findByIdCursoAndIdAluno(idCurso, Usuario.idUsu);

		if (teste != null) {
			trilha.setIdTrilha(teste.getIdTrilha());
			trilha.setAulasFeitas(teste.getAulasFeitas() + 1);
		}

		if (teste == null) {
			trilha.setAulasFeitas(1);
		}

		trilha.setIdAluno(Usuario.idUsu);
		trilha.setIdCurso(idCurso);
		trilhaRepository.save(trilha);
		return "redirect:/seusCursos";
	}

	@RequestMapping(value = "/emitirCertificado")
	public ModelAndView EmitirCertificado(@RequestParam("idCurso") Long idCurso) {
		ModelAndView mv = new ModelAndView("/curso/emitir_certificado");

		Aluno aluno = alunoRepository.findByIdAluno(Usuario.idUsu);
		Curso curso = cursoRepository.findByIdCurso(idCurso);

		mv.addObject("aluno", aluno);
		mv.addObject("curso", curso);
		return mv;
	}
}