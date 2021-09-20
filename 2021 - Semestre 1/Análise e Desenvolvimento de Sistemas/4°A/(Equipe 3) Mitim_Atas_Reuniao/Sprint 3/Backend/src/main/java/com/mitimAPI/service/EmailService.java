package com.mitimAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
//import com.mitimAPI.model.Ata;
//import com.mitimAPI.model.Participante;
import com.mitimAPI.model.Usuario;
import com.mitimAPI.repository.UsuarioRepository;

@Service
public class EmailService {

	private static final String APROVACAO_DE_ACESSO = "Aprovação de acesso";

	private static final String SOLICITACAO_DE_ACESSO = "Solicitação de Acesso";

	private static final String ADMINISTRADOR = "Administrador";
	
	private static final String REDEFINICAO_DE_SENHA = "Redefinição de senha";
	
	//private static final String ASSINATURA = "Assinatura de ata";

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
		mensagem.append("Você possui uma nova solicitação de acesso.");
		//mensagem.append(usuario.getNome());
		//mensagem.append("\n");
		//mensagem.append("Área: ");
		//mensagem.append(usuario.getArea());
		//mensagem.append("\n");
		//mensagem.append("Cargo: ");
		//mensagem.append(usuario.getCargo());
		//mensagem.append("\n");
		//mensagem.append("Email: ");
		//mensagem.append(usuario.getEmail());
		//mensagem.append("\n");
		//mensagem.append("Telefone: ");
		//mensagem.append(usuario.getTelefone());
		//mensagem.append("\n");
		//mensagem.append("Senha: ");
		//mensagem.append(usuario.getSenha());
		
		this.sendEmail(usuarioOpt.get().getEmail(), mensagem.toString(), SOLICITACAO_DE_ACESSO);
	}
	
	public void aprovarAcesso(Usuario usuario) {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("Seja bem vindo ao Mitim\n");
		mensagem.append("Agora você tem acesso a plataforma!\n");
		//mensagem.append("Email: ");
		//mensagem.append(usuario.getEmail());
		//mensagem.append("\n");
		//mensagem.append("Senha: ");
		//mensagem.append(usuario.getSenha());
		
		this.sendEmail(usuario.getEmail(), mensagem.toString(), APROVACAO_DE_ACESSO);
			
	}
	
	public void redefineSenha(Usuario usuario) {
		StringBuilder mensagem = new StringBuilder();
		mensagem.append("Acesse o link abaixo para redefinir sua senha!");
		mensagem.append("http://localhost:3000/redsenhafinal!\n");
	
		this.sendEmail(usuario.getEmail(), mensagem.toString(), REDEFINICAO_DE_SENHA);
			
	}
	//public void assinaAta(Ata ata, Participante participante) {
		//StringBuilder mensagem = new StringBuilder();
		//mensagem.append("Código Assinatura: ");
		//mensagem.append(ata.getCodassinatura());
		
		//this.sendEmail(participante.getEmail(), mensagem.toString(), ASSINATURA);
	//}
}
	
	
	


