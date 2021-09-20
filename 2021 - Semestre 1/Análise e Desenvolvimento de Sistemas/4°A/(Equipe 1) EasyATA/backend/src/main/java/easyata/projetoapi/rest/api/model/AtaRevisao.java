package easyata.projetoapi.rest.api.model;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name = "revisao_ata")
@Entity
public class AtaRevisao implements Serializable {
    //Cabeçalho
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 50)
    public Long id_ata;

    @Column(nullable = false, length = 50)
    public String assunto_rev;

    @Column(nullable = false, length = 50)
    public String responsavel_rev;

    @Column(nullable = false, length = 50)
    public String prazo_rev;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_ata() { return id_ata; }

    public void setId_ata(Long id_ata) { this.id_ata = id_ata; }

    public String getAssunto() {
        return assunto_rev;
    }

    public void setAssunto(String assunto) {
        this.assunto_rev = assunto;
    }

    public String getResponsavel() {
        return responsavel_rev;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel_rev = responsavel;
    }

    public String getPrazo() {
        return prazo_rev;
    }

    public void setPrazo(String prazo) {
        this.prazo_rev = prazo;
    }
}