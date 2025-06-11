package com.rosso.dominio.repository;

import com.rosso.dominio.entity.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.inject.Singleton;

@Singleton
public class UsuarioRepository implements PanacheRepositoryBase<Usuario, Integer> {
}
