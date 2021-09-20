package com.ExampleValcode.valcode.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pagamentos {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name="pagamentos_doc_cli")
    private String doc_cli;

    @Column(name = "pagamentos_tip_cli")
    private String tip_cli;

    @Column(name = "pagamentos_id_ftn")
    private String id_ftn;

    @Column(name = "pagamentos_num_unc")
    private String num_unc;

    @Column(name = "pagamentos_dat_pgt")
    private LocalDateTime dat_pgt;

    @Column(name = "pagamentos_dat_vct")
    private LocalDateTime dat_vct;

    @Column(name = "pagementos_vlr_pgt")
    private Double vlr_pgt;

//    @ManyToOne
//    @JoinColumn(name = "pagamento_cod_mdl", referencedColumnName = "MODALIDADE_COD_MODALIDADE")
    @Column(name = "pagementos_cod_mdl")
    private String cod_mdl;

    public Pagamentos(String doc_cli, String tip_cli, String id_ftn, String num_unc, LocalDateTime dat_pgt, LocalDateTime dat_vct, Double vlr_pgt, String cod_mdl) {
        this.doc_cli = doc_cli;
        this.tip_cli = tip_cli;
        this.id_ftn = id_ftn;
        this.num_unc = num_unc;
        this.dat_pgt = dat_pgt;
        this.dat_vct = dat_vct;
        this.vlr_pgt = vlr_pgt;
        this.cod_mdl = cod_mdl;
    }
}
