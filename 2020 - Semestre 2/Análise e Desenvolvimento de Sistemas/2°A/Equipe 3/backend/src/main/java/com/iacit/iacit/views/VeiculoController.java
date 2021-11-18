package com.iacit.iacit.views;

import java.util.List;
import java.util.Optional;

import com.iacit.iacit.IacitApplication;
import com.iacit.iacit.models.Veiculos;
import com.iacit.iacit.repository.VeiculoRepository;

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

@RestController
@CrossOrigin
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    VeiculoRepository vRepository;

    private static Logger logger = LoggerFactory.getLogger(IacitApplication.class);

    // Criar Veículo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculos createVeiculo(@RequestBody final Veiculos veiculo) {
        logger.info("Novo veículo criado");
        return vRepository.save(veiculo);
    }

    //Listar todos os veículos
    @GetMapping("index")
    public List<Veiculos> indexVeiculo(){
        logger.info("Listagem de veiculos");
        return vRepository.findAll();
    }

    //Achar um veículo por id
    @GetMapping("{id}")
    public ResponseEntity<Optional<Veiculos>> findVeiculo(@PathVariable String id){
        Optional<Veiculos> veiculo;
            veiculo = vRepository.findById(id);
            return veiculo.map(veiculoExist -> {
                logger.info("Veículo " + id + " encontrado");
                return new ResponseEntity<Optional<Veiculos>>(veiculo, HttpStatus.OK);
            }).orElseThrow(() -> {
                logger.info("Veículo " + id + " não encontrado");
                return new ResponseStatusException(HttpStatus.NOT_FOUND,"Veículo não encontrado");
            });
    }

    //Alterar um veículo
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateVeículo(
        @PathVariable final String id,
        @RequestBody final Veiculos veiculo
    )
    {
        vRepository
                    .findById(id)
                    .map(veiculoExist -> {
                        veiculo.setChassi(veiculoExist.getChassi());
                        vRepository.save(veiculo);
                        logger.info("Veículo "+id+" alterado");
                        return ResponseEntity.noContent().build();
                    })
                    .orElseThrow(() -> {
                        logger.info("Veículo "+id+" não encontrado");
                        return new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado");
                    });
    }

    //Deletar um veículo
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVeiculo (@PathVariable final String id){
        vRepository.findById(id)
            .map(veiculo -> {
                vRepository.delete(veiculo);
                logger.info("Veículo "+id+" deletado");
                return veiculo;
            })
            .orElseThrow(() -> {
                logger.info("Veículo "+id+" não encontrado");
                return new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado");
            });
    }

    //Pesquisar por um veículo atraves de um filtro
    @GetMapping
    public List<Veiculos> searchVeiculo(final Veiculos filtro){
        final ExampleMatcher matcher = ExampleMatcher
                                    .matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        final Example example = Example.of(filtro, matcher);
        return vRepository.findAll(example);
    }

}
