package br.gov.sp.fatec.spc.movimentos.model;

import br.gov.sp.fatec.spc.fonte.model.Fonte;
import br.gov.sp.fatec.spc.pessoafisica.model.PessoaFisica;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimentos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"pessoaFisica", "fonte"})
public class Movimento {
    @ManyToOne
    @JoinColumn(name = "doc_cli", columnDefinition = "doc_cli", referencedColumnName = "doc_cli")
    private PessoaFisica pessoaFisica;

    @ManyToOne
    @JoinColumn(name = "id_fnt", columnDefinition = "id_fnt", referencedColumnName = "id_fnt")
    private Fonte fonte;

    @Id
    @Column(name = "tip_cli")
    private String tipoCliente;

    @Column(name = "num_unc")
    private Long numeroContrato;

    @Column(name = "dat_vct")
    private LocalDateTime datVencimento;

    @Column(name = "qtd_pcl_vnc")
    private Long qntParcelaVencimento;

    @Column(name = "qtd_pcl_pgr")
    private Long qntParcelaAPagar;

    @Column(name = "vlr_total_fat")
    private Double valorTotalFat;

    @Column(name = "vlr_min_fat")
    private Double valorMinFat;

    @Column(name = "vlr_pcl")
    private Double valorParcela;

    @Column(name = "tip_mvt")
    @Enumerated(EnumType.STRING)
    private TipoMovimento tipoMovimento;

    @Column(name = "prd")
    private String periodicidade;

}
