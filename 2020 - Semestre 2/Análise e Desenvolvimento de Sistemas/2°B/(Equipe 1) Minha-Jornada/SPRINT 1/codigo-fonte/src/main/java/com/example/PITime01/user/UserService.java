package com.example.PITime01.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserDTO> listAll() {
        return repository.findAll()
            .stream()
            .map(User::toUserDTO)
            .collect(Collectors.toList());
    }

    public User get(Long id) {
        return repository.findById(id).get();
    }

    public void save(User client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        repository.save(client);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
