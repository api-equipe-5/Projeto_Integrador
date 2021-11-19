package com.fatec.team1.TeachingPlatform.application.http.controllers;

import com.fatec.team1.TeachingPlatform.application.config.JwtRequest;
import com.fatec.team1.TeachingPlatform.application.config.JwtResponse;
import com.fatec.team1.TeachingPlatform.application.config.JwtTokenUtil;
import com.fatec.team1.TeachingPlatform.application.config.JwtUserDetailsService;
import com.fatec.team1.TeachingPlatform.application.repositories.UserAccountRepository;
import com.fatec.team1.TeachingPlatform.application.services.UserAccountService;
import com.fatec.team1.TeachingPlatform.domain.UserAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserAccountService accountService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.setUserAccount(accountService.findByEmail(authenticationRequest.getUsername()));
        userAuthentication.setJwtResponse(new JwtResponse(token));

        return ResponseEntity.ok(userAuthentication);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
