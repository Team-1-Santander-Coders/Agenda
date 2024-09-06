package com.team1.mensagem.model;

public class Administrador extends Usuario {

    public Administrador(String nome, String telefone, String email, String senha) {
        super(nome, telefone, email, senha);
    }

    public void verEmailsDeOutroUsuario(Usuario usuario) {
        usuario.verEmails();
    }
}