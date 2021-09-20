package com.fatec.API3.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fatec.API3.model.Alunos;
import com.fatec.API3.repository.AlunosRepository;

@Controller
@RequestMapping("/")
public class AlunosController {
	
	private static String caminhoimagens = "C:\\Users\\kiabi\\OneDrive\\Documentos\\Imagens_API3";
	
	@Autowired
	private AlunosRepository AR;
	
	
	@GetMapping("/help")
	public String help(){
		return "/help/paghelp"; 
	}  
	
	@GetMapping("/index")
	public String index(){
		return "index"; 
	}  
	
	@GetMapping("/divcad")
	public String divcad(){
		return "divcad";
	} 
	
	@GetMapping("/div")
	public String div(){
		return "div";
	}
	
	@GetMapping("/homealuno")
	public String homealuno(){
		return "/aluno/homealuno"; 
}
	
	@GetMapping("/cadastroaluno")
	public String cadastroaluno(){
		return "/entrada/cadastroaluno";
	}
	
	@PostMapping("/cadastroaluno")
	//Verificando se o email já está cadastrado.
	public String cadastroalunop(Alunos alunos){
		boolean existe = AR.existsByemail(alunos.getEmail());
		if(existe) {return "redirect:cadastroluno";}
		String senha = alunos.getSenha();
		String senhaenc = new BCryptPasswordEncoder().encode(senha);
		alunos.setSenha(senhaenc);
	//Colocando propriedades para o envio de email.
		Properties props = new Properties();
	    /** Parâmetros de conexão com servidor Gmail */
		
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class",
	    "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");

	    Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	           protected PasswordAuthentication getPasswordAuthentication()
	           {
	                 return new PasswordAuthentication("timeslim123@gmail.com",
	                 "@Timeslim321");
	           }
	      });

	    /** Ativa Debug para sessão */
	    session.setDebug(true);
	    
	    //Enviando email com os dados revertidos.
	    try {

	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress("timeslim123@gmail.com"));
	      //Remetente

	      Address[] toUser = InternetAddress //Destinatário(s)
	                 .parse(alunos.getEmail());

	      message.setRecipients(Message.RecipientType.TO, toUser);
	      message.setSubject("Bem vindo a Neduc");//Assunto
	      message.setText("Email enviado para confirmação do seu cadastro em nossa plataforma! \n Muito Obrigado!");
	      /**Método para enviar a mensagem criada*/
	      Transport.send(message);

	      System.out.println("Mensagem enviada!!!");

	     } catch (MessagingException e) {
	        throw new RuntimeException(e);}
		AR.save(alunos);
		return "redirect:loginaluno";
	}
	
	@GetMapping("/loginaluno")
	public String loginaluno(){
		return "/loginaluno";
	}
	
	@PostMapping("/loginaluno")
	public String loginalunop(Alunos alunos) throws Exception{
		
		Alunos aluno = AR.findByemail(alunos.getEmail());
		if (aluno == null) {
			//colocar uma mensagem que não foi achado o email.
			return "redirect:index";
		}
		
		if(!aluno.getSenha().equals(alunos.getSenha())) {
			//colocar que a senha tá errada.
			return "redirect:index";}
		
		return "redirect:Homealuno";
	}
	
	@GetMapping("/recuperarsenha")
	public String recuperarsenha(){
		return "/recuperarsenha";
	} 
	@PostMapping("/recuperarsenha")
	public String recuperarsenhap(Alunos alunos){
		Alunos aluno = AR.findByemail(alunos.getEmail());
		if (aluno != null) {
		Properties props = new Properties();
	    /** Parâmetros de conexão com servidor Gmail */
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class",
	    "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");

	    Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	           protected PasswordAuthentication getPasswordAuthentication()
	           {
	                 return new PasswordAuthentication("timeslim123@gmail.com",
	                 "@Timeslim321");
	           }
	      });

	    /** Ativa Debug para sessão */
	    session.setDebug(true);
	    
	    //Enviando email com os dados revertidos.
	    try {

	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress("timeslim123@gmail.com"));
	      //Remetente

	      Address[] toUser = InternetAddress //Destinatário(s)
	                 .parse(alunos.getEmail());

	      message.setRecipients(Message.RecipientType.TO, toUser);
	      message.setSubject("Recuperação de senha Neduc");//Assunto
	      String texto = "Olá! não se preocupe, já cuidei disso para você... Sua senha é: " + aluno.getSenha(); 
	      message.setText(texto);
	      /**Método para enviar a mensagem criada*/
	      Transport.send(message);

	      System.out.println("Mensagem enviada!!!");

	     } catch (MessagingException e) {
	        throw new RuntimeException(e);}
		}
		return "redirect:loginaluno";
	}
	
	@GetMapping("/tarefas")
	public String tarefasaluno(){
		return "/tarefas";
	}
	
	@PostMapping("/tarefas") 
	public String uploadtarefas(Alunos alunos, @RequestParam("file") MultipartFile arquivo) throws IOException {
		if (!arquivo.isEmpty()) {
			byte[] bytes = arquivo.getBytes();
			Path caminho = Paths
					.get(caminhoimagens + String.valueOf(alunos.getId()) + arquivo.getOriginalFilename());
			Files.write(caminho, bytes);

			alunos.setNomearquivo(String.valueOf(alunos.getId()) + arquivo.getOriginalFilename());
			AR.save(alunos);
		}
		return"redirect:Homealuno";
	
}
}

