package br.com.consulta.cep.rest;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path(value = "/ws")
@RegisterRestClient(configKey = "consulta-cep-api")
public interface ConsultaCepService {

    //@GET
    //@Produces(MediaType.APPLICATION_JSON)
    //@Path("/{cep}/json/")
    //default EnderecoWrapper consultarCep(@PathParam("cep") String cep) {
    //  EnderecoWrapper enderecoWrapper = new EnderecoWrapper(cep);
    //return enderecoWrapper;
    //}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{cep}/json/")
    EnderecoWrapper consultarPorCep(@PathParam("cep") final String cep);

    //(UF, Cidade e Logradouro)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{uf}/{cidade}/{logradouro}/json/")
    List<EnderecoWrapper> consultarPorUFCidadeLogradouro(
            @PathParam("uf") String uf,
            @PathParam("cidade") String cidade,
            @PathParam("logradouro") String logradouro);

}
