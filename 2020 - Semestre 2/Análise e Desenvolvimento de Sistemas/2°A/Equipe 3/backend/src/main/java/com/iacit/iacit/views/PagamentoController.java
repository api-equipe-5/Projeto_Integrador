package com.iacit.iacit.views;

import java.util.List;
import java.util.Optional;

import com.iacit.iacit.IacitApplication;
import com.iacit.iacit.models.Pagamentos;
import com.iacit.iacit.repository.PagamentoRepository;

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
@RequestMapping("/pagamento")
public class PagamentoController {
    
    @Autowired
    PagamentoRepository pRepository;

    private static Logger logger = LoggerFactory.getLogger(IacitApplication.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamentos createPagamento(@RequestBody final Pagamentos pagamento) {
        logger.info("Novo Pagamento criado");
        return pRepository.save(pagamento);
    }

    @GetMapping("/extrato/mensal")
    public List<Pagamentos> getExtrato(int mes,int ano){
        logger.info("Listagem de extrato: "+mes+"/"+ano);
        return pRepository.getExtrato(mes, ano);
    }

    @GetMapping("/extrato/diario")
    public List<Pagamentos> getDiario(String dia){
        logger.info("Listagem de extrato dia: "+dia);
        return pRepository.getDay(dia);
    }

    @GetMapping("usuario/{id}")
    public List<Pagamentos> indexByUsuario(@PathVariable String id){
        logger.info("Listagem de pagamentos do usuário "+id);
        return pRepository.findByUsuario(id);
    }

    @GetMapping("index")
    public List<Pagamentos> indexPagamentos(){
        logger.info("Listagem de pagamentos");
        return pRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Pagamentos>> findPagamentos(@PathVariable Long id){
        Optional<Pagamentos> pagamento;
        pagamento = pRepository.findById(id);
            return pagamento.map(Exist -> {
                logger.info("Pagamento " + id + " encontrado");
                return new ResponseEntity<Optional<Pagamentos>>(pagamento, HttpStatus.OK);
            }).orElseThrow(() -> {
                logger.info("Pagamento " + id + " não encontrado");
                return new ResponseStatusException(HttpStatus.NOT_FOUND,"Pagamento não encontrado");
            });
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePagamento(@PathVariable final Long id,@RequestBody final Pagamentos pagamento)
    {
        pRepository.findById(id).map(pagamentoExist -> {
            pagamento.setId(pagamentoExist.getId());
            pRepository.save(pagamento);
            logger.info("Pagamento "+id+" alterado");
            return ResponseEntity.noContent().build();
        }).orElseThrow(() -> {
            logger.info("Pagamento "+id+" não encontrado");
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrada");
        });
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJornada (@PathVariable final Long id){
        pRepository.findById(id).map(pagamento -> {
            pRepository.delete(pagamento);
            logger.info("Pagamento "+id+" cancelado");
            return ResponseEntity.noContent().build();
        })
        .orElseThrow(() -> {
            logger.info("Pagamento "+id+" não encontrado");
            return new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrada");
        });
    }

}
