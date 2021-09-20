package easyata.projetoapi.rest.api.repository;

import easyata.projetoapi.rest.api.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByEmail(String email);

}
