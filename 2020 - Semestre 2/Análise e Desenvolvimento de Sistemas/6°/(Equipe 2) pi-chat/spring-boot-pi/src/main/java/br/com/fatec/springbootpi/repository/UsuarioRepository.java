package br.com.fatec.springbootpi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.springbootpi.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public Usuario findByNomeUsuarioAndCpfUsuario(String nomeUsuario, String cpfUsuario);

    public Usuario findByIdUsuario(Long idUsuario);

    public Usuario findByNomeUsuario(String nomeUsuario);

    public Usuario findByCpfUsuario(String cpf);

}