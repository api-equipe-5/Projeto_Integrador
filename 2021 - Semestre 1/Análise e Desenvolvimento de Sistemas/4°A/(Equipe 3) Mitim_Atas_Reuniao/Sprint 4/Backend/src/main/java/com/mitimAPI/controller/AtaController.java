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


@Controller
@RequestMapping(path = "/ata")
@CrossOrigin(origins = "*")

public class AtaController {
	
	@Autowired
	private AtaService ataService;
	


	@GetMapping(path = "/atas")
	public @ResponseBody Iterable<Ata> getAllAtas() {

		return ataService.findAll();
	}
	@PostMapping(path = "/add")
	public @ResponseBody String addAta(@RequestBody Ata ata, Participante participante) {
		//ata.getusuario.addusuario
		ataService.save(ata);
		return "Saved";
	}
	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteAta(@RequestBody Ata ata) {
		ataService.findById(ata.getId()).ifPresent((u) -> {ataService.delete(u);});
		return "Deleted";
	}
	@PutMapping(path = "/edit")
	public @ResponseBody String editAta(@RequestBody Ata ata) {
		ataService.findById(ata.getId()).ifPresent((u) -> {ataService.update(ata);});
		return "Saved";
	}
}


