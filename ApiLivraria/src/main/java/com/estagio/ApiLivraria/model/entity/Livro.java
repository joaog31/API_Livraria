package com.estagio.ApiLivraria.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Livro_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotNull
    @Column(columnDefinition = "text", nullable = false)
    private String titulo;

    @NotBlank
    @NotNull
    @Column(columnDefinition = "text", nullable = false)
    private String autor;

    @NotBlank
    @NotNull
    @Column(columnDefinition = "text", nullable = false, unique = true)
    private String isbn;


    @NotNull
    @Column(nullable = false)
    private int anoDePublicacao;

}
