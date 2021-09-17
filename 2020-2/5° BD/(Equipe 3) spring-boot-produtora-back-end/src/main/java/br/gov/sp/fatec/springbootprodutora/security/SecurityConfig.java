package br.gov.sp.fatec.springbootprodutora.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;
    
    //configurando o metodo de autenticação http
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        //foi tirada a autenticação basica de antes (.httpBasic().and()) e colocado o filtro no lugar
        //instancia o filtro personalizado antes do filtro do spring 
        http.csrf().disable().addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        //UsernamePasswordAuthenticationFilter, classe do springSecurity
        // isso desabilita a sessao de criação no Spring Security
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    //configurando o metodo de autenticação manager
    //controla como o spring faz autenticação (ele utiliza esse serviço)
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService);
    }

    //passwordEncoder - encriptando a senha
    @Bean
    public PasswordEncoder PasswordEncoderBean()
    {
        return new BCryptPasswordEncoder();
    }

    //habilitando o autowired do AuthenticationManager, quem vem desabilitado por padrão
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }

}