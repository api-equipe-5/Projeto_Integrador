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

import com.mitimAPI.model.Revisao;
import com.mitimAPI.service.RevisaoService;

@Controller
@RequestMapping(path = "/revisao")
@CrossOrigin(origins = "*")
public class RevisaoController {
	
	@Autowired
	private RevisaoService revisaoService;
	

	@GetMapping(path = "/revisoes")
	public @ResponseBody Iterable<Revisao> getAllRevisoes() {
		return revisaoService.findAll();
	}
	@PostMapping(path = "/add")
	public @ResponseBody String addRevisao(@RequestBody Revisao revisao) throws Exception {
		revisaoService.save(revisao);
		return "Saved";
	}
	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteRevisao(@RequestBody Revisao revisao) {
		revisaoService.findById(revisao.getId()).ifPresent((u) -> {revisaoService.delete(u);});
		return "Deleted";
	}
	@PutMapping(path = "/edit")
	public @ResponseBody String editRevisaoService(@RequestBody Revisao revisao) {
		revisaoService.findById(revisao.getId()).ifPresent((u) -> {revisaoService.update(revisao);});
		return "Saved";
	}


	
	

}
