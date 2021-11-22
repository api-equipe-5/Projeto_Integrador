package br.com.fatec.springbootpi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.fatec.springbootpi.controller.View;

@Entity
@Table(name="tipo_usuario")
public class TipoUsuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario")
    private Long idTipoUsuario;

    @JsonView({View.UsuarioResumo.class, View.TipoUsuarioResumo.class})
    @Column(name = "nome_tipo_usuario")
    private String nome;

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public String getNome() {
        return nome;
    }
}