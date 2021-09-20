package easyata.projetoapi.rest.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping(path = "/status")
    public String check(){
        return "Online";
    }
}
