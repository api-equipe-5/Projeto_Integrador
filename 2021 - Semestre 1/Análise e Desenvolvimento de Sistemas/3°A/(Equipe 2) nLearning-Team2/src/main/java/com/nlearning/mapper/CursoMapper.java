package com.nlearning.mapper;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.nlearning.models.Curso;
import com.nlearning.models.CursoControllerModel;
import com.nlearning.models.Usuario;

public class CursoMapper {

	public static Curso converter(CursoControllerModel curso, MultipartFile imagem, MultipartFile video) throws IOException {
		
		var cursoBanco = new Curso();
		cursoBanco.setNomeCurso(curso.getNomeCurso());
		cursoBanco.setDescricao(curso.getDescricao());
		cursoBanco.setTutor(curso.getTutor());
		cursoBanco.setImagem(imagem.getBytes());
		cursoBanco.setPilula(video.getBytes());
		cursoBanco.setIdTutor(Usuario.idUsu);
		
		
		return cursoBanco;
	}
}
