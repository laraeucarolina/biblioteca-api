package com.biblioteca.biblioteca_api.repository;

import com.biblioteca.biblioteca_api.model.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
}
