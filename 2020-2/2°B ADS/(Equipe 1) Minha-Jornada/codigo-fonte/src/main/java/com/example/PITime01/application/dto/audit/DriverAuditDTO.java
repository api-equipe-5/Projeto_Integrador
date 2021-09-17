package com.example.PITime01.application.dto.audit;

import com.example.PITime01.domain.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverAuditDTO {
    private long id;
    private String name;
    private String surname;
    private String categoryLicense;
    private Integer yearAdmission;
    private String telephone;
    private String unionName;
    private String email;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;

    public DriverAuditDTO(Driver driver) {
        this.name = driver.getName();
        this.createdBy = driver.getCreatedBy();
        this.createdDate = driver.getCreatedDate();
        this.lastModifiedBy = driver.getLastModifiedBy();
        this.lastModifiedDate = driver.getLastModifiedDate();
    }
}
