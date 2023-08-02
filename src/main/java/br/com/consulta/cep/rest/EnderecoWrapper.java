package br.com.consulta.cep.rest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoWrapper {


    @Size(min = 8, max = 8, message = "Cep deve possir [{max}] digitos.")
    @NotBlank(message = "Cep não pode estar nulo.")
    @NotEmpty(message = "Cep não pode estar vazio.")
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;

    public EnderecoWrapper(String cep) {
        this.cep = cep;
    }

    public EnderecoWrapper() {}

    public EnderecoWrapper(String cep, String logradouro, String complemento, String bairro, String ddd) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return " CEP: " + this.cep + " - " + " LOGRADOURO: " + this.logradouro + this.complemento + " - " + "  BAIRRO: " + this.bairro;
    }
}