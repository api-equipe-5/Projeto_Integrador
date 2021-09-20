package com.pi3.scorewizard.movimento;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovimentoRepository extends CrudRepository<Movimento, Integer> {
    @Query("SELECT m FROM Movimento m WHERE m.pessoaFisica.documento = ?1 AND data_vencimento < NOW() AND DATE(data_vencimento) not in (select DATE(data_vencimento) from Pagamento p where p.numUnc = m.numUnc and m.pessoaFisica = p.pessoaFisica group by data_vencimento) GROUP BY data_vencimento ORDER BY numUnc, data_vencimento")
    ArrayList<Movimento> findByPessoaFisicaDocumento(String documento);

    @Query("SELECT COUNT(*) FROM Movimento m WHERE m.pessoaFisica.documento = ?1 AND data_vencimento < NOW() AND DATE(data_vencimento) not in (select DATE(data_vencimento) from Pagamento p where p.numUnc = m.numUnc and m.pessoaFisica = p.pessoaFisica group by data_vencimento) GROUP BY data_vencimento ORDER BY numUnc, data_vencimento")
    long findByPessoaFisicaDocumentoCount(String documento);
}
