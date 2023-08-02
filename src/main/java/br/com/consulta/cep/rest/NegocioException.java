package br.com.consulta.cep.rest;

import jakarta.ws.rs.WebApplicationException;

import java.io.Serializable;

public class NegocioException extends Exception {
    public NegocioException(String message) {
        super(message);
    }
}