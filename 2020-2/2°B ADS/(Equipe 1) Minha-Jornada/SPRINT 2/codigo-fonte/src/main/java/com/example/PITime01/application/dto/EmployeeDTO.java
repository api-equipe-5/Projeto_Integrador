package com.example.PITime01.application.dto;

import com.example.PITime01.domain.Employee;
import com.example.PITime01.domain.Profile;
import com.example.PITime01.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * class UserDTO is used to publicly expose data stored in the database
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private long id;
    private String name;
    private Profile profile;
    private Status status;
    private String cpf;
    private String registration;


    public EmployeeDTO(Employee employee) {

        this.id = employee.getId();
        this.name = employee.getName();
        this.profile = employee.getProfile();
        this.status = employee.getStatus();
        this.cpf = employee.getCpf().substring(0, 5) + employee.getCpf().substring(5).replaceAll("[0-9]", "*");
        this.registration = employee.getRegistration();

    }
}
