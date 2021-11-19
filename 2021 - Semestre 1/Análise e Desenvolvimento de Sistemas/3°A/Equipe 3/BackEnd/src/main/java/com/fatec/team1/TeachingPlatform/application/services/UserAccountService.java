package com.fatec.team1.TeachingPlatform.application.services;

import com.fatec.team1.TeachingPlatform.application.dto.UserAccountDTO;
import com.fatec.team1.TeachingPlatform.application.repositories.UserAccountRepository;
import com.fatec.team1.TeachingPlatform.domain.AccountRole;
import com.fatec.team1.TeachingPlatform.domain.UserAccount;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAccountService {

    private final UserAccountRepository repository;

    private final PasswordEncoder passwordEncoder;


    public UserAccountService(UserAccountRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserAccountDTO> listAll() {
        return repository.findAll()
            .stream()
            .map(UserAccountDTO::new)
            .collect(Collectors.toList());
    }

    public List<UserAccountDTO> listAll(AccountRole accountRole) {
        return repository.findAll()
            .stream()
            .filter(userAccount -> userAccount.getRole().equals(accountRole))
            .map(UserAccountDTO::new)
            .collect(Collectors.toList());
    }

    public UserAccount findById(Long id) {
        return repository.findById(id).get();
    }

    public UserAccount findByEmail(String email) {
        return repository.findByEmail(email).get();
    }

    public void save(UserAccount userAccount) {
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        repository.save(userAccount);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
