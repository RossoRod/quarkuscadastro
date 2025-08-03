package com.rosso.exception.mapper;

import com.rosso.exception.UsuarioNaoEncontradoException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UsuarioNaoEncontradoExceptionMapper implements ExceptionMapper<UsuarioNaoEncontradoException> {
    @Override
    public Response toResponse(UsuarioNaoEncontradoException e) {
        return Response.status(Response.Status.NOT_FOUND.getStatusCode(),
                "Usuário não encontrado").build();
    }
}
