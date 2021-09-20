package br.com.fatec.springbootpi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fatec.springbootpi.entity.TipoUsuario;
import br.com.fatec.springbootpi.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {

    @Autowired
    TipoUsuarioRepository tipoUserRepo;

    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public TipoUsuario criarTipoUsuario(String nomeTipoUsuario) {
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setNome(nomeTipoUsuario);

        // Validação
        if (tipoUsuario != null){
            tipoUserRepo.save(tipoUsuario);
        }
    
        return tipoUsuario;
    }

    public List<TipoUsuario> buscarTiposUsuarios() {
        return tipoUserRepo.findAll();
    }

}