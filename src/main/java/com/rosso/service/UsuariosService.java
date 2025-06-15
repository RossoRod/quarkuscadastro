package com.rosso.service;

import com.rosso.entity.UsuarioEntity;
import com.rosso.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import com.rosso.exception.UsuarioNaoEncontradoException;

import java.util.List;

@ApplicationScoped
public class UsuariosService {
    @Inject
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity criarUsuario(@Valid UsuarioEntity usuario) {
        usuarioRepository.persist(usuario);
        return usuario;
    }

    public UsuarioEntity buscarUsuarioPorId(Integer idUsuario) {
        return usuarioRepository.findByIdOptional(idUsuario).orElseThrow(UsuarioNaoEncontradoException::new);
    }

    public UsuarioEntity atualizarUsuario(Integer idUsuario, UsuarioEntity usuario) {
        UsuarioEntity usuarioExistente = buscarUsuarioPorId(idUsuario);
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setLoginUser(usuario.getLoginUser());
        usuarioExistente.setSenha(usuario.getSenha());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioRepository.persist(usuarioExistente);
        return usuarioExistente;
    }

    public void deletarUsuarioPorId(Integer idUsuario) {
        UsuarioEntity usuarioExistente = buscarUsuarioPorId(idUsuario);
        usuarioRepository.deleteById(usuarioExistente.getIdUsuario());
    }

    public List<UsuarioEntity> listarUsuarios(Integer page, Integer size) {
        return usuarioRepository.findAll().page(page, size).list();
    }
}
