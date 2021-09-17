package com.example.PITime01.application.http.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.example.PITime01.domain.Profile.ADMIN;

@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailService userDetailsService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/employee/**").hasAnyAuthority(ADMIN.name())
                .antMatchers("/union/**").hasAnyAuthority(ADMIN.name())
                .antMatchers("/driver/new").hasAnyAuthority(ADMIN.name())
                .antMatchers("/driver/list").hasAnyAuthority(ADMIN.name())
                .antMatchers("/driver/edit/**").hasAnyAuthority(ADMIN.name())
                .antMatchers("/vehicle/**").hasAnyAuthority(ADMIN.name())
                .and().formLogin()
                .loginPage("/login")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .permitAll();

    }

}
