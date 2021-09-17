package com.example.PITime01.application.http.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ApplicationController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.setOrder(1);
    }

    @RequestMapping("/")
    public String userHomePage(Model model, Authentication authResult, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String role = authResult.getAuthorities().toString();
        if (role.contains("DRIVER")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/indexDriver"));
        }
        return "index";
    }

}
