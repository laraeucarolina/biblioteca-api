package com.biblioteca.biblioteca_api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Exemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;

    private LocalDate dataAquisicao;
    private String situacao;
}
