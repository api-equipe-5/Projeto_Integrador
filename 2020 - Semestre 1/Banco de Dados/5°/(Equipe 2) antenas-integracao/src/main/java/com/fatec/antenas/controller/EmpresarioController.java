package com.fatec.antenas.controller;



import javax.mail.SendFailedException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.fatec.antenas.error.ResourceAlreadyExistsException;
import com.fatec.antenas.error.ResourceNotFoundException;
import com.fatec.antenas.model.DocumentEmpresario;
import com.fatec.antenas.model.Usuario;
import com.fatec.antenas.repository.EmpresarioRepository;
import com.fatec.antenas.security.JWTToken;
import com.fatec.antenas.service.EmailService;
import com.fatec.antenas.service.EmpresarioService;
import com.fatec.antenas.util.PasswordEncrypt;

@RestController
@RequestMapping("/empresario")
public class EmpresarioController {
	
	@Autowired
    private EmpresarioRepository empresarioDAO;

	@Autowired
	private EmpresarioService empresarioService;

	@Autowired
	private EmailService emailService;

	@Value("${app.url}")
	private String url;
	
	@PostMapping(path = "/pub/login")
	public ResponseEntity<?> login(@RequestBody Usuario empresario, HttpServletResponse response){
		DocumentEmpresario findEmpresario = empresarioDAO.findByEmail(empresario.getEmail());
		if (!findEmpresario.getAtivo()) {
			return new ResponseEntity<>("Confirme o e-mail antes de logar.", HttpStatus.FORBIDDEN);
		}
		JWTToken jwt = new JWTToken();
		jwt.jwtEmpresario(response, findEmpresario, empresario);
     
        return new ResponseEntity<>(findEmpresario.getEmail(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/pub/save")
	public ResponseEntity<?> save(@Valid @RequestBody DocumentEmpresario empresario) throws SendFailedException {
		
		verifyIfEmpresarioExistsEmail(empresario.getEmail());
		String senha = empresario.getSenha();
		empresario.setSenha(new PasswordEncrypt(senha).getPasswordEncoder());
		emailService.sendMail(empresario.getEmail(),  url + "/empresario/ativa/");
		return new ResponseEntity<>(empresarioDAO.save(empresario), HttpStatus.OK);
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<?> update(@Valid @RequestBody DocumentEmpresario empresario){
		String senha = empresario.getSenha();
		empresario.setSenha(new PasswordEncrypt(senha).getPasswordEncoder());
		return new ResponseEntity<>(empresarioDAO.save(empresario), HttpStatus.OK);
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> listAll(Pageable pageable){
		return new ResponseEntity<>(empresarioDAO.findAll(pageable), HttpStatus.OK);
	}
	
	@DeleteMapping(path="delete/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		verifyIfEmpresarioExistsID(id);
		empresarioDAO.deleteById(id.toString());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(path = "/byEmail/{email}")
	public ResponseEntity<?> getEmpresarioByEmail(@PathVariable String email){
		return new ResponseEntity<>(empresarioDAO.findByEmail(email), HttpStatus.OK);
	}
	
	@GetMapping(path = "/byID")
	public ResponseEntity<?> getEmpresarioByID(@RequestAttribute("idUsuarioLogado") String idEmpresarioLogado){
		return new ResponseEntity<>(empresarioDAO.findById(idEmpresarioLogado), HttpStatus.OK);
	}

	@GetMapping(path = "/ativa/{b64code}")
	public RedirectView ativaEmpresario(@PathVariable String b64code){
		DocumentEmpresario empresario = empresarioService.ativaEmpresario(b64code);
		return new RedirectView("/");
	}

	private void verifyIfEmpresarioExistsID(String id) {
		if(!empresarioDAO.findById(id).isPresent() ) {
			throw new ResourceNotFoundException("Businessman not found dor ID: "+ id);
		}
	}
	
	private void verifyIfEmpresarioExistsEmail(String email) {
		if(empresarioDAO.findByEmail(email) != null) {
			throw new ResourceAlreadyExistsException("Businessman already exists : "+ email);
		}
	}
	
	
}
