package com.example.PITime01.application.http.controllers;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class CustomErrorController implements ErrorController {

    // TODO: Hoje, quando o usuario nao possui permissao para um pagina, OU quando a pagina nao existe, o layout retornado eh o mesmo, e deveria ser diferente. Deveriamos ter um layout de erro "sem permissao" ou algo assim, e um "pagina nao encontrado"
    @RequestMapping("/error")
    public String handleError() {
        return "404";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
