package com.rosso.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_USUARIO")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @Size(min = 3, max = 100)
    @NotBlank
    @Column(name = "NOME")
    private String nome;

    @Size(min = 3, max = 100)
    @NotBlank
    @Column(name = "LOGIN_USER")
    private String loginUser;

    @Size(min = 3, max = 100)
    @NotBlank
    @Column(name = "SENHA")
    private String senha;

    @Email
    @NotBlank
    @Column(name = "EMAIL")
    private String email;

//    @NotNull
//    @Column(name = "")
//    private LocalDate dataCadastro;
}
