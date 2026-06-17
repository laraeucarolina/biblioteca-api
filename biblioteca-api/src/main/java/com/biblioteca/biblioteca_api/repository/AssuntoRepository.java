package com.biblioteca.biblioteca_api.repository;

import com.biblioteca.biblioteca_api.model.Assunto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssuntoRepository extends JpaRepository<Assunto, Long> {
}
