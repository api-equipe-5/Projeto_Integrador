package br.gov.sp.fatec.springbootprodutora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootprodutora.entity.Ator;

public interface AtorRepository extends JpaRepository<Ator, Long>{
    public Ator findByNome(String atorNome);

    public List<Ator> findByNomeContainsIgnoreCase(String nome);
}