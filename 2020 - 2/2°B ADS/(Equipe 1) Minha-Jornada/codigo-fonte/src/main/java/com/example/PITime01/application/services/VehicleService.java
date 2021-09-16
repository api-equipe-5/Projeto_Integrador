package com.example.PITime01.application.services;

import com.example.PITime01.application.dto.audit.VehicleAuditDTO;
import com.example.PITime01.application.repositories.VehicleRepository;
import com.example.PITime01.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository repository;

    public List<Vehicle> listAll() {
        return repository.findAll();
    }

    public List<VehicleAuditDTO> listAllAudit() {
        return repository.findAll()
                .stream()
                .map(VehicleAuditDTO::new)
                .collect(Collectors.toList());
    }

    public void Save(Vehicle vehicle) {
        repository.save(vehicle);
    }

    public Vehicle get(Long id) {
        return repository.findById(id).get();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
