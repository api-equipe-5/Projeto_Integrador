package br.gov.sp.fatec.springbootprodutora.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootprodutora.entity.Autorizacao;
import br.gov.sp.fatec.springbootprodutora.entity.Usuario;
import br.gov.sp.fatec.springbootprodutora.exception.RegistroNaoEncontradoException;
import br.gov.sp.fatec.springbootprodutora.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springbootprodutora.repository.UsuarioRepository;

@Service("SegurancaService")  //Component
public class SegurancaServiceImpl implements SegurancaService {
    
    @Autowired
    private AutorizacaoRepository autoRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PasswordEncoder passEncoder;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<Usuario>buscarTodosUsuarios()
    {
        return usuarioRepo.findAll();
    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
    public Usuario buscarUsuarioPorId(Long id)
    {
        Optional<Usuario> usuarioOp= usuarioRepo.findById(id);
        if(usuarioOp.isPresent())
        {
            return usuarioOp.get();
        }
         throw new RegistroNaoEncontradoException("usuario nao encontrado!");
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Usuario buscarUsuarioPorNome(String nome)
    {
        Usuario usuario = usuarioRepo.findByNome(nome);
        if(usuario!=null)
        {
            return usuario;
        }
        throw new RegistroNaoEncontradoException("usuario nao encontrado!");
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Autorizacao buscarAutorizacaoPorNome(String nome) {
        Autorizacao autorizacao = autoRepo.findByNome(nome);
        if (autorizacao != null) {
            return autorizacao;
        }
        throw new RegistroNaoEncontradoException("autorizacao nao encontrada!");
    }

    @Transactional
    public Usuario criaUsuario(String nome, String senha, String autorizacao) {
        Autorizacao aut = autoRepo.findByNome(autorizacao);
        if(aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autoRepo.save(aut);
        }
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(passEncoder.encode(senha));
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);

        return usuario;
    }

    @Transactional
    public Usuario updateUsuario(Long id, String nome, String senha, String autorizacao) {

        Autorizacao aut = autoRepo.findByNome(autorizacao);
        if (aut == null) {
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autoRepo.save(aut);
        }

        return usuarioRepo.findById(id)
           .map(user -> {
               user.setNome(nome);
               user.setSenha(senha);
               Usuario updated = usuarioRepo.save(user);

               return updated;
        }).orElse(null);

    }

    public void deleteUsuario(Long id) {
        usuarioRepo.deleteById(id);       
    }

    //criando método para realizar login
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.findByNome(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário " + username + " não encontrado! ");
        }
        return User.builder().username(username).password(usuario.getSenha())
                .authorities(usuario.getAutorizacoes().stream()
                    .map(Autorizacao::getNome).collect(Collectors.toList())
                     .toArray(new String[usuario.getAutorizacoes().size()]))
                .build();
    }
}