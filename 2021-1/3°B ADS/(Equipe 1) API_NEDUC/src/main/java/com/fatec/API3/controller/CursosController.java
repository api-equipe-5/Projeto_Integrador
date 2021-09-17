package com.fatec.API3.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.API3.model.Cursos;
import com.fatec.API3.model.Tarefas;
import com.fatec.API3.repository.CursosRepository;
import com.fatec.API3.repository.TarefasRepository;

@Controller
public class CursosController {
	
	private static String caminhoimagens = "C:\\Users\\Pichau\\Documents\\Imagens_API3\\";
	//private static String caminhoimagens = "C:\\Users\\kiabi\\OneDrive\\Documentos\\Imagens_API3\\";
	
	private static String caminhopadrao = "padrao.png";

	@Autowired
	private CursosRepository cr;
	
	@Autowired
	private TarefasRepository tr;
	
	@GetMapping("/cursos")
	public String cursoscad(){
		return "/home/cursos"; 
	}
	
	@RequestMapping(value="/novatarefa/{id}", method=RequestMethod.GET)
	public ModelAndView cadastro(@PathVariable("id") long id){
		Cursos curso = cr.findByid(id);
		ModelAndView mv = new ModelAndView("home/novatarefa");
		mv.addObject("curso", curso);
		return mv;
	}
	
	@RequestMapping(value="/novatarefa/{id}", method=RequestMethod.POST)
	public String cadastro(@PathVariable("id") long id, Tarefas tarefa){
		Cursos curso = cr.findByid(id);
		tarefa.setCurso(curso);
		tr.save(tarefa);
		return "redirect:/homeprofessor";
	}
	
	@GetMapping("/cadastrocurso")
	public String cadastro(){
		return "home/novocurso"; 
	}
	
	@PostMapping("/cadastrocurso")
	public String cadastro(Cursos curso, @RequestParam("file") MultipartFile arquivo) throws IOException {
		if (!arquivo.isEmpty()) {
			byte[] bytes = arquivo.getBytes();
			Path caminho = Paths
					.get(caminhoimagens + arquivo.getOriginalFilename());
			Files.write(caminho, bytes);

			curso.setImagem(arquivo.getOriginalFilename());
		}else {
			curso.setImagem(caminhopadrao);
		}
		cr.save(curso);
		return "home/homeprofessor"; 
	}
	
}
