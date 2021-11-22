package br.com.fatec.springbootpi.controller;

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

import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.model.Form.LoginForm;
import br.com.fatec.springbootpi.security.JwtUtils;
import br.com.fatec.springbootpi.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public LoginForm autenticar(@RequestBody LoginForm loginForm) throws JsonProcessingException {
        
        Authentication auth = new UsernamePasswordAuthenticationToken(loginForm.getDocument(), loginForm.getPassword());
        Usuario user = usuarioService.buscarPorCpf(loginForm.getDocument());
        auth = authManager.authenticate(auth);
        loginForm.setPassword(null);
        loginForm.setIdUsuario(user.getIdUsuario());
        loginForm.setToken(JwtUtils.generateToken(auth));
        return loginForm;
    }
}