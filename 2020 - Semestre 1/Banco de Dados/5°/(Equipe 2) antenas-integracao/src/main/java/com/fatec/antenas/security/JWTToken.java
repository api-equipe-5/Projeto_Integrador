package com.fatec.antenas.security;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fatec.antenas.error.CredentialNotFoundException;
import com.fatec.antenas.model.Usuario;

@Component
public class JWTToken {
		private String hmac256 = "Antenas@2020";
		private String idUsoJwt = "idUsuarioLogado";
		public boolean jwtEmpresario(HttpServletResponse response, Usuario find, Usuario usuario) {
			return jwtGenerate(response, find, usuario, idUsoJwt, hmac256) ;
		}
		
		public boolean jwtCadi(HttpServletResponse response, Usuario find, Usuario usuario) {
			return jwtGenerate(response, find, usuario, idUsoJwt, hmac256) ;
		}
		public boolean jwtAluno(HttpServletResponse response, Usuario find, Usuario usuario) {
			return jwtGenerate(response, find, usuario, idUsoJwt, hmac256) ;
		}
		public boolean jwtProfessor(HttpServletResponse response, Usuario find, Usuario usuario) {
			return jwtGenerate(response, find, usuario, idUsoJwt, hmac256) ;
		}
	
		private boolean jwtGenerate(HttpServletResponse response, Usuario find, Usuario usuario, String idUsoJwt, String hmac256) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if(find == null) {
				
				throw new CredentialNotFoundException("User not Found ");
			}
			if(!passwordEncoder.matches(usuario.getSenha(), find.getSenha())) {
				throw new CredentialNotFoundException("User not Found ");
			}
			
			String jwt = JWT.create()
	                .withClaim(idUsoJwt, find.get_id())
	                .sign(Algorithm.HMAC256(hmac256));
			
			Cookie cookie = new Cookie("token", jwt);
			cookie.setPath("/");
	        cookie.setHttpOnly(true);
	        cookie.setMaxAge(60 * 60); // 30 minutos
	        response.addCookie(cookie);

	        
			return true;
		}

}
