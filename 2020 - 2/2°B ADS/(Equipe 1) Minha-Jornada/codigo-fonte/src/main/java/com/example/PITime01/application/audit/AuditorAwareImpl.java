package com.example.PITime01.application.audit;

import com.example.PITime01.application.http.authentication.MyUserDetails;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((MyUserDetails) authentication.getPrincipal()).getUsername();
        return Optional.of(username);
    }
}
