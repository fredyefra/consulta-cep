package br.com.consulta.cep.rest;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;
import java.util.Optional;

@Path(value = "/ws")
@RegisterRestClient(configKey = "consulta-cep-api")
@RegisterProvider(NegocioExceptionMapper2.class)
public interface ConsultaCepService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{cep}/json/")
    EnderecoWrapper consultarPorCep(@PathParam("cep") String cep);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{uf}/{cidade}/{logradouro}/json/")
    List<EnderecoWrapper> consultarPorUFCidadeLogradouro(
            @PathParam("uf") String uf,
            @PathParam("cidade") String cidade,
            @PathParam("logradouro") String logradouro);

    }
