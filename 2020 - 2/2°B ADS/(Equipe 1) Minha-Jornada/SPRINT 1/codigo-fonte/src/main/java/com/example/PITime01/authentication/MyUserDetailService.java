package com.example.PITime01.authentication;

import com.example.PITime01.user.UserRepository;
import com.example.PITime01.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        Optional<User> user = userRepository.findByName(username);

        user.orElseThrow(() -> new UsernameNotFoundException("User not found, username:  " + username));

        return user.map(MyUserDetails::new).get();
    }
}
