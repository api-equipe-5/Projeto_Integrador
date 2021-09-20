package br.gov.sp.fatec.spc.movimentos.service;

import br.gov.sp.fatec.spc.movimentos.model.Movimento;
import br.gov.sp.fatec.spc.movimentos.repository.MovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Service
public class MovimentoService {

    @Autowired
    private MovimentoRepository movimentoRepository;

    public List<Movimento> buscarPorMesEAno(final Integer mes, final Integer ano) {
        if(mes == null) {
            throw new RuntimeException("Mes é obrigatório.");
        }
        if(mes < 1 || mes > 12) {
            throw new RuntimeException("Mes é inválido.");
        }
        if(ano == null) {
            throw new RuntimeException("Ano é obrigatório.");
        }
        if(ano < 1900) {
            throw new RuntimeException("Ano é inválido.");
        }
        LocalDateTime dataIncial = LocalDateTime.of(ano, Month.of(mes), 1, 0, 0 , 0);
        LocalDateTime dataFinal = dataIncial.plusMonths(1).minusDays(1).plusHours(23).plusMinutes(59).plusSeconds(59);
        return movimentoRepository.findAllByDataVencimento(dataIncial, dataFinal);
    }

}
