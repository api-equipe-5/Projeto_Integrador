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

import br.gov.sp.fatec.springbootprodutora.entity.Duble;
import br.gov.sp.fatec.springbootprodutora.service.ProdutoraServiceProvider;

@RestController
@RequestMapping(value = "/duble")
@CrossOrigin
public class DubleController {
    
    @Autowired
    private ProdutoraServiceProvider produtoraService;

    @JsonView(View.Duble.class)
    @GetMapping
    public List<Duble> buscarTodos()
    {
        return produtoraService.buscarTodosDubles();
    }

    @JsonView(View.Duble.class)
    @GetMapping (value="/id/{id}")
    public Duble buscarPorId(@PathVariable("id") Long id)
    {
        return produtoraService.buscarDublePorId(id);
    }

    @JsonView(View.Duble.class)
    @GetMapping (value = "/nome/{nome}")
    public Duble buscarPorNome(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarDublePorNome(nome);
    }

    @JsonView(View.Duble.class)
    @GetMapping (value = "/letra/{nome}")
    public List<Duble> buscaDublePorLetra(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarDublePorLetra(nome);
    }

    @JsonView(View.Duble.class)
    @PostMapping
    public ResponseEntity <Duble> cadastraNovoDuble(@RequestBody Duble duble,
        UriComponentsBuilder uriComponentsBuilder)
    {
        duble = produtoraService.criaDuble(duble.getNome(), duble.getCpf(), duble.getEspecialidade());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(
            uriComponentsBuilder.path(
                "/duble/id/" + duble.getId()).build().toUri());      
        return new ResponseEntity<Duble>(duble,responseHeaders,HttpStatus.CREATED);
        }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        try{
            produtoraService.deleteDuble(id);
            return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @PutMapping(value = "/altera/{id}")
    public ResponseEntity<Duble> Put(@PathVariable(value = "id") long id, @RequestBody Duble duble) {
        try{
            produtoraService.updateDuble(id, duble.getNome(), duble.getCpf(), duble.getEspecialidade());
            return new ResponseEntity<Duble>(duble, HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }
}