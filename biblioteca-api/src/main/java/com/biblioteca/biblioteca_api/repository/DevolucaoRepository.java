package com.biblioteca.biblioteca_api.repository;

import com.biblioteca.biblioteca_api.model.Devolucao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevolucaoRepository extends JpaRepository<Devolucao, Long> {
}
