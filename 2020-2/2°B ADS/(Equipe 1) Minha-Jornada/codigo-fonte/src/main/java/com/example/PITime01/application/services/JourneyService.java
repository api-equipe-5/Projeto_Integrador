package com.example.PITime01.application.services;

import com.example.PITime01.application.repositories.JourneyRepository;
import com.example.PITime01.application.repositories.VehicleRepository;
import com.example.PITime01.domain.Journey;
import com.example.PITime01.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JourneyService {

    @Autowired
    private JourneyRepository repo;

    public List<Journey> listAll() {
        return repo.findAll();
    }


    public Journey get(Long id){
        return repo.findById(id).get();
    }


}
