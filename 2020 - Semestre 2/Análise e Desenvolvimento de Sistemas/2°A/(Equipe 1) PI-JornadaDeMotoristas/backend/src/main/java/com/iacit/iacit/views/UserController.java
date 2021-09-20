package com.iacit.iacit.views;

import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import com.iacit.iacit.IacitApplication;
import com.iacit.iacit.models.Users;
import com.iacit.iacit.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(IacitApplication.class);
    
    @Autowired
    UserRepository uRepository;

    // Criar Veículo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users createUser(@RequestBody Users user) {
        logger.info("Novo usuário criado");
        return uRepository.save(user);
    }

    @GetMapping("index")
    public List<Users> indexUsers(){
        logger.info("Listagem de usuários");
        return uRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Users>> ProfileUsers(@PathVariable String id) {
        Optional<Users> user;
            user = uRepository.findById(id);
            return user.map(userExist -> {
                logger.info("Usuário " + id + " encontrado");
                return new ResponseEntity<Optional<Users>>(user, HttpStatus.OK);
            }).orElseThrow(() -> {
                logger.info("Usuário " + id + " não encontrado");
                return new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado");
            });
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable String id,@RequestBody Users user){
        uRepository.findById(id).map(userExist->{
            user.setMatricula(userExist.getMatricula());
            uRepository.save(user);
            logger.info("Usuário "+userExist.getMatricula()+" alterado");
            return ResponseEntity.noContent().build();
        }).orElseThrow(()->{
            logger.info("Usuário "+id+" não encontrado");
            return new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado");
        });
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id){
        uRepository.findById(id).map(user->{
            uRepository.delete(user);
            logger.info("Usuário "+id+" deletado");
            return ResponseEntity.noContent().build();
        }).orElseThrow(()->{
            logger.info("Usuário "+id+" não encontrado");
            return new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado");
        });
    }

    @GetMapping
    public List<Users> searchUser(final Users filtro){
        final ExampleMatcher matcher = ExampleMatcher
                                    .matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        final Example example = Example.of(filtro, matcher);
        return uRepository.findAll(example);
    }

}
