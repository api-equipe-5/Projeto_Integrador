package com.fatec.team1.TeachingPlatform.application.config;

import com.fatec.team1.TeachingPlatform.application.services.UserAccountService;
import com.fatec.team1.TeachingPlatform.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.fatec.team1.TeachingPlatform.domain.UserAccount user = userService.findByEmail(email);

        if (user.getEmail().equals(email)) {
            return new User(email, user.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}
