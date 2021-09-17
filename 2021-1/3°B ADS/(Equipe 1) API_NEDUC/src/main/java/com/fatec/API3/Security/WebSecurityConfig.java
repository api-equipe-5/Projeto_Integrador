package com.fatec.API3.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ImplementsAlunosDetailsService userDetailsService;	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET,"/index","/div","/divcad", "/recuperarsenha","/recuperarsenhaprofessor", "/cadastroprofessor",
		"/cadastroaluno", "/help","/loginprofessor","/")
		.permitAll()
		.antMatchers(HttpMethod.POST, "/loginaluno","/loginprofessor","/cadastroaluno","/cadastroprofessor","/recuperarsenha")
		.permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.loginProcessingUrl("/loginaluno")
		.loginPage("/loginaluno").defaultSuccessUrl("/homealuno", true).permitAll()
        .usernameParameter("email")
        .passwordParameter("senha")
		.permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/index");
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
		}

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/acesso/**", "/assets/**","/css/**","/js/**","/static/**");
	}

}

