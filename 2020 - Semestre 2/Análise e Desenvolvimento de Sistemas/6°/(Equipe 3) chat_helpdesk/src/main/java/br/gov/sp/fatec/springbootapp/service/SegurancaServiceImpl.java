package br.gov.sp.fatec.springbootapp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springbootapp.entity.Autorizacao;
import br.gov.sp.fatec.springbootapp.entity.Usuario;
import br.gov.sp.fatec.springbootapp.exception.RegistroNaoEncontradoException;
import br.gov.sp.fatec.springbootapp.repository.AutorizacaoRepository;
import br.gov.sp.fatec.springbootapp.repository.UsuarioRepository;


@Service("segurancaService")
public class SegurancaServiceImpl implements SegurancaService{

    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    AutorizacaoRepository autRepo;

    @Override
    @Transactional
    public Usuario criarUsuario(String nome, String senha, String autorizacao){
        Autorizacao aut = autRepo.findByNome(autorizacao);

        if(aut == null){
            aut = new Autorizacao();
            aut.setNome(autorizacao);
            autRepo.save(aut);
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> buscarTodosUsuarios(){
        return usuarioRepo.findAll();
    }

    @Override
    @Transactional
    public Usuario buscarUsuarioPorId(Long id){
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);

        if(usuarioOp.isPresent()){
            return usuarioOp.get();
        }
        throw new RegistroNaoEncontradoException("Usuario não encontrado");
    }

    @Override
    @Transactional
    public Usuario buscarUsuarioPorNome(String nome){
        Usuario usuario = usuarioRepo.buscaUsuarioPorNome(nome);

        if(usuario == null){
            throw new RegistroNaoEncontradoException("Usuario não existe");
        }
        return usuario;
    }

    @Override
    @Transactional
    public Autorizacao buscarAutorizacaoPorNome(String nome) {
        Autorizacao autorizacao = autRepo.findByNome(nome);
        if(autorizacao == null){
            throw new RegistroNaoEncontradoException("Autorização não existe");
        }
        return autorizacao;
    }

    @Override
    public Usuario buscarUsuarioPorNomeESenha(String nome, String senha) {
        Usuario usuario = usuarioRepo.buscaUsuaioPorNomeESenha(nome, senha);
        
        return usuario;
    }

    @Override
    @Transactional
    public Usuario alterarSenha(String senha, Long id) {
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);

        if(usuarioOp.isPresent()){
            Usuario usuario = usuarioOp.get();

            usuario.setSenha(senha);
            usuarioRepo.save(usuario);
            return usuario;
        
        }
        throw new RegistroNaoEncontradoException("Usuario não encontrado");
    }


    
}