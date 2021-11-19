package com.fatec.team1.TeachingPlatform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Matriculas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idCursoFk;
    private long idUsuarioFk;

    public Matricula(Matricula matricula) {
        this.id = matricula.getId();
        this.idCursoFk = matricula.getIdCursoFk();
        this.idUsuarioFk = matricula.getIdCursoFk();
    }
}
