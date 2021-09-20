package easyata.projetoapi.rest.api.config.security;

import easyata.projetoapi.rest.api.model.UsuarioModel;
import easyata.projetoapi.rest.api.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UsuarioRepository usuarioRepository;

    PasswordEncoder passwordEncoder;

    public UserService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    public UsuarioModel save(UsuarioModel usuarioModel){
        String encodedPassword = this.passwordEncoder.encode(usuarioModel.getSenha());
        usuarioModel.setSenha(encodedPassword);
        return this.usuarioRepository.save(usuarioModel);
    }
}
