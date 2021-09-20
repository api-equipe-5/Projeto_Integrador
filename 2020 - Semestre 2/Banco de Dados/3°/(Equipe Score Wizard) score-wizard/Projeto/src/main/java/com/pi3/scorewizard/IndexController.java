package com.pi3.scorewizard;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.pi3.scorewizard.login.Login;
import com.pi3.scorewizard.pessoafisica.PessoaFisica;
import com.pi3.scorewizard.pessoafisica.PessoaFisicaController;

import lombok.var;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class IndexController {
	
	@Autowired
	PessoaFisicaController pf = new PessoaFisicaController();
	
	HelloController cont = new HelloController();
	  
	  @GetMapping("/")
	  public String LoginForm(Model model) {
	    model.addAttribute("index", new Login());
	    return "index";
	  }

	  @PostMapping("/index")
	  public String LoginSubmit(@ModelAttribute Login greeting, Model model) {
		 	
		 	ArrayList<PessoaFisica> pessoaf = new ArrayList<>();
		 	pessoaf.addAll(pf.getAllPessoaFisica());
		 	
		 	int i = 1;
		 	while( i <= pessoaf.size()) {
			  	  if(greeting.getCpf().equals(pessoaf.get(i).getDocumento()) && greeting.getSenha_usu().equals(pessoaf.get(i).getSenha())) {
			  		  System.out.println("User j cadastrado");
			  		  pf.getCalcularXP(pessoaf.get(i).getDocumento());
			  		  return "dashboard";
			  	  }
			  	  i++;
			}

	    return null;	  
	  }
	  
	  @GetMapping("/cadastro")
	  public String CadastroForm(Model model) {
	    model.addAttribute("cadastro", new PessoaFisica());
	    return "cadastro";
	  }

	  @PostMapping("/cadastro")
	  public String CadastroSubmit(@ModelAttribute PessoaFisica cadastro, Model model) {
		 	
		 	System.out.println("Funcionou!");
		 	
		 	ArrayList<PessoaFisica> pessoaf = new ArrayList<>();
		 	pessoaf.addAll(pf.getAllPessoaFisica());
		 	
		 	int i = 1;
		 	while( i <= pessoaf.size()) {
		 		if(i == pessoaf.size()) {
			  		pf.addpessoaf(cadastro.getDocumento(),
			  				cadastro.getNome(),
							cadastro.getSexo(), 
							cadastro.getAnoNascimento(), 
							cadastro.getCidade(), 
							cadastro.getEstado(),
							cadastro.getSenha());
			  		return "dashboard";
			    	}
			  	  if(cadastro.getDocumento().equals(pessoaf.get(i).getDocumento())) {
			  		  return "index";
			  	  }  
			  	  i++;
			}

	    return null;	  
	  }
}
