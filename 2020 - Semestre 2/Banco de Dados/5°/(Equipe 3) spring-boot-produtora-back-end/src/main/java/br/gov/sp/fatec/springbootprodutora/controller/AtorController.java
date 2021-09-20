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

import br.gov.sp.fatec.springbootprodutora.entity.Ator;
import br.gov.sp.fatec.springbootprodutora.service.ProdutoraServiceProvider;

@RestController
@RequestMapping(value = "/ator")
@CrossOrigin
public class AtorController {
    
    @Autowired
    private ProdutoraServiceProvider produtoraService;

    @JsonView(View.Ator.class)
    @GetMapping
    public List<Ator> buscarTodos()
    {
        return produtoraService.buscarTodosAtores();
    }

    @JsonView(View.Ator.class)
    @GetMapping (value="/id/{id}")
    public Ator buscarPorId(@PathVariable("id") Long id)
    {
        return produtoraService.buscarAtorPorId(id);
    }

    @JsonView(View.Ator.class)
    @GetMapping (value = "/nome/{nome}")
    public Ator buscarPorNome(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarAtorPorNome(nome);
    }

    @JsonView(View.Ator.class)
    @GetMapping (value = "/letra/{nome}")
    public List<Ator> buscaAtorPorLetra(@PathVariable("nome")  String nome)
    {
        return produtoraService.buscarAtorPorLetra(nome);
    }

    @JsonView(View.Ator.class)
    @PostMapping
    public ResponseEntity <Ator> cadastraNovoAtor(@RequestBody Ator ator,
        UriComponentsBuilder uriComponentsBuilder)
    {
        ator = produtoraService.criaAtor(ator.getNome(), ator.getCpf(), ator.getFama());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(
            uriComponentsBuilder.path(
                "/ator/id/" + ator.getId()).build().toUri());      
        return new ResponseEntity<Ator>(ator,responseHeaders,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        try{
            produtoraService.deleteAtor(id);
            return new ResponseEntity<>(id, HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @PutMapping(value = "/altera/{id}")
    public ResponseEntity<Ator> Put(@PathVariable(value = "id") long id, @RequestBody Ator ator) {
        try{
            produtoraService.updateAtor(id, ator.getNome(), ator.getCpf(), ator.getFama());
            return new ResponseEntity<Ator>(ator, HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }
}