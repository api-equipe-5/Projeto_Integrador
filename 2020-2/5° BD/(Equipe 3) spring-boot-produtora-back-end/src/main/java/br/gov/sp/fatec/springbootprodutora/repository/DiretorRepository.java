package br.gov.sp.fatec.springbootprodutora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootprodutora.entity.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long>{
    public Diretor findByNome(String nomeDiretor);

    public List<Diretor> findByNomeContainsIgnoreCase(String nome);
}