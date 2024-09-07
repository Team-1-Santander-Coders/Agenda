package com.team1.mensagem.controller;

import com.team1.mensagem.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private static final List<Usuario> usuarios = new ArrayList<>();

    public static void cadastrarUsuario(String nome, String telefone, String email, String senha) {
        Usuario usuario = new Usuario(nome, telefone, email, senha);
        usuarios.add(usuario);
    }

    public static Usuario fazerLogin(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public static Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }
}