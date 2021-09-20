package com.spring.gantt.GanttBubbleSort.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Controller
@RequestMapping(path="/funcionario")
public class FuncionarioController {
	
    @Autowired
    private FuncionarioRepository  funcionarioRepository;
	
    @PostMapping("/addFunc")
    public @ResponseBody String addFunc(@RequestParam final String label) {
    	    	
		final Funcionario func = new Funcionario(label);
		
		funcionarioRepository.save(func);
		return "Saved";
	}

	@GetMapping(path="/getFuncionarios")
    public @ResponseBody ArrayList<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }
}
