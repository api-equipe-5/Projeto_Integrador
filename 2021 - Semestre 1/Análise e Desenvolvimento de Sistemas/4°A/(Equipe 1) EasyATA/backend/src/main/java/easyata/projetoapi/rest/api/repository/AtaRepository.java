package easyata.projetoapi.rest.api.repository;

import easyata.projetoapi.rest.api.model.Ata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtaRepository extends JpaRepository<Ata, Long> {
    Ata findById(long id);
}
