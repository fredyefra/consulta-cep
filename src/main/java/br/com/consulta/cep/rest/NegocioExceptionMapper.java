package br.com.consulta.cep.rest;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NegocioExceptionMapper implements ExceptionMapper<NegocioException> {
    @Override
    public Response toResponse(NegocioException exception) {
        System.out.println(exception);
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}