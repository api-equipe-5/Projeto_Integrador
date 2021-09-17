package br.gov.sp.fatec.springbootprodutora.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.sp.fatec.springbootprodutora.entity.Diretor;
import br.gov.sp.fatec.springbootprodutora.service.ProdutoraServiceProvider;

/*Anotações breves... alguns métodos precisam ser melhorados junto com as view para que seja exibido os dados
de filmagem participadas e dirigidas */

@RestController
@RequestMapping(value = "/diretor")
@CrossOrigin

public class DiretorController {
    
    @Autowired
    private ProdutoraServiceProvider produtoraService;

    @JsonView(View.Diretor.class)
    @GetMapping
    public List<Diretor> buscarTodos()
    {
        return produtoraService.buscarTodosDiretores();
    }

    @JsonView(View.Diretor.class)
    @GetMapping (value="/id/{id}")
    public Diretor buscarPorId(@PathVariable("id") Long id)
    {
        return produtoraService.buscarDiretorPorId(id);
    }

    @JsonView(View.Diretor.class)
    @GetMapping (value = "/nome/{nome}")
    public Diretor buscarPorNome(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarDiretorPorNome(nome);
    }

    @JsonView(View.Diretor.class)
    @GetMapping (value = "/letra/{nome}")
    public List<Diretor> buscaDiretorPorLetra(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarDiretorPorLetra(nome);
    }

    @JsonView(View.Diretor.class)
    @PostMapping
    public ResponseEntity <Diretor> cadastraNovoDiretor(@RequestBody Diretor diretor,
        UriComponentsBuilder uriComponentsBuilder)
    {
        diretor = produtoraService.criaDiretor(diretor.getNome(), diretor.getCpf());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(
            uriComponentsBuilder.path(
                "/diretor/id/" + diretor.getId()).build().toUri());      
        return new ResponseEntity<Diretor>(diretor,responseHeaders,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        try{
            produtoraService.deleteDiretor(id);
            return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @PutMapping(value = "/altera/{id}")
    public ResponseEntity<Diretor> Put(@PathVariable(value = "id") long id, @RequestBody Diretor diretor) {
        try{
            produtoraService.updateDiretor(id, diretor.getNome(), diretor.getCpf());
            return new ResponseEntity<Diretor>(diretor, HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }
}