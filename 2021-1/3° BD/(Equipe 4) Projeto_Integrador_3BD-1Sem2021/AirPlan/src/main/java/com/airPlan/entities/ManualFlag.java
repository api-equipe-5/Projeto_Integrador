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
@Table(name = "manual_flag")
public class ManualFlag implements Serializable {

    @EmbeddedId
    private ManualFlagId manualFlagId;
}
