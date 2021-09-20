package com.nlearning.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.mapper.QuestaoMapper;
import com.nlearning.models.Admin;
import com.nlearning.models.Curso;
import com.nlearning.models.Usuario;
import com.nlearning.repository.AdminRepository;
import com.nlearning.repository.CursoRepository;
import com.nlearning.repository.QuestaoRepository;

@Controller
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private QuestaoRepository questaoRepository;

	// Validação de login (MENU)
	@RequestMapping(value = "/menuAdmin", method = RequestMethod.GET)
	public String checkMenu(HttpSession sessao) {
		if (Usuario.tipoUsu != "admin") {
			return "redirect:login";
		} else {
			return "admin/menu_admin";
		}
	}

	// Validação de login (UPDATE)
	@RequestMapping(value = "/update_admin")
	public String checkUpdate(Long idAdmin) {
		if (Usuario.tipoUsu != "admin") {
			return "redirect:login";
		} else {
			return "redirect:alterarDadosAdmin";
		}
	}

	// Encontra os dados do admin alvo
	@RequestMapping(value = "alterarDadosAdmin", method = RequestMethod.GET)
	public ModelAndView dadosAdmin(Long idAdmin) {
		Admin admin = adminRepository.findByIdAdmin(Usuario.idUsu);
		ModelAndView mv = new ModelAndView("admin/update_admin");
		mv.addObject("admin", admin);

		return mv;
	}

	// Salva os dados do admin alvo e atualiza no banco
	@RequestMapping(value = "alterarDadosAdmin", method = RequestMethod.POST)
	public String form_update(Admin admin, Long idAdmin) {
		admin.setIdAdmin(Usuario.idUsu);
		adminRepository.save(admin);
		return "redirect:alterarDadosAdmin";
	}

	// Não está sendo utilizado (Cadastrar ADM)
	/*
	 * @RequestMapping(value = "/cadastrarAdmin", method = RequestMethod.POST)
	 * public String form(Admin admin) { adminRepository.save(admin); return
	 * "redirect:cadastrarAdmin"; }
	 */
	
	@RequestMapping("/deletar/{id_admin}")
	public String deletarAdmin(Long idAdmin) {
		Admin admin = adminRepository.findByIdAdmin(idAdmin);
		adminRepository.delete(admin);
		return "redirect:/usuarios";
	}
	@RequestMapping(value = "/cursosQuestoesAdmin")
	public ModelAndView cursosQuestoes(Usuario usu) {

		ModelAndView mv = new ModelAndView("/curso/lista_cursos_admin");
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

	@RequestMapping(value = "/criarQuestaoCursoAdmin")
	public ModelAndView criarQuestaoCurso(@RequestParam("idCurso") Long idCurso) {
		Curso curso = cursoRepository.findByIdCurso(idCurso);
		ModelAndView mv = new ModelAndView("/curso/criar_questao_curso_admin");
		String imagem = Base64.getEncoder().encodeToString(curso.getImagem());
		curso.setImagem_string(imagem);
		mv.addObject("curso", curso);
		return mv;
	}

	// Cadastra os dados das questões no banco de dados
	@RequestMapping(value = "/criarQuestaoCursoAdmin", method = RequestMethod.POST,  consumes = { "multipart/form-data" })
	public String form(@RequestParam(value = "pergunta") MultipartFile pergunta, Long idCurso, @RequestParam(value = "video") MultipartFile video, String forms)
		throws IOException {
			questaoRepository.save(QuestaoMapper.converter(pergunta, idCurso, video, forms));
			return "redirect:menuAdmin";
		}
}
