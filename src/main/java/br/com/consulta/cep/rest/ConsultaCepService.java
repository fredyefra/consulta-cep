package br.com.consulta.cep.rest;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

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

}
