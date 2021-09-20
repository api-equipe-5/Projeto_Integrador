package com.fatec.antenas.controller;

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
import com.fatec.antenas.model.DocumentProfessor;
import com.fatec.antenas.model.Usuario;
import com.fatec.antenas.repository.ProfessorRepository;
import com.fatec.antenas.security.JWTToken;
import com.fatec.antenas.util.PasswordEncrypt;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository professorDAO;
	
	@PostMapping(path = "/pub/login")
	public ResponseEntity<?> login(@RequestBody Usuario professor, HttpServletResponse response){
		DocumentProfessor findProfessor = professorDAO.findByEmail(professor.getEmail());
		
		JWTToken jwt = new JWTToken();
		jwt.jwtProfessor(response, findProfessor, professor);
     
        return new ResponseEntity<>(findProfessor.getEmail(), HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/pub/save")
	public ResponseEntity<?> save(@Valid @RequestBody DocumentProfessor professor){
		verifyIfProfessorExistsEmail(professor.getEmail(), professor.get_id());
		String senha = professor.getSenha();
		professor.setSenha(new PasswordEncrypt(senha).getPasswordEncoder());
		return new ResponseEntity<>(professorDAO.save(professor), HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<?> update(@Valid @RequestBody DocumentProfessor professor){
		return new ResponseEntity<>(professorDAO.save(professor), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> listAll(Pageable pageable){
		return new ResponseEntity<>(professorDAO.findAll(), HttpStatus.OK);
	}
	
	@DeleteMapping(path="delete/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		verifyIfProfessorExistsID(id);
		professorDAO.deleteById(id.toString());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(path = "byEmail/{email}")
	public ResponseEntity<?> getprofessorByEmail(@PathVariable String email){
		return new ResponseEntity<>(professorDAO.findByEmail(email), HttpStatus.OK);
	}
	
	@GetMapping(path = "/byID")
	public ResponseEntity<?> getEmpresarioByID(@RequestAttribute("idUsuarioLogado") String idUsuarioLogado){
		return new ResponseEntity<>(professorDAO.findById(idUsuarioLogado), HttpStatus.OK);
	}

	private void verifyIfProfessorExistsID(String id) {
		if(!professorDAO.findById(id).isPresent() ) {
			throw new ResourceNotFoundException("Businessman not found dor ID: "+ id);
		}
	}
	
	private void verifyIfProfessorExistsEmail(String email, String id) {
		DocumentProfessor find = professorDAO.findByEmail(email);
		if(find != null && !find.get_id().equals(id)) {
			throw new ResourceAlreadyExistsException("Professor already exists : "+ email);
		}
	}
}
