package br.com.fatec.springbootpi.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.fatec.springbootpi.entity.Conversa;
import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.model.Form.CriarConversaForm;
import br.com.fatec.springbootpi.repository.ConversaRepository;
import br.com.fatec.springbootpi.repository.UsuarioRepository;

@Service
public class ConversaService {
    
    @Autowired
    private ConversaRepository conversaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Conversa> listConversaById(long id){
        List<Conversa> conversa = conversaRepository.buscarConversaPeloIdDoUsuario(id);
        return conversa;
    }

    @Transactional
    @PreAuthorize("isAuthenticated()")
    public Conversa cadastrarConversa(CriarConversaForm criarConversaForm){
        Conversa conversa = new Conversa();     
        conversa.setUsuarios(new HashSet<Usuario>());
                
        for (Long ids : criarConversaForm.getIdUsuarios()) {
            Usuario usuario = usuarioRepository.findByIdUsuario(ids);

            if(usuario != null){
                conversa.getUsuarios().add(usuario);
            }
        }               
                
        conversaRepository.save(conversa);                         

        return conversa;
    }
}