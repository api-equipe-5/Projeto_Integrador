package com.pi3.scorewizard.pessoafisica;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends CrudRepository<PessoaFisica, String> {
	ArrayList<PessoaFisica> findAll();

	PessoaFisica findByDocumento(String documento);
}
