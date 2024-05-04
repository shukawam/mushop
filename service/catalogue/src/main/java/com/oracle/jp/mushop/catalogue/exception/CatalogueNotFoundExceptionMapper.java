package com.oracle.jp.mushop.catalogue.exception;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CatalogueNotFoundExceptionMapper implements ExceptionMapper<CatalogueNotFoundException> {

    @Override
    public Response toResponse(CatalogueNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND).type(MediaType.APPLICATION_JSON).build();
    }

}
