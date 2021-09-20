package com.fatec.antenas.controller;



import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import com.fatec.antenas.error.ResourceAlreadyExistsException;
import com.fatec.antenas.error.ResourceNotFoundException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fatec.antenas.error.CredentialNotFoundException;
import com.fatec.antenas.model.DocumentEmpresario;
import com.fatec.antenas.model.Usuario;
import com.fatec.antenas.repository.EmpresarioRepository;
import com.fatec.antenas.util.PasswordEncrypt;
import com.fatec.antenas.security.JWTToken;

@RestController
@RequestMapping("/empresario")
public class EmpresarioController {
	
	@Autowired
    private EmpresarioRepository empresarioDAO;
	
	@PostMapping(path = "/login")
	public ResponseEntity<?> login(@RequestBody Usuario empresario, HttpServletResponse response){
		DocumentEmpresario findEmpresario = empresarioDAO.findByEmail(empresario.getEmail());
		
		JWTToken jwt = new JWTToken();
		jwt.jwtGenerate(response, findEmpresario, empresario);
     
        return new ResponseEntity<>(findEmpresario.getEmail(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/save")
	public ResponseEntity<?> save(@Valid @RequestBody DocumentEmpresario empresario){
		
		verifyIfEmpresarioExistsEmail(empresario.getEmail());
		String senha = empresario.getSenha();
		empresario.setSenha(new PasswordEncrypt(senha).getPasswordEncoder());
		
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
	public ResponseEntity<?> getEmpresarioByID(@RequestAttribute("idUsuarioLogado") String idUsuarioLogado){
		return new ResponseEntity<>(empresarioDAO.findById(idUsuarioLogado), HttpStatus.OK);
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
