package com.biblioteca.biblioteca_api.repository;

import com.biblioteca.biblioteca_api.model.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {
}
