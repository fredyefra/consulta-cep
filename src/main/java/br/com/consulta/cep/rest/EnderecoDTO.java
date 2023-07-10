package br.com.consulta.cep.rest;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EnderecoDTO implements Serializable {

    private Long identificador;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;
    public EnderecoDTO(String cep) {
        this.cep = cep;
    }

    public EnderecoDTO() {
        // TODO Auto-generated constructor stub
    }

    public EnderecoDTO(Long identificador, String cep, String logradouro, String complemento, String bairro, String ddd) {
        this.identificador = identificador;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return " CEP: " + this.cep + " - "+" LOGRADOURO: " + this.logradouro + this.complemento +  " - "+"  BAIRRO: " + this.bairro ;
    }
}


