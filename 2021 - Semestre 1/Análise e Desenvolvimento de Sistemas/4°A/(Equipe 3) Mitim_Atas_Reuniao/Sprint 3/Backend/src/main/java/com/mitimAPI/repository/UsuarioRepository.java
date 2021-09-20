package com.mitimAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mitimAPI.model.Usuario;

// This will be AUTO IMPLEMENTED by Spring into a Bean called UsuarioRepository
// CRUD refers Create, Read, Update, Delete

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
	@Query("SELECT u FROM Usuario u WHERE u.email = :email")
	Optional<Usuario> findByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM Usuario u WHERE u.cargo = :cargo")
	Optional<Usuario> findAdministrator(@Param("cargo") String cargo);
	
}
