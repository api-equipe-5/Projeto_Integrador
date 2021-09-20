package com.example.PITime01.application.services;

import com.example.PITime01.application.dto.EmployeeDTO;
import com.example.PITime01.application.http.authentication.MyUserDetails;
import com.example.PITime01.application.repositories.EmployeeRepository;
import com.example.PITime01.domain.Employee;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    private final PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<EmployeeDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
    }

    public Employee findByID(Long id) {
        return repository.findById(id).get();
    }

    public Employee findByName(String name) {
        return repository.findByName(name).get();
    }

    public void save(Employee client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        repository.save(client);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void changePassword(String newPassword) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((MyUserDetails) (authentication).getPrincipal()).getUsername();

        Employee user = findByName(username);
        user.setPassword(passwordEncoder.encode(newPassword));

        repository.save(user);

    }

    public boolean checkPassword(String password) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((MyUserDetails) (authentication).getPrincipal()).getUsername();

        Employee user = findByName(username);

        return passwordEncoder.matches(password, user.getPassword());
    }
}
