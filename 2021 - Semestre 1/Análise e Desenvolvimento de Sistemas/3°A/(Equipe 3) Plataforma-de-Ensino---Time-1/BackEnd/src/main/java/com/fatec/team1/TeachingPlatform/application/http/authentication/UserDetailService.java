package com.fatec.team1.TeachingPlatform.application.http.authentication;

import com.fatec.team1.TeachingPlatform.application.repositories.UserAccountRepository;
import com.fatec.team1.TeachingPlatform.domain.UserAccount;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    final UserAccountRepository userAccountRepository;

    public UserDetailService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<UserAccount> userAccount = userAccountRepository.findByEmail(email);

        userAccount.orElseThrow(() -> new UsernameNotFoundException("User not found, username:  " + email));

        return userAccount.map(ProjectUserDetails::new).get();
    }

}
