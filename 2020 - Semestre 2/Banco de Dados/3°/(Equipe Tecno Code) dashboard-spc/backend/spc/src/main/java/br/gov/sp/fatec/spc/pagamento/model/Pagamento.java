package br.gov.sp.fatec.spc.pagamento.model;

import br.gov.sp.fatec.spc.fonte.model.Fonte;
import br.gov.sp.fatec.spc.modalidade.model.Modalidade;
import br.gov.sp.fatec.spc.pessoafisica.model.PessoaFisica;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "pagamento")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"pessoaFisica", "fonte"})
public class Pagamento implements Serializable {

    @Id
    @Column(name = "doc_cli")
    private String pessoaFisica;

    @Column(name = "tip_cli")
    private String tipoCliente;

    @ManyToOne
    @JoinColumn(name = "id_fnt", columnDefinition = "id_fnt", referencedColumnName = "id_fnt")
    private Fonte fonte;

    @Column(name = "num_unc")
    private Long numContrato;

    @Column(name = "dat_pgt")
    private LocalDate dataPagParcela;

    @Column(name = "dat_vct")
    private LocalDate datVencimento;

    @Column(name = "vlr_pgt")
    private Double valorPago;

    @ManyToOne
    @JoinColumn(name = "cod_mdl", columnDefinition = "cod_mdl", referencedColumnName = "cod_modalidade")
    private Modalidade modalidade;



}
