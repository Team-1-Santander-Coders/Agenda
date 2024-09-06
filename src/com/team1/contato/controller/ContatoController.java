package com.team1.contato.controller;
import com.team1.contato.util.Utils;
import com.team1.contato.model.Contato;


public class ContatoController {
    private static int id = 1;

    public static Contato novoContato(String nome, String telefone, String email) {
        telefone = telefone.replaceAll("\\D", "");

        try {
            if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                throw new Exception("Contato não adicionado: Dados não foram informados");

            } else if (!Utils.verificarTelefoneValido(telefone)) {
                throw new Exception("Contato não adicionado: Telefone invalido");

            } else if (!Utils.verificarEmailValido(email)) {
                throw new Exception("Contato não adicionado: Email invalido");

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
    public static int getId(){
        return id;
    }
}
