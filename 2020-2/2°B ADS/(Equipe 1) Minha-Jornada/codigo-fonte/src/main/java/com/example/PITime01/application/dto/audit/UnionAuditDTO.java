package com.example.PITime01.application.dto.audit;

import com.example.PITime01.domain.Union;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnionAuditDTO {
    private long id;
    private String name;
    private Integer workingHours;
    private Integer restingHours;
    private Integer firstFraction;
    private Integer secondFraction;
    private Integer thirdFraction;
    private Integer lunchTime;
    private Integer timeOff;
    private Integer allowedExtraHours;
    private Integer allowedClockHours;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;

    public UnionAuditDTO(Union union) {
        this.name = union.getName();
        this.createdBy = union.getCreatedBy();
        this.createdDate = union.getCreatedDate();
        this.lastModifiedBy = union.getLastModifiedBy();
        this.lastModifiedDate = union.getLastModifiedDate();
    }

}
