package easyata.projetoapi.rest.api.config.security;

import java.util.Date;

import easyata.projetoapi.rest.api.model.UsuarioModel;
import easyata.projetoapi.rest.api.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    private UsuarioRepository usuarioRepository;

    public String gerarToken(Authentication authentication) {
        UsuarioModel logado = (UsuarioModel) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API")
                .setSubject(logado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
    public String getNomeUsuario(Authentication authentication, String token){
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        UsuarioModel logado = (UsuarioModel) authentication.getPrincipal();
        return logado.getNome();
    }
    public String getPerfilUsuario(Authentication authentication, String token){
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        UsuarioModel logado = (UsuarioModel) authentication.getPrincipal();
        return logado.getPerfil();
    }
}