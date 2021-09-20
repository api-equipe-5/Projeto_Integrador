package com.pi3.scorewizard.pagamento;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {
    Pagamento findById(int id);

    ArrayList<Pagamento> findByPessoaFisicaDocumentoAndDataPagamento(String documento, Date data);
}
