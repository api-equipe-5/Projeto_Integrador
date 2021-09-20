package com.airPlan.repository;

import com.airPlan.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(" select s from User s where emp_name = ?1 ")
    Optional<User> findByUserName(String username);
}
