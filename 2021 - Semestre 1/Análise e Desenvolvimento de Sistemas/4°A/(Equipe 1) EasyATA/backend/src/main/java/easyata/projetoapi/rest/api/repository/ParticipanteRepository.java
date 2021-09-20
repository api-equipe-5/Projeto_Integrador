package easyata.projetoapi.rest.api.repository;

import easyata.projetoapi.rest.api.model.Participantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipanteRepository extends JpaRepository<Participantes, Long> {
    Participantes findById(long id);
}
