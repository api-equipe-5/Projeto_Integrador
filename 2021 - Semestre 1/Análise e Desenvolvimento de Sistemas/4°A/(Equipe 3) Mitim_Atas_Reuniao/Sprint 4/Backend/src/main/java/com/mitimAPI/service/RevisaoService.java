package com.mitimAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitimAPI.model.Revisao;
import com.mitimAPI.repository.RevisaoRepository;
@Service
public class RevisaoService {
	
	@Autowired
	RevisaoRepository revisaoRepository;

	public Optional<Revisao> findById(Integer id) {
		
		return revisaoRepository.findById(id);
	}
	
	public void delete(Revisao revisao) {
		revisaoRepository.delete(revisao);
	}
	
	public void save(Revisao revisao) {
		revisao.setId(null);
		revisaoRepository.save(revisao);
	}
	
	public void update(Revisao revisao) {
		if(revisao.getId() != null) {
			revisaoRepository.save(revisao);
		}
	}
	public Iterable<Revisao> findAll(){
		return revisaoRepository.findAll();
	}

}
