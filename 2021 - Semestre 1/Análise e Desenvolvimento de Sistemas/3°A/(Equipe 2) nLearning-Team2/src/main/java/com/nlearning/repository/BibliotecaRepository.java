package com.nlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.Biblioteca;

public interface BibliotecaRepository extends CrudRepository<Biblioteca, String> {
	// Procura Aluno por ID
	Biblioteca findByIdLivro(Long codigo);

	// Procura Aluno por Email
	Biblioteca findByNomeLivro(String nome);

	// Procura curso já comprado
	Biblioteca findAllByIdLivro(long codigo);
}
