package com.example.PITime01.application.services;

import com.example.PITime01.application.dto.audit.DriverAuditDTO;
import com.example.PITime01.application.repositories.DriverRepository;
import com.example.PITime01.domain.Driver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {
    private final DriverRepository repository;

    public DriverService(DriverRepository repository) {
        this.repository = repository;
    }

    public Driver get(Long id) {
        return repository.findById(id).get();
    }

    public void save(Driver driver) {
        repository.save(driver);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Driver> listAll() {
        return repository.findAll()
                .stream()
                .map(Driver::new)
                .collect(Collectors.toList());
    }

    public List<DriverAuditDTO> listAllAudit() {
        return repository.findAll()
                .stream()
                .map(DriverAuditDTO::new)
                .collect(Collectors.toList());
    }
}
