package com.biblioteca.biblioteca_api.repository;

import com.biblioteca.biblioteca_api.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
