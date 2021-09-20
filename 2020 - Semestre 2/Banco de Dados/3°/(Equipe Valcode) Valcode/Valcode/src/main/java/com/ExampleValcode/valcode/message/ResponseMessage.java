package com.ExampleValcode.valcode.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResponseMessage {
    private String menssage;

    public ResponseMessage(String menssage){
        this.menssage = menssage;
    }
}
