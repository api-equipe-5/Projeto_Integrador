package br.gov.sp.fatec.springbootprodutora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

    @GetMapping
    public String welcome(){
        return "Hello Galera";
    }

}