package com.airPlan.services;

import com.airPlan.entities.User;
import com.airPlan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public void save(User user){
        repo.save(user);
    }

}
