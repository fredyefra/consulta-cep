package br.com.consulta.cep.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;


@Traced
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

    //(UF, Cidade e Logradouro)


    @GET
    @Path("/{uf}/{cidade}/{logradouro}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarPorUFCidadeLogradouro (@PathParam("uf") String uf,
                                                    @PathParam("cidade") String cidade,
                                                    @PathParam("logradouro") String logradouro){
         return Response.status(Response.Status.OK).entity(service.consultarPorUFCidadeLogradouro(uf,cidade,logradouro)).build();
        //return Response.ok(service.consultarPorUFCidadeLogradouro(uf,cidade,logradouro)).build();
    }
}