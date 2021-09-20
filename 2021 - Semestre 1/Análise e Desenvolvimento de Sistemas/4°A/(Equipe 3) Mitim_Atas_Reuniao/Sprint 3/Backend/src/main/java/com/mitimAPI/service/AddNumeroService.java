package com.mitimAPI.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitimAPI.model.Ata;
import com.mitimAPI.repository.AtaRepository;


@Service
public class AddNumeroService {
	
	@Autowired
	AtaRepository ataRepository;
	
	@SuppressWarnings("deprecation")
	public void save(Ata ata) {
		ata.setNumero(ata.getId() + "/" + (new Date().getYear() + "").substring(1));
		ataRepository.save(ata);
	
	}
	

	

}
