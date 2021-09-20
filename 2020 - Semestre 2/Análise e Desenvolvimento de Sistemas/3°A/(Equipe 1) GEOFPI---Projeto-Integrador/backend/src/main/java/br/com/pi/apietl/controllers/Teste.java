package br.com.pi.apietl.controllers;


import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "*")
public class Teste {


    @GetMapping("/hello")
    @ApiOperation(value = "Retorna uma lista de produtos")
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        return "Hello World";
    }
}
