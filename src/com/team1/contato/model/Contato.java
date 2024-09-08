package com.team1.contato.model;

import com.team1.contato.controller.ContatoController;

import java.util.ArrayList;
import java.util.List;

public class Contato {
    private final int id;
    private String nome;
    private String telefone;
    private String email;
    private static final List<Contato> listaContatos = new ArrayList<>();

    public Contato(String nome, String telefone, String email) {
        this.id = ContatoController.getId();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        listaContatos.add(this);
    }

    public static Contato getContatoPeloEmail(String email) {
        for (Contato contato:listaContatos) {
            if (email.equals(contato.email)) {
                return contato;
            }
        }
        return null;
    }

    public static List<Contato> getListaContatos() {
        return listaContatos;
    }

    public int getId() { return id; }

    public String getNome() { return nome; }

    public String getTelefone() { return telefone; }

    public String getEmail() { return email; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}