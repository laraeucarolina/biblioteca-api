package com.biblioteca.biblioteca_api.model;

import jakarta.persistence.*;

@Entity
public class AssuntoRelacionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assunto_id")
    private Assunto assunto;

    @ManyToOne
    @JoinColumn(name = "relacionado_assunto_id")
    private Assunto relacionadoAssunto;

    public AssuntoRelacionamento() {
        super();
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    public Assunto getRelacionadoAssunto() {
        return relacionadoAssunto;
    }

    public void setRelacionadoAssunto(Assunto relacionadoAssunto) {
        this.relacionadoAssunto = relacionadoAssunto;
    }
}
