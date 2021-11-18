package br.gov.sp.fatec.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootapp.entity.Conversa;

public interface ConversaRepository extends JpaRepository<Conversa, Long> {
    
    @Query("delete from Conversa c where c.id=?1")
    public void deletarConversaPorID(Long id);
}