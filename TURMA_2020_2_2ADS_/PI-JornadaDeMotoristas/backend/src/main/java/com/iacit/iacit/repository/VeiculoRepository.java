package com.iacit.iacit.repository;

import com.iacit.iacit.models.Veiculos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculos,String>{
   
}
