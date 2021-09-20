package br.com.fatec.springbootpi.controller;

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

import br.com.fatec.springbootpi.controller.View.UsuarioResumo;
import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.model.UsuarioForm;
import br.com.fatec.springbootpi.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "*")
@Api(value = "Usuário")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ApiOperation(value = "Inserir um novo usuário")
    public ResponseEntity<Usuario> cadastrarNovoUsuario(@RequestBody UsuarioForm novoUsuario,
            UriComponentsBuilder uriComponentsBuilder) {

        Usuario usuario = usuarioService.criarUsuario(
            novoUsuario.getNomeUsuario(), 
            novoUsuario.getCpfUsuario(), 
            novoUsuario.getIdTipoUsuario(),
            novoUsuario.getSenha()
        );
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/usuario/" + usuario.getIdUsuario()).build().toUri());
        return new ResponseEntity<Usuario>(usuario, responseHeaders, HttpStatus.CREATED);
    }

    
    @JsonView(View.UsuarioResumo.class)
    @GetMapping
    @ApiOperation(value = "Lista todos os usuarios")
    public List<Usuario> buscarUsuarios() {
        return usuarioService.buscarUsuarios();

    }

    @JsonView(View.UsuarioResumo.class)
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Buscar usuário por id")
    public Usuario buscarUsuarioPorID(@PathVariable("id") Long Id) {
        return usuarioService.buscarPorId(Id);

    }

    @JsonView(View.UsuarioResumo.class)
    @GetMapping(value = "cpf/{cpf}")
    @ApiOperation(value = "Buscar usuário por cpf")
    public Usuario buscarUsuarioPorID(@PathVariable("cpf") String cpf) {
        return usuarioService.buscarPorCpf(cpf);
    }

    @JsonView(UsuarioResumo.class)
    @PutMapping(value="/{id}")
    @ApiOperation(value = "Alterar usuário")
    public Usuario atualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        return usuarioService.editarUsuario(id, usuario);
    }

    @ApiOperation(value = "Deletar usuário por id")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") Long id){
        usuarioService.apagarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}