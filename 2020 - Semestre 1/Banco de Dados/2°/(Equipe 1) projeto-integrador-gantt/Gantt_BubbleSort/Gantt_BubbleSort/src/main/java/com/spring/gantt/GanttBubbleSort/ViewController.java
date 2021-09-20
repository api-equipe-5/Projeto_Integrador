package com.spring.gantt.GanttBubbleSort;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.gantt.GanttBubbleSort.funcionario.Funcionario;
import com.spring.gantt.GanttBubbleSort.funcionario.FuncionarioController;
import com.spring.gantt.GanttBubbleSort.link.Link;
import com.spring.gantt.GanttBubbleSort.link.LinkController;
import com.spring.gantt.GanttBubbleSort.projeto.Projeto;
import com.spring.gantt.GanttBubbleSort.projeto.ProjetoController;
import com.spring.gantt.GanttBubbleSort.tarefa.Tarefa;
import com.spring.gantt.GanttBubbleSort.tarefa.TarefaController;

@Controller
public class ViewController {
	
	@Autowired
	TarefaController tc = new TarefaController();

	@Autowired
	ProjetoController pc = new ProjetoController();

	@Autowired
	LinkController lc = new LinkController();

	@Autowired
	FuncionarioController fc = new FuncionarioController();

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/devs")
	public String devs() {
		return "funcionario";
	}
	
	@RequestMapping("/ganttTasks")
	public String ganttTasks(@RequestParam(name = "name", required = false, defaultValue = "World") final String name,
			final Model model) {

		final ArrayList<Tarefa> tarefas = new ArrayList<>();
		final ArrayList<Projeto> projetos = new ArrayList<>();
		final ArrayList<Link> links = new ArrayList<>();
		final ArrayList<Funcionario> funcionarios = new ArrayList<>();

		// tc.getAllTarefas();
		tarefas.addAll(tc.getAllTarefas());
		projetos.addAll(pc.getAllProjetos());
		links.addAll(lc.getAllLinks());
		funcionarios.addAll(fc.getAllFuncionarios());

		model.addAttribute("tarefas", tarefas);
		model.addAttribute("projetos", projetos);
		model.addAttribute("links", links);
		model.addAttribute("funcionarios", funcionarios);

		return "loop";
	}
	
}
