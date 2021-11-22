package br.com.fatec.springbootpi.security;

import br.com.fatec.springbootpi.entity.TipoUsuario;

public interface ServicoService {
    //public Usuario criarUsuario(String nomeUsuario, String cpfUsuario, Long idTipoUsuario, Date dataCriado);
    public TipoUsuario criarTipoUsuario(String nome);
}