package com.spring.gantt.GanttBubbleSort.tarefa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/tarefa")
public class TarefaController {
    
    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping(path="/addTarefa") 
    public @ResponseBody String addNewTask (@RequestParam int id,
                                            @RequestParam String text,
                                            @RequestParam String start_date,
                                            @RequestParam String end_date,
                                            @RequestParam int progress,
                                            @RequestParam String parent,
                                            @RequestParam int duration,
                                            @RequestParam String priority,
                                            @RequestParam String type,
                                            @RequestParam String render,
                                            @RequestParam String owner) {
		
      Tarefa novaTarefa = new Tarefa(id,text,start_date,end_date,progress,parent,duration,priority,type,render,owner);

      tarefaRepository.save(novaTarefa);
      return "Tarefa inserida";
    }

    @GetMapping(path="/getTarefas")
    public @ResponseBody List<Tarefa> getAllTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping(path="/getProjetoTarefas")
    public @ResponseBody List<Tarefa> getProjetoTarefas(@RequestParam int id) {
        return tarefaRepository.findByParent(id);
    }

    public List<Tarefa> getTarefas(int id) {
        return tarefaRepository.findByParent(id);
    }

}