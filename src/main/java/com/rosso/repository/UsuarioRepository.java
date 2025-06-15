package com.rosso.repository;

import com.rosso.entity.UsuarioEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.inject.Singleton;

@Singleton
public class UsuarioRepository implements PanacheRepositoryBase<UsuarioEntity, Integer> {
}
