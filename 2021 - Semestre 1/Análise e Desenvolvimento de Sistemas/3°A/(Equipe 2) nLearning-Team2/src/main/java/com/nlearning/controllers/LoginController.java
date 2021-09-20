package com.nlearning.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// imports de admin
import com.nlearning.models.Admin;
import com.nlearning.models.Aluno;
//imports de gestor
import com.nlearning.models.Gestor;
import com.nlearning.models.Log;
//imports de tutor
import com.nlearning.models.Tutor;
import com.nlearning.models.Usuario;
import com.nlearning.repository.AdminRepository;
// imports de aluno
import com.nlearning.repository.AlunoRepository;
import com.nlearning.repository.GestorRepository;
import com.nlearning.repository.LogRepository;
import com.nlearning.repository.TutorRepository;

@Controller
public class LoginController {

	// Chamando os repositórios para pesquisa no banco para o login
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private GestorRepository gestorRepository;
	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private LogRepository logRepository;

	// Deslogar o usuário (usar esse mapping para deslogar)
	@GetMapping("/login")
	public String sair() {
		Usuario.tipoUsu = "";
		Usuario.idUsu = null;
		return "redirect:Login";
	}

	// Requisição da página de login
	@RequestMapping(value = "Login", method = RequestMethod.GET)
	public ModelAndView dadosAluno(Long idAluno) {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	// Executa todos os passos do login do usuário desejado
	@ExceptionHandler
	@PostMapping("Login")
	public String login(String email, String senha) {
		// Criando classes para efetuação do login
		Admin admin = new Admin();
		admin = adminRepository.findByEmail(email);
		Gestor gestor = new Gestor();
		gestor = gestorRepository.findByEmail(email);
		Tutor tutor = new Tutor();
		tutor = tutorRepository.findByEmail(email);
		Aluno aluno = new Aluno();
		aluno = alunoRepository.findByEmail(email);

		// Checando no banco se o email existe
		if (admin != null || gestor != null || tutor != null || aluno != null) {
			// Verificando em cada tabela se o emais e a senha no banco são iguais as salvas
			// no banco
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			Date date = new Date(); 
			String dataAtual = dateFormat.format(date);
			
			if (admin != null && admin.getEmail().equals(email) && admin.getSenha().equals(senha)) {
				Usuario.tipoUsu = "admin";
				Usuario.idUsu = admin.getIdAdmin();
				
				Log log = new Log();
				log.setIdUsuario(Usuario.idUsu);
				log.setData(dataAtual);
				
				logRepository.save(log);
				
				return "redirect:menuAdmin";
				
			} else if (gestor != null && gestor.getEmail().equals(email) && gestor.getSenha().equals(senha)) {
				Usuario.tipoUsu = "gestor";
				Usuario.idUsu = gestor.getIdGestor();
				
				Log log = new Log();
				log.setIdUsuario(Usuario.idUsu);
				log.setData(dataAtual);
				
				logRepository.save(log);
				
				return "redirect:menuGestor";
				
			} else if (tutor != null && tutor.getEmail().equals(email) && tutor.getSenha().equals(senha)) {
				Usuario.tipoUsu = "tutor";
				Usuario.idUsu = tutor.getIdTutor();
				
				Log log = new Log();
				log.setIdUsuario(Usuario.idUsu);
				log.setData(dataAtual);
				
				logRepository.save(log);
				
				return "redirect:menuTutor";
				
			} else if (aluno != null && aluno.getEmail().equals(email) && aluno.getSenha().equals(senha)) {
				Usuario.tipoUsu = "aluno";
				Usuario.idUsu = aluno.getIdAluno();
				
				Log log = new Log();
				log.setIdUsuario(Usuario.idUsu);
				log.setData(dataAtual);
				
				logRepository.save(log);
				
				return "redirect:menuAluno";
			}
		}
		// caso não encontre nenhum email
		else {
			return null;
		}
		return null;
	}

	// Verifica qual o usuário para voltar ao menu correto
	@RequestMapping("voltar")
	public String voltar() {
		if (Usuario.tipoUsu == "admin") {
			return "redirect:menuAdmin";
		} else if (Usuario.tipoUsu == "gestor") {
			return "redirect:menuGestor";
		} else if (Usuario.tipoUsu == "tutor") {
			return "redirect:menuTutor";
		} else if (Usuario.tipoUsu == "aluno") {
			return "redirect:menuAluno";
		}
		return null;
	}

}