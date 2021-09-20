package com.mitimAPI.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mitimAPI.model.Participante;
import com.mitimAPI.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
	
	@Autowired
	ParticipanteRepository participanteRepository;

	public Optional<Participante> findById(Integer id) {
		
		return participanteRepository.findById(id);
	}
	
	public void delete(Participante participante) {
		participanteRepository.delete(participante);
	}
	
	public void save(Participante participante) {
		participante.setId(null);
		participanteRepository.save(participante);
	}
	
	public void update(Participante participante) {
		if(participante.getId() != null) {
			participanteRepository.save(participante);
		}
	}
	public Iterable<Participante> findAll(){
		return participanteRepository.findAll();
	}
	
	

}
