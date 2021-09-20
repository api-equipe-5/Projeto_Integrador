package com.mitimAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitimAPI.model.Usuario;
import com.mitimAPI.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@Autowired
	private EmailService emailService;
	
	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}
	
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	public void save(Usuario usuario) {
		usuario.setId(null);
		emailService.aprovarAcesso(usuario);
		usuarioRepository.save(usuario);
	}
	
	public void update(Usuario usuario) {
		if(usuario.getId() != null) {
			usuarioRepository.save(usuario);
		}
	}
	public Iterable<Usuario> findAll(){
		return usuarioRepository.findAll();
	}


}
