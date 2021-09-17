package com.example.PITime01.application.dto.audit;

import com.example.PITime01.domain.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleAuditDTO {
    private Long id;
    private String chassi;
    private String trackerBrand;
    private String trackerVersion;
    private String idIntegr;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;

    public VehicleAuditDTO(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.chassi = vehicle.getChassi();
        this.createdBy = vehicle.getCreatedBy();
        this.createdDate = vehicle.getCreatedDate();
        this.lastModifiedBy = vehicle.getLastModifiedBy();
        this.lastModifiedDate = vehicle.getLastModifiedDate();
    }
}
