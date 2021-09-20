package com.fatec.antenas.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
@Order(1)
public class FilterLogin implements Filter {
	
		@Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	        HttpServletResponse httpResponse = (HttpServletResponse)response;
	        HttpServletRequest httpRequest = (HttpServletRequest)request;
	
	        if (httpRequest.getServletPath().equals("/") ||
	        		httpRequest.getServletPath().startsWith("/css") ||
	        		httpRequest.getServletPath().startsWith("/js") ||
					httpRequest.getServletPath().startsWith("/imgs") ||
					httpRequest.getServletPath().startsWith("/monitoring")) {
	            chain.doFilter(request, response);
	            return;
	        }
	        
	        if (httpRequest.getServletPath().equals("/empresario/login") || httpRequest.getServletPath().equals("/empresario/save")) {
	            chain.doFilter(request, response);
	            return;
	        }
	        
	        if (httpRequest.getServletPath().equals("/cadi/login") || httpRequest.getServletPath().equals("/cadi/save")) {
	            chain.doFilter(request, response);
	            return;
	        }
	        
	        if (httpRequest.getServletPath().equals("/aluno/login") || httpRequest.getServletPath().equals("/aluno/save")) {
	            chain.doFilter(request, response);
	            return;
	        }
	        
	        if (httpRequest.getServletPath().equals("/professor/login") || httpRequest.getServletPath().equals("/professor/save")) {
	            chain.doFilter(request, response);
	            return;
	        }
	     
	        Cookie token = WebUtils.getCookie(httpRequest, "token");
	        if (token == null) {
	            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
	            return;
	        }
	
	        try {
	
	            String jwt = token.getValue();
	
	            DecodedJWT decodedJwt = JWT.require(Algorithm.HMAC256("Emp@2020"))
	                    .build()
	                    .verify(jwt);
	
	            String  idUsuarioLogado = decodedJwt.getClaim("idUsuarioLogado").asString();
	            httpRequest.setAttribute("idUsuarioLogado", idUsuarioLogado);
	
	            // chamada autenticada
	            chain.doFilter(request, response);
	
	        } catch (JWTVerificationException ex) {
	            httpResponse.sendError(HttpStatus.UNAUTHORIZED.value());
	            return;
	        }
	    }
	
	    @Override
	    public void init(FilterConfig filterConfig) {
	    }
	
	    @Override
	    public void destroy() {
	    }
	    
	   
}
