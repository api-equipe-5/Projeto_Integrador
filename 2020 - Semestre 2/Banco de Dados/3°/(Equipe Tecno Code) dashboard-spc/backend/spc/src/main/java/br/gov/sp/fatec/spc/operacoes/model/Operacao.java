package br.gov.sp.fatec.spc.operacoes.model;

import br.gov.sp.fatec.spc.fonte.model.Fonte;
import br.gov.sp.fatec.spc.pessoafisica.model.PessoaFisica;
import br.gov.sp.fatec.spc.movimentos.model.Movimento;
import br.gov.sp.fatec.spc.modalidade.model.Modalidade;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;


@Entity
@Table(name = "operacao")
@Getter
@Builder
@EqualsAndHashCode(of = {"pessoaFisica", "fonte"})
public class Operacao implements Serializable{
    @PrimaryKeyJoinColumn(name = "doc_cli", columnDefinition = "doc_cli", referencedColumnName = "doc_cli")
    private PessoaFisica pessoaFisica;

    @Id
    @Column(name = "tip_cli")
    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @Column(name = "num_unc")
    private Long numContrato;

    @PrimaryKeyJoinColumn(name = "id_fnt", columnDefinition = "id_fnt", referencedColumnName = "id_fnt")
    private Fonte fonte;

    @PrimaryKeyJoinColumn(name = "cod_mdl", columnDefinition = "cod_mdl", referencedColumnName = "cod_modalidade")
    private Modalidade modalidade;

    @Id
    @Column(name = "qntd_pcl")
    private String qndParcelaContrato;

    @Id
    @Column(name = "dat_ctrc")
    private String dataContrato;

    @Id
    @Column(name = "dat_vct_ult_pcl")
    private String datVencUltPcl;

    @Id
    @Column(name = "dat_vct")
    private String dataVencimento;

    @Id
    @Column(name = "vlr_ctrd_fta")
    private String valorTotContFat;

    @Id
    @Column(name = "vlr_ctrd")
    private String valorTotContConsorcio;

    @Id
    @Column(name = "sdo_ddr")
    private String valorSaldoDevedor;
}
