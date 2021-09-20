package com.mitimAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mitimAPI.model.Usuario;
import com.mitimAPI.service.EmailService;

@Controller
@RequestMapping(path = "/solicitacao_acesso")
@CrossOrigin(origins = "*")
public class SolicitacaoAcessoController {
	
	
	@Autowired
	private EmailService emailService;
	
	
	@PostMapping(path = "/solicitar")
	public @ResponseBody String solicitar(@RequestBody Usuario usuario) throws Exception {
		emailService.solicitarAcesso(usuario);
		return "Enviado";
	}
}
