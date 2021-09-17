package br.gov.sp.fatec.springbootprodutora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootprodutora.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

    public Filme findByNome(String nome);

    public List<Filme> findByDiretorNome(String nome);

    @Query("select f from Filme f inner join f.diretor d where d.nome =?1")
    public List<Filme> buscaFilmePorDiretor(String diretor);

    @Query("select f from Filme f inner join f.diretor d where f.nome = ?1 and d.nome = ?2")
    public Filme buscaFilmePorNomeEDiretor(String filme, String diretor);
}