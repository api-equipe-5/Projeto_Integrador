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
@Table(name = "union", schema = "springproject")
public class Union extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Union(Union union) {
        this.id = union.getId();
        this.name = union.getName();
        this.workingHours = union.getWorkingHours();
        this.restingHours = union.getRestingHours();
        this.firstFraction = union.getFirstFraction();
        this.secondFraction = union.getSecondFraction();
        this.thirdFraction = union.getThirdFraction();
        this.lunchTime = union.getLunchTime();
        this.timeOff = union.getTimeOff();
        this.allowedExtraHours = union.getAllowedExtraHours();
        this.allowedClockHours = union.getAllowedClockHours();
    }
}