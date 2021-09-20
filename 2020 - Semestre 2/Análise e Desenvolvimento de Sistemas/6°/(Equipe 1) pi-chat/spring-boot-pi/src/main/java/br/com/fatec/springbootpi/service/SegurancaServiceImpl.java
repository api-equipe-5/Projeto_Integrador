package br.com.fatec.springbootpi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.repository.UsuarioRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCpfUsuario(cpf);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuario com documento: " + cpf + "nao foi encontrado!");
        }

        return User.builder()
            .username(usuario.getNomeUsuario())
            .password(usuario.getSenha())
            .authorities(usuario.getTiposUsuarios().getNome())
            .build();
    }
    
}