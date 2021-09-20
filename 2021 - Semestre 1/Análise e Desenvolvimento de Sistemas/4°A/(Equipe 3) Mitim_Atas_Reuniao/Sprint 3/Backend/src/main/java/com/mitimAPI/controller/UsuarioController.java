package com.mitimAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mitimAPI.model.Usuario;
import com.mitimAPI.service.UsuarioService;

@Controller
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	

	@GetMapping(path = "/usuarios")
	public @ResponseBody Iterable<Usuario> getAllUsers() {

		return usuarioService.findAll();
	}
	@PostMapping(path = "/add")
	public @ResponseBody String addUsuario(@RequestBody Usuario usuario) throws Exception {
		usuarioService.save(usuario);
		return "Saved";
	}
	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteUsuario(@RequestBody Usuario usuario) {
		usuarioService.findById(usuario.getId()).ifPresent((u) -> {usuarioService.delete(u);});
		return "Deleted";
	}
	@PutMapping(path = "/edit")
	public @ResponseBody String editUsuario(@RequestBody Usuario usuario) {
		usuarioService.findById(usuario.getId()).ifPresent((u) -> {usuarioService.update(usuario);});
		return "Saved";
	}
}
