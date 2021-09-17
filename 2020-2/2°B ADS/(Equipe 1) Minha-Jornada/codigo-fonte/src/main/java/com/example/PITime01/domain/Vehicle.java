package com.example.PITime01.domain;

import com.example.PITime01.application.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Audited
@Table(name = "vehicle", schema = "springproject")
public class Vehicle extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chassi;
    private String trackerBrand;
    private String trackerVersion;
    private String idIntegr;

}
