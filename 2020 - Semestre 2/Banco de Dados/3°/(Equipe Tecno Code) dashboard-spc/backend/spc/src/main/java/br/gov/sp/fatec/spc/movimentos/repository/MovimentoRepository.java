package br.gov.sp.fatec.spc.movimentos.repository;

import br.gov.sp.fatec.spc.movimentos.model.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimentoRepository extends JpaRepository<Movimento, String> {
    @Query("SELECT m FROM Movimento m WHERE m.datVencimento BETWEEN :dataInicial AND :dataFinal")
    List<Movimento> findAllByDataVencimento(@Param("dataInicial") LocalDateTime dataInicial,
                                            @Param("dataFinal") LocalDateTime dataFinal);
}
