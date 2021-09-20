package com.spring.gantt.GanttBubbleSort.projeto;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/projeto")
public class ProjetoController {
    
    @Autowired
    private ProjetoRepository projetoRepository;

    @PostMapping(path="/addProjeto")
    public @ResponseBody String addProjeto (@RequestParam int id,
                                            @RequestParam String text,
                                            @RequestParam String start_date,
                                            @RequestParam String end_date,
                                            @RequestParam int progress,
                                            @RequestParam int parent,
                                            @RequestParam int duration,
                                            @RequestParam String priority,
                                            @RequestParam String type) {

      Projeto projeto = new Projeto(id,text,start_date,end_date,progress,parent,duration,priority,type);
      
      projetoRepository.save(projeto);
      return "Saved";
    }

    @GetMapping(path="/getProjetos")
    public @ResponseBody ArrayList<Projeto> getAllProjetos() {
        return projetoRepository.findAll();
    }

}