package com.team1.contato.controller;

import com.team1.contato.util.Utils;
import com.team1.contato.model.Contato;
import com.team1.resources.Cores;

public class ContatoController {
    private static int id = 1;

    public static Contato novoContato(String nome, String telefone, String email) {
        telefone = telefone.replaceAll("\\D", "");

        try {
            if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                System.out.println(Cores.RED.colorir("\n Contato não adicionado: Dados não foram informados"));
                return null;
            } else if (!Utils.verificarTelefoneValido(telefone)) {
                System.out.println(Cores.RED.colorir("\n Contato não adicionado: Telefone inválido ou Telefone já adicionado à agenda."));
                return null;
            } else if (!Utils.verificarEmailValido(email)) {
                System.out.println(Cores.RED.colorir("\n Contato não adicionado: Email inválido"));
                return null;
            } else {
                Contato contato = new Contato(nome, telefone, email);
                id++;
                return contato;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static int getId() {
        return id;
    }
}