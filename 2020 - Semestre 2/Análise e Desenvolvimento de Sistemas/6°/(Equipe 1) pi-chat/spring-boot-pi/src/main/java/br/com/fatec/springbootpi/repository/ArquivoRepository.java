package br.com.fatec.springbootpi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fatec.springbootpi.entity.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {

   // @Query("select a from Arquivo a inner join a.usuario u where a.nome_arquivo = ?1")
   // public Arquivo buscarArquivosDeUsuario(String nome);
    
   @Query("select a from Arquivo a inner join a.usuarios u where u.idUsuario = ?1")
    public List<Arquivo> getArquivosPorUsuario(Long idUsuario);
}