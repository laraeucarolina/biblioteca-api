package com.biblioteca.biblioteca_api.service;

import com.biblioteca.biblioteca_api.model.Emprestimo;
import com.biblioteca.biblioteca_api.model.Livro;
import com.biblioteca.biblioteca_api.model.Usuario;
import com.biblioteca.biblioteca_api.repository.EmprestimoRepository;
import com.biblioteca.biblioteca_api.repository.LivroRepository;
import com.biblioteca.biblioteca_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Emprestimo realizarEmprestimo(Long livroId, Usuario usuario) {
        Livro livro = livroRepository.findById(livroId).orElseThrow();

        if (!livro.isDisponivel()) {
            throw new RuntimeException("Livro indisponível");
        }

        livro.setDisponivel(false);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);
        emprestimo.setDataDeEmprestimo(LocalDate.now());

        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo devolverLivro(Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado!"));

        Livro livro = emprestimo.getLivro();

        livro.setDisponivel(true);

        emprestimo.setDataDeDevolucao(LocalDate.now());

        livroRepository.save(livro);

        return emprestimoRepository.save(emprestimo);

    }

    public List<Emprestimo> listarEmprestimo() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo buscarPorId(Long id) {
        return emprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
    }
}
