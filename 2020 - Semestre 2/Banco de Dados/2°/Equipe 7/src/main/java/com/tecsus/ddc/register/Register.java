package com.tecsus.ddc.register;

import com.tecsus.ddc.bill.Bill;
import com.tecsus.ddc.instalation.Instalation;
import com.tecsus.ddc.user.User;
import lombok.Builder;
import lombok.Data;
import com.google.gson.Gson;

import java.util.Date;

@Builder
@Data
public class Register {

    private Integer id;
    private User user;
    private Bill bill;
    private Instalation instalation;
    private Date registerDate;

    public String toJson() {
        return new Gson().toJson(this);
    }
}
