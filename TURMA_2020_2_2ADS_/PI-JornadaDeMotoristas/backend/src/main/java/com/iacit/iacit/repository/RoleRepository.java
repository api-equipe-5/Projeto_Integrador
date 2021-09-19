package com.iacit.iacit.repository;

import com.iacit.iacit.models.Roles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    
}
