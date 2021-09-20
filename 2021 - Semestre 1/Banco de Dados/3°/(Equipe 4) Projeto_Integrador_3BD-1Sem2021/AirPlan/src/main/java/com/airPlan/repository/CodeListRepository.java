package com.airPlan.repository;

import com.airPlan.entities.CodeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CodeListRepository extends JpaRepository<CodeList, Integer> {

    @Query(" select c from CodeList c where c.mnl_id = :manualId ")
    List<CodeList> filtroManual(@Param("manualId") Integer manualId);

    @Query(" select c from CodeList c where c.mnl_id = :manualId and c.flg_secundary = :flgSecundary ")
    List<CodeList> filtroSecundary(@Param("manualId") Integer manualId, @Param("flgSecundary") String flgSecundary);

    @Query(" select c from CodeList c where c.mnl_id = :manualId and c.cdl_section = :cdlSection ")
    List<CodeList> filtroSection(@Param("manualId") Integer manualId, @Param("cdlSection") String cdlSection);

    @Query(" select c from CodeList c where c.mnl_id = :manualId and c.flg_secundary = :flgSecundary and c.cdl_section = :cdlSection ")
    List<CodeList> filtroSecundarySection(@Param("manualId") Integer manualId, @Param("flgSecundary") String flgSecundary, @Param("cdlSection") String cdlSection);

    @Query(" select c from CodeList c where c.mnl_id = :manualId and c.cdl_block_number = :cdlBlockNumber and c.cdl_section = :cdlSection ")
    List<CodeList> filtroBlocoSection(@Param("manualId") Integer manualId, @Param("cdlBlockNumber") Integer cdlBlockNumber, @Param("cdlSection") String cdlSection);

    @Query(" select c from CodeList c where c.mnl_id = :manualId and c.cdl_block_number = :cdlBlockNumber ")
    List<CodeList> filtroBloco(@Param("manualId") Integer manualId, @Param("cdlBlockNumber") Integer cdlBlockNumber);

    @Query(" select c from CodeList c where c.mnl_id = :manualId and c.flg_secundary = :flgSecundary and c.cdl_block_number = :cdlBlockNumber ")
    List<CodeList> filtroSecundaryBlock(@Param("manualId") Integer manualId, @Param("flgSecundary") String flgSecundary, @Param("cdlBlockNumber") Integer cdlBlock);

    @Query(" select c from CodeList c where c.mnl_id = :manualId and c.flg_secundary = :flgSecundary and c.cdl_block_number = :cdlBlockNumber and c.cdl_section = :cdlSection ")
    List<CodeList> filtroAll(@Param("manualId") Integer manualId, @Param("flgSecundary") String flgSecundary, @Param("cdlBlockNumber") Integer cdlBlock,
                             @Param("cdlSection") String cdlSection);
    // for future use
    @Query(" select c from CodeList c where c.mnl_id = :manualId and c.flg_secundary = :flgSecundary")
    List<CodeList> filtroLep(@Param("manualId") Integer manualId, @Param("flgSecundary") String flgSecundary);
}
