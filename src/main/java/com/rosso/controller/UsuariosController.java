package com.rosso.controller;

import com.rosso.entity.UsuarioEntity;
import com.rosso.service.UsuariosService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
public class UsuariosController {
    @Inject
    UsuariosService usuariosService;

    @POST
    @Transactional
    public Response criarUsuario(@Valid UsuarioEntity usuario){
        return Response.ok(usuariosService.criarUsuario(usuario)).build();
    }

    @GET
    @Path("/{idUsuario}")
    public Response buscarUsuarioPorId(@PathParam("IdUsuario") Integer IdUsuario){
        return Response.ok(usuariosService.buscarUsuarioPorId(IdUsuario)).build();
    }

    @PUT
    @Path("/{idUsuario}")
    @Transactional
    public Response atualizarUsuario (@PathParam("idUsuario") Integer idUsuario, UsuarioEntity usuario){
        return Response.ok(usuariosService.atualizarUsuario(idUsuario, usuario)).build();
    }

    @DELETE
    @Path("/{idUsuario}")
    @Transactional
    public Response deletarUsuarioPorId(@PathParam("IdUsuario") Integer IdUsuario){
        usuariosService.deletarUsuarioPorId(IdUsuario);
        return Response.noContent().build();
    }

    @GET
    public Response listarUsuarios(
            @QueryParam("page") @DefaultValue("0") Integer page,
            @QueryParam("size") @DefaultValue("5") Integer size){
        return Response.ok(usuariosService.listarUsuarios(page, size)).build();
    }
}
