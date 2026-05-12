package com.biblioteca.biblioteca_api.controller;

import com.biblioteca.biblioteca_api.model.Usuario;
import com.biblioteca.biblioteca_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuario() {
        return usuarioService.listarUsuario();
    }

    @PutMapping("{/cpf}")
    public Usuario atualizarUsuario(@PathVariable String cpf, @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(cpf, usuario);
    }

    @DeleteMapping("/{cpf}")
    public Usuario removerUsuario(@PathVariable String cpf) {
        return usuarioService.removerUsuario(cpf);
    }
}
