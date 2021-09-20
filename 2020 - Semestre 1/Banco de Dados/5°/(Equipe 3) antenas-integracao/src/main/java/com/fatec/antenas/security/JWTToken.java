package com.fatec.antenas.security;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fatec.antenas.error.CredentialNotFoundException;
import com.fatec.antenas.model.DocumentEmpresario;
import com.fatec.antenas.model.Usuario;

@Component
public class JWTToken {
	
		public boolean jwtGenerate(HttpServletResponse response, Usuario find, Usuario empresario) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if(find == null) {
				
				throw new CredentialNotFoundException("User not Found ");
			}
			
			if(!passwordEncoder.matches(empresario.getSenha(), find.getSenha())) {
				throw new CredentialNotFoundException("User not Found ");
			}
			
			String jwt = JWT.create()
	                .withClaim("idUsuarioLogado", find.get_id())
	                .sign(Algorithm.HMAC256("Emp@2020"));
			
			Cookie cookie = new Cookie("token", jwt);
			cookie.setPath("/");
	        cookie.setHttpOnly(true);
	        cookie.setMaxAge(60 * 30); // 30 minutos
	        response.addCookie(cookie);

	        
			return true;
		}

}
