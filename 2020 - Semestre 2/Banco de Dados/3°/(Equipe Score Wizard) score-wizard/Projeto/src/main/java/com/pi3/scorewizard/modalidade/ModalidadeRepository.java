package com.pi3.scorewizard.modalidade;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalidadeRepository extends CrudRepository<Modalidade, String> {
    
}
