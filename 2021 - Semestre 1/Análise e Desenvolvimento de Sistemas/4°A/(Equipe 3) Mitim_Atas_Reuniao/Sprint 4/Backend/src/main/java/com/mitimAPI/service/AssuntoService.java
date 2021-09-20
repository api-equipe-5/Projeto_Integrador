package com.mitimAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitimAPI.model.Assunto;
import com.mitimAPI.repository.AssuntoRepository;

@Service
public class AssuntoService {
	
	@Autowired
	AssuntoRepository assuntoRepository;

	public Optional<Assunto> findById(Integer id) {	
		return assuntoRepository.findById(id);
	}
	
	public void delete(Assunto assunto) {
		assuntoRepository.delete(assunto);
	}
	
	public void save(Assunto assunto) {
		assunto.setId(null);
		assuntoRepository.save(assunto);
	}
	
	public void update(Assunto assunto) {
		if(assunto.getId() != null) {
			assuntoRepository.save(assunto);
		}
	}
	public Iterable<Assunto> findAll(){
		return assuntoRepository.findAll();
	}

}
