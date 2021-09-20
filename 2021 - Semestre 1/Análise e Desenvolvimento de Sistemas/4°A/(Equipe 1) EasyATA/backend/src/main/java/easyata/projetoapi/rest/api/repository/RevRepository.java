package easyata.projetoapi.rest.api.repository;

import easyata.projetoapi.rest.api.model.AtaRevisao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevRepository extends JpaRepository<AtaRevisao, Long> {
    AtaRevisao findById(long id);
}
