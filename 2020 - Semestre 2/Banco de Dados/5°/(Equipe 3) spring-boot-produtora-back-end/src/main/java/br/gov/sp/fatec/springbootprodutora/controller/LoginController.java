package br.gov.sp.fatec.springbootprodutora.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springbootprodutora.security.JwtUtils;
import br.gov.sp.fatec.springbootprodutora.security.Login;

@RestController
@RequestMapping(value = "/login") /* anotacao que serve para endereçar o servico */
@CrossOrigin
public class LoginController {

    // habilita as configurações do login básico, não vem disponivel por padrão, requer o metodo no SecurityConfig
    @Autowired
    private AuthenticationManager authManager;

    @PostMapping()
    public Login autenticar(@RequestBody Login login) throws JsonProcessingException
    {
        //Authentication é uma interface do spring, não posso escrever o comando new nele
        //porem, temos um objeto que faz isso: UsernamePasswordAuthenticationToken.
        Authentication auth= new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
        auth =authManager.authenticate(auth); //autentica o login e senha buscando no banco de dados
        login.setPassword(null);
        login.setToken(JwtUtils.generateToken(auth));
        return login;
    }

}