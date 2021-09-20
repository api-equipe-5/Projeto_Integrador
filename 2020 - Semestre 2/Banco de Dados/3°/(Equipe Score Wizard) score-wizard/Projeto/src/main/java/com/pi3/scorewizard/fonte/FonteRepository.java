package com.pi3.scorewizard.fonte;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonteRepository extends CrudRepository<Fonte, Integer> {
    
}
