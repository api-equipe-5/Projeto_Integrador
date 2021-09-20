package br.com.fatec.springbootpi.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.springbootpi.entity.TipoUsuario;
import br.com.fatec.springbootpi.service.TipoUsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/tipoUsuario")
@CrossOrigin
@Api(value = "Tipo usuário")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @PostMapping
    @ApiOperation(value = "Inserir um novo role para usuário")
    public ResponseEntity<TipoUsuario> cadastrarTipoUsuario(@RequestBody TipoUsuario tipoUsuario, UriComponentsBuilder uriComponentsBuilder){
    
        tipoUsuario = tipoUsuarioService.criarTipoUsuario(tipoUsuario.getNome());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/tipoUsuario/" + tipoUsuario.getIdTipoUsuario()).build().toUri());
        return new ResponseEntity<TipoUsuario>(tipoUsuario, responseHeaders, HttpStatus.CREATED);
    }

    @JsonView(View.TipoUsuarioResumo.class)
    @GetMapping
    @ApiOperation(value = "Lista todos os usuarios")
    public List<TipoUsuario> buscarUsuarios() {
        return tipoUsuarioService.buscarTiposUsuarios();

    }
}