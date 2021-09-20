package com.nlearning.mapper;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.nlearning.models.Questao;

public class QuestaoMapper {

	public static Questao converter(MultipartFile pergunta, Long idCurso, MultipartFile video, String forms) throws IOException {

		var questoes = new Questao();
		
		if (pergunta.getOriginalFilename() == "") {
			questoes.setPergunta(null);
		}
		else {
			questoes.setPergunta(pergunta.getBytes());
		}
		questoes.setIdCurso(idCurso);
		
		if (video.getOriginalFilename() == "") {
			questoes.setVideo(null);
		}
		else {
			questoes.setVideo(video.getBytes());
		}
		questoes.setForms(forms);

		return questoes;
	}
}
