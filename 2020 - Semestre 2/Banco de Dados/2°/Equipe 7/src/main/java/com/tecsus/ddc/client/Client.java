package com.tecsus.ddc.client;

import com.google.gson.Gson;
import com.tecsus.ddc.identification.Identification;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Client {

    private String name;
    private Identification identification;

    public String toJson() {
        return new Gson().toJson(this);
    }
}
