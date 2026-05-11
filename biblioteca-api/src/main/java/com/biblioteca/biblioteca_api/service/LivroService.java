package com.biblioteca.biblioteca_api.service;

import com.biblioteca.biblioteca_api.model.Livro;
import com.biblioteca.biblioteca_api.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public Livro cadastrarLivro(Livro livro) {
        if (livroRepository.existsByIsbn(livro.getIsbn())) {
            throw new RuntimeException("ISBN já cadastrado");
        }
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivro() {

        return livroRepository.findAll();
    }

    public Livro atualizarLivro(String isbn, Livro novoLivro) {
        Livro livro = livroRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Livro não foi encontrado"));

        livro.setTitulo(novoLivro.getTitulo());
        livro.setAutor(novoLivro.getAutor());
        livro.setIsbn(novoLivro.getIsbn());

        return livroRepository.save(livro);
    }
}
