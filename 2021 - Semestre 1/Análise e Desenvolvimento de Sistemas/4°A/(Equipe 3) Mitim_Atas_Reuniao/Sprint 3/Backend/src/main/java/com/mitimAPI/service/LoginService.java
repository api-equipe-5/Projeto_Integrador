package com.mitimAPI.service;

//import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitimAPI.model.Usuario;
import com.mitimAPI.repository.UsuarioRepository;

@Service
public class LoginService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario logar(String email, String senha) {
		Optional<Usuario> usuarioOp = usuarioRepository.findByEmail(email);
		if (usuarioOp.isPresent()) {
			if (usuarioOp.get().getSenha().equals(senha)) {
				//usuarioOp.get().setToken(new Date().getTime() + "");
				usuarioOp.get().setSenha(null);
				return usuarioOp.get();
			}
		}
		return null;
	}
}
