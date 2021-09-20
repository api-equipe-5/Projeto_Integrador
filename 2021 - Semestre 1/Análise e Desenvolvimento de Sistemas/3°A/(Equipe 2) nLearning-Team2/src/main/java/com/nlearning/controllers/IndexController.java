package com.nlearning.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nlearning.mapper.CurriculoMapper;
import com.nlearning.models.CurriculoControllerModel;
import com.nlearning.models.Usuario;
import com.nlearning.repository.CurriculoRepository;

@Controller
public class IndexController {

	@Autowired
	private CurriculoRepository curriculoRepository;

	@RequestMapping("/")
	public String index() {
		Usuario.tipoUsu = "";
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String form(@RequestParam(value = "curriculo") MultipartFile curriculo, CurriculoControllerModel dados)
			throws IOException {
		curriculoRepository.save(CurriculoMapper.converter(dados, curriculo));
		return "redirect:/";
	}
}