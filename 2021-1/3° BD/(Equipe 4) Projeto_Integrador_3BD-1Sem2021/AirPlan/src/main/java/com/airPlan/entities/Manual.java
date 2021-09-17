package com.airPlan.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "manual")
public class Manual implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mnl_id;

    private String mnl_name;


    public Manual(String mnl_name) {
        this.mnl_name = mnl_name.trim();
    }
}
