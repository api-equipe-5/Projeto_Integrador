package br.gov.sp.fatec.springbootprodutora.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.GenericFilterBean;

public class JwtAuthenticationFilter extends GenericFilterBean{
    
     @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)
    throws IOException, ServletException {
        //pegando a requisição
        try {
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            String authorization = servletRequest.getHeader(HttpHeaders.AUTHORIZATION); //pegando o conteudo do header
            //authorization

            if (authorization != null) {
                // bearer -caracteristica do jwt, porem, extrai-se somente o token usando o parse
                Authentication credentials= JwtUtils.parseToken(authorization.replaceAll("Bearer ", ""));
                //forçando a autenticação setando a autenticação/ fazendo o login
                SecurityContextHolder.getContext().setAuthentication(credentials); //chave do login
            }
            chain.doFilter(request, response); //passa para a rota
        }
        catch(Throwable t) {
            HttpServletResponse servletResponse =(HttpServletResponse) response;
            servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, t.getMessage());
            //caso o token esteja invalido
        }
    }

}