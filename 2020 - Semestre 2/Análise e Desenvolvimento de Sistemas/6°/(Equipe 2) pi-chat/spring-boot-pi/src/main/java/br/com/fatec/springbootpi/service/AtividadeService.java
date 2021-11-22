package br.com.fatec.springbootpi.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import br.com.fatec.springbootpi.entity.Atividade;
import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.model.AtividadeForm;
import br.com.fatec.springbootpi.repository.AtividadeRepository;
import br.com.fatec.springbootpi.repository.UsuarioRepository;

@Service
public class AtividadeService {
    
    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @PreAuthorize("isAuthenticated()")
    public Atividade criarAtividade(AtividadeForm novaAtividade) {

        Date dataCriado = new Date();
        
        Atividade atividade = new Atividade();
        
        atividade.setUsuarios(new HashSet<Usuario>());
        atividade.setDataCriado(dataCriado);
        atividade.setDataFechamento(novaAtividade.getDataFechamento());
        atividade.setDataPrevista(novaAtividade.getDataPrevista());
        atividade.setAtividadeAberta(novaAtividade.getAtividadeAberta());
        atividade.setDescAtividade(novaAtividade.getDescricaoAtividade());
        atividade.setTituloAtividade(novaAtividade.getTituloAtividade());
        atividade.setCorAtividade(novaAtividade.getCorAtividade());

        for (Long ids : novaAtividade.getIdUsuarios()) {
            Usuario usuario = usuarioRepository.findByIdUsuario(ids);

            if(usuario != null){
                atividade.getUsuarios().add(usuario);
            }
        }

        atividadeRepository.save(atividade);

        return atividade;
    }

    public List<Atividade> getOpenAtividade(Long idUsuario){
        return atividadeRepository.getAtividadesAbertas(idUsuario);
    }

    public List<Atividade> getCloseAtividade(Long idUsuario){
        return atividadeRepository.getAtividadesFechadas(idUsuario);
    }

    @PreAuthorize("isAuthenticated()")
    public Atividade fecharAtividade(Long idAtividade){
        Atividade atividade = atividadeRepository.findByIdAtividade(idAtividade);

        
        if (atividade != null){
            Date x = new Date();
            atividade.setDataFechamento(x);     
            atividade.setAtividadeAberta(false);
            atividadeRepository.save(atividade);
        }

        return atividade;
    }

}