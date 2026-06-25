package com.biblioteca.biblioteca_api.controller;

import com.biblioteca.biblioteca_api.model.Emprestimo;
import com.biblioteca.biblioteca_api.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/cadastrar")
    public Emprestimo cadastrarEmprestimo(@RequestBody Emprestimo emprestimo) {
        return emprestimoService.cadastrarEmprestimo(emprestimo);
    }

    @GetMapping("/buscarPorId")
    public Emprestimo buscarPorId(@PathVariable Long id) {
        return emprestimoService.buscarPorId(id);
    }

    @GetMapping("/listarTodos")
    public List<Emprestimo> listarEmprestimos() {
        return emprestimoService.listarEmprestimos();
    }

    @DeleteMapping("/deletar")
    public Emprestimo deletarEmprestimo(@PathVariable Long id) {
        return emprestimoService.deletarEmprestimo(id);
    }
}
