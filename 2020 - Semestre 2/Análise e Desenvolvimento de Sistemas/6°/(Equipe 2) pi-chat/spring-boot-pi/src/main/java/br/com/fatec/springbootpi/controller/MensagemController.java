package br.com.fatec.springbootpi.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.springbootpi.entity.Mensagem;
import br.com.fatec.springbootpi.model.MensagemForm;
import br.com.fatec.springbootpi.repository.MensagemRepository;
import br.com.fatec.springbootpi.service.MensagemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/mensagem")
@CrossOrigin(origins = "*")
@Api(value = "Mensagem")

public class MensagemController {
    @Autowired
    private MensagemService msgService;

    @Autowired
    private MensagemRepository msgRepository;

    @PostMapping
    @JsonView(View.MensagemResumo.class)
	@ApiOperation(value = "Inserir uma nova mensagem")

    public ResponseEntity<Mensagem> cadastrarNovaMensagem(@RequestBody MensagemForm novaMensagem, UriComponentsBuilder uriComponentsBuilder){

        Mensagem mensagem = msgService.criarMensagem(novaMensagem.getConteudoMsg(),novaMensagem.getIdUsuario(), novaMensagem.getIdConversa());
        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/mensagem/conversa/" + mensagem.getConversas().getIdConversa()).build().toUri());
                
        return new ResponseEntity<Mensagem>(mensagem, responseHeaders, HttpStatus.CREATED);
    }

    @JsonView(View.MensagemResumo.class)
    @GetMapping(value = "/conversa/{id}")
    @ApiOperation(value = "Buscar mensagens por ID da conversa")
    public List<Mensagem> pegarMensagensPorConversa(@PathVariable("id") Long id) {
        return msgRepository.getMensagensPorConversa(id);

    }

    @JsonView(View.MensagemResumo.class)
    @PutMapping(value="/{id}")
    @ApiOperation(value = "Alterar mensagem")
     public ResponseEntity<Mensagem> atualizarMensagem(@PathVariable("id") Long id, @RequestBody Mensagem mensagem,
             UriComponentsBuilder uriComponentsBuilder) {
        
        mensagem = msgService.editarMensagem(id, mensagem);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/mensagem/" + mensagem.getIdMensagem()).build().toUri());
        return new ResponseEntity<Mensagem>(mensagem, responseHeaders, HttpStatus.OK); 
    }


    @ApiOperation(value = "Deletar uma mensagem por id")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletetarMensagem(@PathVariable("id") Long id){
        msgService.apagarMensagem(id);
        return ResponseEntity.noContent().build();
    }


}