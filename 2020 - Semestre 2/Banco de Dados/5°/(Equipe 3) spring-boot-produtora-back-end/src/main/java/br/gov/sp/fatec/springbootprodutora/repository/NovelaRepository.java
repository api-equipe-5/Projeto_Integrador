package br.gov.sp.fatec.springbootprodutora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springbootprodutora.entity.Novela;

public interface NovelaRepository extends JpaRepository<Novela, Long>{

    public Novela findByNome(String nome); 

    public Novela findByAnoAndCapitulo(Long ano, Long Capitulo);
   
}