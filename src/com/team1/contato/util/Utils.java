package com.team1.contato.util;

import com.team1.contato.model.Contato;

public class Utils {
    public static boolean verificarTelefoneValido(String telefone) {
        boolean telefoneEstaValido = true;
        if(telefone.length() == 11) {
        for(Contato contato : Contato.getListaContatos()){
            if(contato.getTelefone().equals(telefone)){
                telefoneEstaValido = false;
                break;
            }
        }
        } else telefoneEstaValido  =false;
        return telefoneEstaValido;
    }

    public static boolean verificarEmailValido(String email) {
        return (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));
    }
}