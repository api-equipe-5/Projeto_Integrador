package com.example.PITime01.application.http.authentication;

import com.example.PITime01.application.repositories.EmployeeRepository;
import com.example.PITime01.domain.Employee;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    final
    EmployeeRepository employeeRepository;

    public MyUserDetailService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Employee> user = employeeRepository.findByName(username);

        user.orElseThrow(() -> new UsernameNotFoundException("User not found, username:  " + username));

        return user.map(MyUserDetails::new).get();
    }
}
