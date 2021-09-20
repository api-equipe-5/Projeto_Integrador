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


@Controller
@RequestMapping(path = "/redefinicao_senha")
@CrossOrigin(origins = "*")


public class RedefinirSenhaController {
	
	@Autowired
	private EmailService emailService;

	
	@PutMapping(path = "/redefinir_senha")
	public @ResponseBody String redefineSenha(@RequestBody Usuario usuario) {
		emailService.redefineSenha(usuario);
		return "Envio de redefinição de senha realizado com sucesso";
	}
	


}
