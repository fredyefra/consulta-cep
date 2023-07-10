package br.com.consulta.cep.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

@Path("/ws")
public class ConsultaCepResource {

    @Inject
    @RestClient
    private ConsultaCepService service;

    @ServerExceptionMapper
    public RestResponse<String> mapException(NegocioException negocioException) {
        return RestResponse.status(Response.Status.BAD_REQUEST, "Recurso não localizado: " + negocioException);
    }

    @GET
    @Path("/{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarCep(@PathParam("cep") final String cep) throws NegocioException {
        return Response.status(Response.Status.OK).entity(service.consultarPorCep(cep)).build();
    }
}