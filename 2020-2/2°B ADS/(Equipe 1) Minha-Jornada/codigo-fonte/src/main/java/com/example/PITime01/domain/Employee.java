package com.example.PITime01.domain;

import com.example.PITime01.application.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
@Table(name = "employee", schema = "springproject")
public class Employee extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    private Profile profile;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
    private String cpf;
    private String registration;

}