package com.team1.mensagem.controller;

import com.team1.mensagem.model.Administrador;

import java.util.ArrayList;
import java.util.List;

public class AdministradorController {
    private static List<Administrador> administradores = new ArrayList<>();

    public static void cadastrarAdministrador(String nome, String telefone, String email, String senha) {
        Administrador administrador = new Administrador(nome, telefone, email, senha);
        administradores.add(administrador);
    }

    public static Administrador fazerLogin(String email, String senha) {
        for (Administrador administrador : administradores) {
            if (administrador.getEmail().equals(email) && administrador.getSenha().equals(senha)) {
                return administrador;
            }
        }
        return null;
    }
}