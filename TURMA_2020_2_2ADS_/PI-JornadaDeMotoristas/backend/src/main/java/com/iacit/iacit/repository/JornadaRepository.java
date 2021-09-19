package com.iacit.iacit.repository;

import java.util.List;

import com.iacit.iacit.models.Jornadas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JornadaRepository extends JpaRepository<Jornadas,Long>{
    @Query(value = "select * from jornadas as j where cast(CURRENT_TIMESTAMP as date) between cast(j.data_inicio as date) and cast(j.data_final as date)",nativeQuery = true)
    List<Jornadas> findCurrent();

    @Query(value = "select j.* from jornadas as j join jornada_status as js on j.id = js.jornada and js.status=4", nativeQuery = true)
    List<Jornadas> getCanceled();

}
