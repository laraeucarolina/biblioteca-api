package com.biblioteca.biblioteca_api.repository;

import com.biblioteca.biblioteca_api.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
