package easyata.projetoapi.rest.api.controller;

import easyata.projetoapi.rest.api.config.security.TokenService;
import easyata.projetoapi.rest.api.controller.dto.TokenDto;
import easyata.projetoapi.rest.api.controller.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> autenticartoken(@RequestBody @Valid LoginForm form) {
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();

  
        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            Long id = tokenService.getIdUsuario(token);
            String nome = tokenService.getNomeUsuario(authentication, token);
            String perfil = tokenService.getPerfilUsuario(authentication, token);

            return ResponseEntity.ok(new TokenDto(token, "Bearer", id, nome, perfil));
        } catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }
}