package com.mitimAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mitimAPI.model.Usuario;
import com.mitimAPI.service.EmailService;
import com.mitimAPI.service.UsuarioService;

@Controller
@RequestMapping(path = "/aprova_acesso")
@CrossOrigin(origins = "*")

public class AprovacaoAcessoController {
	
	@Autowired
	private EmailService emailService;
	@Autowired
	private UsuarioService usuarioService;
	
	@PutMapping(path = "/aprovar")
	public @ResponseBody String aprovaAcesso(@RequestBody Usuario usuario) {
		usuarioService.findById(usuario.getId()).ifPresent((u) -> {usuarioService.update(usuario);});
		emailService.aprovarAcesso(usuario);
		return "Aprovado";
	}
}