package com.rosso.dominio.controller;

import com.rosso.dominio.entity.Usuario;
import com.rosso.dominio.repository.UsuarioRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/usuarios")
public class UsuariosController {
    @Inject
    private UsuarioRepository usuarioRepository;

    @POST
    @Transactional
    public Usuario criarUsuario(@Valid Usuario usuario){
        usuarioRepository.persist(usuario);
        return usuario;
    }

    @GET
    @Path("/{idUsuario}")
    public Usuario buscarUsuarioPorId(@PathParam("IdUsuario") Integer IdUsuario){
        return usuarioRepository.findById(IdUsuario);
    }


    @PUT
    @Path("/{idUsuario}")
    @Transactional
    public Usuario atualizarUsuario (@PathParam("idUsuario") Integer idUsuario, Usuario usuario){
        Usuario usuarioExistente = usuarioRepository.findById(idUsuario);
        if (usuarioExistente != null){
            usuarioExistente.setNome(usuario.getNome());
            usuarioExistente.setLoginUser(usuario.getLoginUser());
            usuarioExistente.setSenha(usuario.getSenha());
            usuarioExistente.setEmail(usuario.getEmail());
            return usuarioExistente;
        }
        return null;
    }

    @DELETE
    @Path("/{idUsuario}")
    @Transactional
    public void deletarUsuario(@PathParam("IdUsuario") Integer IdUsuario){
        usuarioRepository.deleteById(IdUsuario);
    }

    @GET
    public List<Usuario> listarUsuarios(
            @QueryParam("page") @DefaultValue("0") Integer page,
            @QueryParam("size") @DefaultValue("5") Integer size){
        return usuarioRepository.findAll().page(page, size).list();
    }
}
