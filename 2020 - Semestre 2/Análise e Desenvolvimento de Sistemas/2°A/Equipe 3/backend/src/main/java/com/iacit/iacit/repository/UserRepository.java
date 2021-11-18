package com.iacit.iacit.repository;

import com.iacit.iacit.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    Users findByLogin(String login);
}
