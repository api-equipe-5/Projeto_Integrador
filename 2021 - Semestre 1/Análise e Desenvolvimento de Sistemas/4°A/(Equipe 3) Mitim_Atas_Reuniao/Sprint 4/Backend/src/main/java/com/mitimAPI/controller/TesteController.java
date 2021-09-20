package com.mitimAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mitimAPI.service.EmailService;

@Controller
@RequestMapping(path = "/teste")
@CrossOrigin(origins = "*")
public class TesteController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping(path = "/testar_email")
	public @ResponseBody void getAllUsers() throws Exception {
		emailService.sendEmail("jodangalas00@gmail.com", "mensagem", "titulo");
	}
}
