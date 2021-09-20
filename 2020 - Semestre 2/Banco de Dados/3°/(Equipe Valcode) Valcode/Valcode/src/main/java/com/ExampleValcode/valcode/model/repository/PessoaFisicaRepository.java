package com.ExampleValcode.valcode.model.repository;

import com.ExampleValcode.valcode.model.entity.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Collection;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, String> {

    @Query(value = "SELECT * FROM PESSOA_FISICA u WHERE u.PF_DOC_CLI = :id", nativeQuery = true)
    Collection<PessoaFisica> getByDoc(@Param("id") String id);
}
