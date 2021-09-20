package com.mitimAPI.service;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mitimAPI.model.Ata;
import com.mitimAPI.model.Participante;
import com.mitimAPI.repository.ParticipanteRepository;

@Service
public class AssinaturaService {
	
	private static final String ASSINATURA = "Assinatura de ata";
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	ParticipanteRepository participanteRepository;
	
	public void sendEmail(String destinatario, String mensagem, String titulo) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(destinatario);

		msg.setSubject(titulo);
		msg.setText(mensagem);

		javaMailSender.send(msg);
	}
	
	public void assinaAta(Ata ata, Participante participante) {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("Código Assinatura: ");
		mensagem.append(ata.getCodassinatura());
		
		this.sendEmail(participante.getEmail(), mensagem.toString(), ASSINATURA);
	}
	//public Participante assina(String idata, String email) {
		//Optional<Participante> participanteOp = ParticipanteRepository.findByEmail(email);
		//if (participanteOp.isPresent()) {
			//if (participanteOp.get().getIdata().equals(idata)) {			
			//}}	
		//return null;}
	
	
	

}
