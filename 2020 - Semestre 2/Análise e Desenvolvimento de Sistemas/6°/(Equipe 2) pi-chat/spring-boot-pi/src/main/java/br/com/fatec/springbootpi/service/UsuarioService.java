package br.com.fatec.springbootpi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fatec.springbootpi.entity.TipoUsuario;
import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.exception.RegisterNotFound;
import br.com.fatec.springbootpi.repository.TipoUsuarioRepository;
import br.com.fatec.springbootpi.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private TipoUsuarioRepository tipoUserRepo;

    @Autowired
    private PasswordEncoder passEncoder;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public Usuario criarUsuario(String nomeUsuario, String cpfUsuario, Long idTipoUsuario, String senha) {
        Date dataAtual = new Date();

        Usuario usuario = new Usuario();

        TipoUsuario tipoUser = tipoUserRepo.findByIdTipoUsuario(idTipoUsuario);
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setCpfUsuario(cpfUsuario);
        usuario.setTiposUsuarios(tipoUser);
        usuario.setDataCriado(dataAtual);
        usuario.setSenha(passEncoder.encode(senha));

        userRepo.save(usuario);

        return usuario;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Usuario buscarPorId(Long id){
        return userRepo.findByIdUsuario(id);
    }

    @PreAuthorize("isAuthenticated()")
    public Usuario editarUsuario(Long id, Usuario userUpdate){
        Usuario usuario = userRepo.findByIdUsuario(id);
        if (usuario != null){
            usuario.setNomeUsuario(userUpdate.getNomeUsuario());
            usuario.setCpfUsuario(userUpdate.getCpfUsuario());

            userRepo.save(usuario);
        }

        else
            throw new RegisterNotFound("Usuário não encontrado.");

        return usuario;
        
    }

    public void apagarUsuario(Long id){
        userRepo.deleteById(id);
    }

    public Usuario buscarPorCpf(String cpf) {
        return userRepo.findByCpfUsuario(cpf);
    }

    public List<Usuario> buscarUsuarios() {
        return userRepo.findAll();
    }
    
}