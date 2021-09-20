package easyata.projetoapi.rest.api.controller;

import easyata.projetoapi.rest.api.config.security.PerfilService;
import easyata.projetoapi.rest.api.config.security.UserService;
import easyata.projetoapi.rest.api.model.Perfil;
import easyata.projetoapi.rest.api.repository.PerfilRepository;
import easyata.projetoapi.rest.api.repository.UsuarioRepository;
import easyata.projetoapi.rest.api.model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping(value="/api")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PerfilRepository perfilRepository;

    @Autowired
    UserService userService;

    @Autowired
    PerfilService perfilService;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/usuario/{id}")
    public ResponseEntity consultar(@PathVariable("id")Long id){
        return usuarioRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario")
    public List<UsuarioModel> listaUsuarios(){
        return usuarioRepository.findAll();
    }


    @PostMapping("/usuario")
    public UsuarioModel criarUsuario(@RequestBody UsuarioModel usuarioModel, Perfil perfil){
        this.perfilService.save(perfil);
        return this.userService.save(usuarioModel);
    }

    @DeleteMapping("/usuario/deletar")
    public void deletaUsuario(@RequestBody UsuarioModel usuarioModel){
        usuarioRepository.delete(usuarioModel);
    }

    @PutMapping("/usuario/atualizar")
    public UsuarioModel atualizaUsuario(@RequestBody UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }


}
