package com.mitimAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mitimAPI.model.Participante;


public interface ParticipanteRepository extends CrudRepository<Participante, Integer> {
	
	@Query("SELECT u FROM Participante u WHERE u.email = :email")
	static
	Optional<Participante> findByEmail(@Param("email") String email) {
		return null;
	}

}
