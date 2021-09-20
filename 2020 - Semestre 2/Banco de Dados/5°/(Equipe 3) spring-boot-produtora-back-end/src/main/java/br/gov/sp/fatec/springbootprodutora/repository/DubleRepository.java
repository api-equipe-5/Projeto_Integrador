package br.gov.sp.fatec.springbootprodutora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootprodutora.entity.Duble;

public interface DubleRepository extends JpaRepository<Duble, Long>{
    public Duble findByNome(String dubleNome);

    public List<Duble> findByNomeContainsIgnoreCase(String nome);
}


