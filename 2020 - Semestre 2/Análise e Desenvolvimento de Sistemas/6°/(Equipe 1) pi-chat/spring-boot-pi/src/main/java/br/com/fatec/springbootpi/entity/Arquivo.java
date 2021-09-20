package br.com.fatec.springbootpi.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.fatec.springbootpi.controller.View;

@Entity
@Table(name = "arquivo")
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arquivo")
    private Long idArquivo;

    @JsonView(View.ArquivoResumo.class)
    @Column(name = "nome_arquivo")
    private String nomeArquivo;

    @JsonView(View.ArquivoResumo.class)
    @Column(name = "desc_arquivo")
    private String descArquivo;

    @JsonView(View.ArquivoResumo.class)
    @Column(name = "data_criado")
    private Date dataCriado;

    @JsonView(View.ArquivoResumo.class)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_arquivo",
    joinColumns = { @JoinColumn(name = "id_arquivo") },
    inverseJoinColumns = { @JoinColumn(name = "id_usuario") })
    private Set<Usuario> usuarios;

    public Long getIdArquivo() {
        return idArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public String getDescArquivo() {
        return descArquivo;
    }

    public Date getDataCriado() {
        return dataCriado;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setIdArquivo(Long idArquivo) {
        this.idArquivo = idArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void setDataCriado(Date dataCriado) {
        this.dataCriado = dataCriado;
    }

    public void setDescArquivo(String descArquivo) {
        this.descArquivo = descArquivo;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}