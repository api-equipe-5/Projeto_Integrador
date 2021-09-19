package com.iacit.iacit.services;

import java.util.ArrayList;
import java.util.List;

import com.iacit.iacit.models.Roles;
import com.iacit.iacit.models.Users;
import com.iacit.iacit.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{
        ArrayList<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
        Users user = userRepository.findByLogin(login);
        for(Roles role:user.getRoles()){
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getSenha(),roles);
    }

}
