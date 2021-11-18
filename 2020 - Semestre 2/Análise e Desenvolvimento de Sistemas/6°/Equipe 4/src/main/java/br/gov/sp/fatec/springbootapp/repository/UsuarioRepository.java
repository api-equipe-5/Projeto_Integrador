package br.gov.sp.fatec.springbootapp.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.springbootapp.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    public List<Usuario> findByNomeContainsIgnoreCase(String nome);

    public Usuario findByNome(String nome);

    @Query("select u from Usuario u where u.nome = ?1")
    public Usuario buscaUsuarioPorNome(String nome);

    public Usuario findByNomeAndSenha(String nome, String senha);

    //jpq da pra fazer consultas maiores
    @Query("select u from Usuario u where u.nome = ?1 and u.senha = ?2")
    public Usuario buscaUsuaioPorNomeESenha(String nome, String senha);

    public List<Usuario> findByAutorizacoesNome(String autorizacao);

    //Consulto com join
    @Query("select u from Usuario u inner join u.autorizacoes a where a.nome = ?1")
    public List<Usuario> buscaPorNomeAutorizacao(String usuario);

    @Query("select u from Usuario u")
    public Set<Usuario> buscarUsuarios();

}