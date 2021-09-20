package com.nlearning.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nlearning.mapper.BibliotecaMapper;
import com.nlearning.models.Biblioteca;
import com.nlearning.models.BibliotecaControllerModel;
import com.nlearning.repository.BibliotecaRepository;

@Controller
public class BibliotecaController {

	@Autowired
	BibliotecaRepository bibliotecaRepository;

	// Rota para o get do form
	@RequestMapping(value = "/cadastrarLivro", method = RequestMethod.GET)
	public String form() {
		return "biblioteca/form_livro";
	}

	// Cadastra os dados do livro no banco de dados
	@RequestMapping(value = "/cadastrarLivro", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public String form(@RequestParam(value = "imagem") MultipartFile imagem, BibliotecaControllerModel livro, @RequestParam(value = "pdf") MultipartFile pdf)
			throws IOException {
		bibliotecaRepository.save(BibliotecaMapper.converter(livro, imagem, pdf));
		return "redirect:menuGestor";
	}
	
	@GetMapping(value = "/biblioteca")
	public ModelAndView listaLivros() throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("/biblioteca/lista_livros");
		Iterable<Biblioteca> livro = bibliotecaRepository.findAll();

		List<Biblioteca> biblioteca = new ArrayList<>();

		for (Biblioteca livros : livro) {

			String imagem = Base64.getEncoder().encodeToString(livros.getImagem());
			livros.setImagem_string(imagem);
			biblioteca.add(livros);
		}

		mv.addObject("livro", biblioteca);

		return mv;
	}
	
	@RequestMapping(value = "/selectLivro")
	public ModelAndView telaLivro(@RequestParam("idLivro") Long idLivro) {
		Biblioteca livro = bibliotecaRepository.findAllByIdLivro(idLivro);
		ModelAndView mv = new ModelAndView("/biblioteca/exibir_livro");
		String pdf = Base64.getEncoder().encodeToString(livro.getPdf());
		livro.setPdf_string(pdf);
		mv.addObject("livro", livro);
		return mv;
	}
	
	@GetMapping(value = "/bibliotecaAluno")
	public ModelAndView listaLivrosAluno() throws UnsupportedEncodingException {
		ModelAndView mv = new ModelAndView("/biblioteca/lista_livros_aluno");
		Iterable<Biblioteca> livro = bibliotecaRepository.findAll();

		List<Biblioteca> biblioteca = new ArrayList<>();

		for (Biblioteca livros : livro) {

			String imagem = Base64.getEncoder().encodeToString(livros.getImagem());
			livros.setImagem_string(imagem);
			biblioteca.add(livros);
		}

		mv.addObject("livro", biblioteca);

		return mv;
	}
	
	@RequestMapping(value = "/selectLivroAluno")
	public ModelAndView telaLivroAluno(@RequestParam("idLivro") Long idLivro) {
		Biblioteca livro = bibliotecaRepository.findAllByIdLivro(idLivro);
		ModelAndView mv = new ModelAndView("/biblioteca/exibir_livro_aluno");
		String pdf = Base64.getEncoder().encodeToString(livro.getPdf());
		livro.setPdf_string(pdf);
		mv.addObject("livro", livro);
		return mv;
	}
}
