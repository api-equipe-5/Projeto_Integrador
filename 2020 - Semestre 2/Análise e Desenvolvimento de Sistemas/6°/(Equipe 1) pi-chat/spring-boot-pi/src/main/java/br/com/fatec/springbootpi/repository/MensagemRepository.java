package br.com.fatec.springbootpi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fatec.springbootpi.entity.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem,Long> {
    @Query("select m from Mensagem m inner join m.conversas c where c.idConversa = ?1")
    public List<Mensagem> getMensagensPorConversa(Long idConversa);
    
    public Mensagem findByIdMensagem(Long idMensagem);
}