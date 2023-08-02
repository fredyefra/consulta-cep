package br.com.consulta.cep.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageError  {

    private String message;
    private int code;


    @Override
    public String toString() {
        return "MessageError{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
