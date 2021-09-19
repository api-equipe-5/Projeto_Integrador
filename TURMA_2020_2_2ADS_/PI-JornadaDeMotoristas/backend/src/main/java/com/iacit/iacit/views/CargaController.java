package com.iacit.iacit.views;

import java.util.Optional;

import com.iacit.iacit.IacitApplication;
import com.iacit.iacit.models.Cargas;
import com.iacit.iacit.repository.CargaRepository;

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
@RequestMapping("/carga")
public class CargaController {

    @Autowired
    CargaRepository cRepository;

    private static Logger logger = LoggerFactory.getLogger(IacitApplication.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cargas createCarga(@RequestBody final Cargas carga) {
        logger.info("Nova carga criada");
        return cRepository.save(carga);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Cargas>> findCarga(@PathVariable Long id){
        Optional<Cargas> carga;
        carga = cRepository.findById(id);
            return carga.map(Exist -> {
                logger.info("Carga " + id + " encontrado");
                return new ResponseEntity<Optional<Cargas>>(carga, HttpStatus.OK);
            }).orElseThrow(() -> {
                logger.info("Carga " + id + " não encontrado");
                return new ResponseStatusException(HttpStatus.NOT_FOUND,"Carga não encontrado");
            });
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCarga(@PathVariable final Long id,@RequestBody final Cargas carga)
    {
        cRepository.findById(id).map(cargaExist -> {
            carga.setId(cargaExist.getId());
            cRepository.save(carga);
            logger.info("Carga "+id+" alterada");
            return ResponseEntity.noContent().build();
        })
        .orElseThrow(() -> {
            logger.info("Carga "+id+" não encontrada");
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Alerta não encontrado");
        });
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarga (@PathVariable final Long id){
        cRepository.findById(id).map(carga -> {
            cRepository.delete(carga);
            logger.info("Carga "+id+" deletada");
            return carga;
        })
        .orElseThrow(() -> {
            logger.info("Carga "+id+" não encontrada");
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Alerta não encontrado");
        });
    }

}
