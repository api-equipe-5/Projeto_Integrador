package com.ExampleValcode.valcode.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Setter
@Getter
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movimentos {
    @Id
//    @SequenceGenerator(name = "GEN_MOVIMENTOS", sequenceName = "SEQ_MOVIMENTOS_2")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MOVIMENTOS")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

//    @ManyToOne
//    @JoinColumn(name = "movimento_doc_cli", referencedColumnName = "PF_DOC_CLI")
    private String doc_cli;

    @Column(name = "movimento_tip_cli")
    private String tip_cli;

//    @ManyToOne
//    @JoinColumn(name = "movimento_id_fonte", referencedColumnName = "id")
    private String id_fnt;

    @Column(name = "movimento_num_unc")
    private String num_unc;

    @Column(name = "movimento_dat_vct")
    private LocalDate dat_vct;

    @Column(name = "movimento_qtd_pcl_vnc")
    private BigInteger qtd_pcl_vnc;

    @Column(name = "movimento_qtd_pcl_pgr")
    private BigDecimal qtd_pcl_pgr;

    @Column(name = "movimento_vlr_tot_fat")
    private BigDecimal vlr_tot_fat;

    @Column(name = "movimento_vlr_min_fat")
    private BigDecimal vlr_min_fat;

    @Column(name = "movimento_vlr_pcl")
    private BigDecimal vlr_pcl;

    @Column(name = "movimento_tip_mvt")
    private String tip_mvt;

    @Column(name = "movimento_prd")
    private String prd;

    public Movimentos(String doc_cli, String tip_cli, String id_fnt, String num_unc, LocalDate dat_vct, BigInteger qtd_pcl_vnc, BigDecimal qtd_pcl_pgr, BigDecimal vlr_tot_fat, BigDecimal vlr_min_fat, BigDecimal vlr_pcl, String tip_mvt, String prd) {
        this.doc_cli = doc_cli;
        this.tip_cli = tip_cli;
        this.id_fnt = id_fnt;
        this.num_unc = num_unc;
        this.dat_vct = dat_vct;
        this.qtd_pcl_vnc = qtd_pcl_vnc;
        this.qtd_pcl_pgr = qtd_pcl_pgr;
        this.vlr_tot_fat = vlr_tot_fat;
        this.vlr_min_fat = vlr_min_fat;
        this.vlr_pcl = vlr_pcl;
        this.tip_mvt = tip_mvt;
        this.prd = prd;
    }
}
