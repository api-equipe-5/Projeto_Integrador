package com.airPlan.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/code-create").hasAnyRole("4","3","1")
                .antMatchers("/code-consult").hasAnyRole("4","2","3","1")
                .antMatchers("/code-import").hasAnyRole("4","3","1")
                .antMatchers("/edit/**").hasAnyRole("4","3","1")
                .antMatchers("/delete/**").hasAnyRole("4","3","1")
                .antMatchers("/delete-manual/**").hasAnyRole("4","3","1")

                .antMatchers("/lep-create").hasAnyRole("3","1")

                .antMatchers("/pdf-full").hasAnyRole("3","1")
                .antMatchers("/pdf-delta").hasAnyRole("3","1")

                .antMatchers("/create-user").hasRole("1")

                .antMatchers("/menu").hasAnyRole("1","2","3","4")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){return NoOpPasswordEncoder.getInstance();}
}
