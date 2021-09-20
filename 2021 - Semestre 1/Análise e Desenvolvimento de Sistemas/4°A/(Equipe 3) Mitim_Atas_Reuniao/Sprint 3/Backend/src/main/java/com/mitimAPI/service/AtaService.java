package com.mitimAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitimAPI.model.Ata;
import com.mitimAPI.repository.AtaRepository;



@Service
public class AtaService {
	
	@Autowired
	private AtaRepository ataRepository;
	
	@Autowired
	private AddNumeroService addNumeroService;

	public Optional<Ata> findById(Integer id) {
		
		return ataRepository.findById(id);
	}
	
	public void delete(Ata ata) {
		ataRepository.delete(ata);
	}
	
	public void save(Ata ata) {
		ata.setId(null);
		ata = ataRepository.save(ata);
		addNumeroService.save(ata);
	}
	
	public void update(Ata ata) {
		if(ata.getId() != null) {
			ataRepository.save(ata);
		}
	}
	public Iterable<Ata> findAll(){
		return ataRepository.findAll();
	}
}
