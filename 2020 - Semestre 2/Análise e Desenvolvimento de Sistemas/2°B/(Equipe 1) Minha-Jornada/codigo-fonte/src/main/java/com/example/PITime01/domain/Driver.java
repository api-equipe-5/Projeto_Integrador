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
@Table(name = "driver", schema = "springproject")
public class Driver extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;
    private String surname;
    private String categoryLicense;
    private Integer yearAdmission;
    private String telephone;
    private String unionName;
    private String email;

    public Driver(Driver driver) {
        this.id = driver.getId();
        this.password = driver.getPassword();
        this.name = driver.getName();
        this.surname = driver.getSurname();
        this.categoryLicense = driver.getCategoryLicense();
        this.yearAdmission = driver.getYearAdmission();
        this.telephone = driver.getTelephone();
        this.unionName = driver.getUnionName();
        this.email = driver.getEmail();
    }
}
