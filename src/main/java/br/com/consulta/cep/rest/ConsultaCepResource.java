package br.com.consulta.cep.rest;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Path("/ws")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsultaCepResource {

    @Inject
    @RestClient
    private ConsultaCepService service;

    @Inject
    Validator validator;

    @GET
    @Path("/{cep}")
    public Response consultarCep(
            @Valid
            @PathParam("cep") EnderecoWrapper cep) throws NegocioException {

        EnderecoWrapper endereco = service.consultarPorCep(cep.getCep());

        return Response.status(Response.Status.OK).entity(endereco).build();
    }

    //(UF, Bairro e Logradouro)
    @GET
    @Path("/{uf}/{bairro}/{logradouro}")
    public Response consultarPorUFCidadeLogradouro(@PathParam("uf") final String uf,
                                                   @PathParam("bairro") final String bairro,
                                                   @PathParam("logradouro") final String logradouro) {

        List<EnderecoWrapper> enderecos =
                service.consultarPorUFCidadeLogradouro(uf, bairro, logradouro)
                        .stream()
                        .filter(e -> e.getUf().length() == 2)
                        .filter(e -> e.getBairro().length() >= 3)
                        .filter(e -> e.getLogradouro().length() >= 3)
                        //.sorted(comparing(EnderecoWrapper::getCep).reversed())
                        .collect(Collectors.toList());

        return Response.status(Response.Status.OK).entity(enderecos).build();

    }
}