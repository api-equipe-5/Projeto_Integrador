package br.com.fatec.springbootpi.service;

import java.util.Date;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import br.com.fatec.springbootpi.entity.Arquivo;
import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.model.ArquivoForm;
import br.com.fatec.springbootpi.repository.ArquivoRepository;
import br.com.fatec.springbootpi.repository.UsuarioRepository;

@Service
public class ArquivoService {
    
    @Autowired
    private ArquivoRepository arquivoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @PreAuthorize("hasAnyRole('ATENDENTE, ADMIN')")
    public Arquivo criarArquivo(ArquivoForm novoArquivo) {

        Date dataCriado = new Date();
        
        Arquivo arquivo = new Arquivo();
        
        arquivo.setUsuarios(new HashSet<Usuario>());
        arquivo.setDataCriado(dataCriado);
        arquivo.setDescArquivo(novoArquivo.getDescricao());
        arquivo.setNomeArquivo(novoArquivo.getNome());

        for (Long ids : novoArquivo.getIdUsuarios()) {
            Usuario usuario = usuarioRepository.findByIdUsuario(ids);

            if(usuario != null){
                arquivo.getUsuarios().add(usuario);
            }
        }

        arquivoRepository.save(arquivo);

        return arquivo;
    }
}