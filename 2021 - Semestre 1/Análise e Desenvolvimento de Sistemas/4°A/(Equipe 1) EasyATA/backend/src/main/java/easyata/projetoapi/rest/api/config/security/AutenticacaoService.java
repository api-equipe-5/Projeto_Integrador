package easyata.projetoapi.rest.api.config.security;

import easyata.projetoapi.rest.api.model.UsuarioModel;
import easyata.projetoapi.rest.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioModel> usuarioModel = repository.findByEmail(username);
        if (usuarioModel.isPresent()){
            return usuarioModel.get();
        }
        throw new UsernameNotFoundException("Dados Inválidos! ");
    }
}