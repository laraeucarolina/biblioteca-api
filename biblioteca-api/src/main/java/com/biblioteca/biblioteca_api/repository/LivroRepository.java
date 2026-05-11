package com.biblioteca.biblioteca_api.repository;

import com.biblioteca.biblioteca_api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    public boolean existsByIsbn(String isbn);

    Optional<Livro> findByIsbn(String isbn);
}
