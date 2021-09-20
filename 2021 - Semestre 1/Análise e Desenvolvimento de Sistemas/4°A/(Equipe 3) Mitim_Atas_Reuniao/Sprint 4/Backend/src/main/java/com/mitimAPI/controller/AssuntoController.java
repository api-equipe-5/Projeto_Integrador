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

import com.mitimAPI.model.Assunto;
import com.mitimAPI.service.AssuntoService;

@Controller
@RequestMapping(path = "/assunto")
@CrossOrigin(origins = "*")
public class AssuntoController {
	
	@Autowired
	private AssuntoService assuntoService;
	

	@GetMapping(path = "/assuntos")
	public @ResponseBody Iterable<Assunto> getAllAssuntos() {
		return assuntoService.findAll();
	}
	@PostMapping(path = "/add")
	public @ResponseBody String addAssunto(@RequestBody Assunto assunto) throws Exception {
		assuntoService.save(assunto);
		return "Saved";
	}
	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteAssunto(@RequestBody Assunto assunto) {
		assuntoService.findById(assunto.getId()).ifPresent((u) -> {assuntoService.delete(u);});
		return "Deleted";
	}
	@PutMapping(path = "/edit")
	public @ResponseBody String editAssunto(@RequestBody Assunto assunto) {
		assuntoService.findById(assunto.getId()).ifPresent((u) -> {assuntoService.update(assunto);});
		return "Saved";
	}

}
