package com.example.PITime01.application.services;

import com.example.PITime01.application.dto.audit.UnionAuditDTO;
import com.example.PITime01.application.repositories.UnionRepository;
import com.example.PITime01.domain.Union;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnionService {
    private final UnionRepository repository;

    public UnionService(UnionRepository repository) {
        this.repository = repository;
    }

    public Union get(Long id) {
        return repository.findById(id).get();
    }

    public Union findByName(String name) {
        return repository.findByName(name).get();
    }

    public void save(Union union) {
        repository.save(union);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Union> listAll() {
        return repository.findAll()
                .stream()
                .map(Union::new)
                .collect(Collectors.toList());
    }

    public List<UnionAuditDTO> listAllAudit() {
        return repository.findAll()
                .stream()
                .map(UnionAuditDTO::new)
                .collect(Collectors.toList());
    }
}
