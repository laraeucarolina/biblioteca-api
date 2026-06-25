package com.biblioteca.biblioteca_api.service;

import com.biblioteca.biblioteca_api.model.Emprestimo;
import com.biblioteca.biblioteca_api.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {
    private EmprestimoRepository emprestimoRepository;

    public Emprestimo cadastrarEmprestimo(Emprestimo emprestimo) {
        if (!emprestimo.getExemplar().getSituacao().equals("DISPONIVEL")) {
            throw new RuntimeException("Exemplar indisponível para empréstimo");
        }

        emprestimo.getExemplar().setSituacao("EMPRESTADO");

        return emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo buscarPorId(Long id) {
        return emprestimoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Emprestimo não encontrado"));
    }

    public Emprestimo deletarEmprestimo(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Emprestimo não encontrado"));

        emprestimoRepository.delete(emprestimo);

        return emprestimo;
    }
}
