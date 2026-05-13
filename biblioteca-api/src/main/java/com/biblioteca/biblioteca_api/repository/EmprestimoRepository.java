package com.biblioteca.biblioteca_api.repository;

import com.biblioteca.biblioteca_api.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

    public Optional<Emprestimo> findByLivroIsbnAndUsuarioCpfAndAtivoTrue(String isbn, String cpf);

    public List<Emprestimo> findByAtivoTrue();

    public List<Emprestimo> findByUsuario();
}
