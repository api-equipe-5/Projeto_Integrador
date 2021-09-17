package com.example.PITime01.application.dto.audit;

import com.example.PITime01.domain.Employee;
import com.example.PITime01.domain.Profile;
import com.example.PITime01.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAuditDTO {
    private long id;
    private String name;
    private Profile profile;
    private Status status;
    private String cpf;
    private String registration;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;

    public EmployeeAuditDTO(Employee employee) {
        this.name = employee.getName();
        this.createdBy = employee.getCreatedBy();
        this.createdDate = employee.getCreatedDate();
        this.lastModifiedBy = employee.getLastModifiedBy();
        this.lastModifiedDate = employee.getLastModifiedDate();
    }
}

