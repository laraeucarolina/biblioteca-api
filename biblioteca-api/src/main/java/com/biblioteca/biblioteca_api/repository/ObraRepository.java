package com.biblioteca.biblioteca_api.repository;

import com.biblioteca.biblioteca_api.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Long> {
}
