package com.fatec.antenas.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.fatec.antenas.model.DocumentCadi;
import com.fatec.antenas.model.Usuario;
import com.fatec.antenas.repository.CadiRepository;
import com.fatec.antenas.security.JWTToken;
import com.fatec.antenas.util.PasswordEncrypt;

@RestController
@RequestMapping("/cadi")
public class CadiController {
	
	@Autowired
	private CadiRepository cadiDAO;
	
	@PostMapping(path = "/pub/login")
	public ResponseEntity<?> login(@RequestBody Usuario cadi, HttpServletResponse response){
		DocumentCadi findCadi = cadiDAO.findByEmail(cadi.getEmail());
		
		JWTToken jwt = new JWTToken();
		jwt.jwtCadi(response, findCadi, cadi);
     
        return new ResponseEntity<>(findCadi.getEmail(), HttpStatus.OK);
	}
	
	
	@PostMapping(path = "/pub/save")
	public ResponseEntity<?> save(@Valid @RequestBody DocumentCadi cadi){
		verifyIfCadiExistsEmail(cadi.getEmail(), cadi.get_id());
		String senha = cadi.getSenha();
		cadi.setSenha(new PasswordEncrypt(senha).getPasswordEncoder());
		return new ResponseEntity<>(cadiDAO.save(cadi), HttpStatus.OK);
	}
	
	@PostMapping(path = "/update")
	public ResponseEntity<?> update(@Valid @RequestBody DocumentCadi cadi){
		return new ResponseEntity<>(cadiDAO.save(cadi), HttpStatus.OK);
	}
	
	@GetMapping(path = "/all")
	public ResponseEntity<?> listAll(){
		return new ResponseEntity<>(cadiDAO.findAll(), HttpStatus.OK);
	}
	
	@DeleteMapping(path="delete/{id}")
	public ResponseEntity<?> delete(@PathVariable String id){
		verifyIfCadiExistsID(id);
		cadiDAO.deleteById(id.toString());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(path = "byEmail/{email}")
	public ResponseEntity<?> getCadiByEmail(@PathVariable String email){
		return new ResponseEntity<>(cadiDAO.findByEmail(email), HttpStatus.OK);
	}
	
	@GetMapping(path = "/byID")
	public ResponseEntity<?> getCADIbyID(@RequestAttribute("idUsuarioLogado") String idUsuarioLogado){
		return new ResponseEntity<>(cadiDAO.findById(idUsuarioLogado), HttpStatus.OK);
	}

	private void verifyIfCadiExistsEmail(String email, String id) {
		DocumentCadi find = cadiDAO.findByEmail(email);
		if(find != null && !find.get_id().equals(id)) {
			throw new ResourceAlreadyExistsException("cadi already exists : "+ email);
		}
	}

	private void verifyIfCadiExistsID(String id) {
		if(!cadiDAO.findById(id).isPresent() ) {
			throw new ResourceNotFoundException("cadi not found dor ID: "+ id);
		}
	}
}
