package easyata.projetoapi.rest.api.config.security;

import easyata.projetoapi.rest.api.model.UsuarioModel;
import easyata.projetoapi.rest.api.repository.UsuarioRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    private UsuarioRepository repository;

    public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository repository) {
        this.tokenService = tokenService;
        this.repository = repository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken(request);
        boolean valido = tokenService.isTokenValido(token);
        if(valido){
            autenticarUsuario(token);
        }
        filterChain.doFilter(request, response);

    }

    private void autenticarUsuario(String token) {
        Long idUsuario = tokenService.getIdUsuario(token);
        UsuarioModel usuario = repository.findById(idUsuario).get();

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }
}
