package com.iacit.iacit.repository;

import java.util.List;
import com.iacit.iacit.models.Pagamentos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PagamentoRepository extends JpaRepository<Pagamentos, Long>{

    @Query(value = "select * from pagamento p where cast(p.data as date) = cast(:data as date)", nativeQuery = true)
    List<Pagamentos> getDay(@Param("data") String data);

    @Query(value="select * from pagamento where extract(month from data)=:mes and extract(year from data)=:ano and status='pago'",nativeQuery=true)
    List<Pagamentos> getExtrato(@Param("mes") int mes, @Param("ano") int ano);

    @Query(value = "SELECT * FROM pagamento p WHERE p.usuario=:id",nativeQuery = true)   
    List<Pagamentos> findByUsuario(@Param("id") String id);
}
