package com.nlearning.mapper;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.nlearning.models.Curriculo;
import com.nlearning.models.CurriculoControllerModel;

public class CurriculoMapper {

	public static Curriculo converter(CurriculoControllerModel dados, MultipartFile curriculo) throws IOException {

		var curriculoBanco = new Curriculo();
		curriculoBanco.setNome(dados.getNome());
		curriculoBanco.setTelefone(dados.getTelefone());
		curriculoBanco.setEmail(dados.getEmail());
		curriculoBanco.setCurriculo(curriculo.getBytes());

		return curriculoBanco;
	}
}
