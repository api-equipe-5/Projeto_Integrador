package com.example.PITime01.application.repositories;

import com.example.PITime01.domain.Employee;
import com.example.PITime01.domain.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface JourneyRepository extends JpaRepository<Journey,Long>{
}
