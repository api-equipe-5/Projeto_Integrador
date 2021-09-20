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

import com.mitimAPI.model.Ata;
import com.mitimAPI.model.Participante;
import com.mitimAPI.service.AssinaturaService;
import com.mitimAPI.service.AtaService;
import com.mitimAPI.service.ParticipanteService;

@Controller
@RequestMapping(path = "/participante")
@CrossOrigin(origins = "*")
public class ParticipanteController {

	@Autowired
	private ParticipanteService participanteService;
	
	@Autowired
	private AssinaturaService assinaturaService;
	
	@Autowired
	private AtaService ataService;
	

	@GetMapping(path = "/participantes")
	public @ResponseBody Iterable<Participante> getAllParticipantes() {
		return participanteService.findAll();
	}
	@PostMapping(path = "/add")
	public @ResponseBody String addParticipante(@RequestBody Participante participante) throws Exception {
		participanteService.save(participante);
		ataService.findById(participante.getIdata()).ifPresent((u) -> {assinaturaService.assinaAta(u, participante);});
		return "Saved";
	}
	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteParticipante(@RequestBody Participante participante) {
		participanteService.findById(participante.getId()).ifPresent((u) -> {participanteService.delete(u);});
		return "Deleted";
	}
	@PutMapping(path = "/edit")
	public @ResponseBody String editParticipante(@RequestBody Participante participante) {
		participanteService.findById(participante.getId()).ifPresent((u) -> {participanteService.update(participante);});
		return "Saved";
	}


}
