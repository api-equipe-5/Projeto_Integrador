package com.ExampleValcode.valcode.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Operacoes {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "operacoes_cd_operacoes")
    private Integer id;

    @Column(name = "operacoes_doc_cli")
    private String docCli;

    @Column(name = "operacoes_tip_cli")
    private String tipCli;

    @Column(name = "operacoes_num_unc")
    private Integer numUnc;

    @Column(name = "operacoes_id_mdl")
    private Integer idMdl;

    @Column(name = "operacoes_cod_mdl")
    private String codMdl;

    @Column(name = "operacoes_qtd_pcl")
    private String qtdPcl;

    @Column(name = "operacoes_dat_ctrc")
    private String datCtrc;

    @Column(name = "operacoes_dat_vct_ult_pcl")
    private String dtVctUltPcl;

    @Column(name = "operacoes_dat_vct")
    private String datVct;

    @Column(name = "operacoes_vlr_ctrd_fta")
    private Double vlrCrtdFta;

    @Column(name = "operacoes_vlr_ctrd")
    private Double vlrCtrd;

    @Column(name = "operacoes_sdo_ddr")
    private Double sdoDdr;

    public Operacoes(String docCli, String tipCli, Integer numUnc, Integer idMdl, String codMdl, String qtdPcl, String datCtrc, String dtVctUltPcl, String datVct, Double vlrCrtdFta, Double vlrCtrd, Double sdoDdr) {
        this.docCli = docCli;
        this.tipCli = tipCli;
        this.numUnc = numUnc;
        this.idMdl = idMdl;
        this.codMdl = codMdl;
        this.qtdPcl = qtdPcl;
        this.datCtrc = datCtrc;
        this.dtVctUltPcl = dtVctUltPcl;
        this.datVct = datVct;
        this.vlrCrtdFta = vlrCrtdFta;
        this.vlrCtrd = vlrCtrd;
        this.sdoDdr = sdoDdr;
    }
}
