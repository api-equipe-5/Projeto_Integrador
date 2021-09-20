package com.nlearning.mapper;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.nlearning.models.Biblioteca;
import com.nlearning.models.BibliotecaControllerModel;

public class BibliotecaMapper {

	public static Biblioteca converter(BibliotecaControllerModel livro, MultipartFile imagem, MultipartFile pdf) throws IOException {
		
		var livroBanco = new Biblioteca();
		livroBanco.setNomeLivro(livro.getNomeLivro());
		livroBanco.setDescricao(livro.getDescricao());
		livroBanco.setAutor(livro.getAutor());
		livroBanco.setImagem(imagem.getBytes());
		livroBanco.setPdf(pdf.getBytes());
		
		return livroBanco;
	}
}
