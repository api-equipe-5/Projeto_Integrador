package com.mitimAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mitimAPI.model.Login;
import com.mitimAPI.model.Usuario;
import com.mitimAPI.service.LoginService;

@Controller
@RequestMapping(path = "/login")

@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	LoginService loginService;

//	@GetMapping(path = "/{email}/{senha}")
//
//	public @ResponseBody Usuario login(@PathVariable String email, @PathVariable String senha) {
//
//		return loginService.logar(email, senha);
//	}

	@PostMapping(path = "/")
	public @ResponseBody Usuario login(@RequestBody Login login) {
		return loginService.logar(login.getEmail(), login.getSenha());
	}
}
