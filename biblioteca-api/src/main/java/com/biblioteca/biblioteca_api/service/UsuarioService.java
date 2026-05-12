package com.biblioteca.biblioteca_api.service;

import com.biblioteca.biblioteca_api.model.Usuario;
import com.biblioteca.biblioteca_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            throw new RuntimeException("Usuario já foi cadastrado");
        }

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizarUsuario(String cpf, Usuario novoUsuario) {
        Usuario usuario = usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        usuario.setNome(novoUsuario.getNome());
        usuario.setEmail(novoUsuario.getEmail());

        usuarioRepository.delete(novoUsuario);

        return usuario;
    }

    public Usuario removerUsuario(String cpf) {
        Usuario usuario = usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        usuarioRepository.delete(usuario);

        return usuario;
    }
}
