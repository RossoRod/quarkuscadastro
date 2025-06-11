package com.rosso.dominio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Size(min = 3, max = 100)
    @NotBlank
    private String nome;
    @Size(min = 3, max = 100)
    @NotBlank
    private String loginUser;
    @Size(min = 3, max = 100)
    @NotBlank
    private String senha;
    @Email
    @NotBlank
    private String email;
    @NotNull
    private LocalDate dataCadastro;
}
