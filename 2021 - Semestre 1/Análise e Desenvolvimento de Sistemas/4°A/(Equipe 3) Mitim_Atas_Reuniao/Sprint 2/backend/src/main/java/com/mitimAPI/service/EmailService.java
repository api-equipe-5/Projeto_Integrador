package com.mitimAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mitimAPI.model.Usuario;
import com.mitimAPI.repository.UsuarioRepository;

@Service
public class EmailService {

	private static final String APROVACAO_DE_ACESSO = "Aprovação de acesso";

	private static final String SOLICITACAO_DE_ACESSO = "Solicitação de Acesso";

	private static final String ADMINISTRADOR = "Administrador";

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void sendEmail(String destinatario, String mensagem, String titulo) {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(destinatario);

		msg.setSubject(titulo);
		msg.setText(mensagem);

		javaMailSender.send(msg);
	}
	
	public void solicitarAcesso(Usuario usuario	) throws Exception {
		Optional<Usuario> usuarioOpt = usuarioRepository.findAdministrator(ADMINISTRADOR);
		if (!usuarioOpt.isPresent()) {
			throw new Exception("Administrador não encontrado!");
		}
		
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("Nome: ");
		mensagem.append(usuario.getNome());
		mensagem.append("\n");
		mensagem.append("Área: ");
		mensagem.append(usuario.getArea());
		mensagem.append("\n");
		mensagem.append("Cargo: ");
		mensagem.append(usuario.getCargo());
		mensagem.append("\n");
		mensagem.append("Email: ");
		mensagem.append(usuario.getEmail());
		mensagem.append("\n");
		mensagem.append("Telefone: ");
		mensagem.append(usuario.getTelefone());
		mensagem.append("\n");
		mensagem.append("Senha: ");
		mensagem.append(usuario.getSenha());
		
		this.sendEmail(usuarioOpt.get().getEmail(), mensagem.toString(), SOLICITACAO_DE_ACESSO);
	}
	
	public void aprovarAcesso(Usuario usuario) {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("Seja bem vindo ao Mitim\n");
		mensagem.append("Seguem dados de acesso: \n");
		mensagem.append("Email: ");
		mensagem.append(usuario.getEmail());
		mensagem.append("\n");
		mensagem.append("Senha: ");
		mensagem.append(usuario.getSenha());
		
		this.sendEmail(usuario.getEmail(), mensagem.toString(), APROVACAO_DE_ACESSO);
	}

}
