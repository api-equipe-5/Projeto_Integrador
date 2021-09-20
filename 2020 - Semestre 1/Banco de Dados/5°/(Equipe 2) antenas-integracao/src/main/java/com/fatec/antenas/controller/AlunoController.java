package com.fatec.antenas.controller;

import javax.mail.SendFailedException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.fatec.antenas.error.ResourceAlreadyExistsException;
import com.fatec.antenas.error.ResourceNotFoundException;
import com.fatec.antenas.model.DocumentAluno;
import com.fatec.antenas.model.Usuario;
import com.fatec.antenas.repository.AlunoRepository;
import com.fatec.antenas.security.JWTToken;
import com.fatec.antenas.util.PasswordEncrypt;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoDAO;
	
	@PostMapping(path = "/pub/login")
	public ResponseEntity<?> login(@RequestBody Usuario aluno, HttpServletResponse response){
		DocumentAluno findAluno = alunoDAO.findByEmail(aluno.getEmail());
		
		JWTToken jwt = new JWTToken();
		jwt.jwtAluno(response, findAluno, aluno);
     
        return new ResponseEntity<>(findAluno.getEmail(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/pub/save")
	public ResponseEntity<?> save(@Valid @RequestBody DocumentAluno aluno) throws SendFailedException {
		verifyIfAlunoExistsEmail(aluno.getEmail());
		String senha = aluno.getSenha();
		aluno.setSenha(new PasswordEncrypt(senha).getPasswordEncoder());
		return new ResponseEntity<>(alunoDAO.save(aluno), HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<?> update(@Valid @RequestBody DocumentAluno aluno){
		return new ResponseEntity<>(alunoDAO.save(aluno), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> listAll(Pageable pageable){
		return new ResponseEntity<>(alunoDAO.findAll(pageable), HttpStatus.OK);
	}
	
	@DeleteMapping(path="delete/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		verifyIfAlunoExistsID(id);
		alunoDAO.deleteById(id.toString());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(path = "byEmail/{email}")
	public ResponseEntity<?> getalunoByEmail(@PathVariable String email){
		return new ResponseEntity<>(alunoDAO.findByEmail(email), HttpStatus.OK);
	}
	
	@GetMapping(path = "/byID")
	public ResponseEntity<?> getEmpresarioByID(@RequestAttribute("idUsuarioLogado") String idUsuarioLogado){
		return new ResponseEntity<>(alunoDAO.findById(idUsuarioLogado), HttpStatus.OK);
	}

	
	private void verifyIfAlunoExistsID(String id) {
		if(!alunoDAO.findById(id).isPresent() ) {
			throw new ResourceNotFoundException("Businessman not found dor ID: "+ id);
		}
	}
	
	private void verifyIfAlunoExistsEmail(String email) {
		if(alunoDAO.findByEmail(email) != null) {
			throw new ResourceAlreadyExistsException("Businessman already exists : "+ email);
		}
	}
}
