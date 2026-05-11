package com.biblioteca.biblioteca_api.controller;

import com.biblioteca.biblioteca_api.model.Livro;
import com.biblioteca.biblioteca_api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroService livroService;

    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro) {
        return livroService.cadastrarLivro(livro);
    }

    @GetMapping
    public List<Livro> listarLivro() {
        return livroService.listarLivro();
    }


}
