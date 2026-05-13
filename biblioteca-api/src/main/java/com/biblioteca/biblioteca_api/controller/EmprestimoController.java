package com.biblioteca.biblioteca_api.controller;

import com.biblioteca.biblioteca_api.model.Emprestimo;
import com.biblioteca.biblioteca_api.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

    @PostMapping
    public Emprestimo realizarEmprestimo(@PathVariable String isbn, @PathVariable String cpf) {
        return emprestimoService.realizarEmprestimo(isbn, cpf);
    }

    @PutMapping("/{isbn}/{cpf}")
    public Emprestimo devolverLivro(@PathVariable String isbn, @PathVariable String cpf) {
        return emprestimoService.devolverLivro(isbn, cpf);
    }

    @GetMapping
    public List<Emprestimo> listarEmprestimos() {
        return emprestimoService.listarEmprestimos();
    }

    @GetMapping("/{id}")
    public Emprestimo listarPorID(@PathVariable Long id) {
        return emprestimoService.buscaPorId(id);
    }

    @GetMapping("/{id}")
    public List<Emprestimo> listarEmprestimoAtivo(@PathVariable Long id) {
        return  emprestimoService.listarEmprestimosAtivos();
    }

    @GetMapping("/{cpf}")
    public List<Emprestimo> listarPorCpf(@PathVariable String cpf) {
        return emprestimoService.listarPorUsuario(cpf);
    }
}
