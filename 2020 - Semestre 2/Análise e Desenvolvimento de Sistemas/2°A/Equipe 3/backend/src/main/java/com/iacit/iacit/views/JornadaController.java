package com.iacit.iacit.views;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.iacit.iacit.IacitApplication;
import com.iacit.iacit.models.JornadaAlerta;
import com.iacit.iacit.models.JornadaStatus;
import com.iacit.iacit.models.Jornadas;
import com.iacit.iacit.repository.JornadaAlertaRepository;
import com.iacit.iacit.repository.JornadaRepository;
import com.iacit.iacit.repository.JornadaStatusRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@CrossOrigin
@RequestMapping("/jornada")
public class JornadaController {
    
    @Autowired
    JornadaRepository jRepository;

    @Autowired
    JornadaStatusRepository jsRepository;

    @Autowired
    JornadaAlertaRepository jaRepository;

    private static Logger logger = LoggerFactory.getLogger(IacitApplication.class);

    @GetMapping("current")
    public List<Jornadas> getCurrent(){
        logger.info("Listagem de jornadas atuais");
        return jRepository.findCurrent();
    }

    @GetMapping("canceled")
    public List<Jornadas> getCanceled(){
        logger.info("Listagem de jornadas canceladas");
        return jRepository.getCanceled();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jornadas createJornada(@RequestBody final Jornadas jornada) {
        logger.info("Nova jornada criada");
        return jRepository.save(jornada);
    }

    @PostMapping("{id}/status")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStatus(@PathVariable Long id, @RequestBody final JornadaStatus js) {
        jRepository.findById(id)
        .map(jExist->{
            js.setJornada(jExist);
            jsRepository.save(js);
            logger.info("Status adcionado a jornada "+id);
            return new ResponseEntity<>("Status adcionado",HttpStatus.OK);
        })
        .orElseThrow(()-> {
            logger.info("Jornada "+id+" não encontrada");
            return new ResponseStatusException(HttpStatus.NOT_FOUND,"Jornada não encontrada");
        });
    }

    @PostMapping("{id}/alerta")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAlerta(@PathVariable Long id, @RequestBody final JornadaAlerta ja) {
        jRepository.findById(id)
        .map(jExist->{
            ja.setJornada(jExist);
            jaRepository.save(ja);
            logger.info("Alerta adcionado a jornada "+id);
            return new ResponseEntity<>("Alerta adcionado",HttpStatus.OK);
        })
        .orElseThrow(()-> {
            logger.info("Jornada "+id+" não encontrada");
            return new ResponseStatusException(HttpStatus.NOT_FOUND,"Jornada não encontrada");
        });
    }

    @GetMapping("index")
    public List<Jornadas> indexJornada(){
        logger.info("Listagem de jornadas");
        return jRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Jornadas>> findJornada(@PathVariable Long id){
        Optional<Jornadas> jornada;
        jornada = jRepository.findById(id);
            return jornada.map(Exist -> {
                logger.info("Jornada " + id + " encontrado");
                return new ResponseEntity<Optional<Jornadas>>(jornada, HttpStatus.OK);
            }).orElseThrow(() -> {
                logger.info("Jornada " + id + " não encontrado");
                return new ResponseStatusException(HttpStatus.NOT_FOUND,"Jornada não encontrado");
            });
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateJornada(@PathVariable final Long id,@RequestBody final Jornadas jornada)
    {
        jRepository.findById(id).map(jornadaExist -> {
            jornada.setId(jornadaExist.getId());
            jRepository.save(jornada);
            logger.info("Jornada "+id+" alterada");
            return ResponseEntity.noContent().build();
        })
        .orElseThrow(() -> {
            logger.info("Jornada "+id+" não encontrada");
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Jornada não encontrada");
        });
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJornada (@PathVariable final Long id){
        jRepository.findById(id).map(jornada -> {
            jRepository.delete(jornada);
            logger.info("Jornada "+id+" deletada");
            return jornada;
        })
        .orElseThrow(() -> {
            logger.info("Jornada "+id+" não encontrada");
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Jornada não encontrada");
        });
    }

}
