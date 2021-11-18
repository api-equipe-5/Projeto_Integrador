package com.tecsus.ddc.address;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Address {

    private String zip;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;

    @Override
    public String toString() {
        return "CEP: " + zip + "" +
                ", " + street +
                ", " + number +
                ", " + complement +
                ", " + neighborhood +
                ", " + city +
                ", " + state ;
    }
}
