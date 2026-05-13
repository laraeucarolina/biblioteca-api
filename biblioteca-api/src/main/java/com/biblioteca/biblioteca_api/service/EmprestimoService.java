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
    LivroRepository livroRepository;

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public Emprestimo realizarEmprestimo(String isbn, String cpf) {
        Livro livro = livroRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Usuario usuario = usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (livro.getQuantidade() <= 0) {
            throw new RuntimeException("Livro indisponível");
        }

        Emprestimo emprestimo = new Emprestimo(livro, usuario);

        livro.setQuantidade(livro.getQuantidade() - 1);

        emprestimo.setAtivo(true);

        return emprestimoRepository.save(emprestimo);
    }


    public Emprestimo devolverLivro(String isbn, String cpf) {
        Emprestimo emprestimo = emprestimoRepository.findByLivroIsbnAndUsuarioCpfAndAtivoTrue(isbn, cpf)
                .orElseThrow(() -> new RuntimeException("Emprestimo ativo não encontrado"));

        if (emprestimo.getDataDeDevolucao() != null) {
            throw new RuntimeException("Livro já devolvido");
        }

        Livro livro = emprestimo.getLivro();

        emprestimo.setDataDeDevolucao(LocalDate.now());

        livro.setQuantidade(livro.getQuantidade() + 1);

        emprestimo.setAtivo(false);

        return emprestimoRepository.save(emprestimo);
    }


    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }


    public Emprestimo buscaPorId(Long id) {
        return emprestimoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprestimo não encontrado"));
    }


    public List<Emprestimo> listarEmprestimosAtivos() {
        return emprestimoRepository.findByAtivoTrue();
    }


    public List<Emprestimo> listarPorUsuario(String cpf) {
        return emprestimoRepository.findByUsuario();
    }
}
