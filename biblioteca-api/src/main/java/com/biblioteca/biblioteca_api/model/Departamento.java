package com.biblioteca.biblioteca_api.model;

import jakarta.persistence.*;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @OneToOne
    @JoinColumn(name = "chefe_funcionario_id")
    private Funcionario chefeFuncionario;

    public Departamento() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Funcionario getChefeFuncionario() {
        return chefeFuncionario;
    }

    public void setChefeFuncionario(Funcionario chefeFuncionario) {
        this.chefeFuncionario = chefeFuncionario;
    }
}
