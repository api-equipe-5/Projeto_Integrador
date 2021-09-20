package easyata.projetoapi.rest.api.repository;

import easyata.projetoapi.rest.api.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Optional<Perfil> findById(Long id);
}
