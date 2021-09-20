package br.gov.sp.fatec.springbootapp.service;

import java.util.List;

import br.gov.sp.fatec.springbootapp.entity.Autorizacao;
import br.gov.sp.fatec.springbootapp.entity.Usuario;

public interface SegurancaService{

    public Usuario criarUsuario(String nome, String senha, String autorizacao);

    public List<Usuario> buscarTodosUsuarios();

    public Usuario buscarUsuarioPorId(Long id);

    public Usuario buscarUsuarioPorNome(String nome);

    public Usuario buscarUsuarioPorNomeESenha(String nome, String senha);

    public Autorizacao buscarAutorizacaoPorNome(String nome);
    
    public Usuario alterarSenha(String senha, Long id);
}