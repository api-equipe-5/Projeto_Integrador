package com.airPlan.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emp_id;

    private String emp_name;

    private String emp_password;

    private Integer typ_id;

    public User(String emp_name, String emp_password, Integer typ_id) {
        this.emp_name = emp_name;
        this.emp_password = emp_password;
        this.typ_id = typ_id;
    }
}
