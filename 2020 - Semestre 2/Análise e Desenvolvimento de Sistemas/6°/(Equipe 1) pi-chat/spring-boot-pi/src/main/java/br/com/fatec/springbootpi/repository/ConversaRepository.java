package br.com.fatec.springbootpi.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fatec.springbootpi.entity.Conversa;
import br.com.fatec.springbootpi.entity.Usuario;

public interface ConversaRepository extends JpaRepository<Conversa, Long> {

    public Conversa findByIdConversa(Long idConversa);
    
    @Query("select u from Usuario u inner join u.conversas c where c.idConversa = ?1")
    public List<Usuario> buscarUsuariosDaConversa(Long id);

    @Query("select c from Conversa c inner join c.usuarios u where u.idUsuario = ?1")
    public List<Conversa> buscarConversaPeloIdDoUsuario(Long id);
}